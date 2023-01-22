package DropDownConcept.DropDownConcept;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;

public class Practice1 {
	static WebDriver driver;
	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		driver=new ChromeDriver();
		driver.get("https://smartwebby.com/PHP/Phptips2.asp");
		//div[@class='oxd-select-text oxd-select-text--active']/div[@class='oxd-select-text-input']

		List <WebElement>allcheckbox = driver.findElements(By.xpath("//input[@type='checkbox']"));
		// to select all checkboxes
		/*	for(WebElement checkbox:allcheckbox)
	{
		checkbox.click();	
	} */
		// to select multiple checkbox by attribute value
		/*	for(WebElement checkbox:allcheckbox)
	{
		String actvalue=checkbox.getAttribute("value");
		if(actvalue.equals("PHP") || actvalue.equals("ASP"))
		{
			checkbox.click();
		}
	} */
		// select last two
		/*	int checkboxsize=allcheckbox.size();
	for(int i=checkboxsize-2;i<checkboxsize;i++)// to select last two
	{
		allcheckbox.get(i).click();
	}  */
		//select first two
		int checkboxsize=allcheckbox.size();
		for(int i=0;i<checkboxsize;i++)
		{
			if(i<2)// to select first two
			{
				allcheckbox.get(i).click();
			}
		}







	}
}

