package Suite3;

import java.io.FileNotFoundException;
import java.io.IOException;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import Base.TestBase;

public class About_us extends TestBase {

	@BeforeTest
	public void initLogs() throws FileNotFoundException {
		// initLogs(this.getClass());
		init();

	}

	@Test//(enabled=false)
	public void aboutUStest() {
		/* Get the Browser Type*/
		openBrowser(Config.getProperty("browserType"));
		dr.get(Config.getProperty("testsiteName"));
		dr.manage().window().maximize();
		System.out.println("testing the About-us page");
		getObject("aboutUs").click();
	}
	
	@Test
	public void CheckDeposittest() throws InterruptedException {
		openBrowser(Config.getProperty("browserType"));
		doDefaultLogin("Username");
		Thread.sleep(2000l);
		getObject("hp_Deposit").click();
	}

	 @AfterMethod
		public void close(){
			quit();
		
	 }
}
