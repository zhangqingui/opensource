package com.lj.test;

public class Person {
   private Brain brain = Brain.InitBrain();
   private Integer position;
   
   
   public void queueUp(Integer position){
	   this.position = position;
   }
   
   public void listenRule(String[] num,String[] st ){
	   brain.getInfo(num, st);
   }
   
   public void countOff(){
	   String r = brain.processResult(position);
	   System.out.println(r);
   }
}
