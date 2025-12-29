package Managers;

import java.util.ArrayList;
import java.util.List;
import model.Reservation;
import Filemanager.txtFileManager;

public class Reservationmanager
{

    private txtFileManager filemanager;

    public Reservationmanager(String filename)
    {
        filemanager=new txtFileManager(filename);
    }

    public void addReservation(Reservation r)
    {
        filemanager.AppendRow(r.intoFile());
    }


    public List<Reservation> getAllReservations()
    {
        List<Reservation> list=new ArrayList<>();

        String data= filemanager.getFromFile();
        String[] lines=data.split("\n");
        for(int i=0;i<lines.length;i++)
        {

            if(lines[i].length()>0)
            {
                Reservation r=Reservation.fromFile(lines[i]);
                list.add(r);

            }
        }
        return list;
    }


}
