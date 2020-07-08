package com.hrms.utils;

public class Constants {
	static String userDir = System.getProperty("user.dir");
	public static final String CHROME_DRIVER_PATH = userDir + "/src/test/resources/drivers/chromedriver";
	public static final String FIREFOX_DRIVER_PATH = userDir + "/src/test/resources/drivers/geckodriver";
	public static final String PROPERTIES_FILE_PATH = userDir + "/src/test/resources/configs/configuration.properties";
	public static final int IMPLICIT_WAIT_TIME = 30;
	public static final int EXPLICIT_WAIT_TIME = 10;
	public static final String TESTDATA_FILEPATH = userDir + "/src/test/resources/testdata/data.xlsx";
	public static final String SCREENSHOT_FILEPATH = userDir + "/screenshots/";
}
