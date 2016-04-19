package interfaces;

import java.util.Arrays;

public class SplitterProcessor extends Processor  {
	
	Object process (Object a){
		return Arrays.toString(((String)a).split(" "));
	}


}
