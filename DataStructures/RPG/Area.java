import java.util.concurrent.ThreadLocalRandom;

public class Area {

  private final int MAX_NODES = 10;
  private int enemies;
  private Boolean treasure;

  public Area() {
    enemies = ThreadLocalRandom.current().nextInt(0, MAX_NODES + 1);
    // remainder = MAX_NODES - enemies;
  }

  public int getEnemies() {return enemies;}
  public Boolean isTreasure() {return treasure;}
}
