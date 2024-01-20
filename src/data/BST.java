package data;

import java.util.ArrayList;
import java.util.List;

import algo.Sort;

/**
* The BST class creates a node-based binary search tree data
* structure with generic values and displays tree traversals.
* @author  Damola Adebayo
* @version 1.0
* @since   2023-08-18
*/

class BSTNode<T> {
	T data;
	BSTNode<T> left, right; 
	
	BSTNode(T data) {
		this.data = data;
	}
}

public class BST<AnyType extends Comparable<AnyType>> {
	private BSTNode<AnyType> root; 
	private int size; 
	
	public BSTNode<AnyType> getRoot() {
		return root;
	}
	
	public void setRoot(BSTNode<AnyType> root) {
		this.root = root; 
	}
	
	public int getSize() {
		return size; 
	}
	
	public void setSize(int size) {
		this.size = size;
	}
	
    /**
    * This method adds a value to the tree.
    * @param data The value to insert
    * BC: O(1) AC: O(log n) - bushy WC: O(n) - linked list 
    * SC: O(1) 
    */
	public void insert(AnyType data) {
		root = insertHelper(root, data);
	}
	
	public BSTNode<AnyType> insertHelper(BSTNode<AnyType> root, AnyType data) {
		if (root == null) {
			size++;
			return new BSTNode<>(data);
		}
		else if (data.compareTo(root.data) < 0) {
			root.left = insertHelper(root.left, data);
		}
		else if (data.compareTo(root.data) > 0) {
			root.right = insertHelper(root.right, data);
		}
		
		return root;
	}
	
    /**
    * This method checks if the tree contains the value.
    * @param data The value to find
    * @return boolean true if the value is found and false if the value is not found
    * BC: O(1) AC: O(log n) - bushy WC: O(n) - linked list
    * SC: O(1)
    */
	public boolean search(AnyType data) {
		return search(root, data);
	}
	
	public boolean search(BSTNode<AnyType> root, AnyType data) {
		if (root == null) {
			return false; 
		}
		else if (data.compareTo(root.data) == 0) {
			return true; 
		}
		else if (data.compareTo(root.data) < 0) {
			return search(root.left, data);
		}
		else if (data.compareTo(root.data) > 0) {
			return search(root.right, data);
		}
		
		return false; 
	}
	
    /**
    * This method removes a value from the tree. 
    * @param data The value to remove
    * BC: O(1) AC: O(log n) - bushy WC: O(n) - linked list
    * SC: O(1)    
    */
	public void delete(AnyType data) {
		root = deleteHelper(root, data);
	}
	
	public BSTNode<AnyType> deleteHelper(BSTNode<AnyType> root, AnyType data) {
		if (root == null) {
			return null;
		}
		else if (data.compareTo(root.data) < 0) {
			root.left = deleteHelper(root.left, data);
		}
		else if (data.compareTo(root.data) > 0) {
			root.right = deleteHelper(root.right, data);
		}
		else {
			size--;
			if (root.left != null && root.right != null) {
				AnyType val = getMax(root.left);
				root.data = val; 
				root.left = deleteHelper(root.left, val);
			}
			else if (root.left != null) {
				return root.left;
			}
			else if (root.right != null) {
				return root.right;
			}
			else {
				return null; 
			}
		}
		
		return root; 
	}
	
    /**
    * This method retrieves the largest value in the tree. 
    * @return AnyType The largest value
    * BC: O(1) AC: O(log n) - bushy WC: O(n) - linked list 
    * SC: O(1)
    */
	public AnyType getMax() {
		BSTNode<AnyType> temp = root; 
		if (temp == null) {
			return null;
		}
		
		while (temp.right != null) {
			temp = temp.right;
		}
		
		return temp.data;
	}
	
	
	public AnyType getMax(BSTNode<AnyType> root) {
		BSTNode<AnyType> temp = root; 
		if (temp == null) {
			return null;
		}
		
		while (temp.right != null) {
			temp = temp.right;
		}
		
		return temp.data;
	}
	
    /**
    * This method recursively retrieves the largest value in the tree. 
    * @return AnyType The largest value
    */
	public AnyType getMaxRecursive() {
		return getMaxRecursive(root);
	}
	
	public AnyType getMaxRecursive(BSTNode<AnyType> root) {
		if (root == null) {
			return null;
		}
		else if (root.right == null) {
			return root.data; 
		}
		
		return getMaxRecursive(root.right);
	}
	
    /**
    * This method retrieves the smallest value in the tree. 
    * @return AnyType The smallest value
    * BC: O(1) AC: O(log n) - bushy WC: O(n) - linked list 
    * SC: O(1) 
    */
	public AnyType getMin() {
		BSTNode<AnyType> temp = root; 
		if (temp == null) {
			return null;
		}
		
		while (temp.left != null) {
			temp = temp.left;
		}
		
		return temp.data; 
	}
	
