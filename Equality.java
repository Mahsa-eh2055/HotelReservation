package model;

public class Equality {

    private final String EqualityType;
    private String price;
    private final String roomNumber;

    public Equality(String equalityType, String price, String roomNumber) {
        this.EqualityType = equalityType;
        this.price = price;
        this.roomNumber = roomNumber;
    }

    public String getEqualityType() {
        return EqualityType;
    }

    public String getPrice() {
        return price;
    }

    public String getRoomNumber() {
        return roomNumber;
    }


    public void setPrice() {
        this.price = price;
    }

    public String intoFile() {
        return EqualityType + "," + price + "," + roomNumber;
    }

    public static model.Equality fromFile(String line) {
        String[] p = line.split(",");
        return new model.Equality(p[0], p[1], p[2]);
    }
}