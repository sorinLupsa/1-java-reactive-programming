package com.rp.sec08;

import com.rp.courseutil.DefaultSubscriber;
import com.rp.sec08.helper.NameGenerator;

public class Lec01StartWith {

    public static void main(String[] args) {
        NameGenerator generator = new NameGenerator();
        generator.generateNames()
                .take(2)
                .subscribe(DefaultSubscriber.subscriber("sam"));

        generator.generateNames()
                .take(2)
                .subscribe(DefaultSubscriber.subscriber("mike"));

    }

}
