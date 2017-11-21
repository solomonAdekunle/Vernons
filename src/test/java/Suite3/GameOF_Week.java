package Suite3;

import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.log4j.Logger;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import Util.TestUtil;
import Base.TestBase;

public class GameOF_Week  extends TestBase{
	
	
	@BeforeTest
	public void initLogs() throws FileNotFoundException{
		//initLogs(this.getClass());
		init();
		  
	  }
		
	
	@Test//(enabled=false)
	public void gameweektest() throws InterruptedException{
		openBrowser(Config.getProperty("browserType"));
		Thread.sleep(1000);
		doDefaultLogin(Config.getProperty("Username"));
		Logger APP_LOGS = Logger.getLogger("devpinoyLogger");
		APP_LOGS.debug("Correct");
		getObject("casino").click();
		getObject("hp_gameof_TheWeek").click();
		getObject("gladitor_gameoftheWeek_playForReal").click();
		Thread.sleep(2000);
		getObject("queenPry_playforReal").click();
		
		
	}
	
	@AfterMethod
	public void close() {
		quit();

	}
}