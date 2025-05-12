package org.example.config;

import org.example.ParkingLot.ParkingFloor;
import org.example.ParkingLot.ParkingLot;
import org.example.gate.EntryGate;
import org.example.gate.ExitGate;
import org.example.service.PaymentService;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Configuration {
    private static Configuration instance;
    private Configuration(){}

    public static Configuration getInstance(){
        if(instance==null) instance=new Configuration();
        return instance;
    }
    // Initial Scanner
    Scanner scanner=new Scanner(System.in);
    // Initialize the floors and parkingLot
    ParkingFloor floor1=new ParkingFloor(1,20,80);
    ParkingFloor floor2=new ParkingFloor(2,40,30);
    ParkingFloor floor3=new ParkingFloor(3,60,0);
    List<ParkingFloor> floors= Arrays.asList(floor1,floor2,floor3);
    ParkingLot parkingLot= new ParkingLot(floors);
    EntryGate entryGate=new EntryGate(scanner,parkingLot);
    PaymentService paymentService=new PaymentService(scanner);
    ExitGate exitGate=new ExitGate(scanner,parkingLot,paymentService);


    public  ParkingLot getParkingLot() {
        return parkingLot;
    }
    public  EntryGate getEntryGate(){
        return entryGate;
    }
    public  ExitGate getExitGate(){
        return exitGate;
    }
}


