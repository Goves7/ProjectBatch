package genericPackage;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class WebDriverUtility {

	public void handleDropdownByVisibleText(WebElement dropdown, String visibleText)
	{
		Select sel = new Select(dropdown);
		sel.selectByVisibleText(visibleText);
	}
	
	public void handleDropdownByIndex(WebElement dropdown, int index)
	{
		Select sel = new Select(dropdown);
		sel.selectByIndex(index);
	}
	
	public void handleDropdownByValue(WebElement dropdown, String value)
	{
		Select sel = new Select(dropdown);
		sel.selectByValue(value);
	}
}
