/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

public class NodeList {
    private int size = 0;
    private Node root = null;
	
    /*
     * It has to take a new Node and add that to the next address of previous Node.
     * If the list is empty, assign it as the "root"
     * @Param - Node
     */
    public void add(Node node) {
    	// Assign a temp value for looping
    	Node tempNode = this.root;
    	
    	// Checks if empty
        if (this.size <= 0)
        	this.root = node;
        else {
        	// loop through the list until we find the end and add node
        	while (tempNode.getNext() != null) {
        		tempNode = tempNode.getNext();
        	}
        	tempNode.setNext(node);	
        }
        
        // increment size	
    	this.size++;
    }
    
    /*
     * It has to return the size of the NodeList
     * 
     * @return size
     */
    public int size() {
    	return this.size;
    }
    
    /*
     * It has to take a Node and checks if the node is in the list.
     * If it finds the node, it returns true, otherwise false
     * 
     * @param - Node
     * @return boolean true/false
     */
    public boolean findNode(Node node){
    	// Temp node for looping
    	Node tempNode = this.root;
    	
    	if (tempNode.getId() == node.getId())
;

		while (tempNode.getNext() != null) {
			tempNode = tempNode.getNext();
			if (tempNode.getId() == node.getId())
				return true;
		}
    		
    	return false;
    }
}

