package algo;

public class Search {
	public static boolean binarySearch(int [] arr, int lo, int hi, int key) {
		int mid; 
		
		while (lo <= hi) {
			mid = lo + (hi - lo) / 2;
			
			if (arr[mid] < key) {
				lo = mid + 1;
			}
			else if (arr[mid] > key) {
				hi = mid - 1;
			}
			else {
				return true;
			}
		}
		
		return false;
	}
	
	// BC: O(1) AC/WC: O(n) 
	// SC: O(1)
	public static boolean linearSearch(int [] arr, int key) {
		if (Utility.isEmptyOrNull(arr)) {
			return false;
		}
		
		for (int i = 0; i < arr.length; i++) {
			if (arr[i] == key) {
				return true; 
			}
		}
		
		return false; 
	}
	
	public static boolean linearSearchRecursive(int [] arr, int key) {
		if (Utility.isEmptyOrNull(arr)) {
			return false;
		}
		;
		return linearSearchRecursive(arr, 0, key);
	}
	
	public static boolean linearSearchRecursive(int [] arr, int i, int key) {
		if (i >= arr.length) {
			return false;
		}
		
		if (arr[i] == key) {
			return true; 
		}
		
		return linearSearchRecursive(arr, i + 1, key);
	}
	
	// BC: O(1) 
	// AC/WC: O(log n) where we halve the search space repeatedly
	// SC: O(1)
	public static boolean binarySearch(int [] arr, int key) {
		if (Utility.isEmptyOrNull(arr)) {
			return false;
		}
		
		int lo = 0, hi = arr.length - 1;
		
		while (lo <= hi) {
			int mid = lo + (hi - lo) / 2;
			
			if (arr[mid] > key) {
				hi = mid - 1;
			}
			else if (arr[mid] < key) {
				lo = mid + 1;
			}
			else {
				return true;
			}
		}
		
		return false;
	}
	
	public static boolean binarySearchRecursive(int [] arr, int key) {		
		if (Utility.isEmptyOrNull(arr)) {
			return false;
		}
	
		return binarySearchRecursive(arr, 0, arr.length - 1, key);
	}
	
	public static boolean binarySearchRecursive(int [] arr, int lo, int hi, int key) {		
		if (lo > hi) {
			return false; 
		}
		
		int mid = lo + (hi - lo) / 2;
		
		if (arr[mid] > key) {
			hi = mid - 1;
		}
		else if (arr[mid] < key) {
			lo = mid + 1;
		}
		else {
			return true;
		}
		
		return binarySearchRecursive(arr, lo, hi, key);
	}

	// BC: O(1) 
	// AC/WC: O(sqrt(n)) where we traverse to n in the first for loop in sqrt(n) increments 
	// SC: O(1)
	public static boolean jumpSearch(int [] arr, int key) {
		if (Utility.isEmptyOrNull(arr)) {
			return false;
		}
		
		int step = (int) Math.sqrt(arr.length), start = -1;
		
		// find an item larger than the key
		for (int i = 0; i < arr.length; i += step) {
			if (arr[i] > key) {
				start = i;
				break; 
			}
			else if (arr[i] == key) {
				return true;
			}
		}
		
		// go backwards to find the key in that block
		for (int i = start; i >= 0 && i >= start - step; i--) {
			if (arr[i] == key) {
				return true;
			}
		}
		
		return false;
	}
	
	public static boolean jumpSearchRecursive(int [] arr, int key) {
		if (Utility.isEmptyOrNull(arr)) {
			return false;
		}
		
		return jumpSearchRecursive(arr, 0, (int) Math.sqrt(arr.length), -1, key);
	}
	
	public static boolean jumpSearchRecursive(int [] arr, int i, int step, int start, int key) {
		if (i >= arr.length || start == i) {
			for (int j = start; j >= 0 && j >= start - step; j--) {
				if (arr[j] == key) {
					return true;
				}
			}
			
			return false;
		}
		
		if (arr[i] > key) {
			start = i;
		}
		else if (arr[i] == key) {
			return true;
		}
		
		return jumpSearchRecursive(arr, i + step, step, start, key);
	}
	
	// TODO: review runtime AC/WC
	// BC: O(1) 
	// AC/WC: O(log n)
	// SC: O(1)
	public static boolean exponentialSearch(int [] arr, int key) {
		if (Utility.isEmptyOrNull(arr)) {
			return false;
		}
		
		int pow = 0, i = 1;  
		
		// find the range where the item is present 
		while (i < arr.length) {
			if (arr[i] == key) {
				return true;
			}
			//  do a search in that range 
			else if (arr[i] > key) {
				return binarySearch(arr, i / 2, i, key);
			}
			
			pow++;
			i = (int) Math.pow(2, pow);
		}
		
		// search in the last range if the item is not in the other ranges 
		return binarySearch(arr, i / 2, arr.length - 1, key);
	}
	
	
	public static boolean exponentialSearchRecursive(int [] arr, int key) {
		if (Utility.isEmptyOrNull(arr)) {
			return false;
		}
		
		return exponentialSearchRecursive(arr, 1, 0, key);
	}
	
	
	public static boolean exponentialSearchRecursive(int [] arr, int i, int pow, int key) {
		if (i >= arr.length) {
			return binarySearch(arr, i / 2, arr.length - 1, key);
		}
		
		if (arr[i] == key) {
			return true;
		}
		else if (arr[i] > key) {
			return binarySearch(arr, i / 2, i, key);
		}
		
		pow++;
		
		return exponentialSearchRecursive(arr, (int) Math.pow(2, pow), pow, key);
	}
}
