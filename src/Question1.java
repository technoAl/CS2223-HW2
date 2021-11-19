import java.util.Random;
import java.util.stream.IntStream;

public class Question1 {
	public static void main(String[] args) {

		// Verification of Functionality

		MinPQ<Integer> minPQ = new MinPQ<>(generate(1000, 1000));
		MaxPQ<Integer> maxPQ = new MaxPQ<>(generate(1000, 1000));
		MyStack<Integer> stack = new MyStack<>(1001);
		while(!minPQ.isEmpty()){
			//System.out.println(minPQ.min());
			stack.push(minPQ.delMin());
		}

		// Use stack to print
		while(stack.size > 0){
			System.out.print(stack.pop() + " ");
		}
		System.out.println();
		while(!maxPQ.isEmpty()){
			//System.out.println(minPQ.min());
			stack.push(maxPQ.delMax());
		}

		while(stack.size > 0){
			System.out.print(stack.pop() + " ");
		}

		System.out.println();


		// Verification for comparable type competitors
		Competitor[] competitors = generateCompetitors(1000, 1000);
		MinPQ<Competitor> minPQcomp = new MinPQ<>(competitors);
		MaxPQ<Competitor> maxPQcomp = new MaxPQ<>(competitors);
		MyStack<Competitor> stackComp = new MyStack<>(1001);
		while(!minPQcomp.isEmpty()){
			//System.out.println(minPQ.min());
			stackComp.push(minPQcomp.delMin());
		}

		while(stackComp.size > 0){
			System.out.print(stackComp.pop()+ " ");
		}
		System.out.println();
		while(!maxPQcomp.isEmpty()){
			//System.out.println(minPQ.min());
			stackComp.push(maxPQcomp.delMax());
		}

		while(stackComp.size > 0){
			System.out.print(stackComp.pop() + " ");
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

	// Generates competitor arrays for testing
	public static Competitor[] generateCompetitors(int n, int maxIntSize){
		Integer[] gen = generate(n, maxIntSize);
		Competitor[] comp = new Competitor[n];
		for(int i = 0; i < n; i++){
			String name = gen[i].toString();
			comp[i] = new Competitor(gen[i], name);
		}
		return comp;
	}

	// My preferred implementation of Stack
	public static class MyStack<T> {
		T[] arr;
		int capacity;
		int size;
		int tailPointer;

		public MyStack(int capacity){
			this.capacity = capacity;
			size = 0;
			tailPointer = 0;
			arr = (T[]) new Object[capacity];
		}

		public boolean push(T e){
			if(size >= capacity){
				return false;
			}

			arr[tailPointer] = e;
			tailPointer++;
			size++;
			return true;
		}

		public T pop(){
			if(size == 0){
				return null;
			}

			T val = arr[tailPointer - 1];
			tailPointer--;
			size--;
			//arr[tailPointer - 1] = null; // might be unnecessary

			return val;
		}

	}
}
