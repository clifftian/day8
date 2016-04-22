package interfaces;

public class LowerCaseProcessor extends Processor {
	
	Object process (Object a){
		return ((String)a).toLowerCase();

	}

}
