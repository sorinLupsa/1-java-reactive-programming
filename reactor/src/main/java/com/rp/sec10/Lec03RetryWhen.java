package com.rp.sec10;

import com.rp.courseutil.DefaultSubscriber;
import com.rp.courseutil.Util;
import reactor.core.publisher.Flux;
import reactor.util.retry.Retry;

import java.time.Duration;

public class Lec03RetryWhen {

    public static void main(String[] args) {

        getIntegers()
                .retryWhen(Retry.fixedDelay(2, Duration.ofSeconds(2)))
                .subscribe(DefaultSubscriber.subscriber());
        Util.sleepSeconds(60);

    }

    private static Flux<Integer> getIntegers(){
        return Flux.range(1,3)
                .doOnSubscribe(subscription -> System.out.println("Subscribed"))
                .doOnComplete(() -> System.out.println("..Completed"))
                .map(i -> i / 0)
                .doOnError(throwable -> System.out.println("--error"));

    }
}
