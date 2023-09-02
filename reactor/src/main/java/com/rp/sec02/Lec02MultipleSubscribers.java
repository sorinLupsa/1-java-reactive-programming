package com.rp.sec02;

import reactor.core.publisher.Flux;

public class Lec02MultipleSubscribers {
    public static void main(String[] args) {
        Flux<Integer> integerFlux = Flux.just(1, 2, 3, 4);
        Flux<Integer> integerFlux1 = integerFlux.filter(i -> i % 2 ==0); // even flux

        integerFlux1.subscribe(i -> System.out.println("Subscriber 1, item = " + i));

        integerFlux1.subscribe(i -> System.out.println("Subscriber 2, item = " + i));
    }
}
