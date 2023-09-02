package com.rp.sec04;

import com.rp.courseutil.DefaultSubscriber;
import com.rp.sec04.helper.Person;
import reactor.core.publisher.Flux;

import java.util.function.Function;

public class Lec11SwitchOnFirst {
    public static void main(String[] args) {
        getPerson()
                .switchOnFirst((signal, personFlux) -> {
                    return signal.isOnNext() && signal.get().getAge()>10 ? personFlux:applyFilterMap().apply(personFlux);
                })
                .subscribe(DefaultSubscriber.subscriber());
    }

    public static Flux<Person> getPerson(){
        return Flux.range(1,10)
                .map(i -> new Person());
    }

    public static Function<Flux<Person>,Flux<Person>> applyFilterMap(){
        return personFlux -> personFlux
                .filter(person -> person.getAge() > 10)
                .doOnNext(person -> person.setName(person.getName().toUpperCase()));
    }
}
