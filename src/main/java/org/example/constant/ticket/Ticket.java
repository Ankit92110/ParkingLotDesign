package org.example.constant.ticket;

import org.example.ParkingLot.ParkingSpot;
import org.example.vehicle.Vehicle;

import java.time.LocalDateTime;

public class Ticket {
    private final String TicketId;
    private final Vehicle vehicle;
    private final ParkingSpot parkingSpot;
    private final LocalDateTime startDateTime;

    public Ticket(String ticketId, Vehicle vehicle,ParkingSpot parkingSpot) {
        TicketId = ticketId;
        this.vehicle = vehicle;
        startDateTime = LocalDateTime.now();
        this.parkingSpot=parkingSpot;
    }

    public ParkingSpot getParkingSpot() {
        return parkingSpot;
    }

    public String getTicketId() {
        return TicketId;
    }

    public Vehicle getVehicle() {
        return vehicle;
    }

    public LocalDateTime getStartDateTime() {
        return startDateTime;
    }
}
