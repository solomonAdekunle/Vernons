package Suite2;

import java.io.FileNotFoundException;
import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import Util.Constant;
import Base.TestBase;

public class Getting_Started extends TestBase {
	@BeforeTest
	public void initLogs() throws FileNotFoundException{
		//initLogs(this.getClass());
		init();
}
		
	
	// verifying the Getting_StartedLink
	@Test(enabled=false)
	public void HowToGetStartedtest() throws InterruptedException{
		openBrowser(Config.getProperty("browserType"));
		dr.get(Config.getProperty("testsiteName"));
		WebDriverWait wait= new WebDriverWait(dr, 30);
		getObject("home").click();
		Thread.sleep(3000L);
		getObject("casino").click();
		//wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//a[@href='getting-started']")));
		String xpath_menu=Constant.GettingStarted;
		String xpath_submenu=Constant.HowToGetStarted;
		WebElement menu= dr.findElement(By.xpath(xpath_menu));
		WebElement submenu=dr.findElement(By.xpath(xpath_submenu));
		Actions slide= new Actions(dr);
		slide.moveToElement(menu).build().perform();
		submenu.click();
		 Thread.sleep(5000L);
		 //verifying the  JoinNow Links within the content
		 getObject("gettingStared_joinNow").click();
		 Thread.sleep(2000L);
		 // verify if the page navigated to registration page
		 if(dr.getCurrentUrl().equals("https://casino.vernons.com/register"))
			 System.out.println("pass");
		 else
			 System.out.println("fail");
		 dr.navigate().back();
		 Thread.sleep(2000);
		 // verifying the 100%bonus up to �200
		 getObject("gettingStarted_Upto�200Bonus").click();
		 Thread.sleep(1000L);
		 if(dr.getCurrentUrl().equals("https://casino.vernons.com/promotions/welcome-bonus"))
			 System.out.println("pass");
		 else
			 System.out.println("fail");
		 dr.navigate().back();
		 Thread.sleep(2000L);
		 getObject("gettingStarted_onlinecasinogames").click();
		 Thread.sleep(3000L);
		 dr.navigate().back();
		 Thread.sleep(3000L);
		  getObject("gettingStarted_HowToDeposit").click();
		 if(dr.getCurrentUrl().equals("https://casino.vernons.com/getting-started/how-to-deposit"))
			 System.out.println("pass");
		 else
			 System.out.println("fail");
		 Thread.sleep(2000L);
		 dr.navigate().back();
		 Thread.sleep(2000L);
		 getObject("gettingStarted_ourFAQSpage").click();
		 Thread.sleep(3000L);
		 	 if(dr.getCurrentUrl().equals("https://casino.vernons.com/faqs"))
			 System.out.println("pass");
		 else
			 System.out.println("fail");
		 System.out.println(dr.getCurrentUrl());
		 
		 
	}
	
