package pers.frame4j.test.多线程常见案例;

import java.util.ArrayList;
import java.util.List;

class Food {
	String name = "";

	// 通过构造方法传入食物的名字
	public Food(String name) {
		this.name = name;
	}

	// get、set 方法
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}

public class KFC {
	// 食物的种类
	String[] names = { "薯条", "烧板", "鸡翅", "可乐" };

	// 生产的最大值，到达后可以休息
	static final int Max = 20;

	// 存放食物的集合
	List<Food> foods = new ArrayList<Food>();

	// 生产食物的方法
	public void prod(int index) {
		synchronized (this) {
			// 如果食物数量大于20
			while (foods.size() > Max) {
				System.out.println("食材够了");
				this.notifyAll();// 这个唤醒是针对生产者和消费者，有all
				try {
					String name = Thread.currentThread().getName();
					this.wait();// 这个唤醒是针对生产者，没有all
					System.out.println("生产者：" + name);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}

			// 开始生产食物食物//有一点要注意的
			System.out.println("开始生产食物");
			for (int i = 0; i < index; i++) {
				Food food = new Food(names[(int) (Math.random() * 4)]);
				foods.add(food);
				System.out.println("生产了" + food.getName() + foods.size());
			}
		}
	}

	// 消费食物的方法
	public void consu(int index) {
		synchronized (this) {
			while (foods.size() < index) {
				System.out.println("食材不够了");
				this.notifyAll();// 这个唤醒是针对生产者和消费者，有all
				try {
					String name = Thread.currentThread().getName();
					this.wait();// 这个唤醒是针对消费者，没有all
					System.out.println("消费者：" + name);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
			// 足够消费
			System.out.println("开始消费");
			for (int i = 0; i < index; i++) {
				Food food = foods.remove(foods.size() - 1);
				System.out.println("消费了一个" + food.getName() + foods.size());
			}
		}
	}

	public static void main(String[] args) {

		// 只实例化一个KFC对象，保证每一个服务员和用户在同一个KFC对象内
		KFC kfc = new KFC();

		// 实例化4个客户对象
		Customers c1 = new Customers(kfc);
		Customers c2 = new Customers(kfc);
		Customers c3 = new Customers(kfc);
		Customers c4 = new Customers(kfc);

		// 实例化3个服务员对象
		Waiter waiter1 = new Waiter(kfc);
		Waiter waiter2 = new Waiter(kfc);
		Waiter waiter3 = new Waiter(kfc);

		// 让所有的对象的线程都开始工作
		waiter1.start();
		waiter2.start();
		waiter3.start();
		c1.start();
		c2.start();
		c3.start();
		c4.start();
	}
}

class Customers extends Thread {
	KFC kfc;

	// KFC要传入，保证每一个服务员和用户在同一个KFC对象内
	public Customers(KFC kfc) {
		this.kfc = kfc;
	}

	@Override
	public void run() {
		int size = (int) (Math.random() * 5);// 每次要消费的食物的数量
		while (true) {
			kfc.consu(size);// 在消费的方法里面传入参数
		}

	}
}

class Waiter extends Thread {
	KFC kfc;

	// KFC要传入，保证每一个服务员和用户在同一个KFC对象内
	public Waiter(KFC kfc) {
		this.kfc = kfc;
	}

	@Override
	public void run() {
		int size = (int) (Math.random() * 5) + 5;// 每次生产的数量
		while (true) {
			kfc.prod(size);// 传入每次生产的数量
		}

	}
}
