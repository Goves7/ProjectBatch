package testPackage;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import genericPackage.BaseTest;
import genericPackage.CustomListener;
import genericPackage.Flib;
import pomPackage.RegisterPage;
import pomPackage.WelcomePage;
@Listeners(CustomListener.class)
public class RegisterTestCase extends BaseTest{

    @Test
	public void registerTC() throws EncryptedDocumentException, IOException
	{
		
		WelcomePage wp = new WelcomePage(driver);
		wp.getRegisterLink().click();
		
		RegisterPage rp = new RegisterPage(driver);
		
		Flib flib = new Flib();
		String fn = flib.readExcelData(EXCEL_PATH, "registercreds", 1, 0);
		String ln = flib.readExcelData(EXCEL_PATH, "registercreds", 1, 1);
		String email = flib.readExcelData(EXCEL_PATH, "registercreds", 1, 2);
		String password = flib.readExcelData(EXCEL_PATH, "registercreds", 1, 3);
		
		rp.registerUser(fn, ln, email, password);
	}
}
