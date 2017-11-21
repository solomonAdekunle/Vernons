package Suite2;

import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import Util.TestUtil;
import Base.TestBase;

public class Live extends TestBase {
	@BeforeTest
	public void initLogs() throws FileNotFoundException{
		//initLogs(this.getClass());
		init();
}
	@Test
	 public void Livetest() throws InterruptedException{
		openBrowser(Config.getProperty("browserType"));
		// Testing all the Functionalities within the Live Home page
		// login in with the following username and Password
		doDefaultLogin("Username"); 
		Logger APP_LOGS = Logger.getLogger("devpinoyLogger");
		APP_LOGS.debug("Correct");
			Thread.sleep(2000L);
		getObject("casino").click();
		Thread.sleep(1000L);
		getObject("live_casino").click();
		Thread.sleep(2000L);
		// click play for real button to lunch a game
		getObject("livecasino_livecasinoHold'EM_playfor_real").click();
		
		
		
		
		
	}
	@AfterMethod
		public void close(){
			quit();
		
	 }
}