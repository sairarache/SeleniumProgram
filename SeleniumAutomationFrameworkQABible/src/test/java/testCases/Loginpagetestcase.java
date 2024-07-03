package testCases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import base.Baseclass;
import elementRepository.Dashboardpage;
import elementRepository.Loginpage;
import utilities.ExcelRead;

public class Loginpagetestcase extends Baseclass
{ 

@Test(groups="High")
  public void verifyloginfunctionwithValidUsers() throws IOException 
  {   
	  Loginpage lp=new Loginpage(driver);
	  lp.enterUsername(ExcelRead.readStringDatafromExcel(1, 0));
	  lp.enterPassword(ExcelRead.readStringDatafromExcel(1, 1));
	  lp.clickLogin();
	  
	  Dashboardpage dp=new Dashboardpage(driver);
	  dp.verifydashboardUsername();
	  String actual=dp.verifydashboardUsername();
	  String expected="CAROL THOMAS";
	  Assert.assertEquals(actual,expected,"username & password is incorrect");
  }
  
  @Test(groups="Critical")
  public void verifytheLogoutFunctionalityworksfineornot() throws IOException 
  {
	  Loginpage lp=new Loginpage(driver);
	  lp.enterUsername(ExcelRead.readStringDatafromExcel(1, 0));
	  lp.enterPassword(ExcelRead.readStringDatafromExcel(1, 1));
	  lp.clickLogin();
	  lp.navigatetoUserProfile();
	  lp.clickOnLogoutbutton();
	  lp.navigatetologoutpage();
	  String actual=lp.navigatetologoutpage();
	  String expected="LOGIN";
	  System.out.println(actual);
      Assert.assertEquals(actual, expected,"login is not working as expected");
      boolean usernamepresentactual=lp.isUsernamepresent();
      boolean usernamepresentexpected=true;
      Assert.assertEquals(usernamepresentactual,usernamepresentexpected,"Logout feature is not working fine");
  }
  
}
