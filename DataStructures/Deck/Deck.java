import java.util.Random;

public class Deck {

  private Card[] deck = new Card[52];
  private final int MAX_CARDS = 52;
  private Card top = null;

  public Deck() {
    populate();
  }

  public void populate() {
    int suit;
    int cardVal;
    Card newCard;
    for (int i = 0; i < MAX_CARDS; i++) {
      suit = i / 13;
      cardVal = i % 13 + 1;
      newCard = new Card(suit, cardVal);
      newCard.setNext(top);
      top = newCard;
    }
  }

  public void populateArray() {
    int suit;
    int cardVal;
    for (int i = 0; i < MAX_CARDS; i++) {
      suit = i / 13;
      cardVal = i % 13 + 1;
      deck[i] = new Card(suit, cardVal);
    }
  }

  public void addCard(Card toAdd) {
    toAdd.setNext(top);
    this.top = toAdd;
  }

  public Card removeCard() {
    Card temp = this.top;
    this.top = this.top.getNext();
    return temp;
  }

  public void shuffle() {
    populateArray();
    Random rand = new Random();
    for (int i = 51; i > 0; i--) {
      swap(i, rand.nextInt(i));
    }
    this.top = null;
    for (int i = 0; i < 52; i++) {
      addCard(deck[i]);
    }
  }

  public void swap(int a, int b) {
    Card temp = deck[a];
    deck[a] = deck[b];
    deck[b] = temp;
  }

  public void printDeck() {
    Card runner = top;
    while (runner != null) {
      runner.printCard();
      runner = runner.getNext();
    }
  }

  public void printDeckArray() {
    for (int i = 0; i < MAX_CARDS; i++) {
      deck[i].printCard();
    }
  }
}
