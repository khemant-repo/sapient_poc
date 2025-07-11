package com.preprations.systemdesign.parkinglot;

import java.util.ArrayList;
import java.util.List;

public class ParkingLot {
    String name;
    String address;
    List<ParkingFloor> floors = new ArrayList<>();

    public void addFloor(ParkingFloor floor) {
        floors.add(floor);
    }

    public ParkingTicket getNewParkingTicket(Vehicle vehicle) {
        ParkingSpotType type = getSpotTypeFromVehicle(vehicle.type);
        for (ParkingFloor floor : floors) {
            ParkingSpot spot = floor.getFreeSpot(type);
            if (spot != null) {
                spot.assignVehicle(vehicle);
                floor.updateDisplayBoard();
                String ticketId = "TICKET-" + System.currentTimeMillis();
                ParkingTicket ticket = new ParkingTicket(ticketId, vehicle, spot, floor.name);
                vehicle.assignTicket(ticket);
                System.out.println("Issued ticket: " + ticketId + " for vehicle: " + vehicle.licenseNumber);
                return ticket;
            }
        }
        System.out.println("No available spot for vehicle type: " + vehicle.type);
        return null;
    }

    private ParkingSpotType getSpotTypeFromVehicle(VehicleType type) {
        return switch (type) {
            case CAR -> ParkingSpotType.COMPACT;
            case BIKE -> ParkingSpotType.MOTORBIKE;
            case TRUCK -> ParkingSpotType.LARGE;
            case ELECTRIC -> ParkingSpotType.ELECTRIC;
        };
    }

    public void exitVehicle(Vehicle vehicle) {
        ParkingTicket ticket = vehicle.ticket;
        if (ticket == null) return;
        ticket.spot.removeVehicle();
        ticket.spot = null;
        ticket.isPaid = true;
        System.out.println("Vehicle " + vehicle.licenseNumber + " exited. Charges: $" + ticket.calculateCharges());
        for (ParkingFloor floor : floors) {
            floor.updateDisplayBoard();
        }
    }

    public void showAllBoards() {
        for (ParkingFloor floor : floors) {
            floor.displayBoard.showBoard();
        }
    }
}