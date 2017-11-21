package Vernons_Core_SUITE;

import java.io.File;
import java.io.IOException;
import java.util.Hashtable;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import Base.TestBase;
import Util.Constant;
import Util.TestDataProvider;
import Util.TestUtil;

public class LoginTest extends TestBase {

	@BeforeTest
	public void initLogs() {
		initLogs(this.getClass());

	}

	@Test(dataProviderClass = TestDataProvider.class, dataProvider = "Vernons_Core_SUITEDataProvider")
	public void Logintest(Hashtable<String, String> table) throws InterruptedException, IOException {
		validateRunmodes("LoginTest", Constant.First_Suite, table.get(Constant.RUNMODE_COL));
		System.out.println("testing my script");
		Thread.sleep(3000L);
		doLogin(table.get(Constant.BROWSER_COL), table.get(Constant.USERNAME_COL), table.get(Constant.PASSWORD_COL));
		Thread.sleep(5000L);
		System.out.println("Looking for error0");
		 //WebDriverWait wait = new WebDriverWait(dr,30);
		//wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("div#sb-player .login-error .error_message")));
		boolean result=isElementPresent("LoginErrorTextPopup_box_Selector");
		 String actualResult=null;
	    if(result)
			actualResult="FAILURE";
		else
			actualResult="SUCCESS";
	     Assert.assertEquals(table.get(Constant.EXPECTEDRESULT_COL), actualResult);
	    if(table.get(Constant.EXPECTEDRESULT_COL).equals("SUCCESS")){
		// verify if user can login with invalid data 
		boolean result1=isElementPresent("userInfo_Selector");
		 System.out.println("Looking for error");
		 String actualResult1=null;
	    if(result1)
			actualResult1="SUCCESS";
		  else 
			actualResult1="FAILURE";
	    System.out.printf(table.get(Constant.EXPECTEDRESULT_COL),actualResult1);
	 	Assert.assertEquals(table.get(Constant.EXPECTEDRESULT_COL),actualResult1);
//	 		
	 		}
	}

	// verifying The Login error Message Box

	@AfterMethod
	public void close() {
		quit();

	}

}
