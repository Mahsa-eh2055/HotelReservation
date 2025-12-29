package Managers;

import java.util.ArrayList;
import java.util.List;

import model.Pay;
import Filemanager.txtFileManager;

public class Paymanager
{

    private txtFileManager filemanager;

    public Paymanager(String filename)
    {
        filemanager=new txtFileManager(filename);
    }



    public void addPay(Pay p)
    {
        filemanager.AppendRow(p.intoFile());
    }


    public List<Pay> getAllPay()
    {
        List<Pay> list=new ArrayList<>();

        String data= filemanager.getFromFile();
        String[] lines=data.split("\n");
        for(int i=0;i<lines.length;i++)
        {

            if(lines[i].length()>0)
            {
                Pay p=Pay.fromFile(lines[i]);
                list.add(p);

            }
        }
        return list;
    }

}
