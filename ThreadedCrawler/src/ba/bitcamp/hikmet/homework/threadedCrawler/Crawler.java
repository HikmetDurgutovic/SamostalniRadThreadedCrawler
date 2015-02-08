package ba.bitcamp.hikmet.homework.threadedCrawler;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

/**
 * Class Crawler crawles through given URL and returns it HTML code
 * 
 * @author Hikmet
 *
 */
public class Crawler {
	
	private static final int BUFFER_SIZE = 4096;
	private static final String saveFilePath = "." + File.separator + "outputDirectory" + File.separator + "crawled";
	static volatile int pagesCrawled = 0;
	
	/**
	 * Constructor of object Crawler
	 * @param url = Some URL
	 */
	public Crawler(String url) {
		
		
		String fileName = randomString();
		getUrlContents(url, fileName);
	}
	
	/**
	 * Method generates some random String with ten characters of the uppercase alphabet
	 * @return
	 */
	private String randomString() {
		
		StringBuilder sb = new StringBuilder();
		
		for (int i = 0; i <= 9; i++) {
			int num = 65 + (int)(Math.random() * (90 - 65) + 1);
			sb.append((char)num);
		}
		String str = sb.toString();
		return str;
	}

	/**
	 * Method return content of given URL
	 * @param url = Given URL
	 * @param fileName = Name of File in which content will be saved
	 */
	private static void getUrlContents(String url, String fileName) {
		try {
			
			URL urlObject = new URL(url);
			
			URLConnection connection = urlObject.openConnection();
			InputStream in = connection.getInputStream();
			
			FileOutputStream out = new FileOutputStream(saveFilePath + fileName + ".txt");
			
			int bytesRead = -1;
			byte[] buffer = new byte[BUFFER_SIZE];
			while ((bytesRead = in.read(buffer)) != -1) {
				out.write(buffer, 0, bytesRead);
			}

			out.close();
			in.close();
			
		} catch (MalformedURLException e) {
			System.err.println(e.getMessage());
		} catch (IOException e) {
			System.err.println(e.getMessage());
		}
	}

}