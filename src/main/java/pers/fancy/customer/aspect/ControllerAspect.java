package pers.fancy.customer.aspect;

import java.lang.reflect.Method;

import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import pers.fancy.frame4j.annotation.Aspect;
import pers.fancy.frame4j.annotation.Controller;
import pers.fancy.frame4j.proxy.AspectProxy;


/**
 * @author fancy
 */
@Slf4j
@Aspect(Controller.class)
public class ControllerAspect extends AspectProxy {

    @Override
    public void before(Class<?> cls, Method method, Object[] params) throws Throwable {
        log.debug("执行前置方法 {} ", method.getName());
    }

    @Override
    public void after(Class<?> cls, Method method, Object[] params, Object result) throws Throwable {
        log.debug("执行后置方法 {} ", method.getName());
    }

}
