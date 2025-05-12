package org.example.gate;

import org.example.ParkingLot.ParkingLot;
import org.example.ParkingLot.ParkingSpot;
import org.example.constant.VehicleType;
import org.example.constant.ticket.TickeManager;
import org.example.constant.ticket.Ticket;
import org.example.service.PaymentService;

import javax.swing.*;
import java.time.LocalDateTime;
import java.util.Scanner;

import static org.example.constant.ParkingConstant.*;

public class ExitGate {
    private final Scanner scanner;
    private final ParkingLot parkingLot;
    private final PaymentService paymentService;

    public ExitGate(Scanner scanner, ParkingLot parkingLot, PaymentService paymentService) {
        this.scanner = scanner;
        this.parkingLot = parkingLot;
        this.paymentService = paymentService;
    }

    public  void  processExit(){
        System.out.println("enter the TicketId");
        String ticketId=scanner.nextLine();
        Ticket ticket= TickeManager.getTicketfromTicketId(ticketId);
        if(ticket==null) System.out.println("invalid ticket");
        else{
            ParkingSpot parkingSpot=ticket.getParkingSpot();
           if( parkingSpot.unParkVehicle()){
               processPayment(ticket);
               TickeManager.removeTicket(ticket.getTicketId());
               return;
           }
            System.out.println("this spot is already empty");
        }
    }

    private void processPayment(Ticket ticket) {
        double parkedTime=( LocalDateTime.now().getSecond()-  ticket.getStartDateTime().getSecond());
        double parSecondPrice=getParSecondPrice(ticket.getVehicle().getVehicleType());
        double amount=parkedTime*parSecondPrice;
        paymentService.processPayment(amount);

    }

    private double getParSecondPrice(VehicleType vehicleType) {
        switch (vehicleType){
            case BIKE -> {
                return BIKE_PER_SECOND_PARKING_FEE;
            }
            case CAR-> {
                return CAR_PER_SECOND_PARKING_FEE;
            }
            default -> {
                return 2;
            }
        }
    }
}
