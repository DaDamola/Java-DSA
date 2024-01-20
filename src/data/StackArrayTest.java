package data;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

class StackArrayTest {
	static int [] res1, res2, res3, res4, res5;
	
	@BeforeAll
	static void setUpBeforeClass() {
		// push 
		res1 = new int [] {3};
		res2 = new int [] {3, 5};
		res3 = new int [] {3, 5, 7};
		
		// peek
		res4 = new int [] {5};
		res5 = new int [] {7};
	}

	@Test
	void push_AnyValue_AddsAValue() {
		StackArray sa = new StackArray(3);
		
		sa.push(3);
		int [] arr1 = sa.storeStack();
		
		sa.push(5);
		int [] arr2 = sa.storeStack();
		
		sa.push(7);
		int [] arr3 = sa.storeStack();
		
		sa.push(9);
		int [] arr4 = sa.storeStack();

		assertArrayEquals(res1, arr1); // one item
		assertArrayEquals(res2, arr2); // two items
		assertArrayEquals(res3, arr3); // three items
		assertArrayEquals(res3, arr4); // full 
	}
	
	@Test
	void pop_AnyValue_RemovesAValue() {
		StackArray sa = new StackArray(3);
		
		sa.push(3);		
		sa.push(5);
		sa.push(7);
		
		sa.pop();
		int [] arr1 = sa.storeStack();
		
		sa.pop();
		int [] arr2 = sa.storeStack();
		
		sa.pop();
		int [] arr3 = sa.storeStack();
		
		sa.pop();
		int [] arr4 = sa.storeStack();
		
		sa.push(3);		
		sa.push(5);
		sa.push(7);
		int [] arr5 = sa.storeStack();
		
		assertArrayEquals(res2, arr1); // removed one item
		assertArrayEquals(res1, arr2); // removed two items
		assertArrayEquals(new int [] {}, arr3); // removed three items
		assertArrayEquals(new int [] {}, arr4); // empty
		assertArrayEquals(res3, arr5); // restore stack 
	}
	
	@Test
	void peek_ValuesInStack_ValueOnTop() {
		StackArray sa = new StackArray(3);
		
		int out1 = sa.peek();
		
		sa.push(3);		
		int out2 = sa.peek();
		
		sa.push(5);
		int out3 = sa.peek();
		
		sa.push(7);
		int out4 = sa.peek();
		
		sa.push(7);
		int out5 = sa.peek();
		
		assertEquals(Integer.MIN_VALUE, out1); // empty
		assertEquals(res1[0], out2); // one item
		assertEquals(res4[0], out3); // two items
		assertEquals(res5[0], out4); // three items 
		assertEquals(res5[0], out5); // full 
	}
	
	@Test
	void clear_ValuesInStack_RemovesAllValues() {
		StackArray sa = new StackArray(3);
		
		sa.push(3);		
		sa.push(5);
		sa.push(7);
		
		sa.clear();
		
		assertArrayEquals(new int [] {}, sa.storeStack());
		assertEquals(0, sa.getSize());
	}
	
	@Test
	void push_NoValuesInStackAfterClear_AddsAValue() {
		StackArray sa = new StackArray(3);
		
		sa.push(3);		
		sa.push(5);
		sa.push(7);
		
		sa.clear();
		
		assertArrayEquals(new int [] {}, sa.storeStack());
		assertEquals(0, sa.getSize());
		
		sa.push(3);
		int [] arr1 = sa.storeStack();
		
		assertArrayEquals(res1, arr1); // one item
	}

}
