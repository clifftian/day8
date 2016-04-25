package interfaces;

class Processor { 
	  public String name() { 
	    return getClass().getName(); 
	  } 
	  
	  Object process(Object input) { return input; } 
	  
	} 