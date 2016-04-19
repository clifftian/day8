package interfaces;

public class UpperCaseProcessor extends Processor {
	
	Object process (Object a){
		
		System.out.println("xxxx");
		return ((String)a).toUpperCase();

	}

}
