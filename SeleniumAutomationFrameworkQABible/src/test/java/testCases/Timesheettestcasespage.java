package testCases;

import java.awt.AWTException;
import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import base.Baseclass;
import constant.Constant;
import elementRepository.Edittimesheetpage;
import elementRepository.Loginpage;
import elementRepository.Timesheetpage;
import utilities.ExcelRead;

public class Timesheettestcasespage extends Baseclass {
	@Test
	public void verifythetooltipvalueofTimesheetPage() throws IOException {
		Loginpage lp = new Loginpage(driver);
		lp.enterUsername(ExcelRead.readStringDatafromExcel(1, 0));
		lp.enterPassword(ExcelRead.readStringDatafromExcel(1, 1));
		lp.clickLogin();
		Timesheetpage tp = new Timesheetpage(driver);
		tp.navigatetoTimesheetpage();
		tp.verifytheTooltipValue();
		String actual = tp.verifytheTooltipValue();
		String expected = "View";
		Assert.assertEquals(actual, expected, "Tooltip value is different");
		System.out.println(actual);

	}

	@Test
	public void verifythedetailsofuserinTimesheetPage() throws IOException {
		Loginpage lp = new Loginpage(driver);
		lp.enterUsername(ExcelRead.readStringDatafromExcel(1, 0));
		lp.enterPassword(ExcelRead.readStringDatafromExcel(1, 1));
		lp.clickLogin();
		Timesheetpage tp = new Timesheetpage(driver);
		tp.navigatetoTimesheetpage();
		tp.verifytheUserNameofHtmlTable();
		String actual = tp.verifytheUserNameofHtmlTable();
		String expected = "Sarah Mathew";
		System.out.println(actual);
		Assert.assertEquals(actual, expected, "username is different");
	}

	@Test(groups="Critical")
	public void verifytheDynamicvalueofUser() throws IOException {
		Loginpage lp = new Loginpage(driver);
		lp.enterUsername(ExcelRead.readStringDatafromExcel(1, 0));
		lp.enterPassword(ExcelRead.readStringDatafromExcel(1, 1));
		lp.clickLogin();
		Timesheetpage tp = new Timesheetpage(driver);
		tp.navigatetoTimesheetpage();
		tp.verifytheDynamictableValue();
		String actual = tp.verifytheDynamictableValue();
		String expected = "//table[@class='table table-striped table-bordered']//tbody//tr[17]//td[2]";
		Assert.assertEquals(actual, expected, "Htm value is different");
		System.out.println(actual);

	}

	@Test
	public void verifyEditpageDropdownvalues() throws IOException {
		Loginpage lp = new Loginpage(driver);
		lp.enterUsername(ExcelRead.readStringDatafromExcel(1, 0));
		lp.enterPassword(ExcelRead.readStringDatafromExcel(1, 1));
		lp.clickLogin();
		Timesheetpage tp = new Timesheetpage(driver);
		tp.navigatetoTimesheetpage();
		tp.navigatetoEditPage();
		Edittimesheetpage et = new Edittimesheetpage(driver);
		et.DropdownValueofeditpage();
		String actual = et.DropdownValueofeditpage();
		String expected = "Senior Carer";
		Assert.assertEquals(actual, expected, "Dropdown value is different");

	}

	@Test
	public void verifytheDirectclientCheckboxisSelected() throws IOException {
		Loginpage lp = new Loginpage(driver);
		lp.enterUsername(ExcelRead.readStringDatafromExcel(1, 0));
		lp.enterPassword(ExcelRead.readStringDatafromExcel(1, 1));
		lp.clickLogin();
		Timesheetpage tp = new Timesheetpage(driver);
		tp.navigatetoTimesheetpage();
		tp.navigatetoEditPage();
		Edittimesheetpage et = new Edittimesheetpage(driver);
		et.clickdirectclientcheckbox();
		et.DirectClientcheckboxisSelected();
		boolean actual = et.DirectClientcheckboxisSelected();
		boolean expected = true;
		Assert.assertEquals(actual, expected);
		System.out.println(actual);

	}
	@Test(groups="Critical")
	public void verifyuploadfiefunctionalityofCreateTimesheetPage() throws AWTException, IOException
	{
		Loginpage lp = new Loginpage(driver);
		lp.enterUsername(ExcelRead.readStringDatafromExcel(1, 0));
		lp.enterPassword(ExcelRead.readStringDatafromExcel(1, 1));
		lp.clickLogin();
		Timesheetpage tp = new Timesheetpage(driver);
		tp.navigatetoTimesheetpage();
		tp.navigatetoCreatetimesheetPage();
		tp.uploadimageinCreateBrowserPage();
        tp.enterDropdownvalueforemployeeinTimesheetpage();
        String actual=tp.enterDropdownvalueforemployeeinTimesheetpage();
      	String expected="Paye";
        Assert.assertEquals(actual,expected,Constant.errorMessage);
        System.out.println(actual);
		
	}
	@Test(groups="High")
	 public void verifythegeneratepayslipfunctionalityworksnotnot() throws IOException, InterruptedException
	 {
		 Loginpage lp = new Loginpage(driver);
			lp.enterUsername(ExcelRead.readStringDatafromExcel(1, 0));
			lp.enterPassword(ExcelRead.readStringDatafromExcel(1, 1));
			lp.clickLogin();
			Timesheetpage tp = new Timesheetpage(driver);
			tp.navigatetoTimesheetpage();
			tp.generatepayslipbutton();
			String expected="Are you sure you want to generate payslip?";
			String actual=tp.gettextofalertBox();
			Assert.assertEquals(expected,actual,Constant.getText);
			System.out.println(actual);
	 }
	@Test(groups="High")
	public void verifythesecondalertbox() throws IOException, InterruptedException
	{
		    Loginpage lp = new Loginpage(driver);
			lp.enterUsername(ExcelRead.readStringDatafromExcel(1, 0));
			lp.enterPassword(ExcelRead.readStringDatafromExcel(1, 1));
			lp.clickLogin();
			Timesheetpage tp = new Timesheetpage(driver);
			tp.navigatetoTimesheetpage();
			tp.generatepayslipbutton();
			tp.gettextofalertBox();
			tp.secondalertbox();
			String actual=tp.secondalertbox();
			String expected="Payslip generated!!!";
			Assert.assertEquals(expected,actual,Constant.getText);
			tp.acceptthealertbox();
			System.out.println(actual);
		
	}
	
}
