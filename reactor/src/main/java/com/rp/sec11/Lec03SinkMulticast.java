package com.rp.sec11;

import com.rp.courseutil.DefaultSubscriber;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Sinks;

public class Lec03SinkMulticast {

    public static void main(String[] args) {

        Sinks.Many<Object> sink = Sinks.many().multicast().onBackpressureBuffer();

        Flux<Object> flux = sink.asFlux();

        flux.subscribe(DefaultSubscriber.subscriber("sam"));
        flux.subscribe(DefaultSubscriber.subscriber("mike"));

        sink.tryEmitNext("hi");
        sink.tryEmitNext("how are you");
        sink.tryEmitNext("?");
    }
}
