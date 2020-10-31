public class Global10Card extends PhoneCard{
  //instance variables
  private final double weeklyFee = 1.00;
  private CallZone cz= new CallZone();
  //constructor @parma no, passwd
  public Global10Card(long no, int passwd){
    super(no, passwd);
    super.setBalance(10.00);
  }
  /**************
    * allowed - checks the if the zone is allowed
    * @parama zone is given to check callzone is allowed
    * returns y - if false or true
    */
  public boolean allowed(String zone){
    if(cz.isValidZone(zone)){
      return true;
    }
    else{
      return false;
    }
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
        x= 0.07;
      }
      else if(zone.equalsIgnoreCase("usa")){
        x= 0.15;
      }
      else if(zone.equalsIgnoreCase("europe")){
        x= 0.30;
      }
      else if(zone.equalsIgnoreCase("asia")){
        x= 0.60;
      }
      else if(zone.equalsIgnoreCase("anz")){
        x= 0.45;
      }
      else if(zone.equalsIgnoreCase("latinam")){
        x= 0.45;
      }
      else if(zone.equalsIgnoreCase("africa")){
        x= 0.60;
      }
      else{
        x= 0.60;
      }
    }
    return x;
  }
  /**************
    * getsLimit of card based on the zone for Global10
    * @parama zone - is the call zone region
    * @return x - this holds the maxiumum minute limit
    */
  public int getLimit(String zone){
    int x= 0;
    if(cz.isValidZone(zone)){
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