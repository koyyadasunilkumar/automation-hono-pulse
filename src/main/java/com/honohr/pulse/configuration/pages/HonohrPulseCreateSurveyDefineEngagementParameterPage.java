package com.honohr.pulse.configuration.pages;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.honohr.pulse.base.pages.BaseHonoPulseAutomationPage;

public class HonohrPulseCreateSurveyDefineEngagementParameterPage extends BaseHonoPulseAutomationPage {
	
	@FindBy(xpath = "//span[text()=' Configuration ']")
	private WebElement btnConfiguration;
	
	@FindBy(xpath = "//a[text()='Define Engagement Parameters ']")
	private WebElement lblDefineEngParameter;
	
	@FindBy(xpath = "//h1[text()='Engagement Parameter']")
	private WebElement lblEngagementParameter;
	
	@FindBy(xpath = "//button[text()=' Add Parameters ']")
	private WebElement btnAddParameters;
	
	@FindBy(xpath = "//h4[text()='Add New Engagement Parameter']//following-sibling::button[@class='close']")
	private WebElement btnClose;
	
	@FindBy(xpath = "//input[@class='form-control seacrh-input ng-pristine ng-invalid ng-untouched' and @placeholder='Enter Performance Parameter Name']")
	private WebElement txtParameterNameTwo;
	
	@FindBy(xpath = "//input[@class='form-control seacrh-input ng-untouched ng-pristine ng-invalid' and @placeholder='Enter Performance Parameter Name'][1]")
	private WebElement txtParameterName;
	
	@FindBy(xpath = "//input[@class='form-control seacrh-input ng-touched ng-dirty ng-invalid']")
	private WebElement txtTouchedParameterName;
	
	@FindBy(xpath = "//input[@class='form-control seacrh-input ng-untouched ng-pristine ng-invalid' and @formcontrolname='scale_start']")
	private WebElement txtScaleStartValue;
	
	@FindBy(xpath = "//input[@class='form-control seacrh-input ng-pristine ng-invalid ng-untouched' and @formcontrolname='scale_start']")
	private WebElement txtScaleStartValueTwo;
	
	@FindBy(xpath = "//input[@formcontrolname='scale_start' and @class='form-control seacrh-input ng-pristine ng-invalid ng-touched']")
	private WebElement txtTouchedScaleStartValue;
	
	@FindBy(xpath = "//input[@formcontrolname='scale_end']")
	private WebElement txtScaleEndValue;
	
	@FindBy(xpath = "//input[@class='form-control seacrh-input ng-pristine ng-invalid ng-touched' and @formcontrolname='scale_end']")
	private WebElement txtTouchedScaleEndValue;
	
	@FindBy(xpath = "//input[@class='form-control seacrh-input ng-pristine ng-invalid ng-untouched' and @formcontrolname='scale_end']")
	private WebElement txtScaleEndValueTwo;
	
	@FindBy(xpath = "//button[text()=' Save ' and @class='btn btn-outline-primary btn-block ng-star-inserted'][1]")
	private WebElement btnSave;
	
	@FindBy(xpath = "//span[text()=' Engagement parameter name is required ' and @class='error-text ng-star-inserted']")
	private WebElement lblParameterRequired;
	
	@FindBy(xpath = "//span[text()=' Scale start value is required ' and @class='error-text ng-star-inserted']")
	private WebElement lblScaleStartRequired;
	
	@FindBy(xpath = "//span[text()=' Scale end value is required ' and @class='error-text ng-star-inserted']")
	private WebElement lblScaleEndRequired;
	
	@FindBy(xpath = "//form[@class='ng-untouched ng-pristine ng-invalid']//input[@placeholder='Enter Performance Parameter Name']")
	private WebElement txtParamName;

	@FindBy(xpath = "//div[@class='form-group']//input[@formcontrolname='scale_end']")
	private WebElement txtScaleEndValues;
	
	@FindBy(xpath = "//div[@class='form-group']//input[@formcontrolname='scale_start']")
	private WebElement txtScaleStartValues;
	
