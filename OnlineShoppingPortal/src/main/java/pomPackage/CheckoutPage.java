package pomPackage;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import genericPackage.BaseTest;
import genericPackage.Flib;
import genericPackage.WebDriverUtility;

public class CheckoutPage extends BaseTest {

	// Declaration
	@FindBy(name="billing_address_id") private WebElement billingAddressDropdown;
	@FindBy(id="BillingNewAddress_CountryId") private WebElement countryDropdown;
	@FindBy(id="BillingNewAddress_City") private WebElement cityTB;
	@FindBy(id="BillingNewAddress_Address1") private WebElement address1TB;
	@FindBy(id="BillingNewAddress_Address2") private WebElement address2TB;
	@FindBy(id="BillingNewAddress_ZipPostalCode")private WebElement postalCodeTB;
	@FindBy(id="BillingNewAddress_PhoneNumber") private WebElement phoneNumberTB;
	@FindBy(id="BillingNewAddress_FaxNumber") private WebElement faxNumberTB;
	@FindBy(xpath = "//input[@onclick='Billing.save()']") private WebElement continueBilling;
	@FindBy(id="shipping-address-select") private WebElement shippingAddressDropdown;
	@FindBy(xpath = "//input[@onclick='Shipping.save()']")private WebElement continueShipping;
	@FindBy(xpath = "//input[@onclick='ShippingMethod.save()']")private WebElement continueShippingMethod;
	@FindBy(xpath = "//input[@onclick='PaymentMethod.save()']")private WebElement continuePaymentMethod;
	@FindBy(xpath = "//input[@onclick='PaymentInfo.save()']")private WebElement continuePaymentInfo;
	@FindBy(xpath = "//input[@onclick='ConfirmOrder.save()']") private WebElement continueConfirmOrder;
	@FindBy(xpath = "//input[@class='button-2 order-completed-continue-button']") private WebElement continueFinalConfirm;
	
	// Initialization
	public CheckoutPage(WebDriver driver)
	{
		PageFactory.initElements(driver,this);
	}

	// Utilization
	public WebElement getBillingAddressDropdown() {
		return billingAddressDropdown;
	}

	public WebElement getCountryDropdown() {
		return countryDropdown;
	}

	public WebElement getCityTB() {
		return cityTB;
	}

	public WebElement getAddress1TB() {
		return address1TB;
	}

	public WebElement getAddress2TB() {
		return address2TB;
	}

	public WebElement getPostalCodeTB() {
		return postalCodeTB;
	}

	public WebElement getPhoneNumberTB() {
		return phoneNumberTB;
	}

	public WebElement getFaxNumberTB() {
		return faxNumberTB;
	}

	public WebElement getContinueBilling() {
		return continueBilling;
	}

	public WebElement getShippingAddressDropdown() {
		return shippingAddressDropdown;
	}

	public WebElement getContinueShipping() {
		return continueShipping;
	}

	public WebElement getContinueShippingMethod() {
		return continueShippingMethod;
	}

	public WebElement getContinuePaymentMethod() {
		return continuePaymentMethod;
	}

	public WebElement getContinuePaymentInfo() {
		return continuePaymentInfo;
	}

	public WebElement getContinueConfirmOrder() {
		return continueConfirmOrder;
	}

	public WebElement getContinueFinalConfirm() {
		return continueFinalConfirm;
	}
	
	public void buyProductInCOD() throws EncryptedDocumentException, IOException, InterruptedException
	{
		WebDriverUtility wdu = new WebDriverUtility();
		Flib flib = new Flib();
		
		String address = flib.readExcelData(EXCEL_TEST_PATH, "buyproduct", 1, 0);
		wdu.handleDropdownByVisibleText(billingAddressDropdown, address);
		
		String country = flib.readExcelData(EXCEL_TEST_PATH, "buyproduct", 1, 1);
		wdu.handleDropdownByVisibleText(countryDropdown, country);
		
		String city = flib.readExcelData(EXCEL_TEST_PATH, "buyproduct", 1, 2);
		cityTB.sendKeys(city);
		
		String address1 = flib.readExcelData(EXCEL_TEST_PATH, "buyproduct", 1, 3);
		address1TB.sendKeys(address1);
		
		 String postalCode = flib.readNumericExcelData(EXCEL_TEST_PATH, "buyproduct", 1, 4);
		 postalCodeTB.sendKeys(postalCode);
		
		int data = flib.getRandomNumber();
		String contact = flib.readNumericExcelData(EXCEL_TEST_PATH, "buyproduct", 1, 5);
		String mobileNo = contact+data;
		phoneNumberTB.sendKeys(mobileNo);
		
		continueBilling.click();
		continueShipping.click();
		continueShippingMethod.click();
		continuePaymentMethod.click();
		continuePaymentInfo.click();
		continueConfirmOrder.click();
		Thread.sleep(2000);
		continueFinalConfirm.click();
		Thread.sleep(5000);
	}
	
	
}
