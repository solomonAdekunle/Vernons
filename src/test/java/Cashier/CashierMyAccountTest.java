package Cashier;

import java.io.FileNotFoundException;
import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import Util.Constant;
import Util.TestUtil;
import Base.TestBase;

public class CashierMyAccountTest extends TestBase {

	public class MyAccount extends TestBase {

		@BeforeTest
		public void initLogs() throws FileNotFoundException {
			// initLogs(this.getClass());
			init();

		}

		@Test(enabled = false)
		public void MYAccountMenutest() throws InterruptedException {
			openBrowser(Config.getProperty("browserType"));
			// dr.get(Config.getProperty("testsiteName"));
			dr.manage().window().maximize();
			doDefaultLogin("Username"); // login in with the following username
										// and Password
			// TestUtil.doLogin("Solomon2015", "London03");
			String Xpath_menu = Constant.MyAccount;
			String Xpath_submenu = Constant.myaccount;
			WebElement menu = dr.findElement(By.xpath(Xpath_menu));
			WebElement submenu = dr.findElement(By.xpath(Xpath_submenu));
			Actions move = new Actions(dr);
			move.moveToElement(menu).build().perform();
			submenu.click();
			Thread.sleep(5000L);
			dr.switchTo().frame("sb-player").switchTo().frame(0);
			WebDriverWait wait = new WebDriverWait(dr, 15);
			WebElement element = wait.until(ExpectedConditions
					.elementToBeClickable(By.xpath("//*[@id='CMS_ConvertToRealMoney']/tbody/tr/td[2]/span")));
			boolean Button = dr.findElement(By.xpath("//*[@id='CMS_ConvertToRealMoney']/tbody/tr/td[2]/span"))
					.isDisplayed();
			System.out.println(
					dr.findElement(By.xpath("//*[@id='CMS_ConvertToRealMoney']/tbody/tr/td[2]/span")).isDisplayed());
			if (Button = true)
				System.out.println("user has navigated to Cashier Account Page");
			else
				System.out.println("Failed");
			getObject("cashier_MyAccount_ConvertToMoney").click();
			Thread.sleep(1000L);
			dr.findElement(By.xpath("//*[@id='UM_OKButton']/tbody/tr/td[2]")).click();
			Thread.sleep(2000L);
			getObject("cashier_MyAccount_InviteaFriend").click();
			boolean Button1 = dr.findElement(By.xpath("//*[@id='I_Submit']/tbody/tr/td[2]")).isDisplayed();
			System.out.println(dr.findElement(By.xpath("//*[@id='I_Submit']/tbody/tr/td[2]")).isDisplayed());
			if (Button1 = true)
				System.out.println("user are able to click the button to navigate to invite friend page");
			else
				System.out.println("Failed");
			Thread.sleep(2000L);
			getObject("cashier_MyAccount").click();
			// verify if user can Add Invalid bonus code
			Thread.sleep(2000L);
			getObject("cashier_MyAccount_promoCode").sendKeys("BONUS400");
			getObject("cashier_MyAccount_PromoCode_Submit").click();
			WebElement Ele = getObject("cashier_MyAccount_PromocodeInvalidBonusCode_ok");
			Thread.sleep(2000L);
			if (Ele.isDisplayed()) {
				System.out.println(true);
			} else
				System.out.println("user has been able to add invalid Bonuscode Successfully ");
			getObject("cashier_MyAccount_PromocodeInvalidBonusCode_ok").click();
			Thread.sleep(3000L);
			Thread.sleep(2000l);
			dr.switchTo().defaultContent();
			Thread.sleep(1000L);
			dr.findElement(By.xpath("//*[@id='sb-nav-close']")).click();
			Thread.sleep(2000L);
			getObject("hp_signout").click();
		}

