package testCases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import base.Baseclass;
import constant.Constant;
import elementRepository.Deductionpage;
import elementRepository.Editdeductionpage;
import elementRepository.Loginpage;
import utilities.ExcelRead;

public class Editdeductionpagetestcase extends Baseclass{
  @Test(groups="Critical")
  public void verifywhethertheeditDeductionpageisworkingornot() throws IOException
  {
	  Loginpage lp=new Loginpage(driver);
	  lp.enterUsername(ExcelRead.readStringDatafromExcel(1, 0));
	  lp.enterPassword(ExcelRead.readStringDatafromExcel(1, 1));
	  lp.clickLogin();
	  Deductionpage dp = new Deductionpage(driver);
	  dp.navigatetoDeductionpage();
	  Editdeductionpage ed=new Editdeductionpage(driver);
	  ed.editbutton();
	  ed.navigatetodeductiontypefield();
	  ed.clickbutton();
	  String actual=ed.navigatetodeductiontypefield();
	  String expected="Client Advance";
	  Assert.assertEquals(actual,expected,Constant.dropDown);
	  System.out.println(actual);
	  

  }
}
