package DropDownConcept.DropDownConcept;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BrokenLinks {
	static WebDriver driver;
	public static void main(String[] args) throws IOException {
		WebDriverManager.chromedriver().setup();
		driver=new ChromeDriver();
		driver.get("http://www.deadlinkcity.com/");
		List <WebElement> links =driver.findElements(By.tagName("a"));
		int brokenlink=0;
		for(WebElement templink:links)
		{
			String url=templink.getAttribute("href");
			if(url==null || url.isEmpty())
			{
				System.out.println("url is empty");
				continue;
			}
			URL link=new URL(url);
			try {
				HttpURLConnection httpcon=(HttpURLConnection) link.openConnection();
				httpcon.connect();
				if(httpcon.getResponseCode()>=400)
				{
					System.out.println(httpcon.getResponseCode()+url+" is "+"Broken Link");
					brokenlink++;
				}
				else
				{
					System.out.println(httpcon.getResponseCode()+" is "+"Valid Link");
				}

			}
			catch(Exception e)
			{

			}
			


		}
		System.out.println("Total Broken Links are:"+brokenlink);
		driver.quit();
	}
}
