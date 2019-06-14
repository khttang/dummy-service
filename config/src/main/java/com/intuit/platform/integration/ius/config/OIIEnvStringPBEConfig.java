package com.intuit.platform.integration.ius.config;

import org.apache.commons.lang3.StringUtils;
import org.jasypt.encryption.pbe.config.EnvironmentStringPBEConfig;

public class OIIEnvStringPBEConfig extends EnvironmentStringPBEConfig {

	static final String DEFAULT_ALGORITHM = "PBEWithMD5AndDES";
	
	public OIIEnvStringPBEConfig(String algorithm, String passwordEnvName, String password) {
		if(StringUtils.isEmpty(algorithm)) {
			algorithm = DEFAULT_ALGORITHM;
		}
 		super.setAlgorithm(algorithm);
 		
		if(StringUtils.isNotEmpty(System.getenv(passwordEnvName))) {
			super.setPasswordEnvName(passwordEnvName);
		} else {
			super.setPassword(password);
		}

	}
	
}
