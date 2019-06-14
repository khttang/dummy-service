package com.intuit.platform.integration.ius.config;

import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

public class ApplicationContextProperties {
	
	public static List<Properties> ctx = new ArrayList<Properties>();

	public void setContextProperties(List<Properties> contextProperties) {
		ctx = contextProperties;
	}
	
}
