package algo;

public class HighArrayAPP {
	
	public static void main(String[] args){
	
		int maxSize=100;
		HighArray arr;
		arr = new HighArray(maxSize);
		
		arr.insert(30);
		arr.insert(44455555);
		arr.insert(7777);;
		
		arr.display();
		System.out.println("find 77 " + arr.find(77));
		System.out.println("find 30 " + arr.find(30));
		System.out.println("delete 30 " + arr.delete(30));
		arr.display();
		//System.out.println(System.getProperties());
		
	
	}	

}
