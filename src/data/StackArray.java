package data;

import java.util.LinkedList;

import algo.Constants;

/**
* The Stack class creates a LIFO stack using an array.
* @author  Damola Adebayo
* @version 1.0
* @since   2024-1-8
*/

public class StackArray {
	private int [] stack;
	private int size, capacity;
	
	public StackArray(int capacity) {
		this.capacity = capacity;
		stack = new int [capacity]; 
	}
	
	public int getSize() {
		return size; 
	}
	
	public void setSize(int size) {
		this.size = size;
	}
	
	public int getCapacity() {
		return capacity; 
	}
	
	public void setCapacity(int capacity) {
		this.capacity = capacity;
	}
	
	public int [] getStack() {
		return stack; 
	}
	
	public void setStack(int [] stack) {
		this.stack = stack;
	}
	
    /**
    * This method determines if the queue is empty.
    * @return boolean true if the queue is has no values and false if the queue contains values
    */
	public boolean isEmpty() {
		return size == 0;
	}
	
    /**
    * This method determines if the queue is full.
    * @return boolean true if the queue is filled and false if the queue can hold more values
    */
	public boolean isFull() {
		return size == capacity;
	}
	
    /**
    * This method adds a value to the stack.
    * @param val The value to insert
    * BC/AC/WC: O(1) 
    *  SC: O(1)
    */
	public void push(int val) {
		if (!isFull()) {
			stack[size++] = val;
		}
	}
	
    /**
    * This method removes a value from the stack.
    * BC/AC/WC: O(1) 
    * SC: O(1)
    */
	public void pop() {
		if (!isEmpty()) {
			size--; 
		}
	}
	
    /**
    * This method retrieves the value at the top of the stack.
    * @return T The value
    * BC/AC/WC: O(1) 
    * SC: O(1)
    */
	public int peek() {
		return !isEmpty() ?  stack[size - 1] : Constants.EMPTY;
	}

    /**
    * This method displays the contents of the stack. 
    */
	public void printStack() {
		if (isEmpty()) {
			System.out.println(Constants.NULL_KEY);
		}
		
		for (int i = size - 1; i >= 0; i--) {
			System.out.println(stack[i]);
			System.out.println("----------");
		}
		
		System.out.println();
	}
	
    /**
    * This method converts the stack to an array.
    * @return T [] The array
    */
	public int [] storeStack() {
		LinkedList<Integer> ls = new LinkedList<>();
		
		if (!isEmpty()) {
			for (int i = size - 1; i >= 0; i--) {
				ls.addFirst(stack[i]);
			}
		}
			
		return ls.stream().mapToInt(i -> i).toArray();
	}
	
    /**
    * This method removes all the values in the stack. 
    */
	public void clear() {
		while (!isEmpty()) {
			pop();
		}
	}
}
