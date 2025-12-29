package model;

import java.util.ArrayList;

public class Floor {

    private final String hotelName;
    private final int floorNumber;
    private ArrayList<Room> rooms;

    public Floor(String hotelName, int floorNumber) {
        this.hotelName = hotelName;
        this.floorNumber = floorNumber;
        rooms = new ArrayList<>();

        for (int i = 1; i <= 5; i++) {
            rooms.add(new Room(floorNumber,
                    i,
                    hotelName,
                    Roomtype.SINGLE,
                    Roomstatus.EMPTY,
                    1000000));
        }

        for (int i = 6; i <= 10; i++) {
            rooms.add(new Room(floorNumber,
                    i,
                    hotelName,
                    Roomtype.DOUBLE,
                    Roomstatus.EMPTY,
                    1500000));
        }
    }

    public int getFloorNumber() {
        return floorNumber;
    }

    public ArrayList<Room> getRooms() {
        return rooms;
    }
}

