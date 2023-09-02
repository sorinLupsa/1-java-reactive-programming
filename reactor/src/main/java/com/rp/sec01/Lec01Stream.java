package com.rp.sec01;

import java.util.stream.Stream;

public class Lec01Stream {
    public static void main(String[] args) {
        Stream<Integer> integerStream = Stream.of(1).map(i -> {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            return i*2;
        });

//        System.out.println(integerStream);
        // in order to print should be connected to a terminal
        integerStream.forEach(System.out::println);
    }
}
