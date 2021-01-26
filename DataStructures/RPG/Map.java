/*
Your shell height needs to be equal to sizeY + 2, so the height of your map + 2 lines
The width should be no less than 48
*/

import java.io.IOException;
import java.io.*;

public class Map {

  private final int sizeX = 30;
  private final int sizeY = 10;
  private char[][] map = new char[sizeX][sizeY];
  private char you;
  private char area;
  private int youX;
  private int youY;
  private final int marshallTownX = 7;
  private final int marshallTownY = 7;
  private final int grimmettTownX = 10;
  private final int grimmettTownY = 2;
  private final int deathValleyX = 27;
  private final int deathValleyY = 3;

  public Map(char you) {
    for (int i = 0; i < sizeY; i++) {
      for (int j = 0; j < sizeX; j++) {
        if (j == 0 || j == 29)
          if (i == 0 || i == 9)
            map[j][i] = '+';
          else
            map[j][i] = '|';
        else if (i == 0 || i == 9)
          map[j][i] = '~';
        else
          map[j][i] = ' ';
      }
    }
    this.you = you;
    area = ' ';
    youX = 1;
    youY = 1;
    map[youX][youY] = you;
    map[marshallTownX][marshallTownY] = 'M';
    map[grimmettTownX][grimmettTownY] = 'G';
    map[deathValleyX][deathValleyY] = '?';
  }

  public Boolean gameOver() {
    if (map[youX][youY] == map[deathValleyX][deathValleyY]) {
      printMap();
      System.out.println("Game Over!");
      return true;
    }
    else
      return false;
  }

  public void printMap() {
    for (int i = 0; i < sizeY; i++) {
      for (int j = 0; j < sizeX; j++) {
        System.out.print(map[j][i]);
      }
      System.out.println();
    }
  }

  public void keyPress() {
    int key;
    BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
    try {
      key = in.read();
      switch (key) {
        case 119: case 87:
          if (youY != 1) {
            map[youX][youY] = area;
            youY--;
            map[youX][youY] = you;
          }
          else
            System.out.println("Sorry, you can't swim :(");
          break;
        case 115: case 83:
          if (youY != sizeY - 2) {
            map[youX][youY] = area;
            youY++;
            map[youX][youY] = you;
          }
          else
            System.out.println("Sorry, you can't swim :(");
          break;
        case 97: case 65:
          if (youX != 1) {
            map[youX][youY] = area;
            youX--;
            map[youX][youY] = you;
          }
          else
            System.out.println("Sorry, you can't swim :(");
          break;
        case 100: case 68:
          if (youX != sizeX - 2) {
            map[youX][youY] = area;
            youX++;
            map[youX][youY] = you;
          }
          else
            System.out.println("Sorry, you can't swim :(");
          break;
        case 32:
          System.out.println("You jumped. Good job.");
          break;
        case 27:
          map[youX][youY] = map[deathValleyX][deathValleyY];
        default:
          System.out.println("W: up, S: down, A: left, D: right, ESC: end game");
          break;
      }
    }
    catch (Exception ex) {
      System.out.println("some error...");
    }
  }
}
