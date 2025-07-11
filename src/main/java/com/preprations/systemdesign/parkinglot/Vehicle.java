package com.preprations.systemdesign.parkinglot;

public abstract class Vehicle {
    String licenseNumber;
    VehicleType type;
    ParkingTicket ticket;

    Vehicle(String licenseNumber, VehicleType type) {
        this.licenseNumber = licenseNumber;
        this.type = type;
    }

    public void assignTicket(ParkingTicket ticket) {
        this.ticket = ticket;
    }
}