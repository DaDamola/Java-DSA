package data;

/**
* The AbstractList class provides method declarations
* and implements some methods common to linked lists using generics.
* @author  Damola Adebayo
* @version 1.0
* @since   2023-07-28
*/

public abstract class AbstractList<T> {
	protected int size; 

	public int getSize() {
		return size;
	}
	
	public void setSize(int size) {
		this.size = size;
	}
	
    /**
    * This method converts an array into a linked list.
    * @param arr The array to convert
    */
	public void arrayToLinkedList(T [] arr) {
		clear();
		
		for (T i : arr) {
			tailInsert(i);
		}
	}
	
    /**
    * This method adds a value in sorted order to the linked list. 
    * @param data The value to add
    */
	public abstract void insert(T data); 
	
    /**
    * This method adds a value to the start of the linked list. 
    * @param data The value to add
    */
	public abstract void headInsert(T data);
	
    /**
    * This method adds a value to the end of the linked list. 
    * @param data The value to add
    */
	public abstract void tailInsert(T data); 
	
    /**
    * This method removes the value at the start of the linked list. 
    */
	public abstract void headDelete();
	
    /**
    * This method removes the value at the end of the linked list. 
    */
	public abstract void tailDelete();
	
    /**
    * This method removes the first occurrence of the value from
    * the linked list.
    * @param data The value to remove
    */
	public abstract void delete(T data);
	
    /**
    * This method checks if the linked list contains the value.
    * @param data The value to find
    * @return boolean true if the value is found and false if the value is not found
    */ 
	public abstract boolean search(T data);	
	
    /**
    * This method reverses the order of values in the linked list.
    */
	public abstract void reverse(); 
	
    /**
    * This method arranges the linked list using merge sort. 
    */
	public abstract void mergeSort();
	
    /**
    * This method displays all the node values in the linked list. 
    */
	public abstract void printList(); 

    /**
    * This method converts the linked list to an array.
    * @return T [] The array
    */
	public abstract T [] storeList(); 

    /**
    * This method removes all the values in the linked list. 
    */
	public abstract void clear(); 
}
