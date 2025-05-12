package org.example.vehicle;

import org.example.constant.VehicleType;

public class VehicleFactory {
    public static Vehicle createVehicle(String vehicleNumber, VehicleType vehicleType){
        switch (vehicleType) {
            case CAR -> {
                return new Car(vehicleNumber);
            }
            case BIKE -> {
                return new Bike(vehicleNumber);
            }
            default -> {
                System.out.println("There is not parking allowed for " + vehicleType);
                return null;
            }
        }
    }
}
