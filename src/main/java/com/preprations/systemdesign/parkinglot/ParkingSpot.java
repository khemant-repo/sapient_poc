package com.preprations.systemdesign.parkinglot;

public abstract class ParkingSpot {
    String number;
    boolean isFree = true;
    Vehicle vehicle;
    ParkingSpotType type;

    ParkingSpot(String number, ParkingSpotType type) {
        this.number = number;
        this.type = type;
    }

    public void assignVehicle(Vehicle vehicle) {
        this.vehicle = vehicle;
        isFree = false;
    }

    public void removeVehicle() {
        this.vehicle = null;
        isFree = true;
    }
}