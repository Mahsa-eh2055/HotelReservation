package Managers;

import Filemanager.txtFileManager;
import model.Equality;

import java.util.ArrayList;
import java.util.List;

public class Equalitymanager {


    private txtFileManager fileManager;

    public Equalitymanager(String fileName) {
        fileManager = new txtFileManager(fileName);
    }

    public void addEquality(Equality equality) {
        fileManager.AppendRow(equality.intoFile());
    }

    public List<Equality> getAllEquality() {
        List<Equality> list = new ArrayList<>();

        String data = fileManager.getFromFile();
        String[] lines = data.split("\n");

        for (String line : lines) {
            if (line.length() > 0) {
                Equality s = Equality.fromFile(line);
                list.add(s);
            }
        }
        return list;
    }
}
