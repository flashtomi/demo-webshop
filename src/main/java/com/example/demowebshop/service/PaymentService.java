package com.example.demowebshop.service;

import com.example.demowebshop.model.PaymentServiceResponse;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Component;

@Component
public class PaymentService implements IPaymentService {

    @Override
    @Cacheable("payment")
    public PaymentServiceResponse callService(int amount) {
        simulateSlowService();
        return new PaymentServiceResponse(true);
    }

    private void simulateSlowService() {
        try {
            long time = 3000L;
            Thread.sleep(time);
        } catch (InterruptedException e) {
            throw new IllegalStateException(e);
        }
    }
}
