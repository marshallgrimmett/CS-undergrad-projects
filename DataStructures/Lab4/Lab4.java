public class Lab4 {

  public static void main(String[] args) {
    System.out.println(calcExponent(2, 3));
    GoldenRatio g1 = new GoldenRatio();
    System.out.println(g1.compute(9999));
    int[] array = {1,2,3,4,5};
    System.out.println(isMember(7, array));
  }


// Part 1
  public static int calcExponent(int base, int exp) {
    int ans = base;
    return calcExponent(base, exp, ans);
  }

  public static int calcExponent(int base, int exp, int ans) {
    if(exp == 1)
      return ans;
    else {
      exp--;
      return calcExponent(base, exp, (ans * base));
    }
  }


// Part 3
  public static Boolean isMember(int num, int[] array) {
    return isMember(num, array, 0);
  }

  public static Boolean isMember(int num, int[] array, int count) {
    if(count >= array.length) {
      return false;
    }
    else if(array[count] == num) {
      return true;
    }
    else {
      count++;
      return isMember(num, array, count);
    }
  }
}
