package data;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

class StackTest {
	static Integer [] res1, res2, res3, res4, res5;
	
	@BeforeAll
	static void setUpBeforeClass() {
		// push 
		res1 = new Integer [] {3};
		res2 = new Integer [] {3, 5};
		res3 = new Integer [] {3, 5, 7};
		
		// peek
		res4 = new Integer [] {5};
		res5 = new Integer [] {7};
	}

	@Test
	void push_AnyValue_AddsAValue() {
		Stack<Integer> s = new Stack<>();
		
		s.push(3);
		Integer [] arr1 = s.storeStack();
		
		s.push(5);
		Integer [] arr2 = s.storeStack();
	
		s.push(7);
		Integer [] arr3 = s.storeStack();
		

		assertArrayEquals(res1, arr1); // one item
		assertArrayEquals(res2, arr2); // two items
		assertArrayEquals(res3, arr3); // three items 
	}
	
	@Test
	void pop_AnyValue_RemovesAValue() {
		Stack<Integer> s = new Stack<>();
		
		s.push(3);		
		s.push(5);
		s.push(7);
		
		s.pop();
		Integer [] arr1 = s.storeStack();
		
		s.pop();
		Integer [] arr2 = s.storeStack();
		
		s.pop();
		Integer [] arr3 = s.storeStack();
		
		s.pop();
		Integer [] arr4 = s.storeStack();
		
		s.push(3);		
		s.push(5);
		s.push(7);
		Integer [] arr5 = s.storeStack();
		
		assertArrayEquals(res2, arr1); // removed one item
		assertArrayEquals(res1, arr2); // removed two items
		assertNull(arr3); // removed three items
		assertNull(arr4); // empty
		assertArrayEquals(res3, arr5); // restore stack 
	}
	
	@Test
	void peek_ValuesInStack_ValueOnTop() {
		Stack<Integer> s = new Stack<>();
		
		Integer out1 = s.peek();
		
		s.push(3);		
		Integer out2 = s.peek();
		
		s.push(5);
		Integer out3 = s.peek();
		
		s.push(7);
		Integer out4 = s.peek();
		
		s.push(7);
		Integer out5 = s.peek();
		
		assertNull(out1); // empty
		assertEquals(res1[0], out2); // one item
		assertEquals(res4[0], out3); // two items
		assertEquals(res5[0], out4); // three items 
		assertEquals(res5[0], out5); // full 
	}


}
