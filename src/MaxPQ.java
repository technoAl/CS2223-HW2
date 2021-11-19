public class MaxPQ<T extends Comparable<T>> {
	private T[] pq;
	private int n = 0;

	public MaxPQ(){
		pq = (T[]) new Comparable[1000+1]; // default size 1001
	}

	public MaxPQ(int maxN) {
		pq = (T[]) new Comparable[maxN+1];
	}

	// Takes an array an makes it into a Max Heap
	public MaxPQ(T[] a){
		pq =  (T[]) new Comparable[a.length * 2+1];
		for (T t : a) {
			insert(t);
		}
	}

	public boolean isEmpty() {
		return n == 0;
	}

	public int size() {
		return n;
	}

	// Inserts a node then swims it up to it's correct place
	public void insert(T v) {
		pq[++n] = v;
		swim(n);
	}

	// returns root/max node
	public T max(){
		return pq[1];
	}

	// Deletes and returns root/max node
	// Swaps it out of the effective space in the heap, then sinks the new node to the right place
	public T delMax() {
		T max = pq[1];
		swap(1, n--);
		pq[n+1] = null;
		sink(1);
		return max;
	}

	private boolean less(int i, int j) {
		return pq[i].compareTo(pq[j]) < 0;
	}

	private void swap(int i, int j){
		T tmp = pq[i];
		pq[i] = pq[j];
		pq[j] = tmp;
	}

	// Swims a node from a leaf to it's correct place
	private void swim(int k) {
		while(k >= 2 && less(k/2, k)){
			swap(k/2, k);
			k = k/2;
		}
	}

	// Swinks a node in the root position to it's correct place
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
}
