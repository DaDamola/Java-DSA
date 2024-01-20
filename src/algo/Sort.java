package algo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.IntStream;

// Everything in Java is pass by value 
// A copy of the array reference is passed to the methods referring to the original array 

public class Sort {	
	public static void swap(int [] arr, int i, int j) {
		int temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
	}
	
	public static int getMax(int [] arr) {
		return Arrays.stream(arr).reduce(Integer.MIN_VALUE, (a, v) -> a < v ? v : a);
	}
	
	public static int getMin(int [] arr) {
		return Arrays.stream(arr).reduce((a, v) -> a > v ? v : a).orElse(Integer.MAX_VALUE);
	}
	
	public static int getMaxIndex(int [] arr, int end) {
		int max = Integer.MIN_VALUE, maxIndex = -1;
		
		for (int i = 0; i <= end; i++) {
			if (arr[i] > max) {
				max = arr[i];
				maxIndex = i; 
			}
		}
		
		return maxIndex;
	}
	
	public static void flip(int [] arr, int start, int end) {
		int [] temp = new int[end - start + 1];
		
		for (int i = end; i >= start; i--) {
			temp[end - i] = arr[i];
		}
		
		for (int i = start; i <= end; i++) {
			arr[i] = temp[i];
		}
	}
	
	public static boolean isSorted(int [] arr) {
		for (int i = 0; i < arr.length - 1; i++) {
			if (arr[i] > arr[i + 1]) {
				return false;
			}
		}
		
		return true;
	}
	
	public static int getIndexBinarySearch(int [] arr, int key, int hi) {
		int lo = 0, mid = -1;
		
		while (lo <= hi) {
			mid = lo + (hi - lo) / 2;
			
			if (arr[mid] > key) {
				hi = mid - 1;
			}
			else if (arr[mid] < key) {
				lo = mid + 1;
			}
			else {
				return mid; 
			}
		}
		
		return mid; 
	}
			
	public static int getValuesLessThanCnt(int [] arr, int val) { 
		return (int) Arrays.stream(arr).filter(c -> c < val).count();
	}
	
	public static int getLargestMagnitudeNumDigitCnt(int [] arr) {
		IntStream lenStream = Arrays.stream(arr).map(n -> n < 0 ? String.valueOf(n).length() + 1 : String.valueOf(n).length());
		int [] lengths = lenStream.toArray();
		return String.valueOf(getMax(lengths)).length();
	}
	
	public static boolean hasNegativeNum(int [] arr) {
		return Arrays.stream(arr).anyMatch(n -> n < 0);
	}
	
	public static void printArray(int [] arr) {
		if (arr == null || arr.length == 0) {
			System.out.println(Constants.NULL_KEY);
		}
		else {
			for (int i = 0; i < arr.length; i++) {
				System.out.print(arr[i] + ((i + 1 == arr.length) ? "\n" : " "));
			}
		}
	}
	
	public static void printList(List<Integer> list) {
		if (list == null || list.size() == 0) {
			System.out.println(Constants.NULL_KEY);
		}
		else {
			for (int i = 0; i < list.size(); i++) {
				System.out.print(list.get(i) + ((i + 1 == list.size()) ? "\n" : " "));
			}
		}
	}
	
	// BC: O(n) where we traverse to n in the for loop  
	// AC/WC: O(n^2) where we traverse to n in the for loop about n times in 
	// the while loop 
	// SC: O(1) 
	public static void bubbleSort(int [] arr) {
		if (Utility.isEmptyOrNull(arr)) {
			return;
		}
		
		boolean swapped = true;
		int j = 0;
		
		while (swapped) {
			swapped = false;
			
			// place the largest number in its sorted position 
			for (int i = 0; i < arr.length - 1 - j; i++) {
				if (arr[i] > arr[i + 1]) {
					swap(arr, i, i + 1);
					swapped = true;
				}
			}
			
			j++;
		}
	}
	
	public static void bubbleSortRecursive(int [] arr) {
		if (Utility.isEmptyOrNull(arr)) {
			return;
		}
		
		bubbleSortRecursive(arr, 0, true);
	}
	
	public static void bubbleSortRecursive(int [] arr, int j, boolean swapped) {
		if (!swapped) {
			return; 
		}
		
		swapped = false;
			
		for (int i = 0; i < arr.length - 1 - j; i++) {
			if (arr[i] > arr[i+1]) {
				swap(arr, i, i + 1);
				swapped = true;
			}
		}
		
		bubbleSortRecursive(arr, j + 1, swapped);
	}
	
