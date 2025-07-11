package com.preprations.systemdesign.parkinglot;

public class HandicappedSpot extends ParkingSpot {
    HandicappedSpot(String number) {
        super(number, ParkingSpotType.HANDICAPPED);
    }
}