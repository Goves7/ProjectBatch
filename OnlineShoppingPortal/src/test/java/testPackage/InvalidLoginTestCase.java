package testPackage;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import genericPackage.BaseTest;
import genericPackage.CustomListener;
import genericPackage.Flib;
import pomPackage.LoginPage;
import pomPackage.WelcomePage;
@Listeners(CustomListener.class)
public class InvalidLoginTestCase extends BaseTest {

	@Test(groups = "Functionality Test")
	public void invalidLoginTC() throws EncryptedDocumentException, IOException, InterruptedException
	{
		WelcomePage wp = new WelcomePage(driver);
		wp.getLoginLink().click();
		
		LoginPage lp = new LoginPage(driver);
		
		Flib flib = new Flib();
		int rc = flib.getLastRowCount(EXCEL_PATH, "invalidcreds");
		
		for(int i=1; i<=rc;i++)
		{
			String email = flib.readExcelData(EXCEL_PATH, "invalidcreds", i, 0);
			String password = flib.readExcelData(EXCEL_PATH, "invalidcreds", i, 1);
			
			lp.validLogin(email, password);
			Thread.sleep(1000);
			lp.getEmailTB().clear();
		}
	}
}
