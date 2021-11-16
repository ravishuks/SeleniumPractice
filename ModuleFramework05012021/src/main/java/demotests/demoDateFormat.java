package demotests;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import utils.DateUtils;

public class demoDateFormat {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub

		//decide the format of date
		//DateFormat dateformat = new SimpleDateFormat("yyyyMMddHHmmss");
		DateFormat dateformat = new SimpleDateFormat("MM/dd/yyyy");
				
		//Get the current date
		//Date date = new Date();
				
		//format the date
		String date1 = dateformat.format("20210530");
		
		System.out.println(date1);
		/*
		DateUtils dt;	
		
		dt = new DateUtils();
		
		System.out.println(dt.getDateInFormat(date, "MM/dd/yyyy"));
		*/
 	}

}
