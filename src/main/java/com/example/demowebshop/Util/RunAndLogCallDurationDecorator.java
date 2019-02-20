package com.example.demowebshop.Util;

import org.springframework.stereotype.Component;

@Component
public class RunAndLogCallDurationDecorator {

    public void run(Runnable runnable) {
        long startTime = System.nanoTime();
        runnable.run();
        System.out.println("Call duration:" + (System.nanoTime() - startTime));
    }
}
