package pers.fancy.frame4j.util;

import java.net.URLDecoder;
import java.net.URLEncoder;
import org.apache.commons.codec.digest.DigestUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 编码与解码操作工具类
 * @author Fancy
 */
public final class CodecUtil {

	private static final Logger LOGGER = LoggerFactory.getLogger(CodecUtil.class);

	public static String encodeURL(String source) {
		String target;
		try {
			target = URLEncoder.encode(source, "UTF-8");
		} catch (Exception e) {
			LOGGER.error("encode url failure", e);
			throw new RuntimeException(e);
		}
		return target;
	}

	public static String decodeURL(String source) {
		String target;
		try {
			target = URLDecoder.decode(source, "UTF-8");
		} catch (Exception e) {
			LOGGER.error("decode url failure", e);
			throw new RuntimeException(e);
		}
		return target;
	}

	public static String md5(String source) {
		return DigestUtils.md5Hex(source);
	}
}
