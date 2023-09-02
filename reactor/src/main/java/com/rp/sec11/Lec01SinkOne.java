package com.rp.sec11;

import com.rp.courseutil.DefaultSubscriber;
import reactor.core.publisher.Mono;
import reactor.core.publisher.Sinks;

public class Lec01SinkOne {

    public static void main(String[] args) {

        // mono 1 value/empty/error
        Sinks.One<Object> sink = Sinks.one();
        Mono<Object> sinkMono = sink.asMono();

        sinkMono.subscribe(DefaultSubscriber.subscriber("sam"));
        sinkMono.subscribe(DefaultSubscriber.subscriber("mike"));

        sink.tryEmitValue("hi");
    }
}
