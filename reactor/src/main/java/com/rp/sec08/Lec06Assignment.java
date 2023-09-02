package com.rp.sec08;

import com.rp.courseutil.DefaultSubscriber;
import com.rp.courseutil.Util;
import reactor.core.publisher.Flux;

import java.time.Duration;

public class Lec06Assignment {

    public static void main(String[] args) {


        final int carPrice = 10000;
        Flux.combineLatest(monthStream(),demandStream(),(month, demand) -> {
            return (carPrice - (month * 100 )) * demand;
        })
                .subscribe(DefaultSubscriber.subscriber());

        Util.sleepSeconds(10);

    }

    private static Flux<Long> monthStream(){
        return Flux.interval(Duration.ZERO, Duration.ofSeconds(1));
    }

    private static Flux<Double> demandStream(){
        return Flux.interval(Duration.ofSeconds(3))
                .map(aLong -> Util.faker().random().nextInt(80,120)/100d)
                .startWith(1d);
    }
}
