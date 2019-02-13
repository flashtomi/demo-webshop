package com.example.demowebshop.Util;

public class LogCallDuration {
    private long logStartTime() {
        return System.nanoTime();
    }

    private long callDuration (long startTime) {
        return System.nanoTime() - startTime;
    }

    public void getCallDuration(Runnable runnable) {
        long startTime = logStartTime();
        runnable.run();
        System.out.println( callDuration(startTime));
    }
}
