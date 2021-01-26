/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
//package lab05;

/**
 *
 * @author zumrut
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
            if (node==null) return;
            if (root == null) {
                Node newNode = new Node(0, node.getName());
                root = newNode;
            }
            else {
                Node currentNode = root;
                while(currentNode.getNext()!=null){
                    currentNode = currentNode.getNext();
                }
                int id = currentNode.getId();
                id ++;
                Node newNode = new Node(id, node.getName());
                currentNode.setNext(newNode);
            }
            size++;
    }

    /*
     * It has to return the size of the NodeList
     *
     * @return size
     */
    public int size() {
        return size;
    }

    /*
     * It has to take a Node and checks if the node is in the list.
     * If it finds the node, it returns true, otherwise false
     *
     * @param - Node
     * @return boolean true/false
     */
    public boolean findNode(Node node){
        if(node==null) return false;
        Node currentNode = root;
        while(currentNode.getName()!= node.getName())
        {
            currentNode = currentNode.getNext();
            if(currentNode == null)
                return false;
        }
        return true;
    }


    /**
     * Start with the head and traverse till you reach null. Print out the data in the nodes.
     */
    public void iterate(){
       if (root == null) {
	      System.out.println("empty list");
       }
       else {
        Node currentNode = root;
	      while (currentNode != null) {
          System.out.println("ID : " + currentNode.getId() + "  Name : " + currentNode.getName());
          currentNode = currentNode.getNext();
        }
      }
    }
}
