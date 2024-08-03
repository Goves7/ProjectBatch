package pomPackage;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.asserts.SoftAssert;


public class LoginPage  {

	// Declaration
	
	@FindBy(id="Email") private WebElement emailTB;
	@FindBy(id="Password") private WebElement passwordTB;
	@FindBy(id="RememberMe") private WebElement rememberMeCheckbox;
	@FindBy(linkText = "Forgot password?") private WebElement forgotPasswordLink;
	@FindBy(xpath = "//input[@value='Log in']") private WebElement loginButton;
	
	// Initialization
	public LoginPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}

	
	// Utilization
	public WebElement getEmailTB() {
		return emailTB;
	}

	public WebElement getPasswordTB() {
		return passwordTB;
	}

	public WebElement getRememberMeCheckbox() {
		return rememberMeCheckbox;
	}

	public WebElement getForgotPasswordLink() {
		return forgotPasswordLink;
	}

	public WebElement getLoginButton() {
		return loginButton;
	}
	

	//Operational Methods
	public void validLogin(String email, String password)
	{
		SoftAssert sa=new SoftAssert();
		sa.assertEquals(true, emailTB.isDisplayed(), "Email Textbox is not displayed");
		emailTB.clear();
		emailTB.sendKeys(email);
		
		sa.assertEquals(true, passwordTB.isDisplayed(), "Password Textbox is not displayed");
		passwordTB.clear();
		passwordTB.sendKeys(password);
		
		sa.assertEquals(true, loginButton.isDisplayed(), "Login Button is not displayed");
		loginButton.click();
		
		sa.assertAll();
	}
	
	
}
