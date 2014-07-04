package com.opensource.concurrent;

import java.util.concurrent.Delayed;
import java.util.concurrent.TimeUnit;

public class TestQueue implements  Delayed {
	
	private long  time;

	@Override
	public int compareTo(Delayed o) {
		TestQueue tq = (TestQueue)o;
		if(tq.time>this.time){
			return 1;
		}
		if(tq.time<this.time){
			return -1;
		}
		return 0;
	}
	
	public TestQueue(long time){
		 //都转为转为ns  
        this.time = time;
        System.out.println(time);
	}
	
	@Override
	public long getDelay(TimeUnit unit) {
	    return unit.convert(time-System.currentTimeMillis()/1000, TimeUnit.SECONDS);  
	}

}
