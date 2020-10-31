public class CardTable {
    // constructor methods

    public CardTable() {
        ct = new PhoneCard[TABLE_LENGTH];
        ctSize = 0;
        current = 0;
    }

    // specialized methods

    public boolean add(PhoneCard card) {
        if (ctSize == TABLE_LENGTH) return false;
        if (get(card.getNumber()) != null) return false;
        ct[ctSize] = card;
        ctSize++;
        return true;
    }
    /*
     * get - gets the card in the array ct
     * @parama no - gets the card according to the number
     * @returns card2 if the PhoneCard is found or null if not
     */
    public PhoneCard get(long no) {
      if(ctSize== 0){
        return null;
      }
      else if(ctSize!= 0){
        PhoneCard card2= null;
        PhoneCard card =this.first();
        while (card != null) {
          if(card.getNumber()== no){
            card2= card;
          }
          card = this.next();
        }
        current =0;
        return card2;
      }
      else{
        return null;
      }
    }
    /*
     * if the array is size 0 then @return null
     * otherwise return the current PhoneCard
     */
    public PhoneCard first() {
        if (ctSize == 0) {
            return null;
        } else {
            current = 0;
            return ct[current];
        }
    }

    public PhoneCard next() {
        if (current + 1 == ctSize) {
            return null;
        } else {
            current++;
            return ct[current];
        }
    }


    // instance variables/attributes/fields

    private PhoneCard[] ct;
    private int ctSize;
    private int current;

    // class/static variables/attributes/fields

    private static int TABLE_LENGTH = 20;

}