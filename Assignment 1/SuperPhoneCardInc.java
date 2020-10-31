/**************************************************************************
  * 
  ITEC 2610 Assignment 1
  * @edited by: Christopher Nguyen
  * @date: Oct, 08, 2019
  * 
  ****************************************************************************/
import java.util.Scanner;
import java.text.*;
public class SuperPhoneCardInc {
  public static void main(String[] args) {
    CardTable ct = new CardTable();
    Scanner in = new Scanner(System.in);
    String line = null;
    boolean done = false;
    DecimalFormat df = new DecimalFormat("##0.00");
    if (! in .hasNextLine()) {
      done = true;
    } else {
      line = in .nextLine();
    }
    if (!done && line.length() >= 4 && line.substring(0, 4).equals("quit")) {
      done = true;
    }
    while (!done) {
      System.out.println("Input: " + line);
      Scanner inl = new Scanner(line);
      String command = "";
      if (inl.hasNext()) {
        command = inl.next();
      }
      if (command.equals("add")) {
        boolean invalidArgs = false;
        long no = 0;
        int passwd = 0;
        String cardType = null;
        if (inl.hasNextLong()) {
          no = inl.nextLong();
        } else {
          invalidArgs = true;
        }
        if (!invalidArgs && inl.hasNextInt()) {
          passwd = inl.nextInt();
        } else {
          invalidArgs = true;
        }
        if (!invalidArgs && inl.hasNext()) {
          cardType = inl.next();
        } else {
          invalidArgs = true;
        }
        if (!invalidArgs && (no <= 0 || passwd <= 0)) {
          invalidArgs = true;
        }
        PhoneCard card = null;
        if (!invalidArgs && cardType.equals("SuperNA10")) {
          card = new SuperNA10Card(no, passwd);
        } else if (!invalidArgs && cardType.equals("Global10")) {
          card = new Global10Card(no, passwd);
        } else if (!invalidArgs && cardType.equals("Global25")) {
          card = new Global25Card(no, passwd);
        } else {
          invalidArgs = true;
        }
        if (invalidArgs) {
          System.out.println("Error: invalid arguments for add command");
        } else if (ct.get(no) != null) {
          System.out.println("Error: card no " + no + " already exists");
        } else if (!ct.add(card)) {
          System.out.println("Error: card table full");
        } else {
          System.out.println("Result: added card " + no);
        }
      } else if (command.equals("getBalance")) {
        boolean invalidArgs = false;
        long no = 0;
        int passwd = 0;
        if (inl.hasNextLong()) {
          no = inl.nextLong();
        } else {
          invalidArgs = true;
        }
        if (!invalidArgs && inl.hasNextInt()) {
          passwd = inl.nextInt();
        } else {
          invalidArgs = true;
        }
        if (!invalidArgs && (no <= 0 || passwd <= 0)) {
          invalidArgs = true;
        }
        if (invalidArgs) {
          System.out.println("Error: invalid arguments for getBalance command");
        } else {
          PhoneCard card = ct.get(no);
          if (card == null) {
            System.out.println("Error: card no " + no + " does not exist");
          } else if (card.getPassword() != passwd) {
            System.out.println("Error: password " + passwd + " incorrect");
          } else {
            System.out.printf("Result: card "+ no+" balance is "+df.format(card.getBalance())+"%n");
          }
        }
      //local variables no, passwd and zone used to hold input of user. cz to check callzone.
      } else if (command.equals("getLimit")) {
        boolean invalidArgs = false;
        long no = 0;
        int passwd = 0;
        String zone= null;
        CallZone cz= new CallZone();
        if (inl.hasNextLong()) {
          no = inl.nextLong();
        } else {
          invalidArgs = true;
        }
        if (!invalidArgs && inl.hasNextInt()) {
          passwd = inl.nextInt();
        } else {
          invalidArgs = true;
        }
        if (!invalidArgs && inl.hasNext()) {
          zone = inl.next();
        } else {
          invalidArgs = true;
        }
        if (!invalidArgs && (no <= 0 || passwd <= 0 || !(cz.isValidZone(zone)))) {
          invalidArgs = true;
        }
        if (invalidArgs) {
          System.out.println("Error: invalid arguments for getLimit command");
        } 
        else {
          PhoneCard card = ct.get(no);
          if (card == null) {
            System.out.println("Error: card no " + no + " does not exist");
          } else if (card.getPassword() != passwd) {
            System.out.println("Error: password " + passwd + " incorrect");
          } else if (!card.allowed(zone)){
            System.out.println("Error: card " + no +" not allowed for zone "+ zone);
          }
          else {
            System.out.println("Result: card "+ no + " limit for zone "+ zone +" is "+card.getLimit(zone)+" minutes");
          }
        }
      }
      //local variables like command.equals(getLimit) but uses min to repersent minutes to be used by user.
      else if (command.equals("charge")) { 
        boolean invalidArgs = false;
        long no = 0;
        int passwd = 0;
        String zone= null;
        int min= 0;
        CallZone cz= new CallZone();
        if (inl.hasNextLong()) {
          no = inl.nextLong();
        } else {
          invalidArgs = true;
        }
        if (!invalidArgs && inl.hasNextInt()) {
          passwd = inl.nextInt();
        } else {
          invalidArgs = true;
        }
        if (!invalidArgs && inl.hasNext()) {
          zone = inl.next();
        } else {
          invalidArgs = true;
        } if (!invalidArgs && inl.hasNextInt()) {
          min = inl.nextInt();
        }
        if (!invalidArgs && (no <= 0 || passwd <= 0 || min<= 0 || !(cz.isValidZone(zone)))) {
          invalidArgs = true;
        }
        if (invalidArgs) {
          System.out.println("Error: invalid arguments for charge command");
        } else {
          PhoneCard card = ct.get(no);
          if (card == null) {
            System.out.println("Error: card no " + no + " does not exist");
          } else if (card.getPassword() != passwd) {
            System.out.println("Error: password " + passwd + " incorrect");
          } else if (!card.allowed(zone)){
            System.out.println("Error: card " + no +" not allowed for zone "+ zone);
          } else if ((card.getBalance()-(min*card.costPerMin(zone)))>=0){
            double x= ((min*card.costPerMin(zone)));
            card.charge(min ,zone);
            System.out.printf("Result: card "+ no + " charged "+ df.format(x) +", new balance is "
                                +df.format(card.getBalance()) +"%n");
          }
          else {
            System.out.println("Error: card "+ no+ " limit for zone " +zone + " is "+ card.getLimit(zone) +" minutes");
          }
        }
      }
      else if (command.equals("deductWeeklyFee")) {
        PhoneCard card = ct.first();
        while (card != null) {
          card.deductWeeklyFee();
          System.out.printf("Result: card %d charged weekly fee%n",
                            card.getNumber());
          card = ct.next();
        }
        System.out.println("Result: weekly fees deducted");
      } else if (command.equals("printAll")) {
        PhoneCard card = ct.first();
        while (card != null) {
          System.out.println("Result: card no "+card.getNumber()+ " has a balance of "+df.format(card.getBalance()));
          card = ct.next();
        }
        System.out.println("Result: all cards printed");
      } else {
        System.out.println("Error: command invalid");
      }
      if (! in .hasNextLine()) {
        done = true;
      } else {
        line = in .nextLine();
      }
      if (!done && line.length() >= 4 && line.substring(0, 4).equals("quit")) {
        done = true;
      }
    }
  }
}