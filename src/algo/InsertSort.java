package algo;

public class InsertSort {
	
	long[] a = {111, 5, 99, 22, 0, 7};
	int nElems = a.length;
	
	public void sort(){
		
		for (int outer=0; outer<nElems; outer ++ ){
			long temp=a[outer];
			int inner=outer;
			while (inner>0 && temp<a[inner-1]){
				a[inner]=a[inner-1];
				inner--;
			}
			a[inner]=temp;
		}
	}
	
	public void display (){
		
		for (long ltemp : a){
			System.out.println(ltemp);
			
		}
	}

	public static void main(String[] args) {
		
		Runtime rt = Runtime.getRuntime();
		System.out.println(rt.maxMemory() + " : " + rt.totalMemory()+ " : " + rt.freeMemory());
		InsertSort insort = new InsertSort();
		insort.sort();
		insort.display();

	}

}
