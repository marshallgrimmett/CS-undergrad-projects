/* Node.java
 * Author: Marshall Grimmett
 * Date: 2/5/2017
 * Description: This class constructs a node that holds a string and has pointers
 * 				to the next and previous nodes.
 * Constructors: Node(String newData) - constructs a new node with a specified string
 * 				 Node(String newData, Node nextNode) - constructs a node with specified string and pointer to the next node.
 * Methods: 
 */
public class Node {
	// PDMs
	private String data;
	private Node next;
	private Node previous;

	// Non default constructor
	public Node(String newData) {
		newData.toLowerCase();
		data = newData;
		next = null;
		previous = null;
	}
	
	public String getData() {
		return data;
	}
	
	public Node getNext() {
		return next;
	}
	
	public Node getPrevious() {
		return previous;
	}
	
	public void setData(String data) {
		this.data = data;
	}
	
	public void setNext(Node next) {
		this.next = next;
	}
	
	public void setPrevious(Node previous) {
		this.previous = previous;
	}

}
