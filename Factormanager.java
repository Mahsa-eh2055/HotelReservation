package Managers;

import java.util.ArrayList;
import java.util.List;

import model.Factor;
import Filemanager.txtFileManager;

public class Factormanager
{

    private txtFileManager filemanager;

    public Factormanager(String filename)
    {
        filemanager=new txtFileManager(filename);
    }

    public void addFactor(Factor f)
    {
        filemanager.AppendRow(f.intoFile());
    }


    public List<Factor> getAllFactors()
    {
        List<Factor> list=new ArrayList<>();

        String data= filemanager.getFromFile();
        String[] lines=data.split("\n");
        for(int i=0;i<lines.length;i++)
        {

            if(lines[i].length()>0)
            {
                Factor f=Factor.fromFile(lines[i]);
                list.add(f);

            }
        }
        return list;
    }

}
