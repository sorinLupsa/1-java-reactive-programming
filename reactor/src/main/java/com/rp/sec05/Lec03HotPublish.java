package com.rp.sec05;

import com.rp.courseutil.DefaultSubscriber;
import com.rp.courseutil.Util;
import reactor.core.publisher.Flux;

import java.time.Duration;
import java.util.stream.Stream;

public class Lec03HotPublish {
    public static void main(String[] args) {
        // share = publish + refCount(1)
        Flux<String> movieFlux = Flux.fromStream(() -> getMovie())
                .delayElements(Duration.ofSeconds(2))
                        .publish()
                                .refCount(2);

        movieFlux.subscribe(DefaultSubscriber.subscriber("sam"));

        Util.sleepSeconds(5);

        movieFlux.subscribe(DefaultSubscriber.subscriber("mike"));

        Util.sleepSeconds(60);
    }

    // netflix
    private static Stream<String> getMovie(){
        System.out.println("Got the movie streaming request");
        return Stream.of(
                "Scene 1",
                "Scene 2",
                "Scene 3",
                "Scene 4",
                "Scene 5",
                "Scene 6",
                "Scene 7"
        );
    }
}
