package pomPackage;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import genericPackage.BaseTest;

public class ElectronicsPage {

	@FindBy(partialLinkText = "Cell phones") private WebElement cellPhonesLink;
	@FindBy(partialLinkText = "Smartphone") private WebElement smartPhoneLink;
	@FindBy(xpath="//a[text()='Smartphone']/../..//input[@value='Add to cart']") private WebElement smartPhoneAddToCartButton;
	@FindBy(xpath="//p[text()='The product has been added to your ']/descendant :: a[text()='shopping cart']") private WebElement productAddedMessage;
	
	//
	public ElectronicsPage(WebDriver driver)
	{
	PageFactory.initElements(driver, this);	
	}

	public WebElement getCellPhonesLink() {
		return cellPhonesLink;
	}

	public WebElement getSmartPhoneLink() {
		return smartPhoneLink;
	}

	public WebElement getSmartPhoneAddToCartButton() {
		return smartPhoneAddToCartButton;
	}

	public WebElement getProductAddedMessage() {
		return productAddedMessage;
	}
	
	public void addProductToCart()
	{
		cellPhonesLink.click();
		smartPhoneAddToCartButton.click();
		
		productAddedMessage.isDisplayed();	
		
	}
	
}