	// BC/AC/WC: O(n^2) where we traverse to n in the inner loop about n times 
	// in the outer loop 
	// SC: O(1) 
	public static void selectionSort(int [] arr) {
		if (Utility.isEmptyOrNull(arr)) {
			return;
		}
		
		int minIndex, min; 
		
		for (int i = 0; i < arr.length - 1; i++) {
			minIndex = i;
			min = arr[i];
			
			// find the smallest number
			for (int j = minIndex + 1; j < arr.length; j++) {
				if (arr[j] < min) {
					min = arr[j];
					minIndex = j; 
				}
			}
			
			// move it to its sorted position 
			swap(arr, i, minIndex);
		}
	}
	
	public static void selectionSortRecursive(int [] arr) {
		if (Utility.isEmptyOrNull(arr)) {
			return;
		}
		
		selectionSortRecursive(arr, 0);
	}
	
	public static void selectionSortRecursive(int [] arr, int i) {
		if (i >= arr.length - 1) {
			return;
		}
		
		int minIndex = i, min = arr[i]; 
		
		for (int j = minIndex + 1; j < arr.length; j++) {
			if (arr[j] < min) {
				min = arr[j];
				minIndex = j; 
			}
		}
		
		swap(arr, i, minIndex);
		selectionSortRecursive(arr, i + 1);
	}
	
	// BC: O(n) where we traverse to n in the outer loop 
	// AC/WC: O(n^2) where we traverse to n in the inner loop about n times
	// in the outer loop 
	// SC: O(1) 
	public static void insertionSort(int [] arr) {
		if (Utility.isEmptyOrNull(arr)) {
			return;
		}
		
		for (int i = 0; i < arr.length; i++) {
			for (int j = i; j > 0 && arr[j-1] > arr[j] ; j--) {
				swap(arr, j, j - 1);
			}
		}
	}
	
	public static void insertionSortRecursive(int [] arr) {
		if (Utility.isEmptyOrNull(arr)) {
			return;
		}
		
		insertionSortRecursive(arr, 0);
	}
	
	public static void insertionSortRecursive(int [] arr, int i) {
		if (i >= arr.length) {
			return; 
		}
		
		for (int j = i; j > 0 && arr[j-1] > arr[j] ; j--) {
			swap(arr, j, j - 1);
		}
		
		insertionSortRecursive(arr, i + 1);
	}
	
	// BC/AC/WC: O(m + n) where m is the length of the frequency array
	// and n is the length of the original array 
	// where we traverse to n in the for loop and m in the inner while loop 
	// SC: O(m) where m is the length of the frequency array
	public static void countingSort(int [] arr) {
		if (Utility.isEmptyOrNull(arr)) {
			return;
		}
		
		// offset to allow the frequency array to hold negative values 
		int max = getMax(arr), min = getMin(arr), offset = 0;
		
		if (min < 0) {
			offset = -min;
		}
		
		int [] buckets = new int [max + offset + 1];
		
		for (int i = 0; i < arr.length; i++) {
			buckets[arr[i] + offset]++;
		}
		
		int i = 0, j = 0;
		
		while (i < arr.length) {
			while (buckets[j]-- > 0) {
				arr[i++] = j - offset;
			}
			
			j++;
		}
	}
	
	public static void countingSortRecursive(int [] arr) {
		if (Utility.isEmptyOrNull(arr)) {
			return;
		}
		
		int max = getMax(arr), min = getMin(arr), offset = 0;
		
		if (min < 0) {
			offset = -min;
		}
		
		int [] buckets = new int [max + offset + 1];
		
		for (int i = 0; i < arr.length; i++) {
			buckets[arr[i] + offset]++;
		}
		
		countingSortRecursive(arr, buckets, 0, 0, offset);
	}
	
	public static void countingSortRecursive(int [] arr, int [] buckets, int i, int j, int offset) {
		if (i >= arr.length) {
			return; 
		}
		
		while (buckets[j]-- > 0) {
			arr[i++] = j - offset;
		}
		
		countingSortRecursive(arr, buckets, i, j + 1, offset);
	}
	
	// BC/AC/WC: O(n log n) where we traverse to n in the for loop about log n times in 
	// in the recursive calls
	// SC: O(n) where n is the length of the auxiliary array 
	public static void mergeSort(int [] arr) {
		if (Utility.isEmptyOrNull(arr)) {
			return;
		}
		
		mergeSort(arr, 0, arr.length - 1);
	}
	
