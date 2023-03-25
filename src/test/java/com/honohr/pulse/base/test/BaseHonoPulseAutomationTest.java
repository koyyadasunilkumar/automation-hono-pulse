package com.honohr.pulse.base.test;
import static com.honohr.pulse.util.Constants.*;

import java.io.FileReader;
import java.io.IOException;
import java.time.Duration;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.List;
import java.util.Map;
import java.util.Properties;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.testng.Assert;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Listeners;
import org.testng.annotations.Parameters;

import com.google.common.base.Function;
import com.honohr.pulse.login.pages.HonohrPulseLoginPage;
import com.honohr.pulse.util.TestListener;

import io.github.bonigarcia.wdm.WebDriverManager;

@Listeners(TestListener.class)
public class BaseHonoPulseAutomationTest {

	protected static String browserDriverPath = null;
	protected WebDriver driver = null;
	protected String batchCode = null;
	protected String loginURL = null;
	private HonohrPulseLoginPage loginPage = null;
	protected String orgCode = null;

	protected WebDriver childWebDriver = null;

	protected static Map<String, String> chromeDriverMap = new HashMap<String, String>();

	private static final Logger logger = Logger.getLogger(BaseHonoPulseAutomationTest.class.getName());

	protected static Properties testDataProp = null;
	protected static Properties expectedAssertionsProp = null;

	protected static Properties xpathProperties = null;
	protected static String osPath = null;
	protected List<WebDriver> lstDriver = new ArrayList<WebDriver>();
	private static Map<WEB_DRIVER, WebDriver> webDriverPool = new Hashtable<WEB_DRIVER, WebDriver>();

	public enum WEB_DRIVER {

		DRIVER,
	}

