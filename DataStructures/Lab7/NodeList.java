/**
 *
 * @author zumrut
 */
public class NodeList {
    private int size = 0;
    private Node root = null;

    /*
     * It has to take a new Node and add that to the beginning of the linked list.
     * If the list is empty, assign it as the "root".
     * @Param - Node
     */
    public void insertAtBeginning(Node newNode) {
      if (root == null) {
        root = newNode;
        size++;
      } else {
        Node temp = root;
        root = newNode;
        newNode.setNext(temp);
        size++;
      }
    }


    /*
     * It has to take a Node and remove that node if you find it in the list
     * from the existing nodes otherwise dont do anything.
     *
     * @return void (if the list is empty, throw an error)
     */
    public void removeFromBeginning(){
      if (root == null) {
        throw new RuntimeException("the list is empty");
      } else {
        root = root.getNext();
        size--;
      }
    }

    /*
     * It has to return the size of the NodeList
     *
     * @return size
     */
    public int size() {
        return size;
    }

    /**
     * Start with the head and traverse, print till you reach null.
     */
    public void iterate(){
      if (root == null) {
        throw new RuntimeException("the list is empty");
      } else {
        System.out.println("Iterate forward...");
        Node temp = root;
        while (temp != null) {
          System.out.println("ID: " + temp.getId() + "; Name: " + temp.getName());
          temp = temp.getNext();
        }
      }

    }

}
