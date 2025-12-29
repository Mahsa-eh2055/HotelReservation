package model;

public class Room {

    private final String hotelName;
    private final int floorNumber;
    private final int roomNumber;
    private final String roomType;
    private final int price;

    private String status;

    public Room(int floorNumber, int roomNumber, String hotelName, String roomType, String status, int price) {
        this.floorNumber = floorNumber;
        this.roomNumber = roomNumber;
        this.hotelName = hotelName;
        this.roomType = roomType;
        this.price = price;
        if (Roomstatus.isValid(status))
            this.status = status;
        else
            this.status = Roomstatus.EMPTY;
    }

    public String getHotelName() { return hotelName; }
    public int getFloorNumber() { return floorNumber; }
    public int getRoomNumber() { return roomNumber; }
    public String getRoomType() { return roomType; }
    public String getStatus() { return status; }
    public int getPrice() { return price; }

    public void setStatus(String status) {
        if (Roomstatus.isValid(status))
            this.status = status;
    }

    public String toFile() {
        return hotelName + "," + floorNumber + ","
                + roomNumber + "," + roomType + "," + status + "," + price;
    }

    public static Room fromFile(String line) {
        String[] r = line.split(",");

        if (r.length < 5)
            throw new RuntimeException("فرمت اشتباه: " + line);

        String hotelName = r[0];
        int floorNumber = Integer.parseInt(r[1]);
        int roomNumber = Integer.parseInt(r[2]);
        String roomType = r[3];
        String status = r[4];
        int price = Integer.parseInt(r[5]);
        



        return new Room(floorNumber, roomNumber, hotelName, roomType, status, price);
    }
}


