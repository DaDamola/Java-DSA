package data;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

import algo.Constants;

/**
* The SinglyLinkedList class creates a linked list where each node has a 
* pointer to the next node. It is implemented with generics.
* @author  Damola Adebayo
* @version 1.0
* @since   2023-10-07
*/

class Node<T> {
	T data;
	Node<T> next; 
	
	Node(T data) {
		this.data = data;
	}
}

public class SinglyLinkedList<AnyType extends Comparable<AnyType>> extends AbstractList<AnyType> {
	private Node<AnyType> head, tail; 
	
	public Node<AnyType> getHead() {
		return head; 
	}
	
	public void setHead(Node<AnyType> head) {
		this.head = head; 
	}
	
	public Node<AnyType> getTail() {
		return tail; 
	}
	
	public void setTail(Node<AnyType> tail) {
		this.tail = tail; 
	}
	
    /**
    * This method adds a value in sorted order to the linked list. 
    * @param data The value to add
    * BC: O(1) AC/WC: O(n) 
    * SC: O(1) 
    */
	@Override
	public void insert(AnyType data) {
		if (head == null || data.compareTo(head.data) <= 0) {
			headInsert(data);
		}
		else {
			if (data.compareTo(tail.data) > 0) {
				tailInsert(data);
			}
			else {
				for (Node<AnyType> temp = head; temp != null; temp = temp.next) {
					if (temp.next != null && data.compareTo(temp.next.data) <= 0) {
						Node<AnyType> newNode = new Node<>(data);
						Node<AnyType> next = temp.next;	
						temp.next = newNode;
						newNode.next = next; 
						
						size++;
						break; 
					}
				}
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
	
	public void insertRecursive(Node<AnyType> temp, AnyType data) {
		if (temp == null || data.compareTo(temp.data) <= 0) { 
			headInsert(data);
			return; 
		}
		else if (data.compareTo(tail.data) > 0) {
			tailInsert(data);
			return; 
		}
		else if (temp.next != null && data.compareTo(temp.next.data) <= 0){
			Node<AnyType> newNode = new Node<>(data);
			Node<AnyType> next = temp.next;	
			temp.next = newNode;
			newNode.next = next; 
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
		if (head != null) {
			Node<AnyType> newHead = new Node<>(data);
			newHead.next = head;
			head = newHead;
		}
		else {
			head = tail = new Node<>(data);
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
		if (tail != null) {
			tail.next = new Node<>(data);
			tail = tail.next;
			size++;
		} 
		else {
			headInsert(data);
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
			if (head == tail) {
				tail = null;
			}
			
			head = head.next;
		}
		
		size--;
	}
	
    /**
    * This method removes the value at the end of the linked list. 
    * BC/AC/WC: O(n) 
    * SC: O(1) 
    */
	@Override
	public void tailDelete() {
		if (head == tail) {
			headDelete();
		}
		else {
			Node<AnyType> temp = head;
			
			while (temp.next.next != null) {
				temp = temp.next;
			}
			
			temp.next = null;
			tail = temp;
			size--;
		}
	}
	
    /**
    * This method recursively removes the value at the end of the linked list. 
    */
	public void tailDeleteRecursive() {
		tailDeleteRecursive(head);
	}
	
	public void tailDeleteRecursive(Node<AnyType> temp) {
		if (head == tail) {
			headDelete();
			return; 
		}
		else if (temp.next == tail) {
			temp.next = null; 
			tail = temp; 
			size--;
			return; 
		}
		
		tailDeleteRecursive(temp.next);
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
			if (data.compareTo(head.data) == 0) {
				headDelete();
			}
			else {
				for (Node<AnyType> temp = head; temp != null; temp = temp.next) {
					if (temp.next != null && data.compareTo(temp.next.data) == 0) {
						if (tail == temp.next) {
							tailDelete();
							return; 
						}
						else {
							temp.next = temp.next.next;
						}			
					}
					
				}
				
				size--;
			}
		}
	}
	
    /**
    * This method recursively removes the first occurrence of the value from
    * the linked list.
    * @param data The value to remove
    */
	public void deleteRecursive(AnyType data) {
		deleteRecursive(head, data);
	}
	
	public void deleteRecursive(Node<AnyType> temp, AnyType data) {
		if (temp == null) {
			return; 
		}
		else if (temp == head && data.compareTo(temp.data) == 0) {
			headDelete();
			return; 
		}
		else if (temp.next != null && data.compareTo(temp.next.data) == 0) {
			if (tail == temp.next) {
				tailDelete();
				return; 
			}
			else {
				temp.next = temp.next.next;
				size--;
				return;
			}		
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
	public boolean search(AnyType key) {
		for (Node<AnyType> temp = head; temp != null; temp = temp.next) {
			if (key.compareTo(temp.data) == 0) {
				return true; 
			}
		}
		
		return false;
	}
	
    /**
    * This method recursively checks if the linked list contains the value.
    * @param data The value to find
    * @return boolean true if the value is found and false if the value is not found
    */ 
	public boolean searchRecursive(AnyType key) {
		return searchRecursive(head, key);
	}
	
	public boolean searchRecursive(Node<AnyType> temp, AnyType key) {
		if (temp == null) {
			return false;
		}
		else if (key.compareTo(temp.data) == 0) {
			return true; 
		}
		
		return searchRecursive(temp.next, key);
	}
	
    /**
    * This method reverses the order of values in the linked list.
    * BC/AC/WC: O(n) 
    * SC: O(n)
    */
	@Override
	public void reverse() {
		Stack<AnyType> s = new Stack<>();
		
		for (Node<AnyType> temp = head; temp != null; temp = temp.next) {
			s.push(temp.data);
		}
		
		for (Node<AnyType> temp = head; temp != null; temp = temp.next) {
			temp.data = s.pop();
		}
	}
	
    /**
    * This method recursively reverses the order of values in the linked list.
    */
	public void reverseRecursive() {
		ArrayDeque<AnyType> q = new ArrayDeque<>();
		reverseRecursive(head, q);
	}
	
	public void reverseRecursive(Node<AnyType> temp, ArrayDeque<AnyType> q) {
		if (temp == null) {
			return; 
		}
		
		q.add(temp.data);
		reverseRecursive(temp.next, q);
		temp.data = q.removeFirst();	
	}
	
    /**
    * This method assigns the end of the list to the tail.
    * @param head The start of the list
    * @return Node<AnyType> The tail
    */
	public Node<AnyType> fixTail(Node<AnyType> head) {
		for (Node<AnyType> temp = head; temp != null; temp = temp.next) {
			if (temp.next == null) {
				return temp;
			}
		}
		
		return head;
	}
	
    /**
    * This method arranges the linked list using merge sort. 
    * BC/AC/WC: O(n log n)
    * SC: O(n) 
    */
	@Override
	public void mergeSort() {
		head = mergeSortHelper(head);
		tail = fixTail(head);
	}
	
	public Node<AnyType> mergeSortHelper(Node<AnyType> start) {
		if (start == null || start.next == null) {
			return start;
		}
		
		Node<AnyType> temp = null;
		Node<AnyType> mid = null;
		
		for (temp = start; temp != null && temp.next != null; temp = temp.next.next) {
			mid = (mid == null) ?  start : mid.next;
		}
		
		temp = mid.next;
		mid.next = null;
		mid = temp;
		
		start = mergeSortHelper(start);
		mid = mergeSortHelper(mid);
		
		Node<AnyType> head = null;
		Node<AnyType> tail = null;
		
		while (start != null || mid != null) {
			Node<AnyType> newTail = null;
			
			if (start == null || (mid != null && mid.data.compareTo(start.data) < 0)) {
				newTail = mid;
				mid = mid.next;
			}
			else {
				newTail = start;
				start = start.next;
			}
			
			if (head == null) {
				head = tail = new Node<>(newTail.data);
			}
			else {
				tail.next = new Node<>(newTail.data);
				tail = tail.next;
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
			for (Node<AnyType> temp = head; temp != null; temp = temp.next) {
				System.out.print(temp.data + ((temp.next != null) ? " -> " : "\n"));
			}
		}
	}

    /**
    * This method converts the linked list to an array.
    * @return T [] The array
    */
	@Override
	public AnyType [] storeList() {
		List<AnyType> al = new ArrayList<>();
		
		for (Node<AnyType> temp = head; temp != null; temp = temp.next) {
			al.add(temp.data);
		}
		
		BST<AnyType> bst = new BST<>();		
		return (AnyType[]) bst.listToReferenceArray(al);
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
}
