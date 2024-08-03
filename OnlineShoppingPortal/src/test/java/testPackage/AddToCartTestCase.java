package testPackage;


import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import genericPackage.BaseTest;
import genericPackage.CustomListener;
import pomPackage.ElectronicsPage;
import pomPackage.WelcomePage;

@Listeners(CustomListener.class)
public class AddToCartTestCase extends BaseTest {

	@Test (groups = "Integration Test")
	public void addToCartTC()
	{
		WelcomePage wp = new WelcomePage(driver);
		wp.getElectronicsLink().click();
		
		ElectronicsPage ep = new ElectronicsPage(driver);
		ep.addProductToCart();
	}
}
