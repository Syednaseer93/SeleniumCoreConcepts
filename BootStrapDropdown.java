package DropDownConcept.DropDownConcept;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BootStrapDropdown {
	static WebDriver driver;
	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		driver=new ChromeDriver();
		driver.get("https://www.hdfcbank.com/");
		driver.findElement(By.xpath("/html/body/div[1]/div/div[2]/div[12]/div[1]/div/div/div[2]/div[1]/div[3]/div/div/div/div/div/div[2]/div/a\r\n"
				+ "")).click();
		Thread.sleep(3000);

		List <WebElement> producttypes=driver.findElements(By.xpath("//div[@class='dropdown1 dropdown=menu']/li"));
		for(WebElement product:producttypes)
		{
			if(product.getText().equals("EMI"))
			{
				product.click();
				break;		
			}  
		}
		driver.findElement(By.xpath("/html/body/div[1]/div/div[2]/div[12]/div[1]/div/div/div[2]/div[1]/div[3]/div/div/div/div/div/div[3]/div/a\r\n"
				+ "")).click();
		List <WebElement> product=driver.findElements(By.xpath("ul[@class='dropdown2 dropdown-menu'//li"));
		for(WebElement product2:product)
		{
			if(product2.getText().equals("Salary Accounts"))
			{
				product2.click();
				break;
			}
		}
	}
/*	public static void selectFromDropdown(List <WebElement-qa	>, String value)
	{
	List <WebElement> product=driver.findElements(By.xpath("ul[@class='dropdown2 dropdown-menu'//li"));
		for(WebElement product2:product)
		{
			if(product2.getText().equals(value))
			{	
				product2.click();
				break;
			}
		}
		
		
	}
*/
}
