package com.preprations.systemdesign.parkinglot;

import java.util.Date;

public class ParkingTicket {
    String ticketNumber;
    Date issuedAt;
    Vehicle vehicle;
    ParkingSpot spot;
    String floorName;
    boolean isPaid = false;

    ParkingTicket(String ticketNumber, Vehicle vehicle, ParkingSpot spot, String floorName) {
        this.ticketNumber = ticketNumber;
        this.vehicle = vehicle;
        this.spot = spot;
        this.floorName = floorName;
        this.issuedAt = new Date();
    }

    public double calculateCharges() {
        long duration = (new Date().getTime() - issuedAt.getTime()) / 1000; // in seconds
        return Math.max(20.0, duration * 0.05);
    }
}