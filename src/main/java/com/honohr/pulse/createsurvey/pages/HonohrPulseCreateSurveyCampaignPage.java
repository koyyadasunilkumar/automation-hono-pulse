package com.honohr.pulse.createsurvey.pages;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.honohr.pulse.base.pages.BaseHonoPulseAutomationPage;

public class HonohrPulseCreateSurveyCampaignPage extends BaseHonoPulseAutomationPage {

	@FindBy(xpath = "//h1[contains(text(),'Campaign')]")
	private WebElement lblCampaign;

	@FindBy(xpath = "//div[@class='col-12 ng-star-inserted']")
	private WebElement lblSurveyNameText;

	@FindBy(xpath = "//input[@formcontrolname='campaign_title']")
	private WebElement txtCampiangTitle;

	@FindBy(xpath = " //select[@formcontrolname='campType']")
	private WebElement btnCampaign;

	@FindBy(xpath = "//select[@formcontrolname='scheduleMode']")
	private WebElement btnScheduleModeDropDown;

	@FindBy(xpath = "//div[@id='campaign-modes']")
	private WebElement btnSelectModesDropDown;

	@FindBy(xpath = "//div[text()='EMAIL']")
	private WebElement chkEmail;

	@FindBy(xpath = "//div[@id='campaign-timezone']")
	private WebElement btnTimeZoneDropDown;

	@FindBy(xpath = "//option[text()=' (GMT+04:00)Europe/Moscow ']")
	private WebElement btnTimeZoneOption;

	@FindBy(xpath = "//input[@formcontrolname='campaign_subject']")
	private WebElement txtSubject;

	@FindBy(xpath = "//div[@class='col-lg-6 input-colhome col-lg-12']")
	private WebElement lblEmailMessageBox;

	@FindBy(xpath = "//body[@data-mce-placeholder='Type here...']")
	private WebElement txtEmail;

	@FindBy(xpath = "//iframe[@class='tox-edit-area__iframe']")
	private WebElement txtIframe;

	@FindBy(xpath = "//a[text()=' Region ']")
	private WebElement btnRegionDropDown;

	@FindBy(xpath = "//input[@class='form-check-input sub-checkbox' and @value='North' ]")
	private WebElement chkSelectAll;

	@FindBy(xpath = "//a[text()=' Department ']")
	private WebElement btnDepartmentDropDown;

	@FindBy(xpath = "//label[text()=' Select All ']//input[@value='department']")
	private WebElement chkSelectNorthDepartment;

	@FindBy(xpath = "//a[text()=' Gender ']")
	private WebElement btnGenderDropDown;

	@FindBy(xpath = "//input[@value='Female']")
	private WebElement chkFemaleOption;

	@FindBy(xpath = "//a[text()='Show List']")
	private WebElement btnShowList;

	@FindBy(xpath = "(//div[@class='modal-body']/parent::div)[2]")
	private WebElement lstBoxEmployee;

	@FindBy(xpath = "//div[@class='form-group']//input[@placeholder='Enter Name ']")
	private WebElement txtNameField;

	@FindBy(xpath = "//input[@class='form-check-input check_all-ch']")
	private WebElement chkT001Employee;

	@FindBy(xpath = "(//button[@class='close']/child::span[text()='×'])[3]")
	private WebElement btnClose;

	@FindBy(xpath = "//button[text()=' Send ']")
	private WebElement btnSend;
	
	@FindBy(xpath = "//div[text()=' New Campaign created successfully ']")
	private WebElement btnCampaignCrtdMsg;
	
	

	private static final Logger logger = Logger.getLogger(HonohrPulseCreateSurveyCampaignPage.class.getName());

	public HonohrPulseCreateSurveyCampaignPage(WebDriver driver) {
		super(driver);
		logger.info("Starting of CampiangPage method");

		PageFactory.initElements(driver, this);

		logger.info("Ending of CampiangPage method");
	}

	public String getcampaignLabel() {
		logger.info("Starting of getcampaignLabel Method");
		logger.info("Ending of getcampaignLabel Method");

		return lblCampaign.getText();
	}
	
