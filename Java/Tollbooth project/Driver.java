/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Aadi
 */
import java.util.*;
import javax.swing.JOptionPane;
import java.sql.Timestamp;

public class Driver {


    public static void main(String[] args) {
      Car carOb = new Car();
      Receipt receiptOb = new Receipt();
      Tollbooth tollOb  = new Tollbooth("GRW Toll Plaza");
      
      //// MENU
      
      int start = -1;
      String input="";
      String option="";
      do
      {
        input = JOptionPane.showInputDialog(" 1 . Create New Receipt" + "\n"+
                         "2 . Detail of Previous Receipts "+"\n"+"0 . Close Program");
        start = Integer.parseInt(input);
        switch(start)
        {
            case 1:
                receiptOb = new Receipt();
                String name = JOptionPane.showInputDialog("Enter the Driver Name (Alphabets); :");
                String carNo = JOptionPane.showInputDialog("Enter the car No (LEW-10-2458):");
                String make = JOptionPane.showInputDialog("Enter Manufactyred Year (2000 i.e XXXX) :");
                int intMake =  Integer.parseInt(make);
                String model = JOptionPane.showInputDialog("Enter the Car Name (Alpahets and (-) :");
                String engineCap = JOptionPane.showInputDialog("Enter EngineCapacity (600 to 6599) :");
                int intEngine = Integer.parseInt(engineCap);
                String seats = JOptionPane.showInputDialog("Enter the Seating capacity (4 to 10) :");
                int intSeat = Integer.parseInt(seats);
                String govt = JOptionPane.showInputDialog("(Yes) if Govt. (No) if not govt : ");
                boolean isGovt = Boolean.parseBoolean(govt);
                if( carOb.validCarName(model)&&carOb.validDriverName(name)&& carOb.validCarNumber(carNo)
                   && carOb.validMake(intMake)
                   && carOb.validatengCap(intEngine)&&carOb.validatCarseats(intSeat)
                    )
                {
                  receiptOb.me = new Car(model,intMake,carNo,intEngine,intSeat,name,isGovt);
                  receiptOb.setTollTex(receiptOb.me.calculateToll());
                  Timestamp time = new Timestamp(System.currentTimeMillis());
                  receiptOb.setTimeStamp(time);
                  tollOb.list.add(receiptOb);
                  JOptionPane.showMessageDialog(null, "Data Successfully Added");
                   
                  }
                else
                {
                    JOptionPane.showMessageDialog(null,"Invalid Information!!");
                }
                break;
            case 2:
                int inCase=0;
                do{
                option=JOptionPane.showInputDialog("1 . To View The recent Receit "+"\n"+
                        "2. To View all Receipt"+"\n"+"3 . Delete the Receipt "+"\n"+"4 . To go back");
                 inCase = Integer.parseInt(option);
                switch(inCase)
                {
                    case 1:
                        int size = tollOb.list.size();
                        if(size==1)
                        {
                            tollOb.display(1);
                        }
                        else
                        {
                            tollOb.display(2);
                        }
                        break;
                    case 2:
                        tollOb.display(1);
                        break;
                    case 3:
                        option = JOptionPane.showInputDialog("Delete will be based on rceeipt No # ");
                        int del = Integer.parseInt(option);
                        if( del >= 0 && del <= tollOb.list.size() )
                        {
                            del = del - 1;
                            tollOb.list.remove(del);
                            JOptionPane.showMessageDialog(null,"Receipt deleted Successfully !!!");
                        }
                        else
                        {
                           JOptionPane.showMessageDialog(null," Entered Receipt no is Out of Range");  
                        }
                        break;
                    case 4:
                        break;
                    default:
                        JOptionPane.showMessageDialog(null,"Please Enter the valid option");
                        break;
                }
                }while(inCase!=4);
                
                break;
            default:
                JOptionPane.showMessageDialog(null,"Please Enter the valid option");
            case 0:
                break;
                
        }
      }
      while(start!=0);
     tollOb.finalize();
      JOptionPane.showMessageDialog(null," Program closed Successfully!!");
    }
    
}
