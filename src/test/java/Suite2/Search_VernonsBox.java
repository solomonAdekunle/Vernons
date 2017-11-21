package Suite2;

import java.io.FileNotFoundException;
import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import Base.TestBase;

public class Search_VernonsBox extends TestBase{
	
	@BeforeTest
	public void initLogs() throws FileNotFoundException{
		//initLogs(this.getClass());
		init();
		  
	  }
		
	
	@Test//(enabled=false)
	public void SearchVernonstest() throws InterruptedException{
		openBrowser(Config.getProperty("browserType"));
		System.out.println("testing the Search Vernons search box Function");
		dr.get(Config.getProperty("testsiteName"));
		dr.manage().window().maximize();
		// verify if the search vernons box will search and display related keyword on the system
		getObject("casino").click();
		Thread.sleep(2000L);
		getObject("search_vernonBox").sendKeys("Promotions");
		getObject("search_vernonsButton").click();
		// verifying that search box return all webelement relating to the  keyword if the  present in the system search box
		boolean search= dr.findElement(By.xpath("//*[@id='block-system-main']/ol/a[1]/li/div/div[1]")).isDisplayed();
		getObject("casino-hold'em-live_search").click();
		//dr.navigate().back();
		Thread.sleep(2000L);
		
		return;
	}
	@Test(enabled=false)
	public void SearchVernonsMPtest() throws InterruptedException{
		System.out.println("testing the Search Vernons search box Function");
		openBrowser(Config.getProperty("browserType"));
		dr.get(Config.getProperty("testsiteName"));
		dr.manage().window().maximize();
		// verify if the search vernons box will search and display related keyword on the system
		getObject("casino").click();
		Thread.sleep(2000L);
		getObject("search_vernonBox").sendKeys("Casino");
		getObject("search_vernonsButton").click();
		getObject("casino-hold'em-live_search").click();
		//dr.navigate().back();
		Thread.sleep(2000L);
		dr.navigate().back();
		// Verifying that each Game Link can be clicked and navigated to
		getObject("searchCasino_casinohold").click();
		dr.navigate().back();
		getObject("searchCasino_casinoTeaser").click();
		dr.navigate().back();
		getObject("searchCasino_welcome2vernons").click();
		dr.navigate().back();
		getObject("searchCasino_CasinoHP").click();
		dr.navigate().back();
		getObject("searchCasino_LiveDealBJ").click();
		dr.navigate().back();
		getObject("searchCasino_FAQS").click();
		dr.navigate().back();
		getObject("searchCasino_GameRule").click();
		dr.navigate().back();
		getObject("searchCasino_Security").click();
		dr.navigate().back();
		getObject("searchCasino_Nextpage").click();
		Thread.sleep(2000L);
		getObject("searchCasino_BlackJackSwitch").click();
		dr.navigate().back();
		getObject("searchCasino_Craps").click();
		dr.navigate().back();
		getObject("searchCasino_GettingStarted").click();
		dr.navigate().back();
		getObject("searchCasino_AmericaRoulette").click();
		dr.navigate().back();
		getObject("searchCasino_WildSpirit").click();
		dr.navigate().back();
		getObject("searchCasino_Baccarat").click();
		dr.navigate().back();
		getObject("saercCasino_LiveRoulette").click();
		dr.navigate().back();
		getObject("searchCasino_preEurRoulette").click();
		dr.navigate().back();
		getObject("searchCasino-Stravaganza").click();
		dr.navigate().back();
		getObject("searchCasino_HeadorTails").click();
		dr.navigate().back();
		getObject("searchCasino_Nextpage2").click();
		Thread.sleep(2000L);
		getObject("searchCasino_NewAR_Roulette").click();
		dr.navigate().back();
		getObject("searchCasino_FunkyMonkey").click();
		dr.navigate().back();
		getObject("searchCasino_Tequila").click();
		dr.navigate().back();
		getObject("searchCasino_MiniRoulette").click();
		dr.navigate().back();
		getObject("searchCasino_JungleBoogie").click();
		dr.navigate().back();
		getObject("searchCasino_GoldRally").click();
		dr.navigate().back();
		getObject("searchCasino_Pre_AmericaRoulette").click();
		dr.navigate().back();
		getObject("searchCasino_QueenOfThePyramaid").click();
		dr.navigate().back();
		getObject("searchCasino_RoulettePro").click();
		dr.navigate().back();
		getObject("searchCasino_BonusBowling").click();
		dr.navigate().back();
		getObject("searchCasino_Nextpage2").click();
		Thread.sleep(2000L);
		getObject("searchCasino_PealitySootout").click();
		dr.navigate().back();
		getObject("searchCasino_GameRule_Blackjack").click();
		dr.navigate().back();
		getObject("searchCasino_MontyPython").click();
		dr.navigate().back();
		getObject("searchCasino_RouletteExpPremium").click();
		dr.navigate().back();
		getObject("searchCasino_DiceTwister").click();
		dr.navigate().back();
		getObject("searchCasino_DoubleAttackBJ").click();
		dr.navigate().back();
		getObject("searchCasino_EurRoulette").click();
		dr.navigate().back();
		getObject("seachCasino_TropicReels").click();
		dr.navigate().back();
		getObject("searchCasino_Nextpage2").click();
		Thread.sleep(2000L);
		getObject("searchCasino_DoubleUpRoulette").click();
		dr.navigate().back();
		getObject("searchCasino_AnightOut").click();
		dr.navigate().back();
		getObject("searchCasino_GameRules").click();
		dr.navigate().back();
		getObject("searchCasino_MultiWheelRoulette").click();
		dr.navigate().back();
		getObject("searchCasino_CashBlox").click();
		dr.navigate().back();
		getObject("searchCasino_Rocky").click();
		dr.navigate().back();
		getObject("searchCasino_keno").click();
		dr.navigate().back();
		getObject("searchCasino_PaiGowPoker").click();
		dr.navigate().back();
		getObject("searchCasino_Nextpage").click();
		Thread.sleep(2000L);
		getObject("searchCasino_MagicSlot").click();
		dr.navigate().back();
		getObject("searchCasino_Crazy7").click();
		dr.navigate().back();
		getObject("searchCasino_SilverBullet").click();
		dr.navigate().back();
		getObject("searchCasino_FrankieDettori").click();
		dr.navigate().back();
		getObject("searchCasino_RouletteExp").click();
		dr.navigate().back();
		getObject("seachCasino_DeucesWild").click();
		dr.navigate().back();
		getObject("searchCasino_ironman").click();
		dr.navigate().back();
		getObject("searchCasino_50Line_jackORBetter").click();
		dr.navigate().back();
		getObject("searchCasino_Nextpage").click();
		Thread.sleep(2000L);
		getObject("searchCasino_Benefit").click();
		dr.navigate().back();
		getObject("searchCasino_HowToWithdraw").click();
		dr.navigate().back();
		getObject("searchCasino_TheSopranos").click();
		dr.navigate().back();
		getObject("searchCasino_Lobby").click();
		dr.navigate().back();
		getObject("searchCasino_POPBingo").click();
		dr.navigate().back();
		getObject("searchCasino_liveTeaser").click();
		dr.navigate().back();
		getObject("searchCasino_CaptainAMerica").click();
		dr.navigate().back();
		getObject("searchCasino_Nextpage").click();
		Thread.sleep(2000L);
		getObject("saerchCasino_DesertTreasureII").click();
		dr.navigate().back();
		getObject("searchCasino_EverybodyJackpot").click();
		dr.navigate().back();
		getObject("searchCasino_LittleBritain").click();
		dr.navigate().back();
		getObject("searchCasino_3DRoulette").click();
		dr.navigate().back();
		getObject("searchCasino_21DuelBlack").click();
		dr.navigate().back();
		getObject("searchCasino_ThrillSeekers").click();
		dr.navigate().back();
		getObject("searchCasino_oceanPrincess").click();
		dr.navigate().back();
		//getObject("searchCasino_Nextpage").click();
		//Thread.sleep(2000L);
		getObject("searchCasino_Beachlife").click();
		dr.navigate().back();
		getObject("searchCasino_Ironman2_50line").click();
		dr.navigate().back();
		getObject("searchCasino_WingsOfGold").click();
		dr.navigate().back();
		getObject("searchCasino_CaribbeanStuddPoker").click();
		dr.navigate().back();
		getObject("searchCasino_RockPaperSci").click();
		dr.navigate().back();
		getObject("searchCasino_10'sORBetter").click();
		dr.navigate().back();
		getObject("searchCasino_deucesWild_4line").click();
		dr.navigate().back();
		getObject("searchCasino_Goblincave").click();
		dr.navigate().back();
		getObject("searchCasino_Nextpage").click();
		Thread.sleep(2000L);
		getObject("searchCasino_TheMummy").click();
		dr.navigate().back();
		getObject("searchCasino_Gadiator").click();
		dr.navigate().back();
		getObject("searchCasino_JohnWanye").click();
		dr.navigate().back();
		getObject("searchCasino_Thor_TheMight_Avenger").click();
		dr.navigate().back();
		getObject("searchCasino_RollerCoasterDice").click();
		dr.navigate().back();
		getObject("searchCasino_jacksORbetter").click();
		dr.navigate().back();
		getObject("searchCasino_GameRules_baccarat").click();
		dr.navigate().back();
		getObject("searchCasino_KingHong").click();
		dr.navigate().back();
		getObject("searchCasino_TresAmigo").click();
		dr.navigate().back();
		getObject("searchCasino_FountainOfYouth").click();
		dr.navigate().back();
		getObject("searchCasino_nextpageTO_11").click();
		Thread.sleep(2000L);
		getObject("searchCasino_FootballFans").click();
		dr.navigate().back();
		getObject("searchCasino_4-LINEjACKSorBETTER").click();
		dr.navigate().back();
		getObject("searchCasino_CaptainTresure").click();
		dr.navigate().back();
		getObject("searchCasino_BermudaTriangle").click();
		dr.navigate().back();
		//getObject("searchCasino_�50Thursday").click();
		//dr.navigate().back();
		getObject("searchcasino_FootballLegends").click();
		dr.navigate().back();
		getObject("searchCasino_Welcom").click();
		
		
		

}
	 @AfterMethod
		public void close(){
			quit();
		
	 }
}