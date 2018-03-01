package com.sir.go.tool.crawler.shanghai;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;

import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.junit.Test;

public class SubjectExample {
	private static String url = "https://careertree.org/explorer/details?search=%E9%94%80%E5%94%AE%E7%BB%8F%E7%90%86&type=Soc&key=11-2022.00";

	@Test
	public void copyImg() {
		Connection connect = Jsoup.connect(url);
		Document document;
		try {
			document = connect.get();
			System.out.println(document);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	@Test
	public void name() {
		String s = "http://www.shmec.gov.cn/web/jyzt/xkkm2017/index.php?area_id=3416";
		URL url;
		try {
			url = new URL(s);

			HttpURLConnection http = (HttpURLConnection) url.openConnection();
			http.setDoOutput(true);
			http.setDoInput(true);
			http.setRequestMethod("POST");
			http.connect();
			OutputStreamWriter out = new OutputStreamWriter(http.getOutputStream(), "UTF-8");

			String input = "name=flr&nowpage=1&pagesize=10";

			out.append(input);
			out.flush();
			out.close();
			int length = (int) http.getContentLength();
			System.out.println(length);
			BufferedReader reader = new BufferedReader(new InputStreamReader(http.getInputStream()));
			String line;
			StringBuffer buffer = new StringBuffer();
			while ((line = reader.readLine()) != null) {
				buffer.append(line);
			}
			reader.close();
			http.disconnect();
			System.out.println(buffer.toString());
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ProtocolException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
