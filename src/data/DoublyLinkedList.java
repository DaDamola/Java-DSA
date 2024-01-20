package data;

import java.util.ArrayList;
import java.util.List;

import algo.Constants;
import algo.Sort;

/**
* The DoublyLinkedList class creates a linked list where each node has a 
* pointer to the previous node as well as a pointer to the next node.
* It is implemented with generics.
* @author  Damola Adebayo
* @version 1.0
* @since   2023-09-20
*/

class DoublyNode<T> {
	T data; 
	DoublyNode<T> next, prev; 
	
	DoublyNode(T data) {
		this.data = data; 
	}
}

public class DoublyLinkedList<AnyType extends Comparable<AnyType>> extends AbstractList<AnyType> {
	private DoublyNode<AnyType> head, tail; 
	
	public DoublyNode<AnyType> getHead() {
		return head; 
	}
	
	public void setHead(DoublyNode<AnyType> head) {
		this.head = head; 
	}
	
	public DoublyNode<AnyType> getTail() {
		return tail; 
	}
	
	public void setTail(DoublyNode<AnyType> tail) {
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
				for (DoublyNode<AnyType> temp = head; temp != null; temp = temp.next) {
					if (data.compareTo(temp.next.data) <= 0) {
						DoublyNode<AnyType> beforeNode = temp.prev;
						DoublyNode<AnyType> afterNode = temp;
						
						DoublyNode<AnyType> newNode = new DoublyNode<>(data);
						newNode.next = afterNode;
						newNode.prev = beforeNode;
						break; 
					}
				}
				
				size++;
			}
		}
	}
	
    /**
    * This method recursively adds a value in sorted order to the linked list. 
    * @param data The value to add
    */
	public void insertRecursive(AnyType data) {
		insertRecursiveHelper(head, data);
	}
	
	public void insertRecursiveHelper(DoublyNode<AnyType> temp, AnyType data) {
		if (head == null || data.compareTo(temp.data) <= 0) {
			headInsert(data);
			return; 
		}
		else if (data.compareTo(tail.data) > 0) {
			tailInsert(data);
			return; 
		}
		else if (data.compareTo(temp.next.data) <= 0) {
			DoublyNode<AnyType> beforeNode = temp.prev;
			DoublyNode<AnyType> afterNode = temp;
			
			DoublyNode<AnyType> newNode = new DoublyNode<>(data);
			newNode.next = afterNode;
			newNode.prev = beforeNode;
			size++;
			return; 
		}
		
		insertRecursiveHelper(head.next, data);
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
			head = tail = new DoublyNode<>(data);
		}
		else {
			DoublyNode<AnyType> newHead = new DoublyNode<>(data);
			newHead.next = head; 
			head.prev = newHead;
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
			DoublyNode<AnyType> newTail = new DoublyNode<>(data);
			tail.next = newTail; 
			newTail.prev = tail; 
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
			head = head.next; 
			
			if (head != null) {
				head.prev = null; 
			}
			else {
				tail = null; 
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
		if (head == tail) {
			headDelete();
		}
		else {
			DoublyNode<AnyType> newTail = tail.prev; 
			newTail.next = null; 
			tail = newTail; 
			
			size--;
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
			if (data.compareTo(head.data) == 0) {
				headDelete();
			}
			else {
				for (DoublyNode<AnyType> temp = head; temp != null; temp = temp.next) {
					if (data.compareTo(temp.data) == 0) {
						if (temp == tail) {
							tailDelete();
							break; 
						}
						else {
							DoublyNode<AnyType> beforeNode = temp.prev;
							DoublyNode<AnyType> afterNode = temp.next;
							beforeNode.next = afterNode;
							
							if (afterNode != null) {
								afterNode.prev = beforeNode; 
							}
							
							size--;
							break; 
						}
					}
				}
			}
		}
	}
	
    /**
    * This method recursively removes the first occurrence of the value from
    * the linked list.
    * @param data The value to remove
    */
	public void deleteRecursive(AnyType data) {
		deleteRecursiveHelper(head, data);
	}
	
	public void deleteRecursiveHelper(DoublyNode<AnyType> temp, AnyType data) {
		if (temp == null) {
			return; 
		}
		if (head.data == data) { 
			headDelete();
			return; 
		}
		else if (temp == tail && temp.data == data) {
			tailDelete();
			return; 
		}
		else if (temp.data == data) {
			DoublyNode<AnyType> beforeNode = temp.prev;
			DoublyNode<AnyType> afterNode = temp.next;
			beforeNode.next = afterNode;
			
			if (afterNode != null) {
				afterNode.prev = beforeNode; 
			}
			
			size--;
			return; 
		}
		
		deleteRecursiveHelper(temp.next, data);
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
		DoublyNode<AnyType> temp = head; 
		
		while (temp != null) {
			if (key.compareTo(temp.data) == 0) {
				return true;
			}
			
			temp = temp.next; 
		}
		
		return false;
 	}
	
    /**
    * This method recursively checks if the linked list contains the value.
    * @param data The value to find
    * @return boolean true if the value is found and false if the value is not found
    */ 
	public boolean searchRecursive(AnyType key) {
		return searchRecursiveHelper(head, key);
 	}
	
	public boolean searchRecursiveHelper(DoublyNode<AnyType> temp, AnyType key) {
		if (temp == null) {
			return false; 
		}
		else if (key.compareTo(temp.data) == 0) {
			return true;
		}
		
		return searchRecursiveHelper(temp.next, key);
 	}
	
    /**
    * This method switches the values between these two nodes.
    * @param temp1 The first node
    * @param temp2 The second node
    */
	public void swap(DoublyNode<AnyType> temp1, DoublyNode<AnyType> temp2) {
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
		for (DoublyNode<AnyType> temp1 = head, temp2 = tail; temp1 != null && temp2 != null && temp1 != temp2
			 && temp1.prev != temp2; 
			 temp1 = temp1.next, temp2 = temp2.prev) {
			swap(temp1, temp2);
		}
	}
	
    /**
    * This method recursively reverses the order of values in the linked list.
    */
	public void reverseRecursive() {		
		reverseRecursiveHelper(head, tail);
	}
	
	public void reverseRecursiveHelper(DoublyNode<AnyType> temp1, DoublyNode<AnyType> temp2) {
		if (temp1 == null || temp2 == null || temp1 == temp2 || temp1.prev == temp2) {
			return; 
		}
		
		swap(temp1, temp2);
		reverseRecursiveHelper(temp1.next, temp2.prev);
	}
	
    /**
    * This method assigns the end of the list to the tail.
    * @param head The start of the list
    * @return DoublyNode<AnyType> The tail
    */
	public DoublyNode<AnyType> fixTail(DoublyNode<AnyType> head) {
		for (DoublyNode<AnyType> temp = head; temp != null; temp = temp.next) {
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
	
	public DoublyNode<AnyType> mergeSortHelper(DoublyNode<AnyType> start) {
		if (start == null || start.next == null) {
			return start;
		}
		
		DoublyNode<AnyType> temp = null;
		DoublyNode<AnyType> mid = null;
		
		for (temp = start; temp != null && temp.next != null; temp = temp.next.next) {
			mid = (mid == null) ?  start : mid.next;
		}
		
		temp = mid.next;
		mid.next = null;
		mid = temp;
		
		start = mergeSortHelper(start);
		mid = mergeSortHelper(mid);
		
		DoublyNode<AnyType> head = null;
		DoublyNode<AnyType> tail = null;
		
		while (start != null || mid != null) {
			DoublyNode<AnyType> newTail = null;
			
			if (start == null || (mid != null && mid.data.compareTo(start.data) < 0)) {
				newTail = mid;
				mid = mid.next;
			}
			else {
				newTail = start;
				start = start.next;
			}
			
			if (head == null) {
				head = tail = new DoublyNode<>(newTail.data);
			}
			else {
				tail.next = new DoublyNode<>(newTail.data);
				tail.next.prev = tail;
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
			for (DoublyNode<AnyType> temp = head; temp != null; temp = temp.next) {
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
		
		for (DoublyNode<AnyType> temp = head; temp != null; temp = temp.next) {
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
