package com.rp;

import org.junit.jupiter.api.Test;
import reactor.core.publisher.Flux;
import reactor.test.StepVerifier;

public class Lec02SVErrorTest {

    @Test
    public void test1(){
        Flux<Integer> integerFlux = Flux.just(1, 2, 3);
        Flux<Integer> oops = Flux.error(new RuntimeException("oops"));

        Flux<Integer> concat = Flux.concat(integerFlux, oops);

        StepVerifier.create(concat)
                .expectNext(1,2,3)
                .verifyError();
    }

    @Test
    public void test2(){
        Flux<Integer> integerFlux = Flux.just(1, 2, 3);
        Flux<Integer> oops = Flux.error(new RuntimeException("oops"));

        Flux<Integer> concat = Flux.concat(integerFlux, oops);

        StepVerifier.create(concat)
                .expectNext(1,2,3)
                .verifyError(RuntimeException.class);
//                .verifyError(IllegalStateException.class);
    }
}
