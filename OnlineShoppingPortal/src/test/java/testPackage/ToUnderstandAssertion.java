package testPackage;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ToUnderstandAssertion {

	@Test
	public void assertion()
	{
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://demowebshop.tricentis.com/");
		
		String actualWelcomePageTitle = "Demo Web Shop";
		String actualLoginPageTitle= "Demo Web Shop. Login";
		
		Assert.assertEquals(actualWelcomePageTitle, driver.getTitle(), "Welcome Page is not displayed");
		
		driver.findElement(By.linkText("Log in")).click();
		Assert.assertEquals(actualLoginPageTitle, driver.getTitle(), "Login Page is not displayed");
		
		WebElement emailTB = driver.findElement(By.id("Email"));
		Assert.assertEquals(true, emailTB.isDisplayed(), "Email Textbox is not displayed");
		emailTB.sendKeys("mahibhai07@gmail.com");
		
		WebElement passwordTB = driver.findElement(By.id("Password"));
		Assert.assertEquals(true, passwordTB.isDisplayed(), "Password Textbox is not displayed");
		passwordTB.sendKeys("mahibhai07");
		
		WebElement loginButton = driver.findElement(By.xpath("//input[@value='Log in']"));
		Assert.assertEquals(true, loginButton.isDisplayed(), "Login Button is not Visible");
		loginButton.click();
		
		
		
	}
}