	@Test//(enabled=false)
	public void HowToDeposittest() throws InterruptedException{
		openBrowser(Config.getProperty("browserType"));
		dr.get(Config.getProperty("testsiteName"));
		WebDriverWait wait= new WebDriverWait(dr, 30);
		getObject("casino").click();
		//wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//a[@href='getting-started']")));
		String xpath_menu =Constant.GettingStarted;
		String xpath_submenu =Constant.HowToDeposit;
		WebElement menu= dr.findElement(By.xpath(xpath_menu));
		WebElement submenu=dr.findElement(By.xpath(xpath_submenu));
		Actions slide= new Actions(dr);
		slide.moveToElement(menu).build().perform();
		submenu.click();
		// verify the if user can click Toggle in Visa and click register account link to navigate to register page
		Thread.sleep(2000L);
		getObject("howToDeposit_visatoggle").click();
		Thread.sleep(1000L);
		getObject("howToDeposit_VisaRegAccount").click();
		dr.navigate().back();
		Thread.sleep(2000L);
		// verify thta user can navigate to winner page by clicking more winners buttons on how to deposit page
		getObject("howToDeposit_morewinner").click();
		if(dr.getCurrentUrl().equals("https://casino.vernons.com/winners"))
			 System.out.println("pass");
		 else
			 System.out.println("fail");
		dr.navigate().back();
		Thread.sleep(2000L);
		// verify that user can navigate to FAQS page from  how to deposit page if user click on Visit our FAQS link
		WebElement VisitOurFAQLink=getObject("howToDeposit_FAQS");
		Actions Move =new Actions(dr);
		Move.moveToElement(VisitOurFAQLink).click().perform();
		//getObject("howToDeposit_FAQS").click();
		if(dr.getCurrentUrl().equals("https://casino.vernons.com/faqs"))
			 System.out.println("pass");
		 else
			 System.out.println("fail");
	}
	@Test//(enabled=false)
	public void HowToWithdrawtest() throws InterruptedException{
		openBrowser(Config.getProperty("browserType"));
		dr.get(Config.getProperty("testsiteName"));
		WebDriverWait wait= new WebDriverWait(dr, 30);
		getObject("casino").click();
		//wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//a[@href='getting-started']")));
		String xpath_menu =Constant.GettingStarted;
		String xpath_submenu =Constant.HowToWithdraw;
		WebElement menu= dr.findElement(By.xpath(xpath_menu));
		WebElement submenu=dr.findElement(By.xpath(xpath_submenu));
		Actions slide= new Actions(dr);
		slide.moveToElement(menu).build().perform();
		submenu.click();
		 Thread.sleep(2000L);
		 getObject("howtoWithdraw_FAQS").click();
		 if(dr.getCurrentUrl().equals("https://casino.vernons.com/faqs"))
			 System.out.println("pass");
		 else
			 System.out.println("fail");
		 Thread.sleep(2000L);
		 dr.navigate().back(); 
		 Thread.sleep(3000L);
		 // verifying that user can navigate to contact us page from this page
		 getObject("howToWithdraw_contactvernons_suportTeam").click();
		 if(dr.getCurrentUrl().equals("https://casino.vernons.com/contact-us"))
			 System.out.println("pass");
		 else
			 System.out.println("fail");
		 
		 
	}
	@Test//(enabled=false)
	public void IsMyDepositSafetest() throws InterruptedException{
		openBrowser(Config.getProperty("browserType"));
		dr.get(Config.getProperty("testsiteName"));
		WebDriverWait wait= new WebDriverWait(dr, 30);
		getObject("casino").click();
		//wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//a[@href='getting-started']")));
		String xpath_menu =Constant.GettingStarted;
		String xpath_submenu =Constant.IsMyDepositSafe;
		WebElement menu= dr.findElement(By.xpath(xpath_menu));
		WebElement submenu=dr.findElement(By.xpath(xpath_submenu));
		Actions slide= new Actions(dr);
		slide.moveToElement(menu).build().perform();
		submenu.click();
		
		
	}
	  @Test//(enabled=false)
	  public void ConfirmYourID() throws InterruptedException{
		openBrowser(Config.getProperty("browserType"));
		  dr.get(Config.getProperty("testsiteName"));
			WebDriverWait wait= new WebDriverWait(dr, 30);
			getObject("casino").click();
			//wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//a[@href='getting-started']")));
			String xpath_menu=Constant.GettingStarted;
			String xpath_submenu=Constant.ConfirmYourIdentity;
			WebElement menu= dr.findElement(By.xpath(xpath_menu));
			WebElement submenu=dr.findElement(By.xpath(xpath_submenu));
			Actions slide= new Actions(dr);
			slide.moveToElement(menu).build().perform();
			submenu.click();
			Thread.sleep(2000L);
			 getObject("confirmYourId_customerServiceTeam").click();
			 if(dr.getCurrentUrl().equals("https://casino.vernons.com/contact-us"))
				 System.out.println("pass");
			 else
				 System.out.println("fail");
			 dr.navigate().back(); 
			 Thread.sleep(2000L);
			 // verifying that user can navigate to  FAQS page from this page
			 getObject("confirmYourId_FAQS").click();
			 if(dr.getCurrentUrl().equals("https://casino.vernons.com/faqs"))
				 System.out.println("pass");
			 else
				 System.out.println("fail");
			 
					  
	  }
      @Test//(enabled=false)
      public void securitytest() throws InterruptedException{
    		openBrowser(Config.getProperty("browserType"));
    	  dr.get(Config.getProperty("testsiteName"));
			WebDriverWait wait= new WebDriverWait(dr, 30);
			getObject("casino").click();
			//wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//a[@href='getting-started']")));
			String xpath_menu =Constant.GettingStarted;
			String xpath_submenu =Constant.Security;
			WebElement menu= dr.findElement(By.xpath(xpath_menu));
			WebElement submenu=dr.findElement(By.xpath(xpath_submenu));
			Actions slide= new Actions(dr);
			slide.moveToElement(menu).build().perform();
			submenu.click();
			Assert.assertEquals(dr.getCurrentUrl(), "https://casino.qa.vernons.com/getting-started/security");
			
      }

 	 @AfterMethod
 		public void close(){
 			quit();
 		
 	 }
}



