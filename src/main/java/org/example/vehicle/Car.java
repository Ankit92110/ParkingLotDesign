package org.example.vehicle;

import org.example.constant.VehicleType;

public class Car extends Vehicle{

    public Car(String vehicleNumber) {
        super(vehicleNumber, VehicleType.CAR);
    }
}
