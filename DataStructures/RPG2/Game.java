import java.io.IOException;
import java.io.*;

/*
 * I made this game using mac and the terminal, so there has been no testing on and other OS.
 */
public class Game {

  public static void main(String[] args) {
    System.out.println("Please resize your window to 48x12.");
    System.out.println("Hit ENTER to continue.");
    
    // Read in user keystroke
    try {System.in.read();}
    catch (Exception ex) {}

    // Create the map
    Map map = new Map('$');
    map.printMap();
    map.keyPress();
    
    // Main Loop
    while (!map.gameOver()) {
      map.printMap();
      map.keyPress();
    }
  }
}
