package com.day8.string;

public class FormatTest {

	/**
	 * @param args
	 */
	
	public FormatTest(){
		System.out.println("contr");
	}
	
	public static String format(byte[] data) {
		
		StringBuilder result = new StringBuilder();
		int i=0;
		for (byte b : data) {
			
			if (i % 16 == 0){
				result.append(String.format("%05X: ", b));
			result.append(String.format("%02X", b));
			i++;
			if (i%16==0)
				result.append("\n");
			}
		}
		return result.toString();
		
	}
	
	public static void main(String[] args) throws Exception {
		
		System.out.println(format(new String("AAA BBB CCString.formatC DDD").getBytes()));
		System.out.print(FormatTest.class.getClassLoader());

	}

}
