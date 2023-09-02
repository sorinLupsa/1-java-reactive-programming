package com.rp.sec01;

import com.rp.courseutil.Util;
import reactor.core.publisher.Mono;

import java.util.concurrent.Callable;
import java.util.function.Supplier;

public class Lec05MonoFromSupplier {
    public static void main(String[] args) {

        // use just only when you have data already
//        Mono<String> mono = Mono.just(getName());
        Supplier<String> supplier = () -> getName();
        Mono<String> mono = Mono.fromSupplier(supplier);
        mono.subscribe(
                Util.onNext(),
                Util.onError(),
                Util.onComplete()
        );

        Callable<String> callable = () -> getName();
        Mono<String> monoCallable = Mono.fromCallable(callable);
        mono.subscribe(
                Util.onNext(),
                Util.onError(),
                Util.onComplete()
        );
    }

    private static String getName(){
        System.out.println("Generating name...");
        return Util.faker().name().fullName();
    }
}
