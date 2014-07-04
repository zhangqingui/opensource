package com.lj.test;

public class ThreadTest {
	public static void main(String[] args) {
		int i = 0;
		while(true){
			new Thread(new Runnable() {
				@Override
				public void run() {
					try {
						Thread.sleep(500000);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			}).start();
			System.out.println(i++);
		}
	}

}
