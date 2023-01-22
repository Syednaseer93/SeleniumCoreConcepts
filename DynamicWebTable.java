package DropDownConcept.DropDownConcept;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DynamicWebTable {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		driver.get("https://demo.opencart.com/admin/index.php");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		driver.findElement(By.xpath("//*[@id=\"input-username\"]\r\n"
				+ "")).sendKeys("demo");
		driver.findElement(By.xpath("//*[@id=\"input-password\"]\r\n"
				+ "")).sendKeys("demo");
		driver.findElement(By.xpath("/html/body/div[1]/div[2]/div/div/div/div/div[2]/form/div[3]/button\r\n"
				+ "")).click();
		driver.findElement(By.xpath("/html/body/div[1]/div[2]/div[3]/div/div/div[1]/button\r\n"
				+ "")).click();
		driver.findElement(By.xpath("/html/body/div[1]/nav/ul/li[5]/a\r\n"
				+ "")).click();
		driver.findElement(By.xpath("/html/body/div[1]/nav/ul/li[5]/ul/li[1]/a\r\n"
				+ "")).click();
		String text=driver.findElement(By.xpath("//div[@class='col-sm-6 text-end']")).getText();
		text.indexOf("(");
		text.indexOf("P");
		String total_pages=text.substring(text.indexOf("(")+1,text.indexOf("P")-1);
		System.out.println(total_pages);
		int totalPages=Integer.parseInt(total_pages);

		for(int p=1;p<=totalPages;p++)
		{
			WebElement  activePage=driver.findElement(By.xpath("//span[@class='page-link']"));
			System.out.println(activePage.getText());
			activePage.click();

			int totalRows=driver.findElements(By.xpath("//tbody//tr")).size();
			System.out.println("Total no of rows in this page are"+totalRows);
			String pageno=Integer.toString(p+1);
			WebElement ele=driver.findElement(By.xpath("//text()='"+pageno+"']"));

			JavascriptExecutor js=(JavascriptExecutor)driver;
			js.executeScript("arguments[0].click();", ele);



		}




	}

}
