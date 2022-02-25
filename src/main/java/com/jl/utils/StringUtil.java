package com.jl.utils;


/**
 * 字符串处理的工具类
 * @author peterlin
 *
 */
public class StringUtil {
	/**
	 * 检查字符串是否为空
	 * @param info
	 * @return
	 */
	public static boolean doCheckNotNull(String info) {
		
		if (null==info ||"".equals(info)) {
			return false;
		}
		return true;
	}

}
