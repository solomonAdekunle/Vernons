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

public class Terms extends TestBase {

	@BeforeTest
	public void initLogs() throws FileNotFoundException {
		// initLogs(this.getClass());
		init();

	}

	@Test
	public void Termstest() throws InterruptedException {
		openBrowser(Config.getProperty("browserType"));
		doDefaultLogin("Username");
		dr.manage().window().maximize();
		// clicking on all the links within the page
		getObject("terms").click();
		Thread.sleep(2000);
		//getObject("terms_casinoEmail").click();
		WebElement LinkWithinTermPage=getObject("term_EULA");
		WebDriverWait wat = new WebDriverWait(dr,10);
		wat.until(ExpectedConditions.presenceOfElementLocated(By.xpath(OR.getProperty("term_EULA"))));
		((JavascriptExecutor) dr).executeScript("arguments[0].click();", LinkWithinTermPage);
		Assert.assertTrue(getObject("title_PlayTechEULA").isDisplayed());
		Thread.sleep(2000);
		dr.navigate().back();
		Thread.sleep(2000);
		

	}

	@AfterMethod
	public void close() {
		 quit();

	}
}
