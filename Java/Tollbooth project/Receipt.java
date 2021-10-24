/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Aadi
 */
import java.sql.Timestamp;
public class Receipt {
    Car me = new Car();
    private Timestamp timeStamp;
    private double tollTex;
    
    /** Setter For tollTex
     * @param toll
     */
    public void setTollTex(double toll)
    {
        tollTex = toll;
    }
    /** Setter for TimeStamp
     * @param date
     */
    public void setTimeStamp(Timestamp date)
    {
        timeStamp = date;
    }
    /** getter for tollTex
     * @return double will return
     */
   public double getTollTex()
   {
       return tollTex;
   }
   /** getter for TimeStamp
  *@return String is return type 
     */
   public Timestamp getTimeStamp()
   {
       return timeStamp;
   }
}
