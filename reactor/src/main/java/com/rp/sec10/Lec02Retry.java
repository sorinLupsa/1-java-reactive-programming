package com.rp.sec10;

import com.rp.courseutil.DefaultSubscriber;
import reactor.core.publisher.Flux;

public class Lec02Retry {

    public static void main(String[] args) {

        getIntegers()
                .retry(2)
                .subscribe(DefaultSubscriber.subscriber());


    }

    private static Flux<Integer> getIntegers(){
        return Flux.range(1,3)
                .doOnSubscribe(subscription -> System.out.println("Subscribed"))
                .doOnComplete(() -> System.out.println("..Completed"))
                .map(i -> i / 0)
                .doOnError(throwable -> System.out.println("--error"));

    }
}

