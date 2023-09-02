package com.rp.sec05;

import com.rp.courseutil.DefaultSubscriber;
import com.rp.courseutil.Util;
import com.rp.sec05.assignment.InventoryService;
import com.rp.sec05.assignment.OrderService;
import com.rp.sec05.assignment.RevenueService;

public class Lec06Assignment {

    public static void main(String[] args) {
        OrderService orderService = new OrderService();
        RevenueService revenueService = new RevenueService();
        InventoryService inventoryService = new InventoryService();

        orderService.orderStream()
                .subscribe(revenueService.subscribeOrderStream());
        orderService.orderStream()
                .subscribe(inventoryService.subscribeOrderStream());

        inventoryService.inventoryStream()
                .subscribe(DefaultSubscriber.subscriber("inventory"));

        revenueService.revenueStream()
                .subscribe(DefaultSubscriber.subscriber("revenue"));

        Util.sleepSeconds(60);
    }
}
