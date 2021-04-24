package trees;

public class BinaryTreeNode<E> {

	private E value;
	private BinaryTreeNode<E> parent;
	private BinaryTreeNode<E> left;
	private BinaryTreeNode<E> right;

	public BinaryTreeNode(E val, BinaryTreeNode<E> par) {
		super();
		this.value = val;
		this.parent = par;
		this.left = null;
		this.right = null;
	}

	public BinaryTreeNode<E> getLeft() {
		return left;
	}

	public BinaryTreeNode<E> addLeftChild(E val) {
		this.left = new BinaryTreeNode<E>(val, this);
		return this.left;
	}

	public BinaryTreeNode<E> getRight() {
		return right;
	}

	public BinaryTreeNode<E> addRightChild(E val) {
		this.right = new BinaryTreeNode<E>(val, this);
		return this.right;

	}
	
	public E getValue() {
		return this.value;
	}

	public void setValue(E value) {
		this.value = value;
	}

	public void visit() {
		System.out.print(value + ", ");
	}

}
