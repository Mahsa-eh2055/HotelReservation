package model;

import javax.swing.JOptionPane;

public class Pay
{

    private int roomNumber;
    private int Payment;
    private String Paymentmethod;
    private String Date;


    public Pay(int roomNumber, int Payment, String Paymentmethod, String Date)
    {


        setroomNumber(roomNumber);
        setPayment(Payment);
        setPaymentmethod(Paymentmethod);
        setDate(Date);


    }




    public int getroomNumber()
    {
        return roomNumber;
    }



    public void setroomNumber(int roomNumber)
    {
        if(roomNumber>=0)
        {
            this.roomNumber=roomNumber;

        }
    }



    public int getPayment()
    {
        return Payment;
    }



    public void setPayment(int payment)
    {

        if(payment>=0)
        {
            this.Payment=payment;

        }
    }



    public String getPaymentmethod()
    {
        return Paymentmethod;
    }



    public void setPaymentmethod(String paymentmethod)
    {
        Paymentmethod = paymentmethod;
    }



    public String getDate()
    {
        return Date;
    }



    public void setDate(String date)
    {
        if(date.length() != 10)
        {
            JOptionPane.showMessageDialog(null,"تاریخ باید 10 کاراکتر باشد (مثلاً 1403/05/20)","مدیریت هتل",	JOptionPane.INFORMATION_MESSAGE);
            return;

        }

        if(date.charAt(4) != '/' || date.charAt(7) != '/')
        {
            JOptionPane.showMessageDialog(null, "تاریخ باید با فرمت YYYY/MM/DD باشد  ","مدیریت هتل", JOptionPane.INFORMATION_MESSAGE);
            return;
        }

        for(int i = 0; i < date.length(); i++)
        {
            if(i == 4 || i == 7)
                continue;

            if(date.charAt(i)<'0'||date.charAt(i)>'9')
            {
                JOptionPane.showMessageDialog(null, " تاریخ نامعتبر است","مدیریت هتل", JOptionPane.INFORMATION_MESSAGE);
                return;
            }


        }

        this.Date = date;

    }



    public String intoFile()
    {

        return roomNumber + "," + Payment + "," + Paymentmethod + "," + Date;
    }


    public static Pay fromFile(String line)
    {
        String[] f= line.split(",");
        int roomNumber=Integer.parseInt(f[0]);
        int Payment=Integer.parseInt(f[1]);
        String Paymentmethod=f[2];
        String Date=f[3];

        return new Pay(roomNumber,Payment, Paymentmethod,Date);
    }


}
