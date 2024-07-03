package elementRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.github.javafaker.Faker;

import utilities.Generalutilities;

public class Createworkerpage 
{
	Generalutilities gu = new Generalutilities();
	Faker fake=new Faker();


	public Createworkerpage(WebDriver driver) 
	{
		this.driver = driver;
		PageFactory.initElements(driver, this);

	}

	WebDriver driver;
	
	@FindBy(id="worker-phone")
	WebElement phone;
	
	@FindBy(id="worker-dob")
	WebElement date;
	
	@FindBy(id="worker-engage_status")
	WebElement engagestatus;
	
	@FindBy(id="worker-email")
	WebElement email;

	public void navigatetophonefield()
	{
		phone.sendKeys("9874562589");
	}
	
	public void enterdate()
	{
		date.sendKeys("03-07-2024");
	}
	
	public String navigatetoEngageStatusdropdown()
	{
		return gu.isDropdownvalueselected(engagestatus,"paye");
	}
	
	public String emailaddress()
	{
		return fake.internet().emailAddress("email");	
		
	}
	
	
	
}
