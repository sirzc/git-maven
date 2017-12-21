package com.pdf.change;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.charset.Charset;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Font;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.BaseFont;
import com.itextpdf.text.pdf.PdfWriter;
import com.itextpdf.tool.xml.XMLWorkerHelper;

/**   
 * @Title: ParseHtml.java
 * @Package com.pdf.change
 * @Description: HTML转pdf
 * @author 作者：Administrator
 * @date 创建时间：2017年12月7日 上午10:57:03
 * @version V1.0   
 */
public class ParseHtml {
	 public static final String HTML = "D:/TestDemo/ftchinese.html";
	    public static final String DEST = "D:/TestDemo/2222222.pdf";
	 
	    /**
	     * Creates a PDF with the words "Hello World"
	     * @param file
	     * @throws IOException
	     * @throws DocumentException
	     */
	    public void createPdf(String file) throws IOException, DocumentException {
	        // step 1
	        Document document = new Document(PageSize.A3.rotate());
 
	        // step 2
	        
	        PdfWriter writer = PdfWriter.getInstance(document, new FileOutputStream(file));
	        // step 3
	        document.open();
	        // step 4
	        XMLWorkerHelper.getInstance().parseXHtml(writer, document,
	                new FileInputStream(HTML), Charset.forName("UTF-8"));
	        // step 5
	        document.close();
	    }
	 
	    /**
	     * Main method
	     */
	    public static void main(String[] args) throws IOException, DocumentException {
	        File file = new File(DEST);
	        file.getParentFile().mkdirs();
	        new ParseHtml().createPdf(DEST);
	    }
	
}
