package genericPackage;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Demo {

	public static void main(String[] args) throws InterruptedException  {
		
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.facebook.com/");
        Thread.sleep(1000);
		driver.manage().window().maximize();
		Thread.sleep(1000);
		WebDriverWait wb = new WebDriverWait(driver, Duration.ofSeconds(15));
		
		WebElement usn = driver.findElement(By.cssSelector("input[placeholder='Email address or phone number']"));	
		usn.sendKeys("qspiders");
		
		WebElement pwd = driver.findElement(By.xpath("//input[@aria-label='Password']"));
		pwd.sendKeys("jspiders");
		
		driver.close();
		
        
	}

}
