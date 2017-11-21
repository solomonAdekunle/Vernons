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

import Util.TestUtil;
import Base.TestBase;

public class EnjoyResponsibly  extends TestBase{
	
	@BeforeTest
	public void initLogs() throws FileNotFoundException{
		//initLogs(this.getClass());
		init();
		  
	  }
		
	
	@Test
	public void EnjoyResponsiblytest() throws InterruptedException{
		openBrowser(Config.getProperty("browserType"));
		dr.get(Config.getProperty("testsiteName"));
		dr.manage().window().maximize();
		// Verify that all the links within the page are clickable and navigate to the right page.
		getObject("enjoyResponsible").click();
		String title1=dr.findElement(By.cssSelector("h1.title")).getText();
		System.out.println(title1);
		Assert.assertEquals(title1, "RESPONSIBLE GAMBLING");
		Thread.sleep(2000L);
		getObject("enjoyRes_Gamcare_urlAdd").click();
		Thread.sleep(2000L);
		Assert.assertEquals(dr.getCurrentUrl(), "http://www.gamcare.org.uk/");
		dr.navigate().back();
		WebElement GameCareForumlink=getObject("enjoyRes_GamecareForun");
		WebDriverWait wat = new WebDriverWait(dr,10);
		wat.until(ExpectedConditions.presenceOfElementLocated(By.xpath(OR.getProperty("enjoyRes_GamecareForun"))));
		((JavascriptExecutor) dr).executeScript("arguments[0].click();", GameCareForumlink);
		Thread.sleep(3000L);
		Assert.assertEquals(dr.getCurrentUrl(), "http://www.gamcare.org.uk/forum");
		dr.navigate().back();
		Thread.sleep(3000L);
		WebElement GamblingAnonylink=getObject("enjoyRes_GambleAnony_urlAdd");
		wat.until(ExpectedConditions.presenceOfElementLocated(By.xpath(OR.getProperty("enjoyRes_GambleAnony_urlAdd"))));
		((JavascriptExecutor) dr).executeScript("arguments[0].click();", GamblingAnonylink);
		Thread.sleep(5000L);
		Assert.assertEquals(dr.getCurrentUrl(), "https://www.gamblersanonymous.org.uk/");
		Thread.sleep(3000L);
    	dr.navigate().back();
		Thread.sleep(3000L);
		WebElement GamblingTheraphylink=getObject("enjoyResGambleTherapy_urlAdd");
		wat.until(ExpectedConditions.presenceOfElementLocated(By.xpath(OR.getProperty("enjoyResGambleTherapy_urlAdd"))));
		((JavascriptExecutor) dr).executeScript("arguments[0].click();", GamblingTheraphylink);
		
		Thread.sleep(2000L);
		dr.navigate().back();
		WebElement Cadlink=getObject("enjoyrRes_CADAS_urlAdd");
		wat.until(ExpectedConditions.presenceOfElementLocated(By.xpath(OR.getProperty("enjoyrRes_CADAS_urlAdd"))));
		((JavascriptExecutor) dr).executeScript("arguments[0].click();", Cadlink);
    	
		dr.navigate().back();
		WebElement NECAlink=getObject("enjoyRes_NECA_urlAdd");
		wat.until(ExpectedConditions.presenceOfElementLocated(By.xpath(OR.getProperty("enjoyRes_NECA_urlAdd"))));
		((JavascriptExecutor) dr).executeScript("arguments[0].click();", NECAlink);
		
		dr.navigate().back();
		Thread.sleep(2000L);
		WebElement RCAurllink=getObject("enjoyRes_RCA_urlAdd");
		wat.until(ExpectedConditions.presenceOfElementLocated(By.xpath(OR.getProperty("enjoyRes_RCA_urlAdd"))));
		((JavascriptExecutor) dr).executeScript("arguments[0].click();", RCAurllink);
		
		dr.navigate().back();
		Thread.sleep(3000L);
		WebElement ResponsibleGamblocklink=getObject("enjoyResGamblock");
		wat.until(ExpectedConditions.presenceOfElementLocated(By.xpath(OR.getProperty("enjoyResGamblock"))));
		((JavascriptExecutor) dr).executeScript("arguments[0].click();", ResponsibleGamblocklink);
		
		dr.navigate().back();
		Thread.sleep(2000L);
		WebElement GamblingUrllink=getObject("enjoyResGamBlingControl_urlAdd");
		wat.until(ExpectedConditions.presenceOfElementLocated(By.xpath(OR.getProperty("enjoyResGamBlingControl_urlAdd"))));
		((JavascriptExecutor) dr).executeScript("arguments[0].click();", GamblingUrllink);
		
		dr.navigate().back();
		Thread.sleep(1000L);
		WebElement EUDisputeUrllink=getObject("enjoyRes_EUDisputeResolution");
		wat.until(ExpectedConditions.presenceOfElementLocated(By.xpath(OR.getProperty("enjoyRes_EUDisputeResolution"))));
		((JavascriptExecutor) dr).executeScript("arguments[0].click();", EUDisputeUrllink);
		

}
	@AfterMethod
	public void close() {
		//quit();

	}
}