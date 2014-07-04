package com.lj.test;

class Value{
	public int i = 15;
}

public class Test {
	public static void main(String[] args) {
		Test t = new Test();
		t.first();
	}
	public void first(){
		int i = 5;
		Value v = new Value();
		v.i = 25;
		sec(v,i);
		System.out.println(v.i);
	}
	public void sec(Value v,int i){
		i = 0;
		v.i = 20;
		Value va = new Value();
		v=va;
		System.out.println(v.i+" "+i);
	}
}