package pers.frame4j.helper;

import java.lang.annotation.Annotation;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import pers.frame4j.annotation.Aspect;
import pers.frame4j.annotation.Service;
import pers.frame4j.proxy.AspectProxy;
import pers.frame4j.proxy.Proxy;
import pers.frame4j.proxy.ProxyManager;
import pers.frame4j.proxy.TransactionProxy;

/**
 * method intercept 动态代理
 * @author Fancy
 */
public final class AopHelper {

	private static final Logger LOGGER = LoggerFactory.getLogger(AopHelper.class);

	static {
		try {
			Map<Class<?>, Set<Class<?>>> proxyMap = createProxyMap();
			Map<Class<?>, List<Proxy>> targetMap = createTargetMap(proxyMap);
			for (Map.Entry<Class<?>, List<Proxy>> targetEntry : targetMap.entrySet()) {
				Class<?> targetClass = targetEntry.getKey();
				List<Proxy> proxyList = targetEntry.getValue();
				// 拆分成类 代理类一一对应，AOP类已去掉
				Object proxy = ProxyManager.createProxy(targetClass, proxyList);
				BeanHelper.setBean(targetClass, proxy);
			}
		} catch (Exception e) {
			LOGGER.error("aop failure", e);
		}
	}

	/**
	 * Map左边代理类.class 右边带注解类.class
	 * @return
	 * @throws Exception
	 */
	private static Map<Class<?>, Set<Class<?>>> createProxyMap() throws Exception {
		Map<Class<?>, Set<Class<?>>> proxyMap = new HashMap<>(0);
		addAspectProxy(proxyMap);
		addTransactionProxy(proxyMap);
		return proxyMap;
	}


	/**
	 * 获取所有Controller.class
	 * @param aspect
	 * @return
	 */
	private static Set<Class<?>> createTargetClassSet(Aspect aspect) {
		Set<Class<?>> targetClassSet = new HashSet<>();
		Class<? extends Annotation> annotation = aspect.value();
		if (annotation != null && !annotation.equals(Aspect.class)) {
			targetClassSet.addAll(ClassHelper.getClassSetByAnnotation(annotation));
		}
		return targetClassSet;
	}


	/**
	 * Map中放入带注解的类 List放入类的代理类
	 * @param proxyMap
	 * @return
	 * @throws Exception
	 */
	private static Map<Class<?>, List<Proxy>> createTargetMap(Map<Class<?>, Set<Class<?>>> proxyMap) throws Exception {
		Map<Class<?>, List<Proxy>> targetMap = new HashMap<>(0);
		for (Map.Entry<Class<?>, Set<Class<?>>> proxyEntry : proxyMap.entrySet()) {
			Class<?> proxyClass = proxyEntry.getKey();
			Set<Class<?>> targetClassSet = proxyEntry.getValue();
			for (Class<?> targetClass : targetClassSet) {
				Proxy proxy = (Proxy) proxyClass.newInstance();
				if (targetMap.containsKey(targetClass)) {
					targetMap.get(targetClass).add(proxy);
				} else {
					List<Proxy> proxyList = new ArrayList<>();
					proxyList.add(proxy);
					targetMap.put(targetClass, proxyList);
				}
			}
		}
		return targetMap;
	}


	/**
	 * 一个AspectProxy实现类，管理所有Controller类，从而对Controller实现AOP功能
	 * 问题：多个AspectProxy实现,类作用相同controller怎么解决？
	 * @param proxyMap
	 */
	private static void addAspectProxy(Map<Class<?>, Set<Class<?>>> proxyMap) {
		Set<Class<?>> proxyClassSet = ClassHelper.getClassSetBySuper(AspectProxy.class);
		for (Class<?> proxyClass : proxyClassSet) {
			if (proxyClass.isAnnotationPresent(Aspect.class)) {
				Aspect aspect = proxyClass.getAnnotation(Aspect.class);
				Set<Class<?>> targetClassSet = createTargetClassSet(aspect);
				proxyMap.put(proxyClass, targetClassSet);
			}
		}
	}


	/**
	 * Set中放入所有带@Service的类
	 * @param proxyMap
	 */
	private static void addTransactionProxy(Map<Class<?>, Set<Class<?>>> proxyMap) {
		Set<Class<?>> serviceClassSet = ClassHelper.getClassSetByAnnotation(Service.class);
		proxyMap.put(TransactionProxy.class, serviceClassSet);
	}

}
