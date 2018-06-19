package pers.frame4j.test.回调;

import java.util.LinkedList;

public class A implements CallBack {
	B b = new B();
	private String answer = "";
	
	@Override
	public void slove(String str) {
		System.out.println(answer);
	}

	/*
	 * 登记回调函数
	 */
	public void askQuestion() {
		System.out.println("ask b solve the problem!");
		new Thread(new Runnable() {

			@Override
			public void run() {
				System.out.println("A want to do another thing!");
			}
		}).start();
		this.b.call(this);
	}

	/*
	 * test
	 */
	public static void main(String[] args) {
		A a = new A();
		a.askQuestion();
	}
}
