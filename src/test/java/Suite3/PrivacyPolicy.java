package Suite3;

import java.io.FileNotFoundException;
import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import Base.TestBase;

public class PrivacyPolicy extends TestBase {
	@BeforeTest
	public void initLogs() throws FileNotFoundException{
		//initLogs(this.getClass());
		init();
		  
	  }
    @Test
     public void privacypolicytest() throws InterruptedException{
    	openBrowser(Config.getProperty("browserType"));
    	doDefaultLogin("Username");
    	//dr.get(Config.getProperty("testsiteName"));
		dr.manage().window().maximize();
		WebElement FooterPrivacyPolicyLink=getObject("privacyPolicy");
		WebDriverWait wat = new WebDriverWait(dr,20);
		wat.until(ExpectedConditions.presenceOfElementLocated(By.xpath(OR.getProperty("privacyPolicy"))));
		((JavascriptExecutor) dr).executeScript("arguments[0].click();", FooterPrivacyPolicyLink);
		// clicking on all the links within the page
		//getObject("privacyPolicy").click();
		Thread.sleep(3000);
		String title=dr.findElement(By.cssSelector("h1.title")).getText();
		System.out.println(title);
		Assert.assertEquals(title, "PRIVACY POLICY");
		
	/*	getObject("privacyPolicy_casinoEmail").click();
		getObject("privacyPolicy_aboutCookies").click();
		//dr.navigate().back();
		Thread.sleep(4000L);
		getObject("privacyPolicy_googleAnalytics").click();
		//dr.navigate().back();
		Thread.sleep(2000L);
		getObject("privacyPolicy_googlepolicy").click();
		//dr.navigate().back();
		//getObject("").click();
		 * 
		 */
    }
    @AfterMethod
	public void close() {
		quit();

	}
}
