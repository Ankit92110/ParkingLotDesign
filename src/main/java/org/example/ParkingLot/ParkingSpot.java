package org.example.ParkingLot;

import org.example.constant.SpotType;
import org.example.constant.VehicleType;
import org.example.vehicle.Vehicle;

public abstract class ParkingSpot {
    private int spotNumber;
    private int floorNumber;
    private SpotType spotType;
    private boolean isAvailabe;
    public ParkingSpot(int spotNumber, int floorNumber, SpotType spotType) {
        this.spotNumber = spotNumber;
        this.floorNumber = floorNumber;
        this.spotType = spotType;
        this.isAvailabe = true;
    }

    boolean canPark(VehicleType vehicleType){
        return  isAvailabe && vehicleType.name().equals(spotType.name());
    }

   public boolean parkVehicle(VehicleType vehicleType){
        if(canPark(vehicleType)) {
            isAvailabe=false;
            return  true;
        }
        System.out.println("either spot is already occupied or you can't "+ vehicleType + "at this spot");
        return false;
    }

   public   boolean unParkVehicle(){
        if(isAvailabe) return false;
        isAvailabe=true;
        return true;
    }

    public int getSpotNumber() {
        return spotNumber;
    }

    public int getFloorNumber() {
        return floorNumber;
    }

    public SpotType getSpotType() {
        return spotType;
    }

    public boolean isAvailabe() {
        return isAvailabe;
    }
}
