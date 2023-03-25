package com.honohr.pulse.createsurvey.pages;

	import org.apache.log4j.Logger;
	import org.openqa.selenium.WebDriver;
	import org.openqa.selenium.WebElement;
	import org.openqa.selenium.support.FindBy;
	import org.openqa.selenium.support.PageFactory;

import com.honohr.pulse.base.pages.BaseHonoPulseAutomationPage;

	public class HonohrPulseCreateSurveyWelcomePage extends BaseHonoPulseAutomationPage {

		@FindBy(xpath = "//iframe[@class='tox-edit-area__iframe']/../../../../../../preceding-sibling::div/editor/div/div/div/div/iframe")
		private WebElement txtIframe;

		@FindBy(xpath = "//div[@id='welcome-description']//iframe")
		private WebElement iframe;

		@FindBy(xpath = "//body[@data-mce-placeholder='Welcome title here...']")
		private WebElement txtWelComeTitle;

		@FindBy(xpath = "//body[@aria-placeholder='Welcome description here...']")
		private WebElement txtWelComeDescription;

		@FindBy(xpath = "//div[@class='col-lg-12 save_btm mt-3']//button[text()=' Update ']")
		private WebElement btnsave;

		private static final Logger logger = Logger.getLogger(HonohrPulseCreateSurveyWelcomePage.class.getName());

		public HonohrPulseCreateSurveyWelcomePage(WebDriver driver) {
			super(driver);
			logger.info("Starting of WelComeTabPage method");

			PageFactory.initElements(driver, this);

			logger.info("Ending of WelComeTabPage method");
		}
		
		public boolean isWelcomeTitlTextDisplayed() {
			logger.info("Starting of isWelcomeTitlehereTextDisplayed Method");
			logger.info("Ending of isWelcomeTitlehereTextDisplayed Method");
			
			this.driver.switchTo().frame(txtIframe);
			this.scrollIntoView(txtWelComeTitle);
			
			return txtWelComeTitle.isDisplayed();
		}

		public synchronized void setWelComeTitleText(String strWelComeTitleTextField) {
			logger.info("Starting of setWelComeTitleTextField Method");

			try {
				Thread.sleep(3000);
				this.scrollIntoView(txtWelComeTitle);
				this.txtWelComeTitle.sendKeys(strWelComeTitleTextField);

			} catch (Exception e) {
				// TODO: handle exception
			}

			logger.info("Ending of setWelComeTitleTextField Method");
		}
		
		public boolean isWelcomeDescriptionDisplayed() throws InterruptedException {
			logger.info("Starting of isWelcomeDescriptionDisplayed Method");
			logger.info("Ending of isWelcomeDescriptionDisplayed Method");
			
			Thread.sleep(3000);
			driver.switchTo().defaultContent();
			this.driver.switchTo().frame(iframe);
			this.scrollIntoView(txtWelComeDescription);
			
			return txtWelComeDescription.isDisplayed();
		}

		public synchronized void setWelComeDescription(String strWelComeDescription) {
			logger.info("Starting of setWelComeDescription Method");

			try {
				//Thread.sleep(3000);
				//driver.switchTo().defaultContent();
				//this.driver.switchTo().frame(iframe);
				this.scrollIntoView(txtWelComeDescription);
				clickOnWebElement(txtWelComeDescription);
				this.txtWelComeDescription.sendKeys(strWelComeDescription);

			} catch (Exception e) {

			}

			logger.info("Ending of setWelComeDescription Method");
		}

		public synchronized void clickOnSaveButton() {
			logger.info("Starting of clickOnSaveButton Method");

			try {
				driver.switchTo().defaultContent();
				this.scrollIntoView(btnsave);
				this.waitForElementToBeClikable(btnsave);
				clickOnWebElement(btnsave);

			} catch (Exception e) {
				btnsave.click();
			}

			logger.info("Ending of clickOnSaveButton Method");
		}
	}

