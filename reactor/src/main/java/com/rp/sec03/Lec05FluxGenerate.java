package com.rp.sec03;

import com.rp.courseutil.DefaultSubscriber;
import com.rp.courseutil.Util;
import reactor.core.publisher.Flux;

public class Lec05FluxGenerate {

    public static void main(String[] args) {
        // using synchronousSink you can emit only one item - for second error
        Flux.generate(synchronousSink -> {
            synchronousSink.next(Util.faker().name().fullName());
//            synchronousSink.next(Util.faker().name().fullName());
            synchronousSink.complete();
        })
                .take(2)
                .subscribe(DefaultSubscriber.subscriber());
    }
}
