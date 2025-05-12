package org.example.payment;

public class Payment {
    private final double amount;
    private final PaymentMode paymentMode;

    public Payment(double amount, PaymentMode paymentMode) {
        this.amount = amount;
        this.paymentMode = paymentMode;
    }
    public void processPayment(){
        paymentMode.processPayment(amount);
    }
}
