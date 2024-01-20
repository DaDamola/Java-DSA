package data;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

import algo.Constants;

/**
* The CircularLinkedList class creates a linked list where all the nodes are
* connected to form a circle. The first node is connected to the last node
* and there are no null values. It is implemented with generics.
* @author  Damola Adebayo
* @version 1.0
* @since   2023-09-03
*/

class CircularNode<T> {
	T data;
	CircularNode<T> next, prev; 
	
	CircularNode(T data) {
		this.data = data;
		next = prev = this;
	}
}

public class CircularLinkedList<AnyType extends Comparable<AnyType>> extends AbstractList<AnyType> {
	private CircularNode<AnyType> head, tail; 
	
	public CircularNode<AnyType> getHead() {
		return head; 
	}
	
	public void setHead(CircularNode<AnyType> head) {
		this.head = head; 
	}
	
	public CircularNode<AnyType> getTail() {
		return tail; 
	}
	
	public void setTail(CircularNode<AnyType> tail) {
		this.tail = tail; 
	}
	
    /**
    * This method adds a value between two nodes.
    * @param beforeNode The node to add before
    * @param afterNode The node to add after
    * @param data The value to add
    */
	public void insertNodeBetween(CircularNode<AnyType> beforeNode, CircularNode<AnyType> afterNode, AnyType data) {
		CircularNode<AnyType> newNode = new CircularNode<>(data);
		newNode.prev = beforeNode; 
		newNode.next = afterNode; 
		
		beforeNode.next = newNode;
		afterNode.prev = newNode;
	}
	
    /**
    * This method adds a value in sorted order to the linked list. 
    * @param data The value to add
    * BC: O(1) AC/WC: O(n) 
    * SC: O(1) 
    */
	@Override
	public void insert(AnyType data) {
		if (head == null ||  head.data.compareTo(data) >= 0) {
			headInsert(data);
		}
		else if (tail.data.compareTo(data) < 0) {
			tailInsert(data);
		}
		else {
			for (CircularNode<AnyType>  temp = head; temp.next != head; temp = temp.next) {
				if (temp.data.compareTo(data) >= 0) {
					insertNodeBetween(temp.prev, temp, data);
					size++;
					return;
				}
			}
			
			if (tail.data.compareTo(data) >= 0) {
				insertNodeBetween(tail.prev, tail, data);
				size++;
			}
		}
	}
	
    /**
    * This method recursively adds a value in sorted order to the linked list. 
    * @param data The value to add
    */
	public void insertRecursive(AnyType data) {
		insertRecursive(head, data);
	}
	
	public void insertRecursive(CircularNode<AnyType> temp, AnyType data) {
		if (head == null || head.data.compareTo(data) >= 0) {
			headInsert(data);
			return; 
		}
		else if (tail.data.compareTo(data) < 0) {
			tailInsert(data);
			return; 
		}
		else if (temp.data.compareTo(data) >= 0) {
			insertNodeBetween(temp.prev, temp, data);
			size++;
			return;
		}
		
		insertRecursive(temp.next, data);
	}
	
    /**
    * This method adds a value to the start of the linked list. 
    * @param data The value to add
    * BC/AC/WC: O(1)
    * SC: O(1) 
    */
	@Override
	public void headInsert(AnyType data) {
		if (head == null) {
			head = tail = new CircularNode<>(data);
			head.next = head.prev = head; 
		}
		else {
			CircularNode<AnyType> newHead = new CircularNode<>(data);
			newHead.next = head; 
			newHead.prev = tail;
			
			head.prev = newHead;
			tail.next = newHead;
			
			head = newHead;
		}
		
		size++;
	}
	
    /**
    * This method adds a value to the end of the linked list. 
    * @param data The value to add
    * BC/AC/WC: O(1)
    * SC: O(1) 
    */
	@Override
	public void tailInsert(AnyType data) {
		if (head == null) {
			headInsert(data);
		}
		else {
			CircularNode<AnyType> newTail = new CircularNode<>(data);
			newTail.prev = tail;
			newTail.next = head; 
			
			head.prev = newTail; 
			tail.next = newTail;
			
			tail = newTail; 
			size++;
		}
	}
	
    /**
    * This method removes the value at the start of the linked list. 
    * BC/AC/WC: O(1)
    * SC: O(1)
    */
	@Override
	public void headDelete() {
		if (head != null) {
			if (head == head.next) {
				head = tail = null; 
			}
			else {
				CircularNode<AnyType> newHead = head.next;
				newHead.prev = tail;
				tail.next = newHead;
				
			    head = newHead;
			}
			 
			size--;
		}
	}
	
    /**
    * This method removes the value at the end of the linked list. 
    * BC/AC/WC: O(1)
    * SC: O(1)
    */
	@Override
	public void tailDelete() {
		if (head != null) {
			if (head == head.next) {
				headDelete();
			}
			else {
				CircularNode<AnyType> newTail = tail.prev; 
				newTail.next = head;
				head.prev = newTail; 
				
				tail =  newTail; 
				size--;
			}
		}
	}
	
