package com.rp.sec04;

import com.rp.courseutil.DefaultSubscriber;
import com.rp.sec04.helper.OrderService;
import com.rp.sec04.helper.UserService;

public class Lec12FlatMap {
    public static void main(String[] args) {
        UserService.getUsers()
//                .map(user -> OrderService.getOrders(user.getUserId())) -- return type is mono/flux ?? in this case use flatMap
                .flatMap(user -> OrderService.getOrders(user.getUserId()))
                .subscribe(DefaultSubscriber.subscriber());
    }
}
