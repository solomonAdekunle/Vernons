package Suite2;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import Util.TestUtil;
import Base.TestBase;

public class CasinoVernons_Homepage extends TestBase {
	@BeforeTest
	public void initLogs() throws FileNotFoundException {
		// initLogs(this.getClass());
		init();

	}

	@Test//(enabled = false)
	public void HeaderElmentstest() throws InterruptedException {
		openBrowser(Config.getProperty("browserType"));
		dr.get(Config.getProperty("testsiteName"));
		dr.manage().window().maximize();
		Thread.sleep(2000L);
		// verifying that Vernos Logo is display on the page
		Object logo = getObject("homepage_vernonslogo").isDisplayed();
		if (getObject("homepage_vernonslogo").isDisplayed())// if Logo is
															// display on the
															// home page
			System.out.println(logo);
		else
			System.out.println(false);

		// verify that help link can be clicked on the header region
		getObject("help").click();
		// the link should navigate to contact-us page, if link does not then
		// system should print False in the Console
		if (dr.getCurrentUrl().equals("https://www.vernons.com/contact-us")) {
			System.out.println(true);
		} else
			System.out.println(false);
		dr.navigate().back();
		// verifying that the chat box open
		WebDriverWait wait = new WebDriverWait(dr, 30);
		wait.until(ExpectedConditions
				.elementToBeClickable(By.cssSelector("a.betssonChatLink")));
		getObject("chat").click();// clicking on the chat link on the
											// page
		// verifying that the chat box open
		Set<String> Windowids = dr.getWindowHandles();
		Iterator<String> it = Windowids.iterator();
		String MainWindowids = it.next();
		String tabbedWindowId = it.next();
		System.out.println(MainWindowids);
		System.out.println(tabbedWindowId);
		while (it.hasNext());
		
		// switch to the the chat box
		dr.switchTo().window(tabbedWindowId);
		Thread.sleep(200);
		/* Check if Chat pop-up box is launched */
		Assert.assertTrue(getObject("chatPopUpBox_VernonsLogo").isDisplayed());

		// if chat box does not open the test must throw an error
	}

	@Test//(enabled = false)
	public void GameCategorytest() throws InterruptedException {
		// verify that when clicking on each game in the GameCategory it will
		// navigate to each game home page.
		openBrowser(Config.getProperty("browserType"));
		dr.get(Config.getProperty("testsiteName"));
		dr.manage().window().maximize();
		// TestUtil.doLogin("Solomon2015", "London03");
		Thread.sleep(2000L);
		getObject("hp_casinoplayNow").click();// click on play now button in the
												// casino
		Thread.sleep(2000L);
		if (dr.getCurrentUrl().equals("https://casino.vernons.com/"))
			System.out.println(true);
		else
			System.out.println(false);
		dr.navigate().back();
		getObject("hp_casinoJoinNow").click();// click on more info link
		Thread.sleep(2000L);
		System.out.println(dr.getCurrentUrl());
		if (dr.getCurrentUrl().equals("https://casino.vernons.com/register"))
			System.out.println(true);
		else
			System.out.println(false);
		dr.navigate().back();
		getObject("hp_BingoJoinNow").click();
		Thread.sleep(4000L);
		System.out.println(dr.getCurrentUrl());
		if (dr.getCurrentUrl().equals("http://bingo.vernons.com/joinnow"))
			System.out.println(true);
		else
			System.out.println(false);
		dr.navigate().back();
		getObject("hp_BinggoplayNow").click();
		Thread.sleep(2000L);
		System.out.println(dr.getCurrentUrl());
		if (dr.getCurrentUrl().equals("http://bingo.vernons.com/"))
			System.out.println(true);
		else
			System.out.println(false);
		dr.navigate().back();
		Thread.sleep(6000L);
		getObject("hp_SportPlayNow").click();
		System.out.println(dr.getCurrentUrl());
		if (dr.getCurrentUrl().equals("http://sports.vernons.com/en/"))
			System.out.println(true);
		else
			System.out.println(false);
		dr.navigate().back();
		Thread.sleep(2000L);
		getObject("hp_SportJoinNow").click();
		Thread.sleep(2000L);
		System.out.println(dr.getCurrentUrl());
		if (dr.getCurrentUrl().equals("https://www.vernons.com/promotions/risk-free-bet-welcome-offer"))
			System.out.println(true);
		else
			System.out.println(false);
		dr.navigate().back();
		Thread.sleep(2000L);
		getObject("casino").click();
		System.out.println(dr.getCurrentUrl());
		if (dr.getCurrentUrl().equals("https://casino.vernons.com/"))
			System.out.println(true);
		else
			System.out.println(false);

		}

