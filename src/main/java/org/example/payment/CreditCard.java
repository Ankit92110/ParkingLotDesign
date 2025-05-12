package org.example.payment;

public class CreditCard implements PaymentMode{

    @Override
    public void processPayment(double amount) {
        System.out.println( "CreditCard Payment processed successfully for $"+amount);
    }
}
