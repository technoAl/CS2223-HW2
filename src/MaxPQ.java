public class MaxPQ<T extends Comparable<T>> {
	private T[] pq; // heap-ordered complete binary tree
	private int n = 0; // in pq[1..N] with pq[0] unused
	public MaxPQ(int maxN) {
		pq = (T[]) new Comparable[maxN+1];
	}

	public boolean isEmpty() {
		return n == 0;
	}

	public int size() {
		return n;
	}

	public void insert(T v) {
		pq[++n] = v;
		swim(n);
	}

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

	private void swim(int k) {
		while(k >= 2 && less(k/2, k)){
			swap(k/2, k);
			k = k/2;
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
}
