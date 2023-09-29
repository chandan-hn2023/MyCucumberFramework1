package utils;

import java.util.Date;

public class CommonUtils {

	public static String getEmailWithTimeStamp() {
		
		Date date = new Date();
		String timeStamp = date.toString().replace(" ", "_").replace(":", "_");
		return "chandan" + timeStamp + "@gmail.com";
		
	}
	
//	Date date = new Date();
//	return "chandan"+date.toString().replace(" ", " ").replace(":", "_")+"@gmail.com";
}
