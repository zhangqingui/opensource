package com.lj.test;

public class ClassTest implements InterfaceTest{
	
	public String b = "testb";
	public Tests test = new Tests();
	private String a = "test";
	public class ClassS_Pub {    
		    int x;  
	}  
	public String getA() {
		return a;
	}

	public void setA(String a) {
		this.a = a;
	}


	public static void main(String[] args) throws ClassNotFoundException {
		ClassTest.class.getFields();
		ClassTest.class.getDeclaredClasses();
		ClassLoader.getSystemClassLoader().loadClass("com.lj.test.Tests");
		Class.forName("com.lj.test.Tests");
		Class<String> c1 = String.class;
		c1.cast("aa");
		ClassTest.class.getName();
		ClassTest.class.getClassLoader();
	}

}
