package testCases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import base.Baseclass;
import constant.Constant;
import elementRepository.Clientpage;
import elementRepository.Loginpage;
import utilities.ExcelRead;

public class Clientpagetestcases extends Baseclass {
	@Test
	public void verifythecheckboxRequirepoinCreateClientsubpage() throws IOException {
		Loginpage lp = new Loginpage(driver);
		lp.enterUsername(ExcelRead.readStringDatafromExcel(1, 0));
		lp.enterPassword(ExcelRead.readStringDatafromExcel(1, 1));
		
		lp.clickLogin();
		Clientpage cp = new Clientpage(driver);
		cp.navigatetoClientpage();
		cp.navigatetoCreateClientpage();
		cp.clickrequiroprocheckbox();
		cp.checkboxRequirepoinCreateClientsubpage();
		boolean expected =true;
        boolean actual = cp.checkboxRequirepoinCreateClientsubpage();
		System.out.println(actual);
		Assert.assertEquals(actual, expected, "Radiobutton is not selected");

	}

	@Test
	public void verifybackgroundcolourofSearchbuttoninclientpage() throws IOException {
		Loginpage lp = new Loginpage(driver);
		lp.enterUsername(ExcelRead.readStringDatafromExcel(1, 0));
		lp.enterPassword(ExcelRead.readStringDatafromExcel(1, 1));
		lp.clickLogin();
		Clientpage cp = new Clientpage(driver);
		cp.navigatetoClientpage();
		cp.backgroundcolourofSearchbuttoninclientpage();
		String actual = cp.backgroundcolourofSearchbuttoninclientpage();
		String expected = "rgba(51, 122, 183, 1)";
		System.out.println(actual);
		Assert.assertEquals(actual, expected);

	}

	@Test
	public void verifythetooltipvalueofEditiconinClientspage() throws IOException {
		Loginpage lp = new Loginpage(driver);
		lp.enterUsername(ExcelRead.readStringDatafromExcel(1, 0));
		lp.enterPassword(ExcelRead.readStringDatafromExcel(1, 1));
		lp.clickLogin();
		Clientpage cp = new Clientpage(driver);
		cp.navigatetoClientpage();
		cp.tooltipvalueofEditiconinClientspage();
		String actual = cp.tooltipvalueofEditiconinClientspage();
		String expected = "Update";
		System.out.println(actual);
		Assert.assertEquals(actual, expected, "tooltip value is not as expected");
	}
	@Test(groups="Critical")
	public void verifythesearchfunctioalityinclientpageworksornot() throws IOException
	{
		Loginpage lp = new Loginpage(driver);
		lp.enterUsername(ExcelRead.readStringDatafromExcel(1, 0));
		lp.enterPassword(ExcelRead.readStringDatafromExcel(1, 1));
		lp.clickLogin();
		Clientpage cp = new Clientpage(driver);
		cp.navigatetoClientpage();
		cp.clientnumberid();
		cp.navigatetosearchbutton();
		cp.customerdetails();
		String actual=cp.customerdetails();
		String expected="6 Bulstrode avenue, Hounslow";
		Assert.assertEquals(expected,actual,Constant.errorMessage);
		System.out.println(actual);
	}
}
