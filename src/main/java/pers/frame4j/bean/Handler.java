package pers.frame4j.bean;

import java.lang.reflect.Method;

/**
 * Action encapsulation
 */
public class Handler {

    /**
     * Controller 
     */
    private Class<?> controllerClass;

    /**
     * Action 
     */
    private Method actionMethod;

    public Handler(Class<?> controllerClass, Method actionMethod) {
        this.controllerClass = controllerClass;
        this.actionMethod = actionMethod;
    }

    public Class<?> getControllerClass() {
        return controllerClass;
    }

    public Method getActionMethod() {
        return actionMethod;
    }
}
