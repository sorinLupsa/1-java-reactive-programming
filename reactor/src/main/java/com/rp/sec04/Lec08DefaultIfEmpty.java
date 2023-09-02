package com.rp.sec04;

import com.rp.courseutil.DefaultSubscriber;
import com.rp.courseutil.Util;
import reactor.core.publisher.Flux;

import java.time.Duration;

public class Lec08DefaultIfEmpty {

    public static void main(String[] args) {
        getOrderNumbers()
                .filter(i -> i > 10)
                .defaultIfEmpty(-100)
                .subscribe(DefaultSubscriber.subscriber());

        Util.sleepSeconds(10);
    }

    private static Flux<Integer> getOrderNumbers(){
        return Flux.range(1,10)
                .delayElements(Duration.ofSeconds(5));
    }
}
