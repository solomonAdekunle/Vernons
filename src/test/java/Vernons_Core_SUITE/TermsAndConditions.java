package Vernons_Core_SUITE;

import java.io.FileNotFoundException;
import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.internal.Coordinates;
import org.openqa.selenium.internal.Locatable;
import org.openqa.selenium.support.events.internal.EventFiringMouse;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import Util.MyListners;
import Util.TestUtil;
import Base.TestBase;

public class TermsAndConditions  extends TestBase{
	
	@BeforeTest
	public void initLogs() throws FileNotFoundException{
		//initLogs(this.getClass());
		init();
	
		
	}
	 @Test(enabled=false)
	  public void termsAndconidtionstest(){
		openBrowser(Config.getProperty("browserType"));
		 dr.get(Config.getProperty("testsiteName"));
		// dr.manage().window().maximize();
		 getObject("hp_casinoJoinNow").click();
		 MyListners myListener = new MyListners();
			driver.register(myListener);
			EventFiringMouse mouse = new EventFiringMouse(driver , myListener);
			// Move Mouse
			Locatable hoverItem = (Locatable) driver.findElement(By.xpath("//*[@id='terms-description']/p/a[2]"));
			Coordinates c= hoverItem.getCoordinates();
			try{
				mouse.mouseMove(c);
			}catch(Exception e1){
				
				
			}
			// right click on Terms&Conditions
			driver.findElement(By.xpath("//*[@id='terms-description']/p/a[2]")).sendKeys(Keys.chord(Keys.SHIFT,Keys.F10));
			// cordinate
			Point p=driver.findElement(By.xpath("//*[@id='terms-description']/p/a[2]")).getLocation();
			System.out.println(p.x);
			System.out.println(p.y);
	 }
	 
	 @Test
	 public void Termspagetest() throws InterruptedException{
		 openBrowser(Config.getProperty("browserType"));
		 dr.get(Config.getProperty("testsiteName"));
		 dr.manage().window().maximize();
		 getObject("hp_casinoJoinNow").click();
		 
		 WebElement TermsLink=getObject("terms");
		 WebDriverWait wat = new WebDriverWait(dr,10);
			wat.until(ExpectedConditions.presenceOfElementLocated(By.xpath(OR.getProperty("terms"))));
			((JavascriptExecutor) dr).executeScript("arguments[0].click();", TermsLink);
		// getObject("terms").click();
		 
	 }
	 @AfterMethod
		public void close(){
			quit();
		
	 }

}