		@Test(enabled = false)
		public void MYAccountMyProfile() throws InterruptedException {
			openBrowser(Config.getProperty("browserType"));
			// dr.get(Config.getProperty("testsiteName"));
			dr.manage().window().maximize();
			doDefaultLogin("Username"); // login in with the following username
										// and Password
			// TestUtil.doLogin("netplay230", "London02");
			String Xpath_menu = Constant.MyAccount;
			String Xpath_submenu = Constant.myaccount;
			WebElement menu = dr.findElement(By.xpath(Xpath_menu));
			WebElement submenu = dr.findElement(By.xpath(Xpath_submenu));
			Actions move = new Actions(dr);
			move.moveToElement(menu).build().perform();
			submenu.click();
			Thread.sleep(5000L);
			dr.switchTo().frame("sb-player").switchTo().frame(0);
			WebDriverWait wait = new WebDriverWait(dr, 15);
			WebElement element = wait.until(
					ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='PB_CasinoMyAccountProfileText']")));
			getObject("cashier_MyAccount_MyProfile").click();
			getObject("cashier_MyAccountMyProfile_changeYourPassword").click();
			Thread.sleep(1000L);
			getObject("cashier_MyAccount_MyProfileChangePassword_OldPassword").sendKeys("London02");
			getObject("cashier_MyAccount_MyProfileChangePassword_NewPassword").sendKeys("London03");
			// Thread.sleep(500L);
			getObject("cashier_MyAccount_MyProfileChangePassword_ReEnterPassword").sendKeys("London03");
			Thread.sleep(1000L);
			getObject("cashier_MyAccountMy_MyProfileChangePassword_Save").click();
			Thread.sleep(500L);
			String TextchangeError = getObject("cashier_MyAccount_MyprofileChangePassword_invalidPassword").getText();
			System.out.println(TextchangeError);
			// verify that user can input invalid data and to change his or her
			// password
			WebElement InvalidPassword = getObject("cashier_MyAccount_MyprofileChangePassword_invalidPassword");
			if (InvalidPassword.isDisplayed())
				getObject("cashier_MyAccount_MyprofileChangePassword_InvalidPasswordtextOK").click();
			else
				System.out.println("Failed");
			getObject("cashier_MyAccount_MyProfileChangePassword_Cancel").click();
			Thread.sleep(2000l);
			dr.switchTo().defaultContent();
			Thread.sleep(1000L);
			dr.findElement(By.xpath("//*[@id='sb-nav-close']")).click();
			Thread.sleep(2000L);
			getObject("hp_signout").click();

		}

		@Test(enabled = false)
		public void MYAccountGaming() throws InterruptedException {
			openBrowser(Config.getProperty("browserType"));
			// dr.get(Config.getProperty("testsiteName"));
			dr.manage().window().maximize();
			doDefaultLogin("Username"); // login in with the following username
										// and Password
			// TestUtil.doLogin("netplay230", "London03");
			String Xpath_menu = Constant.MyAccount;
			String Xpath_submenu = Constant.myaccount;
			WebElement menu = dr.findElement(By.xpath(Xpath_menu));
			WebElement submenu = dr.findElement(By.xpath(Xpath_submenu));
			Actions move = new Actions(dr);
			move.moveToElement(menu).build().perform();
			submenu.click();
			Thread.sleep(5000L);
			dr.switchTo().frame("sb-player").switchTo().frame(0);
			WebDriverWait wait = new WebDriverWait(dr, 15);
			WebElement element = wait
					.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='PB_ResponsibleGamingText']")));
			// Verify that user can set the session timer
			getObject("cashier_MyAccount_Gaming").click();
			getObject("cashier_MyAccount_GamingTurnOn").click();
			getObject("cashier_MyAccount_GamingTimeLimitInMinutes").sendKeys("90");
			getObject("cashier_MyAccount_GamingEffectiveperiod").sendKeys("Prompt message");
			getObject("cashier_MyAccount_Gamingperiod").sendKeys("month");
			getObject("cashier_MyAcoount_GamingSetSessionTimer").click();
			Thread.sleep(2000L);
			// verify if user can Turn off the seetion Timer
			getObject("cashier_MyAccount_GamingTurnOff").click();
			Thread.sleep(2000l);
			dr.switchTo().defaultContent();
			Thread.sleep(1000L);
			dr.findElement(By.xpath("//*[@id='sb-nav-close']")).click();
			Thread.sleep(2000L);
			getObject("hp_signout").click();

		}