	@FindBy(xpath = "//h3[text()=' Employee on Board (Scale 5-10) ']//following-sibling::span//i[@id='add-sub-parameters']")
	private WebElement btnAddSubParameter;
	
	@FindBy(xpath = "(//button[text()=' Save ' and @class='btn btn-outline-primary btn-block ng-star-inserted'])[2]")
	private WebElement btnSubParameterSave;
	
	@FindBy(xpath = "(//div[@class='form-group']//input[@placeholder='Enter Performance Parameter Name'])[2]")
	private WebElement txtSubEngagementParameterName;
	
	@FindBy(xpath = "//h4[contains(text(),'Add New Sub-Parameter')]//following-sibling::button[@class='close']")
	private WebElement btnSubParameterClose;
	
	@FindBy(xpath = "//h3[text()=' Employee on Board (Scale 5-10) ']//following-sibling::span//i[@id='edit-parameters']")
	private WebElement btnUpdateEngagementParameter;
	
	@FindBy(xpath = "//button[@type='submit' and @class='btn btn-outline-primary btn-block ng-star-inserted'][1]")
	private WebElement btnUpdate;
	
	@FindBy(xpath = "//form[@class='ng-untouched ng-pristine ng-valid']//input[@placeholder='Enter Performance Parameter Name']")
	private WebElement txtEditSubEngagementParamName;

	@FindBy(xpath = "//h4[contains(text(),'Update Engagement Parameter')]//following-sibling::button[@class='close']")
	private WebElement btnUpdateSubParameterClose;

	@FindBy(xpath = "//h4[contains(text(),'Add New Engagement Parameter')]")
	private WebElement lblAddNewEngagementParameter;

	@FindBy(xpath = "//span[contains(text(),' Scale end value is required')]")
	private WebElement lblEndValueIsRequired;
	
	@FindBy(xpath = "//span[contains(text(),' Scale start value is required ')]")
	private WebElement lblStartValueIsRequired;
	
	@FindBy(xpath = "//div[@class='modal-body']//child::div/div/div/div/label[contains(text(),'Engagement Parameter Name ')]/following::input/following::div/following::span[contains(text(),' Engagement parameter name is required ')]")
	private WebElement lblParameterNameIsRequired;

	@FindBy(xpath = "//div[@class='modal-content']//child::div/following::h4[contains(text(),'Add New Sub-Parameter in Employee on Board ')]")
	private WebElement lblAddNewSubParameterEmployeeOnBoard;
	
	@FindBy(xpath = "//h4[contains(text(),'Update Engagement Parameter')]")
	private WebElement lblUpdateEngagementParameter;

	@FindBy(xpath = "//div[contains(text(),' Employee Engagement Parameter Updated Successfully ')]")
	private WebElement lblEmployeeEngagementParameterUpdatedSuccessfully;
	
	private static final Logger logger = Logger.getLogger(HonohrPulseCreateSurveyDefineEngagementParameterPage.class.getName());

	public HonohrPulseCreateSurveyDefineEngagementParameterPage(WebDriver driver) {
		super(driver);

		logger.info("Starting of HonohrPulseCreateSurveyDefineEngagementParameterPage method");

		PageFactory.initElements(driver, this);

		logger.info("Ending of HonohrPulseCreateSurveyDefineEngagementParameterPage method");
	}
	
	public synchronized void clickOnConfigurationButton() {
		logger.info("Starting of clickOnConfigurationButton method");

		//clickOnWebElement(btnConfiguration);
		this.btnConfiguration.click();

		logger.info("Ending of clickOnConfigurationButton method");
	}
	
	public synchronized void clickOnEngagementParameter() {
		logger.info("Starting of clickOnEngagementParameter method");

		this.lblDefineEngParameter.click();

		logger.info("Ending of clickOnEngagementParameter method");
	}

	public synchronized String getEngagementParameterText() {
		logger.info("Starting of getEngagementParameterText method");
		logger.info("Ending of getEngagementParameterText method");

		return lblEngagementParameter.getText();
	}
	
