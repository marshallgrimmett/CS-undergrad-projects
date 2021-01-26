class Recursion2 {
  public static int recursive(int x) {
    if(x==0) {
      return 1;
    }
    return 3*recursive(x-1);
  }

  public static void main(String[] args) {
    System.out.println(recursive(4));
  }
}
