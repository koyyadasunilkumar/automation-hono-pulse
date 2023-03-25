package com.honohr.pulse.createsurvey.pages;

	import org.apache.log4j.Logger;
	import org.openqa.selenium.WebDriver;
	import org.openqa.selenium.WebElement;
	import org.openqa.selenium.support.FindBy;
	import org.openqa.selenium.support.PageFactory;

import com.honohr.pulse.base.pages.BaseHonoPulseAutomationPage;

	public class HonohrPulseCreateSurveyPreviewPage extends BaseHonoPulseAutomationPage {

		@FindBy(xpath = "//div[@id='preview-button']//span[text()='Preview']")
		private WebElement btnPreview;

		@FindBy(xpath = "//section[@class='frame_preview']")
		private WebElement lblWindowPreview;

		@FindBy(xpath = "//button[contains(text(),' Start ')]")
		private WebElement btnStart;

		@FindBy(xpath = "//div[@class='col-12 scoll_height ng-star-inserted']")
		private WebElement lblAddedQuestion;

		@FindBy(xpath = "//ul[@class='max-width-content d-block']//span[text()='A']")
		private WebElement btnAnswerOptions;

		@FindBy(xpath = "//textarea[@class='ng-untouched ng-pristine ng-valid']")
		private WebElement txtAddComments;

		@FindBy(xpath="//span[contains(text(),'Next')]")
		private WebElement btnTextQuestionNext;
		
		@FindBy(xpath="(//label[contains(text(),'Agree')])[5]")
		private WebElement btnImageAnswerOption;
		
		@FindBy(xpath="//span[contains(text(),'Next')]")
		private WebElement btnImageQuestionNext;
		
		@FindBy(xpath="(//label[contains(text(),'Strongly Agree')])[3]")
		private WebElement btnAudioQuestionOption;
		
		@FindBy(xpath="//span[contains(text(),'Next')]")
		private WebElement btnAudioQuestionNext;
		
		@FindBy(xpath="(//label[contains(text(),'Neutral')])[3]")
		private WebElement btnVideoQuestionOption;

		@FindBy(xpath = "//a[@class='next_preview_question pull-right ng-star-inserted']")
		private WebElement btnSubmit;

		@FindBy(xpath = "//div[@class='backgroundd w-100']")
		private WebElement lblThankYouTitleAndMessage;

		@FindBy(xpath = "//a[@class='close_icon']")
		private WebElement btnClose;

		@FindBy(xpath = "//span[text()='Publish ']")
		private WebElement btnPublish;
		
		@FindBy(xpath = "//h4[text()='Choose your preferred language']")
		private WebElement lblPreferedLang;
		
		@FindBy(xpath = "//p[text()='Onboarding Survey completed successfully']")
		private WebElement lblThankYouMsg;
		
		@FindBy(xpath = "//div[@class='overlay-container']//div[text()=' Add questions to see preview ']")
		private WebElement msgAddQustions;
		
		@FindBy(xpath = "//div[@class='overlay-container']//div[@aria-label=\"Fill survey's basic details first!\"]")
		private WebElement msgFillBasicDetails;

		@FindBy(xpath = "//ul[@id='custom-tabs-four-tab']//a[text()='Question']")
		private WebElement btnQuestion;
		
		@FindBy(xpath = "//ul[@id='custom-tabs-four-tab']//a[text()='Design']")
		private WebElement btnDesign;

		@FindBy(xpath = "//ul[@id='custom-tabs-four-tab']//a[text()='General ']")
		private WebElement btnGeneral;
		
		@FindBy(xpath = "//div[@class=\"overlay-container\"]//div[text()=' Add survey design first! ']")
		private WebElement msgAddSurveyDesignFirst;

		@FindBy(xpath = "//div[@id='toast-container']//div[text()=' This is required question, Please select option then move to next question ']")
		private WebElement msgSelectOptionFirst;
		
		private static final Logger logger = Logger.getLogger(HonohrPulseCreateSurveyPreviewPage.class.getName());

		public HonohrPulseCreateSurveyPreviewPage(WebDriver driver) {
			super(driver);
			logger.info("Starting of PreviewPage method");

			PageFactory.initElements(driver, this);

			logger.info("Ending of PreviewPage method");
		}
		
		public boolean isThankyouMessageDisplayed() {

			logger.info("Starting of isThankyouMessageDisplayed Method");
			logger.info("Ending isThankyouMessageDisplayed Method");

			return lblThankYouMsg.isDisplayed();
		}

		public void clickOnPreviewButton() {
			logger.info("Starting of clickOnPreviewButton Method");
			try {
				explicitWait(btnPreview);
				this.waitForElementToBeClikable(btnPreview);
				clickOnWebElement(btnPreview);

			} catch (Exception e) {
				this.btnPreview.click();
			}
			logger.info("Ending of clickOnPreviewButton Method");
		}
		
		public String getPreviewButtonText() {
			logger.info("Starting of getPreviewButtonText Method");
			logger.info("Ending of getPreviewButtonText Method");
			
			return btnPreview.getText() ;
		}

		public void clickOnStartButton() {
			logger.info("Starting of clickOnStartButton Method");

			try {
				Thread.sleep(5000);
				explicitWait(btnStart);
				this.btnStart.click();
			} catch (Exception e) {
				this.clickOnWebElement(btnStart);
			}

			logger.info("Ending of clickOnStartButton Method");
		}

		public boolean isAddedQuestionDisplayed() {
			logger.info("Starting of isAddedQuestionDisplayed Method");
			logger.info("Ending of isAddedQuestionDisplayed Method");

			return lblAddedQuestion.isDisplayed();
		}

		public void clickOnAnswerOptionButton() {
			logger.info("Starting of clickOnAnswerOptionButton Method");

			try {
				explicitWait(btnAnswerOptions);
				waitForElementToBeClikable(btnAnswerOptions);
				this.clickOnWebElement(btnAnswerOptions);
			} catch (Exception e) {
				this.btnAnswerOptions.click();
			}

			logger.info("Ending of clickOnAnswerOptionButton Method");
		}

		public void clickOnTextQuestionNextButton() {
			logger.info("Starting of clickOnTextQuestionNextButton Method");
			
			try {
				explicitWait(btnTextQuestionNext);
				waitForElementToBeClikable(btnTextQuestionNext);
				this.clickOnWebElement(btnTextQuestionNext);
			} catch (Exception e) {
				this.btnTextQuestionNext.click();
			}
			logger.info("Ending of clickOnTextQuestionNextButton Method");
		}

		public void clickOnImageAnswerOptionButton() {
			logger.info("Starting of clickOnImageAnswerOptionButton Method");
			try {
				explicitWait(btnImageAnswerOption);
				waitForElementToBeClikable(btnImageAnswerOption);
				this.clickOnWebElement(btnImageAnswerOption);
			} catch (Exception e) {
				this.btnImageAnswerOption.click();
			}
			
			logger.info("Ending of clickOnImageAnswerOptionButton Method");
			}

		public void clickOnImageQuestionNextButton() {
			logger.info("Starting of clickOnImageQuestionNextButton Method");
			
			try {
				explicitWait(btnImageQuestionNext);
				waitForElementToBeClikable(btnImageQuestionNext);
				this.clickOnWebElement(btnImageQuestionNext);
			} catch (Exception e) {
				this.btnImageQuestionNext.click();
			}
			logger.info("Ending of clickOnImageQuestionNextButton Method");
		}

		public void clickOnAudioQuestionOption() {
			logger.info("Starting of clickOnAudioQuestionOption Method");
			try {
				explicitWait(btnAudioQuestionOption);
				waitForElementToBeClikable(btnAudioQuestionOption);
				this.clickOnWebElement(btnAudioQuestionOption);
			} catch (Exception e) {
				this.btnAudioQuestionOption.click();
			}
			logger.info("Ending of clickOnAudioQuestionOption Method");
				
		}
		
		public void clickOnAudioQuestionNext() {
			logger.info("Starting of clickOnAudioQuestionNext Method");
			
			try {
				explicitWait(btnAudioQuestionNext);
				waitForElementToBeClikable(btnAudioQuestionNext);
				this.clickOnWebElement(btnAudioQuestionNext);
			} catch (Exception e) {
				this.btnAudioQuestionNext.click();
			}
				
			logger.info("Endinng of clickOnAudioQuestionNext Method");
		}
		
		public void clickOnVideoQuestionOption() {
			logger.info("Starting of clickOnVideoQuestionOption Method");
			try {
				explicitWait(btnVideoQuestionOption);
				waitForElementToBeClikable(btnVideoQuestionOption);
				this.clickOnWebElement(btnVideoQuestionOption);
			} catch (Exception e) {
				this.btnVideoQuestionOption.click();
			}
			logger.info("Ending of clickOnVideoQuestionOption Method");
				
		}
		public void clickOnSubmitButton() {
			logger.info("Starting of clickOnSubmitButton Method");
					
			try {
				Thread.sleep(3000);
				this.clickOnWebElement(btnSubmit);
			} catch (Exception e) {
				this.btnSubmit.click();
			}

			logger.info("Ending of clickOnSubmitButton Method");
		}

		public boolean isThankYouTitleAndMessageDisplayed() {
			logger.info("Starting of isThankYouTitleAndMessageDisplayed Method");
			logger.info("Ending of isThankYouTitleAndMessageDisplayed Method");

			return lblThankYouTitleAndMessage.isDisplayed();
		}

		public void clickOnCloseButton() {
			logger.info("Starting of clickOnCloseButton Method");

			this.clickOnWebElement(btnClose);

			logger.info("Ending of clickOnCloseButton Method");
		}

		public void clickOnPublishButton() {
			logger.info("Starting of clickOnPublishButton Method");

			try {
				explicitWait(btnPublish);
				this.btnPublish.click();
			} catch (Exception e) {
				this.clickOnWebElement(btnPublish);
			}

			logger.info("Ending of clickOnPublishButton Method");
		}
		
		public void clickOnAddComments(String strComments) {
			logger.info("Starting of clickOnAddComments Method");

			try {
				explicitWait(txtAddComments);
				clickOnWebElement(txtAddComments);
				txtAddComments.sendKeys(strComments);
			} catch (Exception e) {
			}

			logger.info("Ending of clickOnAddComments Method");
		}
		
		public String getPreferedLangText() {
			logger.info("Starting of getPreferedLangText Method");
			logger.info("Ending of getPreferedLangText Method");
			
			return lblPreferedLang.getText();
		}
		
		public String getAddQuestionsToSeePreviewText() {
			logger.info("Starting of getAddQuestionsToSeePreviewText Method");
			logger.info("Ending of getAddQuestionsToSeePreviewText Method");
			
			explicitWait(msgAddQustions);
			return msgAddQustions.getText();
		}
		
		public String getFillBasicDetailsFirstText() {
			logger.info("Starting of getFillBasicDetailsFirstText Method");
			logger.info("Ending of getFillBasicDetailsFirstText Method");
			
			return msgFillBasicDetails.getText();
		}
		
		public void clickOnQuestionButton() {
			logger.info("Starting of clickOnQuestionButton Method");

			try {
				explicitWait(btnQuestion);
				clickOnWebElement(btnQuestion);
				
			} catch (Exception e) {
				this.btnQuestion.click();
			}

			logger.info("Ending of clickOnQuestionButton Method");
		}
		
		public void clickOnDesignButton() {
			logger.info("Starting of clickOnDesignButton Method");

			try {
				explicitWait(btnDesign);
				clickOnWebElement(btnDesign);
				
			} catch (Exception e) {
				this.btnDesign.click();
			}

			logger.info("Ending of clickOnDesignButton Method");
		}
		
		public void clickOnGeneralButton() {
			logger.info("Starting of clickOnGeneralButton Method");

			try {
				explicitWait(btnGeneral);
				clickOnWebElement(btnGeneral);
				
			} catch (Exception e) {
				this.btnGeneral.click();
			}

			logger.info("Ending of clickOnGeneralButton Method");
		}

		public String getAddSurveyDesignFirstText() {
			logger.info("Starting of getAddSurveyDesignFirstText Method");
			logger.info("Ending of getAddSurveyDesignFirstText Method");
			
			explicitWait(msgAddSurveyDesignFirst);
			return msgAddSurveyDesignFirst.getText();
		}

		public String getSelectOptionFirstFirstText() {
			logger.info("Starting of getSelectOptionFirstFirstText Method");
			logger.info("Ending of getSelectOptionFirstFirstText Method");
			
			explicitWait(msgSelectOptionFirst);
			return msgSelectOptionFirst.getText();
		}
	}