package com.intuit.platform.integration.module3;

import org.junit.Test;
import org.junit.experimental.categories.Category;

import com.intuit.platform.integration.testutils.FlakyTest;

public class TestFlakyCategory {
	@Test
	public void test1() {
		System.out.println("test1()");
	}
	
	@Category(FlakyTest.class)
	@Test
	public void test2() {
		System.out.println("Flakytest2()");
	}
	
	@Test
	public void test3() {
		System.out.println("test3()");
	}
}
