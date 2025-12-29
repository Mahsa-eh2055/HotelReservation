package model;

import java.time.LocalDate;

import javax.swing.JOptionPane;

public class Reservation
{


    private int roomnumber;
    private String fromDate;
    private String toDate;



    public Reservation(int roomnumber, String fromDate,  String toDate)
    {
        setRoomNumber(roomnumber);
        setFromDate(fromDate);
        setToDate(toDate);

    }




    public int getRoomNumber()
    {
        return roomnumber;
    }



    public void setRoomNumber(int roomnumber)
    {

        if(roomnumber>0)
        {
            this.roomnumber=roomnumber;

        }
    }



    public String getFromDate()
    {
        return fromDate;
    }



    public void setFromDate(String fromDate)
    {


        if(fromDate.length() != 10)
        {
            JOptionPane.showMessageDialog(null,"تاریخ باید 10 کاراکتر باشد (مثلاً 1403/05/20)","مدیریت هتل",	JOptionPane.INFORMATION_MESSAGE);
            return;

        }

        if(fromDate.charAt(4) != '/' || fromDate.charAt(7) != '/')
        {
            JOptionPane.showMessageDialog(null, "تاریخ باید با فرمت YYYY/MM/DD باشد  ","مدیریت هتل", JOptionPane.INFORMATION_MESSAGE);
            return;
        }

        for(int i = 0; i < fromDate.length(); i++)
        {
            if(i == 4 || i == 7)
                continue;

            if(fromDate.charAt(i)<'0'||fromDate.charAt(i)>'9')
            {
                JOptionPane.showMessageDialog(null, " تاریخ نامعتبر است","مدیریت هتل", JOptionPane.INFORMATION_MESSAGE);
                return;
            }


        }
        this.fromDate=fromDate;

    }



    public String getToDate()
    {
        return toDate;
    }



    public void setToDate(String toDate)
    {

        if(toDate.length() != 10)
        {
            JOptionPane.showMessageDialog(null,"تاریخ باید 10 کاراکتر باشد (مثلاً 1403/05/20)","مدیریت هتل",	JOptionPane.INFORMATION_MESSAGE);
            return;

        }

        if(toDate.charAt(4) != '/' || toDate.charAt(7) != '/')
        {
            JOptionPane.showMessageDialog(null, "تاریخ باید با فرمت YYYY/MM/DD باشد  ","مدیریت هتل", JOptionPane.INFORMATION_MESSAGE);
            return;
        }

        for(int i = 0; i < toDate.length(); i++)
        {
            if(i == 4 || i == 7)
                continue;

            if(toDate.charAt(i)<'0'||toDate.charAt(i)>'9')
            {
                JOptionPane.showMessageDialog(null, " تاریخ نامعتبر است","مدیریت هتل", JOptionPane.INFORMATION_MESSAGE);
                return;
            }


        }
        this.toDate=toDate;
    }

    public String intoFile()
    {
        return roomnumber +"," + fromDate +"," + toDate;
    }


    public static Reservation fromFile(String line)
    {
        String[] r= line.split(",");
        int roomnumber=Integer.parseInt(r[0]);
        String fromDate=r[1];
        String toDate=r[2];
        return new Reservation(roomnumber, fromDate, toDate);

    }



}
