package com.intuit.platform.integration.module2;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.intuit.platform.integration.module2.Class2;

import junit.framework.Assert;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {
		"classpath:beans-ius-propertyConfigurer.xml",
		"classpath:beans-module2.xml"
})
public class TestClass2 extends Assert {
	
	@Autowired
	private Class2 myclass;
	
	@Test
	public void testInternalClass2() {
		int ret = myclass.internalMult2(10);
		System.out.println("10*2 = "+ ret);
		assertEquals("Unexpected value", 20,  ret);
		
		assertEquals("Unexpected value", "module2.class1.prop1", myclass.getProp1());
		assertEquals("Unexpected value", "module2.class1.prop1", myclass.getProp2());
	}
}
