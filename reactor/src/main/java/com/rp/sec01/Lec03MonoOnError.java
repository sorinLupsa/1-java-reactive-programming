package com.rp.sec01;

import reactor.core.publisher.Mono;

public class Lec03MonoOnError {
    public static void main(String[] args) {

        // publisher
        Mono<Integer> mono = Mono.just("sorin")
                .map(s -> s.length())
                .map(integer -> integer/0);


        // subscriber
        mono.subscribe(integer -> System.out.println(integer),throwable -> System.out.println(throwable),() -> System.out.println("Completed"));
    }
}
