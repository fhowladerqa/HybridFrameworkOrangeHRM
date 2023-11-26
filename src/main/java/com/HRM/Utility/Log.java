package com.HRM.Utility;

import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;

public class Log {
	
	public static void main(String[] args) {
		
		Logger Log = LogManager.getLogger(Log.class);
		Log.info("Log4j Info");
		Log.debug("Log4j Debug message");
		Log.warn("Log4j Warn message");
		Log.error("Log4j Error message");
		Log.fatal("Log4j Fatal message");
		
	}

}
 