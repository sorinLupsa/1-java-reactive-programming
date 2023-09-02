package com.rp.sec08;

import com.rp.courseutil.DefaultSubscriber;
import reactor.core.publisher.Flux;

public class Lec02ConcatWith {

    public static void main(String[] args) {

        Flux<String> flux1 = Flux.just("a", "b");
        Flux<String> flux2 = Flux.just("c", "d","e","f","g");

        Flux<String> flux = flux1.concatWith(flux2);

        flux.subscribe(DefaultSubscriber.subscriber());

    }
}
