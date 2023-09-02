package com.rp.sec09;

import com.rp.courseutil.DefaultSubscriber;
import com.rp.courseutil.Util;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.time.Duration;
import java.util.concurrent.atomic.AtomicInteger;

public class Lec04Window {
    private static AtomicInteger atomicInteger = new AtomicInteger(1);
    public static void main(String[] args) {
        eventStream()
                .window(5)
                .flatMap(flux -> saveEvents(flux))
                .subscribe(DefaultSubscriber.subscriber());

        Util.sleepSeconds(10);
    }

    private static Flux<String> eventStream(){
        return Flux.interval(Duration.ofMillis(500))
//                .take(3)
                .map(i -> "events" + i);
    }

    private static Mono<Integer> saveEvents(Flux<String> flux){
        return flux
                .doOnNext(s -> System.out.println("saving " + s))
                .doOnComplete(() -> {
                    System.out.println("saved this batch");
                    System.out.println("-----------------------");
                })
                .then(Mono.just(atomicInteger.getAndIncrement()));
    }
}

