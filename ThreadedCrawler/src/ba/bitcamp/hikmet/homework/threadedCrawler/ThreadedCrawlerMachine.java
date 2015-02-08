package ba.bitcamp.hikmet.homework.threadedCrawler;

import java.io.File;
import java.util.ArrayList;

/**
 * ThreadedCrawlerMachine is a web site crawler which works with threads and creates separate threads
 * for each web site which will be crawled.
 * 
 * @author Hikmet
 *
 */
public class ThreadedCrawlerMachine {
	
	/**
	 * Class Main of ThreadedCrawlerMachine
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		
		// ArrayList of URLs which will be crawled
		ArrayList<String> urls = new ArrayList<String>();
		urls.add("http://klix.ba");
		urls.add("http://index.hr");
		urls.add("http://radiosarajevo.ba");
		urls.add("http://avaz.ba");
		urls.add("http://transfermarkt.de");
		urls.add("http://rtl.de");
		
		// Creation of output folder
		File outputDirectory = new File("." + File.separator + "outputDirectory");
		
		// If there is no directory, this ensures it will be created
		if (!outputDirectory.exists()) {
			System.out.println("Output directory doesn't exist.");
			outputDirectory.mkdir();
			System.out.println("Output directory has been created.");
		}
		
		// For Each loop which creates a new thread for every URL
		for (String s : urls) {
			ThreadedCrawler threadedCrawler = new ThreadedCrawler(s);
			Thread thread = new Thread(threadedCrawler);
			thread.start();
		}
		
	}

}
