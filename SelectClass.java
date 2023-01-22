package DropDownConcept.DropDownConcept;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class SelectClass {

	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		driver.get("https://www.opencart.com/index.php?route=account/register");
		driver.manage().window().maximize();
		//First Approach with select class
		
		/*	WebElement ele1=driver.findElement(By.xpath("//*[@id=\"input-country\"]\r\n"
				+ ""));
		Select country=new Select(ele1);
		country.selectByVisibleText("India");*/
		
		//Second Approach
		WebElement ele=driver.findElement(By.xpath("//*[@id=\"input-country\"]\r\n"
				+ ""));
		Select country=new Select(ele);
		  List <WebElement> ele2=  country.getOptions();
		  for(WebElement ele3:ele2)
		  {
			 String actualvalue =ele3.getText();
			 if(actualvalue.equals("Bahrain"))
			 {
				 ele3.click();
				 break;
			 }
		  }
     
		  
		  

		
		
		
		
		
		
		
		
		Thread.sleep(3000);
		driver.close();

	}

}
