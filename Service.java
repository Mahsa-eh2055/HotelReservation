package model;

public class Service {

    private final String serviceType;
    private String price;
    private final String roomNumber;

    public Service(String serviceType, String price, String roomNumber) {
        this.serviceType = serviceType;
        this.price = price;
        this.roomNumber = roomNumber;
    }


    public String getServiceType() { return serviceType; }
    public String getPrice() { return price; }
    public String getRoomNumber() { return roomNumber; }

    public String intoFile() {
        return serviceType + "," + price + "," + roomNumber;
    }

    public static Service fromFile(String line) {
        String[] p = line.split(",");
        return new Service(p[0], p[1], p[2]);
    }
}
