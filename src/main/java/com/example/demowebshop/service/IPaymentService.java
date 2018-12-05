package com.example.demowebshop.service;

import com.example.demowebshop.model.PaymentServiceResponse;

public interface IPaymentService {

    PaymentServiceResponse callService(int amount);
}
