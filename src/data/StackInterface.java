package data;

/**
* The StackInterface provides method declarations common to stacks.
* @author  Damola Adebayo
* @version 1.0
* @since   2023-12-20
*/

public interface StackInterface<T> {
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
    * This method adds a value to the stack.
    * @param val The value to insert
    */
	public abstract void push(T val);
	
    /**
    * This method removes a value from the stack.
    */
	public abstract void pop();
	
    /**
    * This method retrieves the value at the top of the stack.
    * @return T The value
    */
	public abstract T peek();
	
    /**
    * This method displays the contents of the stack. 
    */
	public abstract void printStack();
	
    /**
    * This method converts the stack to an array.
    * @return T [] The array
    */
	public abstract T [] storeStack();
	
    /**
    * This method removes all the values in the stack. 
    */
	public abstract void clear();
}
