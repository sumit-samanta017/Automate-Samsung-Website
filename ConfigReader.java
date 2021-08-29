package com.utilities;

import java.util.ResourceBundle;

public class ConfigReader {
	
	private ResourceBundle bundle;
	
	public ResourceBundle initPropFile() {
		
		bundle = ResourceBundle.getBundle("configurations.config");
		
		return bundle;
		
	}

}