	@Test//(enabled = false)
	public void footerElementsTest() throws InterruptedException {
		openBrowser(Config.getProperty("browserType"));
		dr.get(Config.getProperty("testsiteName"));
		// verifying if aboutus link will navigate to aboutus home page
		getObject("aboutUs").click();
		Thread.sleep(3000L);
		String text = dr.findElement(By.xpath("//*[@id='content-header']/h1")).getText();
		if (text.equals("ABOUT VERNONS"))
			System.out.println("navigated to the right page");
		else
			System.out.println("PAGE NOT FOUND");
		dr.navigate().back();
		getObject("affilates").click();
		dr.navigate().back();
		// VERIFYING CONTACT US LINK NAVIGATED TO CONTACT US PAGE
		getObject("contactUs").click();
		String textc = dr.findElement(By.xpath("//*[@id='content-header']/h1")).getText();
		if (textc.equals("CONTACT US"))
			System.out.println("navigated to the right page");
		else
			System.out.println("PAGE NOT FOUND");
		dr.navigate().back();
		// VERIFYING ENJOY RESPONSIBLY LINK NAVIGATED TO ENJOY RESPONSIBLY PAGE
		getObject("enjoyResponsible").click();
		String texte = dr.findElement(By.xpath("//*[@id='content-header']/h1")).getText();
		if (texte.equals("ENJOY RESPONSIBLY"))
			System.out.println("navigated to the right page");
		else
			System.out.println("PAGE NOT FOUND");
		dr.navigate().back();
		// VERIFYING HELP&FAQS PAGE LINK NAVIGATED TO HELP&FAQS PAGE
		getObject("helps&FAQS").click(); // clicking on Helps&FAQS link
		String texth = dr.findElement(By.xpath("//*[@id='content-header']/h1")).getText();
		if (texth.equals("FAQS"))
			System.out.println("navigated to the right page");
		else
			System.out.println("PAGE NOT FOUND");
		dr.navigate().back();
		// VERIFYING PRIVACY POLICY LINK NAVIGATED PRIVACY POLICY PAGE
		getObject("privacyPolicy").click(); // Clicking on Privacy Policy link
		String textP = dr.findElement(By.xpath("//*[@id='content-header']/h1")).getText();
		if (textP.equals("PRIVACY POLICY"))
			System.out.println("navigated to the right page");
		else
			System.out.println("PAGE NOT FOUND");
		dr.navigate().back();
		// VERIFYING Terms link in the Navigated to the Terms &Conditions Page
		getObject("terms").click();// click on Terms link
		String textT = dr.findElement(By.xpath("//*[@id='content-header']/h1")).getText();
		if (textT.equals("TERMS & CONDITIONS"))
			System.out.println("navigated to the right page");
		else
			System.out.println(" term PAGE NOT FOUND");
		dr.navigate().back();

	}

	@Test//(enabled = false)
	public void footerElement2test() throws InterruptedException {
		openBrowser(Config.getProperty("browserType"));
		dr.get(Config.getProperty("testsiteName"));
		getObject("footer_NetplayTV").click();
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
		if (dr.getCurrentUrl().equals("http://www.netplaytv.com/"))
			System.out.println(true);
		else
			System.out.println(false);
		Thread.sleep(2000L);
		dr.switchTo().window(MainWindowids);
		getObject("footer_18+").click();// clicking on 18+logo
		String texte = dr.findElement(By.xpath("//*[@id='content-header']/h1")).getText();
		if (texte.equals("ENJOY RESPONSIBLY"))
			System.out.println(true);
		else
			System.out.println("PAGE NOT FOUND");
		dr.navigate().back();

	}

