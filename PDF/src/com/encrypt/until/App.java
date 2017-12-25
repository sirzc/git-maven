package com.encrypt.until;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Date;

import org.junit.Test;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.pdf.PdfWriter;
import com.itextpdf.tool.xml.XMLWorkerHelper;

/**
 * @Title: App.java
 * @Package com.pdf.until
 * @Description: TODO(用一句话描述该文件做什么)
 * @author 作者：Administrator
 * @date 创建时间：2017年12月5日 下午7:42:47
 * @version V1.0
 */
public class App {
	public static void main(String[] args) throws DocumentException, IOException {
		// step 1
		Document document = new Document();
		// step 2
		PdfWriter writer = PdfWriter.getInstance(document, new FileOutputStream("D:\\TestDemo/ftchinese.pdf"));
		// step 3
		document.open();
		// step 4
		XMLWorkerHelper.getInstance().parseXHtml(writer, document,
				new FileInputStream("D:/TestDemo/index.html"));
		//step 5
		document.close();

		System.out.println("PDF Created!");
	}
	
	@Test
	public void name() {
		for (int i = 999999950; i < 999999999; i++){
			System.out.println(Long.toString(2147483647-i, 32));
		}
		System.out.println(2147483647-Integer.parseInt("1vvvvnf", 32));
		
	}
	
	public void data() {
		Date  date = new Date();
		
	}
}
