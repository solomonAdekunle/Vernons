package Suite2;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.MalformedURLException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import Util.Constant;
import Base.TestBase;

public class GamesRules extends TestBase {
	@BeforeTest
	public void initLogs() throws FileNotFoundException{
		//initLogs(this.getClass());
		init();
	}

	@Test//(enabled=false)
	public void roulettetest() throws InterruptedException, MalformedURLException{
		openBrowser(Config.getProperty("browserType"));
		doDefaultLogin(Config.getProperty("Username"));
		// verify if user can navigate to Roulettes-rules page from  Game rules Tab on Casino page
		Thread.sleep(1000);
		getObject("casino").click();
		String Xpath_menu=Constant.GameRules;
		String Xpath_submenu=Constant.Roulette;
		WebElement menu=dr.findElement(By.xpath(Xpath_menu));
		WebElement submenu=dr.findElement(By.xpath(Xpath_submenu));
		Actions solo= new Actions(dr);
		solo.moveToElement(menu).build().perform();
		submenu.click();
		 Thread.sleep(4000L);
		 // verify that  user can  navigate to  jackpot games page if user clicked more-Jackpot button on the right side bottom of the game-rule roulette page
		 getObject("gamesRules_RouletteMoreJackpots").click();
		// System.out.println(dr.getCurrentUrl());
		 String relativeURL = TestBase.getRelativeUrl(dr.getCurrentUrl());
		 if(relativeURL.equals("/games/jackpots"))
			 System.out.println("pass");
		 else
			 System.out.println("fail");
		 
  }
	
	@Test//(enabled=false)
	public void blackjacjtest() throws InterruptedException, MalformedURLException{
		openBrowser(Config.getProperty("browserType"));
		doDefaultLogin(Config.getProperty("Username"));
		getObject("casino").click();
		// verifying if user can navigate to Games Rules-Blackjack page if user click on blackjack link from Game rules Tab.
		String Xpath_menu=Constant.GameRules;
		String Xpath_submenu=Constant.Blackjack;
		WebElement menu=dr.findElement(By.xpath(Xpath_menu));
		WebElement submenu=dr.findElement(By.cssSelector(Xpath_submenu));
		Actions solo= new Actions(dr);
		solo.moveToElement(menu).build().perform();
		submenu.click();
	// Asserting that the URL address of page navigated  is the Same as the one displayed below the page when playing mouse on it
		 //Thread.sleep(2000L);
		String relativeURL = TestBase.getRelativeUrl(dr.getCurrentUrl());
		Assert.assertEquals(relativeURL,"/game-rules/blackjack");
	}
	@Test//(enabled=false)
	public void baccarattest() throws InterruptedException, MalformedURLException{
		openBrowser(Config.getProperty("browserType"));
		doDefaultLogin(Config.getProperty("Username"));
		getObject("casino").click();
		dr.manage().window();
		String Xpath_menu=Constant.GameRules;
		String Xpath_submenu=Constant.Baccarat;
		Thread.sleep(4000);
		WebElement menu=dr.findElement(By.xpath(Xpath_menu));
		WebElement submenu=dr.findElement(By.xpath(Xpath_submenu));
		Actions solo= new Actions(dr);
		solo.moveToElement(menu).build().perform();
		submenu.click(); 
		String relativeURL = TestBase.getRelativeUrl(dr.getCurrentUrl());
		Assert.assertEquals(relativeURL,"/game-rules/baccarat");
	}
	
	
	 @AfterMethod
		public void close(){
			quit();
		
	 }
	}

