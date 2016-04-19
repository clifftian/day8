package generics;

class Automobile {} ;

public class SimpleGenerics<TS> { 
	  private TS a; 
	  public SimpleGenerics(TS a) { this.a = a; } 
	  public void set(TS a) { this.a = a; } 
	  public TS get() { return a; } 
	  public static void main(String[] args) { 
		  SimpleGenerics<Automobile> h3 =     new SimpleGenerics<Automobile>(new Automobile()); 
	    Automobile a = h3.get(); // No cast needed 
	    // h3.set("Not an Automobile"); // Error 
	    // h3.set(1); // Error 
	  } 
	} ///:~