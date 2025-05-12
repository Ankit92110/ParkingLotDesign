package org.example;


import org.example.ParkingLot.ParkingLot;
import org.example.config.Configuration;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        Configuration configuration=Configuration.getInstance();
           boolean exit=false;
           while(!exit){
               showOptions();
               String choice=scanner.nextLine();
               switch (choice) {
                   case "1" -> processEntry(configuration);
                   case "2" -> processExit(configuration);
                   case "3" -> exit = true;
                   default -> System.out.println("please select the correct options!");
               }
           }

        }

    private static void processExit(Configuration configuration) {
        configuration.getExitGate().processExit();
    }

    private static void processEntry(Configuration configuration) {
        configuration.getEntryGate().processEntry();
    }

    private static void showOptions() {
        System.out.println("========================================================================");
        System.out.println("                    Welcome to The Parking Lot");
        System.out.println("=========================================================================");
        System.out.println("please select the correct option:");
        System.out.println("press 1: for Entry");
        System.out.println("press 2: exit the vehicle");
        System.out.println("press 3: for exit the system");
    }
}