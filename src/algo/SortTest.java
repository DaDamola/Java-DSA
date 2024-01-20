package algo;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class SortTest {
	static int [] arr1, arr2, arr3, arr4, arr5, arr6, arr7, arr8, arr9, arr10,
	arr11, arr12;
	static int [] res1, res2, res3, res4, res5, res6, res7, res8, res9, res10,
	res11, res12;
	
	@BeforeEach
	void setup() {  
		arr1 = new int [] {4, -2, -6, 5, 2, 1}; // mixed numbers, even length
		res1 = new int [] {-6, -2, 1, 2, 4, 5};
		
		arr2 = new int [] {9, 2, 0, 3, 5, 1}; // positive numbers, even length
		res2 = new int [] {0, 1, 2, 3, 5, 9};
		
		arr3 = new int [] {-9, -2, -7, -3, -5, -1}; // negative numbers, even length
		res3 = new int [] {-9, -7, -5, -3, -2, -1};
		
		arr4 = new int [] {-9, 2, -7, 3, -5, 1, 2}; // duplicate numbers, even length
		res4 = new int [] {-9, -7, -5, 1, 2, 2, 3};
		
		arr5 = new int [] {-9, 2, -7, 3, -5, 1, 2}; // duplicate numbers, odd length
		res5 = new int [] {-9, -7, -5, 1, 2, 2, 3};
		
		arr6 = new int [] {-9, -2, -7, -3, -5}; // negative numbers, odd length
		res6 = new int [] {-9, -7, -5, -3, -2};
		
		arr7 = new int [] {9, 2, 0, 3, 5}; // positve numbers, odd length
		res7 = new int [] {0, 2, 3, 5, 9};
		
		arr8 = new int [] {4, -2, -6, 5, 2}; // mixed numbers, odd length
		res8 = new int [] {-6, -2, 2, 4, 5};
		
		arr9 = new int [] {-6, -2, 1, 2, 4, 5}; // sorted
		res9 = new int [] {-6, -2, 1, 2, 4, 5};
		
		arr10 = new int [] {5, 4, 2, 1, -2, -6}; // reverse sorted
		res10 = new int [] {-6, -2, 1, 2, 4, 5};
		
		arr11 = new int [] {}; // empty
		res11 = new int [] {};
		
		arr12 = null;
		res12 = null;
	}
	
	
	@Test
	void bubbleSort_UnsortedArray_SortsArray() {	
		Sort.bubbleSort(arr1);
		assertArrayEquals(res1, arr1);
		
		Sort.bubbleSort(arr2);
		assertArrayEquals(res2, arr2);
		
		Sort.bubbleSort(arr3);
		assertArrayEquals(res3, arr3);
		
		Sort.bubbleSort(arr4);
		assertArrayEquals(res4, arr4);
		
		Sort.bubbleSort(arr5);
		assertArrayEquals(res5, arr5);
		
		Sort.bubbleSort(arr6);
		assertArrayEquals(res6, arr6);
		
		Sort.bubbleSort(arr7);
		assertArrayEquals(res7, arr7);
		
		Sort.bubbleSort(arr8);
		assertArrayEquals(res8, arr8);
		
		Sort.bubbleSort(arr9);
		assertArrayEquals(res9, arr9);
		
		Sort.bubbleSort(arr10);
		assertArrayEquals(res10, arr10);
		
		Sort.bubbleSort(arr11);
		assertArrayEquals(new int [] {}, arr11);
		
		Sort.bubbleSort(arr12);
		assertArrayEquals(null, arr12);
	}
	
	@Test
	void bubbleSortRecursive_UnsortedArray_SortsArray() {	
		Sort.bubbleSortRecursive(arr1);
		assertArrayEquals(res1, arr1);
		
		Sort.bubbleSortRecursive(arr2);
		assertArrayEquals(res2, arr2);
		
		Sort.bubbleSortRecursive(arr3);
		assertArrayEquals(res3, arr3);
		
		Sort.bubbleSortRecursive(arr4);
		assertArrayEquals(res4, arr4);
		
		Sort.bubbleSortRecursive(arr4);
		assertArrayEquals(res4, arr4);
		
		Sort.bubbleSortRecursive(arr5);
		assertArrayEquals(res5, arr5);
		
		Sort.bubbleSortRecursive(arr6);
		assertArrayEquals(res6, arr6);
		
		Sort.bubbleSortRecursive(arr7);
		assertArrayEquals(res7, arr7);
		
		Sort.bubbleSortRecursive(arr8);
		assertArrayEquals(res8, arr8);
		
		Sort.bubbleSortRecursive(arr9);
		assertArrayEquals(res9, arr9);
		
		Sort.bubbleSortRecursive(arr10);
		assertArrayEquals(res10, arr10);
		
		Sort.bubbleSortRecursive(arr11);
		assertArrayEquals(new int [] {}, arr11);
		
		Sort.bubbleSortRecursive(arr12);
		assertArrayEquals(null, arr12);
	}
	
	@Test
	void selectionSort_UnsortedArray_SortsArray() {	
		Sort.selectionSort(arr1);
		assertArrayEquals(res1, arr1);
		
		Sort.selectionSort(arr2);
		assertArrayEquals(res2, arr2);
		
		Sort.selectionSort(arr3);
		assertArrayEquals(res3, arr3);
		
		Sort.selectionSort(arr4);
		assertArrayEquals(res4, arr4);
		
		Sort.selectionSort(arr5);
		assertArrayEquals(res5, arr5);
		
		Sort.selectionSort(arr6);
		assertArrayEquals(res6, arr6);
		
		Sort.selectionSort(arr7);
		assertArrayEquals(res7, arr7);
		
		Sort.selectionSort(arr8);
		assertArrayEquals(res8, arr8);
		
		Sort.selectionSort(arr9);
		assertArrayEquals(res9, arr9);
		
		Sort.selectionSort(arr10);
		assertArrayEquals(res10, arr10);
		
		Sort.selectionSort(arr11);
		assertArrayEquals(new int [] {}, arr11);
		
		Sort.selectionSort(arr12);
		assertArrayEquals(null, arr12);
	}
	
	@Test
	void selectionSortRecursive_UnsortedArray_SortsArray() {	
		Sort.selectionSortRecursive(arr1);
		assertArrayEquals(res1, arr1);
		
		Sort.selectionSortRecursive(arr2);
		assertArrayEquals(res2, arr2);
		
		Sort.selectionSortRecursive(arr3);
		assertArrayEquals(res3, arr3);
		
		Sort.selectionSortRecursive(arr4);
		assertArrayEquals(res4, arr4);
		
		Sort.selectionSortRecursive(arr5);
		assertArrayEquals(res5, arr5);
		
		Sort.selectionSortRecursive(arr6);
		assertArrayEquals(res6, arr6);
		
		Sort.selectionSortRecursive(arr7);
		assertArrayEquals(res7, arr7);
		
		Sort.selectionSortRecursive(arr8);
		assertArrayEquals(res8, arr8);
		
		Sort.selectionSortRecursive(arr9);
		assertArrayEquals(res9, arr9);
		
		Sort.selectionSortRecursive(arr10);
		assertArrayEquals(res10, arr10);
		
		Sort.selectionSortRecursive(arr11);
		assertArrayEquals(new int [] {}, arr11);
		
		Sort.selectionSortRecursive(arr12);
		assertArrayEquals(null, arr12);
	}
	
	@Test
	void insertionSort_UnsortedArray_SortsArray() {	
		Sort.insertionSort(arr1);
		assertArrayEquals(res1, arr1);
		
		Sort.insertionSort(arr2);
		assertArrayEquals(res2, arr2);
		
		Sort.insertionSort(arr3);
		assertArrayEquals(res3, arr3);
		
		Sort.insertionSort(arr4);
		assertArrayEquals(res4, arr4);
		
		Sort.insertionSort(arr5);
		assertArrayEquals(res5, arr5);
		
		Sort.insertionSort(arr6);
		assertArrayEquals(res6, arr6);
		
		Sort.insertionSort(arr7);
		assertArrayEquals(res7, arr7);
		
		Sort.insertionSort(arr8);
		assertArrayEquals(res8, arr8);
		
		Sort.insertionSort(arr9);
		assertArrayEquals(res9, arr9);
		
		Sort.insertionSort(arr10);
		assertArrayEquals(res10, arr10);
		
		Sort.insertionSort(arr11);
		assertArrayEquals(new int [] {}, arr11);
		
		Sort.insertionSort(arr12);
		assertArrayEquals(null, arr12);
	}
	
	@Test
	void insertionSortRecursive_UnsortedArray_SortsArray() {	
		Sort.insertionSortRecursive(arr1);
		assertArrayEquals(res1, arr1);
		
		Sort.insertionSortRecursive(arr2);
		assertArrayEquals(res2, arr2);
		
		Sort.insertionSortRecursive(arr3);
		assertArrayEquals(res3, arr3);
		
		Sort.insertionSortRecursive(arr4);
		assertArrayEquals(res4, arr4);
		
		Sort.insertionSortRecursive(arr5);
		assertArrayEquals(res5, arr5);
		
		Sort.insertionSortRecursive(arr6);
		assertArrayEquals(res6, arr6);
		
		Sort.insertionSortRecursive(arr7);
		assertArrayEquals(res7, arr7);
		
		Sort.insertionSortRecursive(arr8);
		assertArrayEquals(res8, arr8);
		
		Sort.insertionSortRecursive(arr9);
		assertArrayEquals(res9, arr9);
		
		Sort.insertionSortRecursive(arr10);
		assertArrayEquals(res10, arr10);
		
		Sort.insertionSortRecursive(arr11);
		assertArrayEquals(new int [] {}, arr11);
		
		Sort.insertionSortRecursive(arr12);
		assertArrayEquals(null, arr12);
	}
	
	@Test
	void countingSort_UnsortedArray_SortsArray() {	
		Sort.countingSort(arr1);
		assertArrayEquals(res1, arr1);
		
		Sort.countingSort(arr2);
		assertArrayEquals(res2, arr2);
		
		Sort.countingSort(arr3);
		assertArrayEquals(res3, arr3);
		
		Sort.countingSort(arr4);
		assertArrayEquals(res4, arr4);
		
		Sort.countingSort(arr5);
		assertArrayEquals(res5, arr5);
		
		Sort.countingSort(arr6);
		assertArrayEquals(res6, arr6);
		
		Sort.countingSort(arr7);
		assertArrayEquals(res7, arr7);
		
		Sort.countingSort(arr8);
		assertArrayEquals(res8, arr8);
		
		Sort.countingSort(arr9);
		assertArrayEquals(res9, arr9);
		
		Sort.countingSort(arr10);
		assertArrayEquals(res10, arr10);
		
		Sort.countingSort(arr11);
		assertArrayEquals(new int [] {}, arr11);
		
		Sort.countingSort(arr12);
		assertArrayEquals(null, arr12);
	}
	
	@Test
	void countingSortRecursive_UnsortedArray_SortsArray() {	
		Sort.countingSortRecursive(arr1);
		assertArrayEquals(res1, arr1);
		
		Sort.countingSortRecursive(arr2);
		assertArrayEquals(res2, arr2);
		
		Sort.countingSortRecursive(arr3);
		assertArrayEquals(res3, arr3);
		
		Sort.countingSortRecursive(arr4);
		assertArrayEquals(res4, arr4);
		
		Sort.countingSortRecursive(arr5);
		assertArrayEquals(res5, arr5);
		
		Sort.countingSortRecursive(arr6);
		assertArrayEquals(res6, arr6);
		
		Sort.countingSortRecursive(arr7);
		assertArrayEquals(res7, arr7);
		
		Sort.countingSortRecursive(arr8);
		assertArrayEquals(res8, arr8);
		
		Sort.countingSortRecursive(arr9);
		assertArrayEquals(res9, arr9);
		
		Sort.countingSortRecursive(arr10);
		assertArrayEquals(res10, arr10);
		
		Sort.countingSortRecursive(arr11);
		assertArrayEquals(new int [] {}, arr11);
		
		Sort.countingSortRecursive(arr12);
		assertArrayEquals(null, arr12);
	}
	
	@Test
	void mergeSort_UnsortedArray_SortsArray() {	
		Sort.mergeSort(arr1);
		assertArrayEquals(res1, arr1);
		
		Sort.mergeSort(arr2);
		assertArrayEquals(res2, arr2);
		
		Sort.mergeSort(arr3);
		assertArrayEquals(res3, arr3);
		
		Sort.mergeSort(arr4);
		assertArrayEquals(res4, arr4);
		
		Sort.mergeSort(arr5);
		assertArrayEquals(res5, arr5);
		
		Sort.mergeSort(arr6);
		assertArrayEquals(res6, arr6);
		
		Sort.mergeSort(arr7);
		assertArrayEquals(res7, arr7);
		
		Sort.mergeSort(arr8);
		assertArrayEquals(res8, arr8);
		
		Sort.mergeSort(arr9);
		assertArrayEquals(res9, arr9);
		
		Sort.mergeSort(arr10);
		assertArrayEquals(res10, arr10);
		
		Sort.mergeSort(arr11);
		assertArrayEquals(new int [] {}, arr11);
		
		Sort.mergeSort(arr12);
		assertArrayEquals(null, arr12);
	}
	
	@Test
	void quickSort_UnsortedArray_SortsArray() {	
		Sort.quickSort(arr1);
		assertArrayEquals(res1, arr1);
		
		Sort.quickSort(arr2);
		assertArrayEquals(res2, arr2);
		
		Sort.quickSort(arr3);
		assertArrayEquals(res3, arr3);
		
		Sort.quickSort(arr4);
		assertArrayEquals(res4, arr4);
		
		Sort.quickSort(arr5);
		assertArrayEquals(res5, arr5);
		
		Sort.quickSort(arr6);
		assertArrayEquals(res6, arr6);
		
		Sort.quickSort(arr7);
		assertArrayEquals(res7, arr7);
		
		Sort.quickSort(arr8);
		assertArrayEquals(res8, arr8);
		
		Sort.quickSort(arr9);
		assertArrayEquals(res9, arr9);
		
		Sort.quickSort(arr10);
		assertArrayEquals(res10, arr10);
		
		Sort.quickSort(arr11);
		assertArrayEquals(new int [] {}, arr11);
		
		Sort.quickSort(arr12);
		assertArrayEquals(null, arr12);
	}
	
	@Test
	void bucketSort_UnsortedArray_SortsArray() {	
		Sort.bucketSort(arr1);
		assertArrayEquals(res1, arr1);
		
		Sort.bucketSort(arr2);
		assertArrayEquals(res2, arr2);
		
		Sort.bucketSort(arr3);
		assertArrayEquals(res3, arr3);
		
		Sort.bucketSort(arr4);
		assertArrayEquals(res4, arr4);
		
		Sort.bucketSort(arr5);
		assertArrayEquals(res5, arr5);
		
		Sort.bucketSort(arr6);
		assertArrayEquals(res6, arr6);
		
		Sort.bucketSort(arr7);
		assertArrayEquals(res7, arr7);
		
		Sort.bucketSort(arr8);
		assertArrayEquals(res8, arr8);
		
		Sort.bucketSort(arr9);
		assertArrayEquals(res9, arr9);
		
		Sort.bucketSort(arr10);
		assertArrayEquals(res10, arr10);
		
		Sort.bucketSort(arr11);
		assertArrayEquals(new int [] {}, arr11);
		
		Sort.bucketSort(arr12);
		assertArrayEquals(null, arr12);
	}
	
	@Test
	void bucketSortRecursive_UnsortedArray_SortsArray() {	
		Sort.bucketSortRecursive(arr1);
		assertArrayEquals(res1, arr1);
		
		Sort.bucketSortRecursive(arr2);
		assertArrayEquals(res2, arr2);
		
		Sort.bucketSortRecursive(arr3);
		assertArrayEquals(res3, arr3);
		
		Sort.bucketSortRecursive(arr4);
		assertArrayEquals(res4, arr4);
		
		Sort.bucketSortRecursive(arr5);
		assertArrayEquals(res5, arr5);
		
		Sort.bucketSortRecursive(arr6);
		assertArrayEquals(res6, arr6);
		
		Sort.bucketSortRecursive(arr7);
		assertArrayEquals(res7, arr7);
		
		Sort.bucketSortRecursive(arr8);
		assertArrayEquals(res8, arr8);
		
		Sort.bucketSortRecursive(arr9);
		assertArrayEquals(res9, arr9);
		
		Sort.bucketSortRecursive(arr10);
		assertArrayEquals(res10, arr10);
		
		Sort.bucketSortRecursive(arr11);
		assertArrayEquals(new int [] {}, arr11);
		
		Sort.bucketSortRecursive(arr12);
		assertArrayEquals(null, arr12);
	}
	
	@Test
	void radixSort_UnsortedArray_SortsArray() {	
		Sort.radixSort(arr1);
		assertArrayEquals(res1, arr1);
		
		Sort.radixSort(arr2);
		assertArrayEquals(res2, arr2);
		
		Sort.radixSort(arr3);
		assertArrayEquals(res3, arr3);
		
		Sort.radixSort(arr4);
		assertArrayEquals(res4, arr4);
		
		Sort.radixSort(arr5);
		assertArrayEquals(res5, arr5);
		
		Sort.radixSort(arr6);
		assertArrayEquals(res6, arr6);
		
		Sort.radixSort(arr7);
		assertArrayEquals(res7, arr7);
		
		Sort.radixSort(arr8);
		assertArrayEquals(res8, arr8);
		
		Sort.radixSort(arr9);
		assertArrayEquals(res9, arr9);
		
		Sort.radixSort(arr10);
		assertArrayEquals(res10, arr10);
		
		Sort.radixSort(arr11);
		assertArrayEquals(new int [] {}, arr11);
		
		Sort.radixSort(arr12);
		assertArrayEquals(null, arr12);
	}
	
	@Test
	void radixSortRecursive_UnsortedArray_SortsArray() {	
		Sort.radixSortRecursive(arr1);
		assertArrayEquals(res1, arr1);
		
		Sort.radixSortRecursive(arr2);
		assertArrayEquals(res2, arr2);
		
		Sort.radixSortRecursive(arr3);
		assertArrayEquals(res3, arr3);
		
		Sort.radixSortRecursive(arr4);
		assertArrayEquals(res4, arr4);
		
		Sort.radixSortRecursive(arr5);
		assertArrayEquals(res5, arr5);
		
		Sort.radixSortRecursive(arr6);
		assertArrayEquals(res6, arr6);
		
		Sort.radixSortRecursive(arr7);
		assertArrayEquals(res7, arr7);
		
		Sort.radixSortRecursive(arr8);
		assertArrayEquals(res8, arr8);
		
		Sort.radixSortRecursive(arr9);
		assertArrayEquals(res9, arr9);
		
		Sort.radixSortRecursive(arr10);
		assertArrayEquals(res10, arr10);
		
		Sort.radixSortRecursive(arr11);
		assertArrayEquals(new int [] {}, arr11);
		
		Sort.radixSortRecursive(arr12);
		assertArrayEquals(null, arr12);
	}
	
	@Test
	void oddEvenSort_UnsortedArray_SortsArray() {	
		Sort.oddEvenSort(arr1);
		assertArrayEquals(res1, arr1);
		
		Sort.oddEvenSort(arr2);
		assertArrayEquals(res2, arr2);
		
		Sort.oddEvenSort(arr3);
		assertArrayEquals(res3, arr3);
		
		Sort.oddEvenSort(arr4);
		assertArrayEquals(res4, arr4);
		
		Sort.oddEvenSort(arr5);
		assertArrayEquals(res5, arr5);
		
		Sort.oddEvenSort(arr6);
		assertArrayEquals(res6, arr6);
		
		Sort.oddEvenSort(arr7);
		assertArrayEquals(res7, arr7);
		
		Sort.oddEvenSort(arr8);
		assertArrayEquals(res8, arr8);
		
		Sort.oddEvenSort(arr9);
		assertArrayEquals(res9, arr9);
		
		Sort.oddEvenSort(arr10);
		assertArrayEquals(res10, arr10);
		
		Sort.oddEvenSort(arr11);
		assertArrayEquals(new int [] {}, arr11);
		
		Sort.oddEvenSort(arr12);
		assertArrayEquals(null, arr12);
	}
	
	@Test
	void oddEvenSortRecursive_UnsortedArray_SortsArray() {	
		Sort.oddEvenSortRecursive(arr1);
		assertArrayEquals(res1, arr1);
		
		Sort.oddEvenSortRecursive(arr2);
		assertArrayEquals(res2, arr2);
		
		Sort.oddEvenSortRecursive(arr3);
		assertArrayEquals(res3, arr3);
		
		Sort.oddEvenSortRecursive(arr4);
		assertArrayEquals(res4, arr4);
		
		Sort.oddEvenSortRecursive(arr5);
		assertArrayEquals(res5, arr5);
		
		Sort.oddEvenSortRecursive(arr6);
		assertArrayEquals(res6, arr6);
		
		Sort.oddEvenSortRecursive(arr7);
		assertArrayEquals(res7, arr7);
		
		Sort.oddEvenSortRecursive(arr8);
		assertArrayEquals(res8, arr8);
		
		Sort.oddEvenSortRecursive(arr9);
		assertArrayEquals(res9, arr9);
		
		Sort.oddEvenSortRecursive(arr10);
		assertArrayEquals(res10, arr10);
		
		Sort.oddEvenSortRecursive(arr11);
		assertArrayEquals(new int [] {}, arr11);
		
		Sort.oddEvenSortRecursive(arr12);
		assertArrayEquals(null, arr12);
	}
	
	@Test
	void cocktailSort_UnsortedArray_SortsArray() {	
		Sort.cocktailSort(arr1);
		assertArrayEquals(res1, arr1);
		
		Sort.cocktailSort(arr2);
		assertArrayEquals(res2, arr2);
		
		Sort.cocktailSort(arr3);
		assertArrayEquals(res3, arr3);
		
		Sort.cocktailSort(arr4);
		assertArrayEquals(res4, arr4);
		
		Sort.cocktailSort(arr5);
		assertArrayEquals(res5, arr5);
		
		Sort.cocktailSort(arr6);
		assertArrayEquals(res6, arr6);
		
		Sort.cocktailSort(arr7);
		assertArrayEquals(res7, arr7);
		
		Sort.cocktailSort(arr8);
		assertArrayEquals(res8, arr8);
		
		Sort.cocktailSort(arr9);
		assertArrayEquals(res9, arr9);
		
		Sort.cocktailSort(arr10);
		assertArrayEquals(res10, arr10);
		
		Sort.cocktailSort(arr11);
		assertArrayEquals(new int [] {}, arr11);
		
		Sort.cocktailSort(arr12);
		assertArrayEquals(null, arr12);
	}
	
	@Test
	void cocktailSortRecursive_UnsortedArray_SortsArray() {	
		Sort.cocktailSortRecursive(arr1);
		assertArrayEquals(res1, arr1);
		
		Sort.cocktailSortRecursive(arr2);
		assertArrayEquals(res2, arr2);
		
		Sort.cocktailSortRecursive(arr3);
		assertArrayEquals(res3, arr3);
		
		Sort.cocktailSortRecursive(arr4);
		assertArrayEquals(res4, arr4);
		
		Sort.cocktailSortRecursive(arr5);
		assertArrayEquals(res5, arr5);
		
		Sort.cocktailSortRecursive(arr6);
		assertArrayEquals(res6, arr6);
		
		Sort.cocktailSortRecursive(arr7);
		assertArrayEquals(res7, arr7);
		
		Sort.cocktailSortRecursive(arr8);
		assertArrayEquals(res8, arr8);
		
		Sort.cocktailSortRecursive(arr9);
		assertArrayEquals(res9, arr9);
		
		Sort.cocktailSortRecursive(arr10);
		assertArrayEquals(res10, arr10);
		
		Sort.cocktailSortRecursive(arr11);
		assertArrayEquals(new int [] {}, arr11);
		
		Sort.cocktailSortRecursive(arr12);
		assertArrayEquals(null, arr12);
	}
	
	@Test
	void testStrandSortIsSorted() {	
		Sort.strandSort(arr1);
		assertArrayEquals(res1, arr1);
		
		Sort.strandSort(arr2);
		assertArrayEquals(res2, arr2);
		
		Sort.strandSort(arr3);
		assertArrayEquals(res3, arr3);
		
		Sort.strandSort(arr4);
		assertArrayEquals(res4, arr4);
		
		Sort.strandSort(arr5);
		assertArrayEquals(res5, arr5);
		
		Sort.strandSort(arr6);
		assertArrayEquals(res6, arr6);
		
		Sort.strandSort(arr7);
		assertArrayEquals(res7, arr7);
		
		Sort.strandSort(arr8);
		assertArrayEquals(res8, arr8);
		
		Sort.strandSort(arr9);
		assertArrayEquals(res9, arr9);
		
		Sort.strandSort(arr10);
		assertArrayEquals(res10, arr10);
		
		Sort.strandSort(arr11);
		assertArrayEquals(new int [] {}, arr11);
		
		Sort.strandSort(arr12);
		assertArrayEquals(null, arr12);
	}
	
	@Test
	void testStrandSortIterativeIsSorted() {	
		Sort.strandSortIterative(arr1);
		assertArrayEquals(res1, arr1);
		
		Sort.strandSortIterative(arr2);
		assertArrayEquals(res2, arr2);
		
		Sort.strandSortIterative(arr3);
		assertArrayEquals(res3, arr3);
		
		Sort.strandSortIterative(arr4);
		assertArrayEquals(res4, arr4);
		
		Sort.strandSortIterative(arr5);
		assertArrayEquals(res5, arr5);
		
		Sort.strandSortIterative(arr6);
		assertArrayEquals(res6, arr6);
		
		Sort.strandSortIterative(arr7);
		assertArrayEquals(res7, arr7);
		
		Sort.strandSortIterative(arr8);
		assertArrayEquals(res8, arr8);
		
		Sort.strandSortIterative(arr9);
		assertArrayEquals(res9, arr9);
		
		Sort.strandSortIterative(arr10);
		assertArrayEquals(res10, arr10);
		
		Sort.strandSortIterative(arr11);
		assertArrayEquals(new int [] {}, arr11);
		
		Sort.strandSortIterative(arr12);
		assertArrayEquals(null, arr12);
	}
	
	@Test
	void pancakeSort_UnsortedArray_SortsArray() {	
		Sort.pancakeSort(arr1);
		assertArrayEquals(res1, arr1);
		
		Sort.pancakeSort(arr2);
		assertArrayEquals(res2, arr2);
		
		Sort.pancakeSort(arr3);
		assertArrayEquals(res3, arr3);
		
		Sort.pancakeSort(arr4);
		assertArrayEquals(res4, arr4);
		
		Sort.pancakeSort(arr5);
		assertArrayEquals(res5, arr5);
		
		Sort.pancakeSort(arr6);
		assertArrayEquals(res6, arr6);
		
		Sort.pancakeSort(arr7);
		assertArrayEquals(res7, arr7);
		
		Sort.pancakeSort(arr8);
		assertArrayEquals(res8, arr8);
		
		Sort.pancakeSort(arr9);
		assertArrayEquals(res9, arr9);
		
		Sort.pancakeSort(arr10);
		assertArrayEquals(res10, arr10);
		
		Sort.pancakeSort(arr11);
		assertArrayEquals(new int [] {}, arr11);
		
		Sort.pancakeSort(arr12);
		assertArrayEquals(null, arr12);
	}
	
	@Test
	void pancakeSortRecursive_UnsortedArray_SortsArray() {	
		Sort.pancakeSortRecursive(arr1);
		assertArrayEquals(res1, arr1);
		
		Sort.pancakeSortRecursive(arr2);
		assertArrayEquals(res2, arr2);
		
		Sort.pancakeSortRecursive(arr3);
		assertArrayEquals(res3, arr3);
		
		Sort.pancakeSortRecursive(arr4);
		assertArrayEquals(res4, arr4);
		
		Sort.pancakeSortRecursive(arr5);
		assertArrayEquals(res5, arr5);
		
		Sort.pancakeSortRecursive(arr6);
		assertArrayEquals(res6, arr6);
		
		Sort.pancakeSortRecursive(arr7);
		assertArrayEquals(res7, arr7);
		
		Sort.pancakeSortRecursive(arr8);
		assertArrayEquals(res8, arr8);
		
		Sort.pancakeSortRecursive(arr9);
		assertArrayEquals(res9, arr9);
		
		Sort.pancakeSortRecursive(arr10);
		assertArrayEquals(res10, arr10);
		
		Sort.pancakeSortRecursive(arr11);
		assertArrayEquals(new int [] {}, arr11);
		
		Sort.pancakeSortRecursive(arr12);
		assertArrayEquals(null, arr12);
	}
	
	@Test
	void bogoSort_UnsortedArray_SortsArray() {	
		Sort.bogoSort(arr1);
		assertArrayEquals(res1, arr1);
		
		Sort.bogoSort(arr2);
		assertArrayEquals(res2, arr2);
		
		Sort.bogoSort(arr3);
		assertArrayEquals(res3, arr3);
		
		Sort.bogoSort(arr4);
		assertArrayEquals(res4, arr4);
		
		Sort.bogoSort(arr5);
		assertArrayEquals(res5, arr5);
		
		Sort.bogoSort(arr6);
		assertArrayEquals(res6, arr6);
		
		Sort.bogoSort(arr7);
		assertArrayEquals(res7, arr7);
		
		Sort.bogoSort(arr8);
		assertArrayEquals(res8, arr8);
		
		Sort.bogoSort(arr9);
		assertArrayEquals(res9, arr9);
		
		Sort.bogoSort(arr10);
		assertArrayEquals(res10, arr10);
		
		Sort.bogoSort(arr11);
		assertArrayEquals(new int [] {}, arr11);
		
		Sort.bogoSort(arr12);
		assertArrayEquals(null, arr12);
	}
	
	@Test
	void bogoSortIterative_UnsortedArray_SortsArray() {	
		Sort.bogoSortIterative(arr1);
		assertArrayEquals(res1, arr1);
		
		Sort.bogoSortIterative(arr2);
		assertArrayEquals(res2, arr2);
		
		Sort.bogoSortIterative(arr3);
		assertArrayEquals(res3, arr3);
		
		Sort.bogoSortIterative(arr4);
		assertArrayEquals(res4, arr4);
		
		Sort.bogoSortIterative(arr5);
		assertArrayEquals(res5, arr5);
		
		Sort.bogoSortIterative(arr6);
		assertArrayEquals(res6, arr6);
		
		Sort.bogoSortIterative(arr7);
		assertArrayEquals(res7, arr7);
		
		Sort.bogoSortIterative(arr8);
		assertArrayEquals(res8, arr8);
		
		Sort.bogoSortIterative(arr9);
		assertArrayEquals(res9, arr9);
		
		Sort.bogoSortIterative(arr10);
		assertArrayEquals(res10, arr10);
		
		Sort.bogoSortIterative(arr11);
		assertArrayEquals(new int [] {}, arr11);
		
		Sort.bogoSortIterative(arr12);
		assertArrayEquals(null, arr12);
	}
	
	@Test
	void gnomeSort_UnsortedArray_SortsArray() {
		Sort.gnomeSort(arr1);
		assertArrayEquals(res1, arr1);
		
		Sort.gnomeSort(arr2);
		assertArrayEquals(res2, arr2);
		
		Sort.gnomeSort(arr3);
		assertArrayEquals(res3, arr3);
		
		Sort.gnomeSort(arr4);
		assertArrayEquals(res4, arr4);
		
		Sort.gnomeSort(arr5);
		assertArrayEquals(res5, arr5);
		
		Sort.gnomeSort(arr6);
		assertArrayEquals(res6, arr6);
		
		Sort.gnomeSort(arr7);
		assertArrayEquals(res7, arr7);
		
		Sort.gnomeSort(arr8);
		assertArrayEquals(res8, arr8);
		
		Sort.gnomeSort(arr9);
		assertArrayEquals(res9, arr9);
		
		Sort.gnomeSort(arr10);
		assertArrayEquals(res10, arr10);
		
		Sort.gnomeSort(arr11);
		assertArrayEquals(new int [] {}, arr11);
		
		Sort.gnomeSort(arr12);
		assertArrayEquals(null, arr12);
	}
	
	@Test
	void gnomeSortRecursive_UnsortedArray_SortsArray() {	
		Sort.gnomeSortRecursive(arr1);
		assertArrayEquals(res1, arr1);
		
		Sort.gnomeSortRecursive(arr2);
		assertArrayEquals(res2, arr2);
		
		Sort.gnomeSortRecursive(arr3);
		assertArrayEquals(res3, arr3);
		
		Sort.gnomeSortRecursive(arr4);
		assertArrayEquals(res4, arr4);
		
		Sort.gnomeSortRecursive(arr5);
		assertArrayEquals(res5, arr5);
		
		Sort.gnomeSortRecursive(arr6);
		assertArrayEquals(res6, arr6);
		
		Sort.gnomeSortRecursive(arr7);
		assertArrayEquals(res7, arr7);
		
		Sort.gnomeSortRecursive(arr8);
		assertArrayEquals(res8, arr8);
		
		Sort.gnomeSortRecursive(arr9);
		assertArrayEquals(res9, arr9);
		
		Sort.gnomeSortRecursive(arr10);
		assertArrayEquals(res10, arr10);
		
		Sort.gnomeSortRecursive(arr11);
		assertArrayEquals(new int [] {}, arr11);
		
		Sort.gnomeSortRecursive(arr12);
		assertArrayEquals(null, arr12);
	}
	
	@Test
	void shellSort_UnsortedArray_SortsArray() {	
		Sort.shellSort(arr1);
		assertArrayEquals(res1, arr1);
		
		Sort.shellSort(arr2);
		assertArrayEquals(res2, arr2);
		
		Sort.shellSort(arr3);
		assertArrayEquals(res3, arr3);
		
		Sort.shellSort(arr4);
		assertArrayEquals(res4, arr4);
		
		Sort.shellSort(arr5);
		assertArrayEquals(res5, arr5);
		
		Sort.shellSort(arr6);
		assertArrayEquals(res6, arr6);
		
		Sort.shellSort(arr7);
		assertArrayEquals(res7, arr7);
		
		Sort.shellSort(arr8);
		assertArrayEquals(res8, arr8);
		
		Sort.shellSort(arr9);
		assertArrayEquals(res9, arr9);
		
		Sort.shellSort(arr10);
		assertArrayEquals(res10, arr10);
		
		Sort.shellSort(arr11);
		assertArrayEquals(new int [] {}, arr11);
		
		Sort.shellSort(arr12);
		assertArrayEquals(null, arr12);
	}
	
	@Test
	void shellSortRecursive_UnsortedArray_SortsArray() {	
		Sort.shellSortRecursive(arr1);
		assertArrayEquals(res1, arr1);
		
		Sort.shellSortRecursive(arr2);
		assertArrayEquals(res2, arr2);
		
		Sort.shellSortRecursive(arr3);
		assertArrayEquals(res3, arr3);
		
		Sort.shellSortRecursive(arr4);
		assertArrayEquals(res4, arr4);
		
		Sort.shellSortRecursive(arr5);
		assertArrayEquals(res5, arr5);
		
		Sort.shellSortRecursive(arr6);
		assertArrayEquals(res6, arr6);
		
		Sort.shellSortRecursive(arr7);
		assertArrayEquals(res7, arr7);
		
		Sort.shellSortRecursive(arr8);
		assertArrayEquals(res8, arr8);
		
		Sort.shellSortRecursive(arr9);
		assertArrayEquals(res9, arr9);
		
		Sort.shellSortRecursive(arr10);
		assertArrayEquals(res10, arr10);
		
		Sort.shellSortRecursive(arr11);
		assertArrayEquals(new int [] {}, arr11);
		
		Sort.shellSortRecursive(arr12);
		assertArrayEquals(null, arr12);
	}
	
	@Test
	void binaryInsertionSort_UnsortedArray_SortsArray() {	
		Sort.binaryInsertionSort(arr1);
		assertArrayEquals(res1, arr1);
		
		Sort.binaryInsertionSort(arr2);
		assertArrayEquals(res2, arr2);
		
		Sort.binaryInsertionSort(arr3);
		assertArrayEquals(res3, arr3);
		
		Sort.binaryInsertionSort(arr4);
		assertArrayEquals(res4, arr4);
		
		Sort.binaryInsertionSort(arr5);
		assertArrayEquals(res5, arr5);
		
		Sort.binaryInsertionSort(arr6);
		assertArrayEquals(res6, arr6);
		
		Sort.binaryInsertionSort(arr7);
		assertArrayEquals(res7, arr7);
		
		Sort.binaryInsertionSort(arr8);
		assertArrayEquals(res8, arr8);
		
		Sort.binaryInsertionSort(arr9);
		assertArrayEquals(res9, arr9);
		
		Sort.binaryInsertionSort(arr10);
		assertArrayEquals(res10, arr10);
		
		Sort.binaryInsertionSort(arr11);
		assertArrayEquals(new int [] {}, arr11);
		
		Sort.binaryInsertionSort(arr12);
		assertArrayEquals(null, arr12);
	}
	
	@Test
	void binaryInsertionSortRecursive_UnsortedArray_SortsArray() {	
		Sort.binaryInsertionSortRecursive(arr1);
		assertArrayEquals(res1, arr1);
		
		Sort.binaryInsertionSortRecursive(arr2);
		assertArrayEquals(res2, arr2);
		
		Sort.binaryInsertionSortRecursive(arr3);
		assertArrayEquals(res3, arr3);
		
		Sort.binaryInsertionSortRecursive(arr4);
		assertArrayEquals(res4, arr4);
		
		Sort.binaryInsertionSortRecursive(arr5);
		assertArrayEquals(res5, arr5);
		
		Sort.binaryInsertionSortRecursive(arr6);
		assertArrayEquals(res6, arr6);
		
		Sort.binaryInsertionSortRecursive(arr7);
		assertArrayEquals(res7, arr7);
		
		Sort.binaryInsertionSortRecursive(arr8);
		assertArrayEquals(res8, arr8);
		
		Sort.binaryInsertionSortRecursive(arr9);
		assertArrayEquals(res9, arr9);
		
		Sort.binaryInsertionSortRecursive(arr10);
		assertArrayEquals(res10, arr10);
		
		Sort.binaryInsertionSortRecursive(arr11);
		assertArrayEquals(new int [] {}, arr11);
		
		Sort.binaryInsertionSortRecursive(arr12);
		assertArrayEquals(null, arr12);
	}
	
	@Test
	void combSort_UnsortedArray_SortsArray() {	
		Sort.combSort(arr1);
		assertArrayEquals(res1, arr1);
		
		Sort.combSort(arr2);
		assertArrayEquals(res2, arr2);
		
		Sort.combSort(arr3);
		assertArrayEquals(res3, arr3);
		
		Sort.combSort(arr4);
		assertArrayEquals(res4, arr4);
		
		Sort.combSort(arr5);
		assertArrayEquals(res5, arr5);
		
		Sort.combSort(arr6);
		assertArrayEquals(res6, arr6);
		
		Sort.combSort(arr7);
		assertArrayEquals(res7, arr7);
		
		Sort.combSort(arr8);
		assertArrayEquals(res8, arr8);
		
		Sort.combSort(arr9);
		assertArrayEquals(res9, arr9);
		
		Sort.combSort(arr10);
		assertArrayEquals(res10, arr10);
		
		Sort.combSort(arr11);
		assertArrayEquals(new int [] {}, arr11);
		
		Sort.combSort(arr12);
		assertArrayEquals(null, arr12);
	}
	
	@Test
	void combSortRecursive_UnsortedArray_SortsArray() {	
		Sort.combSortRecursive(arr1);
		assertArrayEquals(res1, arr1);
		
		Sort.combSortRecursive(arr2);
		assertArrayEquals(res2, arr2);
		
		Sort.combSortRecursive(arr3);
		assertArrayEquals(res3, arr3);
		
		Sort.combSortRecursive(arr4);
		assertArrayEquals(res4, arr4);
		
		Sort.combSortRecursive(arr5);
		assertArrayEquals(res5, arr5);
		
		Sort.combSortRecursive(arr6);
		assertArrayEquals(res6, arr6);
		
		Sort.combSortRecursive(arr7);
		assertArrayEquals(res7, arr7);
		
		Sort.combSortRecursive(arr8);
		assertArrayEquals(res8, arr8);
		
		Sort.combSortRecursive(arr9);
		assertArrayEquals(res9, arr9);
		
		Sort.combSortRecursive(arr10);
		assertArrayEquals(res10, arr10);
		
		Sort.combSortRecursive(arr11);
		assertArrayEquals(new int [] {}, arr11);
		
		Sort.combSortRecursive(arr12);
		assertArrayEquals(null, arr12);
	}
	
	@Test
	void cycleSort_UnsortedArray_SortsArray() {	
		Sort.cycleSort(arr1);
		assertArrayEquals(res1, arr1);
		
		Sort.cycleSort(arr2);
		assertArrayEquals(res2, arr2);
		
		Sort.cycleSort(arr3);
		assertArrayEquals(res3, arr3);
		
		Sort.cycleSort(arr4);
		assertArrayEquals(res4, arr4);
		
		Sort.cycleSort(arr5);
		assertArrayEquals(res5, arr5);
		
		Sort.cycleSort(arr6);
		assertArrayEquals(res6, arr6);
		
		Sort.cycleSort(arr7);
		assertArrayEquals(res7, arr7);
		
		Sort.cycleSort(arr8);
		assertArrayEquals(res8, arr8);
		
		Sort.cycleSort(arr9);
		assertArrayEquals(res9, arr9);
		
		Sort.cycleSort(arr10);
		assertArrayEquals(res10, arr10);
		
		Sort.cycleSort(arr11);
		assertArrayEquals(new int [] {}, arr11);
		
		Sort.cycleSort(arr12);
		assertArrayEquals(null, arr12);
	}
	
	@Test
	void cycleSortRecursive_UnsortedArray_SortsArray() {	
		Sort.cycleSortRecursive(arr1);
		assertArrayEquals(res1, arr1);
		
		Sort.cycleSortRecursive(arr2);
		assertArrayEquals(res2, arr2);
		
		Sort.cycleSortRecursive(arr3);
		assertArrayEquals(res3, arr3);
		
		Sort.cycleSortRecursive(arr4);
		assertArrayEquals(res4, arr4);
		
		Sort.cycleSortRecursive(arr5);
		assertArrayEquals(res5, arr5);
		
		Sort.cycleSortRecursive(arr6);
		assertArrayEquals(res6, arr6);
		
		Sort.cycleSortRecursive(arr7);
		assertArrayEquals(res7, arr7);
		
		Sort.cycleSortRecursive(arr8);
		assertArrayEquals(res8, arr8);
		
		Sort.cycleSortRecursive(arr9);
		assertArrayEquals(res9, arr9);
		
		Sort.cycleSortRecursive(arr10);
		assertArrayEquals(res10, arr10);
		
		Sort.cycleSortRecursive(arr11);
		assertArrayEquals(new int [] {}, arr11);
		
		Sort.cycleSortRecursive(arr12);
		assertArrayEquals(null, arr12);
	}
	
	@Test
	void stalinSort_UnsortedArray_SortsArray() {	
		Sort.stalinSort(arr1);
		assertArrayEquals(res1, arr1);
		
		Sort.stalinSort(arr2);
		assertArrayEquals(res2, arr2);
		
		Sort.stalinSort(arr3);
		assertArrayEquals(res3, arr3);
		
		Sort.stalinSort(arr4);
		assertArrayEquals(res4, arr4);
		
		Sort.stalinSort(arr5);
		assertArrayEquals(res5, arr5);
		
		Sort.stalinSort(arr6);
		assertArrayEquals(res6, arr6);
		
		Sort.stalinSort(arr7);
		assertArrayEquals(res7, arr7);
		
		Sort.stalinSort(arr8);
		assertArrayEquals(res8, arr8);
		
		Sort.stalinSort(arr9);
		assertArrayEquals(res9, arr9);
		
		Sort.stalinSort(arr10);
		assertArrayEquals(res10, arr10);
		
		Sort.stalinSort(arr11);
		assertArrayEquals(new int [] {}, arr11);
		
		Sort.stalinSort(arr12);
		assertArrayEquals(null, arr12);
	}
	
	@Test
	void stalinSortRecursive_UnsortedArray_SortsArray() {	
		Sort.stalinSortRecursive(arr1);
		assertArrayEquals(res1, arr1);
		
		Sort.stalinSortRecursive(arr2);
		assertArrayEquals(res2, arr2);
		
		Sort.stalinSortRecursive(arr3);
		assertArrayEquals(res3, arr3);
		
		Sort.stalinSortRecursive(arr4);
		assertArrayEquals(res4, arr4);
		
		Sort.stalinSortRecursive(arr5);
		assertArrayEquals(res5, arr5);
		
		Sort.stalinSortRecursive(arr6);
		assertArrayEquals(res6, arr6);
		
		Sort.stalinSortRecursive(arr7);
		assertArrayEquals(res7, arr7);
		
		Sort.stalinSortRecursive(arr8);
		assertArrayEquals(res8, arr8);
		
		Sort.stalinSortRecursive(arr9);
		assertArrayEquals(res9, arr9);
		
		Sort.stalinSortRecursive(arr10);
		assertArrayEquals(res10, arr10);
		
		Sort.stalinSortRecursive(arr11);
		assertArrayEquals(new int [] {}, arr11);
		
		Sort.stalinSortRecursive(arr12);
		assertArrayEquals(null, arr12);
	}
	
	@Test
	void stoogeSortRecursive_UnsortedArray_SortsArray() {	
		Sort.stoogeSort(arr1);
		assertArrayEquals(res1, arr1);
		
		Sort.stoogeSort(arr2);
		assertArrayEquals(res2, arr2);
		
		Sort.stoogeSort(arr3);
		assertArrayEquals(res3, arr3);
		
		Sort.stoogeSort(arr4);
		assertArrayEquals(res4, arr4);
		
		Sort.stoogeSort(arr5);
		assertArrayEquals(res5, arr5);
		
		Sort.stoogeSort(arr6);
		assertArrayEquals(res6, arr6);
		
		Sort.stoogeSort(arr7);
		assertArrayEquals(res7, arr7);
		
		Sort.stoogeSort(arr8);
		assertArrayEquals(res8, arr8);
		
		Sort.stoogeSort(arr9);
		assertArrayEquals(res9, arr9);
		
		Sort.stoogeSort(arr10);
		assertArrayEquals(res10, arr10);
		
		Sort.stoogeSort(arr11);
		assertArrayEquals(new int [] {}, arr11);
		
		Sort.stoogeSort(arr12);
		assertArrayEquals(null, arr12);
	}
}