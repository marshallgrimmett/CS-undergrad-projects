/*
 * Author: Marshall Grimmett
 * Date: 5/5/2017
 * Description: This class defines a Node to be used with a binary search tree.
 * 				The datatype used is of type String.
 */
public class Node {
	
	//##############################################################
	// PDMs
	private String data;
	private Node left;
	private Node right;
	private Node parent;
	
	//##############################################################
	// Constructors
	public Node(String data) {
		this.data = data;
		left = null;
		right = null;
		parent = null;
	}
	
	//##############################################################
	// Methods
	public String getData() {
		return data;
	}
	
	public void setData(String data) {
		this.data = data;
	}
	
	public Node getLeft() {
		return left;
	}
	
	public void setLeft(Node left) {
		this.left = left;
	}
	
	public Node getRight() {
		return right;
	}
	
	public void setRight(Node right) {
		this.right = right;
	}
	
	public Node getParent() {
		return parent;
	}
	
	public void setParent(Node parent) {
		this.parent = parent;
	}
}
