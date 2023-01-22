package DropDownConcept.DropDownConcept;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class SwitchWindowHandles {
	static WebDriver driver;
		public static void main(String[] args) throws InterruptedException {
			WebDriverManager.chromedriver().setup();
			driver=new ChromeDriver();
			driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
			Thread.sleep(3000);
			driver.findElement(By.linkText("OrangeHRM, Inc")).click();
			Set<String> windowHandles=driver.getWindowHandles();
			List<String> windowHandlesList=new ArrayList(windowHandles); //convert set into list
		/*	for(String winids:windowHandlesList)
			{
				System.out.println(driver.switchTo().window(winids).getTitle());
			} */
			
			for(String winids:windowHandlesList)
			{
				String title=driver.switchTo().window(winids).getTitle();
				if(title.equals("OrangeHRM")) // to close perticular window
				{
					driver.close();
				}
			}
			
			
		}

}
