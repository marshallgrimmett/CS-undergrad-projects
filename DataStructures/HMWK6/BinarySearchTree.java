/*
 * Author: Marshall Grimmett
 * Date: 5/5/2017
 * Description: This program contains the definition for a binary search tree.
 * 				It utilizes nodes with a string datatype
 */
public class BinarySearchTree {
	private Node root;
	private int size;

	// Methods
	//##############################################################

	// Getters
	public int getSize() {
		return size;
	}

	public Node getRoot() {
		return root;
	}

	//##############################################################
	// insert
	public void insert(Node newNode) {
		Node runner = root;
		if (newNode != null) {
			newNode.setData(newNode.getData().toLowerCase());
			if (root == null) {
				root = newNode;
			} else {
				insert(newNode, runner);
			}
			this.size++;
		}
	}
	private void insert(Node newNode, Node runner) {
		if (newNode.getData().compareTo(runner.getData()) <= 0) {
			if (runner.getLeft() == null) {
				runner.setLeft(newNode);
				runner.getLeft().setParent(runner);
			}
			else
				insert(newNode, runner.getLeft());
		} else {
			if (runner.getRight() == null) {
				runner.setRight(newNode);
				runner.getRight().setParent(runner);
			}
			else
				insert(newNode, runner.getRight());
		}
	}

	//##############################################################
	// print - traverse inorder
    public void print() {
        print(root);
    }
    private void print(Node r) {
        if (r != null) {
            print(r.getLeft());
            System.out.println(r.getData());
            print(r.getRight());
        }
    }

	//##############################################################
    // toArray
    public Node[] toArray() {
		Node[] arr = new Node[this.size];
		toArray(root, arr, 0);
		return arr;
    }
    private int toArray(Node r, Node[] arr, int pos) {
        if (r.getLeft() != null) {
            pos = toArray(r.getLeft(), arr, pos);
        }
        arr[pos++] = r;
        if (r.getRight() != null) {
            pos = toArray(r.getRight(), arr, pos);
        }
    	return pos;
    }

	//##############################################################
	// delete
    public void delete(String toDelete) {
    	toDelete = toDelete.toLowerCase();
		Node temp = root;

		if (root == null) {
			System.out.println("The tree is empty.");
		} else {
	    	temp = search(toDelete);
			if (temp == root) {
				root = root.getLeft();
			} else if (temp.getParent().getLeft() == temp) {
				temp.getParent().setLeft(temp.getLeft());
			} else {
				temp.getParent().setRight(temp.getLeft());
			}
			insert(temp.getRight());
		}
    }

	//##############################################################
	// search
    public Node search(String toFind) {
    	return search(root, toFind);
    }
    public Node search(Node runner, String s) {
    	if (runner != null) {
	    	if (runner.getData().compareTo(s) == 0) {
	    		return runner;
	    	} else if (runner.getData().compareTo(s) > 0) {
					return search(runner.getLeft(), s);
				} else {
					return search(runner.getRight(), s);
				}
    	} else {
    		System.out.println("The string does not exist in the tree.");
    		return null;
    	}
    }

	//##############################################################
	// balance
    public void balance() {
        Node[] treeArray = toArray();
        nullify(treeArray);
        root = null;
        size = 0;
        balance(treeArray, 0, treeArray.length - 1);
    }
    private void balance(Node[] data, int first, int last) {
        if (first <= last) {
          int middle = first + (last - first) / 2;
          insert(data[middle]);
          balance(data, first, middle - 1);
          balance(data, middle + 1, last);
        }
    }
    private void nullify(Node[] arr) {
    	for (int i = 0; i < arr.length; i++) {
    		arr[i].setLeft(null);
    		arr[i].setRight(null);
    		arr[i].setParent(null);
    	}
    }

	//##############################################################
    // printTree
    // NOTE!!!: This function is to be used with the input file ONLY after being balanced
    // Errors will occur if used otherwise
    public void printTree() {
		System.out.println("Level 1: " + root.getData());
		System.out.println("Level 2: " + root.getLeft().getData()
				+ ", " + root.getRight().getData());
		System.out.println("Level 3: " + root.getLeft().getLeft().getData()
				+ ", " + root.getLeft().getRight().getData()
				+ ", " +  root.getRight().getLeft().getData()
				+ ", " + root.getRight().getRight().getData());
		System.out.println("Level 4: " + root.getLeft().getLeft().getLeft().getData()
				+ ", " + root.getLeft().getLeft().getRight().getData()
				+ ", " + root.getLeft().getRight().getLeft().getData()
				+ ", " + root.getLeft().getRight().getRight().getData()
				+ ", " + root.getRight().getLeft().getLeft().getData()
				+ ", null" //+ root.getRight().getLeft().getRight().getData()
				+ ", " + root.getRight().getRight().getLeft().getData()
				+ ", null" //+ root.getRight().getRight().getRight().getData()
				);
		System.out.println("Level 5: " + root.getRight().getLeft().getLeft().getLeft().getData()
				+ ", " + root.getRight().getRight().getLeft().getRight().getData());
    }
}
