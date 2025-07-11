package com.preprations.systemdesign.parkinglot;

public class ParkingLotSimulation {
    public static void main(String[] args) {
        // Initialize display board and floor
        DisplayBoard board = new DisplayBoard();
        board.id = "DB1";
        ParkingFloor floor1 = new ParkingFloor("F1", board);

        // Add sample parking spots
        for (int i = 1; i <= 2; i++) floor1.addParkingSpot(new CompactSpot("C" + i));
        for (int i = 1; i <= 2; i++) floor1.addParkingSpot(new ElectricSpot("E" + i));
        for (int i = 1; i <= 1; i++) floor1.addParkingSpot(new LargeSpot("L" + i));
        for (int i = 1; i <= 1; i++) floor1.addParkingSpot(new MotorbikeSpot("M" + i));

        // Create parking lot and add floor
        ParkingLot lot = new ParkingLot();
        lot.name = "GreenPark";
        lot.address = "Sector 21";
        lot.addFloor(floor1);

        // Create entrance and exit panels
        EntrancePanel entrancePanel = new EntrancePanel("EP1");
        ExitPanel exitPanel = new ExitPanel("XP1");

        // Show initial parking spot availability
        lot.showAllBoards();

        // Simulate vehicle entries using EntrancePanel
        Vehicle car1 = new Car("DL123");
        Vehicle ev1 = new ElectricCar("EV001");
        Vehicle bike1 = new Bike("BK001");

        // Vehicles entering through entrance panel
        entrancePanel.printTicket(lot, car1);
        entrancePanel.printTicket(lot, ev1);
        entrancePanel.printTicket(lot, bike1);

        System.out.println("\nAfter vehicles parked:");
        lot.showAllBoards();

        // Simulate vehicle exits using ExitPanel
        exitPanel.scanTicketAndExit(lot, ev1);
        exitPanel.scanTicketAndExit(lot, car1);

        System.out.println("\nAfter vehicles exited:");
        lot.showAllBoards();
    }
}
