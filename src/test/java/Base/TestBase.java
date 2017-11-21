package Base;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.commons.lang3.RandomStringUtils;
import org.apache.log4j.FileAppender;
import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.apache.log4j.PatternLayout;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.firefox.internal.ProfilesIni;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.testng.Assert;
import org.testng.SkipException;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import Util.Constant;
import Util.TestUtil;
import Util.Xls_Reader;

public class TestBase {

	// initalizing the property file reading
	public static Properties Config;
	public static Properties OR;
	public static WebDriver dr;
	public static EventFiringWebDriver driver;
	public static boolean isLoggedIn = false;
	public ExtentReports extent = Util.ExtentManager.getInstance();
	public ExtentTest test;
	public static Logger APPLICATION_LOG = Logger.getLogger("devpinoyLogger");

	public void initLogs(Class<?> class1) {

		FileAppender appender = new FileAppender();
		// configure the appender here, with file location, etc
		appender.setFile(System.getProperty("user.dir") + "//target//reports//" + Util.CustomListener.resultFolderName+ "//" + class1.getName() + ".log");
		appender.setLayout(new PatternLayout("%d %-5p [%c{1}] %m%n"));
		appender.setAppend(false);
		appender.activateOptions();

		APPLICATION_LOG = Logger.getLogger(class1);
		APPLICATION_LOG.setLevel(Level.DEBUG);
		APPLICATION_LOG.addAppender(appender);
	}

