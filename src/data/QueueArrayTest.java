package data;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

class QueueArrayTest {
	static int [] res1, res2, res3, res4, res5;
	
	@BeforeAll
	static void setUpBeforeClass() {
		// enqueue 
		res1 = new int [] {3};
		res2 = new int [] {3, 5};
		res3 = new int [] {3, 5, 7};
		
		// dequeue
		res4 = new int [] {5, 7};
		res5 = new int [] {7};
	}
	
	@Test
	void enqueue_AnyValue_AddsAValue() {
		QueueArray q = new QueueArray(3);
		
		q.enqueue(3);
		int [] arr1 = q.storeQueue();
		
		q.enqueue(5);
		int [] arr2 = q.storeQueue();
	
		q.enqueue(7);
		int [] arr3 = q.storeQueue();
		
		q.dequeue();
		q.enqueue(8);
		int [] arr4 = q.storeQueue();
		
		q.dequeue();
		q.enqueue(10);
		int [] arr5 = q.storeQueue();
		
		q.dequeue();
		q.enqueue(3);
		int [] arr6 = q.storeQueue();

		assertArrayEquals(res1, arr1); // one item
		assertArrayEquals(res2, arr2); // two items
		assertArrayEquals(res3, arr3); // three items 
		assertArrayEquals(new int [] {5, 7, 8}, arr4);
		assertArrayEquals(new int [] {7, 8, 10}, arr5);	
		assertArrayEquals(new int [] {8, 10, 3}, arr6);
	}
	
	@Test
	void dequeue_AnyValue_RemovesAValue() {
		QueueArray q = new QueueArray(3);
		
		q.enqueue(3);		
		q.enqueue(5);
		q.enqueue(7);
		
		q.dequeue();
		int [] arr1 = q.storeQueue();
		
		q.dequeue();
		int [] arr2 = q.storeQueue();
		
		q.dequeue();
		int [] arr3 = q.storeQueue();
		
		q.dequeue();
		int [] arr4 = q.storeQueue();
		
		q.enqueue(3);		
		q.enqueue(5);
		q.enqueue(7);
		int [] arr5 = q.storeQueue();
		
		assertArrayEquals(res4, arr1); // removed one item
		assertArrayEquals(res5, arr2); // removed two items
		assertArrayEquals(new int [] {}, arr3); // removed three items
		assertArrayEquals(new int [] {}, arr4); // empty
		assertArrayEquals(res3, arr5); // restore queue
	}
	
	@Test
	void clear_ValuesInQueue_RemovesAllValues() {
		QueueArray q = new QueueArray(3);
		
		q.enqueue(3);		
		q.enqueue(5);
		q.enqueue(7);
		
		q.clear();
		
		assertArrayEquals(new int [] {}, q.storeQueue());
		assertEquals(0, q.getSize());
	}
	
	@Test
	void enqueue_NoValuesInQueueAfterClear_AddsAValue() {
		QueueArray q = new QueueArray(3);
		
		q.enqueue(3);		
		q.enqueue(5);
		q.enqueue(7);
		
		q.clear();
		
		assertArrayEquals(new int [] {}, q.storeQueue());
		assertEquals(0, q.getSize());
		
		q.enqueue(3);
		int [] arr1 = q.storeQueue();
		
		assertArrayEquals(res1, arr1); // one item
	}
}
