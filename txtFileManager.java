package Filemanager;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

public class txtFileManager {
    private String FileName;
    private int Rows;

    public txtFileManager(String FileName)
    {
        this.FileName=FileName;
        Rows=0;

        File f=new File(FileName);
        if(!f.exists())
        {
            try {
                f.createNewFile();

            }
            catch(Exception e)
            {
                e.printStackTrace();
            }
        }
    }


    public void DeleteRow(int Row)
    {
        _UpdateRows();

        if(Row<=0 || Row>Rows)
            return;
        String s[]=getArrayFromFile();
        String news="";
        for(int i=0;i<s.length;i++)
        {
            if(i !=Row-1)
                news=news+s[i];
        }
        setIntoFile(news);
    }


    public int SelectCount()
    {
        _UpdateRows();

        return Rows;
    }


    private void _UpdateRows()
    {
        int c=0;

        try
        {


            Scanner input=new Scanner(new File(FileName));

            while(input.hasNextLine())
            {
                input.nextLine();
                c++;
            }
            input.close();


        }
        catch(FileNotFoundException e)
        {
            e.printStackTrace();

        }
        Rows=c;
    }

    public void AppendRow(String NewRow)
    {
        String s=getFromFile();
        if(s.length()==0)
            s=NewRow;
        else
            s=s+"\n"+NewRow;
        setIntoFile(s);
    }


    //////////////////////////////////////////////////setintofile
    public void setIntoFile(String s)
    {

        try
        {

            PrintWriter out= new PrintWriter(this.FileName);
            out.print(s);
            out.close();
            _UpdateRows();


        }
        catch(FileNotFoundException e)
        {
            e.printStackTrace();

        }
    }

    private String[] getArrayFromFile()
    {

        File file=new File(this.FileName);
        String s[]=new String[Rows];
        int cs=0;
        try
        {

            Scanner input=new Scanner(file);

            while(input.hasNextLine())
            {
                s[cs++]=input.nextLine()+"\n";
            }
            input.close();



        }
        catch(FileNotFoundException e)
        {
            e.printStackTrace();

        }
        return s;
    }




    //////////////////////////////////////////////////getfromfile
    public String getFromFile()
    {
        File file=new File(this.FileName);
        String s="";
        try
        {

            Scanner input=new Scanner(file);

            while(input.hasNextLine())
            {
                if(s.length()==0)
                    s=input.nextLine();
                else
                    s=s+"\n"+input.nextLine();
            }
            input.close();



        }
        catch(FileNotFoundException e)
        {
            e.printStackTrace();

        }
        return s;
    }


    //////////////////////////////////////////////////createfile


    public void CreateFile()
    {
        setIntoFile("");
        Rows=0;
    }


    //////////////////////////////////////////////////clear
    public void Clear()
    {
        CreateFile();
        Rows=0;
    }

    public String GetRow(int row)
    {
        _UpdateRows();
        if(row<=0 || row>Rows)
            return "";

        int c=1;
        File file=new File(this.FileName);

        try
        {

            Scanner input=new Scanner(file);

            while(input.hasNextLine())
            {
                String line=input.nextLine();
                if(c==row)
                {
                    input.close();
                    return line;
                }
                c++;

            }
            input.close();



        }
        catch(FileNotFoundException e)
        {
            e.printStackTrace();

        }
        return "";
    }

}
