package model;

public class Roomtype {

    public static final String SINGLE = "Single";
    public static final String DOUBLE = "Double";

    public static boolean isValid(String type) {
        return type.equals(SINGLE) ||
                type.equals(DOUBLE);
    }
}
