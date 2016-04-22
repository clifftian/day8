package interfaces;

public class ApplyProcessor {

	public static void Handler (Processor a, String s)
	{
		System.out.println(a.name());
		System.out.println(a.process(s));
	}
	
	public static String s = "AAA bbbb CCC ddd";
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Handler (new UpperCaseProcessor(), s);
		Handler (new LowerCaseProcessor(), s);
		Handler (new SplitterProcessor(), s);

	}

}