	@Test//(enabled = false)
	public void GCtest() throws InterruptedException {
		openBrowser(Config.getProperty("browserType"));
		dr.get(Config.getProperty("testsiteName"));
		getObject("footer_GamblinCom").click();
		Set<String> Windowids2 = dr.getWindowHandles();
		Iterator<String> it2 = Windowids2.iterator();
		String MainWindowids2 = it2.next();
		String tabbedWindowId2 = it2.next();
		System.out.println(MainWindowids2);
		System.out.println(tabbedWindowId2);
		while (it2.hasNext())
			;
		// System.out.println(it.next());
		dr.switchTo().window(tabbedWindowId2);
		if (dr.getCurrentUrl().equals(
				"https://secure.gamblingcommission.gov.uk/gccustomweb/PublicRegister/PRAccountDetails.aspx?accountNo=39144"))
			System.out.println(true);
		else
			System.out.println(false);
		dr.switchTo().window(MainWindowids2);
		Thread.sleep(2000L);
		getObject("footer_GamCare").click();
		Set<String> Windowids = dr.getWindowHandles();
		Iterator<String> it = Windowids.iterator();
		String MainWindowids = it.next();
		String tabbedWindowId = it.next();
		// System.out.println(MainWindowids);
		// System.out.println(tabbedWindowId);
		// while(it.hasNext());
		// System.out.println(it.next());
		dr.switchTo().window(tabbedWindowId);
		Thread.sleep(2000L);
		if (dr.getCurrentUrl().equals("http://www.gamcare.org.uk/")) {
			System.out.println(dr.getCurrentUrl());
		} else
			System.out.println(false);

	}
	
	/* Content Blocks are Content Tabs that are displayed on Casino Vernons Vertical Home Page 
	 *  This is Located Below the Games Category and just above the Footer links.
	 */

	@Test//(enabled = false)
	public void contentblockHPtest() throws InterruptedException {
		openBrowser(Config.getProperty("browserType"));
		dr.get(Config.getProperty("testsiteName"));
		dr.manage().window().maximize();
		getObject("casino").click();
		WebElement RouletteTabContentBlock = getObject("rouletteTab_contentblock");
		Actions make = new Actions(dr);
		make.moveToElement(RouletteTabContentBlock).click().perform();
		WebElement RouletteGameContentBlock = getObject("rouletteGame_rouletteContentblock");
		WebDriverWait wait = new WebDriverWait(dr, 35);
		wait.until(ExpectedConditions
				.presenceOfElementLocated(By.xpath(OR.getProperty("rouletteGame_rouletteContentblock"))));
		((JavascriptExecutor) dr).executeScript("arguments[0].click();", RouletteGameContentBlock);
		String texte = dr.findElement(By.xpath("//*[@id='content-header']/h1")).getText();
		if (texte.equals("TABLE GAMES"))
			System.out.println(true);
		else
			System.out.println("PAGE NOT FOUND");
		dr.navigate().back();
		WebElement PopularGameContentBlock = getObject("popularGames_contblock");
		((JavascriptExecutor) dr).executeScript("arguments[0].click();", PopularGameContentBlock);
		String textgames = dr.findElement(By.xpath("//*[@id='content-header']/h1")).getText();
		if (textgames.equals("POPULAR GAMES"))
			System.out.println(true);
		else
			System.out.println("PAGE NOT FOUND");
		dr.navigate().back();
		Thread.sleep(2000);

	}

	@Test//(enabled = false)
	public void contentblockHP1test() throws InterruptedException {
		openBrowser(Config.getProperty("browserType"));
		dr.get(Config.getProperty("testsiteName"));
		dr.manage().window().maximize();
		getObject("casino").click();
		WebDriverWait wait = new WebDriverWait(dr, 35);
		WebElement OnlineCasinTabGameContentBlock = getObject("onlineCasinoGames_contentblock");
		wait.until(ExpectedConditions
				.presenceOfElementLocated(By.xpath(OR.getProperty("onlineCasinoGames_contentblock"))));
		((JavascriptExecutor) dr).executeScript("arguments[0].click();", OnlineCasinTabGameContentBlock);
		wait.until(ExpectedConditions.visibilityOf(OnlineCasinTabGameContentBlock));
		((JavascriptExecutor) dr).executeScript("arguments[0].click();", OnlineCasinTabGameContentBlock);
		Thread.sleep(2000);
		WebElement TableGameContentBlock = getObject("tableGames_contentblock");
		((JavascriptExecutor) dr).executeScript("arguments[0].click();", TableGameContentBlock);
		String texttable = dr.findElement(By.xpath("//*[@id='content-header']/h1")).getText();
		if (texttable.equals("TABLE GAMES"))
			System.out.println(true);
		else
			System.out.println("PAGE NOT FOUND");
		dr.navigate().back();
	}

