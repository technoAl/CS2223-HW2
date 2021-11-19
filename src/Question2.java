import java.util.Random;
import java.util.stream.IntStream;

public class Question2 {

	public static void main(String[] args) {
		// Verify functionality

		// Heap Sort
		Integer[] test = generate(1000, 1000);
		for(int i: test){
			System.out.print(test[i] + " ");
		}
		System.out.println();
		HeapSort.sort(test);
		for(int i = 0; i < test.length; i++){
			System.out.print(test[i] + " ");
		}

		// Quick Sort
		System.out.println();
		test = generate(1000, 1000);
		for(int i: test){
			System.out.print(test[i] + " ");
		}
		System.out.println();
		QuickSort.sort(test);
		for(int i = 0; i < test.length; i++){
			System.out.print(test[i] + " ");
		}

		// Insertion Sort
		System.out.println();
		test = generate(1000, 1000);
		for(int i: test){
			System.out.print(test[i] + " ");
		}
		System.out.println();
		InsertionSort.sort(test);
		for(int i = 0; i < test.length; i++){
			System.out.print(test[i] + " ");
		}


		System.out.println();
		// Timing Code

		//Heap Sort times
		System.out.println(timedSort(0, generate(1000, 1000)));
		System.out.println(timedSort(0, generate(10000, 10000)));
		System.out.println(timedSort(0, generate(100000, 100000)));
		System.out.println(timedSort(0, generate(1000000, 1000000)));
		System.out.println(timedSort(0, generate(10000000, 10000000)));

		//Quick Sort times
		System.out.println(timedSort(1, generate(1000, 1000)));
		System.out.println(timedSort(1, generate(10000, 10000)));
		System.out.println(timedSort(1, generate(100000, 100000)));
		System.out.println(timedSort(1, generate(1000000, 1000000)));
		System.out.println(timedSort(1, generate(10000000, 10000000)));

		//Insertion Sort times
		System.out.println(timedSort(2, generate(1000, 1000)));
		System.out.println(timedSort(2, generate(10000, 10000)));
		//System.out.println(timedSort(2, generate(100000, 100000)));
		//System.out.println(timedSort(2, generate(1000000, 1000000)));

		/*
		Observations
		Insertion sort is by far the slowest (not suprising) O(n^2) algorithm
		At around n = 100,000, Heap sort and Quick sort are very close
		At around n = 1,000,000 and n = 10,000,000 Quick sort blows it out of the water in terms of speed
		Both algorithms are O(n log n) time complexity average, so why does Quick sort consistently beat heap sort
		From my viewing, it has to do with the swaps.
		Quicksort doesn't do nearly as many swaps as Heap sort
		Heap sort has to swap to get things to into heap form, then swap more to get the ordering
		Quick sort is more than 2 times faster  on the n = 10,000,000 test case

		 */
	}


	// Runs the sort while timing them
	public static long timedSort(int sort, Integer[] arr){
		long startTime = System.currentTimeMillis();
		if(sort == 0){
			HeapSort.sort(arr);
		} else if(sort == 1){
			QuickSort.sort(arr);
		} else {
			InsertionSort.sort(arr);
		}
		long endTime = System.currentTimeMillis();
		return endTime - startTime;
	}


	// Generates an array of specified size
	public static Integer[] generate(int n, int maxIntSize) {
		int[] gen = IntStream.generate(() -> new Random().nextInt(maxIntSize)).limit(n).toArray();
		Integer[] integers = new Integer[n];
		for(int i = 0; i < gen.length; i++){
			integers[i] = gen[i];
		}
		return integers;
	}
}



