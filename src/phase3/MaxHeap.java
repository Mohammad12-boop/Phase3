package phase3;

import java.util.Comparator;

public class MaxHeap<T extends Comparable<T>> implements MaxHeapInterface<T> {

	private T[] arr;
	private int N;

	@SuppressWarnings("unchecked")
	public MaxHeap(int size) {
		arr = (T[]) new Comparable[size + 1];
	}

	public T get(int i) {

		return arr[i];
	}

	@Override
	public void add(T data) {
		arr[++N] = data;
		swim(N);
	}

	@Override
	public T removeMax() {
		T max = arr[1];
		swap(1, N--);
		sink(1);
		arr[N+1] = null; // prevent loitering ??
		return max;
	}

	@Override
	public T getMax() {
		return arr[1];
	}

	@Override
	public boolean isEmpty() {
		return N == 0;
	}

	@Override
	public int getSize() {
		return N;
	}

	@Override
	public void clear() {
		N = 0;
	}

	private void swim(int k) {
		while (k > 1 && less(k/2, k)) {
			swap(k/2, k);
			k /= 2;
		}
	}

	private boolean less(int p, int c) {
		return arr[p].compareTo(arr[c]) < 0;
	}

	private void swap(int p, int c) {
		T temp = arr[p];
		arr[p] = arr[c];
		arr[c] = temp;
	}

	private void sink(int k) {
		while (2*k <= N) {
			int j = 2*k;
			if (j < N && less(j, j+1)) j++;
			if (!less(k, j)) break;
			swap(k, j);
			k = j;
		}
	}

	public boolean isMaxHeap() {
		int N = this.arr.length;
		for (int i = 1; i <= N/2; i++) {
			int lc = i*2, rc = lc + 1;
			if (lc < N && this.arr[i].compareTo(this.arr[lc]) < 0) return false;
			if (rc < N && this.arr[i].compareTo(this.arr[rc]) < 0) return false;
		}
		return true;
	}

	Comparator <? super T> ageC=(Comparator<? super T>) new AgeComparator();

	public void heapSortAsc() {

		int N = this.arr.length - 1;
		T temp;

		maxHeapify();  // to a max-heap

		while (N > 1) {
			// 1. Swap the first element with the last element
			temp = this.arr[1];
			this.arr[1] = this.arr[N];
			this.arr[N] = temp;

			// 2. decrement N
			N--;

			// 3. sink[1]
			int k = 1;
			while (2*k <= N) {
				int j = 2*k;
				if (j < N && ageC.compare(this.arr[j], this.arr[j+1]) < 0) j++;
				if (ageC.compare(this.arr[k], this.arr[j]) >= 0) break;

				temp = this.arr[k];
				this.arr[k] = this.arr[j];
				this.arr[j] = temp;
				k = j;
			}
		}
	}

	public void maxHeapify() {

		int N = this.arr.length - 1, i = N / 2;
		T temp;

		while (i-- > 0) {

			int k = i+1;
			while (2*k <= N) {

				int j = 2*k;
				if (j < N && ageC.compare(this.arr[j], this.arr[j+1]) < 0) j++;
				if (ageC.compare(this.arr[k], this.arr[j]) >= 0) break;
				temp = this.arr[k];
				this.arr[k] = this.arr[j];
				this.arr[j] = temp;
				k = j;
			}
		}
	}


}
