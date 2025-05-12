package org.example.ParkingLot;

import org.example.constant.VehicleType;

import java.util.List;

public class ParkingLot {
    private final List<ParkingFloor> parkingFloorList;

    public ParkingLot(List<ParkingFloor> parkingFloorList) {
        this.parkingFloorList = parkingFloorList;
    }

   public ParkingSpot getParkingSpot(VehicleType vehicleType){
        for(var parkingFloor:parkingFloorList){
            var parkingSpot=parkingFloor.getParkingSpot(vehicleType);
            if(parkingSpot!=null) return parkingSpot;
        }
        return null;
    }

}
