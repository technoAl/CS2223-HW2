// Simple Insertion sort implementation
public class InsertionSort<T extends Comparable<T>> {
	public InsertionSort(){

	}
	public static void sort(Comparable[] arr){
		int n = arr.length;
		// loop through entire array
		for (int i = 1; i < n; ++i) {
			Comparable val = arr[i];
			int j = i - 1;

			// Move current element to a spot where it's less than all elements that came before it
			while (j >= 0 && arr[j].compareTo(val) > 0) {
				arr[j + 1] = arr[j];
				j--;
			}
			arr[j + 1] = val;
		}
	}
}
