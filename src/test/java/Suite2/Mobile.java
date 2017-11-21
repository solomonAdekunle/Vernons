package Suite2;

import java.io.FileNotFoundException;

import org.openqa.selenium.By;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import Base.TestBase;

public class Mobile extends TestBase {
	  @BeforeTest
	  public void initLogs() throws FileNotFoundException{
			//initLogs(this.getClass());
			init();
	  }
		  
	  	 
	 @Test(enabled=false)
 public void moblietest() throws InterruptedException{
		 openBrowser(Config.getProperty("browserType"));
		 dr.get(Config.getProperty("testsiteName"));
		 dr.manage().window().maximize();
		 getObject("mobile").click();
		 Thread.sleep(2000L);
		 // verifying that the mobile Image is Displayed
		  if(dr.findElement(By.xpath("//*[@id='tall_mobile_app_cta_wrapper']/img[1]")).isDisplayed())// if displayed should print true in the console else it should print false
			  System.out.println(true);
		  else
			  System.out.println(false);
		  // verify that Ipad image is displayed on the page
		if (getObject("mobile_ipad").isDisplayed())// if this is displayed it should print true else print false in the console
			System.out.println(true);
		else
			System.out.println(false);
		 // verify that Vernons Logo image is displayed on the page
		if (getObject("mobile_vernonslogo").isDisplayed())// if this is displayed it should print true else print false in the console
			System.out.println(true);
		else
			System.out.println(false);
		 getObject("mobile_PlayResponsibly").click();
		 // verifying that user navigated to Enjoy responsibly  page
		 String Title= getObject("title_EnjoyResponsibly").getText();
		 if (Title.equals("ENJOY RESPONSIBLY"))
			 System.out.println(Title);
		 else
			 System.out.println(false);
		 dr.navigate().back();
		 Thread.sleep(2000L);
		 // VERIFYING THAT  hOW TO GET SATARTED LINK CAN BE CLICKED AND NAVIGATED TO
		 getObject("mobile_HowToGetStarted").click();
		 String Title1=getObject("title_GettingStarted").getText();// Getting the Title page of the Getting Started Page, if page found it should print true else print false
		 if (Title1.equals("GETTING STARTED"))
			 System.out.println(Title1);
		 else
			 System.out.println(false);
		 dr.navigate().back();
		 Thread.sleep(2000L);
		 // VERIFYING THE IS MY DEPOSIT SAFE LINK WITHIN THE CONTENT CAN BE CLICKED AND NAVIGATED TO
		 getObject("mobile_IsmyDepositSafe").click();
		 String Title2=getObject("title_IsMyDepositSafe").getText();// Getting the Title page of the  IS MY DEPOSIT SAFE Page, if page found it should print true else print false
		 if (Title2.equals("IS MY DEPOSIT SAFE?"))
			 System.out.println(Title2);
		 else
			 System.out.println(false);
		 dr.navigate().back();
		 Thread.sleep(2000L);
		 getObject("mobile_100%welBonusUpTo�200").click();
		 String Title3= getObject("title_100%WelcomeBonus").getText();// Getting the Title page of the  IS MY DEPOSIT SAFE Page, if page found it should print true else print false
		 if (Title3.equals("100% WELCOME BONUS"))
			 System.out.println(Title3);
		 else
			 System.out.println(false);
		 dr.navigate().back();
		 Thread.sleep(2000L);
		 
		 
			 
	 }
}
