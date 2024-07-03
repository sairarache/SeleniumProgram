package testCases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import base.Baseclass;
import constant.Constant;
import elementRepository.Clientpage;
import elementRepository.Createclientpage;
import elementRepository.Loginpage;
import utilities.ExcelRead;

public class Createclientpagetestcase extends Baseclass {
  @Test
  public void verifythedropdownfieldinCreateclientpageworksornot() throws IOException
  {
	  Loginpage lp=new Loginpage(driver);
	  lp.enterUsername(ExcelRead.readStringDatafromExcel(1, 0));
	  lp.enterPassword(ExcelRead.readStringDatafromExcel(1, 1));
	  lp.clickLogin();
	  Clientpage cp=new Clientpage(driver);
	  cp.navigatetoClientpage();
	  cp.navigatetoCreateClientpage();
	  Createclientpage ccp=new Createclientpage(driver);
	  ccp.navigatetodivisionfield();
	  String actual=ccp.navigatetodivisionfield();
	  String expected ="NewAlpha";
	  Assert.assertEquals(actual,expected,Constant.dropDown);
	  System.out.println(expected);	  
  }
  @Test
  public void verifythebranchdropdownworksfineornot() throws IOException
  {
	  Loginpage lp=new Loginpage(driver);
	  lp.enterUsername(ExcelRead.readStringDatafromExcel(1, 0));
	  lp.enterPassword(ExcelRead.readStringDatafromExcel(1, 1));
	  lp.clickLogin();
	  Clientpage cp=new Clientpage(driver);
	  cp.navigatetoClientpage();
	  cp.navigatetoCreateClientpage();
	  Createclientpage ccp=new Createclientpage(driver);
	  ccp.navigatetobranchfield();
	  String actual=ccp.navigatetobranchfield();
	  String expected="Alpha_new";
	  Assert.assertEquals(actual,expected,Constant.dropDown);
	  
  }
  
  @Test(groups="High")
  public void IscheckboxUkpublicsectorisselectedornot() throws IOException
  {
	  Loginpage lp=new Loginpage(driver);
	  lp.enterUsername(ExcelRead.readStringDatafromExcel(1, 0));
	  lp.enterPassword(ExcelRead.readStringDatafromExcel(1, 1));
	  lp.clickLogin();
	  Clientpage cp=new Clientpage(driver);
	  cp.navigatetoClientpage();
	  cp.navigatetoCreateClientpage();
	  Createclientpage ccp=new Createclientpage(driver);
	 // ccp.publicsectorcheckbox();
	  ccp.clickrequiroprocheckbox();
	  ccp.checkboxRequirepoinCreateClientsubpage();
	  boolean actual=ccp.checkboxRequirepoinCreateClientsubpage();
	  boolean expected=true;
	  Assert.assertEquals(actual,expected,Constant.checkbox);
  }
}
