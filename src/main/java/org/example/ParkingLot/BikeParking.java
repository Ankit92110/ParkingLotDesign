package org.example.ParkingLot;

import org.example.constant.SpotType;

public class BikeParking extends ParkingSpot{

    public BikeParking(int spotNumber, int floorNumber) {
        super(spotNumber, floorNumber, SpotType.BIKE);
    }
}
