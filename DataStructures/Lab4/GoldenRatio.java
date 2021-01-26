public class GoldenRatio {

  private float num;

  public GoldenRatio() {}

  public float compute(float num) {
    if(num == 0) {
      return 1;
    } else if (num >= 0) {
      return (1 + 1 / compute(num - 1));
    } else
      return -1;

  }
}
