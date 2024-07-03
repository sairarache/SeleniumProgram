package elementRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Wait;

import utilities.Generalutilities;

public class Createclientpage 
{
	Generalutilities gu = new Generalutilities();


	public Createclientpage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);

	}
	WebDriver driver;
	
	@FindBy(id="client-division_id")
	WebElement division;
	
	@FindBy(id="client-branch_id")
	WebElement branch;
	
	@FindBy(xpath="//input[@id='client-direct_client']")
	WebElement directclient;
	
	@FindBy(id = "client-require_po")
	WebElement requirepro;
	
	public String navigatetodivisionfield()
	{
		return gu.isDropdownvalueselected(division,"1");
		
	}
	public String navigatetobranchfield()
	{
		return gu.isDropdownvalueselected(branch,"1");
		
	}
	public void clickrequiroprocheckbox()
    {
    	requirepro.click();
    }
	public boolean checkboxRequirepoinCreateClientsubpage() 
	{
	    gu.pageScrolldownaction(requirepro, driver);
		return gu.isCheckboxRadiobuttonselected(requirepro);
		

	}
	
	
}
