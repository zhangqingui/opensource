package com.lj.test;


/**
 * 大脑运算室
 * @author qinghui.zhang
 *3. 学生报数时，如果所报数字是第一个特殊数（3）的倍数，那么不能说该数字，而要说Fizz；如果所报数字是第二个特殊数（5）的倍数，那么要说Buzz；如果所报数字是第三个特殊数（7）的倍数，那么要说Whizz。
4. 学生报数时，如果所报数字同时是两个特殊数的倍数情况下，也要特殊处理，比如第一个特殊数和第二个特殊数的倍数，那么不能说该数字，而是要说FizzBuzz, 以此类推。如果同时是三个特殊数的倍数，那么要说FizzBuzzWhizz。
5. 学生报数时，如果所报数字包含了第一个特殊数，那么也不能说该数字，而是要说相应的单词，比如本例中第一个特殊数是3，那么要报13的同学应该说Fizz。如果数字中包含了第一个特殊数，那么忽略规则3和规则4，比如要报35的同学只报Fizz，不报BuzzWhizz。
 */
public class Brain {
	private  String[] num = new String[]{"3","5","7"};
	private  String[] st = new String[]{"Fizz","Buzz","Whizz"};
	private static Brain brain = new Brain();
	private Brain(){
	}
	public static Brain InitBrain(){
		if(brain  instanceof Brain){
			return brain;
		}
		return new Brain();
	}
	
	public void getInfo(String[] num,String[] st ){
		if(!isEmpty(num)){
			this.num = num;
		}
	    if(!isEmpty(st)){
			this.st = st;
		}
	}
	
	public   String processResult(Integer n){
		String ts = String.valueOf(n);
		String s = "";
		if(ts.contains(num[0])){
			return st[0];
		}
		for(int j=0;j<num.length;j++){
			
			if(n%Integer.parseInt(num[j])==0){
				s = s+ st[j];
			}
		}
		return s.equals("")?ts:s;
	}
    public  boolean isEmpty(Object[] array) {
        return array == null || array.length == 0;
    }
}
