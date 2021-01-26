public class BSTree {
  // properties
  public BSTree parent;
  public BSTree left;
  public BSTree right;
  public int data;
    
  // constructor
  public BSTree() {
    this.parent = null;
    this.left = null;
    this.right = null;
    this.data = 0;
  }
  
  public BSTree(int data) {
    this.parent = null;
    this.left = null;
    this.right = null;
    this.data = data;
  }
  
  // methods
  
  public boolean hasLeft() {
    return !(this.left == null);
  }
  
  public boolean hasRight() {
    return !(this.right == null);
  }
  
  public boolean hasParent() {
    return !(this.parent == null);
  }
  
  public void add(int data) {
    this.add(new BSTree(data));
  }
  
  // add new node to right if greater or equal, 
  // left if less than
  public void add(BSTree subtree) {
    if (subtree != null) {
      if (subtree.data < this.data) {
        if (this.hasLeft())
          this.left.add(subtree);
        else {
          this.left = subtree;
          subtree.parent = this;
        }
      } 
      else
        if (this.hasRight())
          this.right.add(subtree);
        else {
          this.right = subtree;
          subtree.parent = this;
      }
    }
  }
  
  public void print() {
    System.out.print(this.data + " ");
  }
  
  public void inOrder() {
    if (this.left != null)
      this.left.inOrder();
    this.print();
    if (this.right != null)
      this.right.inOrder();
    /*if (node != null) */
  }
  
  public BSTree find (int data) {
  if(this.data == data)
    return this;
  else if(data < this.data && hasLeft() )
    return left.find(data);
  else if(data > this.data && hasRight() )
    return right.find(data);
  else
    return null;
  }
  
  public BSTree delete(int data) {
    BSTree tmp = this.find(data);
    if (tmp == null)
      return null;
    if (tmp.parent == null){
      tmp.left.add(tmp.right);
      tmp.data = tmp.left.data;
      tmp.right = tmp.left.right;
      tmp.left.right.parent = tmp;
      tmp.left = tmp.left.left;
      tmp.left.parent = tmp;
    }
    else {
      if (tmp.parent.left.data == data)
        tmp.parent.left = null;
      else
        tmp.parent.right = null;
      this.add(tmp.left);
      this.add(tmp.right);
      tmp.parent = null;
      tmp.left = null;
      tmp.right = null;
    }
    return(tmp);
  }
  
  public int depth() {
    int leftDepth = 0;
    int rightDepth = 0;
    if (this.hasLeft())
      leftDepth = left.depth();
    if (this.hasRight())
      rightDepth = right.depth();
    if (leftDepth > rightDepth)
      return leftDepth + 1;
    else
      return rightDepth + 1;
  }
}