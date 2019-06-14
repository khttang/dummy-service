package com.intuit.platform.integration.module1;

import org.junit.Test;
import org.junit.experimental.categories.Category;

import com.intuit.platform.integration.testutils.UnitTests;

@Category(UnitTests.class)
public class TestUnitTestCategory {
	
	@Test
	public void test1() {
		System.out.println("Unittest1()");
	}
	
	@Test
	public void test2() {
		System.out.println("Unittest2()");
	}
	
	@Test
	public void test3() {
		System.out.println("Unittest3()");
	}
}
