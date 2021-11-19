// My implementation of HeapSort
public class HeapSort<T extends Comparable<T>>  {

	public HeapSort(){

	}

	public static void sort(Comparable[] arr){ // Sort

		// Heap sort does indexing starting at 1, so copy array into an array w/ size+1 & indexed at 1
		Comparable[] sortingArr  = new Comparable[arr.length+1];
		for(int i = 0; i < arr.length; i++){
			sortingArr[i+1] = arr[i];
		}


		// "Heapify"
		// sink starting at the parents to make the array into a heap
		int n = arr.length;
		for(int k = n/2; k >= 1; k--){
			sink(sortingArr ,k, n);
		}

		// Sort into place
		while(n > 1){
			swap(sortingArr,1, n--); // Swap root node into leaf
			sink(sortingArr, 1, n); // sink the new root into place
		}

		// Copy 1 indexed array into original array that was 0 indexed
		for(int i = 0; i < arr.length; i++){
			arr[i] = sortingArr[i+1];
		}
	}

	private static void sink(Comparable[] arr, int k, int n) {
		// Move Down Tree
		while(2 * k < n+1 ){
			int child = 2 * k; // Pick Smaller child
			if(child + 1 <= n && less(arr, child, child+1)) child++; // If other child smaller, then pick that one
			if(less(arr, k, child)){ // If parent is less than child, swap
				swap(arr, k, child);
			}
//			if (!less(arr, k, child))
//				break;
//			swap(arr, k, child);
			k = child;// Move down tree
		}
	}

	private static boolean less(Comparable[] arr, int i, int j) {
		return arr[i].compareTo(arr[j]) < 0;
	}

	private static void swap(Comparable[] arr, int i, int j){
		Comparable tmp =  arr[i];
		arr[i] = arr[j];
		arr[j] = tmp;
	}
}
