package com.honohr.pulse.createsurvey.pages;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.honohr.pulse.base.pages.BaseHonoPulseAutomationPage;

public class HonohrPulseCreateSurveyPage extends BaseHonoPulseAutomationPage {

	@FindBy(xpath = "//button[text()=' Create New Template ']")
	private WebElement btnCreateNewTemplate;

	@FindBy(xpath = "//h1[text()='Create Survey ']")
	private WebElement lblCreateSurvey;

	@FindBy(xpath = "//A[text()='General ']")
	private WebElement lblGeneral;

	@FindBy(xpath = "//input[@formcontrolname='survey_name']")
	private WebElement txtSurveyName;

	@FindBy(xpath = "//input[@formcontrolname='survey_desc']")
	private WebElement txtSurveyDesc;

	@FindBy(xpath = "//select[@formcontrolname='survey_category']")
	private WebElement btnSurveyCategory;

	@FindBy(xpath = "//option[text()='Engagement ']")
	private WebElement lblEngagement;

	@FindBy(xpath = "//select[@formcontrolname='survey_category']")
	private WebElement btnSurveyName;

	@FindBy(xpath = "//input[@class='form-control seacrh-input expiryDate ng-untouched ng-pristine ng-valid']")
	private WebElement txtExpiryDate;

	@FindBy(xpath = "//div[@id='survey-add-language']//input[@type='checkbox']")
	private WebElement btnAddLanguage;

	@FindBy(xpath = "//select[@formcontrolname='languages']")
	private WebElement lblSelectLanguage;

	@FindBy(xpath = "//button[@class='btn btn-info btn-block btn-flat ng-star-inserted']")
	private WebElement btnSave;
	
	@FindBy(xpath ="//div[text()=' Survey Initialize ']")
	private WebElement lblSurveyInitialize;
	
	@FindBy(xpath ="//div[text()=' Check Your Field ']")
	private WebElement msgPopup;
	
	@FindBy(xpath ="// div[text()=' Select survey category ']")
	private WebElement msgSelectcategory;

	private static final Logger logger = Logger.getLogger(HonohrPulseCreateSurveyPage.class.getName());

	public HonohrPulseCreateSurveyPage(WebDriver driver) {
		super(driver);

		logger.info("Starting of HonohrPulseCreateSurveyPage method");

		PageFactory.initElements(driver, this);

		logger.info("Ending of HonohrPulseCreateSurveyPage method");
	}

	public synchronized void clickOnCreateNewButton() {
		logger.info("Starting of clickOnCreateNewButton method");

		clickOnWebElement(btnCreateNewTemplate);

		logger.info("Ending of clickOnCreateNewButton method");
	}

	public synchronized String getCreateSurveyText() {
		logger.info("Starting of getCreateSurveyText method");
		logger.info("Ending of getCreateSurveyText method");

		return lblCreateSurvey.getText();
	}

	public synchronized String getTextGeneral() {
		logger.info("Starting of getTextGeneral method");
		logger.info("Ending of getTextGeneral method");

		return lblGeneral.getText();
	}

	public synchronized void clickOnSurveyName(String strSurveyName) {
		logger.info("Starting of clickOnSurveyName method");

		clickOnWebElement(txtSurveyName);
		this.txtSurveyName.sendKeys(strSurveyName);

		logger.info("Ending of clickOnSurveyName method");
	}

	public synchronized void clickOnSurveyDesc(String strSurveyDesc) {
		logger.info("Starting of clickOnSurveyDesc method");

		clickOnWebElement(txtSurveyDesc);
		this.txtSurveyDesc.sendKeys(strSurveyDesc);

		logger.info("Ending of clickOnSurveyDesc method");
	}

	public synchronized void clickOnSurveyCategory() {
		logger.info("Starting of clickOnSurveyCategory method");

		try {
			Select sec = new Select(btnSurveyCategory);
			sec.selectByIndex(0);

		} catch (Exception e) {
		}

		logger.info("Ending of clickOnSurveyCategory method");
	}

	public synchronized void clickOnEngagement() {
		logger.info("Starting of clickOnEngagement method");

		try {
			clickOnWebElement(lblEngagement);
		} catch (Exception e) {
			this.lblEngagement.click();
		}

		logger.info("Ending of clickOnEngagement method");
	}

	public synchronized void setExpiryDate(String strExpDate) {
		logger.info("Starting of setExpiryDate method");

		try {
			explicitWait(txtExpiryDate);
			clickOnWebElement(txtExpiryDate);
			 this.txtExpiryDate.sendKeys(strExpDate);

			/*
			 * explicitWait(txtExpiryDate); clickOnWebElement(txtExpiryDate);
			 * txtExpiryDate.sendKeys("11/18/2022");
			 * 
			 * Actions act = new Actions(driver); Point s=txtExpiryDate.getLocation();
			 * act.moveToElement(txtExpiryDate,10,10); // act.moveByOffset(1,1);
			 * PointerInput e=act.getActivePointer(); act.tick();
			 * act.doubleClick(txtExpiryDate).perform();
			 */
			/*
			 * Actions act = new Actions(driver); List<WebElement> elements =
			 * driver.findElements(By.xpath("//input[@id='expiryDate']"));
			 * System.out.println("Size of elements*************"+elements.size()
			 * +"************************"); for (int i=0; i < elements.size();i++) {
			 * elements.get(i).click(); }
			 */
		} catch (Exception e) {
			this.txtExpiryDate.click();

		}

		logger.info("Ending of setExpiryDate method");
	}

	public synchronized void clickOnAddLanguage() {
		logger.info("Starting of clickOnAddLanguage method");

		clickOnWebElement(btnAddLanguage);

		logger.info("Ending of clickOnAddLanguage method");
	}

	public synchronized void clickOnSelectLanguage() {
		logger.info("Starting of clickOnSelectLanguage method");

		Select sec = new Select(lblSelectLanguage);
		sec.selectByIndex(0);
		sec.selectByIndex(1);

		logger.info("Ending of clickOnSelectLanguage method");
	}

	public synchronized void clickOnSaveButton() throws InterruptedException {
		logger.info("Starting of clickOnSaveButton method");

		try {
			explicitWait(btnSave);
			clickOnWebElement(btnSave);
		} catch (Exception e) {
		}

		logger.info("Ending of clickOnSaveButton method");
	}

	public synchronized String getServeyIntializeText() throws InterruptedException {

		logger.info("Starting of getServeyIntializeText method");
		logger.info("Ending of getServeyIntializeText method");

		return lblSurveyInitialize.getText();
	}

	public boolean isSurveyInitializeMessageDisplayed() {

		logger.info("Starting of isSurveyInitializeMessageDisplayed Method");
		logger.info("Ending ofisSurveyInitializeMessageDisplayed Method");

		return lblSurveyInitialize.isDisplayed();
	}
	
	public synchronized String getGeneralToastText() {
		logger.info("Starting of getgeneralToastText method");
		logger.info("Ending of getgeneralToastText method");

		return msgPopup.getText();
	}
	
	public synchronized String getGeneralCategoryText() {
		logger.info("Starting of getgeneralCategoryText method");
		logger.info("Ending of getgeneralCategoryText method");

		return msgSelectcategory.getText();
	}
}
