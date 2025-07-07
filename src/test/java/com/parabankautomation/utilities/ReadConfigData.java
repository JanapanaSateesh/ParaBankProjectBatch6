package com.parabankautomation.utilities;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ReadConfigData {

	
    Properties pro;
	
	public ReadConfigData() throws IOException {
		
		File file=new File("./Configuration/config.properties");
		FileInputStream fi=new FileInputStream(file);
		pro=new Properties();
		pro.load(fi);
	}
	
	public String getUrl() {
		String url= pro.getProperty("url");
		return url;
	}
	
	public String getBrowserName() {
		String browser= pro.getProperty("browser");
		return browser;
	}
}
