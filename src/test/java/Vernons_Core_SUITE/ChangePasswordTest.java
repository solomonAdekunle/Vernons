package Vernons_Core_SUITE;

import java.io.IOException;
import java.util.Hashtable;

import org.apache.commons.configuration.ConfigurationException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import Util.Constant;
import Util.TestDataProvider;
import Util.TestUtil;
import Base.TestBase;

public class ChangePasswordTest extends TestBase {

	@BeforeTest
	public void initLogs() {
		initLogs(this.getClass());
	}

	@Test(enabled = false, dataProviderClass = TestDataProvider.class, dataProvider = "Vernons_Core_SUITEDataProvider")
	public void ChangePasswordtest(Hashtable<String, String> table)
			throws IOException, InterruptedException, ConfigurationException {
		validateRunmodes("ChangePasswordTest", Constant.First_Suite, table.get(Constant.RUNMODE_COL));
		openBrowser(table.get(Constant.BROWSER_COL));
		doDefaultLogin("Username");
		dr.manage().window().maximize();
		Thread.sleep(200L);
		WebDriverWait wait = new WebDriverWait(dr, 30);
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='user-account-link']")));
		String Xpath_menu = Constant.MyAccount;
		String Xpath_submenu = Constant.changepassword;
		WebElement menu = dr.findElement(By.xpath(Xpath_menu));
		WebElement submenu = dr.findElement(By.xpath(Xpath_submenu));
		Actions slip = new Actions(dr);
		slip.moveToElement(menu).build().perform();
		submenu.click();
		getObject("changePS_oldPs").sendKeys(table.get(Constant.OLDPASSWORD_COL));
		String NewPassWord = table.get(Constant.NEWPASSWORD_COL).toString();
		if (NewPassWord.equals("{generator}")) {
			NewPassWord = generateRandomAlphaNumeric(20, "");
		}
		getObject("changePS_NewPS").sendKeys(NewPassWord);
		if (table.get(Constant.CONFPASSWORD_COL).equals("{generator}")) {
			getObject("changePS_ConfPS").sendKeys(NewPassWord);
			System.out.println(NewPassWord);
		} else {
			getObject("changePS_ConfPS").sendKeys(table.get(Constant.CONFPASSWORD_COL));
		}
		getObject("changePS_submit").click();
		Thread.sleep(1000);
		if (table.get(Constant.EXPECTEDRESULT_COL).equals("SUCCESS")) {
			// verify that user has change his password successfully with valid
			// data.
			String title = dr.findElement(By.xpath("//*[@id='content-header']/h1")).getText();
			System.out.println(title);
			Assert.assertEquals(title, "YOUR PASSWORD HAS BEEN SUCCESSFULLY CHANGED");
			System.out.println("Password change successfully");
			// updating the default password.
			TestUtil.updateproperty("Password", NewPassWord);

			// Update the Old Passwords colum in the excel sheet
			TestUtil.writeXLSXFile(54, 3, NewPassWord);
			// Update the Password on the LoginTest on excel sheet
			TestUtil.writeXLSXFile(5, 4, NewPassWord);
		} else
		System.out.println("password change not succefull");
		Thread.sleep(1000L);
		getObject("hp_signout").click();
	}

	@AfterMethod
	public void close() {
		quit();

	}

}
