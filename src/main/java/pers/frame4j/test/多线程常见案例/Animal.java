package pers.frame4j.test.多线程常见案例;

import pers.frame4j.test.多线程常见案例.Animal.Calltoback;

public abstract class Animal extends Thread {
	public double length = 20;// 比赛的长度

	public abstract void runing();// 抽象方法需要子类实现

	// 在父类重写run方法，在子类只要重写running方法就可以了
	@Override
	public void run() {
		super.run();
		while (length > 0) {
			runing();
		}
	}

	// 在需要回调数据的地方（两个子类需要），声明一个接口
	public static interface Calltoback {
		public void win();
	}

	// 2.创建接口对象
	public Calltoback calltoback;

}

class Rabbit extends Animal {

	public Rabbit() {
		setName("兔子");// Thread的方法，给线程赋值名字
	}

	// 重写running方法，编写兔子的奔跑操作
	@Override
	public void runing() {
		// 跑的距离
		double dis = 0.5;
		length -= dis;// 跑完后距离减少
		if (length <= 0) {
			length = 0;
			System.out.println("兔子获得了胜利");
			// 给回调对象赋值，让乌龟不要再跑了
			if (calltoback != null) {
				calltoback.win();
			}
		}
		System.out.println("兔子跑了" + dis + "米，距离终点还有" + (int) length + "米");

		if (length % 2 == 0) {// 两米休息一次
			try {
				sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}

class Tortoise extends Animal {

	public Tortoise() {
		setName("乌龟");// Thread的方法，给线程赋值名字
	}

	// 重写running方法，编写乌龟的奔跑操作
	@Override
	public void runing() {
		// 跑的距离
		double dis = 0.1;
		length -= dis;
		if (length <= 0) {
			length = 0;
			System.out.println("乌龟获得了胜利");
			// 让兔子不要在跑了
			if (calltoback != null) {
				calltoback.win();
			}
		}
		System.out.println("乌龟跑了" + dis + "米，距离终点还有" + (int) length + "米");
		try {
			sleep(100);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}

class LetOneStop implements Calltoback {

	// 动物对象
	Animal an;

	// 获取动物对象，可以传入兔子或乌龟的实例
	public LetOneStop(Animal an) {
		this.an = an;
	}

	// 让动物的线程停止
	@Override
	public void win() {
		// 线程停止
		an.stop();
	}

}

