package org.example.ParkingLot;

import org.example.constant.VehicleType;

import java.util.ArrayList;
import java.util.List;

public class ParkingFloor {
   private final List<ParkingSpot> parkingSpotList;

    public ParkingFloor(int floorNumber ,int carPakingCapacity,int bikeParkingCapacity) {
        parkingSpotList=new ArrayList<>();
        for(int i=0;i<carPakingCapacity;i++){
            parkingSpotList.add(new CarParking(i+1,floorNumber));
        }
        for(int i=0;i<bikeParkingCapacity;i++){
            parkingSpotList.add(new BikeParking(i+1+carPakingCapacity,floorNumber));
        }
    }
    public ParkingSpot getParkingSpot(VehicleType vehicleType){
        for(var parkingSpot:parkingSpotList){
            if(parkingSpot.canPark(vehicleType)) return parkingSpot;
        }
        return null;
    }
}
