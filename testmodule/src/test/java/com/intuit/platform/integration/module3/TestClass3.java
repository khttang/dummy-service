package com.intuit.platform.integration.module3;

import org.junit.Test;

import com.intuit.platform.integration.module1.Class1;
import com.intuit.platform.integration.module2.Class2;

import junit.framework.Assert;

public class TestClass3 extends Assert {
	private Class3 class3 = new Class3();

	private Class2 class2 = new Class2();
	private Class1 class1 = new Class1();
	
	@Test
	public void testClass3() {
		int ret = class3.combine(50);
		assertEquals("Unexpected value", 50,  ret);
	}
	
	@Test
	public void testClass1Class2() {
		int ret = class2.add10(class1.sub10(100));
		assertEquals("Unexpected value", 100,  ret);
	}
}
