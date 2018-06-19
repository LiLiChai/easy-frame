package pers.frame4j.test.回调;

public class B {
	/*
	 * 回调函数
	 */
	public void call(CallBack a){
		System.out.println("b help a solve the problem!");
		
		a.slove("答案是2");
	}
}
