package com.intuit.platform.integration.module1;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import junit.framework.Assert;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {
		"classpath:beans-ius-propertyConfigurer.xml",
		"classpath:beans-module1.xml"
})
public class TestClass1 extends Assert {

	@Autowired
	private Class1 myclass;
	
	@Test
	public void testInternal() {
		int ret = myclass.internalDiv2(10);
		System.out.println("10/2 = "+ ret);
		assertEquals("Unexpected value", 5,  ret);
	}
	
}
