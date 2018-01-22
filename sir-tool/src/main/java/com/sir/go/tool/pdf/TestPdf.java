package com.sir.go.tool.pdf;

import java.io.ByteArrayOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.junit.Test;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.pdf.AcroFields;
import com.itextpdf.text.pdf.PdfCopy;
import com.itextpdf.text.pdf.PdfImportedPage;
import com.itextpdf.text.pdf.PdfReader;
import com.itextpdf.text.pdf.PdfStamper;

/**
 * @Title: TestPdf.java
 * @Package com.sir.go.tool.pdf
 * @Description: TODO(用一句话描述该文件做什么)
 * @author 作者：sirzc
 * @date 创建时间：2018年1月8日 下午7:18:02
 * @version V1.0
 */
public class TestPdf {
	@Test
	public void fillTemplate() {// 利用模板生成pdf
		// 模板路径
		String templatePath = "C:/Users/Administrator/Desktop/test.pdf";
		// 生成的新文件路径
		String newPDFPath = "C:/Users/Administrator/Desktop/test1.pdf";
		PdfReader reader;
		FileOutputStream out;
		ByteArrayOutputStream bos;
		PdfStamper stamper;
		try {
			out = new FileOutputStream(newPDFPath);// 输出流
			reader = new PdfReader(templatePath);// 读取pdf模板
			bos = new ByteArrayOutputStream();
			stamper = new PdfStamper(reader, bos);
			AcroFields form = stamper.getAcroFields();

			String[] str = { "123456789", "23333", "boy", "1994-00-00", "130222111133338888", "河北省唐山市" };
			int i = 0;
			java.util.Iterator<String> it = form.getFields().keySet().iterator();
			while (it.hasNext()) {
				String name = it.next().toString();
				System.out.println(name);
				form.setField(name, str[i++]);
			}
			stamper.setFormFlattening(true);// 如果为false那么生成的PDF文件还能编辑，一定要设为true
			stamper.close();

			Document doc = new Document();
			PdfCopy copy = new PdfCopy(doc, out);
			doc.open();
			PdfImportedPage importPage = copy.getImportedPage(new PdfReader(bos.toByteArray()), 1);
			copy.addPage(importPage);
			doc.close();

		} catch (IOException e) {
			System.out.println(1);
		} catch (DocumentException e) {
			System.out.println(2);
		}

	}
}
