/**
 *
 * @author zumrut
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
		
		NodeList list = new NodeList();
		Node node = new Node(1, "Book");
		Node node2 = new Node(2, "Binder");
		
		list.insertAtBeginning(node);
		list.insertAtBeginning(node2);
		System.out.println("Length : "+list.size());
		
		Node node3 = new Node(3, "Glass");
        list.insertAtBeginning(node3);
        Node node4 = new Node(4, "Pen");
        list.insertAtBeginning(node4);
		System.out.println("Length : "+list.size());
                
        System.out.println("List with all elements: ");
        list.iterate();
                
        list.removeFromBeginning();
        System.out.println("Length : "+list.size());
        System.out.println("List with root removed: ");
        list.iterate();

	}

    
}
