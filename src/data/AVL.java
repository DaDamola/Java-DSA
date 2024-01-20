package data;

class AVLNode {
	int data, height;
	AVLNode left, right;
	
	AVLNode(int data) {
		this.data = data;
	}
}

public class AVL {
	private AVLNode root;
	
	public int getHeight(AVLNode root) {
		return (root == null) ? -1 : root.height;
	}
	
	public int BF(AVLNode root) {
		return getHeight(root.left) - getHeight(root.right);
	}
	
	public int getMax() {
		if (root == null) {
			return Integer.MIN_VALUE;
		}
		
		while (root.right != null) {
			root = root.right;
		}
		
		return root.data;
	}
	
	public int getMaxRecursive() {
		return getMaxRecursiveHelper(root);
	}
	
	public int getMaxRecursiveHelper(AVLNode root) {
		if (root == null) {
			return Integer.MIN_VALUE;
		}
		else if (root.right == null) {
			return root.data;
		}
		
		return getMaxRecursiveHelper(root.right);
	}
	
	public AVLNode rotateLeft(AVLNode root) {
		AVLNode newRoot = root.right;
		AVLNode orphan = newRoot.left;
		
		newRoot.left = root;
		root.right = orphan;
		
		root.height = 1 + Math.max(getHeight(root.left), getHeight(root.right));
		newRoot.height = 1 + Math.max(getHeight(newRoot.left), getHeight(newRoot.right));
		
		return newRoot;
	}
	
	public AVLNode rotateRight(AVLNode root) {
		AVLNode newRoot = root.left;
		AVLNode orphan = newRoot.right;
		
		newRoot.right = root;
		root.left = orphan;
		
		root.height = 1 + Math.max(getHeight(root.left), getHeight(root.right));
		newRoot.height = 1 + Math.max(getHeight(newRoot.left), getHeight(newRoot.right));
		
		return newRoot;
	}
	
	public AVLNode balance(AVLNode root) {
		int bf = BF(root);
		
		if (bf == 2) {
			if (BF(root.left) < 0) {
				root.left = rotateLeft(root.left);
			}
			
			root = rotateRight(root);
		}
		else if (bf == -2) {
			if (BF(root.right) > 0) {
				root.right = rotateRight(root.right);
			}
			
			root = rotateLeft(root);
		}
		
		return root;
	}
	
	public void preorder() {
		preorderHelper(root);
		System.out.println();
	}
	
	public void preorderHelper(AVLNode root) {
		if (root == null) {
			return;
		}
		
		System.out.print(root.data + " ");
		preorderHelper(root.left);
		preorderHelper(root.right);
	}
	
	public void inorder() {
		inorderHelper(root);
		System.out.println();
	}
	
	public void inorderHelper(AVLNode root) {
		if (root == null) {
			return;
		}
		
		inorderHelper(root.left);
		System.out.print(root.data + " ");
		inorderHelper(root.right);
	}
	
	public void postorder() {
		postorderHelper(root);
		System.out.println();
	}
	
	public void postorderHelper(AVLNode root) {
		if (root == null) {
			return;
		}
		
		postorderHelper(root.left);
		postorderHelper(root.right);
		System.out.print(root.data + " ");
	}
	
	public void insert(int data) {
		root = insertHelper(root, data);
	}
	
	public AVLNode insertHelper(AVLNode root, int data) {
		if (root == null) {
			return new AVLNode(data);
		}
		else if (root.data <= data) {
			root.right = insertHelper(root.right, data);
		}
		else if (root.data > data) {
			root.left = insertHelper(root.left, data);
		}
		
		root.height = 1 + Math.max(getHeight(root.left), getHeight(root.right));
		root = balance(root);
		
		return root;
	}
	
	public static void main(String[] args) {
		AVL root = new AVL();
		
//		root.insert(35);
//		root.insert(20);
//		root.insert(40);
//		root.insert(10);
//		root.insert(25);
		
		// IO: 10 20 25 35 40
		// PO: 10 25 20 40 35
		
//		root.inorder();
//		root.postorder();
		
		root.insert(3);
		root.insert(1);
		root.insert(23);
		root.insert(42);
		root.insert(50);
		
		// IO: 1 3 23 42 50
		// PO: 1 50 42 23 3
		
		root.inorder();
		root.postorder();
		
//		root.insert(10);
//		root.insert(12);
//		root.insert(14);
		
		// PRO: 12 10 14
		// PO: 10 14 12
//		root.preorder();
//		root.postorder();

		
//		root.insert(23);
//		root.insert(42);
//		root.insert(35);
		
//		root.insert(10);
//		root.insert(6);
//		root.insert(8);
		
//		root.insert(14);
//		root.insert(2);
//		root.insert(21);
//		root.insert(17);
//		root.insert(40);
//		root.insert(42);
		
//		root.insert(14);
//		root.insert(2);
//		root.insert(21);
//		root.insert(17);
//		root.insert(40);
//		root.insert(18);
		
//		root.insert(14);
//		root.insert(2);
//		root.insert(21);
//		root.insert(17);
//		root.insert(40);
//		root.delete(2);
		
//		root.inorder();
	}

}