	public static void mergeSort(int [] arr, int lo, int hi) {
		// base case for one sorted item 
		if (lo >= hi) {
			return;
		}
		
		// calculate the midpoint by adding half of the range to the start
		int mid = lo + (hi - lo) / 2;
		
		// partition the array into two halves until the size of the array becomes one
		mergeSort(arr, lo, mid);
		mergeSort(arr, mid + 1, hi);
		
		int [] aux = new int [hi - lo + 1];	
		int i = lo, j = mid + 1, k = 0;
		
		// sort the lower half and upper half and merge them into the auxiliary array 
		while (i <= mid || j <= hi) {
			if (i > mid) {
				aux[k++] = arr[j++];
			}
			else if (j > hi || arr[i] < arr[j]) {
				aux[k++] = arr[i++];
			}
			else {
				aux[k++] = arr[j++];
			}
		}
		
		// merge back into the original array 
		for (int r = lo; r <= hi; r++) {
			arr[r] = aux[r - lo];
		}
	}
	
	// TODO: review WC runtime
	// BC/AC: O(n log n) where we traverse to n in the loop about log n times
	// in the recursive calls 
	// WC: O(n^2)
	// SC: O(1)
	public static void quickSort(int [] arr) {
		if (Utility.isEmptyOrNull(arr)) {
			return;
		}
		
		quickSort(arr, 0, 1, arr.length - 1);
	}
	
	public static void quickSort(int [] arr, int pivot, int lp, int rp) {
		// base case for when the pointers cross over
		if (lp > rp) {
			return; 
		}
		
		// stop when the pointers cross over
		while (lp <= rp) {
			// swap when the values have been found 
			if (arr[lp] > arr[pivot] && arr[rp] <= arr[pivot]) {
				swap(arr, lp, rp);
			}
			
			// Utility.for a value that is greater than the pivot
			if (arr[lp] <= arr[pivot]) {
				lp++;
			}
			
			// Utility.for a value that is less than or equal to the pivot
			if (arr[rp] > arr[pivot]) {
				rp--;
			}
		}
		
		// always swap the pivot with the right pointer 
		swap(arr, rp, pivot);	
		
		// partition the array with the pivot as the divider
		quickSort(arr, pivot, pivot + 1, rp - 1);
		quickSort(arr, rp + 1, rp + 2, arr.length - 1);
	}
	
	
	// TODO: review WC runtime
	// BC/AC: O(n + m) where n is the length of the array 
	// and m is the length of the buckets
	// where we traverse to n in the second for loop and m in the first for loop 
	// WC: O(n^2)
	// SC: O(m) where m is the length of the buckets
	public static void bucketSort(int [] arr) {
		if (Utility.isEmptyOrNull(arr)) {
			return;
		}
		
		boolean hasNeg = hasNegativeNum(arr);
		List<LinkedList<Integer>> buckets = new LinkedList<>();
		
		// offset to allow the buckets to represent negative digits 
		int bucketSize = hasNeg ? 19 : 10, offset = hasNeg ? 9 : 0;
		
		for (int i = 0; i < bucketSize; i++) {
			buckets.add(new LinkedList<>());
		}
		
		for (int i : arr) {
			String s = String.valueOf(i);
			int j = (i < 0) ? -Integer.valueOf(String.valueOf(s.charAt(1))) : Integer.valueOf(String.valueOf(s.charAt(0)));
			
			buckets.get(j + offset).add(i);
		}
		
		for (LinkedList<Integer> bucket : buckets) {
			Collections.sort(bucket);
		}
		
		for (int i = 0, j = 0; i < buckets.size(); i++) {
			while (!buckets.get(i).isEmpty()) {
				arr[j++] = buckets.get(i).removeFirst();
			}
		}
	}
	
	public static void bucketSortRecursive(int [] arr) {
		if (Utility.isEmptyOrNull(arr)) {
			return;
		}
		
		boolean hasNeg = hasNegativeNum(arr);
		List<LinkedList<Integer>> buckets = new LinkedList<>();
		int bucketSize = hasNeg ? 19 : 10, offset = hasNeg ? 9 : 0;
		
		for (int i = 0; i < bucketSize; i++) {
			buckets.add(new LinkedList<>());
		}
		
		for (int i : arr) {
			String s = String.valueOf(i);
			
			int j = (i < 0) ? -Integer.valueOf(String.valueOf(s.charAt(1))) : Integer.valueOf(String.valueOf(s.charAt(0)));
			
			buckets.get(j + offset).add(i);
		}
		
		for (LinkedList<Integer> bucket : buckets) {
			Collections.sort(bucket);
		}
		
		bucketSortRecursive(buckets, arr, 0, 0);
	}
	
