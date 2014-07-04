package com.opensource.concurrent;

import java.util.Map;
import java.util.Random;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.DelayQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

import org.apache.commons.lang.math.RandomUtils;

public class Test {
    public static void main(String[] args) {
         int count = 700;
         CyclicBarrier cyclicBarrier = new CyclicBarrier(count);  
         System.out.println("getParties"+cyclicBarrier.getParties()); 
         ExecutorService executorService = Executors.newFixedThreadPool(30);
         long starttime = System.currentTimeMillis();
         System.out.println("start");
         for (int i = 0; i < count; i++){
         	 System.out.println(i);
        	 executorService.execute(new Test().new Task(cyclicBarrier, new ConcurrentHashMap<String,String>()));
         }
        	 
         executorService.shutdown();
       
         while (!executorService.isTerminated()) {
              try {
                   Thread.sleep(10);
              } catch (InterruptedException e) {
                   e.printStackTrace();
              }
         }
         System.out.println(System.currentTimeMillis() - starttime);
    }

    public class Task implements Runnable {
    	  private Map<String,String> map;
    	  private CyclicBarrier cyclicBarrier;  
    	  
          public Task(CyclicBarrier cyclicBarrier,Map<String,String> map) {  
               this.cyclicBarrier = cyclicBarrier;  
               this.map = map;
          }  
         @Override
         public void run() {
              try {
            	  // 等待所有任务准备就绪 
            	  System.out.println("Waiting nume"+cyclicBarrier.getNumberWaiting()+" "+cyclicBarrier.getParties()); 
            	  
                 cyclicBarrier.await();  
                  if(RandomUtils.nextBoolean()){
                	  if(!map.containsKey("a")){
                		  map.put("a","2");
                	  }
                  }else{
                	  map.put("a","3");
                  }
           //  	  map.put("a","2");
                 
           //       Singleton s = 	  Singleton.GetInstence();
           	 
            	 System.out.println( map.get("a"));
              } catch (Exception e) {
                   e.printStackTrace();
              }
         }
    }
    
    @org.junit.Test
    public void testDelayQueue() throws InterruptedException{
    	TestQueue tq ;
        Random r = new Random();  
    	 DelayQueue<TestQueue> students = new DelayQueue<TestQueue>();  
    	 for(int i=2;i<5;i++){
    		 tq =  new TestQueue(i+System.currentTimeMillis()/1000 );
    		 students.put(tq);
    	 }
    //	 Thread.sleep(10000);
    	 while(true){
    		long time = students.peek().getDelay(TimeUnit.SECONDS);
    		System.out.println(time);
    		if(time <0){
    			break;
    		}
    	 }
    
    	 System.out.println(students.take());
    }
}