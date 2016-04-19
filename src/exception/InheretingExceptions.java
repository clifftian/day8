package exception;

class SimpleException extends Exception {} 

public class InheretingExceptions { 
  public void f()  { 
    System.out.println("Throw SimpleException from f()"); 
    System.out.println(1/0);
    //throw new SimpleException(); 
  } 
  public static void main(String[] args) { 
	  InheretingExceptions sed = new InheretingExceptions(); 
    try { 
      sed.f(); 
    } catch (Exception e){
    	System.out.println("Caught it now!" + e); 
    	e.printStackTrace();
    }
  } 
}

/* Output: 
Throw SimpleException from f() */