	public String getCampaignSuccessMsg() {
		logger.info("Starting of getCampaignSuccessMsg Method");
		logger.info("Ending of getCampaignSuccessMsg Method");

		return btnCampaignCrtdMsg.getText();
	}

	public boolean isSurveyNameTextDisplayed() {
		logger.info("Starting Of isSurveyNameTextDisplayed Method");
		logger.info("Ending Of isSurveyNameTextDisplayed Method");

		return lblSurveyNameText.isDisplayed();
	}

	public void setCampaignTitleText(String strCampaignTitle) {
		logger.info("Starting Of setCampaignTitle Method");

		try {
			Thread.sleep(5000);
			this.explicitWait(txtCampiangTitle);
			this.txtCampiangTitle.sendKeys(strCampaignTitle);
		} catch (Exception e) {
		}

		logger.info("Ending Of setCampaignTitle Method");
	}

	public void clickOnCampaignType() {
		logger.info("Starting Of clickOnCampaignType Method");

		try {
			Select sec = new Select(btnCampaign);
			sec.selectByIndex(0);
		} catch (Exception e) {

		}

		logger.info("Ending Of clickOnCampaignType Method");
	}

	public void clickOnScheduleModeDropDownButton() {
		logger.info("Starting Of clickOnScheduleModeDropDownButton Method");

		try {
			Select sec = new Select(btnScheduleModeDropDown);
			sec.selectByIndex(0);
		} catch (Exception e) {
		}

		logger.info("Ending Of clickOnScheduleModeDropDownButton Method");
	}

	public void clickOnSelectModesDropDown() {
		logger.info("Starting of clickOnSelectModesDropDown Method");

		this.btnSelectModesDropDown.click();

		logger.info("Ending Of clickOnSelectModesDropDown Method");
	}

	public void clickOnEmailCheckBox() {
		logger.info("Starting of clickOnEmailCheckBox Method");

		this.chkEmail.click();

		logger.info("Ending of clickOnEmailCheckBox Method");
	}

	public void clickOnTimeZoneDropDownButton() {
		logger.info("Starting Of clickOnTimeZoneDropDownButton Method");

		try {
			explicitWait(btnTimeZoneDropDown);
			clickOnWebElement(btnTimeZoneDropDown);
		} catch (Exception e) {
			this.btnTimeZoneDropDown.click();
		}

		logger.info("Ending Of clickOnTimeZoneDropDownButton Method");

	}

	public void clickOnTimeZoneOptionButton() {
		logger.info("Starting Of clickOnTimeZoneOptionButton Method");

		try {
			explicitWait(btnTimeZoneOption);
			clickOnWebElement(btnTimeZoneOption);
		} catch (Exception e) {
			this.btnTimeZoneOption.click();
		}

		logger.info("Ending Of clickOnTimeZoneOptionButton Method");
	}

	public void setSubjectText(String strSubjectText) {
		logger.info("Starting Of setSubjectText Method");

		this.explicitWait(txtSubject);
		this.txtSubject.sendKeys(strSubjectText);
		

		logger.info("Ending of setSubjectText Method");
	}

	public void setTextEmail(String strTextEmail) {
		logger.info("Starting of setTextEmail Method");

		try {
			driver.switchTo().frame(txtIframe);
			Thread.sleep(10000);
			explicitWait(txtEmail);
			this.txtEmail.sendKeys(strTextEmail);
		} catch (Exception e) {
		}

		logger.info("Ending of setTextEmail Method");
	}

	public void clickOnRegionDropDownButton() {
		logger.info("Starting of clickOnRegionDropDownButton Method");

		try {
			driver.switchTo().defaultContent();
			explicitWait(btnRegionDropDown);
			this.btnRegionDropDown.click();
		} catch (Exception e) {

			this.clickOnWebElement(btnRegionDropDown);
		}

		logger.info("Ending Of clickOnRegionDropDownButton Method");
	}