	public static void bucketSortRecursive(List<LinkedList<Integer>> buckets, int [] arr, int i, int j) {
		if (i >= buckets.size()) {
			return; 
		}
		
		while (!buckets.get(i).isEmpty()) {
			arr[j++] = buckets.get(i).removeFirst();
		}
		
		bucketSortRecursive(buckets, arr, i + 1, j);
	}
	
	// TODO: review BC/AC/WC runtime
	// BC/AC/WC: O(n * k) where n is the length of the array and k where is 
	// the number of digits of the number with the greatest magnitude in the array
	// where we traverse to n in the first for loop k times in the outer while loop 
	// SC: O(m) where m is the length of buckets 
	public static void radixSort(int [] arr) {
		if (Utility.isEmptyOrNull(arr)) {
			return;
		}
		
		boolean hasNeg = hasNegativeNum(arr);
		int k = getLargestMagnitudeNumDigitCnt(arr);
		
		// offset to allow the buckets to represent negative digits
		List<LinkedList<Integer>> buckets = new LinkedList<>();
		int bucketSize = hasNeg ? 19 : 10, offset = hasNeg ? 9 : 0, cnt = 0;
		
		for (int i = 0; i < bucketSize; i++) {
			buckets.add(new LinkedList<>());
		}
		
		while (cnt < k) {
			// enqueue the numbers into buckets by their digit, starting from the right
			for (int i : arr) {
				buckets.get((int)(i / Math.pow(10, cnt)) % 10 + offset).add(i);
			}
			
			// dequeue numbers
			for (int i = 0, j = 0; i < buckets.size(); i++) {
				while (!buckets.get(i).isEmpty()) {
					arr[j++] = buckets.get(i).removeFirst();
				}
			}
			
			// repeat until you reach the number of digits of the number with the greatest magnitude 
			cnt++;
		}
	}
	
	public static void radixSortRecursive(int [] arr) {
		if (Utility.isEmptyOrNull(arr)) {
			return;
		}
		
		boolean hasNeg = hasNegativeNum(arr);
		List<LinkedList<Integer>> buckets = new LinkedList<>();
		int bucketSize = hasNeg ? 19 : 10, offset = hasNeg ? 9 : 0;
		
		for (int i = 0; i < bucketSize; i++) {
			buckets.add(new LinkedList<>());
		}
		
		radixSortRecursive(arr, buckets, 0, offset, getLargestMagnitudeNumDigitCnt(arr));
	}
	
	public static void radixSortRecursive(int [] arr, List<LinkedList<Integer>> buckets, int cnt, int offset, int k) {
		if (cnt >= k) {
			return; 
		}
		
		for (int i : arr) {
			buckets.get((int)(i / Math.pow(10, cnt)) % 10 + offset).add(i);
		}
		
		// dequeue numbers
		for (int i = 0, j = 0; i < buckets.size(); i++) {
			while (!buckets.get(i).isEmpty()) {
				arr[j++] = buckets.get(i).removeFirst();
			}
		}
		
		radixSortRecursive(arr, buckets, cnt + 1, offset, k);
	}
	
	// BC: O(n) where we traverse to n in the for loop
	// AC/WC: O(n^2) where traverse to n in the for loop about n times 
	// in the while loop 
	// SC: O(1)
	public static void oddEvenSort(int [] arr) {
		if (Utility.isEmptyOrNull(arr)) {
			return;
		}
		
		boolean swapped = true;
		
		// do bubble sort for even and odd-based pairs 
		while (swapped) {
			swapped = false;
			
			// sort even-based pairs
			for (int i = 0; i < arr.length - 1; i += 2) {
				if (arr[i] > arr[i + 1]) {
					swap(arr, i, i + 1);
					swapped = true;
				}
			}
			
			// sort odd-based pairs 
			for (int i = 1; i < arr.length - 1; i += 2) {
				if (arr[i] > arr[i + 1]) {
					swap(arr, i, i + 1);
					swapped = true;
				}
			}
		}
	}
	
	public static void oddEvenSortRecursive(int [] arr) {
		if (Utility.isEmptyOrNull(arr)) {
			return;
		}
		
		oddEvenSortRecursive(arr, true);		
	}
	
