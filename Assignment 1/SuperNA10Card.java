public class SuperNA10Card extends PhoneCard{
  //instance variables
  private final double weeklyFee = 0.50;
  private CallZone cz= new CallZone();
  //Constructor for SuperNA10 @parama no, passwd
  public SuperNA10Card(long no, int passwd){
    super(no, passwd);
    super.setBalance(10.00);
  }
   /**************
    * allowed - checks the if the zone is allowed
    * @parama zone is given to check callzone is allowed
    * returns y - if false or true
    */
  public boolean allowed(String zone){
    boolean y= false;
    if(cz.isValidZone(zone)){
      if (zone.equalsIgnoreCase("canada")){
        y = true;
      }
      else if(zone.equalsIgnoreCase("usa")){
        y= true;
      }
      else if(zone.equalsIgnoreCase("europe")){
        y= false;
      }
      else if(zone.equalsIgnoreCase("asia")){
        y= false;
      }
      else if(zone.equalsIgnoreCase("anz")){
        y= false;
      }
      else if(zone.equalsIgnoreCase("latinam")){
        y= false;
      }
      else if(zone.equalsIgnoreCase("africa")){
        y= false;
      }
      else{
        y= false;
      }
    }
    return y;
  }
   /**************
    * costPerMin find the cost per min depending on zone
    * @parama zone is used to find the callzone to assign a costpermin
    * @return x - is the costPerMin value depending on zone
    */
  public double costPerMin(String zone){
     double x= 0.0;
    if(cz.isValidZone(zone)){
      if (zone.equalsIgnoreCase("canada")){
        x= 0.05;
      }
      else if(zone.equalsIgnoreCase("usa")){
        x= 0.10;
      }
      else{
        x= 0.10;
      }
    }
    return x;
  }
  /**************
    * getsLimit of card based on the zone for SuperNA10Card
    * @parama zone - is the call zone region
    * @return x - this holds the maxiumum minute limit
    */
  public int getLimit(String zone){
    int x= 0;
    if (cz.isValidZone(zone)){
      if (zone.equalsIgnoreCase("canada")){
        x= (int)(bal / this.costPerMin(zone));
      }
      else if(zone.equalsIgnoreCase("usa")){
        x= (int)(bal / this.costPerMin(zone));
      }
      else if(zone.equalsIgnoreCase("europe")){
        x= (int)(bal / this.costPerMin(zone));
      }
      else if(zone.equalsIgnoreCase("asia")){
        x= (int)(bal / this.costPerMin(zone));
      }
      else if(zone.equalsIgnoreCase("anz")){
        x= (int)(bal / this.costPerMin(zone));
      }
      else if(zone.equalsIgnoreCase("latinam")){
        x= (int)(bal / this.costPerMin(zone));
      }
      else if(zone.equalsIgnoreCase("africa")){
        x= (int)(bal / this.costPerMin(zone));
      }
      else{
        x= 20;
      }
    }
          return x;
  }
  /**************
    * decuctWeeklyFee subtracts the weeklyFee from balance
    * @void does not return
    */
  public void deductWeeklyFee(){
    if(super.getBalance() - weeklyFee <=0){
      bal=0;
    }
    else{
    super.setBalance(super.getBalance() - weeklyFee);
    }
  }
}