package com.rp.sec04;

import com.rp.courseutil.DefaultSubscriber;
import com.rp.courseutil.Util;
import reactor.core.publisher.Flux;

import java.time.Duration;

public class Lec09SwitchIfEmpty {
    public static void main(String[] args) {
        getOrderNumbers()
                .filter(i -> i > 10)
                .switchIfEmpty(fallback())
                .subscribe(DefaultSubscriber.subscriber());

        Util.sleepSeconds(10);
    }

    private static Flux<Integer> getOrderNumbers(){
        return Flux.range(1,10)
                .delayElements(Duration.ofSeconds(5));
    }

    private static Flux<Integer> fallback(){
        return Flux.range(20,5);
    }
}
