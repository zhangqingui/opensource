package com.opensource.concurrent;

import java.util.concurrent.Callable;
import java.util.concurrent.CompletionService;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorCompletionService;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

import org.junit.Test;

public class ThreadPoolTest {
	public static void main(String[] args) {
		ScheduledExecutorService ses = Executors.newScheduledThreadPool(2);
		ses.scheduleWithFixedDelay(new Task(), 5, 2, TimeUnit.SECONDS);
		for(int i=1;i<15;i++){
			try {
				Thread.sleep(1000);
				System.out.println("过了"+i+"秒");
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
	static class Task implements Runnable{

		@Override
		public void run() {
			try {
				Thread.sleep(2001);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println("Thead-name"+Thread.currentThread().getName()+"come!");
		}
		
	}
	static class TaskCall implements Callable<String>{
		private String type;
		public TaskCall(String type) {
			this.type = type;
		}
		
		@Override
		public String  call() throws Exception {
			// 睡眠3秒，代表执行某段复杂业务逻辑  
			if(type.equals("hard")){
			    Thread.sleep(5000);  
			}
			if(type.equals("easy")){
			    Thread.sleep(3000);  
			}
            String result = "下订单成功！";  
            return type+ result;  
		}
	}
	@Test
	public void testExecutorCompletionService() throws InterruptedException, ExecutionException{
        ExecutorService threadPool = Executors.newFixedThreadPool(2);  
		CompletionService<String> cs = new ExecutorCompletionService<String>(threadPool);
		cs.submit(new TaskCall("hard"));
		cs.submit(new TaskCall("easy"));
    	Future<String> c = null;
		while(( c = cs.take()) != null){
			   System.out.println(c.get());  
		}
	//	threadPool.shutdown();
		   System.out.println("over");  
	}
}
