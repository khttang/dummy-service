package com.intuit.platform.integration.module2;

public class Class2 {

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

	public int mult2(int a) {
		return a*2;
	}
	
	public int internalMult2(int a) {
		return a*2;
	}
	
	public int add10(int a) {
		return a + 10;
	}
	
	public int clientAdd10(int b) {
		return b + 10;
	}
}
