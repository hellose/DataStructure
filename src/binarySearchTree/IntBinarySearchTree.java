package binarySearchTree;

public class IntBinarySearchTree {

	public static final String PRE = "preorder";
	public static final String IN = "inorder";
	public static final String POST = "postorder";

	private Node root;

	public IntBinarySearchTree() {
	}

	public IntBinarySearchTree(int[] intArray) {
		for (int index = 0; index < intArray.length; index++) {
			addNode(intArray[index]);
		}
	}

	private class Node {

		private int value;
		private Node left;
		private Node right;

		private Node(int value, Node left, Node right) {
			this.value = value;
			this.left = left;
			this.right = right;
		}

	}

	// 1. 노드 추가
	public void addNode(int value) {
		if (this.root == null) {
			root = new Node(value, null, null);
			return;
		}

		Node current = root;
		while (true) {

			if (value < current.value) {
				if (current.left == null) {
					current.left = new Node(value, null, null);
					break;
				} else {
					current = current.left;
				}
			} else if (value == current.value) {
				break;
			} else {
				if (current.right == null) {
					current.right = new Node(value, null, null);
					break;
				} else {
					current = current.right;
				}
			}

		}
	}

	// 2. 트리 순회
	public void print(String order) {
		if (root == null) {
			System.out.println("Tree에 노드가 없음");
			return;
		}

		StringBuilder builder = new StringBuilder();

		switch (order) {
		case PRE:
			preorder(root, builder);
			break;
		case IN:
			inorder(root, builder);
			break;
		case POST:
			postorder(root, builder);
			break;
		}

		System.out.println(builder.toString());
	}

	// root - left - right
	private void preorder(Node node, StringBuilder builder) {
		if (node != null) {
			builder.append(node.value);
			builder.append(' ');
			preorder(node.left, builder);
			preorder(node.right, builder);
		}
	}

	// left - root - right
	private void inorder(Node node, StringBuilder builder) {
		if (node != null) {
			inorder(node.left, builder);
			builder.append(node.value);
			builder.append(' ');
			inorder(node.right, builder);
		}
	}

	// left - right - root
	private void postorder(Node node, StringBuilder builder) {
		if (node != null) {
			postorder(node.left, builder);
			postorder(node.right, builder);
			builder.append(node.value);
			builder.append(' ');
		}
	}

}