		@Test(enabled = false)
		public void MYAccountGaming1() throws InterruptedException {
			openBrowser(Config.getProperty("browserType"));
			// dr.get(Config.getProperty("testsiteName"));
			dr.manage().window().maximize();
			doDefaultLogin("browser"); // login in with the following username
										// and Password
			// TestUtil.doLogin("netplay230", "London03");
			String Xpath_menu = Constant.MyAccount;
			String Xpath_submenu = Constant.myaccount;
			WebElement menu = dr.findElement(By.xpath(Xpath_menu));
			WebElement submenu = dr.findElement(By.xpath(Xpath_submenu));
			Actions move = new Actions(dr);
			move.moveToElement(menu).build().perform();
			submenu.click();
			Thread.sleep(5000L);
			dr.switchTo().frame("sb-player").switchTo().frame(0);
			WebDriverWait wait = new WebDriverWait(dr, 15);
			WebElement element = wait
					.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='PB_ResponsibleGamingText']")));
			// Verify that user can set Loss Limit
			getObject("cashier_MyAccount_Gaming").click();
			Thread.sleep(500L);
			getObject("cashier_MyAccount_GamingLossLimitChange").click();
			getObject("cashier_MyAccount_GamingLossLimitSession").clear();
			Thread.sleep(500L);
			getObject("cashier_MyAccount_GamingLossLimitSession").sendKeys("200");
			Thread.sleep(500L);
			getObject("cashier_MyAccount_GamingLossLimitDaily").clear();
			Thread.sleep(500L);
			getObject("cashier_MyAccount_GamingLossLimitDaily").sendKeys("250");
			getObject("cashier_MyAccount_GamingLossLimitWeekly").clear();
			Thread.sleep(500L);
			getObject("cashier_MyAccount_GamingLossLimitWeekly").sendKeys("1250");
			Thread.sleep(500L);
			getObject("cashier_MyAccount_GamingLossLimitMonthly").clear();
			Thread.sleep(500L);
			getObject("cashier_MyAccount_GamingLossLimitMonthly").sendKeys("5000");
			Thread.sleep(500L);
			getObject("cashier_MyAccount_GamingLossLimitChoseAction").sendKeys("Prompt message");
			getObject("cashier_MyAccount_GamingLossLimitSaveLossLimmit").click();
			Thread.sleep(1000L);
			WebElement ActionText = getObject("cashier_MyAccount_GamingLossLimitActionText");
			if (ActionText.isDisplayed())
				System.out.println(true);
			else
				System.out.println(false);
			Thread.sleep(2000l);
			dr.switchTo().defaultContent();
			Thread.sleep(1000L);
			dr.findElement(By.xpath("//*[@id='sb-nav-close']")).click();
			Thread.sleep(2000L);
			getObject("hp_signout").click();
		}
	}

	@Test(enabled = false)
	public void MYAccountGaming2() throws InterruptedException {
		openBrowser(Config.getProperty("browserType"));
		// dr.get(Config.getProperty("testsiteName"));
		dr.manage().window().maximize();
		doDefaultLogin("browser"); // login in with the following username and
									// Password
		// TestUtil.doLogin("netplay144", "London03");
		String Xpath_menu = Constant.MyAccount;
		String Xpath_submenu = Constant.myaccount;
		WebElement menu = dr.findElement(By.xpath(Xpath_menu));
		WebElement submenu = dr.findElement(By.xpath(Xpath_submenu));
		Actions move = new Actions(dr);
		move.moveToElement(menu).build().perform();
		submenu.click();
		Thread.sleep(5000L);
		dr.switchTo().frame("sb-player").switchTo().frame(0);
		WebDriverWait wait = new WebDriverWait(dr, 15);
		WebElement element = wait
				.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='PB_ResponsibleGamingText']")));
		// Verify that user can set Deposit Limit
		getObject("cashier_MyAccount_Gaming").click();// click on Responsible
														// Gaming Link within
														// the cashier
		Thread.sleep(1000L);
		getObject("cashier_MyAccount_GammingDepositLimitChange").click(); // click
																			// on
																			// deposit
																			// limit
																			// change
																			// button
		Thread.sleep(500);
		getObject("cashier_MyAccount_DepositLimitDaily").sendKeys("200");
		Thread.sleep(500);
		getObject("cashier_MyAcoount_DepositLimtWeekly").sendKeys("1000");
		Thread.sleep(500);
		getObject("cashier_MyAccount_DepositLimitMonthly").clear();
		Thread.sleep(500);
		getObject("cashier_MyAccount_DepositLimitMonthly").sendKeys("4000");
		Thread.sleep(500);
		// getObject("cashier_MyAccount_GamingDepositLimitNewLimmit").sendKeys("Monthly");
		getObject("cashier_MyAcount_GamingDepositLimitSaveDepositLimit").click();
		Thread.sleep(2000l);
		dr.switchTo().defaultContent();
		Thread.sleep(1000L);
		dr.findElement(By.xpath("//*[@id='sb-nav-close']")).click();
		Thread.sleep(2000L);
		getObject("hp_signout").click();

	}

	@Test(enabled = false)
	public void timeoutOptiointest() throws InterruptedException {
		openBrowser(Config.getProperty("browserType"));
		dr.get(Config.getProperty("testsiteName"));
		dr.manage().window().maximize();
		doDefaultLogin("browser"); // login in with the following username and
									// Password
		// TestUtil.doLogin("netplay235", "London02");
		String Xpath_menu = Constant.MyAccount;
		String Xpath_submenu = Constant.myaccount;
		WebElement menu = dr.findElement(By.xpath(Xpath_menu));
		WebElement submenu = dr.findElement(By.xpath(Xpath_submenu));
		Actions move = new Actions(dr);
		move.moveToElement(menu).build().perform();
		submenu.click();
		Thread.sleep(5000L);
		dr.switchTo().frame("sb-player").switchTo().frame(0);
		WebDriverWait wait = new WebDriverWait(dr, 15);
		WebElement element = wait
				.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='PB_ResponsibleGamingText']")));
		// Verify that user can set Deposit Limit
		getObject("cashier_MyAccount_Gaming").click();// click on Responsible
														// Gaming Link within
														// the cashier
		Thread.sleep(1000L);
		getObject("cashier_MyAccount_TimeOutOptionsSelectPeroid").sendKeys("24 Hours");
		Thread.sleep(300L);
		getObject("cashier_MyAccountTimeOutOptionsStartNotification").click();
		Thread.sleep(300L);
		getObject("cashier_MyAccountTimeOutOtionsEndNotification").click();
		Thread.sleep(300L);
		getObject("cashier_MyAccountTimeOutOptionsSave").click();
		String TextMessage1 = getObject("cashier_MyAccountTimeoutOptionsTextMessage").getText();
		if (getObject("cashier_MyAccountTimeoutOptionsTextMessage").isDisplayed()) {
			System.out.println(TextMessage1);// get the text message displayed
												// on the scrren
		} else {
			System.out.println(false);
		}
		Thread.sleep(300L);
		getObject("cashier_MyAccountTimeoutOptionsTextMessageOK").click();
		Thread.sleep(3000L);
		// Verify if user can deposit after setting Time out Options
		getObject("cashier_Deposit").click();
		Thread.sleep(5000);
		// getObject("cashier_DepositCreditCardslogo_DepositNow").click();
		getObject("cashier_Deposit_AmountToDeposit").sendKeys("150");
		getObject("cashier_Deposit_CardNumber").sendKeys("1111111111111111");
		getObject("cashier_Deposit_CVV2").sendKeys("123");
		// getObject("cashier_Deposit_promocode").sendKeys(PromoCode);
		getObject("cashier_Deposit_DEPOSIT").click();
		Thread.sleep(3000L);
		String TextMessage = getObject("cashier_UnabletodepositTimeoutoptionsTextMessage").getText();
		if (getObject("cashier_UnabletodepositTimeoutoptionsTextMessage").isDisplayed())
			System.out.println(TextMessage);// print the text message displayed
											// on the screen
		else
			System.out.println(false);
		Thread.sleep(2000);
		dr.switchTo().defaultContent();
		Thread.sleep(1000L);
		getObject("cashier_close").click();

	}

	@Test
	public void SelfExcludetest() throws InterruptedException {
		dr.get(Config.getProperty("testsiteName"));
		dr.manage().window().maximize();
		doDefaultLogin("browser");
		// TestUtil.doLogin(Config.getProperty("username"),Config.getProperty("password"));
		String Xpath_menu = Constant.MyAccount;
		String Xpath_submenu = Constant.myaccount;
		WebElement menu = dr.findElement(By.xpath(Xpath_menu));
		WebElement submenu = dr.findElement(By.xpath(Xpath_submenu));
		Actions move = new Actions(dr);
		move.moveToElement(menu).build().perform();
		submenu.click();// clcik My account link within the Account Drop down
						// menu
		Thread.sleep(5000L);
		dr.switchTo().frame("sb-player").switchTo().frame(0);
		WebDriverWait wait = new WebDriverWait(dr, 15);
		WebElement element = wait
				.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='PB_ResponsibleGamingText']")));
		// Verify that user can self exclude herself
		getObject("cashier_MyAccount_Gaming").click();// click Responsible
														// Gaming link
		Thread.sleep(2000l);
		getObject("cashier_MyAccountSelfExcludeAddNew").click();
		Thread.sleep(2000l);
		getObject("cashier_MyAccount_TimeOutOptionsSelectPeroid").sendKeys("All");
		Thread.sleep(200l);
		getObject("cashier_MyAccountSelfExclude_SeleectProduct").sendKeys("12Monthsl");
		Thread.sleep(200l);
		getObject("cashier_MyAccountSelfExclude_SELFEXCLUDE").click();
		Thread.sleep(200l);
		String text1 = getObject("cashier_MyAccountSelfExcludeTextMessage").getText();
		if (getObject("cashier_MyAccountSelfExcludeTextMessage").isDisplayed())
			System.out.println(text1);
		else
			System.out.println(false);
		Thread.sleep(200l);
		getObject("cashier_MyAccountSelfExcldeTextMessageOK").click();
		Thread.sleep(1000);
		String text2 = getObject("cashier_MyAccountSelfExcludeTextMessage2").getText();
		if (getObject("cashier_MyAccountSelfExcludeTextMessage2").isDisplayed())
			System.out.println(text2);
		else
			System.out.println(false);
		Thread.sleep(200l);
		getObject("cashier_MyAccountTimeoutOptionsTextMessage2OK").click();
		Thread.sleep(1000l);
		// Verify if user can deposit after self excluded
		getObject("cashier_Deposit").click();
		Thread.sleep(2000);
		// getObject("cashier_DepositCreditCardslogo_DepositNow").click();
		getObject("cashier_Deposit_AmountToDeposit").sendKeys("150");
		getObject("cashier_Deposit_CardNumber").sendKeys("1111111111111111");
		getObject("cashier_Deposit_CVV2").sendKeys("123");
		// getObject("cashier_Deposit_promocode").sendKeys(PromoCode);
		getObject("cashier_Deposit_DEPOSIT").click();
		Thread.sleep(2000L);
		String TextMessage = getObject("cashier_UnabletodepositTimeoutoptionsTextMessage").getText();
		if (getObject("cashier_UnabletodepositTimeoutoptionsTextMessage").isDisplayed())
			System.out.println(TextMessage);// print the text message displayed
											// on the screen
		else
			System.out.println(false);
		Thread.sleep(2000);
		dr.switchTo().defaultContent();
		Thread.sleep(1000L);
		getObject("cashier_close").click();

	}

	@AfterMethod
	public void close() {
		quit();

	}
}