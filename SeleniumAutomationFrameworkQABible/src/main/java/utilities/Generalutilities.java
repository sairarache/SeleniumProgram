package utilities;



import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public  class Generalutilities {
	
	

	public String getElementText(WebElement element)

	// TODO Auto-generated method stub
	{
		String text = element.getText();
		return text;
	}
    
	public String getstylePropertyValue(WebElement element, String propertyType)

	{
		String propertyvalue = element.getCssValue(propertyType);
		return propertyvalue;
	}
    public void enterText(WebElement element, String text)
    {
        element.clear();
        element.sendKeys(text);
    }
	public boolean isCheckboxRadiobuttonselected(WebElement element) {
		element.click();
		boolean flag = element.isSelected();
		return flag;

	}

	public String getAttributevalue(WebElement element, String title) 
	{
		String tooltip = element.getAttribute("title");
		return tooltip;

	}
	

	public String isDropdownvalueselected(WebElement element, String value)
	{
		Select obj = new Select(element);
		obj.selectByValue(value);
		WebElement dropdown = obj.getFirstSelectedOption();
		String val = dropdown.getText();
		return val;
	}
	
	public String isDropdownvalueselectedtitle(WebElement element, String title)
	{
		Select obj = new Select(element);
		obj.selectByValue(title);
		WebElement dropdown = obj.getFirstSelectedOption();
		String val = dropdown.getText();
		return val;
	}
	
	public boolean ispresenceofelement(WebElement element)
	{
		boolean f=element.isDisplayed();
		return f;
		
	}
	public void pageScrolldownaction(WebElement element, WebDriver driver)
	{
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("window.scrollBy(0,2000)",element );       
	}
	
	public void fileuploadaction(WebElement element, WebDriver driver) throws AWTException 
	{
		   Actions action=new Actions(driver);
	       action.moveToElement(element).click().perform();
	       StringSelection ss = new StringSelection("C:\\Users\\USER\\Pictures\\Screenshots\\output 5.jpg");
	       Toolkit.getDefaultToolkit().getSystemClipboard().setContents(ss, null);
	       
	       Robot robot=new Robot();
	       robot.keyPress(KeyEvent.VK_CONTROL);
	       robot.delay(1000);
	       
	       robot.keyPress(KeyEvent.VK_V);
	       robot.delay(1000);
	       robot.keyRelease(KeyEvent.VK_CONTROL);
	       robot.delay(1000);

	       robot.keyRelease(KeyEvent.VK_V);
	       robot.delay(1000);
	       robot.keyPress(KeyEvent.VK_ENTER);
	       robot.keyRelease(KeyEvent.VK_ENTER);
	   }
	
	    public String gettextofalertbox(WebElement element,WebDriver driver)
	     {
		        
	    		String text=driver.switchTo().alert().getText();
	    		driver.switchTo().alert().accept();
	    		return text;
	    	
	     }
	    public String generatepayslip(WebElement element,WebDriver driver)
	    {  
	    	Wait wait=new Wait();
	    	wait.waittillAlertisPresent(driver);
	    	String m= driver.switchTo().alert().getText();
            return m;
		  
	    }
	    public void acceptalert(WebDriver driver)
	    {
		    driver.switchTo().alert().accept();

	    }
	
}