	public static void oddEvenSortRecursive(int [] arr, boolean swapped) {
		if (!swapped) {
			return; 
		}
		
		swapped = false;
		
		for (int i = 0; i < arr.length - 1; i += 2) {
			if (arr[i] > arr[i + 1]) {
				swap(arr, i, i + 1);
				swapped = true;
			}
		}
		
		for (int i = 1; i < arr.length - 1; i += 2) {
			if (arr[i] > arr[i + 1]) {
				swap(arr, i, i + 1);
				swapped = true;
			}
		}
		
		oddEvenSortRecursive(arr, swapped);	
	}
	
	// BC: O(n) where we traverse to n in the for loop 
	// AC/WC: O(n^2) where we traverse to n in the for loop about n times
	// in the while loop 
	// SC: O(1)
	public static void cocktailSort(int [] arr) {
		if (Utility.isEmptyOrNull(arr)) {
			return;
		}
		
		boolean swapped = true;
		int j = 0, k = 0; 
		
		// do bubble sort with forward and backward passes
		while (swapped) {
			swapped = false;
			
			// the forward pass places larger values in their place
			for (int i = 0; i < arr.length - 1 - j; i++) {
				if (arr[i] > arr[i + 1]) {
					swap(arr, i, i + 1);
					swapped = true;
				}
			}
			
			j++;
			
			// the backwards pass places smaller values in their place 
			for (int i = arr.length - 1 - j; i - 1 >= 0 + k; i--) {
				if (arr[i] < arr[i - 1]) {
					swap(arr, i, i - 1);
					swapped = true;
				}
			}
			
			k++;
	
		}
	}
	
	public static void cocktailSortRecursive(int [] arr) {
		if (Utility.isEmptyOrNull(arr)) {
			return;
		}
		
		cocktailSortRecursive(arr, true, 0, 0);
	}
	
	public static void cocktailSortRecursive(int [] arr, boolean swapped, int j, int k) {
		if (!swapped) {
			return; 
		}
		
		swapped = false;
		
		for (int i = 0; i < arr.length - 1 - j; i++) {
			if (arr[i] > arr[i + 1]) {
				swap(arr, i, i + 1);
				swapped = true;
			}
		}
		
		j++;
		
		for (int i = arr.length - 1 - j; i - 1 >= 0 + k; i--) {
			if (arr[i] < arr[i - 1]) {
				swap(arr, i, i - 1);
				swapped = true;
			}
		}
		
		cocktailSortRecursive(arr, swapped, j, k + 1);
	}
	
	// BC: O(n) where we traverse to n in the for loop 
	// AC/WC: O(n^2) where we traverse to n in the for loop about n times
	// in the recursive calls 
	// SC: O(n) where n is the length of the sorted list 
	public static void strandSort(int [] arr) {
		if (Utility.isEmptyOrNull(arr)) {
			return;
		}
		
		Integer [] in = Arrays.stream(arr).boxed().toArray(Integer[]::new);
		List<Integer> sorted = new ArrayList<>();
		strandSort(new ArrayList<>(Arrays.asList(in)), new ArrayList<>(), sorted, new ArrayList<>());
		for (int i = 0; i < sorted.size(); i++) {
			arr[i] = sorted.get(i);
		}
	}

	public static void strandSort(List<Integer> in, List<Integer> temp, List<Integer> sorted, List<Integer> aux) {
		if (in.size() <= 0) {
			return; 
		}
		
		for (int i = 0; i < in.size(); i++) {
			if (i == 0 || in.get(i) > temp.get(temp.size() - 1)) {
				temp.add(in.get(i));
			}
		}
		
		int j = 0, k = 0;
		
		while (j < temp.size() || k < sorted.size()) {
			if (j >= temp.size()) {
				aux.add(sorted.get(k++));
			}
			else if (k >= sorted.size() || temp.get(j) < sorted.get(k)) {
				in.remove(Integer.valueOf(temp.get(j)));
				aux.add(temp.get(j++));
			}
			else {
				aux.add(sorted.get(k++));
			}
		}
		
		sorted.clear();
		
		for (int i : aux) {
			sorted.add(i);
		}
		
		aux.clear();
		temp.clear();
		strandSort(in, temp, sorted, aux);
	}
	
