package com.rp.sec04;

import com.rp.courseutil.DefaultSubscriber;
import com.rp.courseutil.Util;
import reactor.core.publisher.Flux;

public class Lec02HandleAssignment {

    public static void main(String[] args) {
        Flux.generate(synchronousSink -> synchronousSink.next(Util.faker().country().name()))
                .map(o -> o.toString())
                .handle((country, synchronousSink) -> {
                    synchronousSink.next(country);
                    if (country.toLowerCase().equals("canada")){
                        synchronousSink.complete();
                    }
                }).subscribe(DefaultSubscriber.subscriber());
    }
}
