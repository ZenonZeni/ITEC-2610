public abstract class PhoneCard{
  //Instance Variables
  long no=0;
  int passwd= 0;
  double bal= 0;
  //Constructor @para no1, passwd1
  public PhoneCard(long no1, int passwd1){
    no = no1;
    passwd = passwd1;
  }
  //accessor method @returns no
  public long getNumber(){
    return no;
  }
  //accessor method @returns passwd
  public int getPassword(){
    return passwd;
  }
  //accessor method @returns bal
  public double getBalance(){
    return bal;
  }
  //mutator method @void
  public void setBalance(double bal2){
    bal = bal2;
  }
  //Abstract method does not have body
  public abstract boolean allowed(String zone);
  //Abstract method does not have body
  public abstract double costPerMin(String zone);
  /*
   * getLimit gets the minute limit according to zone
   * @parama zone - according to zone find the minutes
   * @return minutes - according to the limit for your balance and zone
   */
  public int getLimit(String zone){
    int minutes= 0;
    if (zone.equalsIgnoreCase("canada")){
      minutes= (int)(bal / this.costPerMin(zone));
    }
    if(zone.equalsIgnoreCase("usa")){
      minutes= (int)(bal / this.costPerMin(zone));
    }
    if(zone.equalsIgnoreCase("europe")){
      minutes= (int)(bal / this.costPerMin(zone));
    }
    if(zone.equalsIgnoreCase("asia")){
      minutes= (int)(bal / this.costPerMin(zone));
    }
    if(zone.equalsIgnoreCase("anz")){
      minutes= (int)(bal / this.costPerMin(zone));
    }
    if(zone.equalsIgnoreCase("latinam")){
      minutes= (int)(bal / this.costPerMin(zone));
    }
    if(zone.equalsIgnoreCase("africa")){
      minutes= (int)(bal / this.costPerMin(zone));
    }
    return minutes;
  }
  /*
   * charge - charges the balance according to the costPerMin of different types
   * @parama zone - used to check zone to find costPerMin for zone
   * @returns true or false according if it was charged
   */
  public boolean charge(int minutes,String zone){
    if (zone.equalsIgnoreCase("canada")){
      if((bal - (minutes*this.costPerMin(zone)))>=0 ){
        bal= bal - (minutes*costPerMin(zone));
        return true;
      }
      else{
        return false;
      }
    }
    else if(zone.equalsIgnoreCase("usa")){
      if((bal - (minutes*this.costPerMin(zone)))>= 0){
        bal= bal - (minutes*this.costPerMin(zone));
        return true;
      }
      else{
        return false;
      }
    }
    else if(zone.equalsIgnoreCase("europe")){
      if((bal - (minutes*this.costPerMin(zone)))>= 0){
        bal= bal - (minutes*this.costPerMin(zone));
        return true;
      }
      else{
        return false;
      }
    }
    else if(zone.equalsIgnoreCase("asia")){
      if((bal - (minutes*this.costPerMin(zone)))>= 0){
        bal= bal - (minutes*this.costPerMin(zone));
        if(this.bal<=0){
          this.bal=0;
        }
        return true;
      }
      else{
        return false;
      }
    }
    else if(zone.equalsIgnoreCase("anz")){
      if((bal - (minutes*this.costPerMin(zone)))>= 0){
        bal= bal - (minutes*this.costPerMin(zone));
        return true;
      }
      else{
        return false;
      }
    }
    else if(zone.equalsIgnoreCase("latinam")){
      if((bal - (minutes*this.costPerMin(zone)))>= 0){
        bal= bal - (minutes*this.costPerMin(zone));
        return true;
      }
      else{
        return false;
      }
    }
    else if(zone.equalsIgnoreCase("africa")){
      if((bal - (minutes*this.costPerMin(zone)))>= 0){
        bal= bal - (minutes*this.costPerMin(zone));
        return true;
      }
    }
    else if(this.bal==0){
      return false;
    }
    else{
      return false;
    }
    return false;
  }
  //Abstract method has no body
  public abstract void deductWeeklyFee();
  //outputs the card number and balance
  public String toString(){
    return "card no "+no+" has a balance of "+bal;
  }
}