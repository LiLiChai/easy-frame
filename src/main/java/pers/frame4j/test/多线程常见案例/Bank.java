package pers.frame4j.test.多线程常见案例;

/*
 * 两个人AB通过一个账户A在柜台取钱和B在ATM机取钱
 */
public class Bank {
	// 假设一个账户有1000块钱
	static int money = 1000;

	// 柜台Counter取钱的方法
	public void Counter(int money) {// 参数是每次取走的钱
		Bank.money -= money;// 取钱后总数减少
		System.out.println("A取走了" + money + "还剩下" + (Bank.money));
	}

	// ATM取钱的方法
	public void ATM(int money) {// 参数是每次取走的钱
		Bank.money -= money;// 取钱后总数减少
		System.out.println("B取走了" + money + "还剩下" + (Bank.money));
	}

	public static void main(String[] args) {
		// 实力化一个银行对象
		Bank bank = new Bank();
		// 实例化两个人，传入同一个银行的对象
		PersonA pA = new PersonA(bank);
		PersonB pB = new PersonB(bank);
		// 两个人开始取钱
		pA.start();
		pB.start();

	}
}

class PersonA extends Thread {
	// 创建银行对象
	Bank bank;

	// 通过构造器传入银行对象，确保两个人进入的是一个银行
	public PersonA(Bank bank) {
		this.bank = bank;
	}

	// 重写run方法，在里面实现使用柜台取钱
	@Override
	public void run() {
		while (Bank.money >= 100) {
			bank.Counter(100);// 每次取100块
			try {
				sleep(100);// 取完休息0.1秒
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}

class PersonB extends Thread {
	// 创建银行对象
	Bank bank;

	// 通过构造器传入银行对象，确保两个人进入的是一个银行
	public PersonB(Bank bank) {
		this.bank = bank;
	}

	// 重写run方法，在里面实现使用柜台取钱
	@Override
	public void run() {
		while (Bank.money >= 200) {
			bank.ATM(200);// 每次取200块
			try {
				sleep(100);// 取完休息0.1秒
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}

	}
}
