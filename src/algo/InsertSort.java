package algo;

import java.util.Arrays;

public class InsertSort {

	private long[] a;
	private Long[] b;
	private int nElems;
	private String str = "AAAABBB";
	Long intt = Long.valueOf(3);

	public InsertSort(int maxSize) {
		a = new long[maxSize];
		nElems = 0;
	}

	public int size() {
		return nElems;
	}

	public void sort() {

		try {
			for (int i = 1; i < nElems; i++) {

				long temp = a[i];
				int in = i;
				while (in > 0 && a[in-1] >= temp) {
					a[in] = a[in - 1];
					in--;
				}
				a[in] = temp;
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
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

		InsertSort oa = new InsertSort(100);
		System.out.println(oa.insert(111));
		System.out.println(oa.insert(99));
		System.out.println(oa.insert(7));
		System.out.println(oa.insert(3));
		oa.display();
		System.out.println("Beginning sort :");
		oa.sort();
		System.out.println("Done sort :");
		oa.display();

	}

}
