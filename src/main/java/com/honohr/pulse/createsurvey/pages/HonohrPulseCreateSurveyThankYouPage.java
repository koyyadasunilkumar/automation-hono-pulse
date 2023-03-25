package com.honohr.pulse.createsurvey.pages;

	import org.apache.log4j.Logger;
	import org.openqa.selenium.WebDriver;
	import org.openqa.selenium.WebElement;
	import org.openqa.selenium.support.FindBy;
	import org.openqa.selenium.support.PageFactory;

import com.honohr.pulse.base.pages.BaseHonoPulseAutomationPage;

	public class HonohrPulseCreateSurveyThankYouPage extends BaseHonoPulseAutomationPage {

		@FindBy(xpath = "//iframe[@class='tox-edit-area__iframe']/../../../../../../preceding-sibling::div/editor/div/div/div/div/iframe")
		private WebElement txtIframe;

		@FindBy(xpath = "//iframe[@class='tox-edit-area__iframe']/../../../../../../following-sibling::div/editor/div/div/div/div/iframe")
		private WebElement iframe;

		@FindBy(xpath = "//body[@data-mce-placeholder='Thank you title here...']")
		private WebElement txtThankYouTitle;

		@FindBy(xpath = "//body[@data-mce-placeholder='Thank you message goes here...']")
		private WebElement txtThabkYouMessage;
		
		@FindBy(xpath="//div[@class='col-lg-12 question_main']//button[text()=' Update ']")
		private WebElement btnUpDate;
		
		@FindBy(xpath = "//div[@id='preview-button']//span[text()='Preview']")
		private WebElement btnPreview;


		private static final Logger logger = Logger.getLogger(HonohrPulseCreateSurveyThankYouPage.class.getName());

		public HonohrPulseCreateSurveyThankYouPage(WebDriver driver) {
			super(driver);
			logger.info("Starting of ThankYouTabPage method");

			PageFactory.initElements(driver, this);

			logger.info("Ending of ThankYouTabPage method");

		}
		
		public boolean isThankYouTitleDisplayed() throws InterruptedException {
			logger.info("Starting of isThankYouTitleDisplayed Method");
			logger.info("Ending of isThankYouTitleDisplayed Method");
			Thread.sleep(3000);
			this.driver.switchTo().frame(txtIframe);
			this.scrollIntoView(txtThankYouTitle);

			return txtThankYouTitle.isDisplayed();
		}

		public synchronized void setThankYouTitle(String strThankYouTitle) {
			logger.info("Starting of setThankYouTitle Method");

			try {
				Thread.sleep(3000);
				//this.driver.switchTo().frame(txtIframe);
				this.scrollIntoView(txtThankYouTitle);
				this.txtThankYouTitle.sendKeys(strThankYouTitle);
			} catch (Exception e) {
			}

			logger.info("Ending of setThankYouTitle Method");

		}
		
		public boolean isThankYouMessageDisplayed() throws InterruptedException {
			logger.info("Starting of isThankYouMessageDisplayed Method");
			logger.info("Ending of isThankYouMessageDisplayed Method");
			Thread.sleep(3000);
			driver.switchTo().defaultContent();
			this.driver.switchTo().frame(iframe);
			this.scrollIntoView(txtThabkYouMessage);

			return txtThabkYouMessage.isDisplayed();
		}

		public synchronized void setThankYouMessage(String strThankYouMessage) {
			logger.info("Starting of setThankYouMessage Method");

			try {
				Thread.sleep(3000);
				//driver.switchTo().defaultContent();
				//this.driver.switchTo().frame(iframe);
				this.scrollIntoView(txtThabkYouMessage);
				this.txtThabkYouMessage.sendKeys(strThankYouMessage);
			} catch (Exception e) {
			}

			logger.info("Ending of setThankYouMessage Method");

		}

		public synchronized void clickOnUpDateButton() {
			logger.info("Starting of clickOnUpDateButton Method");

			try {
				driver.switchTo().defaultContent();
				//this.scrollIntoView(btnUpDate);
				this.waitForElementToBeClikable(btnUpDate);
				clickOnWebElement(btnUpDate);
			} catch (Exception e) {
				this.btnUpDate.click();
			}

			logger.info("Ending of clickOnUpDateButton Method");
		}
		
		public void clickOnPreviewButton() throws InterruptedException {
			logger.info("Starting of clickOnPreviewButton Method");
			try {
				Thread.sleep(5000);
				explicitWait(btnPreview);
				clickOnWebElement(btnPreview);
				
			} catch (Exception e) {
				Thread.sleep(5000);
				explicitWait(btnPreview);
				this.btnPreview.click();
			}
			logger.info("Ending of clickOnPreviewButton Method");
		}
	}
