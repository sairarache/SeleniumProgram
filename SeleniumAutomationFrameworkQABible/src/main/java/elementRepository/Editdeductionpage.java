package elementRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.Generalutilities;
import utilities.Wait;

public class Editdeductionpage {
	Generalutilities gu = new Generalutilities();
	Wait wt=new Wait();

	public Editdeductionpage(WebDriver driver) 
	{
		this.driver = driver;
		PageFactory.initElements(driver, this);

	}
	WebDriver driver;
    
	@FindBy(xpath="//select[@id='deduction-worker_id']")
	WebElement workerid;
	
	@FindBy(id="deduction-type")
	WebElement deductiontype;
	
	@FindBy(id="deduction-amount")
	WebElement deductionamount;
	
	@FindBy(id="deduction-effective_from")
	WebElement date;
	
	@FindBy(xpath="//button[@type='submit']")
	WebElement save;
	
	@FindBy(xpath="//a[@href='/payrollapp/deduction/update?id=5978']")
	WebElement edit;
	
	public void editbutton()
	{   gu.pageScrolldownaction(edit, driver);
		edit.click();
	}
    public String navigatetoworkerid()
    {
      return gu.isDropdownvalueselected(workerid,"3");
    }
    public String navigatetodeductiontypefield()
    {
    	return gu.isDropdownvalueselected(deductiontype,"Client Advance");
    }
    public void navigatetoamountfield()
    {
    	deductionamount.sendKeys("2000");
    }
	public void navigatetodatefield()
	{
		date.sendKeys("01-02-2024");
	}
	public void clickbutton()
	{   
		save.click();
	}
	
	
		
 }