    /**
    * This method recursively retrieves the smallest value in the tree. 
    * @return AnyType The smallest value
    */
	public AnyType getMinRecursive() {
		return getMinRecursive(root);
	}
	
	public AnyType getMinRecursive(BSTNode<AnyType> root) {
		if (root == null) {
			return null;
		}
		else if (root.left == null) {
			return root.data; 
		}
		
		return getMinRecursive(root.left);
	}
	
    /**
    * This method displays the tree using preorder traversal 
    * starting with the root.
    * BC/AC/WC: O(n) where n is the number of nodes in the tree
    * SC: O(1)
    */
	public void preorder() {
		preorder(root);
		
		if (root == null) {
			System.out.println(root);
		}
		else {
			System.out.println();
		}
	}
	
	public void preorder(BSTNode<AnyType> root) {
		if (root == null) {
			return;
		}
		
		System.out.print(root.data + " ");
		preorder(root.left);
		preorder(root.right);
	}
	
	public void preorder(List<AnyType> ls) {
		preorder(root, ls);
	}
	
	public void preorder(BSTNode<AnyType> root, List<AnyType> ls) {
		if (root == null) {
			return;
		}
		
		ls.add(root.data);
		preorder(root.left, ls);
		preorder(root.right, ls);
	}
	
    /**
    * This method inserts the preorder traversal into a list and
    * converts it to an array.
    * @return AnyType [] The array
    */
	public AnyType [] storePreorderTree() {
		List<AnyType> al = new ArrayList<>();
		preorder(al);
		return listToReferenceArray(al);
	}
	

    /**
    * This method displays the tree in sorted order using inorder traversal.
    * BC/AC/WC: O(n) where n is the number of nodes in the tree
    * SC: O(1)
    */
	public void inorder() {
		inorder(root);
		
		if (root == null) {
			System.out.println(root);
		}
		else {
			System.out.println();
		}
	}
	
	public void inorder(BSTNode<AnyType> root) {
		if (root == null) {
			return;
		}
		
		inorder(root.left);
		System.out.print(root.data + " ");
		inorder(root.right);
	}
	
	public void inorder(List<AnyType> ls) {
		inorder(root, ls);
	}
	
	public void inorder(BSTNode<AnyType> root, List<AnyType> ls) {
		if (root == null) {
			return;
		}
		
		inorder(root.left, ls);
		ls.add(root.data);
		inorder(root.right, ls);
	}
	
    /**
    * This method inserts the inorder traversal into a list and
    * converts it to an array.
    * @return AnyType [] The array
    */
	public AnyType [] storeInorderTree() {
		List<AnyType> al = new ArrayList<>();
		inorder(al);
		return listToReferenceArray(al);
	}

    /**
    * This method displays the tree using postorder traversal 
    * ending with the root.
    * BC/AC/WC: O(n) where n is the number of nodes in the tree
    * SC: O(1)
    */
	public void postorder() {
		postorder(root);
		
		if (root == null) {
			System.out.println(root);
		}
		else {
			System.out.println();
		}
	}
	
	public void postorder(BSTNode<AnyType> root) {
		if (root == null) {
			return;
		}
		
		postorder(root.left);
		postorder(root.right);
		System.out.print(root.data + " ");
	}
	
	public void postorder(List<AnyType> ls) {
		postorder(root, ls);
	}
	
	public void postorder(BSTNode<AnyType> root, List<AnyType> ls) {
		if (root == null) {
			return;
		}
		
		postorder(root.left, ls);
		postorder(root.right, ls);
		ls.add(root.data);
	}
	
    /**
    * This method inserts the postorder traversal into a list and
    * converts it to an array.
    * @return AnyType [] The array
    */
	public AnyType [] storePostorderTree() {
		List<AnyType> al = new ArrayList<>();
		postorder(al);
		return listToReferenceArray(al);
	}
	
    /**
    * This method converts the list to an array using 
    * the appropriate reference type 
    * @param al The list
    * @return AnyType [] The array
    */
	public AnyType [] listToReferenceArray(List<AnyType> al) {
		if (al.size() > 0 && al.get(0) instanceof String) {
			return (AnyType []) al.toArray(new String [al.size()]);
		}
		else if (al.size() > 0 && al.get(0) instanceof Character) {
			return (AnyType []) al.toArray(new Character [al.size()]);
		}
		else if (al.size() > 0 && al.get(0) instanceof Boolean) {
			return (AnyType []) al.toArray(new Boolean [al.size()]);
		}
		else if (al.size() > 0 && al.get(0) instanceof Integer) {
			return (AnyType []) al.toArray(new Integer [al.size()]);
		}
		else if (al.size() > 0 && al.get(0) instanceof Double) {
			return (AnyType []) al.toArray(new Double [al.size()]);
		}
		
		return null;
	}
	
    /**
    * This method removes all the values from the tree. 
    */
	public void clear() {
		while (size > 0) {
			delete(root.data);
		}
		
		root = null;
	}
}
