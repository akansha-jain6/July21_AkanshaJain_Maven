package com.akanshaJain.orangeHRM.testScripts;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.testng.annotations.Test;
import com.akanshaJain.orangeHRM.constants.ConstantPath;
import com.akanshaJain.orangeHRM.util.DateOperations;

public class LoggerFile {
	Logger log = Logger.getLogger(LoggerFile.class);
	
	@Test
	public void addLogs() {
		System.setProperty("current.date.time", DateOperations.getTimeStamp());
		PropertyConfigurator.configure(ConstantPath.LOG4J_FILE_PATH);
		log.trace("this is trace");
		log.debug("this is debug");
		log.info("this is info");
		log.warn("this is warn");
		log.error("this is error");
		log.fatal("this is fatal");
	}
}