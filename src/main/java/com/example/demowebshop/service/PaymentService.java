package com.example.demowebshop.service;

import com.example.demowebshop.model.PaymentServiceResponse;
import org.springframework.stereotype.Component;

@Component
public class PaymentService implements IPaymentService {

    @Override
    public PaymentServiceResponse pay(double totalPrice) {
        connectToServer("PaymentService");
        return new PaymentServiceResponse(true);
    }

    private int random(int min, int max) {
        return min + (int) (Math.random() * ((max - min) + 1));
    }

    private void experienceNetworkLatency() {
        int randomLatency = random(5, 10);
        for (int i = 0; i < randomLatency; i++) {
            try {
                Thread.sleep(100);
            } catch (InterruptedException ex) {
                ex.printStackTrace();
            }
        }
    }

    private void connectToServer(String server) {
        System.out.print("Connecting to " + server + "... ");
        experienceNetworkLatency();
        System.out.print("Connected!" + "\n");
    }
}
