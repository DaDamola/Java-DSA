package algo;

import java.util.ArrayList;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Stack;
import java.awt.Point;



public class DemoSort {	
//	
//	// BC/AC/WC: O(n ^ (log 3 / log 1.5))
//	// SC: O(1)
//	public static void stoogeSort(int [] nums)
//	{	
//		stoogeSortHelper(nums, 0, nums.length - 1);	
//	}
//	
//	public static void stoogeSortHelper(int [] nums, int lo, int hi)
//	{	
//		if (lo >= hi)
//			return; 
//		
//		// check when the first number is larger than the last number 
//		if (nums[lo] > nums[hi])
//		{
//			swap(nums, lo, hi);
//		}
//		
//		if (hi - lo + 1 > 2)
//		{
//			int third = (hi - lo + 1) / 3;
//			
//			// sort the first two-thirds of the array
//			stoogeSortHelper(nums, lo, hi - third);
//			
//			// sort the last two-thirds of the array
//			stoogeSortHelper(nums, lo + third, hi);
//			
//			// sort the first two-thirds of the array again 
//			stoogeSortHelper(nums, lo, hi - third);
//		}
//	}
//	
	
//	
//	public static void bitonicSort(int [] nums)
//	{		
//		if (isPowerOf2(nums.length))
//		{
//			int lo = 0, hi = nums.length - 1;
//			bitonicSortHelper(nums, lo, hi);
//		}
//		else
//		{
//			System.out.println("The length of the array must be a power of two.");
//		}	
//	}
//			
//	public static void bitonicSortHelper(int [] nums, int lo, int hi)
//	{
//		
//	}

//	
//	// BC: O(n) AC/WC: O(n log n)
//	// SC: O(n) where n is the length of the auxiliary array
//	public static void timSort(int [] nums)
//	{		
//		final int RUN_SIZE = 3;
//		Stack<Point> s = new Stack<>();
//		ArrayList<Integer> indices = new ArrayList<>();
//		int cnt = 1, prevCnt = -1; 
//			
//		for (int i = 1; i < nums.length; i++)
//		{	
//			// finish this run since the next item does not follow the sorted pattern 
//			if (cnt >= RUN_SIZE && nums[i] < nums[i-1]) 
//			{
//				indices.add(i-1);
//				prevCnt = cnt; 
//				cnt = 1;
//			}
//			else if (nums[i] < nums[i-1]) // add this item to the run and place it in its sorted 
//										  // position
//			{	
//				binaryInsertionSort(nums, i - cnt, i);
//				cnt++;
//			}  
//			else // add this item to the run 
//			{
//				cnt++;
//			}
//			
//			// store the ending index of this run  
//			if (cnt >= RUN_SIZE && i + 1 == nums.length)
//			{
//				indices.add(i);
//			}
//			else if (cnt < RUN_SIZE && i + 1 == nums.length) 
//			{
//				// add the last items of this current run to the previous run since it
//				// has not reached the minimum run size
//				for (int j = i - cnt; j <= i; j++)
//				{
//					binaryInsertionSort(nums, j - prevCnt, j);
//				}
//				
//				indices.set(indices.size()-1, nums.length - 1);
//			}
//		}
//		
//		// check when there is only one run, then the array is already sorted 
//		if (indices.size() == 1)
//		{
//			return; 
//		}
//		
//		// insert the start and end indices of each run into a stack 
//		for (int i = 0; i < indices.size(); i++)
//		{
//			int val = indices.get(i);
//			
//			if (i == 0)
//			{
//				s.push(new Point(0, val));		
//			}
//			else
//			{
//				s.push(new Point(s.peek().y + 1, val));
//			}
//		}
//		
//		
//		while (!s.isEmpty())
//		{
//			int start = s.peek().x, stop = s.peek().y, k = 0; 
//			int [] aux = new int[stop - start + 1];
//			
//			// store the topmost run in an auxiliary array 
//			for (int i = start; i <= stop; i++)
//			{
//				aux[k++] = nums[i];	
//			}
//				
//			s.pop();
//			
//			int nxtStart = s.peek().x, nxtStop = s.peek().y, r = stop; 
//			
//			// move the next run to the back of the original array 
//			for (int i = nxtStop; i >= nxtStart; i--)
//			{
//				nums[r--] = nums[i];
//				
//			}	
//
//			s.pop();
//			
//			// insert a merged run of the previous two runs
//			if (!s.isEmpty())
//				s.push(new Point(nxtStart, stop));
//			
//			int i = r + 1, j = 0;
//			k = nxtStart;
//			
//			// sort and merge the runs into the original array 
//			while (i <= stop  || j < aux.length)
//			{
//				if (i > stop)
//				{
//					nums[k++] = aux[j++];
//				}
//				else if (j >= aux.length)
//				{
//					nums[k++] = nums[i++];
//				}
//				else if (nums[i] < aux[j])
//				{
//					nums[k++] = nums[i++];
//				}
//				else
//				{
//					nums[k++] = aux[j++];
//				}
//			}
//		}
//	}
	
	public static void librarySort(int [] nums)
	{		
		// create an aux array
		// use binary search to find the position for the current item 
		// insert it 
		
		// move back everything behind it until you hit an empty space
		// rebalance it by creating an array with spaces after each item 
		// repeat until all the items are inserted
		
		
		
		int [] aux = new int[1], copy;
		
//		for (int i = 0; i < nums.length; i++)
//		{
//			int pos = binarySearch(nums[i], nums, 0, aux.length - 1);
//			int pos = binarySearch(nums[i], nums, 0, aux.length - 1);
//			System.out.println(pos);
//			
//			if (i == 0)
//				aux[pos] = nums[i];
//			
//			copy = new int[(i + 1) * 2];
//			
//			int k = 0;
//			
//			for (int j = 0; j + 1 < copy.length; j += 2)
//			{
//				copy[j] = aux[k];
//				copy[j+1] = aux[j+1];
//			}
//			
//			if (i == 1)
//				break;
//			
//			
//		}
	}
	
	
	public static void main(String [] args)
	{		
		int [] arr1 = new int [] {10, 2, 14, 3, 12, 1, 9, 1}; // 1, 1, 2, 3, 9, 10, 12, 14
		int [] arr2 = new int [] {9, -3, 7, -2, 2, -15, -7}; // -15, -7, -3, -2, 2, 7, 9
		int [] arr3 = new int [] {-11, -7, -3, 2, 5, 8, 11};
		
		librarySort(arr1);
//		librarySort(arr2);
//		librarySort(arr3);
	
	
		for (int i = 0; i < arr1.length; i++)
		{
//			System.out.print(arr1[i] + ((i + 1 == arr1.length) ? "\n" : " "));
		}
		
		for (int i = 0; i < arr2.length; i++)
		{
//			System.out.print(arr2[i] + ((i + 1 == arr2.length) ? "\n" : " "));
		}
		
		for (int i = 0; i < arr3.length; i++)
		{
//			System.out.print(arr3[i] + ((i + 1 == arr3.length) ? "\n" : " "));
		}
		
	}

}
