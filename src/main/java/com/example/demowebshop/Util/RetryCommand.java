package com.example.demowebshop.Util;

import java.util.function.Supplier;

public class RetryCommand <T> {
    private int numberOfTriesLeft;
    private int numberOfRetries;
    private long timeToWait;
    public static final int DEFAULT_RETRIES = 3;
    public static final long DEFAULT_WAIT_TIME_IN_MILLI = 2000;

    public RetryCommand() {
        this(DEFAULT_RETRIES, DEFAULT_WAIT_TIME_IN_MILLI);
    }

    private RetryCommand(int numberOfRetries, long timeToWait) {
        this.numberOfRetries = numberOfRetries;
        numberOfTriesLeft = numberOfRetries;
        this.timeToWait = timeToWait;
    }

    public T run(Supplier<T> function) {
        while (shouldRetry()) {
            try {
                return function.get();
            } catch (Exception ex) {
                try {
                    errorOccured();
                } catch (Exception e) {
                    throw new RuntimeException("Exception:" + e);
                }
            }
        }
        throw new RuntimeException("Command failed on all of " + numberOfRetries + " retries");
    }

    private void errorOccured() throws Exception {
        numberOfTriesLeft--;
        if (!shouldRetry()) {
            throw new Exception("Retry Failed: Total " + numberOfRetries
                    + " attempts made at interval " + getTimeToWait()
                    + "ms");
        }
        waitUntilNextTry();
    }

    private boolean shouldRetry() {
        return numberOfTriesLeft > 0;
    }

    private void waitUntilNextTry() {
        try {
            Thread.sleep(getTimeToWait());
        } catch (InterruptedException ignored) {
        }
    }

    private long getTimeToWait() {
        return timeToWait;
    }
}
