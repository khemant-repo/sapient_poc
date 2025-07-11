package com.preprations.systemdesign.parkinglot;

// similarly for other parkingSpotType
public class BikeSpot extends ParkingSpot {
    public BikeSpot(String number) {
        super(number, ParkingSpotType.MOTORBIKE);
    }
}
