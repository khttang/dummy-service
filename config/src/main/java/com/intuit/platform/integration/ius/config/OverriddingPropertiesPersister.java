/* CONFIDENTIAL -- Copyright 2011 Intuit Inc. This material contains certain   * 
 * trade secrets and confidential and proprietary information of Intuit Inc.   *
 * Use, reproduction, disclosure and distribution by any means are prohibited, *
 * except pursuant to a written license from Intuit Inc. Use of copyright      *
 * notice is precautionary and does not imply publication or disclosure.       */
package com.intuit.platform.integration.ius.config;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import org.apache.commons.lang3.reflect.FieldUtils;
import org.apache.log4j.Logger;
import org.springframework.util.DefaultPropertiesPersister;
import org.springframework.util.StringUtils;

/**
 * This class extends from DefaultPropertiesPersister to override the behavior
 * of loading the properties from resources.
 */
public class OverriddingPropertiesPersister extends DefaultPropertiesPersister {

	private static final Logger sLogger = Logger.getLogger(
			OverriddingPropertiesPersister.class);
	private ApplicationContextProperties applicationContextProperties= null;
	private List<Properties> propertyList = new ArrayList<Properties>();

	@Override
	public void load(Properties props, InputStream is) throws IOException {
		BufferedInputStream tmp = (BufferedInputStream)is;

        //The line below throws IllegalArgumentException - sometimes
        try {
            String fileName = (String) FieldUtils.readField(tmp, "path", true);
            System.out.println(fileName);
            if (fileName.equals("/Users/ktang/Git/ius-service/ius-rest/ius-access-client/target/classes/config.properties")) {
                System.out.println(fileName);
            }
        } catch (Exception e) {

        }



		BufferedReader reader = new BufferedReader(new InputStreamReader(is));
		load(props, reader);
		setContextProperties(props);
	} 

	@Override
	public void load(Properties props, Reader reader)
			throws IOException {
		
		sLogger.debug("OverriddingPropertiesPersister.load()");
		BufferedReader in = new BufferedReader(reader);
		while (true) {
			String line = in.readLine();
			if (line == null) {
				sLogger.debug("End OverriddingPropertiesPersister.load()");
				return;
			}
			line = StringUtils.trimLeadingWhitespace(line);
			if (line.length() > 0) {
				char firstChar = line.charAt(0);
				if (firstChar != '#' && firstChar != '!') {
					while (endsWithContinuationMarker(line)) {
						String nextLine = in.readLine();
						line = line.substring(0, line.length() - 1);
						if (nextLine != null) {
							line += StringUtils
							.trimLeadingWhitespace(nextLine);
						}
					}
					int separatorIndex = line.indexOf("=");
					if (separatorIndex == -1) {
						separatorIndex = line.indexOf(":");
					}
					String key = (separatorIndex != -1 ? line
							.substring(0, separatorIndex) : line);
					String value = (separatorIndex != -1) ? line
							.substring(separatorIndex + 1) : "";
					key = StringUtils.trimTrailingWhitespace(key);
					value = StringUtils.trimLeadingWhitespace(value);		

					// Change the behavior from the DefaultPropertiesPersister here:
					// Only insert new property and do not override the property value
					// of the existing property
					if (!props.containsKey(unescape(key))) {
						props.put(unescape(key), unescape(value));

						sLogger.debug("   New property: "+unescape(key)+"="+unescape(value));

					} else {
						sLogger.debug("   "+unescape(key)+" already exists with value="+ props.getProperty(unescape(key)));
					}
				}
			}
		}
	}
	
	private void setContextProperties(Properties properties) {
		
		sLogger.debug("Setting the property during context intialization");
		applicationContextProperties = new ApplicationContextProperties();
		propertyList.add(properties);
		applicationContextProperties.setContextProperties(propertyList);
	}
	protected boolean endsWithContinuationMarker(String line) {
		boolean evenSlashCount = true;
		int index = line.length() - 1;
		while (index >= 0 && line.charAt(index) == '\\') {
			evenSlashCount = !evenSlashCount;
			index--;
		}
		return !evenSlashCount;
	}	
	protected String unescape(String str) {
		StringBuilder result = new StringBuilder(str.length());
		for (int index = 0; index < str.length();) {
			char c = str.charAt(index++);
			if (c == '\\') {
				c = str.charAt(index++);
				if (c == 't') {
					c = '\t';
				}
				else if (c == 'r') {
					c = '\r';
				}
				else if (c == 'n') {
					c = '\n';
				}
				else if (c == 'f') {
					c = '\f';
				}
			}
			result.append(c);
		}
		return result.toString();
	}	
		
}


