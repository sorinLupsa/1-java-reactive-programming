package com.rp.sec03;

import com.rp.courseutil.DefaultSubscriber;
import com.rp.courseutil.Util;
import reactor.core.publisher.Flux;

public class Lec01FluxCreate {

    public static void main(String[] args) {
        Flux.create(fluxSink -> {
            String country;
            do {
                country = Util.faker().country().name();
                fluxSink.next(country);
            }while (!country.toLowerCase().startsWith("canada"));
            fluxSink.complete();

        })
        .subscribe(DefaultSubscriber.subscriber());

    }
}
