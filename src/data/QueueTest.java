package data;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

class QueueTest {
	static Integer [] res1, res2, res3, res4, res5;
	
	@BeforeAll
	static void setUpBeforeClass() {
		// enqueue 
		res1 = new Integer [] {3};
		res2 = new Integer [] {3, 5};
		res3 = new Integer [] {3, 5, 7};
		
		// dequeue
		res4 = new Integer [] {5, 7};
		res5 = new Integer [] {7};
	}

	@Test
	void enqueue_AnyValue_AddsAValue() {
		Queue<Integer> q = new Queue<>();
		
		q.enqueue(3);
		Integer [] arr1 = q.storeQueue();
		
		q.enqueue(5);
		Integer [] arr2 = q.storeQueue();
	
		q.enqueue(7);
		Integer [] arr3 = q.storeQueue();

		q.dequeue();
		q.enqueue(8);
		Integer [] arr4 = q.storeQueue();
		
		q.dequeue();
		q.enqueue(10);
		Integer [] arr5 = q.storeQueue();
		
		q.dequeue();
		q.enqueue(3);
		Integer [] arr6 = q.storeQueue();

		assertArrayEquals(res1, arr1); // one item
		assertArrayEquals(res2, arr2); // two items
		assertArrayEquals(res3, arr3); // three items 
		assertArrayEquals(new Integer [] {5, 7, 8}, arr4);
		assertArrayEquals(new Integer [] {7, 8, 10}, arr5);	
		assertArrayEquals(new Integer [] {8, 10, 3}, arr6);
	}
	
	@Test
	void dequeue_AnyValue_RemovesAValue() {
		Queue<Integer> q = new Queue<>();
		
		q.enqueue(3);		
		q.enqueue(5);
		q.enqueue(7);
		
		q.dequeue();
		Integer [] arr1 = q.storeQueue();
		
		q.dequeue();
		Integer [] arr2 = q.storeQueue();
		
		q.dequeue();
		Integer [] arr3 = q.storeQueue();
		
		q.dequeue();
		Integer [] arr4 = q.storeQueue();
		
		q.enqueue(3);		
		q.enqueue(5);
		q.enqueue(7);
		Integer [] arr5 = q.storeQueue();
		
		assertArrayEquals(res4, arr1); // removed one item
		assertArrayEquals(res5, arr2); // removed two items
		assertNull(arr3); // removed three items
		assertNull(arr4); // empty
		assertArrayEquals(res3, arr5); // restore queue
	}

}
