package trees;

public class TreeTester {
	public static void main(String[] args) {
		BinaryTree<Integer> bt = new BinaryTree<Integer>(10);
		
		bt.root.addLeftChild(5);
		bt.root.addRightChild(15);
		bt.root.getLeft().addLeftChild(3);
		bt.root.getLeft().addRightChild(7);
		bt.root.getRight().addLeftChild(13);
		bt.root.getRight().addRightChild(17);
		
		System.out.println(bt.binarySearch(6));
		//System.out.print(bt.binarySearch(5, bt.root));
		//System.out.print(bt.root.getLeft().getRight().getValue());
		bt.insert(18);
		//System.out.println(bt.binarySearch(6));
	}
}
