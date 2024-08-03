package pomPackage;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class RegisterPage {

	// Declaration
	@FindBy(id="gender-male") private WebElement maleRadioButton;
	@FindBy(id="gender-female") private WebElement femaleRadioButton;
	@FindBy(id="FirstName")private WebElement firstNameTB;
	@FindBy(id="LastName") private WebElement lastNameTB;
	@FindBy(id="Email") private WebElement emailTB;
	@FindBy(id="Password") private WebElement passwordTB;
	@FindBy(id="ConfirmPassword") private WebElement confirmPasswordTB;
	@FindBy(id="register-button") private WebElement registerButton;
	
	// Initialization
	public RegisterPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}

	
	// Utilization
	public WebElement getMaleRadioButton() {
		return maleRadioButton;
	}

	public WebElement getFemaleRadioButton() {
		return femaleRadioButton;
	}

	public WebElement getFirstNameTB() {
		return firstNameTB;
	}

	public WebElement getLastNameTB() {
		return lastNameTB;
	}

	public WebElement getEmailTB() {
		return emailTB;
	}

	public WebElement getPasswordTB() {
		return passwordTB;
	}

	public WebElement getConfirmPasswordTB() {
		return confirmPasswordTB;
	}

	public WebElement getRegisterButton() {
		return registerButton;
	}
	
	// Operational Methods
	public void registerUser(String fn, String ln, String email, String pwd)
	{
		maleRadioButton.click();
		firstNameTB.clear();
		firstNameTB.sendKeys(fn);
		
		lastNameTB.clear();
		lastNameTB.sendKeys(ln);
		
		emailTB.clear();
		emailTB.sendKeys(email);
		
		passwordTB.clear();
		passwordTB.sendKeys(pwd);
		
		confirmPasswordTB.clear();
		confirmPasswordTB.sendKeys(pwd);
		
		registerButton.click();
	}
}
