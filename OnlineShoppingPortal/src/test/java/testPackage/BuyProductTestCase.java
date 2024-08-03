package testPackage;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import genericPackage.BaseTest;
import genericPackage.CustomListener;
import genericPackage.Flib;
import pomPackage.CheckoutPage;
import pomPackage.ElectronicsPage;
import pomPackage.LoginPage;
import pomPackage.ShoppingCartPage;
import pomPackage.WelcomePage;
@Listeners(CustomListener.class)
public class BuyProductTestCase extends BaseTest {

	@Test (groups = "System Test")
	public void buyProductTC() throws EncryptedDocumentException, IOException, InterruptedException
	{
		WelcomePage wp = new WelcomePage(driver);
		wp.getLoginLink().click();
		
		LoginPage lp = new LoginPage(driver);
		Flib flib = new Flib();
		lp.validLogin(flib.readExcelData(EXCEL_PATH,"validcreds", 1, 0), flib.readExcelData(EXCEL_PATH, "validcreds", 1, 1));
		
		wp.getElectronicsLink().click();
		 ElectronicsPage ep = new ElectronicsPage(driver);
		 ep.addProductToCart();
		 
		 wp.getShoppingCartLink().click();
		 ShoppingCartPage sp = new ShoppingCartPage(driver);
		 sp.getTermsOfServiceCheckbox().click();
		 sp.getCheckoutButton().click();
		 
		 CheckoutPage cp = new CheckoutPage(driver);
		 cp.buyProductInCOD();
	}
}
