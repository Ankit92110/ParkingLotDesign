package org.example.payment;

public class UPI implements PaymentMode{
    @Override
    public void processPayment(double amount) {
        System.out.println( "UPI Payment processed successfully for $"+amount);
    }
}
