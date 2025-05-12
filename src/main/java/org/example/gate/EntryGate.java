package org.example.gate;

import org.example.ParkingLot.ParkingLot;
import org.example.ParkingLot.ParkingSpot;
import org.example.constant.VehicleType;
import org.example.constant.ticket.TickeManager;
import org.example.vehicle.Vehicle;
import org.example.vehicle.VehicleFactory;

import java.util.Scanner;

public class EntryGate {
    private final Scanner scanner;
    private final ParkingLot parkingLot;

    public EntryGate(Scanner scanner, ParkingLot parkingLot) {
        this.scanner = scanner;
        this.parkingLot = parkingLot;
    }
    public void processEntry(){
        Vehicle vehicle=gateVehicleDetails();
        if(vehicle==null) return ;
       ParkingSpot parkingSpot= parkingLot.getParkingSpot(vehicle.getVehicleType());
       if (parkingSpot==null){
           System.out.println("there is no space available for +" +vehicle.getVehicleType());
           return ;
       }
       parkingSpot.parkVehicle(vehicle.getVehicleType());
        System.out.println("Ticket Id:"+ TickeManager.generateTicket(vehicle,parkingSpot));
    }

    private Vehicle gateVehicleDetails() {
        VehicleType vehicleType=getVehicleType();
        if(vehicleType!=null){
            System.out.println("enter the vehicle Plate Number:");
            String vehiclePalate=scanner.nextLine();
            return VehicleFactory.createVehicle(vehiclePalate,vehicleType);
        }
        return null;
    }

    private VehicleType getVehicleType() {

        System.out.println("Enter vehicle type (CAR, BIKE):");
        String input = scanner.nextLine().toUpperCase();
        try {
           VehicleType vehicleType = VehicleType.valueOf(input);
           return vehicleType;
        } catch (IllegalArgumentException e) {
            System.out.println(input +" parking is not allowed in this parking Lot");
        }
        return null;
    }


}
