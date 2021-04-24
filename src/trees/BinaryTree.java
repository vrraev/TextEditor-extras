package trees;

public class BinaryTree<E extends Comparable <? super E>>{
	
	public BinaryTreeNode<E> root;

	public BinaryTree() {
		super();
		this.root = null;
	}
	
	public BinaryTree(E val) {
		super();
		this.root = new BinaryTreeNode<E>(val, null);
	}
	
	public BinaryTree(BinaryTreeNode<E> root) {
		super();
		this.root = root;
	}
	
	private void preOrder(BinaryTreeNode<E> node) {
		if (node != null) {
			node.visit();
			preOrder(node.getLeft());
			preOrder(node.getRight());
		}
	}
	
	public void preOrder() {
		this.preOrder(root);
	}
	
	public boolean binarySearch(E searchVal) {
		BinaryTreeNode<E> curr = root;
		int comp;
		while (curr != null) {
			comp = searchVal.compareTo(curr.getValue());
			if (comp < 0) {
				curr = curr.getLeft();
				//System.out.println("left");
			} else if (comp > 0) {
				curr = curr.getRight();
				//System.out.println("right");
			} else {
				return true;
			}
		}
		
		return false;
	
	}
	
	public boolean binarySearch(E searchVal, BinaryTreeNode<E> startNode) {
		E currNodeVal = startNode.getValue();
		if (currNodeVal == searchVal) {
			return true;
		} 
		else if (currNodeVal.compareTo(searchVal) > 0 && startNode.getLeft() != null) {
			binarySearch(searchVal,startNode.getLeft());
			//System.out.println("left");
		} 
		else if (currNodeVal.compareTo(searchVal) < 0 && startNode.getRight() != null) {
			binarySearch(searchVal,startNode.getRight());
			//System.out.println("right");
		}
		return false;
	}
	
	public boolean insert(E val) {
		BinaryTreeNode<E> curr = root;
		int comp;
		
		while (curr != null) {
			comp = val.compareTo(curr.getValue());
			if (comp < 0) {
				if (curr.getLeft() != null) {
					curr = curr.getLeft();
				} else {
					curr.addLeftChild(val);
					break;
				}
				//System.out.println("left");
			} else if (comp > 0) {
				if (curr.getRight() != null) {
					curr = curr.getRight();
				} else {
					curr.addRightChild(val);
					break;
				}
				//System.out.println("right");
			} else {
				System.out.println("Entry exists!");
				return false;
			}
		} 
		
		return true;
	}
	
	
}
