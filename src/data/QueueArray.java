package data;

import algo.Constants;
import algo.Sort;

/**
* The QueueArray class creates a FIFO queue using an array.
* @author  Damola Adebayo
* @version 1.0
* @since   2023-12-12
*/

public class QueueArray  {
	private int front, back, size, capacity;
	private int [] queue; 
	
	public QueueArray(int capacity) {
		this.capacity = capacity;
		queue = new int [capacity];
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
	
	public int getFront() {
		return front; 
	}
	
	public void setFront(int front) {
		this.front = front;
	}
	
	public int getBack() {
		return back; 
	}
	
	public void setBack(int back) {
		this.back = back;
	}
	
	public int [] getQueue() {
		return queue; 
	}
	
	public void setQueue(int [] queue) {
		this.queue = queue;
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
    * This method adds a value to the queue.
    * @param val The value to insert
    * BC/AC/WC: O(1) 
    * SC: O(1)
    */
	public void enqueue(int val) {
		if (!isFull()) {
			if (size == 0) {
				queue[back] = val;
			}
			else {
				if (back + 1 >= capacity) {
					back = -1;
				}
				
				queue[++back] = val;
			}
			
			size++;
		}
	}
	
    /**
    * This method removes a value from the queue.
    * BC/AC/WC: O(1) 
    * SC: O(1)
    */
	public void dequeue() {
		if (!isEmpty()) {
			front++;
			size--;
			
			if (size == 0) {
				front = back = 0;
			}
		}
	}
	
    /**
    * This method displays the contents of the queue. 
    */
	public void printQueue() {
		if (isEmpty()) {
			System.out.println(Constants.NULL_KEY);
			return; 
		}
		
		if (front <= back) {
			for (int i = front; i <= back; i++) {
				System.out.print(queue[i] + ((i + 1 == back) ? "\n" : " "));
			}
		}
		else {
			for (int i = front; i < queue.length; i++) {
				System.out.print(queue[i] + " ");
			}
		
			for (int i = 0; i <= back; i++) {
				System.out.print(queue[i] + " ");
			}
			
			System.out.println();
		}
	}
	
    /**
    * This method converts the queue to an array.
    * @return int [] The array
    */
	public int [] storeQueue() {	
		if (isEmpty()) {
			return new int [] {};
		}
		
		int [] arr = new int [size];
		
		if (front <= back) {
			for (int i = front; i <= back; i++) {
				arr[i - front] = queue[i];
			}
		}
		else {
			int k = 0;
			for (int i = front; i < queue.length; i++) {
				arr[k++] = queue[i];
			}
			
			for (int i = 0; i <= back; i++) {
				arr[k++] = queue[i];
			}
		}

		
		return arr;
	}
	
    /**
    * This method removes all the values in the queue. 
    */
	public void clear()	 {
		while (!isEmpty()) {
			dequeue();
		}
	}
}
