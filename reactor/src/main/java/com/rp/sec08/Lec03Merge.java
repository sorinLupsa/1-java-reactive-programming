package com.rp.sec08;

import com.rp.courseutil.DefaultSubscriber;
import com.rp.courseutil.Util;
import com.rp.sec08.helper.AmericanAirLines;
import com.rp.sec08.helper.Emirates;
import com.rp.sec08.helper.Qatar;
import reactor.core.publisher.Flux;

public class Lec03Merge {

    public static void main(String[] args) {

        Flux<String> merge = Flux.merge(
                Qatar.getFlights(),
                Emirates.getFlights(),
                AmericanAirLines.getFlights()
        );

        merge.subscribe(DefaultSubscriber.subscriber());
        Util.sleepSeconds(10);
    }
}
