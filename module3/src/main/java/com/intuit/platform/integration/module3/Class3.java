package com.intuit.platform.integration.module3;

import com.intuit.platform.integration.module1.Class1;
import com.intuit.platform.integration.module2.Class2;

public class Class3 {

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

	private Class1 class1 = new Class1();
	private Class2 class2 = new Class2();
	
	public int combine(int a) {
		return class2.mult2(class1.div2(a));
	}

}
