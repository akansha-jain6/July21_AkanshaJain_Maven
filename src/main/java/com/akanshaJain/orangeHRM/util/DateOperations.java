package com.akanshaJain.orangeHRM.util;

import java.text.SimpleDateFormat;
import java.util.Date;
import com.akanshaJain.orangeHRM.constants.ConstantPath;

public class DateOperations {

	public static String getTimeStamp() {
		SimpleDateFormat dateFormat = new SimpleDateFormat(ConstantPath.DATE_FORMAT_TIMESTAMP);
		Date date = new Date();
		String timestamp = dateFormat.format(date);
		return timestamp;
	}
}