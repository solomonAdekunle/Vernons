package Vernons_Core_SUITE;

import java.io.IOException;
import java.util.Hashtable;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import Util.Constant;
import Util.TestDataProvider;
import Base.TestBase;

public class RegistrationTest extends TestBase {
	@BeforeTest
	public void initLogs() {
		initLogs(this.getClass());
	}

	@Test(dataProviderClass = TestDataProvider.class, dataProvider = "Vernons_Core_SUITEDataProvider")
	public void RegistrationTest(Hashtable<String, String> table) throws InterruptedException, IOException {
		// System.out.println(" testing the system");
		String consValue = Constant.First_Suite;
		String tableValue = table.get(Constant.RUNMODE_COL);
		validateRunmodes("RegistrationTest", consValue, tableValue);
		openBrowser(table.get(Constant.BROWSER_COL));
		// navigate("testsiteURL");
		dr.get(Config.getProperty("testsiteName"));
		dr.manage().window().maximize();
		getObject("hp_casinoJoinNow").click();
		String Username = table.get(Constant.REGUSERNAME_COL).toString();
		System.out.println(Username);
		if (Username.equals("{generator}")) {
			Username = generateStringWithAllobedSplChars(20, "");
		}
		getObject("reg_username").sendKeys(Username);
		getObject("reg_password").sendKeys(table.get(Constant.REGPASSWORD_COL));
		getObject("reg_ConfPassword").sendKeys(table.get(Constant.CONFPASSWORD_COL));
		getObject("reg_Email").sendKeys(table.get(Constant.EMAIL_COL));
		getObject("reg_Title").sendKeys(table.get(Constant.TITLE_COL));
		getObject("reg_Fname").sendKeys(table.get(Constant.FIRSTNAME_COL));
		getObject("reg_Lname").sendKeys(table.get(Constant.LASTNAME_COL));
		getObject("reg_day").sendKeys(table.get(Constant.DAY_COL));
		getObject("reg_month").sendKeys(table.get(Constant.MONTH_COL));
		getObject("reg_year").sendKeys(table.get(Constant.YEAR_COL));
		WebElement EnterYourAddressManually=getObject("reg_enteraddressmanually");
		WebDriverWait wat = new WebDriverWait(dr,10);
		wat.until(ExpectedConditions.presenceOfElementLocated(By.xpath(OR.getProperty("reg_enteraddressmanually"))));
		((JavascriptExecutor) dr).executeScript("arguments[0].click();", EnterYourAddressManually);
		//getObject("reg_enteraddressmanually").click();
		Thread.sleep(500);
		getObject("reg_addresss").sendKeys(table.get(Constant.ADDRESS_COL));
		getObject("reg_city").sendKeys(table.get(Constant.CITY_COL));
		getObject("reg_county").sendKeys(table.get(Constant.COUNTY_COL));
		getObject("reg_postcode").sendKeys(table.get(Constant.POSTCODE_COL));
		// getObject("reg_FindAddress").click();
		// getObject("reg_houseNum").sendKeys(address);
		getObject("reg_ContactNum").sendKeys(table.get(Constant.CONTACTNUMBER_COL));
		// getObject("reg_promoCode").sendKeys(PROMCODE);
		// getObject("reg_FirstBonus").click();
		WebElement RegisterTermAndConditionCheckbox=getObject("reg_T&C");
		wat.until(ExpectedConditions.presenceOfElementLocated(By.xpath(OR.getProperty("reg_enteraddressmanually"))));
		((JavascriptExecutor) dr).executeScript("arguments[0].click();", RegisterTermAndConditionCheckbox);
		//getObject("reg_T&C").click();
		WebElement RegisterSubmitButton=getObject("reg_submit");
		wat.until(ExpectedConditions.presenceOfElementLocated(By.xpath(OR.getProperty("reg_submit"))));
		((JavascriptExecutor) dr).executeScript("arguments[0].click();", RegisterSubmitButton);
		//getObject("reg_submit").click();
		// verifying if user has successfully register
		Thread.sleep(500l);
		boolean result = isElementPresent("regForm_ErrorMessage_Selector");
		String actualResult = null;
		if (result)
			actualResult = "FAILURE";
		else
			actualResult = "SUCCESS";
		Assert.assertEquals(table.get(Constant.EXPECTEDRESULT_COL), actualResult);
		if (table.get(Constant.EXPECTEDRESULT_COL).equals("SUCCESS")) {
			// verify if user can login with invalid data
			boolean result1 = isElementPresent("welcomeTitle_xpath");
			System.out.println("Looking for error");
			String actualResult1 = null;
			if (result1)
				actualResult1 = "SUCCESS";
			else
				actualResult1 = "FAILURE";
			System.out.printf(table.get(Constant.EXPECTEDRESULT_COL), actualResult1);
			Assert.assertEquals(table.get(Constant.EXPECTEDRESULT_COL), actualResult1);
			//
		}

	}

	@AfterMethod
	public void close() {
		 quit();

	}

}
