package Suite3;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Iterator;
import java.util.Set;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import Base.TestBase;

public class Contact_us extends TestBase {

	@BeforeTest
	public void initLogs() throws FileNotFoundException {
		// initLogs(this.getClass());
		init();

	}

	@Test
	public void aboutUStest() throws InterruptedException {
		openBrowser(Config.getProperty("browserType"));
		dr.get(Config.getProperty("testsiteName"));
		dr.manage().window().maximize();
		System.out.println("testing the About-us page");
		getObject("contactUs").click();
		getObject("contactus_fqas").click();
		// verifying that the page navigated to the right page
		String title = dr.findElement(By.xpath("//*[@id='content-header']/h1")).getText();
		if (title.equals("FAQS"))
			System.out.println(title);
		else
			System.out.println("Page Not Found");
		dr.navigate().back();
		Thread.sleep(2000L);
		getObject("contactus_here").click();
		String title1 = dr.findElement(By.xpath("//*[@id='content-header']/h1")).getText();
		if (title.equals("FORGOTTEN DETAILS"))
			System.out.println(title1);
		else
			System.out.println("Page Not Found");
		dr.navigate().back();
		Thread.sleep(2000L);
		getObjectFromSelector("contactus_livechat").click();
		Set<String> Windowids = dr.getWindowHandles();
		Iterator<String> it = Windowids.iterator();
		String MainWindowids = it.next();
		String tabbedWindowId = it.next();
		System.out.println(MainWindowids);
		System.out.println(tabbedWindowId);
		while (it.hasNext())
			;
		// System.out.println(it.next());
		dr.switchTo().window(tabbedWindowId);// switch to the the chat box
		Thread.sleep(15000L);
		//chatPopUpBox_VernonsLogo
		
		Assert.assertTrue(getObject("chatPopUpBox_VernonsLogo").isDisplayed());
//		getObject("chat_textbox").sendKeys("Hello");// input hello in the chat
//													// box
//
//		getObject("chat_textbox").sendKeys(Keys.ENTER);

	}

	@AfterMethod
	public void close() {
		quit();

	}
}