package testCases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import base.Baseclass;
import constant.Constant;
import elementRepository.Createworkerpage;
import elementRepository.Loginpage;
import elementRepository.Workerpage;
import io.opentelemetry.context.Context;
import utilities.ExcelRead;

public class Createworkerpagetestcase extends Baseclass {
  @Test(groups="High")
  public void verifywhetherdatefieldworksfineornot() throws IOException
  {
	  Loginpage lp=new Loginpage(driver);
	  lp.enterUsername(ExcelRead.readStringDatafromExcel(1, 0));
	  lp.enterPassword(ExcelRead.readStringDatafromExcel(1, 1));
	  lp.clickLogin();
	  Workerpage wp=new Workerpage(driver);
	  wp.navigateWorker();
	  wp.createworkerpage();
	  Createworkerpage cwp=new Createworkerpage(driver);
	  cwp.enterdate();
	  cwp.navigatetophonefield();
	  cwp.navigatetoEngageStatusdropdown();
	  String actual=cwp.navigatetoEngageStatusdropdown();
	  String expected="Paye";
	  Assert.assertEquals(actual,expected,Constant.dropDown);
  }
  @Test(groups="Critical")
  public void verifyemailidwithfaker() throws IOException
  {
	  Loginpage lp=new Loginpage(driver);
	  lp.enterUsername(ExcelRead.readStringDatafromExcel(1, 0));
	  lp.enterPassword(ExcelRead.readStringDatafromExcel(1, 1));
	  lp.clickLogin();
	  Workerpage wp=new Workerpage(driver);
	  wp.navigateWorker();
	  wp.createworkerpage();
	  Createworkerpage cwp=new Createworkerpage(driver);
	  String n=cwp.emailaddress();
	  System.out.println(n);

	  
	  
  }
}
