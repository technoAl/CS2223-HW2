public class InsertionSort<T extends Comparable<T>> {
	public InsertionSort(){

	}
	public static void sort(Comparable[] arr){
		int n = arr.length;
		for (int i = 1; i < n; ++i) {
			Comparable key = arr[i];
			int j = i - 1;

			while (j >= 0 && arr[j].compareTo(key) > 0) {
				arr[j + 1] = arr[j];
				j = j - 1;
			}
			arr[j + 1] = key;
		}
	}
}
