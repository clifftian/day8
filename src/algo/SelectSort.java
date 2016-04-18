package algo;

public class SelectSort {

	private long[] a;
	private int nElems;

	public SelectSort(int maxSize) {
		a = new long[maxSize];
		nElems = 0;
	}

	public int size() {
		return nElems;
	}

	public void sort() {

			for (int i = 0; i < nElems; i++) {
				
				int cur=i;
				for (int k=cur+1; k<nElems; k++)
				{
					if (a[k]<a[cur]) 
					cur=k;
				}
					swap(i, cur);
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

		SelectSort oa = new SelectSort(100);
		System.out.println(oa.insert(111));
		System.out.println(oa.insert(99));
		System.out.println(oa.insert(7));
		System.out.println(oa.insert(3));
		oa.display();
		oa.sort();
		oa.display();

	}

}
