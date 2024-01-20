package data;

import java.util.LinkedList;

import algo.Constants;

/**
* The Stack class creates a LIFO stack to store generic values.
* @author  Damola Adebayo
* @version 1.0
* @since   2023-12-29
*/

public class Stack<AnyType extends Comparable<AnyType>> implements StackInterface<AnyType> {
	private SinglyLinkedList<AnyType> sl;
	
	{
		sl = new SinglyLinkedList<>();
	}
	
	public SinglyLinkedList<AnyType> getList() {
		return sl;
	}
	
	public void setList(SinglyLinkedList<AnyType> sl) {
		this.sl = sl; 
	}
	
    /**
    * This method determines if the queue is empty.
    * @return boolean true if the queue is has no values and false if the queue contains values
    */
	@Override
	public boolean isEmpty() {
		return sl.size == 0;
	}
	
    /**
    * This method adds a value to the stack.
    * @param val The value to insert
    */
	@Override
	public boolean isFull() {
		return false;
	}
	
    /**
    * This method adds a value to the stack.
    * @param val The value to insert
    * BC/AC/WC: O(1) 
    * SC: O(1)
    */
	@Override
	public void push(AnyType val) {
		sl.headInsert(val);
	}
	
    /**
    * This method removes a value from the stack.
    * BC/AC/WC: O(1) 
    * SC: O(1)
    */
	@Override
	public void pop() {
		sl.headDelete();
	}
	
    /**
    * This method retrieves the value at the top of the stack.
    * @return T The value
    * BC/AC/WC: O(1) 
    * SC: O(1)
    */
	@Override
	public AnyType peek() {
		return isEmpty() ? null : sl.getHead().data;
	}
	
    /**
    * This method displays the contents of the stack. 
    */
	@Override
	public void printStack() {
		if (isEmpty()) {
			System.out.println(Constants.NULL_KEY);
			return;
		}
		
		for (Node<AnyType> temp = sl.getHead(); temp != null; temp = temp.next) {
			System.out.println(temp.data);
			System.out.println("----------");
		}
		
		System.out.println();
	}
	
    /**
    * This method converts the stack to an array.
    * @return T [] The array
    */
	@Override
	public AnyType [] storeStack() {
		LinkedList<AnyType> ls = new LinkedList<>();
		
		for (Node<AnyType> temp = sl.getHead(); temp != null; temp = temp.next) {
			ls.addFirst(temp.data);
		}
		
		BST<AnyType> bst = new BST<>();		
		return (AnyType[]) bst.listToReferenceArray(ls);
	}
	
    /**
    * This method removes all the values in the stack. 
    */
	@Override
	public void clear()	 {
		sl.clear();
	}
}
