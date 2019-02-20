package com.example.demowebshop.service;

import com.example.demowebshop.model.PaymentServiceResponse;
import org.springframework.stereotype.Component;

@Component
public class PaymentCacheProxy implements IPaymentService {

    private IPaymentService paymentService;
    private PaymentServiceResponse cachePaymentCall = new PaymentServiceResponse(false);

    public PaymentCacheProxy() {
        this.paymentService = new PaymentService();
    }

    @Override
    public PaymentServiceResponse pay(double totalPrice) {
        if(!cachePaymentCall.getSuccess()) {
            cachePaymentCall = paymentService.pay(totalPrice);
        } else {
            System.out.println("Retrieved Payment Response from cache");
        }
        return cachePaymentCall;
    }

}
