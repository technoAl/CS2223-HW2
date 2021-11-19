
// QuickSort adapted from HW 1 w/ modification to extend comparable & support sort()
public class QuickSort<T extends Comparable<T>> {

	public QuickSort(){ // Constructor

	}

	public static void sort(Comparable[] arr){
		sort(arr, 0, arr.length-1);
	}

	public static void sort(Comparable[] arr, int lo, int hi) { // Partition, then sort 2 halves around partition
		if(lo < hi){
			int partitionPoint = partition(arr, lo, hi);

			sort(arr, lo, partitionPoint-1);
			sort(arr, partitionPoint+1, hi);
		}
	}

	public static int partition(Comparable[] arr, int lo, int hi){ // Implementation uses last element as pivot (approach I was most familiar with)
		Comparable pivot = arr[hi];

		// Loop from lo to hi, and any value < pivot gets swapped to the first half of the array in the next unused spot
		int k = lo; // stores index of next unused spot
		for(int i = lo; i < hi; i++){
			if(arr[i].compareTo(pivot) < 0){
				swap(arr, k, i);
				k++;
			}
		}

		swap(arr, k, hi); // Swap pivot into center
		return k;
	}


	public static void swap(Comparable[] arr, int a, int b){ // Swap
		Comparable tmp = arr[a];
		arr[a] = arr[b];
		arr[b] = tmp;
	}
}