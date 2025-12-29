package Managers;

import java.util.ArrayList;
import java.util.List;

import model.Customer;
import Filemanager.txtFileManager;

public class Customermanager
{
    private txtFileManager filemanager;

    public Customermanager(String filename)
    {
        filemanager=new txtFileManager(filename);
    }

    public void addCustomer(Customer customer)
    {
        filemanager.AppendRow(customer.intoFile());
    }


    public List<Customer> getAllCustomer()
    {
        List<Customer> list=new ArrayList<>();

        String data= filemanager.getFromFile();
        String[] lines=data.split("\n");
        for(int i=0;i<lines.length;i++)
        {

            if(lines[i].length()>0)
            {
                Customer c=Customer.fromFile(lines[i]);
                list.add(c);

            }
        }
        return list;
    }

    public Customer findbyNationalcode(String nationalCode)
    {
        List<Customer> allCustomers=getAllCustomer();
        for(int i=0;i<allCustomers.size();i++)
        {
            Customer c=allCustomers.get(i);

            if(c.getNationalcode().equals(nationalCode))
                return c;
        }
        return null;

    }

}
