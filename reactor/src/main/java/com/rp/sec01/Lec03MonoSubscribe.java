package com.rp.sec01;

import com.rp.courseutil.Util;
import reactor.core.publisher.Mono;

public class Lec03MonoSubscribe {

    public static void main(String[] args) {
        Mono<String> mono = Mono.just("ball")
                .map(s -> String.valueOf(s.length()));

        mono.subscribe(
//                item -> System.out.println(item),
                Util.onNext(),
//                err -> System.out.println(err),
                Util.onError(),
//                () -> System.out.println("completed")
                Util.onComplete()
        );
    }
}
