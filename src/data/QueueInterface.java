package data;

/**
* The QueueInterface provides method declarations common to queues.
* @author  Damola Adebayo
* @version 1.0
* @since   2023-11-26
*/

public interface QueueInterface<T> {
    /**
    * This method determines if the queue is empty.
    * @return boolean true if the queue is has no values and false if the queue contains values
    */
	public abstract boolean isEmpty();
	
    /**
    * This method determines if the queue is full.
    * @return boolean true if the queue is filled and false if the queue can hold more values
    */
	public abstract boolean isFull();
	
    /**
    * This method adds a value to the queue.
    * @param val The value to insert
    */
	public abstract void enqueue(T val);
	
    /**
    * This method removes a value from the queue.
    */
	public abstract void dequeue();
	
    /**
    * This method displays the contents of the queue. 
    */
	public abstract void printQueue();
	
    /**
    * This method converts the queue to an array.
    * @return T [] The array
    */
	public abstract T [] storeQueue();
	
    /**
    * This method removes all the values in the queue. 
    */
	public abstract void clear();
}
