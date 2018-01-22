package com.sir.go.crawler;

import java.io.BufferedInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.UUID;

import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class ForExample {
	private static String url = "https://sz.lianjia.com/zufang/";

	public static void copyImg() {
		Connection connect = Jsoup.connect(url);
		Document document;
		try{
			document = connect.get();
			System.out.println(document);
			Elements element = document.getElementsByClass("house-lst");
			Elements aImgs = element.get(0).getElementsByTag("img");
			for (Element a : aImgs){
				String src = a.attr("data-img");
				String alt = a.attr("alt");
				System.out.println(src + "," + alt);
				// 下载img标签里面的图片到本地
				WebContext.saveToFile(src, "D:\\新建文件夹/");
			}
		} catch (IOException e){
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
 
	public static void copyHtml() {
		FileOutputStream foStream = null;
		Connection connect = Jsoup.connect(url);
		try{
			Document document = connect.get();
			System.out.println(document);
			foStream = new FileOutputStream("D:\\新建文件夹/233.html");
			foStream.write(document.toString().getBytes());
		} catch (FileNotFoundException e){
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e){
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try{
				foStream.close();
			} catch (IOException e){
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	public static void saveToFile(String destUrl, String saveUrl) {
		FileOutputStream fos = null;
		BufferedInputStream bis = null;
		HttpURLConnection httpUrl = null;
		URL url = null;
		String uuid = UUID.randomUUID().toString(); //生成不重复的随机数
		String fileAddress = saveUrl + uuid;// 存储本地文件地址
		int BUFFER_SIZE = 1024;
		byte[] buf = new byte[BUFFER_SIZE];
		int size = 0;
		try{
			url = new URL(destUrl);
			httpUrl = (HttpURLConnection) url.openConnection(); //打开一个新的url连接，创建了一个连接对象
			httpUrl.connect(); //执行连接对象，建立连接关系
			String Type = httpUrl.getHeaderField("Content-Type"); //获取信息头
			if (Type.equals("image/gif")){
				fileAddress += ".gif";
			} else if (Type.equals("image/png")){
				fileAddress += ".png";
			} else if (Type.equals("image/jpeg")){
				fileAddress += ".jpg";
			} else{
				System.err.println("未知图片格式");
				return;
			}
			bis = new BufferedInputStream(httpUrl.getInputStream());
			fos = new FileOutputStream(fileAddress);
			while ((size = bis.read(buf)) != -1){
				fos.write(buf, 0, size);
			}
			fos.flush();
			System.out.println("图片保存成功！地址：" + fileAddress);
		} catch (IOException e){
			e.printStackTrace();
		} catch (ClassCastException e){
			e.printStackTrace();
		} finally{
			try{
				fos.close();
				bis.close();
				httpUrl.disconnect(); //关闭连接
			} catch (IOException e){
				e.printStackTrace();
			} catch (NullPointerException e){
				e.printStackTrace();
			}
		}
	}
}
