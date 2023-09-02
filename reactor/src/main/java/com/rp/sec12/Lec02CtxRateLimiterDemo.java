package com.rp.sec12;

import com.rp.courseutil.DefaultSubscriber;
import com.rp.sec12.helper.BookService;
import com.rp.sec12.helper.UserService;
import reactor.util.context.Context;

public class Lec02CtxRateLimiterDemo {

    public static void main(String[] args) {
        BookService.getBook()
                .repeat(2)
                .contextWrite(UserService.userCategoryContext())
                .contextWrite(Context.of("user","sam"))
                .subscribe(DefaultSubscriber.subscriber());
    }
}
