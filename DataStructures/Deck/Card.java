public class Card {

  private int suit = 0;
  private int cardVal = 0;
  private Card nextCard;

  public Card(int suit, int cardVal) {
    this.suit = suit;
    this.cardVal = cardVal;
    nextCard = null;
  }

  public Card getNext() {
    return this.nextCard;
  }

  public void setNext(Card nextCard) {
    this.nextCard = nextCard;
  }

  public void printCard() {
    String s;
    switch (this.cardVal) {
      case 1: s = "Ace of "; break;
      case 11: s = "Jack of "; break;
      case 12: s = "Queen of "; break;
      case 13: s = "King of "; break;
      default: s = this.cardVal + " of "; break;
    }
    switch (this.suit) {
      case 0: s += "Hearts"; break;
      case 1: s += "Diamonds"; break;
      case 2: s += "Spades"; break;
      case 3: s += "Clubs"; break;
      default: break;
    }
    System.out.println(s);
  }
}
