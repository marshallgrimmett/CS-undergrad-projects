class Recursion1 {
  public static void printSomething(int x) {
    if(x<1) {
      System.out.println(x);
      return;
    }
    System.out.println(x);
    printSomething(x-1);
  }

  public static void main(String[] args) {
    printSomething(4);
  }
}
