import java.util.Scanner;
import java.io.Reader;
import java.io.FileReader;

public class Main{
  public static void main(String [ ] args) {
    String filename = "data.txt";
    BSTree tree = new BSTree(63);
    System.out.println(tree.depth());
    tree.add(91);
    System.out.println(tree.depth());
    tree.add(52);
    System.out.println(tree.depth());
    tree.add(53);
    System.out.println(tree.depth());
    tree.add(19);
    System.out.println(tree.depth());
    tree.add(1);
    System.out.println(tree.depth());
    tree.add(92);
    System.out.println(tree.depth());
    
    
    
    /*tree.find(63).print();
    tree.find(52).print();
    tree.find(92).print();
    tree.find(1).print();
    tree.find(19).print();
    tree.find(53).print();
    tree.find(91).print();
    System.out.println(tree.find(5));*/
    /*System.out.println(tree.hasParent());
    System.out.println(tree.hasLeft());
    System.out.println(tree.hasRight());*/
    //tree.inOrder();

    
    
    
    try
    {
      Scanner scanner = new Scanner(new FileReader(filename));

      while (scanner.hasNext())
      {
        //System.out.println(scanner.nextInt());
      }
      scanner.close();
    }
    catch (Exception e)
    {
      System.err.format("Exception occurred trying to read '%s'.", filename);
      e.printStackTrace();
    }
  }
  
  
}