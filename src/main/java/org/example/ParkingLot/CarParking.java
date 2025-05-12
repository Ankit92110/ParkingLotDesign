package org.example.ParkingLot;

import org.example.constant.SpotType;

public class CarParking extends ParkingSpot{

    public CarParking(int spotNumber, int floorNumber) {
        super(spotNumber, floorNumber, SpotType.CAR);
    }
}
