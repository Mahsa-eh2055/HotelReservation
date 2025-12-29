package Managers;

import Filemanager.txtFileManager;
import model.Employee;

import java.util.ArrayList;
import java.util.List;

public class Employeemanager {

    private txtFileManager fileManager;


    public Employeemanager(String fileName) {
        fileManager = new txtFileManager(fileName);
    }

    public void addEmployee(Employee emp) {
        fileManager.AppendRow(emp.intoFile());
    }

    public List<Employee> getAllEmployees() {
        List<Employee> list = new ArrayList<>();
        String data = fileManager.getFromFile();
        String[] lines = data.split("\n");

        for (String line : lines) {
            if (line.length() > 0) {
                Employee e = Employee.fromFile(line);
                list.add(e);
            }
        }
        return list;
    }
}
