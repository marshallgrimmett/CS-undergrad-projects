/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
		
		NodeList list = new NodeList();
		Node node = new Node(1, "Book");
		Node node2 = new Node(2, "Binder");
		
		list.add(node);
		list.add(node2);
		System.out.println("Length : "+list.size());
		
		Node node3 = new Node(3, "Glass");
        Node node4 = new Node(4, "Pen");
        list.add(node3);
		System.out.println("Length : "+list.size());
        if(list.findNode(node3))
            System.out.println("Node found: "+node3.getName());
        else
            System.out.println("Node not found: "+node3.getName());
        if(list.findNode(node4))
            System.out.println("Node found: "+node4.getName());
        else
            System.out.println("Node not found: "+node4.getName());

	}
}
