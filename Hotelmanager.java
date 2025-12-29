package Managers;

import model.Hotel;
import java.util.ArrayList;

public class Hotelmanager {

    private ArrayList<Hotel> hotels;

    public Hotelmanager() {
        hotels = new ArrayList<>();
        hotels.add(new Hotel( 1,"Zomorod"));
        hotels.add(new Hotel( 2,"Aram"));
    }

    public ArrayList<Hotel> getHotels() {
        return hotels;
    }

    public Hotel getHotelByName(String name) {
        for (Hotel h : hotels) {
            if (h.getName().equals(name))
                return h;
        }
        return null;
    }
}
