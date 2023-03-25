package com.honohr.pulse.login.pages;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.honohr.pulse.base.pages.BaseHonoPulseAutomationPage;

public class HonohrPulseLoginPage extends BaseHonoPulseAutomationPage {
	
	@FindBy(xpath = "//p[text()='LOGIN HERE']")
	private WebElement lblLoginHere;

	@FindBy(xpath = "//a[text()='Forgot Password ?']")
	private WebElement lblForgotPassword;
	
	@FindBy(xpath = "//input[@name='email']")
	private WebElement txtEmail;
	
	@FindBy(xpath = "//input[@type='password']")
	private WebElement txtPassword;
	
	@FindBy(xpath = "//button[@type='submit']")
	private WebElement btnSignIn;
	
	@FindBy(xpath = "//button[text()='Yes']")
	private WebElement btnYesOrNoPopUp;
	
	@FindBy(xpath = "//h2[text()='Are you sure?']")
	private WebElement lblAreYouSure;
	
	@FindBy(xpath = "//h1[text()='Dashboard']")
	private WebElement lblDashboard;
	
	private static final Logger logger = Logger.getLogger(HonohrPulseLoginPage.class.getName());

	public HonohrPulseLoginPage(WebDriver driver) {
		super(driver);
		
		logger.info("Starting of HonoLoginPage method");

		PageFactory.initElements(driver, this);

		logger.info("Ending of HonoLoginPage method");
	}
	
	public synchronized String getLoginHereText() {
		logger.info("Starting of getLoginHereText method");
		logger.info("Ending of getLoginHereText method");
		
		return lblLoginHere.getText();
	}
	
	public synchronized String getSignInText() {
		logger.info("Starting of getSignInText method");
		logger.info("Ending of getSignInText method");
		
		return btnSignIn.getText();
	}
	
	public synchronized String getForgotPasswordText() {
		logger.info("Starting of getForgotPasswordText method");
		logger.info("Ending of getForgotPasswordText method");
		
		return lblForgotPassword.getText();
	}
	
	public synchronized void setEmailAddress(String strEmailAddress) {
		logger.info("Starting of setEmailAddress method");

		this.txtEmail.sendKeys(strEmailAddress);

		logger.info("Ending of strEmailAddress method");
	}

	public synchronized void setPassword(String strPassword) {
		logger.info("Starting of setPassword method");
		
        this.txtPassword.sendKeys(strPassword);
        
		logger.info("Ending of setPassword method");
	}
	
	public synchronized void clickOnSignInButton() {
		logger.info("Starting of clickOnSignInButton method");

        this.btnSignIn.click();
        
		logger.info("Ending of clickOnSignInButton method");
	}
	
	public synchronized void clickOnYesOrNoButton() {
		logger.info("Starting of clickOnYesOrNoButton method");

        this.btnYesOrNoPopUp.click();
        
		logger.info("Ending of clickOnYesOrNoButton method");
	}
	
	public synchronized String getTextAreYouSure() {
		logger.info("Starting of getTextAreYouSure method");   
		logger.info("Ending of getTextAreYouSure method");

		return lblAreYouSure.getText();
	}
	
	public synchronized String getTextDashboard() {
		logger.info("Starting of getTextAreYouSure method");   
		logger.info("Ending of getTextAreYouSure method");

		return lblDashboard.getText();
	}	
}
