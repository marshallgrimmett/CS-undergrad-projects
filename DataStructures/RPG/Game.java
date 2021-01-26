import java.io.IOException;
import java.io.*;

public class Game {

  public static void main(String[] args) {
    System.out.println("Please resize your window to 48x12.");
    System.out.println("Hit ENTER to continue.");
    try {System.in.read();}
    catch (Exception ex) {}
    Map map = new Map('$');
    Area area;
    map.printMap();
    map.keyPress();
    // Main Loop
    while (!map.gameOver()) {
      // Load the area
      area = new Area();
      // System.out.println("Trees: " + area.getTrees());
      // System.out.println("Ore: " + area.getOre());
      // System.out.println("Plants: " + area.getPlants());
      // System.out.println("Enemies: " + area.getEnemies());
      // System.out.println("Treasure: " + area.isTreasure());
      // System.out.println("Occurence: " + area.isOccurence());
      map.printMap();
      map.keyPress();
    }
  }
}