	public void clickOnSelectAllCHeckBox() {
		logger.info("Starting Of clickOnSelectAllCHeckBox Method");

		try {
			explicitWait(chkSelectAll);
			clickOnWebElement(chkSelectAll);
		} catch (Exception e) {
			this.chkSelectAll.click();
		}

		logger.info("Ending of clickOnSelectAllCHeckBox Method");
	}

	public void clickOnDepartmentDropDown() {
		logger.info("Starting Of clickOnDepartmentDropDown Method");

		try {
			explicitWait(btnDepartmentDropDown);
			clickOnWebElement(btnDepartmentDropDown);
		} catch (Exception e) {
			this.btnDepartmentDropDown.click();
		}

		logger.info("Ending Of clickOnDepartmentDropDown Method");
	}

	public void clickOnSelectAllDepartmentCheckBox() {
		logger.info("Starting of clickOnSelectAllDepartmentCheckBox Method");

		try {
			explicitWait(chkSelectNorthDepartment);
			clickOnWebElement(chkSelectNorthDepartment);
		} catch (Exception e) {
			this.chkSelectNorthDepartment.click();
		}

		logger.info("Ending of clickOnSelectAllDepartmentCheckBox Method");
	}

	public void clickOnGenderDropDownButton() {
		logger.info("Starting Of clickOnGenderDropDownButton Method");

		this.btnGenderDropDown.click();

		logger.info("Ending of clickOnGenderDropDownButton Method");
	}

	public void clickOnFemaleOptionCheckBox() {
		logger.info("Starting of clickOnFemaleOptionCheckBox Method");

		try {
			explicitWait(chkFemaleOption);
			clickOnWebElement(chkFemaleOption);
		} catch (Exception e) {
			this.chkFemaleOption.click();
		}

		logger.info("Ending of clickOnFemaleOptionCheckBox Method");
	}

	public void clickOnShowListButton() {
		logger.info("Starting Of clickOnShowListButton Method");

		try {
			Thread.sleep(5000);
			explicitWait(btnShowList);
			clickOnWebElement(btnShowList);
		} catch (Exception e) {
			this.btnShowList.click();
		}

		logger.info("Ending Of clickOnShowListButton Method");
	}

	public boolean isEmployeeListBoxDispalyed() {
		logger.info("Starting Of isEmployeeListBoxDispalyed Method");
		logger.info("Ending Of isEmployeeListBoxDispalyed Method");

		return lstBoxEmployee.isDisplayed();

	}

	public void setNameTextField(String strNameTextField) {
		logger.info("Starting Of clickOnNameTextField Method");

		try {
			Thread.sleep(5000);
			explicitWait(txtNameField);
			this.txtNameField.sendKeys("Kavya Ketha");
		} catch (Exception e) {
			// TODO: handle exception
		}

		logger.info("Ending Of setNameTextField Method");
	}

	public void clickOnT001EmployeeCheckBox() {
		logger.info("Starting Of clickOnT001EmployeeCheckBox Method");

		this.chkT001Employee.click();

		logger.info("Ending Of clickOnT001EmployeeCheckBox Method");
	}

	public void clickOnCloseButton() {
		logger.info("Starting Of clickOnCloseButton Method");

		try {
			explicitWait(btnClose);
			clickOnWebElement(btnClose);
		} catch (Exception e) {
			this.btnClose.click();
		}

		logger.info("Endig Of clickOnCloseButton Method");
	}

	public void clickOnSendButton() {
		logger.info("Starting Of clickOnSendButton Method");

		try {
			
			//explicitWait(btnSend);
			clickOnWebElement(btnSend);
		} catch (Exception e) {
			this.btnSend.click();
		}

		logger.info("Ending Of clickOnSendButton Method");
	}

	public boolean getSendtButtonText() {
		logger.info("Starting Of getStartButtonText Method");
		logger.info("Ending Of getStartButtonText Method");

		return btnSend.isDisplayed();
	}

	public String getCampaignPageText() {
		logger.info("Starting Of getCampaignPageText Method");
		logger.info("Ending Of getCampaignPageText Method");

		return lblCampaign.getText();
	}
}
