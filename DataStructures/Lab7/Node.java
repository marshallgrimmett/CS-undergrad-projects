/**
 *
 * @author zumrut
 */
public class Node {

	private int id = 0;
	private String name = "";
	private Node next;
	
	public Node(int id, String name) {
		this.id = id;
		this.name = name;
		this.next = null;
	}
	
	public Node getNext() {
		return next;
	}

	public void setNext(Node node) {
		this.next = node;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	public String toString() {
		return "ID : "+this.id+" Name : "+this.name;
	}
}
