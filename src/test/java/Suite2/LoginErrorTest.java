package Suite2;

import java.io.FileNotFoundException;

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

public class LoginErrorTest extends TestBase {

	@BeforeTest
	public void initLogs() throws FileNotFoundException {
		// initLogs(this.getClass());
		init();
	}

	@Test//(enabled = false)
	public void invalidLogin() throws InterruptedException {
		openBrowser(Config.getProperty("browserType"));
		dr.get(Config.getProperty("testsiteName"));
		getObject("login_username").sendKeys("asddfrey");
		getObject("login_password").sendKeys("agggaji");
		getObject("loginButton").click();
		Thread.sleep(3000L);
		// verify that user is unable to login with incorrect data
		String errormsg = dr.findElement(By.cssSelector("div#sb-player .login-error .error_message")).getText();
		System.out.println(errormsg);
		// user verifying that incorrect data message is displayed if user input
		// incorrect data
		if ((errormsg).equals("Incorrect Username or Password – please re-enter.")) {
			System.out.println(true);
		} else {
			System.out.println(false);
		}

	}

	// verify that user is able to click the i know my username but forgot my
	// passwordlink in the incorrect
	@Test//(enabled=false)
	public void passwordforgot() throws InterruptedException {
		openBrowser(Config.getProperty("browserType"));
		dr.get(Config.getProperty("testsiteName"));
		getObject("login_username").sendKeys("asddfrey");
		getObject("login_password").sendKeys("agggaji");
		getObject("loginButton").click();
		Thread.sleep(3000L);
		WebElement errorLoginModal_ForgottenDetails = dr
				.findElement(By.cssSelector("div#sb-player .login-error a#forgotten-details-link"));
		errorLoginModal_ForgottenDetails.click();
		dr.getCurrentUrl();
		Thread.sleep(3000L);
		System.out.println(dr.getTitle());
		// verified if the page navigated back to the Forgotten detail page
		Assert.assertEquals(dr.getTitle(),"Forgotten Details | Vernons.com");

	}

	

	@Test//(enabled = false)
	public void closebutton() throws InterruptedException {
		openBrowser(Config.getProperty("browserType"));
		dr.get(Config.getProperty("testsiteName"));
		getObject("login_username").sendKeys("asddfrey");
		getObject("login_password").sendKeys("agggaji");
		getObject("loginButton").click();
		Thread.sleep(5000L);
		// Click the close icon on the Error Login pop-up box
	 WebElement CloseIcon=	dr.findElement(By.xpath("//*[@id='pas-block']/div[4]/div[1]/a"));
	 ((JavascriptExecutor) dr).executeScript("arguments[0].click();",CloseIcon);
		// dr.close();

	}

	@AfterMethod
	public void close() {
		quit();

	}
}
