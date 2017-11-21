package Cashier;

import java.io.FileNotFoundException;
import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import Base.TestBase;
import Util.Constant;
import Util.TestUtil;

public class CashierDepositTest extends TestBase {
	@BeforeTest
	public void initLogs() throws FileNotFoundException {
		// initLogs(this.getClass());
		init();

	}

	@Test(enabled=false,dataProvider = "getdata")
	public void MYAccountMenutest(String Amount, String Card, String Cvv2, String PromoCode)throws InterruptedException {
		// verify if user can make a deposit
		// verify if user can make a deposit less than �5
		// verify if the system will accept Invalid Bonus Code
		// Verify if the system will accept valid Bonus Code.
		// login in with the following username and Password
		openBrowser(Config.getProperty("browserType"));
		doDefaultLogin("Username");
		Thread.sleep(1000L);
		getObject("hp_Deposit").click();
		Thread.sleep(2000L);
		dr.switchTo().frame("sb-player").switchTo().frame(0);
		WebDriverWait wait = new WebDriverWait(dr, 15);
		getObject("cashier_Deposit_AmountToDeposit").sendKeys(Amount);
		getObject("cashier_Deposit_CardNumber").sendKeys(Card);
		getObject("cashier_Deposit_CVV2").sendKeys(Cvv2);
		getObject("cashier_Deposit_promocode").sendKeys(PromoCode);
		getObject("cashier_Deposit_DEPOSIT").click();
		Thread.sleep(2000L);
		WebElement ComplianceTextBox = getObject("cashier_DepositGamblinglicenceConfirmMessagePROCEED");
		if (ComplianceTextBox.isDisplayed())
			getObject("cashier_DepositGamblinglicenceConfirmMessagePROCEED").click();
		// Thread.sleep(5000L);
		// getObject("cashier_DepositGamblinglicenceConfirmMessagePROCEED").click();
		Thread.sleep(3000L);
		WebElement check = getObject("Cashier_Deposit_CreditCadrDepositAprroved");
		if (check.isDisplayed()) {
			getObject("cashier_Deposit_CreditcardDepositApprovedOK").click();
		} else {
			System.out.println(false);
		}
		dr.switchTo().defaultContent();
		Thread.sleep(1000L);
		dr.findElement(By.xpath("//*[@id='sb-nav-close']")).click();
		Thread.sleep(1000L);
		getObject("hp_signout").click();
	}

	@DataProvider
	public Object[][] getdata() {
		Object data[][] = new Object[5][4];
		// frist row
		data[0][0] = "3";
		data[0][1] = "111";
		data[0][2] = "123";
		data[0][3] = "";

		// SecondRow
		data[1][0] = "5";
		data[1][1] = "2224";
		data[1][2] = "123";
		data[1][3] = "";
		//
		// ThirdRow
		data[2][0] = "5";
		data[2][1] = "111";
		data[2][2] = "126";
		data[2][3] = "";
		//
		// fourth Row
		data[3][0] = "5";
		data[3][1] = "111";
		data[3][2] = "188";
		data[3][3] = "QWETY";
		// // Fifth Row
		data[4][0] = "5";
		data[4][1] = "111";
		data[4][2] = "123";
		data[4][3] = "";
		return data;

	}

	@AfterMethod
	public void close() {
		quit();

	}
}
//
