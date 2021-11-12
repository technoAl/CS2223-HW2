public class HeapSort<T extends Comparable<T>>  {
	T[] arr;
	int n = 0;

	public HeapSort(T[] arr){ // Constructor
		this.arr = arr;
	}

	public void sort(){ // Sort
		int n = arr.length;
		for(int k = n/2; k >= 1; k--){ // heapify
			sink(k);
		}
		while(n > 1){ // sort into place
			swap(1, n--);
			sink(n);
		}
	}

	private void sink(int k) {
		while(2 * k < n+1 ){
			int child = 2 * k;
			if(child + 1 <= n && less(child, child+1)) child++;
			if(less(k, child)){
				swap(k, child);
			}
			k = child;
		}
	}

	private boolean less(int i, int j) {
		return arr[i].compareTo(arr[j]) < 0;
	}

	private void swap(int i, int j){
		T tmp = arr[i];
		arr[i] = arr[j];
		arr[j] = tmp;
	}
}