	public synchronized void clickOnAddParameterButton() {
		logger.info("Starting of clickOnAddParameterButton method");
		
		try {
			waitForElementToBeClikable(btnAddParameters);
			//explicitWait(btnAddParameters);
			this.btnAddParameters.click();
			
		} catch (Exception e) {
			this.clickOnWebElement(btnAddParameters);
		}

		logger.info("Ending of clickOnAddParameterButton method");
	}

   public synchronized void setParameterName(String strParameterName) throws InterruptedException {
		logger.info("Starting of setParameterName method");
		
			Thread.sleep(3000);
        	this.txtParameterName.sendKeys(strParameterName);
                
		logger.info("Ending of setParameterName method");
	}
   
   public synchronized void setTouchedParameterName(String strParameterName) {
		logger.info("Starting of setParameterName method");
       
        	this.txtTouchedParameterName.sendKeys(strParameterName);
        
		logger.info("Ending of setParameterName method");
	}
   
   public synchronized void setScaleStartValue(String strStartScaleValue) {
 		logger.info("Starting of setScaleStartValue method");

 		//clickOnWebElement(txtScaleStartValue);
 		this.txtScaleStartValue.sendKeys(strStartScaleValue);

 		logger.info("Ending of setScaleStartValue method");
 	}
   
   public synchronized void setScaleEndValue(String strScaleEndValue){
 		logger.info("Starting of setScaleEndValue method");

 		try {
 			this.txtScaleEndValue.click();
 			this.txtScaleEndValue.sendKeys(strScaleEndValue);
		} catch (Exception e) {
			this.clickOnWebElement(txtScaleEndValue);
			this.txtScaleEndValue.sendKeys(strScaleEndValue);
		}
 
 		logger.info("Ending of setScaleEndValue method");
 	}
   
	public synchronized void clickOnSaveButton() {
		logger.info("Starting of clickOnSaveButton method");
		try {
			this.explicitWait(btnSave);
			this.btnSave.click();

		} catch (Exception e) {
			
			this.clickOnWebElement(btnSave);
		}

		logger.info("Ending of clickOnSaveButton method");
	}
	
	public synchronized String getEngagementParameterRequiredText() {
		logger.info("Starting of getEngagementParameterRequiredText method");
		logger.info("Ending of getEngagementParameterRequiredText method");

		return lblParameterRequired.getText();
	}
	
	public synchronized String getScaleStartValueRequiredText() {
		logger.info("Starting of getScaleStartValueRequiredText method");
		logger.info("Ending of getScaleStartValueRequiredText method");

		return lblScaleStartRequired.getText();
	}
	
	public synchronized String getScaleEndValueRequiredText() {
		logger.info("Starting of getScaleEndValueRequiredText method");
		logger.info("Ending of getScaleEndValueRequiredText method");

		return lblScaleEndRequired.getText();
	}
	
	public synchronized void clickOnCloseButton() {
		logger.info("Starting of clickOnCloseButton method");

		try {
			this.btnClose.click();

		} catch (Exception e) {
			
			clickOnWebElement(btnClose);
		}
		
		logger.info("Ending of clickOnCloseButton method");
	}
	
	   public synchronized void setEngParamValue(String strEngParamValue) throws InterruptedException {
	 		logger.info("Starting of setEngParamValue method");

	 		Thread.sleep(1000);
	 		this.txtParameterNameTwo.sendKeys(strEngParamValue);

	 		logger.info("Ending of setEngParamValue method");
	 	}
	   
	   public synchronized void setScaleStartValueTwo(String strScaleStartValue) throws InterruptedException {
	 		logger.info("Starting of setScaleStartValueTwo method");

	 		Thread.sleep(1000);
	 		this.txtScaleStartValueTwo.sendKeys(strScaleStartValue);

	 		logger.info("Ending of setScaleStartValueTwo method");
	 	}
	   
	   public synchronized void setScaleEndValueTwo(String strScaleEndValue) throws InterruptedException {
	 		logger.info("Starting of setScaleEndValueTwo method");

	 		Thread.sleep(1000);
	 		this.txtScaleEndValueTwo.sendKeys(strScaleEndValue);

	 		logger.info("Ending of setScaleEndValueTwo method");
	 	}
	   
