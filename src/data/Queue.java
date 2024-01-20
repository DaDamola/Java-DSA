package data;

import algo.Constants;

/**
* The Queue class creates a FIFO queue to store generic values.
* @author  Damola Adebayo
* @version 1.0
* @since   2023-11-26
*/

public class Queue<AnyType extends Comparable<AnyType>> implements QueueInterface<AnyType> {
	private DoublyLinkedList<AnyType> dl;
	
	{
		dl = new DoublyLinkedList<>();
	}
	
	public DoublyLinkedList<AnyType> getList() {
		return dl;
	}
	
	public void setList(DoublyLinkedList<AnyType> dl) {
		this.dl = dl; 
	}
	
    /**
    * This method determines if the queue is empty.
    * @return boolean true if the queue is has no values and false if the queue contains values
    */
	@Override
	public boolean isEmpty() {
		return dl.size == 0;
	}
	
    /**
    * This method determines if the queue is full.
    * @return boolean true if the queue is filled and false if the queue can hold more values
    */
	@Override
	public boolean isFull() {
		return false;
	}
	
    /**
    * This method adds a value to the queue.
    * @param val The value to insert
    * BC/AC/WC: O(1) 
    * SC: O(1)
    */
	@Override
	public void enqueue(AnyType val) {
		dl.tailInsert(val);
	}
	
    /**
    * This method removes a value from the queue.
    * BC/AC/WC: O(1) 
    * SC: O(1)
    */
	@Override
	public void dequeue() {
		dl.headDelete();
	}
	
    /**
    * This method displays the contents of the queue. 
    */
	@Override
	public void printQueue() {
		if (isEmpty()) {
			System.out.println(Constants.NULL_KEY);
			return;
		}
		
		for (DoublyNode<AnyType> temp = dl.getHead(); temp != null; temp = temp.next) {
			System.out.print(temp.data + ((temp.next == null) ?  "\n" : " "));
		}
	}
	
    /**
    * This method converts the queue to an array.
    * @return T [] The array
    */
	@Override
	public AnyType [] storeQueue() {		
		return dl.storeList();
	}
	
    /**
    * This method removes all the values in the queue. 
    */
	@Override
	public void clear()	 {
		dl.clear();
	}
}
