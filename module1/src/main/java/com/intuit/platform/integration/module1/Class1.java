package com.intuit.platform.integration.module1;

public class Class1 {

	private String prop1;
	private String prop2;

	public String getProp1() {
		return prop1;
	}

	public void setProp1(String prop1) {
		this.prop1 = prop1;
	}

	public String getProp2() {
		return prop2;
	}

	public void setProp2(String prop2) {
		this.prop2 = prop2;
	}

	public int div2(int a) {
		return a/2;
	}
	public int internalDiv2(int a) {
		return a/2;
	}
	
	public int sub10(int a) {
		return a - 10;
	}
	
	public int clientSub10(int b) {
		return b - 10;
	}
}
