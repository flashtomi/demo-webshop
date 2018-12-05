package com.example.demowebshop.model;

public class PaymentServiceResponse {

    private Boolean isSuccess = true;

    public PaymentServiceResponse(Boolean isSuccess) {
        this.isSuccess = isSuccess;
    }

    public Boolean getSuccess() {
        return isSuccess;
    }

    @Override
    public String toString() {
        return "PaymentServiceResponse{" +
                "isSuccess=" + isSuccess +
                '}';
    }
}
