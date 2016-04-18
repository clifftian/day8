package algo;

public class OrderArray {

	private long[] a;
	private int nElems;
	
	public OrderArray (int maxSize){
		a = new long[maxSize];
		nElems=0;
	}
	
	public int size(){
		return nElems;
	}

	public int find (long value){
		
		int ai=0;
		int ae=nElems-1;
		int am;
		int result=-1;
		
		while (ai <= ae) {
			am = (ai + ae) / 2;
			if (value==a[am]){
				result=am;
				break;
			}
			else if (value < a[am]){
				ae=am-1;
			}else{
				ai=am+1;
			}
		}
		
		return result;
		
	}
	
	public boolean insert(long value){
		
		int i=0;
		
		for ( i=0; i<nElems; i++){
			if (a[i] > value){
				break;
			}else if(a[i]==value) return false;
		}
		for (int j=nElems; j>i; j--){
			a[j]=a[j-1];
		}
		a[i]=value;
		nElems++;
		return true;
	}
	
	public boolean delete(long value){
		
		int findResult=find(value);
		if (findResult != -1){
			for (int i=findResult; i < nElems; i++){
				a[i]=a[i+1];
			}
			nElems = nElems - 1;
			return true;
		}
		
		return false;
		
	}
	
	public void display(){
		for (int i=0; i<nElems; i++){
			System.out.println(a[i]);
		}
	}
	
	public static void main(String[] args) {
		
		OrderArray oa = new OrderArray(100);
		
		System.out.println(oa.insert(99));
		System.out.println(oa.insert(3));
		System.out.println(oa.insert(7));
		System.out.println(oa.insert(111));
		oa.display();
		System.out.println(oa.find(111));

	}

}
