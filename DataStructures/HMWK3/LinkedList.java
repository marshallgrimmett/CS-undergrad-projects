/* LinkedList.java
 * Author: Marshall Grimmett
 * Date: 2/5/2017
 * 
 * Description: This class contains constructors and methods for a linked list.
 * 				This list holds nodes with string values.
 * 				Each node has a pointer to the next node and previous node.
 * 				
 * Constructors: LinkedList() - creates an empty list of size 0.
 * 				 LinkedList(Node newNode) - creates a list with one node.
 * 
 * Methods: getSize() - returns the size of the list.
 * 			isEmpty() - returns a boolean indicating if the list is empty.
 * 			addAtHead() - adds a node before the head.
 * 			addAtTail() - adds a node after the tail.
 * 			addBefore() - adds a node before a node in the list.e
 * 			add() - adds a node alphabetically into the list.
 * 			find(String toFind) - returns a node whose value is equal to a string.
 * 			remove(String toRemove) - removes the specified string.
 * 			destroy() - resets the list.
 * 			printForward() - prints the list from head to tail.
 * 			printBackward() - prints the list from tail to head.
 */
public class LinkedList {

	// ****************************************************************************
	// PDMS
	private Node head;
	private Node tail;
	private int size;

	// ****************************************************************************
	// Constructors

	// Default
	public LinkedList() {
		head = null;
		tail = null;
		size = 0;
	}

	// Non-Default
	public LinkedList(Node newNode) {
		head = newNode;
		tail = newNode;
		size = 1;
	}

	// ****************************************************************************
	// Methods

	// Getters
	// getSize
	public int getSize() {
		return size;
	}

	// isEmpty
	public Boolean isEmpty() {
		return size == 0;
	}

	// ############################################################################
	// addAtHead
	// This is both a helper method and a method for inserting before the head
	public void addAtHead(Node newNode) {
		if (size == 0) {
			head = newNode;
			tail = newNode;
		} else {
			Node temp = head;
			head = newNode;
			newNode.setNext(temp);
			temp.setPrevious(newNode);
		}
		size++;
	}

	// ############################################################################
	// addAtTail
	// This is both a helper method for add() and can be used to insert a node at the tail.
	public void addAtTail(Node newNode) {
		if (isEmpty()) {
			head = newNode;
			tail = newNode;
		} else {
			Node temp = tail;
			tail = newNode;
			temp.setNext(newNode);
			newNode.setPrevious(temp);
		}
		size++;
	}
	
	// ############################################################################
	// addBefore
	// This is a helper for the add method only.
	// Inserts a node before the specified node.
	private void addBefore(Node toAdd, Node runner) {
		Node before = runner.getPrevious();
		runner.setPrevious(toAdd);
		toAdd.setPrevious(before);
		toAdd.setNext(runner);
		before.setNext(toAdd);
		size++;
	}

	// ############################################################################
	// add
	// Adds a node alphabetically into the list
	public void add(Node newNode) {
		// if the list is empty
		if (size == 0) {
			head = newNode;
			tail = newNode;
			size++;
		} else {
			Node temp = head;
			add(newNode, temp);
		}
	}

	// Polymorphic helper method for add
	// ONLY for readability purposes
	private void add(Node newNode, Node runner) {
		// run through the list and compare strings
		while (runner != null) {
			// compareTo: 0 = equal; 1 = greater than; -1 = less than
			// if the runner is greater than (or equal to) our new node,
			// we want to add the new node before the runner
			// otherwise, keep going until we hit the end of the list
			if (runner.getData().compareTo(newNode.getData()) >= 0) {
				// if the newNode comes before the head
				if (runner == head)
					addAtHead(newNode);
				else {
					addBefore(newNode, runner);
				}
				// we need to exit, since  we found a spot for our new node
				return;
			} else
				runner = runner.getNext();
		}
		// if we hit the end of the list
		if (runner == null)
			addAtTail(newNode);
	}

	// ############################################################################
	// remove
	// returns and removes the removed node(like cut and paste), otherwise returns null
	public Node remove(String toRemove) {
		// find the node, compare data
		Node temp = find(toRemove);
		if (temp != null) {
			temp.getPrevious().setNext(temp.getNext());
			temp.getNext().setPrevious(temp.getPrevious());
			return temp;
		} else {
			return null;
		}
	}

	// ############################################################################
	// find
	// returns a Node whose value is equal to the specified string
	// returns null if not found
	public Node find(String toFind) {
		Node runner = head;
		while (runner != null) {
			if (runner.getData().compareTo(toFind) == 0)
				return runner;
			else
				runner = runner.getNext();
		}
		return null;
	}

	// ############################################################################
	// destroy
	// this method only resets the list
	public void destroy() {
		if (head == null)
			System.out.println("Your list is empty.");
		else {
			head = null;
			tail = null;
			size = 0;
		}
	}

	// ############################################################################
	// printForward
	public void printForward() {
		if (head == null)
			System.out.println("Your list is empty.");
		else {
			Node temp = head;
			while (temp != null) {
				System.out.println(temp.getData());
				temp = temp.getNext();
			}
		}
	}

	// ############################################################################
	// printBackward
	public void printBackward() {
		if (head == null)
			System.out.println("Your list is empty.");
		else {
			Node temp = tail;
			while (temp != null) {
				System.out.println(temp.getData());
				temp = temp.getPrevious();
			}
		}
	}
	
	
	// ------------------------------------------------------------------------------
}
