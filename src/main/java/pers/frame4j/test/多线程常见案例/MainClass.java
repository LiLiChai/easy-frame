package pers.frame4j.test.多线程常见案例;

public class MainClass {
	/**
	 * 龟兔赛跑：20米
	 */
	public static void main(String[] args) {
		// 实例化乌龟和兔子
		Tortoise tortoise = new Tortoise();
		Rabbit rabbit = new Rabbit();
		// 回调方法的使用，谁先调用calltoback方法，另一个就不跑了
		LetOneStop letOneStop1 = new LetOneStop(tortoise);
		rabbit.calltoback = letOneStop1;// 让兔子的回调方法里面存在乌龟对象的值，可以把乌龟stop
		LetOneStop letOneStop2 = new LetOneStop(rabbit);
		tortoise.calltoback = letOneStop2;// 让乌龟的回调方法里面存在兔子对象的值，可以把兔子stop
		// 开始跑
		tortoise.start();
		rabbit.start();

	}

}