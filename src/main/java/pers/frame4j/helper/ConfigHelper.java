package pers.frame4j.helper;

import java.util.Properties;

import pers.frame4j.common.ConfigConstant;
import pers.frame4j.util.PropertiesUtil;

/**
 * config helper
 *
 * @author Fancy
 */
public final class ConfigHelper {

	private static final Properties CONFIG_PROPS = PropertiesUtil.loadProps(ConfigConstant.CONFIG_FILE);

	/**
	 * 获取 JDBC 驱动
	 */
	public static String getJdbcDriver() {
		return PropertiesUtil.getString(CONFIG_PROPS, ConfigConstant.JDBC_DRIVER);
	}

	/**
	 * 获取 JDBC URL
	 */
	public static String getJdbcUrl() {
		return PropertiesUtil.getString(CONFIG_PROPS, ConfigConstant.JDBC_URL);
	}

	/**
	 * 获取 JDBC 用户名
	 */
	public static String getJdbcUsername() {
		return PropertiesUtil.getString(CONFIG_PROPS, ConfigConstant.JDBC_USERNAME);
	}

	/**
	 * 获取 JDBC 密码
	 */
	public static String getJdbcPassword() {
		return PropertiesUtil.getString(CONFIG_PROPS, ConfigConstant.JDBC_PASSWORD);
	}

	/**
	 * 获取应用基础包名
	 */
	public static String getAppBasePackage() {
		return PropertiesUtil.getString(CONFIG_PROPS, ConfigConstant.APP_BASE_PACKAGE);
	}

	/**
	 * 获取应用 JSP 路径
	 */
	public static String getAppJspPath() {
		return PropertiesUtil.getString(CONFIG_PROPS, ConfigConstant.APP_JSP_PATH, "/WEB-INF/zhy/");
	}

	/**
	 * 获取应用静态资源路径
	 */
	public static String getAppAssetPath() {
		return PropertiesUtil.getString(CONFIG_PROPS, ConfigConstant.APP_ASSET_PATH, "/asset/");
	}

	/**
	 * 获取应用文件上传限制
	 */
	public static int getAppUploadLimit() {
		return PropertiesUtil.getInt(CONFIG_PROPS, ConfigConstant.APP_UPLOAD_LIMIT, 10);
	}

	/**
	 * 根据属性名获取 String 类型的属性值
	 */
	public static String getString(String key) {
		return PropertiesUtil.getString(CONFIG_PROPS, key);
	}

	/**
	 * 根据属性名获取 int 类型的属性值
	 */
	public static int getInt(String key) {
		return PropertiesUtil.getInt(CONFIG_PROPS, key);
	}

	/**
	 * 根据属性名获取 boolean 类型的属性值
	 */
	public static boolean getBoolean(String key) {
		return PropertiesUtil.getBoolean(CONFIG_PROPS, key);
	}
}
