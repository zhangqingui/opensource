package com.lj.test;

public class Singleton {
	    public static int a;     
	    private  static  Singleton singleton  = new Singleton();
	    public  int b = 0;  
	    private Singleton() {     
	    }     
	    
	    public int getB() {
			return b;
		}

		public void setB(int b) {
			this.b = b;
		}

		public static  Singleton GetInstence() {     
		        return singleton;     
	    }     
	    
	    public static void main(String[] args) {     
	        Singleton mysingleton = Singleton.GetInstence();     
	        System.out.println(mysingleton.a);     
	        System.out.println(mysingleton.b);     
}
}