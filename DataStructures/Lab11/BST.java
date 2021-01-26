import java.util.ArrayList;

/**
 *
 * @author zumrut
 */
public class BST {

     private BSTNode root;
     ArrayList<Integer> tree = new ArrayList<Integer>();

     public BST()
     {
         root = null;
     }

     public boolean isEmpty()
     {
         return root == null;
     }

     public void setRoot(int data){
         root = new BSTNode(data);
     }

     public BSTNode getRoot(){
         return root;
     }

     public void insert(int data)
     {
        if(root!=null){
            insert(root, data);
        }
        else{
            root = new BSTNode(data);
            System.out.println("Building tree with root data " +data);
        }
     }

     private void insert(BSTNode node, int data)
     {
        if (data <= node.getData()) {
            if (node.left != null) {
                   insert(node.left, data);
            } else {
                System.out.println("++Inserted " + data + " to left of "
                + node.getData());
                node.left = new BSTNode(data);
            }
        } else if (data > node.getData()) {
            if (node.right != null) {
                insert(node.right, data);
            } else {
                System.out.println("--Inserted " + data + " to right of "
                + node.getData());
                node.right = new BSTNode(data);
            }
        }
     }


     public void inorder()
     {
         inorder(root);
     }

     private void inorder(BSTNode r)
     {
         if (r != null)
         {
             inorder(r.getLeft());
             System.out.print(r.getData() +" ");
             tree.add(r.getData());
             inorder(r.getRight());
         }
     }

     public void preorder()
     {
         preorder(root);
     }
     private void preorder(BSTNode r)
     {
       if (r != null)
       {
           System.out.print(r.getData() +" ");
           preorder(r.getLeft());
           preorder(r.getRight());
       }
     }


     public void postorder()
     {
         postorder(root);
     }
     private void postorder(BSTNode r)
     {
       if (r != null)
       {
           postorder(r.getLeft());
           postorder(r.getRight());
           System.out.print(r.getData() +" ");
       }
     }

    public void balance(Integer data[], int first, int last) {
        if (first <= last) {
          int middle = first + (last - first) / 2;
          insert(data[middle]);
          balance(data, first, middle - 1);
          balance(data, middle + 1, last);
        }
    }

    public void balance() {
        Integer[] treeArray = tree.toArray(new Integer[tree.size()]);
        root = null;
        balance(treeArray,0,treeArray.length-1);
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        BST bstInstance = new BST();
        bstInstance.setRoot(5);
        System.out.println("Binary Tree Example");
        System.out.println("Building tree with root data " + bstInstance.getRoot().getData());
        bstInstance.insert(1);
        bstInstance.insert(8);
        bstInstance.insert(6);
        bstInstance.insert(3);
        bstInstance.insert(9);
        bstInstance.insert(12);
        bstInstance.insert(11);
        bstInstance.insert(15);
        System.out.println("Traversing tree in order");
        bstInstance.inorder();
        System.out.println();
        System.out.println("Traversing tree pre order");
        bstInstance.preorder();
        System.out.println();
        System.out.println("Traversing tree post order");
        bstInstance.postorder();
        System.out.println();
        bstInstance.balance();
        System.out.println();
    }

}
