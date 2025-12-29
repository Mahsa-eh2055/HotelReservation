package model;

import javax.swing.JOptionPane;

public class Customer
{
    private String firstName;
    private String lastName;
    private String nationalcode;
    private String phonenumber;



    public Customer(String firstName, String lastName, String nationalcode, String phonenumber)
    {
        setFirstName(firstName);
        setLastName(lastName);
        setNationalcode(nationalcode);
        setPhonenumber(phonenumber);

    }



    public String getFirstName()
    {
        return firstName;
    }



    public void setFirstName(String firstName)
    {
        if(firstName.length()<2)
        {
            JOptionPane.showMessageDialog(null, "لطفا اسم را وارد کنید","مدیریت هتل", JOptionPane.INFORMATION_MESSAGE);
            return;
        }

        if(firstName.length()>2)
        {
            for(int i=0;i<firstName.length();i++)
            {

                if(firstName.charAt(i)>='0' && firstName.charAt(i)<='9')
                {
                    JOptionPane.showMessageDialog(null, "نام: لطفا حروف وارد کنید   ","مدیریت هتل", JOptionPane.INFORMATION_MESSAGE);
                    return;
                }


            }
            this.firstName=firstName;
        }


    }


    public String getLastName()
    {
        return lastName;
    }



    public void setLastName(String lastName)
    {
        if(lastName.length()<2)
        {
            JOptionPane.showMessageDialog(null, "لطفا نام خانوادگی را وارد کنید","مدیریت هتل", JOptionPane.INFORMATION_MESSAGE);
            return;
        }

        if(lastName.length()>2)
        {
            for(int i=0;i<lastName.length();i++)
            {

                if(lastName.charAt(i)>='0' && lastName.charAt(i)<='9')
                {
                    JOptionPane.showMessageDialog(null, "نام خانوادگی: لطفا حروف وارد کنید   ","مدیریت هتل", JOptionPane.INFORMATION_MESSAGE);
                    return;
                }


            }
            this.lastName=lastName;
        }
    }



    public String getNationalcode()
    {
        return nationalcode;
    }



    public void setNationalcode(String nationalcode)
    {
        if(nationalcode.length()==10)
        {

            for(int i=0;i<nationalcode.length();i++)
            {
                if(nationalcode.charAt(i)<'0'||nationalcode.charAt(i)>'9')
                {

                    JOptionPane.showMessageDialog(null, "کدملی: لطفا عدد وارد کنید   ","مدیریت هتل", JOptionPane.INFORMATION_MESSAGE);
                    return;
                }

            }
            this.nationalcode=nationalcode;
        }
        else
        {
            JOptionPane.showMessageDialog(null, "کدملی: لطفا 10 رقم وارد کنید  ","مدیریت هتل", JOptionPane.INFORMATION_MESSAGE);
            return;
        }
    }



    public String getPhonenumber()
    {
        return phonenumber;
    }



    public void setPhonenumber(String phonenumber)
    {

        if(phonenumber.length()==11)
        {

            for(int i=0;i<phonenumber.length();i++)
            {
                if(phonenumber.charAt(i)<'0'||phonenumber.charAt(i)>'9')
                {

                    JOptionPane.showMessageDialog(null, "شماره تماس: لطفا  عدد وارد کنید  ","مدیریت هتل", JOptionPane.INFORMATION_MESSAGE);
                    return;
                }

            }
            this.phonenumber=phonenumber;
        }
        else
        {
            JOptionPane.showMessageDialog(null, "شماره تماس: لطفا 11 رقم وارد کنید  ","مدیریت هتل", JOptionPane.INFORMATION_MESSAGE);
            return;
        }
    }

    public String intoFile()
    {
        return firstName +"," + lastName +"," + nationalcode +"," + phonenumber;
    }


    public static Customer fromFile(String line)
    {
        String[] cu= line.split(",");
        return new Customer(cu[0], cu[1], cu[2], cu[3]);
    }



}
