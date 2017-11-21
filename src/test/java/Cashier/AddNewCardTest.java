package Cashier;

import java.io.FileNotFoundException;
import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import Util.TestUtil;
import Base.TestBase;

public class AddNewCardTest extends TestBase {

	@BeforeTest
	public void initLogs() throws FileNotFoundException {
		// initLogs(this.getClass());
		init();

	}

	@Test(enabled=false,dataProvider = "getdata")
	public void addcardtest(String Amt, String CVV2, String PromoCode, String Cardtype, String CardNum, String Month,String Yr) throws InterruptedException {
		openBrowser(Config.getProperty("browserType"));
		doDefaultLogin("UserName");
		// dr.get(Config.getProperty("testsiteName"));
		// dr.manage().window().maximize();
		// login in with the following username and Password
		// TestUtil.doLogin("Netplay237", "London02");
		Thread.sleep(1000L);
		getObject("hp_Deposit").click();
		Thread.sleep(2000L);
		dr.switchTo().frame("sb-player").switchTo().frame(0);
		WebDriverWait wait = new WebDriverWait(dr, 15);
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='UM_OKButton']/tbody/tr/td[2]")));
		getObject("cashier_Deposit_AddNewCardMessageOK").click();
		getObject("cashier_Deposit_AddNewCreditCard").click();
		Thread.sleep(1000L);
		getObject("cashier_DepositAddNweCreditCard_AmtToDeposit").sendKeys(Amt);
		getObject("cashier_DepositAddNewCreditCard_cvv2").sendKeys(CVV2);
		getObject("cashier_DepositAddNewCreditCard_PromCode").sendKeys(PromoCode);
		getObject("cashier_DepositAddNewCreditCard_cardType").sendKeys(Cardtype);
		getObject("cashier_depositAddNewCreditCard_CardNumber").sendKeys(CardNum);
		getObject("cashier_DepositAddNewCreditCard_ExpiraryDateNonth").sendKeys(Month);
		getObject("cashier_DepositAddNewCreditCard_expiraryDateYear").sendKeys(Yr);
		getObject("cashier_DepoistAddNewCreditCard_Deposit").click();
		Thread.sleep(1000L);
		WebElement ComplianceTextBox = getObject("cashier_DepositGamblinglicenceConfirmMessage");
		if (ComplianceTextBox.isDisplayed())
			getObject("cashier_DepositGamblinglicenceConfirmMessage").click();
		getObject("cashier_DepositGamblinglicenceConfirmMessagePROCEED").click();
		// VERIFY if user can Add invalid card to the system
		String AddCreditCardText = getObject("cashier_DepositAddNewCardInvalidCardNumberMessage").getText();
		// System.out.println(AddCreditCardText);
		Thread.sleep(1000L);
		if (AddCreditCardText.equalsIgnoreCase("Please enter a valid Credit Card Number.")) {
			System.out.println("user unable to register with invalid credit card");
		} else {
			System.out.println(AddCreditCardText);
		}
		getObject("cashier_DepositAddNewCardInvalidCardNumberMessageOK").click();
		Thread.sleep(1000L);
		dr.switchTo().defaultContent();
		Thread.sleep(1000L);
		dr.findElement(By.xpath("//*[@id='sb-nav-close']")).click();
		Thread.sleep(1000L);
		getObject("hp_signout").click();

	}

	@AfterMethod
	public void close() {
		quit();

	}

	@DataProvider
	public Object[][] getdata() {
		Object data[][] = new Object[5][7];
		// frist row
		data[0][0] = "30";
		data[0][1] = "12";
		data[0][2] = "Bonus12";
		data[0][3] = "DELTA";
		data[0][4] = "1111122222333333";
		data[0][5] = "02";
		data[0][6] = "2020";
		// SecondRow
		data[1][0] = "5";
		data[1][1] = "123";
		data[1][2] = "";
		data[1][3] = "MASETRO";
		data[1][4] = "12222222222222";
		data[1][5] = "08";
		data[1][6] = "2018";
		// ThirdRow
		data[2][0] = "5";
		data[2][1] = "123";
		data[2][2] = "";
		data[2][3] = "VISA";
		data[2][4] = "1111111111111145";
		data[2][5] = "05";
		data[2][6] = "2017";
		// fourth Row
		data[3][0] = "5";
		data[3][1] = "123";
		data[3][2] = "";
		data[3][3] = "VISA";
		data[3][4] = "1111111111111111";
		data[3][5] = "01";
		data[3][6] = "2015";
		// Fifth Row
		data[4][0] = "50";
		data[4][1] = "123";
		data[4][2] = "";
		data[4][3] = "VISA";
		data[4][4] = "1111111111111111";
		data[4][5] = "05";
		data[4][6] = "2017";
		return data;
	}

}
