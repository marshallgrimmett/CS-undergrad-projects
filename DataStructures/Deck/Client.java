public class Client {

  public static void main(String[] args) {
    Deck d1 = new Deck();
    d1.populate();
    // d1.printDeck ();
    d1.shuffle();
    d1.printDeck();
  }
}
