package date;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateComparison {
	
	
	public static void main(String[] args) throws InterruptedException {
		
		long startTime = System.currentTimeMillis();
		java.util.Date now = new java.util.Date();
		java.util.Date inputdate;
        String input = "2015-03-003 16:30";
        java.text.SimpleDateFormat inputDf = new java.text.SimpleDateFormat("yyyy-MM-dd HH:mm");

        
		try {
			inputdate = inputDf.parse(input);
			if (now.compareTo(inputdate)>0){
				System.out.println("Cliff: done" );
			}else{
				System.out.println("Cliff: before  " + inputdate + " need run again!");
			}

		} catch (java.text.ParseException e) {
			e.printStackTrace();
		}
		java.lang.Thread.sleep(1000);
		long endTime = System.currentTimeMillis();
		System.out.println(endTime-startTime);
        
	}

}
