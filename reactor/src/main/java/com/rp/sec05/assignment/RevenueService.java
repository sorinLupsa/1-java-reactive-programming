package com.rp.sec05.assignment;

import reactor.core.publisher.Flux;

import java.time.Duration;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Consumer;

public class RevenueService {

    private Map<String,Double> db = new HashMap<>();

    public RevenueService(){
        db.put("kids",0.0);
        db.put("Automotive",0.0);

    }

    public Consumer<PurchaseOrder> subscribeOrderStream(){
        return (purchaseOrder -> db.computeIfPresent(purchaseOrder.getCategory(), (category, value) ->
               value = value + purchaseOrder.getPrice()
        ));
    }

    public Flux<String> revenueStream(){
        return Flux.interval(Duration.ofSeconds(2))
                .map(i -> db.toString());
    }
}
