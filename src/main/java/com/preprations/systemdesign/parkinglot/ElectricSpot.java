package com.preprations.systemdesign.parkinglot;

public class ElectricSpot extends ParkingSpot {
    ElectricSpot(String number) {
        super(number, ParkingSpotType.ELECTRIC);
    }
}