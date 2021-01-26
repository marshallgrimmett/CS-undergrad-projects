/* Client.java
 * Author: Marshall Grimmett
 * Date: 2/5/2017
 * Description: This program contains testing methods for the Linked list class.
 */
public class Client {

	public static void main(String[] args) {
		// Create our list for testing
		LinkedList list = new LinkedList();
		
		System.out.println("***** Testing the printForward method *****\n");
		testPrintForward(list);
		
		// Clear the list
		// Not the same as the destroy method
		list = new LinkedList();

		System.out.println("\n***** Testing the add method *****\n");
		testAdd(list);
		
		System.out.println("\n***** Testing the find method *****\n");
		testFind(list);
		
		System.out.println("\n***** Testing the printBackward method *****\n");
		testPrintBackward(list);
		
		System.out.println("\n***** Testing the remove method *****\n");
		testRemove(list);
		
		System.out.println("\n***** Testing the destroy method *****\n");
		testDestroy(list);
	}
	
	// ############################################################################
	// test the remove method
	public static void testRemove(LinkedList list) {
		list.remove("3");
		list.printForward();
	}
	
	// ############################################################################
	// test the destroy method
	public static void testDestroy(LinkedList list) {
		list.destroy();
		list.printForward();
	}
	
	// ############################################################################
	// test the printForward method
	// this was implemented before the add function
	// this also tests our addAtHead method
	public static void testPrintForward(LinkedList list) {
		// add the nodes in manually so we can test our printing method
		Node n1 = new Node("4");
		list.addAtHead(n1);
		Node n2 = new Node("3");
		list.addAtHead(n2);
		Node n3 = new Node("2");
		list.addAtHead(n3);
		Node n4 = new Node("1");
		list.addAtHead(n4);
		
		// print the list
		list.printForward();
	}
	
	// ############################################################################
	// test the printBackward method
	public static void testPrintBackward(LinkedList list) {
		list.printBackward();
	}

	// ############################################################################
	// test the add method
	// the printForward method must be working prior to using this method
	// this also tests our addAtTail method
	public static void testAdd(LinkedList list) {
		Node n1 = new Node("1");
		Node n2 = new Node("2");
		Node n3 = new Node("3");
		Node n4 = new Node("4");
		
		// add to empty list
		list.add(n2);
		
		// add to end of list
		list.add(n4);
		
		// add in the middle
		list.add(n3);
		
		// add at the head
		list.add(n1);
		
		list.printForward();
		System.out.println("Size: " + list.getSize());
	}

	// ############################################################################
	// test the find method
	// add method must work prior to using this method
	public static void testFind(LinkedList list) {
		testFind("hi", list);
		testFind("3", list);
	}
	
	// helper for the testFind method
	private static void testFind(String s, LinkedList list) {
		if (list.find(s) != null)
			System.out.println("found the string :)");
		else
			System.out.println("we did not find the string :(");
	}
}
