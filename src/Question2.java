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



