package Suite2;

import java.io.FileNotFoundException;
import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import Util.Constant;
import Util.TestUtil;
import Base.TestBase;

public class MyAccount extends TestBase {
	@BeforeTest
	public void initLogs() throws FileNotFoundException {
		// initLogs(this.getClass());
		init();

	}

	@Test //(enabled=false)
	public void MYAccountMenutest() throws InterruptedException {
		openBrowser(Config.getProperty("browserType"));
		// login in with the following username and Password
		doDefaultLogin("Username");
		// Maximise the Window
		dr.manage().window().maximize();
		String Xpath_menu = Constant.MyAccount;
		String Xpath_submenu = Constant.myaccount;
		WebElement menu = dr.findElement(By.xpath(Xpath_menu));
		WebElement submenu = dr.findElement(By.xpath(Xpath_submenu));
		Actions move = new Actions(dr);
		move.moveToElement(menu).build().perform();
		submenu.click();
		Thread.sleep(5000L);
		// close the cashier frame
		dr.findElement(By.xpath("//*[@id='sb-nav-close']")).click();
		Thread.sleep(2000L);
		getObject("hp_signout").click();

	}

	@Test// (enabled=false)
	public void personaletailstest() throws InterruptedException {
		// verifying that user can navigate to Personal Details Page
		openBrowser(Config.getProperty("browserType"));
		// login in with the following username and Password
		doDefaultLogin("Username");
		dr.manage().window().maximize();

		// mouse move to My Acoount and Click Personal Details
		String Xpath_menu = Constant.MyAccount;
		String Xpath_submenu = Constant.personalDetail;
		WebElement menu = dr.findElement(By.xpath(Xpath_menu));
		WebElement submenu = dr.findElement(By.xpath(Xpath_submenu));
		Actions move = new Actions(dr);
		move.moveToElement(menu).build().perform();
		Thread.sleep(3000L);
		submenu.click();
		// verifying that user navigated to the presonal Details Page
		String Tittle = dr.findElement(By.xpath("//*[@id='content-header']/h1")).getText();
		try {
			// if Text on the header of the page is not Personal Details Throw
			// an Error
			Assert.assertEquals(Tittle, "PERSONAL DETAILS");
		} catch (Throwable t) {
			t.getStackTrace();
			System.out.println(t);
			Thread.sleep(1000L);
			getObject("hp_signout").click();
		}
	}

	@Test// (enabled=false)
	public void changePasswordtest() throws InterruptedException {
		// verifying if clicking on Change Password link in My Account Menu will
		// navigate to Change password page
		openBrowser(Config.getProperty("browserType"));
		// login in with the following username and Password
		doDefaultLogin("Username");
		dr.manage().window().maximize();
		Thread.sleep(3000L);
		// clicking on CASINO in the vertical
		getObject("casino").click();
		// mouse move to My Acoount and Click change password
		String Xpath_menu = Constant.MyAccount;
		String Xpath_submenu = Constant.changepassword;
		WebElement menu = dr.findElement(By.xpath(Xpath_menu));
		WebElement submenu = dr.findElement(By.xpath(Xpath_submenu));
		Actions move = new Actions(dr);
		move.moveToElement(menu).build().perform();
		Thread.sleep(3000L);
		submenu.click();
		// verifying that user navigated to the Change Password Page
		String Tittle = dr.findElement(By.xpath("//*[@id='content-header']/h1")).getText();
		try {
			// if the Texts Display on the Page is not Change password throw an
			// error
			Assert.assertEquals(Tittle, "CHANGE PASSWORD");
		} catch (Throwable t) {
			t.getStackTrace();
			System.out.println(t);
			getObject("hp_signout").click();
		}

	}

	@Test// (enabled=false)
	public void deposittest() throws InterruptedException {
		// Checking to see if user can click on Deposit link within My Account
		// Menu to lunch the Cashier
		openBrowser(Config.getProperty("browserType"));
		// login in with the following username and Password
		doDefaultLogin("Username");
		dr.manage().window().maximize();
		Thread.sleep(2000L);
		String Xpath_menu = Constant.MyAccount;
		String Xpath_submenu = Constant.deposit;
		WebElement menu = dr.findElement(By.xpath(Xpath_menu));
		WebElement submenu = dr.findElement(By.xpath(Xpath_submenu));
		Actions move = new Actions(dr);
		move.moveToElement(menu).build().perform();
		Thread.sleep(3000L);
		submenu.click();
		Thread.sleep(3000L);
		// close the cashier frame
		dr.findElement(By.xpath("//*[@id='sb-nav-close']")).click();
		Thread.sleep(3000L);
		getObject("hp_signout").click();
	}

	@Test // (enabled=false)
	// Checking to see if user can click on Withdraw link within My Account Menu
	// to lunch the Cashier
	public void withdrawtest() throws InterruptedException {
		openBrowser(Config.getProperty("browserType"));
		// login in with the following username and Password
		doDefaultLogin("Username");
		dr.manage().window().maximize();
		String Xpath_menu = Constant.MyAccount;
		String Xpath_submenu = Constant.withdraw;
		WebElement menu = dr.findElement(By.xpath(Xpath_menu));
		WebElement submenu = dr.findElement(By.xpath(Xpath_submenu));
		Actions move = new Actions(dr);
		move.moveToElement(menu).build().perform();
		Thread.sleep(3000L);
		submenu.click();
		Thread.sleep(3000L);
		// close the cashier frame
		dr.findElement(By.xpath("//*[@id='sb-nav-close']")).click();
		Thread.sleep(3000L);
		getObject("hp_signout").click();

	}

	@Test// (enabled=false)
	// Checking to see if user can click on bonus link within My Account Menu to
	// lunch the Cashier
	public void bonustest() throws InterruptedException {
		openBrowser(Config.getProperty("browserType"));
		// login in with the following username and Password
		doDefaultLogin("Username");
		dr.manage().window().maximize();
		String Xpath_menu = Constant.MyAccount;
		String Xpath_submenu = Constant.bonus;
		WebElement menu = dr.findElement(By.xpath(Xpath_menu));
		WebElement submenu = dr.findElement(By.xpath(Xpath_submenu));
		Actions move = new Actions(dr);
		move.moveToElement(menu).build().perform();
		Thread.sleep(3000L);
		submenu.click();
		Thread.sleep(3000L);
		// close the Cashier frame
		dr.findElement(By.xpath("//*[@id='sb-nav-close']")).click();
		Thread.sleep(3000L);
		getObject("hp_signout").click();
	}

	@AfterMethod
	public void close() {
		quit();

	}
}
