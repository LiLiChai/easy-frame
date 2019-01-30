package pers.fancy.frame4j.common;

import pers.fancy.frame4j.helper.AopHelper;
import pers.fancy.frame4j.helper.ControllerHelper;
import pers.fancy.frame4j.helper.IocHelper;
import pers.fancy.frame4j.util.ClassUtil;
import pers.fancy.frame4j.helper.BeanHelper;
import pers.fancy.frame4j.helper.ClassHelper;

/**
 * @author FancyLi
 * @time 2018-09-28
 */
public final class HelperLoader {

    public static void init() {
        Class<?>[] classList = {
            ClassHelper.class,
            BeanHelper.class,
            AopHelper.class,
            IocHelper.class,
            ControllerHelper.class
        };
        for (Class<?> cls : classList) {
            ClassUtil.loadClass(cls.getName());
        }
    }
}