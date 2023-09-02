package com.rp.sec09.assignment;

import reactor.core.publisher.Flux;

import java.util.function.Function;

public class OrderProcessor {

    public static Function<Flux<PurchaseOrder>, Flux<PurchaseOrder>> automotiveProcessing(){
        return flux -> flux
                .doOnNext(purchaseOrder -> purchaseOrder.setPrice(1.1 * purchaseOrder.getPrice()))
                .doOnNext(purchaseOrder -> purchaseOrder.setItem("{{ " + purchaseOrder.getItem() + " }}"));
    }

    public static Function<Flux<PurchaseOrder>, Flux<PurchaseOrder>> kidsProcessing(){
        return flux -> flux
                .doOnNext(purchaseOrder -> purchaseOrder.setPrice(0.5 * purchaseOrder.getPrice()))
                .flatMap(purchaseOrder -> Flux.just(purchaseOrder,getFreeKidsOrder()));

    }

    private static PurchaseOrder getFreeKidsOrder(){
        PurchaseOrder purchaseOrder = new PurchaseOrder();
        purchaseOrder.setItem("FREE - " + purchaseOrder.getItem());
        purchaseOrder.setPrice(0);
        purchaseOrder.setCategory("Kids");
        return purchaseOrder;

    }
}
