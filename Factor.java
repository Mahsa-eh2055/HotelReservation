package model;

import javax.swing.JOptionPane;

public class Factor
{
    private int factornumber;
    private int totalprice;
    private String paystatus;



    public Factor(int factornumber,int totalprice, String paystatus)
    {
        setFactornumber(factornumber);
        setTotalprice(totalprice);
        setPaystatus(paystatus);
    }








    public int getFactornumber()
    {
        return factornumber;
    }



    public void setFactornumber(int factornumber)
    {
        if(factornumber>0)
        {
            this.factornumber=factornumber;

        }
    }


    public int getTotalprice()
    {
        return totalprice;
    }



    public void setTotalprice(int totalprice)
    {

        if(totalprice>=0)
        {
            this.totalprice=totalprice;

        }
    }



    public String getPaystatus()
    {
        return paystatus;
    }



    public void setPaystatus(String paystatus)
    {
        this.paystatus=paystatus;

    }



    public String intoFile()
    {
        return factornumber +"," + totalprice +"," + paystatus;
    }


    public static Factor fromFile(String line)
    {
        String[] f= line.split(",");
        int factornumber=Integer.parseInt(f[0]);
        int totalprice=Integer.parseInt(f[1]);
        String paystatus=f[2];


        return new Factor(factornumber, totalprice,paystatus);
    }

}
