
public class Stack {
	private Node top = null;
	private int size = 0;
	
	// Methods
	
	public int getSize() {return size;}
	
	public Boolean isEmpty() {
		return size == 0;
	}
	
	public void push(Node newNode) {
		newNode.setNext(top);
		top = newNode;
		size++;
	}
	
	public Node pop() {
		if (isEmpty())
			return null;
		Node temp = top;
		top = top.getNext();
		size--;
		return temp;
	}
	
	public Node peek() {
		return top;
	}
	
	public void print() {
		Node runner = top;
		while (runner != null) {
			System.out.println(runner.getData());
			runner = runner.getNext();
		}
	}
}
