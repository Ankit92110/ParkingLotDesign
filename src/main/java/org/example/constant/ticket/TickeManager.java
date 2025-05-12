package org.example.constant.ticket;

import org.example.ParkingLot.ParkingSpot;
import org.example.vehicle.Vehicle;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

public class TickeManager {
    private static Map<String,Ticket> ticketMap=new HashMap<>();
    private static final AtomicInteger counter = new AtomicInteger(1000);
    private static String getTickeId(){
        String datePrefix = new SimpleDateFormat("yyyyMMddHHmm ss").format(new Date());
        return "TICKET-" + datePrefix + "-" + counter.getAndIncrement();

    }

    public static String generateTicket(Vehicle vehicle,ParkingSpot parkingSpot){
        String ticketId=getTickeId();
        ticketMap.put(ticketId,new Ticket(ticketId,vehicle,parkingSpot));
        return ticketId;
    }
    public static Ticket getTicketfromTicketId(String ticketId){
       return ticketMap.get(ticketId);
    }
    public static void removeTicket(String ticketId){
        ticketMap.remove(ticketId);
    }
}
