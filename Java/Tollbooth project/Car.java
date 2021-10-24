/**
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Aadi
 */
public class Car {

  private String model;
  private int make;
  private String carNumber;
  private int engineCapicity;
  private int seatingCapicity;
  private String driverName;
  private boolean isGovtVechicle;
  
  /////////////////////////////// Constructorr
  /**Constructor for car info. and Driver Name
   * @param model
   * @param make
   * @param carNumber
   * @param engineCapicity
   * @param seatingCapicity
   * @param driverName
   * @param isGovtVechicle
   */
  public Car(String modell,int make,String carNumber,int engineCapicity,
              int seatingCapicity,String driverName,boolean isGovtVechile)
  {
      model = modell;
      this.make = make;
      this.carNumber = carNumber;
      this.engineCapicity = engineCapicity;
      this.seatingCapicity = seatingCapicity;
      this.driverName = driverName;
      this.isGovtVechicle = isGovtVechile;
      
  }
  /** Default Constructor
   */

  public Car()
  {
      
  }
 /**
  * To Calculate Toll of The Car
  * @return It return total toll of Car
  */  
  public double calculateToll()
  {
      double toll = 10;
      if(isGovtVechicle == true)
      {
          // No toll for Govt vechile
          return 0;
      }
      if(engineCapicity < 1000)
      {
          return toll;
      }
      else if(engineCapicity >= 1000 && engineCapicity <=1300)
      {
          toll = (engineCapicity / 100) + toll;
      }
      else if(engineCapicity >1300 && engineCapicity <=1800)
      {
          toll = (engineCapicity / 65) + toll;
      }
      else if(engineCapicity > 1800)
      {
          toll = (engineCapicity / 50) +toll;
      }
      // Seating capicity
      if(seatingCapicity >4)
      {
          for(int i=4;i<seatingCapicity;i++)
          {
              toll = toll + 5;
          }
      }
      // make
      if(make < 2018)
      {
          for(int i =2018;i<make;i++)
          {
              toll = toll+ 2;
          }
      }
      return toll;     
  }
  //// setters
  /**
   * Setter is for carDriverName
   * @param name
   * @return method return String
   */
  public void setName(String name)
  {
      driverName = name;
  }
  // Getter
  /** Getter for model
   * @return method return String
   */
  public String getModel()
  {
      return model;
  }
  /** getter for make
   * @return method will return int
   */
  public int getMake()
  {
      return make;
  }
  /** getter for carNumber
   * @return String
   */
  public String getcarNumber() {
        return carNumber;
  }
   /** getter for engineCapacity
  *@return  return int
     */
    public int getengineCapacity() {
        return engineCapicity;
    }
    /** getter for seatingCapacity
  *@return return int
     */
    public int getseatingCapacity() {
        return seatingCapicity;
    }
     /** getter for DriverName
  *@return return String
     */
    public String getdriverName() {
        return driverName;
    }
    /*getter for isGovtVehicle
  *@return return Boolean
     */
    public boolean getisGovtVehicle() {
        return isGovtVechicle;
    }
    //////////// Validators
    
   /** Validator for CarNAme
  * @param carName
  *@return method return Boolean
     */  
     public boolean validCarName(String carName)
     {

        boolean flag = false;
        int size = carName.length();
        if (size <= 28) {
            for (int i = 0; i < size; i++)
            {
                if ((carName.charAt(i) >= 'A' && carName.charAt(i) <= 'Z') 
                    || (carName.charAt(i) >= 'a' && carName.charAt(i) <= 'z') || carName.charAt(i) == ' ' 
                        || carName.charAt(i) == '_' || carName.charAt(i) == '-') 
                {
                    flag = true;
                } 
                else 
                {
                    return false;
                }
            }
        }
        return flag;
    }
    /** Validator for make
  *@return method return Boolean
  *@param year
     */
    public boolean validMake(int year) 
    {
        boolean flag;
        String yearr = String.valueOf(year);
        if (yearr.length() == 4) 
        {
            flag = true;
        } 
        else 
        {
            return false;
        }
        return flag;
    }
   /** Validator for carNumber
  *@return method return Boolean
  *@param carNumber
     */
     public boolean validCarNumber(String carNumber) 
     {
        boolean flag = false;
        if (carNumber.length() == 11) 
        {
            if (carNumber.charAt(3) == '-' && carNumber.charAt(6) == '-')
            {
                for (int i = 0; i < 3; i++) 
                {
                    if (carNumber.charAt(i) >= 'A' && carNumber.charAt(i) <= 'Z') 
                    {
                        flag = true;
                    } else {
                        return false;
                    }
                }
                for (int i = 4; i < 6; i++) {
                    if (carNumber.charAt(i) >= '0' && carNumber.charAt(i) <= '9') {
                        flag = true;
                    } else {
                        return false;
                    }
                }
                for (int i = 7; i < 11; i++) {
                    if (carNumber.charAt(i) >= '0' && carNumber.charAt(i) <= '9') {
                        flag = true;
                    } else {
                        return false;
                    }
                }
            }
        }
        return flag;
    }
   /** Validator for DriverName
  *@return method return Boolean
  *@param name
     */  
    public boolean validDriverName(String name)
    {
        boolean flag = false;
        for (int i = 0; i < name.length(); i++)
        {
            if ((name.charAt(i) >= 'a' && name.charAt(i) <= 'z')  
                 || (name.charAt(i) >= 'A' && name.charAt(i) <= 'Z') || (name.charAt(i) == ' ')) 
            {
                flag = true;
            } else 
            {
                return false;
            }
        }
        return flag;
    }
   
    /** Validator for GovtCar
  *@return method return Boolean
  *@param govt
  */
   public boolean validGovtCar(String govt) 
   {
        boolean flag = false;
        if (govt.equals("Yes")) 
        {
            return true;
        } else 
        {
            return false;
        }
   }
    /** Validator for EngineCapacity
  *@return method return Boolean
  *@param capicaty
     */
    public boolean validatengCap(int capicaty) 
       {
        boolean flag = false;

        if (capicaty >= 600 && capicaty <= 6599) 
        {
            return true;
        }
        return flag;
    }
    /** Validator for CarSeats
  *@return method return Boolean
  *@param seats
     */
    public boolean validatCarseats(int seats) 
    {
        boolean flag = false;
        if (seats >= 2 && seats <= 10) 
        {
            return true;
        }
        return flag;
    } 
}
  
