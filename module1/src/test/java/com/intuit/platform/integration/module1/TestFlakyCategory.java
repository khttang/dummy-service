package com.intuit.platform.integration.module1;

import org.junit.Test;
import org.junit.experimental.categories.Category;

import com.intuit.platform.integration.testutils.FlakyTest;

@Category(FlakyTest.class)
public class TestFlakyCategory {
	@Test
	public void test1() {
		System.out.println("Flakytest1()");
	}
	
	@Test
	public void test2() {
		System.out.println("Flakytest2()");
	}
	
	@Test
	public void test3() {
		System.out.println("Flakytest3()");
	}
}
