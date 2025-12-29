package model;
import java.util.ArrayList;
import java.util.List;
public class Hotel {
    private int id;
    private String name;
    private List<Floor> floors;
    public Hotel(int id, String name) {
        this.id = id;
        this.name = name;
        floors = new ArrayList<>();
        for(int i=1; i<=8; i++) {
            floors.add(new Floor(name, i));
        }
    }
    public static final String Zomorod = "Zomorod";
    public static final String Aram = "Aram";
    public static boolean isValid(String type) {
        return type.equals(Zomorod) || type.equals(Aram);
    }

    public int getId() { return id; }
    public String getName() { return name; }
    public List<Floor> getFloors() { return floors; } }