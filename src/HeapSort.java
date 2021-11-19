public class HeapSort<T extends Comparable<T>>  {

	public HeapSort(){

	}

	public static void sort(Comparable[] arr){ // Sort
		Comparable[] sortingArr  = new Comparable[arr.length+1];
		for(int i = 0; i < arr.length; i++){
			sortingArr[i+1] = arr[i];
		}


		int n = arr.length;
		for(int k = n/2; k >= 1; k--){ // heapify
			sink(sortingArr ,k, n);
		}

		while(n > 1){ // sort into place
			swap(sortingArr,1, n--);
			sink(sortingArr, 1, n);
		}

		for(int i = 0; i < arr.length; i++){
			arr[i] = sortingArr[i+1];
		}
	}

	private static void sink(Comparable[] arr, int k, int n) {
		while(2 * k < n+1 ){
			int child = 2 * k;
			if(child + 1 <= n && less(arr, child, child+1)) child++;
//			if(less(arr, k, child)){
//				swap(arr, k, child);
//			}
			if (!less(arr, k, child))
				break;
			swap(arr, k, child);
			k = child;
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
