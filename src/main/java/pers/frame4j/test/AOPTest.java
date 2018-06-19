package pers.frame4j.test;

import java.lang.reflect.Method;

import net.sf.cglib.proxy.Callback;
import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

public class AOPTest  implements MethodInterceptor{
	private Object obj;  
    public Object createProxy(Object target) {  
        this.obj = target;  
        Enhancer enhancer = new Enhancer();  
        enhancer.setSuperclass(this.obj.getClass());// 设置代理目标  
        enhancer.setCallback((Callback) this);// 设置回调  
        enhancer.setClassLoader(target.getClass().getClassLoader());  
        return enhancer.create();  
    }  
  
    @Override  
    public Object intercept(Object obj, Method method, Object[] args, MethodProxy proxy) throws Throwable {  
        Object result = null;  
        try {  
            // 前置通知  
            before();  
            result = proxy.invokeSuper(obj, args);  
            // 后置通知  
            after();  
        } catch (Exception e) {  
            exception();  
        }finally{  
            beforeReturning();  
        }  
        return result;  
    }  
  
  
    private void before() {  
        System.out.println("before method invoke");  
    }  
    private void after() {  
        System.out.println("after method invoke");  
    }  
    private void exception() {  
        System.out.println("method invoke exception");  
    }  
    private void beforeReturning() {  
        System.out.println("before returning");  
    }
    
    public static void main(String[] args) throws Exception {  
        Hello hello = new Hello();  
        AOPTest cglibProxy = new AOPTest();  
        Hello proxy = (Hello) cglibProxy.createProxy(hello);  
        String result=proxy.sayHello(true);  
        System.out.println(result);  
    }  
}

class Hello {  
    public String sayHello(boolean throwException) throws Exception {  
        System.out.println("hello everyone!");  
        if(throwException)  
            throw new Exception("test exception");  
        return "123";  
    }  
}