	   public synchronized void setParamValue(String strEngParamValue) throws InterruptedException {
	 		logger.info("Starting of setParamValue method");

	 		Thread.sleep(1000);
	 		
	 		this.txtParamName.sendKeys(strEngParamValue);

	 		logger.info("Ending of setParamValue method");
	 	}
	   
	   public synchronized void setScaleEndValueText(String strScaleEndValue) throws InterruptedException {
	 		logger.info("Starting of setScaleEndValueText method");

	 		Thread.sleep(1000);
	 		this.txtScaleEndValues.sendKeys(strScaleEndValue);

	 		logger.info("Ending of setScaleEndValueText method");
	 	}
	   
	   public synchronized void setScaleStartValueText(String strScaleStartValue) throws InterruptedException {
	 		logger.info("Starting of setScaleStartValueText method");

	 		Thread.sleep(1000);
	 		this.txtScaleStartValues.sendKeys(strScaleStartValue);

	 		logger.info("Ending of setScaleStartValueText method");
	 	}
	    
	   public synchronized void clickOnAddSubParameterButton() {
	 		logger.info("Starting of clickOnAddSubParameterButton method");
	 		
             try {
            	// explicitWait(btnAddSubParameter);
            	 this.btnAddSubParameter.click();
			} catch (Exception e) {
				clickOnWebElement(btnAddParameters);
			}
	 		

	 		logger.info("Ending of clickOnAddSubParameterButton method");
	 	}
	   
	   public synchronized void setSubEngagementParameterText(String strScaleEndValue) throws InterruptedException {
	 		logger.info("Starting of setSubEngagementParameterText method");
	 		
	 		Thread.sleep(2000);
           	 this.txtSubEngagementParameterName.sendKeys(strScaleEndValue);
           	
	 		logger.info("Ending of setSubEngagementParameterText method");
	 	}
	   
	   public synchronized void clickOnSubParameterSaveButton() {
	 		logger.info("Starting of clickOnSubParameterSaveButton method");
	 		
            try {
           
           	 this.btnSubParameterSave.click();
			} catch (Exception e) {
				clickOnWebElement(btnSubParameterSave);
			}

	 		logger.info("Ending of clickOnSubParameterSaveButton method");
	 	}
	   
	   public synchronized void clickOnSubParameterCloseButton() {
	 		logger.info("Starting of clickOnSubParameterCloseButton method");
	 		
            try {
           
           	 this.btnSubParameterClose.click();
			} catch (Exception e) {
				clickOnWebElement(btnSubParameterClose);
			}

	 		logger.info("Ending of clickOnSubParameterCloseButton method");
	 	}
	   
	   public synchronized void clickOnUpdateEngagementParameterButton() {
	 		logger.info("Starting of clickOnUpdateEngagementParameterButton method");
	 		
           try {
        	   //this.refresh();
        	   this.explicitWait(btnUpdateEngagementParameter);
          	 this.btnUpdateEngagementParameter.click();
			} catch (Exception e) {
				clickOnWebElement(btnUpdateEngagementParameter);
			}

	 		logger.info("Ending of clickOnUpdateEngagementParameterButton method");
	 	}
	   
	   public synchronized void clickOnEngParameterName() throws InterruptedException {
	 		logger.info("Starting of clickOnEngParameterName method");

	 		Thread.sleep(1000);
	 		
	 		this.txtEditSubEngagementParamName.clear();
	 		this.txtScaleStartValues.click();
	 		
	 		logger.info("Ending of clickOnEngParameterName method");
	 	}
	   
	   public synchronized void setUpdateEngParameterValue(String strEngParamValue) throws InterruptedException {
	 		logger.info("Starting of setParamValue method");

	 		Thread.sleep(1000);
	 		this.txtEditSubEngagementParamName.sendKeys(strEngParamValue);
	 		Thread.sleep(10000);
	 		logger.info("Ending of setParamValue method");
	 	}
	   
	   public synchronized void clickOnUpdateButton() throws InterruptedException {
	 		logger.info("Starting of clickOnUpdateButton method");
	 		
	 		Thread.sleep(1000);
	 		this.btnUpdate.click();

	 		logger.info("Ending of clickOnUpdateButton method");
	 	}
		
