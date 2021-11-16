package utils;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUtils {

	public static String getDate() throws Exception{
		
		//decide the format of date
		DateFormat dateformat = new SimpleDateFormat("yyyyMMddHHmmss");
		
		//Get the current date
		Date date = new Date();
		
		//format the date
		String date1 = dateformat.format(date);
		
		return date1;
	}
	
	public static String getDateInFormat(Date dateProvided, String format) throws Exception{
		
		//decide the format of date
		DateFormat dateformat = new SimpleDateFormat(format);
		
		//format the date
		String dateFormat = dateformat.format(dateProvided);
		
		return dateFormat;
	}
}
