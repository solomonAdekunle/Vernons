package Suite2;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import Util.Constant;
import Util.TestUtil;
import Base.TestBase;

public class GamesTab extends TestBase {

	@BeforeTest
	public void initLogs() throws FileNotFoundException {
		// initLogs(this.getClass());
		init();
	}

	// verifying that user can click JoinNow in Hero Banner and navigated to
	// Registration form page
	@Test//(enabled = false)
	public void JNBtest() throws InterruptedException {
		openBrowser(Config.getProperty("browserType"));
		dr.get(Config.getProperty("testsiteName"));
		getObject("casino").click();
		Thread.sleep(2000L);
		getObject("joinNow1").click();
		dr.navigate().back();
		Thread.sleep(2000L);
		WebElement BottomRegisterNowButton=getObject("greenBigJoinNow2");
		Actions move = new Actions(dr);
		move.moveToElement(BottomRegisterNowButton).click().perform();
		
		

	}

	// verifying that game can be lunched in each of the game category tab
	// verifying that the actual game that user want to lunch lunched
	// if any below getCurrenturl().indexof()" return negative number then the
	// test failed but if it returns positive number then the test passed

	@Test(enabled = false)
	public void jackpotstest() throws InterruptedException {
		openBrowser(Config.getProperty("browserType"));
		doDefaultLogin(Config.getProperty("Username"));
		// TestUtil.doLogin("Solomon2015", "London03");
		Thread.sleep(2000L);
		getObject("casino").click();
		getObject("jackpotTab").click();
		Thread.sleep(3000L);
		getObjectFromSelector("jackpotDart_playForReal").click();
		Set<String> Windowids = dr.getWindowHandles();
		Iterator<String> it = Windowids.iterator();
		String MainWindowids = it.next();
		String tabbedWindowId = it.next();
		System.out.println(MainWindowids);
		System.out.println(tabbedWindowId);
		while (it.hasNext())
			;
		// System.out.println(it.next());
		dr.switchTo().window(tabbedWindowId);
		dr.getCurrentUrl();
		System.out.println(dr.getCurrentUrl());
		// System.out.println(dr.getCurrentUrl().indexOf("game=drts"));
		// VERIFYING THAT THE RIGHT GAME LUNCHED
		int y = dr.getCurrentUrl().indexOf("game=drts");
		if (y == -1) {
			System.out.println("fail");
		} else
			System.out.println("pass");
		Thread.sleep(2000);
	}

	// System.out.println(d.getCurrentUrl().indexOf("gamecode=drts"));
	// d.close();

	@Test//(enabled=false)
	public void slottest() throws InterruptedException {
		openBrowser(Config.getProperty("browserType"));
		doDefaultLogin(Config.getProperty("Username"));
		// TestUtil.doLogin("Solomon2015", "London03");
		Thread.sleep(2000L);
		getObject("casino").click();
		Thread.sleep(5000L);
		TestUtil.takeScreenShot("slot");
		try {
			getObject("slot").click();
		} catch (Throwable e) {
			e.getStackTrace();
			System.out.println(e);
		}
		Thread.sleep(3000L);
		List<WebElement> Games = dr.findElements(By.cssSelector("div.playtech-games a.play-for-real"));
		System.out.println(Games.size());
		WebElement SecondGame = Games.get(1);
		((JavascriptExecutor) dr).executeScript("arguments[0].click();", SecondGame);
		Thread.sleep(2000);
		
		Set<String> Windowids = dr.getWindowHandles();
		Iterator<String> it = Windowids.iterator();
		String MainWindowids = it.next();
		String tabbedWindowId = it.next();
		System.out.println(MainWindowids);
		System.out.println(tabbedWindowId);
		while (it.hasNext())
			;
		// System.out.println(it.next());
		dr.switchTo().window(tabbedWindowId);
		dr.getCurrentUrl();
		System.out.println(dr.getCurrentUrl());
		// System.out.println(dr.getCurrentUrl().indexOf("game=gtssmdm"));
		int y = dr.getCurrentUrl().indexOf("game=drts");
		if (y == -1) {
			System.out.println("fail");
		} else
			System.out.println("pass");
		
	}

	@Test//(enabled=false)
	public void tablegamestest() throws InterruptedException {
		openBrowser(Config.getProperty("browserType"));
		doDefaultLogin(Config.getProperty("Username"));
		Thread.sleep(2000L);
		getObject("casino").click();
		getObject("table_Games").click();
		Thread.sleep(3000L);
		getObject("sicBo_palyForReal").click();
		Set<String> Windowids = dr.getWindowHandles();
		Iterator<String> it = Windowids.iterator();
		String MainWindowids = it.next();
		String tabbedWindowId = it.next();
		System.out.println(MainWindowids);
		System.out.println(tabbedWindowId);
		while (it.hasNext())
			;
		// System.out.println(it.next());
		dr.switchTo().window(tabbedWindowId);
		dr.getCurrentUrl();
		System.out.println(dr.getCurrentUrl());
		System.out.println(dr.getCurrentUrl().indexOf("game=sb"));
		int y = dr.getCurrentUrl().indexOf("game=sb");
		if (y == -1) {
			System.out.println("fail");
		} else
			System.out.println("pass");
		Thread.sleep(2000);
	}

