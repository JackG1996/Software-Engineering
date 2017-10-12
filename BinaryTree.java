import java.util.NoSuchElementException;

public class BinaryTree<Key extends Comparable<Key>, Value> {
	private Node root;

	private class Node {

		private Key key; // sorted by key
		private Value val; // associated data
		private Node left, right; // left and right subtrees
		private int N; // number of nodes in subtree

		public Node(Key key, Value val, int N) {

			this.key = key;
			this.val = val;
			this.N = N;
		}
	}

	public boolean isEmpty() {
		return size() == 0;
	}

	public int size() {
		return size(root);
	}

	private int size(Node x) {
		if (x == null)
			return 0;
		else
			return x.N;
	}

	public boolean contains(Key key) {
		return get(key) != null;
	}

	public Value get(Key key) {
		return get(root, key);
	}

	private Value get(Node x, Key key) {
		if (x == null)
			return null;
		int cmp = key.compareTo(x.key);
		if (cmp < 0)
			return get(x.left, key);
		else if (cmp > 0)
			return get(x.right, key);
		else
			return x.val;

	}

	public void put(Key key, Value val) {
		root = put(root, key, val);
	}

	private Node put(Node x, Key key, Value val) {
		if (x == null)
			return new Node(key, val, 1);
		int cmp = key.compareTo(x.key);
		if (cmp < 0)
			x.left = put(x.left, key, val);
		else if (cmp > 0)
			x.right = put(x.right, key, val);
		else
			x.val = val;
		x.N = 1 + size(x.left) + size(x.right);
		return x;
	}

	public String lca(Key x1, Key x2) {
		if (!(contains(x1) && contains(x2))) {
			return null;
		}
		if (root == null) {
			return null;
		}
		return lca(root, x1, x2);
	}

	private String lca(Node node, Key x1, Key x2) {

		if (x1.compareTo(node.key) < 0 && x2.compareTo(node.key) < 0) {
			node = node.left;
			return lca(node, x1, x2);
		} else if (x1.compareTo(node.key) > 0 && x2.compareTo(node.key) > 0) {
			node = node.right;
			return lca(node, x1, x2);
		}

		return String.valueOf(node.key);
	}

}

