package Cashier;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
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

public class ProfitReportTest extends TestBase {

	public class MyAccount extends TestBase {
		@BeforeTest
		public void initLogs() throws FileNotFoundException {
			// initLogs(this.getClass());
			init();

		}

		@Test//(enabled = false)
		public void MYAccountProfitReport() throws InterruptedException {
			openBrowser(Config.getProperty("browserType"));
			doDefaultLogin("Username");
			// dr.get(Config.getProperty("testsiteName"));
			dr.manage().window().maximize();
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
			WebDriverWait wait = new WebDriverWait(dr, 20);
			WebElement element = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='PB_CasinoProfitReporttText']")));// wait
																												
			// verify if user can generate profit report if it is available
			getObject("cashier_MyAccount_ProfitReport").click();
			Thread.sleep(2000L);
			getObject("cashier_MyAccount_ProfitReportTimePeriod").sendKeys("Last 30 days");
			dr.switchTo().defaultContent();
			Thread.sleep(1000L);
			dr.findElement(By.xpath("//*[@id='sb-nav-close']")).click();
			Thread.sleep(2000L);
			getObject("hp_signout").click();

		}

		@Test // (enabled=false)
		public void MYAccountTransactions() throws InterruptedException {
			openBrowser(Config.getProperty("browserType"));
			doDefaultLogin("Username");
			String Xpath_menu = Constant.MyAccount;
			String Xpath_submenu = Constant.myaccount;
			WebElement menu = dr.findElement(By.xpath(Xpath_menu));
			WebElement submenu = dr.findElement(By.xpath(Xpath_submenu));
			Actions move = new Actions(dr);
			move.moveToElement(menu).build().perform();
			submenu.click();
			Thread.sleep(5000L);
			dr.switchTo().frame("sb-player").switchTo().frame(0);
			WebDriverWait wait1 = new WebDriverWait(dr, 15);
			WebElement element = wait1.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='PB_TransactionLogsText']")));
			getObject("cashier_MyAccount_Transactions").click();
			// getObject("cashier_MyAccount_TransactionsSelectPeriod").sendKeys("Last
			// 30 days");
			getObject("cashier_MyAccount_TansactionsStartDate").click();
			getObject("cashier_MyAccount_TansactionsStartDate").sendKeys("2015-04-03");
			getObject("cashier_MyAccount_TransactionsEndDate").click();
			getObject("cashier_MyAccount_TransactionsEndDate").sendKeys("2015-06-08");
			getObject("cashier_MyAccount_TransactionsViewHistory").click();
			// verify if the system ia able to generate transaction report
			WebElement visaAsPayementMethood = getObject(
					"cashier_MyAccount_TransactionsViewHistoryMethodPaymentVisaIcon");
			if (visaAsPayementMethood.isDisplayed())
				System.out.println("Transaction History is generated");
			else
				System.out.println("unable to generate Transaction History");
			Thread.sleep(2000L);
			dr.switchTo().defaultContent();
			Thread.sleep(1000L);
			dr.findElement(By.xpath("//*[@id='sb-nav-close']")).click();
			Thread.sleep(2000L);
			getObject("hp_signout").click();
		}

		@Test // (enabled=false)
		public void MYAccountSesstion() throws InterruptedException {
			openBrowser(Config.getProperty("browserType"));
			doDefaultLogin("Username");
			String Xpath_menu = Constant.MyAccount;
			String Xpath_submenu = Constant.myaccount;
			WebElement menu = dr.findElement(By.xpath(Xpath_menu));
			WebElement submenu = dr.findElement(By.xpath(Xpath_submenu));
			Actions move = new Actions(dr);
			move.moveToElement(menu).build().perform();
			submenu.click();
			Thread.sleep(5000L);
			dr.switchTo().frame("sb-player").switchTo().frame(0);
			WebDriverWait wait1 = new WebDriverWait(dr, 15);
			WebElement element = wait1
					.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='PB_SessionLogsText']")));
			getObject("cashier_MyAccount_Sessions").click();
			Thread.sleep(2000L);
			Actions action = new Actions(dr);
			action.moveToElement(dr.findElement(By.xpath("//*[@id='SH_Submit']/tbody/tr/td[2]"))).sendKeys(Keys.TAB).sendKeys(Keys.ARROW_DOWN).sendKeys((Keys.ENTER)).build().perform();
			getObject("cashier_MyAccount_SessionsViewSession").click();
			Thread.sleep(2000l);
			dr.switchTo().defaultContent();
			Thread.sleep(1000L);
			dr.findElement(By.xpath("//*[@id='sb-nav-close']")).click();
			Thread.sleep(2000L);
			getObject("hp_signout").click();

		}

		@Test // (enabled=false)
		public void MYAccountGameHistory() throws InterruptedException {
			openBrowser(Config.getProperty("browserType"));
			doDefaultLogin("Username");
			String Xpath_menu = Constant.MyAccount;
			String Xpath_submenu = Constant.myaccount;
			WebElement menu = dr.findElement(By.xpath(Xpath_menu));
			WebElement submenu = dr.findElement(By.xpath(Xpath_submenu));
			Actions move = new Actions(dr);
			move.moveToElement(menu).build().perform();
			submenu.click();
			Thread.sleep(5000L);
			dr.switchTo().frame("sb-player").switchTo().frame(0);
			WebDriverWait wait1 = new WebDriverWait(dr, 15);
			WebElement element = wait1.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='PB_BettingLogsText']")));
			// Verify that user can check is game history by setting the start
			// all the input boxes according to his date of preference
			getObject("cashier_MyAccount_GameHistory").click();
			getObject("cashier_MyAccount_GameHistoryTimePeriod").sendKeys("Yesterday");
			getObject("cashier_MyAccount_GameHistoryStartDate").clear();
			getObject("cashier_MyAccount_GameHistoryStartDate").sendKeys("2015-05-01 00:00");
			getObject("cashier_MyAccount_GameHistoryEndDate").clear();
			getObject("cashier_MyAccount_GameHistoryEndDate").sendKeys("2015-06-01 00:00");
			getObject("cashier_MyAccount_GameHistoryGameType").sendKeys("PROGRESSIVE GAMES");
			getObject("cashier_MyAccount_GameHistoryGameName").sendKeys("Alien Hunter");
			getObject("cashier_MyAccount_GameHistoryGameState").sendKeys("Broken");
			getObject("cashier-MyAccount_GameHistoryResultPerPage").sendKeys("100 games");
			getObject("cashier_MyAccount_GameHistorySearch").click();
			// verify if user can set time period to exceed more than 30day
			String timeperoidtext = getObject("cashier_MyAccount_GameHistoryTimePeriodText").getText();
			System.out.println(timeperoidtext);
			if (timeperoidtext.equalsIgnoreCase(
					"The time period must not exceed 30 days. Please enter a time period equal to or less than 30 days.")) {
				getObject("cashier_MyAccount_GameHistoryTimePeriodTextOK").click();
			} else {
				System.out.println("failed, user was able to set the time period to exceed 30 doys");
			}
			Thread.sleep(2000l);
			getObject("cashier_MyAccount_GameHistoryTimePeriodCLOSE").click();
			dr.switchTo().defaultContent();
			Thread.sleep(1000L);
			dr.findElement(By.xpath("//*[@id='sb-nav-close']")).click();
			Thread.sleep(2000L);
			getObject("hp_signout").click();
			// Thread.sleep(1000L);
			// dr.close();

		}

		@Test // (enabled=false)
		public void MYAccountGameHistoryB() throws InterruptedException {
			openBrowser(Config.getProperty("browserType"));
			doDefaultLogin("Username");
			String Xpath_menu = Constant.MyAccount;
			String Xpath_submenu = Constant.myaccount;
			WebElement menu = dr.findElement(By.xpath(Xpath_menu));
			WebElement submenu = dr.findElement(By.xpath(Xpath_submenu));
			Actions move = new Actions(dr);
			move.moveToElement(menu).build().perform();
			submenu.click();
			Thread.sleep(5000L);
			dr.switchTo().frame("sb-player").switchTo().frame(0);
			WebDriverWait wait1 = new WebDriverWait(dr, 15);
			// wait for Game History  to load 
			WebElement element = wait1.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='PB_BettingLogsText']")));
			// Verify that user can check is game history by setting the start
			// all the input boxes according to his date of preference
			getObject("cashier_MyAccount_GameHistory").click();
			// getObject("cashier_MyAccount_GameHistoryTimePeriod").sendKeys("Yesterday");
			getObject("cashier_MyAccount_GameHistoryStartDate").clear();
			getObject("cashier_MyAccount_GameHistoryStartDate").sendKeys("2015-05-01 00:00");
			getObject("cashier_MyAccount_GameHistoryEndDate").clear();
			getObject("cashier_MyAccount_GameHistoryEndDate").sendKeys("2015-05-29 00:00");
			getObject("cashier_MyAccount_GameHistoryGameType").sendKeys("TABLE & CARDS GAMES");
			getObject("cashier_MyAccount_GameHistoryGameName").sendKeys("3D Roulette");
			getObject("cashier_MyAccount_GameHistoryGameState").sendKeys("Finished");
			getObject("cashier-MyAccount_GameHistoryResultPerPage").sendKeys("100 games");
			getObject("cashier_MyAccount_GameHistorySearch").click();
			Thread.sleep(1000L);
			getObject("cashier_MyAccount_GameHistoryTimePeriodCLOSE").click();
			dr.switchTo().defaultContent();
			Thread.sleep(1000L);
			dr.findElement(By.xpath("//*[@id='sb-nav-close']")).click();
			Thread.sleep(2000L);
			getObject("hp_signout").click();

			

		}

	}

	@AfterMethod
	public void close() {
		quit();

	}
}