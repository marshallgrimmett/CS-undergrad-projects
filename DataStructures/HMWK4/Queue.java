
public class Queue {
	private Node front = null;
	private Node back = null;
	private int size = 0;
	
	// Methods
	
	public int getSize() {return size;}
	
	public Boolean isEmpty() {
		return size == 0;
	}
	
	public void enqueue(Node newNode) {
		if (isEmpty()) {
			front = newNode;
			back = newNode;
		} else {
			back.setNext(newNode);
			back = newNode;
		}
		size++;
	}
	
	public Node dequeue() {
		if (isEmpty())
			return null;
		Node temp = front;
		front = front.getNext();
		size--;
		return temp;
	}
	
	public Node peek() {
		return front;
	}
	
	public void print() {
		Node runner = front;
		while (runner != null) {
			System.out.println(runner.getData());
			runner = runner.getNext();
		}
	}
}
