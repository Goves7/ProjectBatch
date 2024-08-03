package testPackage;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import genericPackage.BaseTest;
import genericPackage.CustomListener;
import genericPackage.Flib;
import pomPackage.LoginPage;
import pomPackage.WelcomePage;
@Listeners(CustomListener.class)
public class ValidLoginTestCase extends BaseTest {

	@Test(groups = "Functionality Test")
	public void validLoginTC() throws EncryptedDocumentException, IOException
	{
		SoftAssert sa = new SoftAssert();
		String expectedWelcomePageTitle= "Demo Web Shop";
		sa.assertEquals(driver.getTitle(), expectedWelcomePageTitle, "Welcome Page is not displayed");
		
		WelcomePage wp = new WelcomePage(driver);
		sa.assertEquals(true, wp.getLoginLink().isDisplayed(), "Login link is not displayed");
		wp.getLoginLink().click();
		
		LoginPage lp = new LoginPage(driver);
		
		Flib flib = new Flib();
		String email = flib.readExcelData(EXCEL_PATH, "validcreds", 1, 0);
		String password = flib.readExcelData(EXCEL_PATH, "validcreds", 1, 1);
		
		lp.validLogin(email, password);
		sa.assertAll();
	}
	
}
