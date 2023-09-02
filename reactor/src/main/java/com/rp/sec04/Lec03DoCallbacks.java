package com.rp.sec04;

import com.rp.courseutil.DefaultSubscriber;
import reactor.core.publisher.Flux;

public class   Lec03DoCallbacks {
    public static void main(String[] args) {
        Flux.create(fluxSink -> {
            System.out.println("inside create");
            for (int i = 0; i < 5; i++) {
                fluxSink.next(i);
            }
            fluxSink.complete();
            System.out.println("completed");
        })
                .doOnComplete(() -> System.out.println("doOnComplete"))
                .doFirst(() -> System.out.println("doFirst"))
                .doOnNext(o -> System.out.println("doOnNext : " +o))
                .doOnSubscribe(subscription -> System.out.println("doOnSubscribe: " + subscription))
                .doOnRequest(value -> System.out.println("doOnRequest: " + value))
                .doFinally(signalType -> System.out.println("doFinally: " + signalType))
                .subscribe(DefaultSubscriber.subscriber());

    }
}
