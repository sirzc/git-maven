package com.sir.go.tool.hutool;

import org.junit.Test;

import cn.hutool.core.lang.Console;
import cn.hutool.core.util.CharsetUtil;
import cn.hutool.core.util.HexUtil;
import cn.hutool.crypto.SecureUtil;

/**
 * @Title: HuToolTest.java
 * @Package com.sir.go.tool.hutool
 * @Description: TODO(用一句话描述该文件做什么)
 * @author 作者：Administrator
 * @date 创建时间：2018年2月6日 下午3:14:45
 * @version V1.0
 */
public class HuToolTest {
	@Test
	public void name() {
		String str = "1001";
		String hex = HexUtil.encodeHexStr(str, CharsetUtil.CHARSET_UTF_8);
		System.out.println(hex);
		String decodedStr = HexUtil.decodeHexStr(hex);
		System.out.println(decodedStr);

		String[] a = { "abc", "bcd", "def" };
		Console.log(a);
		System.out.println(a);
		Console.log("This is Console log for {{}}.", "test");
		Console.log(CharsetUtil.defaultCharset());

		String aString = SecureUtil.simpleUUID();
		System.out.println(aString);

	}
}
