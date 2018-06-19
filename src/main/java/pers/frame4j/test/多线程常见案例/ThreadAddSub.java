package pers.frame4j.test.多线程常见案例;
/*
 * 设计四个线程对象对同一个数据进行操作
 */
public class ThreadAddSub extends Thread {
	// 判断要进行的操作
	boolean operate = true;
	// 要操作的数
	static int sum = 0;

	// 把操作运算通过构造方法传进来  
	public ThreadAddSub(boolean operate) {
		super();
		this.operate = operate;
	}

	@Override
	public void run() {
		super.run();
		while (true) {
			if (operate) {
				sum += 5;
				System.out.println("加后，sum=" + sum);
			} else {
				sum -= 4;
				System.out.println("减后，sum=" + sum);
			}
			try {
				sleep(500);// 睡眠0.5秒
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}

	}

	public static void main(String[] args) {

		// 创建一个存放ThreadAddSub对象的数组
		ThreadAddSub[] tSub = new ThreadAddSub[4];
		for (int i = 0; i < tSub.length; i++) {

			// 把实例化ThreadAddSub对象赋值到数组内
			// 第一三个是true，二四个是false
			tSub[i] = new ThreadAddSub(i % 2 == 0 ? true : false);

			// 让线程开始工作
			tSub[i].start();
		}

	}
}