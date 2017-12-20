package pers.frame4j.soap;

import pers.frame4j.helper.ConfigHelper;

/**
 * 从配置文件中获取相关属性
 */
public class SoapConfig {

    public static boolean isLog() {
        return ConfigHelper.getBoolean(SoapConstant.LOG);
    }
}
