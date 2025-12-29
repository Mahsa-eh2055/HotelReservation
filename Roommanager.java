package Managers;

import Filemanager.txtFileManager;
import model.Room;
import model.Roomstatus;

import java.util.ArrayList;

public class Roommanager {

    private txtFileManager file;

    public Roommanager(String fileName) {
        file = new txtFileManager(fileName);
        if (file.SelectCount() == 0)
            file.CreateFile();
    }

    public ArrayList<Room> getAllRooms() {
        ArrayList<Room> rooms = new ArrayList<>();

        int count = file.SelectCount();
        for (int i = 1; i <= count; i++) {
            String line = file.GetRow(i).trim();
            if (!line.isEmpty())
                rooms.add(Room.fromFile(line));
        }
        return rooms;
    }

    public ArrayList<Room> findEmptyRooms(String hotelName, String roomType) {
        ArrayList<Room> result = new ArrayList<>();
        for (Room r : getAllRooms()) {
            if (r.getHotelName().equalsIgnoreCase(hotelName)
                    && r.getRoomType().equalsIgnoreCase(roomType)
                    && r.getStatus().equalsIgnoreCase(Roomstatus.EMPTY)) {
                result.add(r);
            }
        }
        return result;
    }

    public void updateRoom(Room updatedRoom) {
        ArrayList<Room> all = getAllRooms();
        StringBuilder sb = new StringBuilder();
        for (Room r : all) {
            if (r.getHotelName().equals(updatedRoom.getHotelName())
                    && r.getRoomNumber() == updatedRoom.getRoomNumber()) {
                sb.append(updatedRoom.toFile());
            } else {
                sb.append(r.toFile());
            }
            sb.append("\n");
        }
        file.setIntoFile(sb.toString().trim());
    }
}
