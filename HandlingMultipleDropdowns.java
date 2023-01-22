package DropDownConcept.DropDownConcept;

import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import io.github.bonigarcia.wdm.WebDriverManager;


public class HandlingMultipleDropdowns {
	static WebDriver driver;

	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		driver=new ChromeDriver();
		driver.get("https://formstone.it/components/dropdown/demo/");
		
		driver.manage().window().maximize();
		WebElement native1=driver.findElement(By.xpath("//*[@id=\'demo_native\']"));
		WebElement defaultlabel=driver.findElement(By.id("demo_label-dropdown"));
		WebElement customlabel=driver.findElement(By.id("demo_custom_1-dropdown"));
		
		selectOptionDropdown(native1,"Four");
		selectOptionDropdown(defaultlabel,"Arizona");
		selectOptionDropdown(customlabel,"Option Two");
		Thread.sleep(4000);
		driver.close();
	}
	public static void selectOptionDropdown(WebElement ele,String value)
	{	
		Select drp=new Select(ele);

		List <WebElement>elements= drp.getOptions();
		for(WebElement finalelement:elements)
		{ 
			if(finalelement.getText().equals(value))
			{
				finalelement.click();
				break;
			}
		}
	}
	
}
