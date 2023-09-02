package com.rp.sec03;

import com.rp.courseutil.DefaultSubscriber;
import com.rp.courseutil.Util;
import reactor.core.publisher.Flux;

public class Lec04FluxCreateIssueFix {
    public static void main(String[] args) {
        // only one instance of fluxsink
        Flux.create(fluxSink -> {
                    String country;
                    do {
                        country = Util.faker().country().name();
                        System.out.println("Emitting country : " + country);
                        fluxSink.next(country);
                    }while (!country.toLowerCase().startsWith("canada") && !fluxSink.isCancelled());
                    fluxSink.complete();

                })
                .take(3)
                .subscribe(DefaultSubscriber.subscriber());
    }
}
