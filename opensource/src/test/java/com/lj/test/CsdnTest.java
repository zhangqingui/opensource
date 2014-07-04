package com.lj.test;


public class CsdnTest {    // a[j]-1  a[from]-1  a[from+1]+1   
	private static Integer[] a = new Integer[]{1000,123,232321,8};
	private static Integer num = 0;
	public static void main(String[] args) {
	/*   for(int i=0;i<3;i++){
		   for(int j=0;j<3;j++){
			   if(i==0 || j==3){ 
				   continue;
			   }
			   if(go(i,j)){
				   break;
			   }
		   }
	   }*/
		  go(0,0);
		  go(1,1);
		  for(int j=1;j<4;j++){
			  
		   }
	// go(2,1);
	   for(Integer a1:a){
		   System.out.println(a1);
	   }
	   System.out.println("num"+num);
	}
	public static Integer go(Integer from,Integer to){
		while(true){
		if(a[0]==0 && a[1]==0){
			return 1;
		}
		if(a[to]==0||a[from]==0){
			return 0;
		}
		a[from] --;
		if(from != 0){
			a[from-1] ++;
		}
		a[to]--;
		if(to != 4){
			a[to+1] ++;
		}
		num ++;
		}
	}

}
