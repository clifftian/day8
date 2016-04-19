package arrays;

import java.util.Arrays;

public class ArrayTest {

	static int counter=1000;
	
	public static void main(String[] args) {
		
		System.out.printf("%02X", 11);

		
	    int[][] a = { 
	    	      { 1, 2, 3, }, 
	    	      { 4, 5, 6, }, 
	    	    }; 
	    
	    System.out.println(Arrays.deepToString(a));

		String[] str = {"123", "456", "789"};
		for (String s : str){
			System.out.println(s);
		}
		for (int i=0; i < str.length; i++){
			System.out.println(str[i]);
		}
		
		Object[] obj = new Object[4];
		for (int i=0; i < obj.length; i++){
			obj[i]=counter++;
		}
		for (int i=0; i < obj.length; i++){
			System.out.println(obj[i]);
		}
		

	}

}