	@Test//(enabled = false)
	public void contentblockHP2test() throws InterruptedException {
		openBrowser(Config.getProperty("browserType"));
		dr.get(Config.getProperty("testsiteName"));
		dr.manage().window().maximize();
		getObject("casino").click();
		WebDriverWait wait = new WebDriverWait(dr, 30);
		WebElement OnlineCasinTabGameContentBlock = getObject("onlineCasinoGames_contentblock");
		wait.until(ExpectedConditions
				.presenceOfElementLocated(By.xpath(OR.getProperty("onlineCasinoGames_contentblock"))));
		((JavascriptExecutor) dr).executeScript("arguments[0].click();", OnlineCasinTabGameContentBlock);
		Thread.sleep(2000);
		WebElement CasinoGameContentBlock = getObject("onlineCasinoGames_casinoSlots");
		((JavascriptExecutor) dr).executeScript("arguments[0].click();", CasinoGameContentBlock);
		String textslot = dr.findElement(By.xpath("//*[@id='content-header']/h1")).getText();
		if (textslot.equals("SLOTS"))
			System.out.println(true);
		else
			System.out.println("PAGE NOT FOUND");
		Thread.sleep(2000);
		dr.navigate().back();
	}

	@Test//(enabled = false)
	public void contentblockHP3test() throws InterruptedException {
		openBrowser(Config.getProperty("browserType"));
		dr.get(Config.getProperty("testsiteName"));
		dr.manage().window().maximize();
		getObject("casino").click();
		WebDriverWait wait = new WebDriverWait(dr, 30);
		WebElement OnlineCasinTabGameContentBlock = getObject("onlineCasinoGames_contentblock");
		wait.until(ExpectedConditions
				.presenceOfElementLocated(By.xpath(OR.getProperty("onlineCasinoGames_contentblock"))));
		((JavascriptExecutor) dr).executeScript("arguments[0].click();", OnlineCasinTabGameContentBlock);
		Thread.sleep(2000);
		WebElement OnlineCasinoProgressiveGameContentBlock = getObject("onlineCasinoGames_progressiveJackpots");
		((JavascriptExecutor) dr).executeScript("arguments[0].click();", OnlineCasinoProgressiveGameContentBlock);
		String textJACKPOT = dr.findElement(By.xpath("//*[@id='content-header']/h1")).getText();
		if (textJACKPOT.equals("JACKPOTS"))
			System.out.println("JACKPOTS");
		else
			System.out.println("PAGE NOT FOUND");
		dr.navigate().back();

	}

	@Test //(enabled=false)
	public void contentblockHP4test() throws InterruptedException {
		openBrowser(Config.getProperty("browserType"));
		dr.get(Config.getProperty("testsiteName"));
		dr.manage().window().maximize();
		getObject("casino").click();
		WebDriverWait wait = new WebDriverWait(dr, 30);
		WebElement OnlinePromotionTabGameContentBlock = getObject("CasinoPromotion_contentblock");
		wait.until(
				ExpectedConditions.presenceOfElementLocated(By.xpath(OR.getProperty("CasinoPromotion_contentblock"))));
		((JavascriptExecutor) dr).executeScript("arguments[0].click();", OnlinePromotionTabGameContentBlock);
		WebElement OnlinePromotionCasinoContentBlock = getObject("casinoPromotions_casinoPromo_CB");
		wait.until(ExpectedConditions
				.presenceOfElementLocated(By.xpath(OR.getProperty("casinoPromotions_casinoPromo_CB"))));
		((JavascriptExecutor) dr).executeScript("arguments[0].click();", OnlinePromotionCasinoContentBlock);
		String textpromo = dr.findElement(By.xpath("//*[@id='content-header']/h1")).getText();
		if (textpromo.equals("PROMOTIONS"))
			System.out.println("PROMOTIONS");
		else
			System.out.println("PAGE NOT FOUND");

	}

