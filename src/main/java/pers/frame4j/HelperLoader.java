package pers.frame4j;

import pers.frame4j.helper.AopHelper;
import pers.frame4j.helper.BeanHelper;
import pers.frame4j.helper.ClassHelper;
import pers.frame4j.helper.ControllerHelper;
import pers.frame4j.helper.IocHelper;
import pers.frame4j.util.ClassUtil;

/**
 * load relative helper
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