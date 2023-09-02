package com.rp.sec10;

import com.rp.courseutil.DefaultSubscriber;
import reactor.core.publisher.Flux;

public class Lec01Repeat {

    public static void main(String[] args) {

        getIntegers()
                .repeat(2)
//                .repeat(() -> true) -- boolean expression
                .subscribe(DefaultSubscriber.subscriber());


    }

    private static Flux<Integer> getIntegers(){
        return Flux.range(1,3)
                .doOnSubscribe(subscription -> System.out.println("Subscribed"))
                .doOnComplete(() -> System.out.println("..Completed"));

    }
 }