	public static void strandSortIterative(int [] arr) {
		if (Utility.isEmptyOrNull(arr)) {
			return;
		}
		
		Integer [] x = Arrays.stream(arr).boxed().toArray(Integer[]::new);
		List<Integer> in = new ArrayList<>(Arrays.asList(x));
		List<Integer> temp =  new ArrayList<>(), sorted = new ArrayList<>(), aux = new ArrayList<>();
		
		while (in.size() > 0) {
			for (int i = 0; i < in.size(); i++) {
				if (i == 0 || in.get(i) > temp.get(temp.size() - 1)) {
					temp.add(in.get(i));
				}
			}
			
			int j = 0, k = 0;
			
			// sort into the sorted list 
			while (j < temp.size() || k < sorted.size()) {
				if (j >= temp.size()) {
					aux.add(sorted.get(k++));
				}
				else if (k >= sorted.size() || temp.get(j) < sorted.get(k)) {
					// so remove takes away the correct value
					in.remove(Integer.valueOf(temp.get(j)));
					aux.add(temp.get(j++));
				}
				else {
					aux.add(sorted.get(k++));
				}
			}
			
			// clear auxiliary and temporary lists so they can hold new values
			// paste all the current sorted elements to the sorted list 
			sorted = new ArrayList<>(aux);
			aux.clear();
			temp.clear();
		}
		
		// move all the values back to the original array
		for (int i = 0; i < sorted.size(); i++) {
			arr[i] = sorted.get(i);
		}
	}
	
	// BC/AC/WC: O(n^2) where we traverse to n in getMaxIndex() about n times 
	// in the while loop 
	// SC: O(n) where n is length of the temporary array 
	public static void pancakeSort(int [] arr) {
		if (Utility.isEmptyOrNull(arr)) {
			return;
		}
		
		int end = arr.length - 1;
		
		while (end > 0) {
			int maxIndex = getMaxIndex(arr, end);
			
			if (maxIndex != end) {
				// move the max value to the front
				flip(arr, 0, maxIndex);
				// move the max value to its sorted position 
				flip(arr, 0, end);
			}
			
			// repeat for the next largest number
			end--;
		}
	}
	
	public static void pancakeSortRecursive(int [] arr) {
		if (Utility.isEmptyOrNull(arr)) {
			return;
		}
		
		pancakeSortRecursive(arr, arr.length - 1);
	}
	
	public static void pancakeSortRecursive(int [] arr, int end) {
		if (end <= 0) {
			return; 
		}
		
		int maxIndex = getMaxIndex(arr, end);
		
		if (maxIndex != end) {
			flip(arr, 0, maxIndex);
			flip(arr, 0, end);
		}
		
		pancakeSortRecursive(arr, end - 1);
	}
	
	// TODO: review AC/WC runtime
	// BC: O(n) where we traverse to n in isSorted()
	// AC/WC: O((n + 1)!)
	// SC: O(1)
	public static void bogoSort(int [] arr) {
		if (Utility.isEmptyOrNull(arr)) {
			return;
		}

		// do permutation sort
		bogoSortHelper(arr, 0);
	}
	
	public static boolean bogoSortHelper(int [] arr, int start) {
		// base case
		if (isSorted(arr)) {
			return true;
		}
		
		for (int i = start; i < arr.length - 1; i++) {
			for (int j = i + 1; j < arr.length; j++) {
				// make move
				swap(arr, i, j);
				
				// change state and track outcome
				if (bogoSortHelper(arr, i + 1)) {
					return true;
				}
				
				// undo move 
				swap(arr, i, j);
			}
		}
		
		return false;
	}
	
	// BC: O(n)
	// AC/WC: O((n + 1)!)
	// SC: O(1)
	public static void bogoSortIterative(int [] arr) {	
		if (Utility.isEmptyOrNull(arr)) {
			return;
		}
		
		while (!isSorted(arr)) {
			for (int i = 0; i < arr.length; i++) {
				swap(arr, i, (int) (Math.random() * arr.length));
			}
		}
	}
	
	// BC: O(n) where we traverse to n in the for loop
	// AC/WC: O(n^2) where we traverse to n in the for loop about n times
	// when we go backwards 
	// SC: O(1)
	public static void gnomeSort(int [] arr) {
		if (Utility.isEmptyOrNull(arr)) {
			return;
		}
		
		for (int i = 0; i < arr.length; i++) {
			if (i == 0) {
				continue;
			}
			else if (arr[i] < arr[i - 1]) {
				swap(arr, i, i - 1);
				i -= 2;
			}
		}
		
	}
	
	public static void gnomeSortRecursive(int [] arr) {
		if (Utility.isEmptyOrNull(arr)) {
			return;
		}
		
		gnomeSortRecursive(arr, 0);
	}
	
