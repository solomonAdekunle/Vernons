package Vernons_Core_SUITE;

import java.io.IOException;
import java.util.Hashtable;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import Base.TestBase;
import Util.Constant;
import Util.TestDataProvider;

public class ForgottenDetailsTest extends TestBase {

	@BeforeTest
	public void initLogs() {
		initLogs(this.getClass());

	}

	@Test(dataProviderClass = TestDataProvider.class, dataProvider = "Vernons_Core_SUITEDataProvider")
	public void ForgottenDetailstest(Hashtable<String, String> table) throws IOException, InterruptedException {
		test = extent.startTest("ForgottenDetailsTest");
		openBrowser(table.get(Constant.BROWSER_COL));
		dr.get(Config.getProperty("testsiteName"));
		if ((dr.getTitle()).equals("Vernons")) {
			System.out.println(dr.getTitle());
		} else {
			System.out.println(false);
		}
		// getObject("casino").click();
		getObject("forgotten_Details").click();
		// verify that the page display Forgotten details as title page
		dr.getTitle();
		System.out.println(dr.getTitle());
		if ((dr.getTitle()).equals("Forgotten Details | Vernons.com")) {
			System.out.println(dr.getTitle());
		} else {
			System.out.println(false);
		}
		getObject("fd_username").sendKeys(table.get(Constant.USERNAME_COL));

		getObject("fd_email").sendKeys(table.get(Constant.EMAIL_COL));

		getObject("fd_day").sendKeys(table.get(Constant.DAY_COL));

		getObject("fd_month").sendKeys(table.get(Constant.MONTH_COL));
		getObject("fd_year").sendKeys(table.get(Constant.YEAR_COL));
		getObject("fd_submitButton").click();
		Thread.sleep(1000L);
		if (table.get(Constant.Result).equals("Correct")) {
			getObject("resetPassword_Newpassword").sendKeys(table.get(Constant.NEWPASSWORD_COL));
			getObject("resetPassword_Confpassword").sendKeys(table.get(Constant.CONFIRMPASSWORD_COL));
			getObject("resetpassword_Submit").click();
			WebElement Element = getObject("title_DetailsUpdated");
			if (Element.isDisplayed())
				System.out.println(true);
			else
				System.out.println(false);
			Assert.assertTrue(Element.isDisplayed());

		}
	}

	@Test(enabled = false)
	public void customersuportLinkTest() throws InterruptedException {
		dr.get(Config.getProperty("testsiteName"));
		dr.manage().window().maximize();
		getObject("forgotten_Details").click();
		getObject("fd_customersuport").click();
		Thread.sleep(2000L);
		// verify that user can navigate to Contact-us page if user click on
		// Customer Support link
		String title1 = dr.findElement(By.xpath("//*[@id='content-header']/h1")).getText();
		if (title1.equals("RESET PASSWORD"))
			System.out.println(title1);
		else
			System.out.println("Page Not Found");

	}

	@AfterMethod
	public void close() {
		quit();

	}
}