		public synchronized void clickOnScaleStartValue() throws InterruptedException {
	 		logger.info("Starting of clickOnScaleStartValue method");

	 		Thread.sleep(1000);
	 		
	 		this.txtScaleStartValues.clear();
	 		
	 		logger.info("Ending of clickOnScaleStartValue method");
	 	}
		
		public synchronized void clickOnScaleEndValue() throws InterruptedException {
	 		logger.info("Starting of clickOnScaleEndValue method");

	 		Thread.sleep(1000);
	 		
	 		this.txtScaleEndValues.clear();
	 		
	 		logger.info("Ending of clickOnScaleEndValue method");
	 	}
	 	
	 	public synchronized void clickOnUpdateCloseButton() throws InterruptedException {
	 		logger.info("Starting of clickOnUpdateCloseButton method");

	 		Thread.sleep(3000);
	 		
	 		this.btnUpdateSubParameterClose.click();
	 		
	 		logger.info("Ending of clickOnUpdateCloseButton method");
	 	}
	 	
	 	
	 	public String getAddEngagaeMentParameterText() {
			this.explicitWait(lblAddNewEngagementParameter);
			
	 		logger.info("Starting of getAddEngagaeMentParameterText method");
	 		logger.info("ending of getAddEngagaeMentParameterText method");

	 		return lblAddNewEngagementParameter.getText();
	 	}
	 	
	 	public String getEndValueIsRequiredText() {
			this.explicitWait(lblEndValueIsRequired);
			
	 		logger.info("Starting of getEndValueIsRequiredText method");
	 		logger.info("ending of getEndValueIsRequiredText method");

	 		return lblEndValueIsRequired.getText();
	 		
	 	}
	 	
	 	public String getStartValueIsRequiredText() {
			this.explicitWait(lblStartValueIsRequired);
			
	 		logger.info("Starting of getStartValueIsRequiredText method");
	 		logger.info("Ending of getStartValueIsRequiredText method");

	 		return lblStartValueIsRequired.getText();
	 	}
	 	
	 	public boolean isParameterNameIsRequiredMessageDisplayed() {
			logger.info("Starting of isParameterNameIsRequiredMessageDisplayed");
	 		logger.info("ending of isParameterNameIsRequiredMessageDisplayed");
	 		
	 		this.explicitWait(lblParameterNameIsRequired);
			return lblParameterNameIsRequired.isDisplayed();
		}
	 	
	 	public String getAddSubParameterEmployeeOnBoardText() {
			
	 		logger.info("Starting of getAddSubParameterEmployeeOnBoardText method");
	 		logger.info("ending of getAddSubParameterEmployeeOnBoardText method");
	 		
            this.explicitWait(lblAddNewSubParameterEmployeeOnBoard);
            
	 		return lblAddNewSubParameterEmployeeOnBoard.getText();
	 		
	 	}
	 	
	 	public String getParameterNameIsRequiredText() {
			
	 		logger.info("Starting of getParameterNameIsRequiredText method");
	 		logger.info("ending of getParameterNameIsRequiredText method");
	 		
            this.explicitWait(lblParameterNameIsRequired);
            
	 		return lblParameterNameIsRequired.getText();
	 		
	 	}
	 	
	 	public String getUpadteEngagementParameterText() {
			
			this.explicitWait(lblUpdateEngagementParameter);
			
	 		logger.info("Starting of getUpadteEngagementParameterText method");
	 		logger.info("ending of getUpadteEngagementParameterText method");

	 		return lblUpdateEngagementParameter.getText();
	 	}
		
	 	public String getEmployeeEngagementParameterUpdatedSuccessfullyText() {
			this.explicitWait(lblEmployeeEngagementParameterUpdatedSuccessfully);
			
	 		logger.info("Starting of getEmployeeEngagementParameterUpdatedSuccessfullyText method");
	 		logger.info("ending of getEmployeeEngagementParameterUpdatedSuccessfullyText method");

	 		return lblEmployeeEngagementParameterUpdatedSuccessfully.getText();
	 		
	 	}
		







}