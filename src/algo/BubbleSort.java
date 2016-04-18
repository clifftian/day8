package algo;

public class BubbleSort {

	private long[] a;
	private int nElems;

	public BubbleSort(int maxSize) {
		a = new long[maxSize];
		nElems = 0;
	}

	public int size() {
		return nElems;
	}

	public void sort() {

		for (int j = nElems - 1; j > 0; j--) {

			for (int i = 0; i < j; i++) {
				if (a[i] > a[i + 1])
					swap(i, i + 1);
			}
		}

	}

	public void swap(int idx1, int idx2) {
		long temp = a[idx1];
		a[idx1] = a[idx2];
		a[idx2] = temp;
	}

	public boolean insert(long value) {

		a[nElems++] = value;
		return true;
	}

	public void display() {
		for (int i = 0; i < nElems; i++) {
			System.out.println(a[i]);
		}
	}

	public static void main(String[] args) {

		BubbleSort oa = new BubbleSort(100);
		System.out.println(oa.insert(111));
		System.out.println(oa.insert(99));
		System.out.println(oa.insert(7));
		//System.out.println(oa.insert(3));
		oa.display();
		oa.sort();
		oa.display();

	}

}
