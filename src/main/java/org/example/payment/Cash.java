package org.example.payment;

public class Cash implements PaymentMode{
    @Override
    public void processPayment(double amount) {
        System.out.println( "Cash Payment processed successfully for $"+amount);
    }
}
