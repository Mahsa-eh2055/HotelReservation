package model;

public class Roomstatus {

    public static final String EMPTY = "Empty";
    public static final String FULL = "Full";
    public static final String CLEANING = "Cleaning";
    public static final String REPAIR = "Repair";

    public static boolean isValid(String status) {
        return status.equals(EMPTY) ||
                status.equals(FULL) ||
                status.equals(CLEANING)||
                status.equals(REPAIR);
    }
}
