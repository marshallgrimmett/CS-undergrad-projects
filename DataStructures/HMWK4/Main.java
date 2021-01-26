
public class Main {
	// Main
	public static void main(String[] args) {
		System.out.println("###################################################\nTesting Push:");
		testPush();
		System.out.println("\n###################################################\nTesting Pop:");
		testPop();
		System.out.println("\n###################################################\nTesting Peek:");
		testPeek();
		System.out.println("\n###################################################\nTesting Enqueue:");
		testEnqueue();
		System.out.println("\n###################################################\nTesting Dequeue:");
		testDequeue();
		System.out.println("\n###################################################\nTesting Stack to Queue:");
		TestStackToQueue();
		System.out.println("\n###################################################\nTesting Stack to Stack:");
		TestStackToStack();
		System.out.println("\n###################################################\nTesting Queue to Stack:");
		TestQueueToStack();
	}
	
	//##################################################################################

	public static Queue StackToQueue(Stack s1) {
		Queue q1 = new Queue();
		Node runner = s1.peek();
		Node newNode;
		while (runner != null) {
			newNode = new Node(runner);
			q1.enqueue(newNode);
			runner = runner.getNext();
		}
		return q1;
	}
	
	//##################################################################################
	
	public static Stack StackToStack(Stack s1) {
		Stack s2 = new Stack();
		Stack s3 = new Stack();
		Node runner = s1.peek();
		Node newNode;
		while (runner != null) {
			newNode = new Node(runner);
			s2.push(newNode);
			runner = runner.getNext();
		}
		runner = s2.peek();
		while (runner != null) {
			newNode = new Node(runner);
			s3.push(newNode);
			runner = runner.getNext();
		}
		return s3;
	}
	
	//##################################################################################
	
	public static Stack QueueToStack(Queue q1) {
		Stack s1 = new Stack();
		Stack s2 = new Stack();
		Node runner = q1.peek();
		Node newNode;
		while (runner != null) {
			newNode = new Node(runner);
			s1.push(newNode);
			runner = runner.getNext();
		}
		runner = s1.peek();
		while (runner != null) {
			newNode = new Node(runner);
			s2.push(newNode);
			runner = runner.getNext();
		}
		return s2;
	}
	
	// Tests
	
	//##################################################################################

	public static void TestStackToQueue() {
		Stack s1 = new Stack();
		System.out.println("adding node...");
		s1.push(new Node(1));
		System.out.println("adding node...");
		s1.push(new Node(2));
		System.out.println("adding node...");
		s1.push(new Node(3));
		System.out.println("adding node...");
		s1.push(new Node(4));
		System.out.println("Printing stack...");
		s1.print();
		System.out.println("Moving stack to queue...");
		Queue q1 = StackToQueue(s1);
		System.out.println("Printing stack...");
		s1.print();
		System.out.println("Printing queue...");
		q1.print();
	}
	
	//##################################################################################

	public static void TestStackToStack() {
		Stack s1 = new Stack();
		System.out.println("adding node...");
		s1.push(new Node(1));
		System.out.println("adding node...");
		s1.push(new Node(2));
		System.out.println("adding node...");
		s1.push(new Node(3));
		System.out.println("adding node...");
		s1.push(new Node(4));
		System.out.println("Printing stack 1...");
		s1.print();
		System.out.println("Moving stack 1 to stack 2...");
		Stack s2 = StackToStack(s1);
		System.out.println("Printing stack 1...");
		s1.print();
		System.out.println("Printing stack 2...");
		s2.print();
	}
	
	//##################################################################################

	public static void TestQueueToStack() {
		Queue q1 = new Queue();
		System.out.println("adding node...");
		q1.enqueue(new Node(1));
		System.out.println("adding node...");
		q1.enqueue(new Node(2));
		System.out.println("adding node...");
		q1.enqueue(new Node(3));
		System.out.println("adding node...");
		q1.enqueue(new Node(4));
		System.out.println("Printing queue...");
		q1.print();
		System.out.println("Moving queue to stack...");
		Stack s1 = QueueToStack(q1);
		System.out.println("Printing queue...");
		q1.print();
		System.out.println("Printing stack...");
		s1.print();
	}
	
	//##################################################################################

	public static void testEnqueue() {
		Queue q1 = new Queue();
		System.out.println("adding node...");
		q1.enqueue(new Node(1));
		System.out.println("adding node...");
		q1.enqueue(new Node(2));
		System.out.println("adding node...");
		q1.enqueue(new Node(3));
		System.out.println("adding node...");
		q1.enqueue(new Node(4));
		System.out.println("Printing List...");
		q1.print();
	}
	
	//##################################################################################

	public static void testDequeue() {
		Queue q1 = new Queue();
		System.out.println("adding node...");
		q1.enqueue(new Node(1));
		System.out.println("adding node...");
		q1.enqueue(new Node(2));
		System.out.println("adding node...");
		q1.enqueue(new Node(3));
		System.out.println("adding node...");
		q1.enqueue(new Node(4));
		System.out.println("Dequeue node...");
		q1.dequeue();
		System.out.println("Printing List...");
		q1.print();
		System.out.println("Dequeue all nodes...");
		q1.dequeue();
		q1.dequeue();
		q1.dequeue();
		System.out.println("Printing List... (but it's empty.)");
		q1.print();
	}
	
	//##################################################################################

	public static void testPush() {
		Stack s1 = new Stack();
		// Test push and print results
		System.out.println("adding node...");
		s1.push(new Node(1));
		System.out.println("adding node...");
		s1.push(new Node(2));
		System.out.println("adding node...");
		s1.push(new Node(3));
		System.out.println("adding node...");
		s1.push(new Node(4));
		System.out.println("Printing List...");
		s1.print();
	}
	
	//##################################################################################

	public static void testPop() {
		Stack s1 = new Stack();
		// Add nodes
		System.out.println("adding node...");
		s1.push(new Node(1));
		System.out.println("adding node...");
		s1.push(new Node(2));
		System.out.println("adding node...");
		s1.push(new Node(3));
		System.out.println("adding node...");
		s1.push(new Node(4));
		// Test pop
		System.out.println("Popping...");
		s1.pop();
		System.out.println("Printing List...");
		s1.print();
		// Pop more nodes
		System.out.println("Popping all nodes...");
		s1.pop();
		s1.pop();
		s1.pop();
		System.out.println("Printing List... (but it's empty.)");
		s1.print();
		// Pop with empty stack
		s1.pop();
	}
	
	//##################################################################################

	public static void testPeek() {
		Stack s1 = new Stack();
		// Test empty list
		s1.peek();
		// Add nodes
		System.out.println("adding node...");
		s1.push(new Node(1));
		System.out.println("adding node...");
		s1.push(new Node(2));
		System.out.println("adding node...");
		s1.push(new Node(3));
		System.out.println("adding node...");
		s1.push(new Node(4));
		// Test peek
		System.out.println("Peeking...");
		System.out.println(s1.peek().getData());
		// Pop one node and test again
		System.out.println("Popping...");
		s1.pop();
		System.out.println("Peeking...");
		System.out.println(s1.peek().getData());
	}
}
