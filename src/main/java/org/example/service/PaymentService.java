package org.example.service;

import org.example.payment.*;

import java.util.Scanner;

import static org.example.constant.ParkingConstant.*;

public class PaymentService {
    private Payment payment;
    private final Scanner scanner;

    public PaymentService(Scanner scanner) {
        this.scanner = scanner;
    }

    public void processPayment(double amount){
        showPaymentMode();
        String choice =scanner.nextLine();
        PaymentMode paymentMode;
        switch (choice) {
            case ONE -> paymentMode = new Cash();
            case TWO -> paymentMode = new UPI();
            case THREE -> paymentMode = new CreditCard();
            default -> {
                System.out.println("your choice:" + choice + "  is invalid.");
                showPaymentMode();
                return;
            }
        }
        new Payment(amount,paymentMode).processPayment();
    }

    private void showPaymentMode() {
        System.out.println("Please select the payment Mode:");
        System.out.println("1. for cash.");
        System.out.println("2. for UPI.");
        System.out.println("3. for CreditCard");
    }
}
