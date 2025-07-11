package com.preprations.systemdesign.parkinglot;

import java.util.EnumMap;
import java.util.Map;

public class DisplayBoard {
    String id;
    Map<ParkingSpotType, Integer> freeSpots = new EnumMap<>(ParkingSpotType.class);

    public void updateAvailableSpots(ParkingSpotType type, int count) {
        freeSpots.put(type, count);
    }

    public void showBoard() {
        System.out.println("=== Display Board [" + id + "] ===");
        freeSpots.forEach((k, v) -> System.out.println(k + ": " + v));
    }
}