	public static void gnomeSortRecursive(int [] arr, int i) {
		if (i >= arr.length) {
			return; 
		}
		
		if (i == 0) {
			i += 1;
		}
		else if (arr[i] < arr[i - 1]) {
			swap(arr, i, i - 1);
			i -= 2;
		}
		
		gnomeSortRecursive(arr, i + 1);
	}
	
	// BC: O(n log n) where we traverse to n in the outer for loop about log n times in the while loop 
	// AC/WC: O(n log2 n) where we traverse to n in the inner for loop about n log n times
	// in the outer for loop and while loop 
	// SC: O(1) 
	public static void shellSort(int [] arr) {
		if (Utility.isEmptyOrNull(arr)) {
			return;
		}
		
		int gap = arr.length;
		
		// do insertion sort with a reducing gap size
		while (gap > 0) {
			gap /= 2;
			
			for (int i = 0; i < arr.length; i++) {
				for (int j = i; j - gap >= 0 && arr[j - gap] > arr[j]; j -= gap) {
					swap(arr, j, j - gap);
				}
			}
		}
	}
	
	public static void shellSortRecursive(int [] arr) {
		if (Utility.isEmptyOrNull(arr)) {
			return;
		}
		
		shellSortRecursive(arr, arr.length / 2);
	}
	
	public static void shellSortRecursive(int [] arr, int gap) {
		if (gap <= 0) {
			return; 
		}
		
		for (int i = 0; i < arr.length; i++) {
			for (int j = i; j - gap >= 0 && arr[j - gap] > arr[j]; j -= gap) {
				swap(arr, j, j - gap);
			}
		}
		
		shellSortRecursive(arr, gap / 2);
	}
	
	// BC: O(n log n) where we traverse to n in the outer for loop
	// about log n times in getIndexBinaryUtility.)
	// AC/WC: O(n^2) where we traverse to n in the inner for loop n times
	// in the outer for loop 
	// SC: O(1)
	public static void binaryInsertionSort(int [] arr) {
		if (Utility.isEmptyOrNull(arr)) {
			return;
		}
		
		int index; 
		
		for (int i = 1; i < arr.length; i++) {
			// Utility.for the position for the current value in the sorted part of the array 
			index = getIndexBinarySearch(arr, arr[i], i - 1);
			
			// when the current value is larger place it in the position after 
			if (arr[index] <= arr[i]) {
				index = index + 1;
			}
			
			// place the current value in its position 
			swap(arr, index, i);
			
			// shift back the consecutive values that got displaced due to the swap 
			for (int j = index + 1; j < i; j++) {
				swap(arr, j, i);
			}
		}
	}
	
	public static void binaryInsertionSortRecursive(int [] arr) {
		if (Utility.isEmptyOrNull(arr)) {
			return;
		}
		
		binaryInsertionSortRecursive(arr, 1);
	}
	
	public static void binaryInsertionSortRecursive(int [] arr, int i) {
		if (i >= arr.length) {
			return; 
		}

		int index = getIndexBinarySearch(arr, arr[i], i - 1);
		
		if (arr[index] <= arr[i]) {
			swap(arr, index + 1, i);
			
			for (int j = index + 2; j < i; j++) {
				swap(arr, j, i);
			}
		}
		else {
			swap(arr, index, i);
			
			for (int j = index + 1; j < i; j++) {
				swap(arr, j, i);
			}
		}
		
		binaryInsertionSortRecursive(arr, i + 1);
	}
	
	// TODO: review AC/WC runtime
	// BC: O(n log n) where we traverse to n in the for loop about log n times
	// in the while loop 
	// AC/WC: O(n^2)
	// SC: O(1)
	public static void combSort(int [] arr) {
		if (Utility.isEmptyOrNull(arr)) {
			return;
		}
		
		int gap = arr.length;
		boolean swapped = true;
		
		// do bubble sort with a reducing gap size
		while (gap > 1 || swapped) {
			gap /= 1.3;
			
			swapped = false;
			for (int i = 0; i + gap < arr.length; i++) {
				if (arr[i] > arr[i + gap]) {
					swap(arr, i, i + gap);
					swapped = true;
				}
			}
		}
	}
	
	public static void combSortRecursive(int [] arr) {
		if (Utility.isEmptyOrNull(arr)) {
			return;
		}

		combSortRecursive(arr, (int) (arr.length / 1.3), true);
	}
	
