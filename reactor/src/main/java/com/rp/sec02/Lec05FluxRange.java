package com.rp.sec02;

import com.rp.courseutil.Util;
import reactor.core.publisher.Flux;

public class Lec05FluxRange {
    public static void main(String[] args) {
        Flux<Integer> range = Flux.range(1, 10);
        range.map(i -> Util.faker().name().fullName()).subscribe(Util.onNext());
    }
}
