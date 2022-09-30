package org.avs.core.helper;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 
 * @author Avanzino.A
 * @author Avsoft Studio
 * @since 1.0
 */
public final class TimeHelper {
private static Date currentDeviceDate = new Date();
	
	/**
	 * Get the current date and time from the devices used
	 * @return the current date and time into the format YYYY/MM/DD HH:MM:SS
	 * @since 1.0
	 */
	public static String Now() {
		DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
		return dateFormat.format(currentDeviceDate);
	}
	
	public static String Now(String format) {
		DateFormat dateFormat = new SimpleDateFormat(format);
		return dateFormat.format(currentDeviceDate);
	}
	
	public static String Now(DateFormat dateFormat) {
		return dateFormat.format(currentDeviceDate);
	}
}