	public static void init() throws FileNotFoundException {
		if (Config == null) {
			String path = System.getProperty("user.dir") + "\\src\\test\\java\\Config\\Config.Properties";

			Config = new Properties();
			try {
				FileInputStream fs = new FileInputStream(path);
				Config.load(fs);
			} catch (Exception e) {
				e.printStackTrace();
			}
			System.out.println(Config.getProperty("xlsFileLocation"));
			System.out.println(path);
			OR = new Properties();

			FileInputStream fn = new FileInputStream(
					System.getProperty("user.dir") + "\\src\\test\\java\\Config\\OR.Properties");
			try {
				OR.load(fn);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	public void validateRunmodes(String testName, String suiteName, String dataRunmode) throws IOException {
		APPLICATION_LOG.debug("Validating runmode for " + testName + " in suite " + suiteName);
		init();
		// suite runmode
		boolean suiteRunmode = TestUtil.isSuiteRunnable(suiteName,
				new Util.Xls_Reader(Config.getProperty("xlsFileLocation") + "Suite.xlsx"));
		System.out.println("12");
		boolean testRunmode = TestUtil.isTestCaseRunnable(testName,
				new Xls_Reader(Config.getProperty("xlsFileLocation") + suiteName + ".xlsx"));
		System.out.println("12");
		boolean dataSetRunmode = false;
		if (dataRunmode.equals(Constant.RUNMODE_YES))
			dataSetRunmode = true;

		if (!(suiteRunmode && testRunmode && dataSetRunmode)) {
			APPLICATION_LOG.debug("Skipping the test " + testName + " inside the suite " + suiteName);
			throw new SkipException("Skipping the test " + testName + " inside the suite " + suiteName);
		}
	}


	// Initalize the webdriver and EventFiringWebDriver
	
	public void openBrowser(String browserType) {
		if(browserType.equalsIgnoreCase("Mozilla")){
			FirefoxProfile profile = new FirefoxProfile();
			ProfilesIni prof = new ProfilesIni();	
			FirefoxProfile ffProfile= prof.getProfile("ProfileSeleniumQA");
			 profile.setPreference("dom.max_chrome_script_run_time", 0);
		    profile.setPreference("dom.max_script_run_time", 0);
		    ffProfile.setAcceptUntrustedCertificates(true);
		    ffProfile.setAssumeUntrustedCertificateIssuer(false);
		    System.setProperty("webdriver.gecko.driver", "lib\\geckodriver.exe");
		    dr=new FirefoxDriver(ffProfile);
		}
			else if(browserType.equals("IE")){
				 //File file= new File("C:\\QA\\Chrome\\IEDriverServer.exe");
					System.setProperty("webdriver.ie.driver", "lib\\chromedriver.exe");
					 dr= new InternetExplorerDriver();
			 }
			 else if(browserType.equals("Chrome")){
				 System.setProperty("webdriver.chrome.driver", "lib\\chromedriver.exe");
					//File file= new File("D:\\Installers\\Chrome\\chromedriver.exe");
					//System.setProperty("webdriver.chrome.driver", file.getAbsolutePath());
						ChromeOptions options = new ChromeOptions();
						options.addArguments("no-sandbox");
						options.addArguments("disable-infobars");
						 dr= new ChromeDriver();
			 }
		         dr.manage().window().maximize();
		         dr.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		          EventFiringWebDriver driver= new EventFiringWebDriver(dr);
	}
		
	
	
	public void reportFailure(String failureMessage) {
		test.log(LogStatus.FAIL, failureMessage);
		TestUtil.takeScreenShot(failureMessage);
		Assert.fail(failureMessage);
	}
	public void navigate(String testsiteName) {
		dr.get(Config.getProperty(testsiteName));
		System.out.println(Config.getProperty(testsiteName));
		// Utility.takeScreenshot(URLKey);
	}
	public void doLogin(String Browser, String Username, String Password) {
		openBrowser(Browser);
		navigate("testsiteName");
		//dr.get(Config.getProperty("testsiteName"));
		// String LoginUserName=Username;
		getObject("login_username").sendKeys(Username);
		// getObject("login_username").sendKeys((String.valueOf(Username)));
		getObject("login_password").sendKeys(Password);
		getObject("loginButton").click();

	}
	
	public void doDefaultLogin(String browser) {
		doLogin(browser, Config.getProperty("Username"), Config.getProperty("Password"));
	}

	public static WebElement getObject(String Xpath) {
		try {
			return dr.findElement(By.xpath(OR.getProperty(Xpath)));

		} catch (Throwable t) {
			// report error
			TestUtil.takeScreenShot(Xpath);

			return null;
		}

	}

	public static WebElement getObjectFromSelector(String Selector) {
		try {
			return dr.findElement(By.cssSelector(OR.getProperty(Selector)));

		} catch (Throwable t) {
			// report error
			TestUtil.takeScreenShot(Selector);

			return null;
		}

	}
	public boolean isElementPresent(String identifier) {
		// System.out.println(d.getPageSource());
		int size = 0;
		if (identifier.endsWith("_xpath"))
			size = dr.findElements(By.xpath(OR.getProperty(identifier))).size();
		else if (identifier.endsWith("_id"))
			size = dr.findElements(By.id(OR.getProperty(identifier))).size();
		else if (identifier.endsWith("_name"))
			size = dr.findElements(By.name(OR.getProperty(identifier))).size();
		else if ((identifier.endsWith("_Selector")))
			size = dr.findElements(By.cssSelector(OR.getProperty(identifier))).size();
		else // not in prop file
			size = dr.findElements(By.xpath(identifier)).size();
		TestUtil.takeScreenShot(identifier);
		if (size > 0)
			return true;
		else
			return false;
	}

	public static String getRelativeUrl(String absoluteURL) throws MalformedURLException {
		URL url = new URL(absoluteURL);
		return url.getPath();
	}

	public static String formatIntegerToString(String str) {
		return String.valueOf((int) Double.parseDouble(str));
	}
	// Creating a Dynamatic Data Generator

	public String generateStringWithAllobedSplChars(int length, String allowdSplChrs) {
		String allowedChars = "abcdefghijklmnopqrstuvwxyz" + // alphabets
				"1234567890" + // numbers
				allowdSplChrs;
		return RandomStringUtils.random(length, allowedChars);
	}

	
	public String generateRandomAlphaNumeric(int lenght, String charcter) {
		String characters = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789!\"$%^&*()";
		charcter = RandomStringUtils.random(lenght, characters);
		return charcter;
	}

	public void quit() {
		if (dr != null) {
			dr.quit();
			dr = null;
		}
	}
}