	@Test//(enabled=false)
	public void cardgamestest() throws InterruptedException {
		openBrowser(Config.getProperty("browserType"));
		doDefaultLogin(Config.getProperty("Username"));
		Logger APP_LOGS = Logger.getLogger("devpinoyLogger");
		APP_LOGS.debug("Correct");
		Thread.sleep(2000L);
		getObject("casino").click();
		getObject("card_Games").click();
		Thread.sleep(3000L);
		getObject("dualBlackjak21").click();
		Set<String> Windowids = dr.getWindowHandles();
		Iterator<String> it = Windowids.iterator();
		String MainWindowids = it.next();
		String tabbedWindowId = it.next();
		System.out.println(MainWindowids);
		System.out.println(tabbedWindowId);
		while (it.hasNext())
			;
		// System.out.println(it.next());
		dr.switchTo().window(tabbedWindowId);
		dr.getCurrentUrl();
		System.out.println(dr.getCurrentUrl());
		System.out.println(dr.getCurrentUrl().indexOf("game=bjuk_mh5"));
		int y = dr.getCurrentUrl().indexOf("game=bjuk_mh5");
		if (y == -1) {
			System.out.println("fail");
		} else
			System.out.println("pass");
		Thread.sleep(2000);

	}

	@Test//(enabled=false)
	public void livecasinotest() throws InterruptedException {
		openBrowser(Config.getProperty("browserType"));
		doDefaultLogin(Config.getProperty("Username"));
		Logger APP_LOGS = Logger.getLogger("devpinoyLogger");
		APP_LOGS.debug("Correct");
		// TestUtil.doLogin("Solomon2015", "London03");
		Thread.sleep(2000L);
		getObject("casino").click();
		getObject("live_casino").click();
		Thread.sleep(3000L);
		getObject("casinoLiveCasino_LiveDealerBlackjackplayforReal").click();
		Set<String> Windowids = dr.getWindowHandles();
		Iterator<String> it = Windowids.iterator();
		String MainWindowids = it.next();
		String tabbedWindowId = it.next();
		System.out.println(MainWindowids);
		System.out.println(tabbedWindowId);
		while (it.hasNext());
		// System.out.println(it.next());
		dr.switchTo().window(tabbedWindowId);
		dr.getCurrentUrl();
		System.out.println(dr.getCurrentUrl());
		System.out.println(dr.getCurrentUrl().indexOf("game=sb"));
		int y = dr.getCurrentUrl().indexOf("game=sb");
		if (y == -1) {
			System.out.println("fail");
		} else
			System.out.println("pass");
		Thread.sleep(2000);

	}

	@Test//(enabled = false)
	public void AllGamestest() throws InterruptedException {
		openBrowser(Config.getProperty("browserType"));
		//dr.get(Config.getProperty("testsiteName"));
		Logger APP_LOGS = Logger.getLogger("devpinoyLogger");
		APP_LOGS.debug("Correct");
		doDefaultLogin(Config.getProperty("Username"));
		Thread.sleep(2000L);
		getObject("casino").click();
		getObject("all").click();
		Thread.sleep(5000L);
	 List <WebElement> Games=dr.findElements(By.cssSelector(OR.getProperty("playtechGames_Selector")));
	 WebElement AnyGame=Games.get(5);
		((JavascriptExecutor) dr).executeScript("arguments[0].click();", AnyGame);
	 // AnyGame.click();
		Set<String> Windowids = dr.getWindowHandles();
		Iterator<String> it = Windowids.iterator();
		String MainWindowids = it.next();
		String tabbedWindowId = it.next();
		System.out.println(MainWindowids);
		System.out.println(tabbedWindowId);
		while (it.hasNext())
			;
		// System.out.println(it.next());
		dr.switchTo().window(tabbedWindowId);
		dr.getCurrentUrl();
		System.out.println(dr.getCurrentUrl());
		System.out.println(dr.getCurrentUrl().indexOf("game=gtsstg"));
		int y = dr.getCurrentUrl().indexOf("game=gtsstg");
		if (y == -1) {
			System.out.println("fail");
		} else
			System.out.println("pass");
		Thread.sleep(2000);

	}

	@Test//(enabled = false)
	public void Gamesearchboxtest() throws InterruptedException {
		openBrowser(Config.getProperty("browserType"));
		doDefaultLogin(Config.getProperty("Username"));
		Logger APP_LOGS = Logger.getLogger("devpinoyLogger");
		APP_LOGS.debug("Correct");
		getObject("casino").click();
		Thread.sleep(2000);
		getObject("gamesSearch_inputbox").sendKeys("Little Britain");
		getObject("gamesSearch_inputbox").sendKeys(Keys.ENTER);
		Thread.sleep(2000);
		// Verify that the system will return the actual game searched for.
		String Game_tile = dr.findElement(By.xpath(Constant.LittleBritain)).getText();
		APP_LOGS.debug(Game_tile);
		if ("Little Britain".equals("Game_title"))
			APP_LOGS.debug(true);
		// System.out.println(true);
		else
			APP_LOGS.debug(false);
		// System.out.println(false);
		Thread.sleep(2000);

	}

	@AfterMethod
	public void close() throws InterruptedException {
		Thread.sleep(2000);
		quit();

	}

}