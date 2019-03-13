package com.example.demowebshop.Util;

import org.springframework.stereotype.Component;

@Component
public class LogCallDurationDecorator {

    public void run(Runnable runnable) {
        long startTime = System.nanoTime();
        try {
            runnable.run();
        } catch (Exception e) {
            System.out.println("Some Exception happened:" + e);
        } finally {
            System.out.println("Call duration:" + (System.nanoTime() - startTime));
        }
    }
}
