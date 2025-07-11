package com.preprations.systemdesign.parkinglot;

import java.util.HashMap;
import java.util.Map;
import java.util.EnumMap;

public class ParkingFloor {
    String name;
    Map<String, ParkingSpot> parkingSpots = new HashMap<>();
    DisplayBoard displayBoard;

    ParkingFloor(String name, DisplayBoard board) {
        this.name = name;
        this.displayBoard = board;
    }

    public void addParkingSpot(ParkingSpot spot) {
        parkingSpots.put(spot.number, spot);
        updateDisplayBoard();
    }

    public void updateDisplayBoard() {
        Map<ParkingSpotType, Integer> countMap = new EnumMap<>(ParkingSpotType.class);
        for (ParkingSpot spot : parkingSpots.values()) {
            if (spot.isFree) {
                countMap.put(spot.type, countMap.getOrDefault(spot.type, 0) + 1);
            }
        }
        for (ParkingSpotType type : ParkingSpotType.values()) {
            displayBoard.updateAvailableSpots(type, countMap.getOrDefault(type, 0));
        }
    }

    public ParkingSpot getFreeSpot(ParkingSpotType type) {
        for (ParkingSpot spot : parkingSpots.values()) {
            if (spot.type == type && spot.isFree) {
                return spot;
            }
        }
        return null;
    }
}