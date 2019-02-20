package com.example.demowebshop.Util;

import java.util.function.Supplier;

public class RetryCommand <T> {
    private int retryCounter;
    private int maxRetries;

    public RetryCommand(int maxRetries) {
        this.maxRetries = maxRetries;
    }

    public T run(Supplier<T> function) {
        try {
            return function.get();
        } catch (Exception e) {
            return retry(function);
        }
    }

    public int getRetryCounter() {
        return retryCounter;
    }

    private T retry(Supplier<T> function) {
        System.out.println("FAILED - Command failed, will be retried " + maxRetries + " times.");
        retryCounter = 0;
        while (retryCounter < maxRetries) {
            try {
                return function.get();
            } catch (Exception ex) {
                retryCounter++;
                System.out.println("FAILED - Command failed on retry " + retryCounter + " of " + maxRetries + " error: " + ex);
                if (retryCounter >= maxRetries) {
                    System.out.println("Max retries exceeded.");
                    break;
                }
            }
        }
        throw new RuntimeException("Command failed on all of " + maxRetries + " retries");
    }
}
