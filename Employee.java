package model;

public class Employee {

    private int personnelCode;
    private String name;
    private String role;
    private String shift;

    public Employee(int personnelCode, String name, String role, String shift) {
        this.personnelCode = personnelCode;
        this.name = name;
        this.role = role;
        this.shift = shift;
    }

    public int getPersonnelCode() {
        return personnelCode;
    }

    public String getName() {
        return name;
    }

    public String getRole() {
        return role;
    }

    public String getShift() {
        return shift;
    }

    public String intoFile() {
        return personnelCode + "," + name + "," + role + "," + shift;
    }

    public static Employee fromFile(String line) {
        String[] p = line.split(",");
        return new Employee(Integer.parseInt(p[0]), p[1], p[2], p[3]);
    }
}