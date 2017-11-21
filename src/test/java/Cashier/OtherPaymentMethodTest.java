package Cashier;

import java.io.FileNotFoundException;
import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import Util.TestUtil;
import Base.TestBase;

public class OtherPaymentMethodTest extends TestBase {

	@BeforeTest
	public void initLogs() throws FileNotFoundException {
		// initLogs(this.getClass());
		init();

	}

	@Test(enabled=false)
	public void PaymentMethodTest() throws InterruptedException {
		openBrowser(Config.getProperty("browserType"));
		// login in with the following username and Password
		doDefaultLogin("UserName");
		dr.manage().window().maximize();
		Thread.sleep(1000L);
		getObject("hp_Deposit1").click();
		Thread.sleep(500L);
		dr.switchTo().frame("sb-player").switchTo().frame(0);
		WebDriverWait wait = new WebDriverWait(dr, 15);
		// wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='UM_OKButton']/tbody/tr/td[2]")));
		// getObject("cashier_Deposit_AddNewCardMessageOK").click();
		// getObject("cashier_Deposit_AddNewCreditCard").click();
		// Thread.sleep(1000L);
		// getObject("cashier_Deposit").click();
		// Thread.sleep(1000L);
		getObject("cashier_MyAccount").click();
		Thread.sleep(1000L);
		getObject("cashier_Deposit").click();
		Thread.sleep(1000L);
		getObject("cashier_Deposit_PayPalLogo").click();
		Thread.sleep(1000L);
		getObject("cashier_Deposit_PayPalAmountToDeposit").sendKeys("70");
		getObject("cashier-Deposit_PayPalDeposit").click();
		Thread.sleep(1000L);
		// getObject("cashier_Deposit_PaypalDepositConfirmMessage").click();
		// getObject("cashier_Deposit_PayPalDepositConfirmMessageCancel").click();
		// getObject("cashier_Deposit_PayPalDepositConfirmMessageProceed").click();
		// // Verify if user can Deposit with PayPal
		// String
		// PaypalremoteText=getObject("cashier_Deposit_payPalProceedWithPaymentMessage").getText();
		// if(PaypalremoteText.equalsIgnoreCase("Click OK to proceed with remote
		// deposit."))
		// System.out.println("PaypalremoteText");
		// else
		// System.out.println(false);
		//
		// Thread.sleep(1000L);
		dr.switchTo().defaultContent();
		Thread.sleep(1000L);
		dr.findElement(By.xpath("//*[@id='sb-nav-close']")).click();
		Thread.sleep(1000L);
		getObject("hp_signout").click();
	}

	@Test // (enabled=false)
	public void PaymentMethodPayPal() throws InterruptedException {
		// login in with the following username and Password
		doDefaultLogin("UserName");
		Thread.sleep(1000L);
		getObject("hp_Deposit1").click();
		Thread.sleep(500L);
		dr.switchTo().frame("sb-player").switchTo().frame(0);
		WebDriverWait wait = new WebDriverWait(dr, 15);
		getObject("cashier_MyAccount").click();
		Thread.sleep(1000L);
		getObject("cashier_Deposit").click();
		Thread.sleep(1000L);
		getObject("cashier_Deposit_PayPalLogo").click();
		Thread.sleep(1000L);
		getObject("casher_Deposit_PayPalClickhere").click();
		Thread.sleep(3000L);
		WebElement eli = getObject("cashier_MyAccount_GammingDepositLimitChange");
		if (eli.isDisplayed())
			System.out.println("User able to navigate to the Responsible Gaming page");
		else
			System.out.println("user unable to navigate");
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
}