package com.beitech.order.utils;

import java.text.SimpleDateFormat;
import java.util.Date;

import com.beitech.order.utils.exception.BadRequest;

public class Utility {
	private static SimpleDateFormat DATE_FORMAT = new SimpleDateFormat("YYYYMMDD");
	
	public Date convertStringToDate(String stringDate) {
		Date objectDate=null;		
		try {
			objectDate = DATE_FORMAT.parse(stringDate);
		} catch (Exception e) {
			throw new BadRequest(e.getMessage());
		}
		return objectDate;
	}
}