	public static void combSortRecursive(int [] arr, int gap, boolean swapped) {
		if (gap <= 0 && !swapped) {
			return;
		}
		
		swapped = false; 
		
		for (int i = 0; i + gap < arr.length; i++) {
			if (arr[i] > arr[i + gap]) {
				swap(arr, i, i + gap);
				swapped = true;
			}
		}
		
		gap /= 1.3;
		
		combSortRecursive(arr, gap, swapped);
	}
	
	// BC/AC/WC: O(n^2) where we traverse to n in getValuesLessThanCnt() about n times in the for loop 
	// SC: O(1)
	public static void cycleSort(int [] arr) {		
		if (Utility.isEmptyOrNull(arr)) {
			return;
		}
		
		for (int i = 0; i < arr.length; i++) {
			// find the number of values smaller than the current value
			int pos = getValuesLessThanCnt(arr, arr[i]);
			
			// this value is a duplicate 
			if (arr[i] == arr[pos]) {
				// find the position for the duplicate value 
				while (arr[i] == arr[pos] && i != pos) {
					pos++;
				}
			}
			
			// move the value to the position  
			swap(arr, i, pos);
			
			if (i == pos) {
				continue;
			}
			// repeat this until the position gets filled
			else {
				i--;
			}
		}
	}
	
	public static void cycleSortRecursive(int [] arr) {
		if (Utility.isEmptyOrNull(arr)) {
			return;
		}

		cycleSortRecursive(arr, 0);
	}
	
	public static void cycleSortRecursive(int [] arr, int i) {
		if (i >= arr.length) {
			return; 
		}
		
		int pos = getValuesLessThanCnt(arr, arr[i]);
		
		if (arr[i] == arr[pos]) {
			while (arr[i] == arr[pos] && i != pos) {
				pos++;
			}
		}
		
		swap(arr, i, pos);
		
		if (i == pos) {
			i += 1;
		}
		
		cycleSortRecursive(arr, i);;
	}
	
	// BC: O(n) AC/WC: O(n^2)
	// SC: O(n)
	public static void stalinSort(int [] arr) { 
		if (Utility.isEmptyOrNull(arr)) {
			return;
		}
		
		Integer [] in = Arrays.stream(arr).boxed().toArray(Integer[]::new);
		List<Integer> ls = new LinkedList<>(Arrays.asList(in));
		
		boolean moved = true;
		int j = 0;
		
		while (moved) {
			moved = false;
			int k = 0;
			
			for (int i = 0; i < ls.size() - 1 - j; i++) {
				if (ls.get(i) > ls.get(i + 1)) {
					ls.add(k, ls.remove(i + 1));
					k++;
					moved = true;
				}
			}
			
			j++;
		}
		
		for (int i = 0; i < ls.size(); i++) {
			arr[i] = ls.get(i);
		}
	}
	
	public static void stalinSortRecursive(int [] arr) { 
		if (Utility.isEmptyOrNull(arr)) {
			return;
		}
		
		Integer [] in = Arrays.stream(arr).boxed().toArray(Integer[]::new);
		List<Integer> ls = new LinkedList<>(Arrays.asList(in));
		
		stalinSortRecursive(ls, true, 0);
		
		for (int i = 0; i < ls.size(); i++) {
			arr[i] = ls.get(i);
		}
	}
	
	public static void stalinSortRecursive(List<Integer> ls, boolean moved, int j) {
		if (!moved) {
			return;
		}
		
		moved = false;
		int k = 0;
			
		for (int i = 0; i < ls.size() - 1 - j; i++) {
			if (ls.get(i) > ls.get(i + 1)) {
				ls.add(k, ls.remove(i + 1));
				k++;
				moved = true;
			}
		}
			
		stalinSortRecursive(ls, moved, j + 1);
	}
	
	// BC/AC/WC: O(n^(log3/log1.5))
	// SC: O(1)
	public static void stoogeSort(int [] arr) { 
		if (Utility.isEmptyOrNull(arr)) {
			return;
		}
		
		stoogeSort(arr, 0, arr.length - 1);
	}
	
	public static void stoogeSort(int [] arr, int lo, int hi) { 
		if (lo >= hi) {
			return;
		}
		
		if (arr[lo] > arr[hi]) {
			swap(arr, lo, hi);
		}
		
		if (hi - lo > 1) {
			int third = (hi - lo + 1) / 3;
			stoogeSort(arr, lo, hi - third);
			stoogeSort(arr, lo + third, hi);
			stoogeSort(arr, lo, hi - third);
		}		
	}
}