    /**
    * This method removes the first occurrence of the value from
    * the linked list.
    * @param data The value to remove
    * BC: O(1) AC/WC: O(n)
    * SC: O(1) 
    */
	@Override
	public void delete(AnyType data) {
		if (head != null) {
			if (head.data.compareTo(data) == 0) {
				headDelete();
			}
			else {
				for (CircularNode<AnyType> temp = head; temp.next != head; temp = temp.next) {
					if (temp.data.compareTo(data) == 0) {
						CircularNode<AnyType> beforeNode = temp.prev; 
						CircularNode<AnyType> afterNode = temp.next;
						
						beforeNode.next = afterNode;
						afterNode.prev = beforeNode; 
						size--;
						return; 
					}
				}
				
				if (tail.data.compareTo(data) == 0) {
					tailDelete();
				}
			}
		}
	}
	
    /**
    * This method recursively removes the first occurrence of the value from
    * the linked list.
    * @param data The value to remove
    * BC: O(1) AC/WC: O(n)
    * SC: O(1) 
    */	
	public void deleteRecursive(AnyType data) {
		deleteRecursive(head, data);
	}
	
	public void deleteRecursive(CircularNode<AnyType> temp, AnyType data) {
		if (head == null || (temp.next == head && temp.data.compareTo(data) != 0)) {
			return; 
		}
		else if (head.data.compareTo(data) == 0) {
			headDelete();
			return; 
		}
		else if (tail.data.compareTo(data) == 0) {
			tailDelete();
			return; 
		}
		else if (temp.data.compareTo(data) == 0) { // delete tail
			CircularNode<AnyType> beforeNode = temp.prev; 
			CircularNode<AnyType> afterNode = temp.next;

			beforeNode.next = afterNode;
			afterNode.prev = beforeNode; 
			size--;
			return; 
		}
		
		deleteRecursive(temp.next, data);
	}
	
    /**
    * This method checks if the linked list contains the value.
    * @param data The value to find
    * @return boolean true if the value is found and false if the value is not found
    * BC: O(1) AC/WC: O(n)
    * SC: O(1) 
    */
	@Override
	public boolean search(AnyType data) {
		for (CircularNode<AnyType> temp = head; temp != null && temp.next != head; temp = temp.next) {
			if (temp.data == data) {
				return true; 
			}
		}
		
		if (tail != null && tail.data == data) {
			return true;
		}
		
		return false; 
	}
	
    /**
    * This method recursively checks if the linked list contains the value.
    * @param data The value to find
    * @return boolean true if the value is found and false if the value is not found
    */
	public boolean searchRecursive(AnyType data) {
		return searchRecursive(head, data);
	}
	
	public boolean searchRecursive(CircularNode<AnyType> temp, AnyType data) {
		if (temp == null) {
			return false; 
		}
		else if (temp.data == data || tail.data == data) {
			return true;
		}
		else if (temp.next == head) {
			return false; 
		}
		
		return searchRecursive(temp.next, data);
	}
	
    /**
    * This method switches the values between these two nodes.
    * @param temp1 The first node
    * @param temp2 The second node
    */
	public void swap(CircularNode<AnyType> temp1, CircularNode<AnyType> temp2) {
		AnyType data = temp1.data;
		temp1.data = temp2.data;
		temp2.data = data;
	}
	
    /**
    * This method reverses the order of values in the linked list.
    * BC/AC/WC: O(n) 
    * SC: O(n) 
    */
	@Override
	public void reverse() {
		int i = 0, j = size - 1;
		
		for (CircularNode<AnyType> temp1 = head, temp2 = tail; temp1 != null && i < j; 
			 temp1 = temp1.next, temp2 = temp2.prev, i++, j--) {
			swap(temp1, temp2);
		}
	}
	
    /**
    * This method recursively reverses the order of values in the linked list.
    */
	public void reverseRecursive() {
		reverseRecursive(head, tail, 0, size - 1);
	}
	
	public void reverseRecursive(CircularNode<AnyType> temp1, CircularNode<AnyType> temp2, int i, int j) {
		if (temp1 == null || i >= j) {
			return; 
		}
		
		swap(temp1, temp2);
		reverseRecursive(temp1.next, temp2.prev, i + 1, j - 1);
	}
	
    /**
    * This method assigns the end of the list to the tail.
    * @param head The start of the list
    * @return CircularNode<AnyType> The tail
    */
	public CircularNode<AnyType> fixTail(CircularNode<AnyType> head) {
		for (CircularNode<AnyType> temp = head; temp != null; temp = temp.next) {
			if (temp.next == null) {
				return temp;
			}
		}
		
		return head;
	}
	
    /**
    * This method displays all the node values in the linked list. 
    */
	@Override
	public void printList() {
		if (head == null) {
			System.out.println(Constants.NULL_KEY);
		}
		else {
			for (CircularNode<AnyType> temp = head; temp != null && temp.next != head; temp = temp.next) {
				System.out.print(temp.data + " -> ");
			}
			
			System.out.println(tail.data);
		}
	}

    /**
    * This method converts the linked list to an array.
    * @return T [] The array
    */	
	@Override
	public AnyType [] storeList() {	
		List<AnyType> al = new ArrayList<>();	
		
		for (CircularNode<AnyType> temp = head; temp != null && temp.next != head; temp = temp.next) {
			al.add(temp.data);
		}
		
		
		if (tail != null) {
			al.add(tail.data);
		}

		BST<AnyType> bst = new BST<>();		
		return (AnyType []) bst.listToReferenceArray(al);
	}
	 
    /**
    * This method removes all the values in the linked list. 
    */
	@Override
	public void clear() {
		while (size > 0) {
			headDelete();
		}
	}

	// TODO: write code for this method
	@Override
	public void mergeSort() {
	}
}
