/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Aadi
 */
import java.io.FileWriter;
import java.io.FileReader;
import java.io.BufferedReader;
import java.sql.Timestamp;
import java.util.*;
import javax.swing.JOptionPane;
public class Tollbooth {
    private String location;
    List<Receipt> list;
    /** Default Constructor for Tollbooth
     */
    public Tollbooth()
    {
        
    }
    /** Constructor for Tollbooth And to Read Data from the file
     * @param Loction
     */
    public Tollbooth(String Location)
    {
        this.location = Location;
        this.list = new ArrayList<>();
        Receipt recok = new Receipt();
         try
        {
            FileReader obj = new FileReader("receipt.txt");
            BufferedReader buobj= new BufferedReader(obj);
            String line = "0";
            while(line!=null)
            {
                recok = new Receipt();
                line = buobj.readLine();
                String []arr = line.split("/");
                String name = arr[0];
                String model = arr[1];
                String make = arr[2];
                int intMake = Integer.parseInt(make);
                String carNo = arr[3];
                int seatsCap = Integer.parseInt(arr[4]);
                int engineCap = Integer.parseInt(arr[5]);
                boolean govt = Boolean.parseBoolean(arr[6]);
                Timestamp time = Timestamp.valueOf(arr[7]);
                double toll = Double.parseDouble(arr[8]);
                recok.me = new Car(model,intMake,carNo,engineCap,seatsCap,name,govt);
                recok.setTimeStamp(time);
                recok.setTollTex(toll);
                list.add(recok);
            }
            buobj.close();
            obj.close();
        }
         catch(Exception ex)
         {
             
         }
    }
    /** To Write the Data on the file
     */
    protected void finalize() throws Throwable
    {
        try
        {
            FileWriter obj = new FileWriter("receipt.txt");
            String line = "";
            boolean flag = false;
            if(list.isEmpty())
            {
                JOptionPane.showMessageDialog(null,"File is Empty...");
            }
            else
            {
                for(int i=0;i<list.size();i++)
              {
                  line = line+ list.get(i).me.getdriverName() + "/";
                  line = line+ list.get(i).me.getModel()+"/";
                  line = line+ list.get(i).me.getMake()+"/";
                  line = line+ list.get(i).me.getcarNumber()+"/";
                  line = line+ list.get(i).me.getseatingCapacity()+"/";
                  line = line+ list.get(i).me.getengineCapacity()+"/";
                  line = line+ list.get(i).me.getisGovtVehicle()+"/";
                  line = line+ list.get(i).getTimeStamp()+"/";
                  line = line+ list.get(i).getTollTex()+"\n";
              }
               obj.write(line);
               obj.flush();
               obj.close();
               
               JOptionPane.showMessageDialog(null,"File saved successfuly!!!");
               super.finalize();
               
            }
        }
        catch(Throwable e)
        {
            throw e;
        }
    }
    
    /**Getter 
     * @return String will return
     */
    public String getlocation()
    {
        return location;
    } 
    
    /** To output 
     * @param option to decide whether to show All list or Recent One.
     */
    public void display(int option)
    {
        String display = "";
        
        if(list.isEmpty())
        {
            JOptionPane.showMessageDialog(null,"Plz Enter Receipt First.....");
           
        }
        else
        {
            if(option==1)
            {
            for(int i=0;i<list.size();i++)
            {
                display = display + "Receipt "+"  #"+(i+1)+"\n";
                display = display + getlocation()+"\n" + "___________________________________"+"\n" ;
                display = display + "Name of the Driver :   "+ list.get(i).me.getdriverName()+"\n";
                display = display + "Car Details : "+"\n";
                display = display + "Car Model :" + list.get(i).me.getModel()+"\n"+
                           "Car Year :  " + list.get(i).me.getMake() + "\n";
                display = display + "Car Number :  " + list.get(i).me.getcarNumber()+"\n"+
                          "Car's Seating Capacity : "+list.get(i).me.getseatingCapacity() + "\n";
                display = display + "Engine Capacity : "+list.get(i).me.getengineCapacity()+"\n";
                display = display + "Tex details : "+"\n";
                display = display + "Time :"+list.get(i).getTimeStamp()+"\n";
                if(list.get(i).me.getisGovtVehicle())
                {
                    display = display + "Car is Government,No toll tex"+"\n";
                }
                    else
                    {
                        display = display + "Total Toll tex : "+list.get(i).getTollTex()+"\n"+"\t\n";
                    }
                
            }
            JOptionPane.showMessageDialog(null, display);
            }
            else if(option==2)
            {
                int size=list.size();
                size=size-1;
                 display = display + "Receipt "+"  #"+(size)+"\n";
                display = display + getlocation()+"\n" + "___________________________________"+"\n" ;
                display = display + "Name of the Driver :   "+ list.get(size).me.getdriverName()+"\n";
                display = display + "Car Details : "+"\n";
                display = display + "Car Model :" + list.get(size).me.getModel()+"\n"+
                           "Car Year :  " + list.get(size).me.getMake() + "\n";
                display = display + "Car Number :  " + list.get(size).me.getcarNumber()+"\n"+
                          "Car's Seating Capacity : "+list.get(size).me.getseatingCapacity() + "\n";
                display = display + "Engine Capacity : "+list.get(size).me.getengineCapacity()+"\n";
                display = display + "Tex details : "+"\n";
                display = display + "Time :"+list.get(size).getTimeStamp()+"\n";
                if(list.get(size).me.getisGovtVehicle())
                {
                    display = display + "Car is Government,No toll tex"+"\n";
                }
                    else
                    {
                        display = display + "Total Toll tex : "+list.get(size).getTollTex()+"\n"+"\t\n";
                    }
                JOptionPane.showMessageDialog(null, display);
            }
        }
        
    }
}
