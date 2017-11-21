package Suite2;

import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.log4j.Logger;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import Base.TestBase;

public class WinnersAND_Vip extends TestBase {

	@BeforeTest
	public void initLogs() throws FileNotFoundException{
		//initLogs(this.getClass());
		init();
		  
	  }
		
	
	
	@Test
	public void viptest() throws InterruptedException{
		 openBrowser(Config.getProperty("browserType"));
		dr.get(Config.getProperty("testsiteName"));
		dr.manage().window().maximize();
		Logger APP_LOGS = Logger.getLogger("devpinoyLogger");
		APP_LOGS.debug("Correct");
		getObject("casino").click();
		getObject("vip").click();// CLICK ON VIP LINK ON THE CASINO HOMEPAGE
		// VERIFY THAT THE TITLE NAVIGATED TO IS VIP HOMEPAGE
		String title= getObject("tVip").getText();
		if((title).equals("VIP"))
			System.out.println(true);
	else
		System.out.println(false);
		 getObject("vip_promotions").click();// CLCK ON PROMOTION LINK ON THE VIP PAGE
		 Thread.sleep(1000L);
		 getObject("vip_events").click();// CLICK ON EVENT LINK ON VIP PAGE
		 Thread.sleep(1000L);
		 getObject("vip_winner").click();// CLICK ON WINNERS ON VIP PAGE
		 Thread.sleep(1000L);
		 getObject("vip_loyaltyPoints").click();
		 Thread.sleep(1000L);
		 getObject("vip_benefit").click();
		 Thread.sleep(1000L);
		 getObject("vip_managerVIP").click();
		
	}
	@Test
	public void winnertabtest(){
		 openBrowser(Config.getProperty("browserType"));
		dr.get(Config.getProperty("testsiteName"));// NAVIGATE TO THE WEBSITE
		dr.manage().window().maximize();
		Logger APP_LOGS = Logger.getLogger("devpinoyLogger");
		APP_LOGS.debug("Correct");
		// VERIFYING THAT USER CAN NAVIGATE TO THE VIP PAGE
		getObject("casino").click();// CLICK ON CASINO LINK
		getObject("winners").click();// CLICK ON WINNERS LINK
		String title= getObject("twinners").getText();// CHECKING IF THE TITLE PAGE NAVIAGTED TO IS WINNERS
		if((title).equals("WINNERS"))
			APP_LOGS.debug(true);
			//System.out.println(true);
	else
		//System.out.println(false);
		
		dr.close();
		
	}
	}



