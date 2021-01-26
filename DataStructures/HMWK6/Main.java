import java.util.Scanner;
import java.io.File;
/*
 * Author: Marshall Grimmett
 * Date: 5/5/2017
 * Description: This program creates a binary search tree and tests its various methods.
 * 				It also reads in a file and inserts it into a binary search tree.
 * 				Lastly, it creates a histogram with a binary search tree.
 */
public class Main {
	
	public static void main(String[] args) {
		testInsert();
		testDelete();
		testSearch();
		testBalance();
		testHistogram();
	}
	
	//##############################################################
	static void testHistogram() {
		System.out.println("\n################################################");
		System.out.println("Testing Histogram");
		System.out.println("################################################");
		BinarySearchTree tree = readInFile();
		histogram(tree);
	}
	
	//##############################################################
	static void testInsert() {
		System.out.println("################################################");
		System.out.println("Testing Insert");
		System.out.println("################################################");
		BinarySearchTree tree = new BinarySearchTree();
		System.out.println("Inserting: Hello...");
		tree.insert(new Node("Hello"));
		System.out.println("Inserting: World!...");
		tree.insert(new Node("World!"));
		System.out.println("Inserting: This...");
		tree.insert(new Node("This"));
		System.out.println("Inserting: is...");
		tree.insert(new Node("is"));
		System.out.println("Inserting: a...");
		tree.insert(new Node("a"));
		System.out.println("Inserting: tree...");
		tree.insert(new Node("tree"));
		System.out.println("Printing tree...");
		tree.print();
	}
	
	//##############################################################
	static void testDelete() {
		System.out.println("\n################################################");
		System.out.println("Testing Delete");
		System.out.println("################################################");
		System.out.println("Reading in text file...");
		BinarySearchTree tree = readInFile();
		System.out.println("Deleting: this...");
		tree.delete("this");
		System.out.println("Deleting: words...");
		tree.delete("words");
		System.out.println("Deleting: makes...");
		tree.delete("makes");
		System.out.println("Printing tree...");
		tree.print();
	}
	
	//##############################################################
	static void testSearch() {
		System.out.println("\n################################################");
		System.out.println("Testing Search");
		System.out.println("################################################");
		System.out.println("Reading in text file...");
		BinarySearchTree tree = readInFile();
		Node temp;
		System.out.println("Finding: this...");
		temp = tree.search("this");
		if (temp != null && temp.getData().compareTo("this") == 0)
			System.out.println("Found it!");
		System.out.println("Finding: words...");
		temp = tree.search("this");
		if (temp != null && temp.getData().compareTo("words") == 0)
			System.out.println("Found it!");		
		System.out.println("Finding: hi...");
		temp = tree.search("hi");
		if (temp != null && temp.getData().compareTo("hi") == 0)
			System.out.println("Found it!");
	}
	
	//##############################################################
	static void testBalance() {
		System.out.println("\n################################################");
		System.out.println("Testing Balance");
		System.out.println("################################################");
		System.out.println("Reading in text file...");
		BinarySearchTree tree = readInFile();
		System.out.println("Balancing tree...");
		tree.balance();
		System.out.println("Printing a balanced tree...");
		tree.printTree();
	}
	
	//##############################################################
	static BinarySearchTree readInFile() {
		BinarySearchTree tree = new BinarySearchTree();
		Boolean found = false;
		Scanner scanner = null;
		
		// Check if file exists
		while (!found)
			try {
				scanner = new Scanner(new File("InputFile.txt"));
				found = true;
				
				// Read in the file
				while (scanner.hasNextLine()) {
					Node newNode = new Node(scanner.nextLine());
					tree.insert(newNode);
				}
			} catch (Exception ex) {
				System.out.println("Could not find file...");
			}
		
		scanner.close();
		return tree;
	}
	
	//##############################################################
	static void histogram(BinarySearchTree bst) {
		Node[] arr = bst.toArray();
		int count = 1;
		
		// For each element, search the array for duplicates
		for (int i = 0; i < bst.getSize(); i++) {
			for (int j = 0; j < bst.getSize(); j++)
				if (arr[i].getData().compareTo(arr[j].getData()) == 0
						&& arr[i] != arr[j])
					count++;
			
			// Only print one of each occurence
			if (i == bst.getSize() - 1)
				System.out.println(arr[i].getData() + " " + count);
			else if (arr[i].getData().compareTo(arr[i + 1].getData()) != 0)
				System.out.println(arr[i].getData() + " " + count);
			
			count = 1;
		}
	}
}
