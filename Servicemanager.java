package Managers;

import Filemanager.txtFileManager;
import model.Service;

import java.util.ArrayList;
import java.util.List;

public class Servicemanager {


    private txtFileManager fileManager;

    public Servicemanager(String fileName) {
        fileManager = new txtFileManager(fileName);
    }

    public void addService(Service service) {
        fileManager.AppendRow(service.intoFile());
    }

    public List<Service> getAllServices() {
        List<Service> list = new ArrayList<>();

        String data = fileManager.getFromFile();
        String[] lines = data.split("\n");

        for (String line : lines) {
            if (line.length() > 0) {
                Service s = Service.fromFile(line);
                list.add(s);
            }
        }
        return list;
    }
}