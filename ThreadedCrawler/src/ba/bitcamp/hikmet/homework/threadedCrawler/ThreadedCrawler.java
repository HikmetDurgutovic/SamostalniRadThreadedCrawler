package ba.bitcamp.hikmet.homework.threadedCrawler;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Date;

/**
 * Class ThreadedCrawler creates new thread for each Crawler started
 * and creates a report on job done
 * 
 * @author Hikmet
 *
 */
public class ThreadedCrawler implements Runnable {
	
	private String url;
	private static volatile int threads = 0;
	private static File crawlingDirectory = new File("." + File.separator + "CrawlingDirectory");
	private volatile File crawlingDiaries = new File("." + File.separator + "CrawlingDirectory" + File.separator + "crawling_diaries");
	
	/**
	 * Constructor of object ThreadedCrawler
	 * @param url = Given URL
	 */
	public ThreadedCrawler(String url) {
		
		this.url = url;
	}

	/**
	 * Override method run from interface Runnable
	 * creates new Crawler and reports of job done
	 */
	@Override
	public synchronized void run() {
		
		@SuppressWarnings("unused")
		Crawler crawler = new Crawler(url);
		Crawler.pagesCrawled++;
		threads++;
		System.out.println("Thread " + threads + " started.");
		System.out.println("Pages crawled done: " + Crawler.pagesCrawled);
		
		reportToFile();
	}

	/**
	 * Method creates new file and writes report on job done
	 */
	private synchronized void reportToFile() {
		
		// If there is no directory, this ensures it will be created
		if (!crawlingDirectory.exists()) {
			System.out.println("Crawling directory doesn't exist.");
			crawlingDirectory.mkdir();
			System.out.println("Crawling directory has been created.");
		}
		
		//Writing to file
		try {
			FileWriter fw = new FileWriter(crawlingDiaries, true);
			fw.write(url + " : " + new Date() + "\n\r");
			fw.write("Pages crawled done: " + Crawler.pagesCrawled + "\n\r");
			fw.close();
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	

}