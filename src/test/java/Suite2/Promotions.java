package Suite2;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import Base.TestBase;

public class Promotions extends TestBase {
	
	
	@BeforeTest
	public void initLogs() throws FileNotFoundException{
		//initLogs(this.getClass());
		init();
		  
	  }
	
	// am verifying that the all links on the promotions page can be clicked and navigated to
	@Test//(enabled=false)
	public void allPromotiontest() throws InterruptedException{
		System.out.println("checking the all promotions link");
		openBrowser(Config.getProperty("browserType"));
		doDefaultLogin("Username"); // login in with the following username and Password
		Thread.sleep(2000L);
		getObject("casino").click();
		Thread.sleep(2000L);
		getObject("promotions").click();
		Thread.sleep(2000L);
		
		 WebElement promo=dr.findElement(By.cssSelector("div.view-promotions"));
		   List <WebElement> Promlist=promo.findElements(By.cssSelector("div.promo"));
		   
		   System.out.println(Promlist.size());
		   
		   for(int i=0; i < Promlist.size(); i++) {
			   
			   System.out.println(i);
			   // Repolulate  the list of all the Elements on all the banner.
			    promo=dr.findElement(By.cssSelector("div.view-promotions"));
			   Promlist = promo.findElements(By.cssSelector("div.promo"));
			   WebElement promotion = Promlist.get(i);
					   
			   //get promotion title
			   String promotionTitle = promotion.findElement(By.cssSelector(".promotion-title a")).getText();
			   System.out.println(promotionTitle);
//			   
//			   //navigate
		 WebElement Button1=promotion.findElement(By.cssSelector("a.promo-more-info"));
		 	Button1.click();
  		 //get page title
		 	String pagetitle=dr.findElement(By.cssSelector("h1.title")).getText();
		 	Thread.sleep(200);
		 	System.out.println(pagetitle);
		 	if(pagetitle.equalsIgnoreCase(promotionTitle)){
		 		System.out.println(true);
		 		
		 		Thread.sleep(1000);
		 		dr.navigate().back();
		 	}else{
		 		System.out.println(false);
		 		return;

		 	}	
		
		   }
	}
	 @AfterMethod
		public void close(){
			quit();
		
	 }
}
		
		
		
		
		
		
		
		
		


