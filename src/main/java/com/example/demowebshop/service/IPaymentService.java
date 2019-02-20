package com.example.demowebshop.service;

import com.example.demowebshop.model.PaymentServiceResponse;

public interface IPaymentService {

    PaymentServiceResponse pay(double totalPrice);
}
