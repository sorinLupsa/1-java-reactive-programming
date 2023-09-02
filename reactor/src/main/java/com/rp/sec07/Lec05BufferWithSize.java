package com.rp.sec07;

import com.rp.courseutil.DefaultSubscriber;
import com.rp.courseutil.Util;
import reactor.core.publisher.Flux;
import reactor.core.scheduler.Schedulers;

public class Lec05BufferWithSize {

    public static void main(String[] args) {

        System.setProperty("reactor.bufferSize.small", "16");


        Flux.create(fluxSink -> {
                    for (int i = 1; i < 201 && !fluxSink.isCancelled(); i++) {
                        fluxSink.next(i);
                        System.out.println("Pushed : " + i);
                        Util.sleepMillis(1);
                    }
                    fluxSink.complete();
                })
                .onBackpressureBuffer(20)
                .publishOn(Schedulers.boundedElastic())
                .doOnNext(i -> {
                    Util.sleepMillis(10);
                })
                .subscribe(DefaultSubscriber.subscriber());

        Util.sleepSeconds(60);
    }
}
