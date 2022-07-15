package binarySearchTree;

public class IntBinarySearchTreeTest {

	public static void main(String[] args) {

		int[] ints = { 7, 3, 6, 8, 1, 4, 9 };

		IntBinarySearchTree tree = new IntBinarySearchTree(ints);

		System.out.println("preorder");
		tree.print(IntBinarySearchTree.PRE);
		System.out.println("inorder");
		tree.print(IntBinarySearchTree.IN);
		System.out.println("postorder");
		tree.print(IntBinarySearchTree.POST);
	}

}
