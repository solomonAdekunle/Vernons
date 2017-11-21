package Suite2;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import Util.TestUtil;
import Base.TestBase;

public class Casino extends TestBase {
	@BeforeTest
	public void initLogs() throws FileNotFoundException {
		// initLogs(this.getClass());
		init();
	}

	@Test //(enabled=false)
	public void casinogamestest() throws InterruptedException {
		// verifying if user can lunch a game from casino home page
		openBrowser(Config.getProperty("browserType"));
		dr.manage().window().maximize();
		// Login with username and p-assword
		doDefaultLogin(Config.getProperty("Username"));
		Thread.sleep(3000L);
		// clicking on CASINO in the vertical
		getObject("casino").click();
		Thread.sleep(3000L);
		// then click on play Now button in popular game
		getObject("popularGame_REPplayForReal").click();

		dr.getCurrentUrl();
		// verifying thta the current url is the same as the one expected
		if (dr.getCurrentUrl().equals(
				"https://casino.vernons.com/launch/flash/index.php?myGameCode=rep2&myFreePlay=CashMode&cu=GBP&la=en&myBrandCode=bv&myRandm=21664991&gameParams=dW5pcXVlSWQ9d29uV2xiU3R4cEdEaUNRT0ttYXBPLTloelhJTHFkbEFubEJNb19mWlY2NCZnYW1lQXV0aFVybD1odHRwOi8vd3d3LnN0YWdpbmcudmVybm9ucy5jb20vcmVzb3VyY2Uvc2VydmVyL2dhbWVhdXRo&mySubType=rep2_sc_on_bv&myOver=True&t=&connectNPS=no&demoWebChat=no")) {
			System.out.println(true);
		} else {
			System.out.println(false);
			// dr.close();

		}
	}

	// verifying all the links in the pop-up sign in box for casino games
	@Test // (enabled = false)
	public void PopupSignToPlayBoxtest() throws InterruptedException {
		openBrowser(Config.getProperty("browserType"));
		dr.get(Config.getProperty("testsiteName"));
		dr.manage().window().maximize();
		Logger APP_LOGS = Logger.getLogger("devpinoyLogger");
		APP_LOGS.debug("Correct");
		// clicking on CASINO in the vertical
		getObject("casino").click();
		Thread.sleep(3000L);
		// then click on play Now button in popular game
		List<WebElement> eli = dr
				.findElements(By.cssSelector("div#quicktabs-tabpage-game_categories-0 .game-wrapper .play-for-real"));
		System.out.println(eli.size());
		WebDriverWait wait= new WebDriverWait(dr,30);
		wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.cssSelector("div#quicktabs-tabpage-game_categories-0 .game-wrapper .play-for-real")));
		WebElement SecondGame = eli.get(3);
		Actions move = new Actions(dr);
		move.moveToElement(SecondGame).build().perform();
		//((JavascriptExecutor) dr).executeScript("arguments[0].click();", SecondGame);
		SecondGame.click();
		Thread.sleep(5000L);
		// Verifying if user can login through this pop-up box
		dr.findElement(By.cssSelector("div#sb-player #username")).sendKeys("Solomon2015");
		dr.findElement(By.cssSelector("div#sb-player #password")).sendKeys("London03");
		dr.findElement(By.cssSelector("div#sb-player input.form-submit")).click();
		// verifying if user has logged in
		Thread.sleep(1000L);
		String var = dr.findElement(By.xpath("//*[@id='authcache-block-account-my_account_bar']/ul[2]/li[1]"))
				.getText();
		System.out.println(var);
		if (var.equals("Welcome,SOLOMON2015"))
			System.out.println("user has logged in");
		else
			System.out.println("user has not login");
	}

	@Test//(enabled = false)
	public void popup_NewUserlinktest() throws InterruptedException {
		openBrowser(Config.getProperty("browserType"));
		dr.get(Config.getProperty("testsiteName"));
		dr.manage().window().maximize();
		Logger APP_LOGS = Logger.getLogger("devpinoyLogger");
		APP_LOGS.debug("Checking the APP_LOGS");
		getObject("casino").click();// clicking on CASINO in the vertical
		Thread.sleep(3000L);
		// then click on play Now button in popular game
		List<WebElement> eli = dr
				.findElements(By.cssSelector("div#quicktabs-tabpage-game_categories-0 .game-wrapper .play-for-real"));
		System.out.println(eli.size());
		WebElement SecondGame = eli.get(8);
		SecondGame.click();
		WebDriverWait wait= new WebDriverWait(dr,20);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("div#sb-body div a[href='/register']")));
		dr.findElement(By.cssSelector("div#sb-body div a[href='/register']")).click();
		// verify that the page navigated to the Registration page
		if (dr.getCurrentUrl().equals(Config.get("testsiteName") + "/register")) {
			// APP_LOGS.debug("pass");
			System.out.println("pass");
		} else
			// APP_LOGS.debug("fail");
			System.out.println("fail");

	}

	@Test//(enabled = false)
	public void popup_forgottenDtest() throws InterruptedException {
		openBrowser(Config.getProperty("browserType"));
		dr.get(Config.getProperty("testsiteName"));
		Logger APP_LOGS = Logger.getLogger("devpinoyLogger");
		APP_LOGS.debug("Correct");
		// clicking on CASINO in the vertical
		getObject("casino").click();
		Thread.sleep(3000L);
		List<WebElement> eli = dr
				.findElements(By.cssSelector("div#quicktabs-tabpage-game_categories-0 .game-wrapper .play-for-real"));
		System.out.println(eli.size());
		WebElement SecondGame = eli.get(8);
		SecondGame.click();
		Thread.sleep(3000L);
		// click on forgotten details link
		dr.findElement(By.cssSelector("div#sb-body a#forgotten-details-link")).click();
		// verify that the user navigated to forgottenDetails Page
		if (dr.getCurrentUrl().equals("https://casino.vernons.com/forgotten-details"))
			APP_LOGS.debug("PASS");
		// System .out.println("pass");
		else
			APP_LOGS.debug("Fail");
		// System.out.println("fail");

	}

	@AfterMethod
	public void close() {
		quit();

	}
}
