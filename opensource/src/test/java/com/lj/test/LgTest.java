package com.lj.test;

import java.util.Scanner;

public class LgTest {
	private static final Integer totolnum = 100;
	
	public static void main(String[] args) {
		System.out.println("请输入");
		@SuppressWarnings("resource")
		Scanner sc = new Scanner(System.in);
		if(sc.hasNext()){
			args = sc.next().split(",");
		}
		if(args.length>3||args.length<0){
			System.out.println("Bad Parameter  Example  3,5,9");
			return;
		}
		for(int i=1;i<=totolnum;i++){
			Person p = new Person();
			p.queueUp(i);
			p.listenRule(args,null);
			p.countOff();
		}
	}
}
