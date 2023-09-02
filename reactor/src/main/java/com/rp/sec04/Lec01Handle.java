package com.rp.sec04;

import com.rp.courseutil.DefaultSubscriber;
import reactor.core.publisher.Flux;

public class Lec01Handle {

    public static void main(String[] args) {

        // handle = filter + map
        Flux.range(1,20)
                .handle((integer, synchronousSink) -> {
                    if (integer %2 == 0){
                        synchronousSink.next(integer); //filter
                    }else{
                        synchronousSink.next(integer + "a"); // map
                    }

                })
                .subscribe(DefaultSubscriber.subscriber());
    }

}
