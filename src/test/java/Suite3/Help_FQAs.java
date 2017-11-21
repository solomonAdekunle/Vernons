package Suite3;

import java.io.FileNotFoundException;
import java.io.IOException;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import Base.TestBase;

public class Help_FQAs extends TestBase{
	
	@BeforeTest
	public void initLogs() throws FileNotFoundException{
		//initLogs(this.getClass());
		init();
		  
	  }
	
	@Test(enabled=true)
	public void Help_Faqstest() throws InterruptedException{
		openBrowser(Config.getProperty("browserType"));
		doDefaultLogin("Username");
		//dr.get(Config.getProperty("testsiteName"));
		dr.manage().window().maximize();
		getObject("helps&FAQS").click();
		Thread.sleep(3000);
		String title=dr.findElement(By.cssSelector("h1.title")).getText();
		System.out.println(title);
		Assert.assertEquals(title, "FAQS");
		getObject("faqs_regisLiink1").click();
		
		
}
	@AfterMethod
	public void close() {
		quit();

	}
}
