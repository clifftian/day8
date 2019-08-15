package execcontrol;

public class Switch {

	enum DAYOFWEEK {MON, TUES, WED, THUR, FRI, SAT, SUN};

	public static void main(String[] args) {

	int[] a= {0,1,2,3,4,5,6,7};
	String dayw = "Wrong";
	for (int i : a){
		switch (i) {
		case 1: dayw="Monday"; break;
		case 2: dayw="Tues"; break;
		case 3: dayw="Wed"; break;
		case 4: dayw="Thur"; break;
		case 5: dayw="Fri"; break;
		case 6: dayw="Sat"; break;
		case 0: dayw="Sun"; break;
		}
		//System.out.println(dayw);
	}
	
	System.out.println(DAYOFWEEK.valueOf("MON") );

	}

}
