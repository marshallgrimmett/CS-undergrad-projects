import java.util.Random;

public class Stack{
  // Properties
  protected Card top = null;

  // Constructor: Using default constructor
  
  // Getter/Setter Methods
  
  public Card peek() {
    return this.top;
  }
  
  /* Traverses & prints list */
  public void print() {
    if (this.isEmpty()) {
      System.out.println("List is empty.");
    }
    else {
      Card tmp = this.top;
      while (tmp != null) {
        tmp.print();
        tmp = tmp.getNext();
      }
      System.out.println("");
    }
  }
  
  public boolean isEmpty() {
    return this.top==null;
  }
  
  public void addCard(Card newCard) {
    newCard.setNext(this.top);
    this.top = newCard;
  }
  
  public Card removeCard(){
    if (this.isEmpty()){
      return null;
    }
    else {
      Card tmp = this.top;
      this.top = top.getNext();
      return tmp;
    }
  }
 
  
  
  
  
  
  public void destroy() {
    this.top = null;
  }
  
  public void populateDeck() {
    for (int i = 0; i < 4; i++) {
      for (int j = 1; j <= 13; j++) {
        switch (i) {
          case 1: 
            this.addCard(new Card(j, "hearts"));
            break;
          case 2:
            this.addCard(new Card(j, "diamonds"));
            break;
          case 3:
            this.addCard(new Card(j, "clubs"));
            break;
          case 0:
            this.addCard(new Card(j, "spades"));
            break;
        }
      }
    }
  }
  
  public void shuffle() {
    Random rand = new Random();
    // create temporary array
    Card[] tmp = new Card[52];
    for (int i = 0; i < 52; i++) {
      tmp[i] = null;
    }
    // Randomize cards into array
    while (!this.isEmpty()) {
      int index = rand. nextInt(52);
      if (tmp[index] == null)
        tmp[index] = this.removeCard();
      else {
        while (tmp[index] != null) {
          index++;
          if (index > 51) index = 0;
        }
        tmp[index] = this.removeCard();
      }
    }
    // put result into deck
    for (int i = 0; i < 52; i++) {
      if (tmp[i] != null)
        this.addCard(tmp[i]);
    }
  }
}