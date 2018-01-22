package com.sirzc.go.test;

import org.junit.Test;

public class AsciiChange {

	@Test
	public void name() {
		String elementId = "1.B.1.f";
		byte b = elementId.getBytes()[elementId.length() - 1];
		elementId = (b - 96) + "";
		System.out.println(elementId);
	}
}
