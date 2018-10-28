package pers.auxiliary.reflection;

/**
 * 获取class对象的三种方式
 *
 * @auther: Administrator
 * @date: 2018/10/23 0023 21:28
 */
public class Demo1 {

    public static void main(String[] args) throws ClassNotFoundException {
        new Demo1().getDemoClass();
    }

    public void getDemoClass() throws ClassNotFoundException {
        Class clzz3 = this.getClass();
        Class clzz = Demo1.class;
        Class clzz2 = Class.forName("pers.auxiliary.reflection.Demo1");
    }
}