	@Test//(enabled=false)
	public void contentblockHP5test() throws InterruptedException {
		openBrowser(Config.getProperty("browserType"));
		dr.get(Config.getProperty("testsiteName"));
		dr.manage().window().maximize();
		getObject("casino").click();
		WebElement OnlineCasinTabGameContentBlock = getObject("onlineCasinoGames_contentblock");
		WebDriverWait wait = new WebDriverWait(dr, 30);
		wait.until(ExpectedConditions
				.presenceOfElementLocated(By.xpath(OR.getProperty("onlineCasinoGames_contentblock"))));
		((JavascriptExecutor) dr).executeScript("arguments[0].click();", OnlineCasinTabGameContentBlock);
		Thread.sleep(2000);
		WebElement OnlineCasinoCardGameContentBlock = getObject("onlineCasinoGames_cardGames_CB");
		((JavascriptExecutor) dr).executeScript("arguments[0].click();", OnlineCasinoCardGameContentBlock);
		String textCARD = dr.findElement(By.xpath("//*[@id='content-header']/h1")).getText();
		if (textCARD.equals("CARD GAMES"))
			System.out.println("CARD GAMES");
		else
			System.out.println("PAGE NOT FOUND");

	}

	@Test //(enabled=false)
	public void contentblockHP6test() throws InterruptedException {
		openBrowser(Config.getProperty("browserType"));
		dr.get(Config.getProperty("testsiteName"));
		dr.manage().window().maximize();
		getObject("casino").click();
		WebDriverWait wait = new WebDriverWait(dr, 30);
		WebElement OnlinePromotionTabGameContentBlock = getObject("CasinoPromotion_contentblock");
		wait.until(
				ExpectedConditions.presenceOfElementLocated(By.xpath(OR.getProperty("CasinoPromotion_contentblock"))));
		((JavascriptExecutor) dr).executeScript("arguments[0].click();", OnlinePromotionTabGameContentBlock);
		Thread.sleep(2000L);
		WebElement OnlinePromotionVIPMemberContentBlock=dr.findElement(By.cssSelector("div.view-home-page-content-block a[href='/vip']"));
		wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("div.view-home-page-content-block a[href='/vip']")));
		((JavascriptExecutor) dr).executeScript("arguments[0].click();", OnlinePromotionVIPMemberContentBlock);
		/* Check if user naviagted to VIP Page */
		String textvp = dr.findElement(By.xpath("//*[@id='content-header']/h1")).getText();
		if (textvp.equals("VIP"))
			System.out.println("VIP");
		else
			System.out.println("PAGE NOT FOUND");
	}

	@Test// (enabled=false)
	public void contentblockHP7test() throws InterruptedException {
		openBrowser(Config.getProperty("browserType"));
		dr.get(Config.getProperty("testsiteName"));
		dr.manage().window().maximize();
		getObject("casino").click();
		WebElement OnlineCasinTabGameContentBlock = getObject("onlineCasinoGames_contentblock");
		WebDriverWait wait = new WebDriverWait(dr, 30);
		wait.until(ExpectedConditions
				.presenceOfElementLocated(By.xpath(OR.getProperty("onlineCasinoGames_contentblock"))));
		((JavascriptExecutor) dr).executeScript("arguments[0].click();", OnlineCasinTabGameContentBlock);
		WebElement OnlineCasinoLiveGameContentBlock = getObject("onlineCasinoGames_LiveonlineBlackjack_CB");
		((JavascriptExecutor) dr).executeScript("arguments[0].click();", OnlineCasinoLiveGameContentBlock);
		String textBLACKJACK = dr.findElement(By.xpath("//*[@id='content-header']/h1")).getText();
		if (textBLACKJACK.equals("LIVE CASINO"))
			System.out.println("LIVE CASINO");
		else
			System.out.println("PAGE NOT FOUND");
	}

	@AfterMethod
	public void close() {
		quit();

	}
}
