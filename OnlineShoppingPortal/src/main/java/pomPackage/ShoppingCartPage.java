package pomPackage;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ShoppingCartPage {

	// Declaration
	@FindBy(xpath="(//a[text()='Smartphone'])[2]") private WebElement smartPhoneCartElement;
	@FindBy(xpath ="(//a[text()='Smartphone'])[2]/../..//input[@name='removefromcart']") private WebElement smartphoneRemoveCheckbox;
	@FindBy(name="updatecart") private WebElement updateCartButton;
	@FindBy(name="continueshopping")private WebElement continueShoppingButton;
	@FindBy(name="termsofservice") private WebElement termsOfServiceCheckbox;
	@FindBy(id="checkout") private WebElement checkoutButton;
	
	//Initialization
	public ShoppingCartPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}

	
	//Utilization
	public WebElement getSmartPhoneCartElement() {
		return smartPhoneCartElement;
	}

	public WebElement getSmartphoneRemoveCheckbox() {
		return smartphoneRemoveCheckbox;
	}

	public WebElement getUpdateCartButton() {
		return updateCartButton;
	}

	public WebElement getContinueShoppingButton() {
		return continueShoppingButton;
	}

	public WebElement getTermsOfServiceCheckbox() {
		return termsOfServiceCheckbox;
	}

	public WebElement getCheckoutButton() {
		return checkoutButton;
	}
	
	
	
}