	@BeforeSuite
	@Parameters({ "siteURL" })
	public synchronized void initTestData(String siteURL) {

		if (siteURL != null) {
			this.loginURL = siteURL;
		}

		if (testDataProp == null) {
			osPath = System.getProperty("os.name");

			FileReader testDataReader = null;
			FileReader assertionsReader = null;

			try {
				testDataReader = new FileReader("src/main/resources/testdata.properties");
				assertionsReader = new FileReader("src/main/resources/expectedassertions.properties");

				testDataProp = new Properties();
				testDataProp.load(testDataReader);

				expectedAssertionsProp = new Properties();
				expectedAssertionsProp.load(assertionsReader);

			} catch (IOException e) {
				e.printStackTrace();
			} finally {
				try {
					testDataReader.close();
					assertionsReader.close();

				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		logger.debug("Site URL : " + this.loginURL);
	}

	protected synchronized void quitDriver(WEB_DRIVER webDriver) {
		logger.info("Starting of method quitDriver in BaseClassplusAutomationTest ");

		WebDriver driver = webDriverPool.get(webDriver);
		try {
			if (driver != null) {
				driver.quit();
				driver = null;
				webDriverPool.remove(webDriver);
				logger.debug(webDriver + " Web driver quit successfully in BaseClassplusAutomationTest ");
			}
		} catch (Exception ex) {
			logger.error(ex.getMessage());
			driver = null;
		}
		logger.info("Ending of method quitDriver in BaseClassplusAutomationTest");
	}

	/**
	 * This method is used for get driver
	 * 
	 * @param webDriver
	 * @return
	 */

	public void fluentWaitForElement(WebDriver childDriver, final String xPath) {

		try {

			// Reference : https://www.guru99.com/implicit-explicit-waits-selenium.html
			Wait<WebDriver> wait = new FluentWait<WebDriver>(childDriver).withTimeout(Duration.ofSeconds(60))
					.pollingEvery(Duration.ofSeconds(3)).ignoring(Exception.class);

			WebElement webElement = wait.until(new Function<WebDriver, WebElement>() {
				public WebElement apply(WebDriver driver) {
					return driver.findElement(By.xpath(xPath));
				}
			});

		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	protected synchronized WebDriver getWebDriver(String browser) {
		logger.info("Starting of method getWebDriver");

		String osPath = System.getProperty("os.name");

		if (osPath.contains("Linux")) {

			if (browser.equalsIgnoreCase("Firefox")) {
				WebDriverManager.firefoxdriver().setup();
				FirefoxOptions firefoxOptions = new FirefoxOptions();
				firefoxOptions.setHeadless(true);
				// chromeOptions.addArguments("--no-sandbox");
				firefoxOptions.addArguments("allow-file-access-from-files");
				firefoxOptions.addArguments("use-fake-device-for-media-stream");
				firefoxOptions.addArguments("use-fake-ui-for-media-stream");
				driver = new FirefoxDriver(firefoxOptions);
			} else if (browser.equalsIgnoreCase("Chrome")) {
				WebDriverManager.chromedriver().setup();
				ChromeOptions chromeOptions = new ChromeOptions();
				chromeOptions.addArguments("--remote-allow-origins=*");
				chromeOptions.setHeadless(true);
				chromeOptions.addArguments("--no-sandbox");
				chromeOptions.addArguments("allow-file-access-from-files");
				chromeOptions.addArguments("use-fake-device-for-media-stream");
				chromeOptions.addArguments("use-fake-ui-for-media-stream");

				driver = new ChromeDriver(chromeOptions);
			}
		} else if (osPath.contains("Mac OS X")) {
			browserDriverPath = "/usr/bin/chromedriver";

			if (browserDriverPath.contains("safaridriver")) {
				System.setProperty("webdriver.safari.driver", browserDriverPath);
				ChromeOptions chromeOptions = new ChromeOptions();
				chromeOptions.addArguments("allow-file-access-from-files");
				chromeOptions.addArguments("use-default-device-for-media-stream");
				chromeOptions.addArguments("use-default-ui-for-media-stream");
				driver = new ChromeDriver(chromeOptions);

				logger.debug("Safari driver path " + browserDriverPath);
			} else if (browser.equalsIgnoreCase("chrome")) {

				WebDriverManager.chromedriver().setup();
				driver = new ChromeDriver();
			}
		} else {

			if (browser.equalsIgnoreCase("chrome")) {
				WebDriverManager.chromedriver().setup();

				ChromeOptions chromeOptions = new ChromeOptions();
				chromeOptions.addArguments("--remote-allow-origins=*");
				chromeOptions.setHeadless(false);
				chromeOptions.addArguments("allow-file-access-from-files");
				chromeOptions.addArguments("use-fake-device-for-media-stream");
				chromeOptions.addArguments("use-fake-ui-for-media-stream");

				driver = new ChromeDriver(chromeOptions);

			} else if (browser.equalsIgnoreCase("Firefox")) {
				WebDriverManager.firefoxdriver().setup();
				driver = new FirefoxDriver();
			} else if (browser.equalsIgnoreCase("Chromium")) {
				WebDriverManager.chromiumdriver().setup();
				driver = new EdgeDriver();
			} else if (browser.equalsIgnoreCase("IEDriverServer")) {
				WebDriverManager.iedriver().setup();
				driver = new InternetExplorerDriver();
			}
		}

		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(Duration.ofMinutes(1));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(60));

		logger.info("********** Driver Successfully Created ********* " + driver.getTitle());

		logger.info("End of method getWebDriver");

		return driver;
	}

	public synchronized void loginToHono(String browser, String siteURL, String emailAddress, String password,
			WebDriver driver) throws InterruptedException {
		logger.info("Starting of loginToHono method");

		this.childWebDriver = driver;
		loginPage = new HonohrPulseLoginPage(driver);
		driver.get(siteURL);
		Thread.sleep(5000);
		this.login(emailAddress, password);

		logger.info("Ending of loginToHono method");
	}

	public synchronized void login(String emailAddress, String password) {
		logger.info("Starting of login method");
		
		Assert.assertEquals(loginPage.getLoginHereText(), expectedAssertionsProp.getProperty(LOGIN_HERE));
		Assert.assertEquals(loginPage.getSignInText(), expectedAssertionsProp.getProperty(SIGN_IN));
		Assert.assertEquals(loginPage.getForgotPasswordText(), expectedAssertionsProp.getProperty(FORGOT_PASSWORD));
		this.loginPage.setEmailAddress(emailAddress);
		this.loginPage.setPassword(password);
		this.loginPage.clickOnSignInButton();
		// Assert.assertEquals(loginPage.getTextAreYouSure(),
		// expectedAssertionsProp.getProperty(ARE_YOU_SURE));
		this.loginPage.clickOnYesOrNoButton();
		
		logger.info("Ending of login method");
	}


	public synchronized void goToSite(String siteURL, WebDriver driver) {
		logger.info("starting of method goToSite");

		logger.debug("Login URL is" + siteURL);
		driver.get(siteURL);

		logger.info("Ending of method goToSite");
	}

	public WebDriver getChildWebDriver() {
		return this.childWebDriver;
	}

	public WebDriver getDriver() {
		logger.info("Starting of WebDriver method ");
		logger.info("Ending of WebDriver method ");

		return childWebDriver;
	}

	public List<WebDriver> getDriversList() {
		return lstDriver;
	}

}
