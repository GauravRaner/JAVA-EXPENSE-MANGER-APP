package Model;

import java.util.Date;
import java.util.Calendar;

public class ServiceClass {
	
	public static String startPoint() {
		Calendar calender=Calendar.getInstance();
		String startPoint="";
		int date=calender.getActualMaximum(Calendar.DATE);
		
		Date d=new Date();
		int month=d.getMonth()+1;
		int year=d.getYear()+1900;
		if(month<10) {
			startPoint=year+"-0"+month+"-0"+date;
		}else {
			startPoint=year+"-"+month+"-0"+date;
		}
		

		
		return startPoint;
	}
	
	
	public static String endPoint() {
		Calendar calender=Calendar.getInstance();
		String endPoint="";
		int date=calender.getActualMaximum(Calendar.DATE);
		
		Date d=new Date();
		int month=d.getMonth()+1;
		int year=d.getYear()+1900;
		
		if(month<10) {
			endPoint=year+"-0"+month+"-0"+date;
		}else {
			endPoint=year+"-"+month+"-0"+date;
		}
		
		return endPoint;
	}

}
