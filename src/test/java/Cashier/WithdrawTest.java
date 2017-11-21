package Cashier;

import java.io.FileNotFoundException;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import Util.Constant;
import Base.TestBase;

public class WithdrawTest extends TestBase {
	@BeforeTest
	public void initLogs() throws FileNotFoundException{
		//initLogs(this.getClass());
		init();
		  
	  }
@Test
 public void withdrawtest() throws InterruptedException{
	// verify if user can withdraw with registered card
	// login in with the following username and Password
	openBrowser(Config.getProperty("browserType"));
	 doDefaultLogin("Username");
	  Thread.sleep(1000L);
	  String Xpath_menu=Constant.MyAccount;
	  String Xpath_submenu=Constant.withdraw;
	  WebElement menu=dr.findElement(By.xpath(Xpath_menu));
	  WebElement submenu=dr.findElement(By.xpath(Xpath_submenu));
	   Actions move= new Actions(dr);
	   move.moveToElement(menu).build().perform();
	   Thread.sleep(3000L);
	   submenu.click();
	   Thread.sleep(3000L);
	// switch to frame
	    dr.switchTo().frame("sb-player").switchTo().frame(0);
	    WebDriverWait wait= new WebDriverWait(dr,15);
	    getObject("cashier_WithDraw_AmtToWithdarw").sendKeys("10");
	    Actions action= new Actions(dr);
	    action.moveToElement(dr.findElement(By.xpath("//*[@id='W_CardNumber']"))).sendKeys(Keys.TAB).sendKeys(Keys.ARROW_DOWN).sendKeys((Keys.ENTER)).build().perform();
	    // click on withdraw button
	         getObject("cashier_withdraw_Withdaw").click();
	      Thread.sleep(2000L);
	    String message= getObject("cashier_withdraw_yourWithdrawRequestHasBeenReceived").getText();
	   System.out.println(message);
	   WebElement withdrawMessage=getObject("cashier_withdraw_yourWithdrawRequestHasBeenReceived");
	     Thread.sleep(500L);
	   if(withdrawMessage.equals("Your Withdrawal request has been received and will be processed by the casino's cashier. You can check your withdrawal status in the Pending Withdrawals section. Thank you!")){
		   Thread.sleep(1000L);
		   System.out.println("message displayed correctly");
	   }else
		   System.out.println("different message displayed");
	   
	   getObject("cashier_withdraw_YourWithdrawHasBeenReceivedOK").click();
	   Thread.sleep(500L);
	   getObject("cashier_MyAccount").click();
	   Thread.sleep(1000L);
	   getObject("cashier_PendingWithdrawals").click();
	   Thread.sleep(1000L);
	   getObject("cashier_withdraw_PendingWithdrawalsTransferBackToBalance").click();
	   Thread.sleep(1000L);
	   String CancelwithdrawText=getObject("cashier_withdraw_pendingwithdrawalCancellingMessage").getText();
	   if(CancelwithdrawText.equalsIgnoreCase("Your Pending withdrawal was successfully cancelled and the funds were transferred back to your account balance."))
		   System.out.println("Pending withdrawal cancel successfully");
	   else
		   System.out.println("user unable to cancel pending withdrawal");
	   
	   Thread.sleep(1000L);
	   getObject("cashier_withdraw_pendingwithdrawalCancellingMessageOK").click();
	   Thread.sleep(1000L);
	   dr.close();
	   
}  
@AfterMethod
public void close() {
	quit();

}
}
