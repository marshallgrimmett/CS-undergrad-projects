// Testing client for Babylonian class
public class Client {

  public static void main(String[] args) {
    // Tests the Babylonian Class
    Babylonian b1 = new Babylonian(80, 5);
    Babylonian b2 = new Babylonian(81, 5);
    System.out.println(b1.sqrt());
    System.out.println(b2.sqrt());

    // Test negatives
    Babylonian b3 = new Babylonian(-80, 5);
    Babylonian b4 = new Babylonian(81, -5);
    System.out.println(b3.sqrt());
    System.out.println(b4.sqrt());
  }
}
