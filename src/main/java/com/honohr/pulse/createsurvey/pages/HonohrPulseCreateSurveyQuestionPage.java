package com.honohr.pulse.createsurvey.pages;

import java.io.File;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.honohr.pulse.base.pages.BaseHonoPulseAutomationPage;

public class HonohrPulseCreateSurveyQuestionPage extends BaseHonoPulseAutomationPage {

	@FindBy(xpath = "//a[@id='custom-tabs-four-home-tab']")
	private WebElement lblQuestionTab;

	@FindBy(xpath = "//div[@id='question-category']//select[@id='question-category-selection']")
	private WebElement btnQuestionType;

	@FindBy(xpath = "//select[@formcontrolname='parameter']")
	private WebElement btnEngParameter;

	@FindBy(xpath = "//select[@formcontrolname='subParameter']")
	private WebElement btnSubParameter;

	@FindBy(xpath = "//div[@class='sectr1 ng-star-inserted']//select[@formcontrolname='scale']")
	private WebElement btnScale;

	@FindBy(xpath = "//select[@formcontrolname='likert_scale']")
	private WebElement btnLikertScale;

	@FindBy(xpath = "//div[@id='question-opinion-minimum-value']//child::input")
	private WebElement txtOpenionScaleMinValue;

	@FindBy(xpath = "//div[@id='question-opinion-maximum-value']//child::input")
	private WebElement txtOpenionScaleMaxValue;

	@FindBy(xpath = "//textarea[@formcontrolname='questions']")
	private WebElement txtAddQuestion;

	@FindBy(xpath = "//span[text()='Image']")
	private WebElement btntAddImageQuestion;

	@FindBy(xpath = "//span[text()='Audio']")
	private WebElement btntAddAudioQuestion;

	@FindBy(xpath = "//span[text()='Video']")
	private WebElement btntAddVideoQuestion;

	@FindBy(xpath = "//input[@id='exampleInputFile']")
	private WebElement btntUploadFile;

	@FindBy(xpath = "//input[@formcontrolname='showDescription']")
	private WebElement btnShowDescription;

	@FindBy(xpath = "//textarea[@formcontrolname='question_desc']")
	private WebElement txtQuestionDescription;

	@FindBy(xpath = "//div[@id='engagement-add-question-is-optional']//input[@formcontrolname='isOptional']")
	private WebElement btnIsOptional;

	@FindBy(xpath = "//input[@formcontrolname='allowComments']")
	private WebElement btnAllowComments;

	@FindBy(xpath = "//select[@formcontrolname='commentOptions']")
	private WebElement txtCommentsOptions;

	@FindBy(xpath = "//span//i[@class='fa fa-plus']")
	private WebElement btnAddYourChoice;

	@FindBy(xpath = "//input[@type='number']")
	private WebElement btnAddChoiceNumber;

	@FindBy(xpath = "//input[@type='text' and @class='form-control choice_input ng-valid ng-touched ng-dirty']")
	private WebElement btnAddChoiceDesc;

	@FindBy(xpath = "//button[text()='Save ' and @class='btn btn-info btn-block btn-flat']")
	private WebElement btnQuestionSave;

	@FindBy(xpath = "//div[@aria-label='Success!']/preceding-sibling::div[@aria-label='Question Added Successfully']")
	private WebElement lblQtnAddedSuccessfully;

	@FindBy(xpath = "//div[text()=' Survey Initialize ']")
	private WebElement lblQtnSaveMeassage;

	@FindBy(xpath = "//h4[text()=' Add Question ']")
	private WebElement btnAddQuestion;

	@FindBy(xpath = "//option[text()='Employee Engagement Parameter ']")
	private WebElement lblTypeParameter;

	@FindBy(xpath = "//div[@id='question-rating-left-label']//input[@formcontrolname='left_label']")
	private WebElement txtLeftLabel;

	@FindBy(xpath = "//div[@id='question-rating-right-label']//input[@formcontrolname='right_label']")
	private WebElement txtRightLabel;

	@FindBy(xpath = "//div[@id='question-rating-maximum-value']//input[@formcontrolname='rating_comment_box']")
	private WebElement txtRatingScaleMaxValue;

	@FindBy(xpath = "//div[@id='question-rating-image']//select[@formcontrolname='rating_image']")
	private WebElement drdRatingImage;

	@FindBy(xpath = "//div[@id='toast-container']//child::div//following::div//following::div")
	private WebElement msgOpenionScaleValuesRequired;

	@FindBy(xpath = "//div[@id='toast-container']//child::div//following-sibling::div[text()=' Question Added Successfully ']")
	private WebElement msgQuestionAddedSuccessfully;

	@FindBy(xpath = "//div[@class='form-group']//div[@class='badge_badege']//span[text()='Image']")
	private WebElement btnQuestionImage;
	
	@FindBy(xpath = "//div[@class='form-group']//div[@class='badge_badege']//span[text()='Audio']")
	private WebElement btnQuestionAudio;

	@FindBy(xpath = "//div[@class='form-group']//div[@class='badge_badege']//span[text()='Video']")
	private WebElement btnQuestionVideo;

	@FindBy(xpath = "//div[@class='col-lg-12 add_choice_mood']//div[@class='badge_badege']//span[text()='Image']")
	private WebElement btnQuestionChoiceImage;

	@FindBy(xpath = "//div[@class='col-lg-12 add_choice_mood']//div[@class='badge_badege']//span[text()='Audio']")
	private WebElement btnQuestionChoiceAudio;

	@FindBy(xpath = "//div[@class='col-lg-12 add_choice_mood']//div[@class='badge_badege']//span[text()='Video']")
	private WebElement btnQuestionChoiceVideo;

	@FindBy(xpath = "(//div[@class='col-lg-12 add_choice_mood']//following::input[@id='exampleInputFile1'])[1]")
	private WebElement btnuploadImageChoiceQuestion;

	@FindBy(xpath = "(//div[@class='input-group ng-star-inserted']//label[text()='Upload Audio'])[1]")
	private WebElement btnUploadAudioChoice2;

	@FindBy(xpath = "(//div[@class='input-group ng-star-inserted']//label[text()='Upload Audio'])[1]")
	private WebElement btnUploadAudioChoice1;

	@FindBy(xpath = "//div[@class=\"col-lg-12 type_questuo_options ng-star-inserted\"]//i[@class='fa fa-plus']")
	private WebElement btAddQuestionChoice;

	@FindBy(xpath = "(//input[@type='file'])[3]")
	private WebElement btnUploadAudioChoice;

	@FindBy(xpath = "//div[@class='overlay-container']//div[text()=' File, audio_question.mp3 is invalid, ']")
	private WebElement msgAudioQuestionIsInvalid;

	@FindBy(xpath = "//div[@class='overlay-container']//div[text()=' File, image_question.jpg is invalid, ']")
	private WebElement msImageQuestionIsInvalid;

	@FindBy(xpath = "//div[@class='overlay-container']//div[text()=' File, video_question.mp4 is invalid, ']")
	private WebElement msgVideoQuestionIsInvalid;

	@FindBy(xpath = "//div[@class=\"col-lg-12 add_choice_mood\"]//i[@class=\"fa fa-plus\"]")
	private WebElement btnAddMoreChoice;

	@FindBy(xpath = "//div[text()=' Survey Initialize ']")
	private WebElement msgSurveyInitializeSuccessfully;

	@FindBy(xpath = "//div[@id='toast-container']//child::div//following::div//following::div")
	private WebElement msgSelectquestioncategorytocreatequestion;

	@FindBy(xpath = "//div[text()=' Add question text first! ']")
	private WebElement msgAddQuestionTextFirst;
	
	@FindBy(xpath = "//div[text()='Something went wrong!']") 
	private WebElement msgSomethingWentWrong;
	
	@FindBy(xpath = "//div[@id='toast-container']//child::div//following::div//following::div")
	private WebElement msgOpinionMinimumScaleValueIsRequired;
	
	@FindBy(xpath="//div[@id='toast-container']//child::div//following::div//following::div")
	private WebElement msgOpinionMaximumScaleValueIsRequired;
	
	@FindBy(xpath="//div[text()=' Rating image count is required ']")
	private WebElement msgRatingImageCountIsRequired;

	@FindBy(xpath="//div[text()=' Rating image is required ']")
	private WebElement msgRatingImageIsRequired;
	
	@FindBy(xpath="//div[text()=' Ratings maximum value should be less than or equal to 10 ']")
	private WebElement msgRatingsMaximumValueLessThanOrEqualToTen;
	
	@FindBy(xpath="//div[text()=' Opinion scale value be between 5 and 10 ']")
	private WebElement msgOpinionScaleValueBetweenFiveAndTen;
	
	@FindBy(xpath="//div[text()=' netPromoter minimum scale value is required ']")
	private WebElement msgNetPromoterMiniumkeValueReqired;
	
	@FindBy(xpath="//div[text()=' netPromoter maximum scale value is required ']")
	private WebElement msgNetPromoterMaximumValueRequired;
	
	@FindBy(xpath="//div[text()=' netPromoter minimum scale value is required ']")
	private WebElement msgNetPromoterMinimumValueRequired;
	
	@FindBy(xpath="//div[text()=' Opinion scale value be between 5 and 10 ']")
	private WebElement msgNetPromoterScaleValueBetweenFiveAndTen;

	private static final Logger logger = Logger.getLogger(HonohrPulseCreateSurveyQuestionPage.class.getName());

	public HonohrPulseCreateSurveyQuestionPage(WebDriver driver) {
		super(driver);

		logger.info("Starting of HonohrPulseCreateSurveyQuestionPage method");

		PageFactory.initElements(driver, this);

		logger.info("Ending of HonohrPulseCreateSurveyQuestionPage method");
	}

	public synchronized void clickOnQuestionType() {
		logger.info("Starting of clickOnQuestionType method");

		try {
			explicitWait(btnQuestionType);
			Select sec = new Select(btnQuestionType);
			sec.selectByIndex(1);

		} catch (Exception e) {

		}

		logger.info("Ending of clickOnQuestionType method");
	}

	public synchronized void clickOnEngagementParameter() {
		logger.info("Starting of clickOnEngagementParameter method");

		try {
			// this.waitForElementToBeClikable(btnEngParameter);
			Select sec = new Select(btnEngParameter);
			sec.selectByIndex(1);

		} catch (Exception e) {

		}
		logger.info("Ending of clickOnEngagementParameter method");
	}

	public synchronized void clickOnEngagementParameterDropDown() {
		logger.info("Starting of clickOnEngagementParameterDropDown method");

		try {
			Select sec = new Select(btnEngParameter);
			sec.selectByIndex(2);
		} catch (Exception e) {

		}
		logger.info("Ending of clickOnEngagementParameterDropDown method");
	}
	
	public synchronized void clickOnEmployOnBoard() {
		logger.info("Starting of clickOnEngagementParameterDropDown method");

		try {
			Select sec = new Select(btnEngParameter);
			sec.selectByIndex(1);
		} catch (Exception e) {

		}
		
		logger.info("Ending of clickOnEngagementParameterDropDown method");
	}

	public synchronized void clickOnSubParameter() {
		logger.info("Starting of clickOnSubParameter method");

		try {
			// this.waitForElementToBeClikable(btnSubParameter);
			Select sec = new Select(btnSubParameter);
			sec.selectByIndex(0);

		} catch (Exception e) {

		}

		logger.info("Ending of clickOnSubParameter method");
	}

	public synchronized void clickOnScale() {
		logger.info("Starting of clickOnScale method");

		try {
			Select sec = new Select(btnScale);
			sec.selectByIndex(0);

		} catch (Exception e) {

		}

		logger.info("Ending of clickOnScale method");
	}
	


	public synchronized void clickOnLikertScale() {
		logger.info("Starting of clickOnLikertScale method");

		Select sec = new Select(btnLikertScale);
		sec.selectByIndex(0);

		logger.info("Ending of clickOnLikertScale method");
	}
	
	public synchronized void clickOnNewLikertScale() {
		logger.info("Starting of clickOnNewLikertScale method");

		Select sec = new Select(btnLikertScale);
		sec.selectByIndex(1);

		logger.info("Ending of clickOnNewLikertScale method");
	}

	public synchronized void clickOnLikertScaleEngagement() {
		logger.info("Starting of clickOnLikertScaleEngagement method");

		Select sec = new Select(btnLikertScale);
		sec.selectByIndex(2);

		logger.info("Ending of clickOnLikertScaleEngagement method");
	}

	public synchronized void clickOnLikertScaleAgrementOption() {
		logger.info("Starting of clickOnLikertScale method");

		Select sec = new Select(btnLikertScale);
		sec.selectByIndex(1);

		logger.info("Ending of clickOnLikertScale method");
	}

	public synchronized void clickOnNetPromotorScore() {
		logger.info("Starting of clickOnNetPromotorScore method");

		Select sec = new Select(btnScale);
		sec.selectByIndex(3);

		logger.info("Ending of clickOnNetPromotorScore method");
	}

	public synchronized void clickOnRatingScale() {
		logger.info("Starting of clickOnRatingScale method");

		Select sec = new Select(btnScale);
		sec.selectByIndex(1);

		logger.info("Ending of clickOnRatingScale method");
	}

	public synchronized void clickOnOpinionScale() {
		logger.info("Starting of clickOnOpinionScale method");

		Select sec = new Select(btnScale);
		sec.selectByIndex(2);

		logger.info("Ending of clickOnOpinionScale method");
	}

	public synchronized void clickOnAddQuestion(String strAddQuestion) {
		logger.info("Starting of clickOnAddQuestion method");

		this.waitForElementToBeClikable(txtAddQuestion);
		txtAddQuestion.sendKeys(strAddQuestion);

		logger.info("Ending of clickOnAddQuestion method");
	}

	public synchronized void clickOnAddImageQuestion(String strAddImage) {
		logger.info("Starting of clickOnAddImageQuestion method");

		try {

			explicitWait(btntAddImageQuestion);
			clickOnWebElement(btntAddImageQuestion);

			wait(2);
			String osPath = System.getProperty("os.name");
			if (osPath.contains("Linux")) {
				btntUploadFile.sendKeys(TEST_FILE_PATH + "/data/" + strAddImage);
			} else {
				wait(5);
				System.out.println(
						"Image path:::" + TEST_FILE_PATH + File.separator + "data" + File.separator + strAddImage);
				btntUploadFile.sendKeys(TEST_FILE_PATH + File.separator + "data" + File.separator + strAddImage);
			}

		} catch (Exception e) {

		}

		logger.info("Ending of clickOnAddImageQuestion method");
	}

	public synchronized void clickOnAddImageQuestionButton() {
		logger.info("Starting of clickOnAddImageQuestionButton method");

		try {

			this.explicitWait(btntAddImageQuestion);

			clickOnWebElement(btntAddImageQuestion);

		} catch (Exception e) {

			this.explicitWait(btntAddImageQuestion);

			this.btntAddImageQuestion.click();
		}

		logger.info("Ending of clickOnAddImageQuestionButton method");
	}

	public synchronized void clickOnAddAudioQuestion(String strAddAudio) {
		logger.info("Starting of clickOnAddAudioQuestion method");

		try {

			explicitWait(btntAddAudioQuestion);

			clickOnWebElement(btntAddAudioQuestion);

			wait(2);
			String osPath = System.getProperty("os.name");
			if (osPath.contains("Linux")) {
				btntUploadFile.sendKeys(TEST_FILE_PATH + "/data/" + strAddAudio);
			} else {
				wait(5);
				System.out.println(
						"Image path:::" + TEST_FILE_PATH + File.separator + "data" + File.separator + strAddAudio);
				btntUploadFile.sendKeys(TEST_FILE_PATH + File.separator + "data" + File.separator + strAddAudio);
			}

		} catch (Exception e) {
		}

		logger.info("Ending of clickOnAddAudioQuestion method");
	}

	public synchronized void clickOnAddAudioQuestionButton() {
		logger.info("Starting of clickOnAddAudioQuestionButton method");

		try {

			this.explicitWait(btntAddAudioQuestion);

			clickOnWebElement(btntAddAudioQuestion);

		} catch (Exception e) {

			this.explicitWait(btntAddAudioQuestion);

			this.btntAddAudioQuestion.click();
		}

		logger.info("Ending of clickOnAddAudioQuestionButton method");
	}

	public synchronized void clickOnAddVideoQuestion(String strAddVideo) {
		logger.info("Starting of clickOnAddVideoQuestion method");

		try {

			explicitWait(btntAddVideoQuestion);

			clickOnWebElement(btntAddVideoQuestion);

			// this.btntUploadFile.sendKeys(addVideo);

			wait(2);
			String osPath = System.getProperty("os.name");
			if (osPath.contains("Linux")) {
				btntUploadFile.sendKeys(TEST_FILE_PATH + "/data/" + strAddVideo);
			} else {
				wait(5);
				System.out.println(
						"Image path:::" + TEST_FILE_PATH + File.separator + "data" + File.separator + strAddVideo);
				btntUploadFile.sendKeys(TEST_FILE_PATH + File.separator + "data" + File.separator + strAddVideo);
			}
		} catch (Exception e) {

		}
		logger.info("Ending of clickOnAddVideoQuestion method");
	}

	public synchronized void clickOnAddVideoQuestionButton() {
		logger.info("Starting of clickOnAddVideoQuestionButton method");

		try {

			this.explicitWait(btntAddVideoQuestion);

			clickOnWebElement(btntAddVideoQuestion);

		} catch (Exception e) {

			this.explicitWait(btntAddVideoQuestion);

			this.btntAddVideoQuestion.click();
		}

		logger.info("Ending of clickOnAddVideoQuestionButton method");
	}

	public synchronized void clickOnShowQuestion() {
		logger.info("Starting of clickOnAddQuestion method");

		try {
			this.waitForElementToBeClikable(btnShowDescription);
			clickOnWebElement(btnShowDescription);
		} catch (Exception e) {
			btnShowDescription.click();
		}

		logger.info("Ending of clickOnAddQuestion method");
	}

	public synchronized void clickOnAddDescription(String strAddDescription) {
		logger.info("Starting of clickOnAddDescription method");

		this.waitForElementToBeClikable(txtQuestionDescription);

		try {
			txtQuestionDescription.sendKeys(strAddDescription);
		} catch (Exception e) {

			txtQuestionDescription.sendKeys(strAddDescription);
		}

		logger.info("Ending of clickOnAddDescription method");
	}

	public synchronized void clickOnIsOptional() {
		logger.info("Starting of clickOnIsOptional method");

		try {
			this.waitForElementToBeClikable(btnIsOptional);
			clickOnWebElement(btnIsOptional);

		} catch (Exception e) {
			this.waitForElementToBeClikable(btnIsOptional);
			this.btnIsOptional.click();
		}

		logger.info("Ending of clickOnIsOptional method");
	}

	public synchronized void clickOnAllowComments() {
		logger.info("Starting of clickOnAllowComments method");

		try {
			this.waitForElementToBeClikable(btnAllowComments);
			clickOnWebElement(btnAllowComments);
		} catch (Exception e) {
			this.waitForElementToBeClikable(btnAllowComments);
			this.btnAllowComments.click();
		}

		logger.info("Ending of clickOnAllowComments method");
	}

	public synchronized void clickOnCommentOptions() {
		logger.info("Starting of clickOnAllowComments method");

		try {
			this.waitForElementToBeClikable(txtCommentsOptions);
			Select sec = new Select(txtCommentsOptions);
			sec.selectByIndex(3);
		} catch (Exception e) {

		}

		logger.info("Ending of clickOnAllowComments method");
	}

	public synchronized void clickOnAddYourChoice() {
		logger.info("Starting of clickOnAddYourChoice method");

		this.waitForElementToBeClikable(btnAddYourChoice);

		try {
			clickOnWebElement(btnAddYourChoice);
		} catch (Exception e) {
			this.btnAddYourChoice.click();
		}

		logger.info("Ending of clickOnAddYourChoice method");
	}

	public synchronized void clickOnChoiceNumber(String strChoiceNumber) {
		logger.info("Starting of clickOnChoiceNumber method");

		this.waitForElementToBeClikable(btnAddChoiceNumber);

		try {
			clickOnWebElement(btnAddChoiceNumber);
			btnAddChoiceNumber.sendKeys(strChoiceNumber);
		} catch (Exception e) {
			this.btnAddChoiceNumber.click();
		}

		logger.info("Ending of clickOnChoiceNumber method");
	}

	public synchronized void clickOnAddYourChoice(String strChoiceDesc) {
		logger.info("Starting of clickOnAddYourChoice method");

		this.waitForElementToBeClikable(btnAddYourChoice);

		try {
			clickOnWebElement(btnAddYourChoice);
			btnAddYourChoice.sendKeys(strChoiceDesc);
		} catch (Exception e) {
			this.btnAddYourChoice.click();
		}

		logger.info("Ending of clickOnAddYourChoice method");
	}

	public synchronized void clickOnQuestionSaveButton() throws InterruptedException {
		logger.info("Starting of clickOnQuestionSaveButton method");

		this.waitForElementToBeClikable(btnQuestionSave);

		try {
			clickOnWebElement(btnQuestionSave);
			Thread.sleep(1000);
		} catch (Exception e) {
			this.btnQuestionSave.click();

		}

		logger.info("Ending of clickOnQuestionSaveButton method");
	}

/*	public synchronized String getQuestionAddedSuccessfullyText() {
		logger.info("Starting of getQuestionAddedSuccessfully method");
		logger.info("Ending of getQuestionAddedSuccessfully method");

		// this.waitForElementToBeClikable(lblQtnAddedSuccessfully);
		return lblQtnAddedSuccessfully.getText();
	}*/

	public boolean isQuestionAddedSuccessfullyMessageDisplayed() {

		logger.info("Starting of isQuestionAddedSuccessfullyMessageDisplayed Method");
		logger.info("Ending isQuestionAddedSuccessfullyMessageDisplayed Method");

		return lblQtnAddedSuccessfully.isDisplayed();
	}

	public String getQuestionTabLabel() {
		logger.info("Starting of getQuestionTabLabel Method");
		logger.info("Ending of getQuestionTabLabel Method");

		return lblQuestionTab.getText();
	}

	public void AddQuestion() throws InterruptedException {
		logger.info("Starting of AddQuestion Method");

		// this.btnQuestionType.click();

		Thread.sleep(5000);
		this.waitForElementToBeClikable(btnQuestionType);
		Select sec = new Select(btnQuestionType);
		sec.selectByIndex(1);
		Thread.sleep(3000);

		Select sel = new Select(btnEngParameter);
		sel.selectByIndex(2);
		Thread.sleep(3000);

		Select sec1 = new Select(btnSubParameter);
		sec1.selectByIndex(0);
		Thread.sleep(3000);

		Select scale = new Select(btnScale);
		scale.selectByIndex(0);
		Thread.sleep(3000);

		Select lksc = new Select(btnLikertScale);
		lksc.selectByIndex(1);
		Thread.sleep(3000);

		logger.info("Ending of AddQuestion Method");
	}

	public void AddQuestionDesc() throws InterruptedException {
		logger.info("Starting of AddQuestionDesc Method");

		this.waitForElementToBeClikable(btnIsOptional);
		clickOnWebElement(btnIsOptional);
		Thread.sleep(3000);

		this.waitForElementToBeClikable(btnAllowComments);
		clickOnWebElement(btnAllowComments);
		Thread.sleep(3000);

		this.waitForElementToBeClikable(txtCommentsOptions);
		Select sec3 = new Select(txtCommentsOptions);
		sec3.selectByIndex(3);
		Thread.sleep(3000);

		this.waitForElementToBeClikable(btnQuestionSave);

		clickOnWebElement(btnQuestionSave);

		logger.info("Ending of AddQuestion Method");
	}

	public String getQuestionAddedSuccessfullyTextMessage() throws InterruptedException {

		logger.info("Starting of getQuestionAddedSuccessfullyTextMessage Method");
		logger.info("Ending getQuestionAddedSuccessfullyTextMessage Method");

		// String strQstn= "//div[@aria-label='Survey Initialize']";
		// this.fluentWaitForElement(strQstn);
		// explicitWait(lblQtnSaveMeassage);
		// this.waitForElementToBeClikable(lblQtnSaveMeassage);

		this.waitForElementToBeClikable(lblQtnSaveMeassage);
		return lblQtnSaveMeassage.getText();
	}

	public synchronized void clickOnQuestionButton() throws InterruptedException {
		logger.info("Starting of clickOnQuestionSaveButton method");

		// this.waitForElementToBeClikable(btnAddQuestion);
		this.btnQuestionType.click();
		this.lblTypeParameter.click();
		// this.btnAddQuestion.click();

		logger.info("Ending of clickOnQuestionSaveButton method");
	}

	public synchronized void clickOnOpinionScaleMinValue(String strScaleMinValue) {
		logger.info("Starting of clickOnOpinionScaleMinValue method");

		this.waitForElementToBeClikable(txtOpenionScaleMinValue);

		this.txtOpenionScaleMinValue.sendKeys(strScaleMinValue);

		logger.info("Ending of clickOnOpinionScaleMinValue method");
	}

	public synchronized void clickOnOpinionScaleMaxValue(String strScaleMaxValue) {
		logger.info("Starting of clickOnOpinionScaleMaxValue method");

		this.waitForElementToBeClikable(txtOpenionScaleMaxValue);

		this.txtOpenionScaleMaxValue.sendKeys(strScaleMaxValue);

		logger.info("Ending of clickOnOpinionScaleMaxValue method");
	}

	public synchronized void clickOnRatingScaleLeftLabel(String strScaleLeftValue) {
		logger.info("Starting of clickOnRatingScaleLeftLabel method");

		this.waitForElementToBeClikable(txtLeftLabel);

		this.txtLeftLabel.sendKeys(strScaleLeftValue);

		logger.info("Ending of clickOnRatingScaleLeftLabel method");
	}

	public synchronized void clickOnRatingScaleRightLabel(String strScaleRightValue) {
		logger.info("Starting of clickOnRatingScaleRightLabel method");

		this.waitForElementToBeClikable(txtRightLabel);

		this.txtRightLabel.sendKeys(strScaleRightValue);

		logger.info("Ending of clickOnRatingScaleRightLabel method");
	}

	public synchronized void clickOnRatingScaleMaximumValue(String strScaleMaxValue) {
		logger.info("Starting of clickOnRatingScaleMaximumValue method");

		this.waitForElementToBeClikable(txtRatingScaleMaxValue);

		this.txtRatingScaleMaxValue.sendKeys(strScaleMaxValue);

		logger.info("Ending of clickOnRatingScaleMaximumValue method");
	}

	public synchronized void clickOnRatingImage() {
		logger.info("Starting of clickOnRatingImage method");

		try {
			this.waitForElementToBeClikable(drdRatingImage);
			Select sec = new Select(drdRatingImage);
			sec.selectByIndex(1);
		} catch (Exception e) {

		}

		logger.info("Ending of clickOnRatingImage method");
	}

	public synchronized String getOpinionScaleValueBetweenZeroAndTenMessage() {
		logger.info("Staring of getOpinionScaleValueBetweenZeroAndTenMessage method");

		logger.info("Ending of getOpinionScaleValueBetweenZeroAndTenMessage method");

		this.explicitWait(msgOpenionScaleValuesRequired);

		return msgOpenionScaleValuesRequired.getText();
	}

	public synchronized String getQuestionAddedSuccessfullyText() {
		logger.info("Staring of getQuestionAddedSuccessfullyText method");

		logger.info("Ending of getQuestionAddedSuccessfullyText method");

		this.explicitWait(msgQuestionAddedSuccessfully);

		return msgQuestionAddedSuccessfully.getText();
	}

	public synchronized void clickOnQuestionImageButton() {
		logger.info("Starting of clickOnQuestionImageButton method");

		this.waitForElementToBeClikable(btnQuestionImage);

		try {
			clickOnWebElement(btnQuestionImage);

		} catch (Exception e) {

			this.btnQuestionImage.click();
		}

		logger.info("Ending of clickOnQuestionImageButton method");
	}

	public synchronized void clickOnAddAudioQuestionsButton() {
		logger.info("Starting of clickOnQuestionAudioButton method");

		this.waitForElementToBeClikable(btnQuestionAudio);

		try {
			clickOnWebElement(btnQuestionAudio);

		} catch (Exception e) {

			this.btnQuestionAudio.click();
		}

		logger.info("Ending of clickOnQuestionAudioButton method");
	}

	public synchronized void clickOnAddVideoQuestionsButton() {
		logger.info("Starting of clickOnAddVideoQuestionsButton method");

		this.waitForElementToBeClikable(btnQuestionVideo);

		try {
			clickOnWebElement(btnQuestionVideo);

		} catch (Exception e) {

			this.btnQuestionVideo.click();
		}

		logger.info("Ending of clickOnAddVideoQuestionsButton method");
	}

	public synchronized void clickOnImageChoiceQuestionButton() {
		logger.info("Starting of clickOnImageChoiceQuestionButton method");

		this.waitForElementToBeClikable(btnQuestionChoiceImage);

		try {
			clickOnWebElement(btnQuestionChoiceImage);

		} catch (Exception e) {

			this.btnQuestionChoiceImage.click();
		}

		logger.info("Ending of clickOnImageChoiceQuestionButton method");
	}

	public synchronized void clickOnAddAudioChoiceQuestionsButton() {
		logger.info("Starting of clickOnAddImageChoiceQuestionsButton method");

		this.waitForElementToBeClikable(btnQuestionChoiceAudio);

		try {

			explicitWait(btnQuestionChoiceAudio);

			clickOnWebElement(btnQuestionChoiceAudio);

		} catch (Exception e) {

			this.btnQuestionChoiceAudio.click();
		}

		logger.info("Ending of clickOnAddImageChoiceQuestionsButton method");
	}

	public synchronized void clickOnAddVideoChoiceQuestionsButton() {
		logger.info("Starting of clickOnAddVideoChoiceQuestionsButton method");

		explicitWait(btntAddImageQuestion);

		this.waitForElementToBeClikable(btnQuestionChoiceVideo);

		try {

			clickOnWebElement(btnQuestionChoiceVideo);

		} catch (Exception e) {

			this.btnQuestionChoiceVideo.click();
		}

		logger.info("Ending of clickOnAddVideoChoiceQuestionsButton method");
	}

	public synchronized void clickOnUploadImageChoiceQuestionsButton(String strUploadImageChoice) {
		logger.info("Starting of clickOnImageChoiceQuestionsButton method");

		try {
			explicitWait(btnuploadImageChoiceQuestion);
			this.btnuploadImageChoiceQuestion.click();
			btnuploadImageChoiceQuestion.sendKeys(strUploadImageChoice);

		} catch (Exception e) {
			clickOnWebElement(btnuploadImageChoiceQuestion);
			btnuploadImageChoiceQuestion.sendKeys(strUploadImageChoice);
		}

		logger.info("Ending of clickOnImageChoiceQuestionsButton method");
	}

	public synchronized void clickOnAddQuestionChoiceButton() {
		logger.info("Starting of clickOnAddQuestionChoiceButton method");

		explicitWait(btAddQuestionChoice);

		try {
			this.btAddQuestionChoice.click();

		} catch (Exception e) {
			clickOnWebElement(btAddQuestionChoice);

		}

		logger.info("Ending of clickOnAddQuestionChoiceButton method");
	}

	public synchronized void setImageChoiceOptions(String strImageChoice) {
		logger.info("Starting of clickOnAddQuestionChoiceButton method");

		try {
			wait(2);
			String osPath = System.getProperty("os.name");
			if (osPath.contains("Linux")) {
				btnUploadAudioChoice.sendKeys(TEST_FILE_PATH + "/data/" + strImageChoice);
			} else {
				wait(5);
				System.out.println(
						"Image path:::" + TEST_FILE_PATH + File.separator + "data" + File.separator + strImageChoice);
				btnUploadAudioChoice.sendKeys(TEST_FILE_PATH + File.separator + "data" + File.separator + strImageChoice);
			}

		} catch (Exception e) {

		}

		logger.info("Ending of clickOnAddQuestionChoiceButton method");
	}

	public synchronized void setAudioChoiceOptions(String strAudioChoice) {
		logger.info("Starting of clickOnAddQuestionChoiceButton method");

		try {
			wait(2);
			String osPath = System.getProperty("os.name");
			if (osPath.contains("Linux")) {
				btnUploadAudioChoice.sendKeys(TEST_FILE_PATH + "/data/" + strAudioChoice);
			} else {
				wait(5);
				System.out.println(
						"Image path:::" + TEST_FILE_PATH + File.separator + "data" + File.separator + strAudioChoice);
				btnUploadAudioChoice
						.sendKeys(TEST_FILE_PATH + File.separator + "data" + File.separator + strAudioChoice);
			}

		} catch (Exception e) {

		}

		logger.info("Ending of clickOnAddQuestionChoiceButton method");
	}

	public synchronized void setVideoChoiceOptions(String strVideoChoice) {
		logger.info("Starting of clickOnAddQuestionChoiceButton method");

		try {
			wait(2);
			String osPath = System.getProperty("os.name");
			if (osPath.contains("Linux")) {
				btnUploadAudioChoice.sendKeys(TEST_FILE_PATH + "/data/" + strVideoChoice);
			} else {
				wait(5);
				System.out.println(
						"Image path:::" + TEST_FILE_PATH + File.separator + "data" + File.separator + strVideoChoice);
				btnUploadAudioChoice
						.sendKeys(TEST_FILE_PATH + File.separator + "data" + File.separator + strVideoChoice);
			}

		} catch (Exception e) {

		}

		logger.info("Ending of clickOnAddQuestionChoiceButton method");
	}

	public synchronized String getAudioQuestionIsInvalidText() {
		logger.info("Staring of getAudioQuestionIsInvalidText method");

		logger.info("Ending of getAudioQuestionIsInvalidText method");

		this.explicitWait(msgAudioQuestionIsInvalid);

		return msgAudioQuestionIsInvalid.getText();
	}

	public synchronized String getVideoQuestionIsInvalidText() {
		logger.info("Staring of getVideoQuestionIsInvalidText method");

		logger.info("Ending of getVideoQuestionIsInvalidText method");

		this.explicitWait(msgVideoQuestionIsInvalid);

		return msgVideoQuestionIsInvalid.getText();
	}

	public synchronized String getImageQuestionIsInvalidText() {
		logger.info("Staring of getImageQuestionIsInvalidText method");

		logger.info("Ending of getImageQuestionIsInvalidText method");

		this.explicitWait(msImageQuestionIsInvalid);

		return msImageQuestionIsInvalid.getText();
	}

	public synchronized String getSurveyInitializeSuccessfullyText() {
		logger.info("Starting of getSurveyInitializeSuccessfullyText method");

		logger.info("Ending of getSurveyInitializeSuccessfullyText method");

		this.explicitWait(msgSurveyInitializeSuccessfully);
		return msgSurveyInitializeSuccessfully.getText();

	}

	public synchronized String getSelectquestioncategorytocreatequestionText() {
		logger.info("Starting of getSelectquestioncategorytocreatequestionText method");

		logger.info("Ending of getSelectquestioncategorytocreatequestionText method");

		this.explicitWait(msgSelectquestioncategorytocreatequestion);
		return msgSelectquestioncategorytocreatequestion.getText();

	}

	public synchronized String getAddQuestionTextFirstText() {
		logger.info("Starting of getAddQuestionTextFirstText method");
		
		logger.info("Ending of getAddQuestionTextFirstText method");

		this.explicitWait(msgAddQuestionTextFirst);
		return msgAddQuestionTextFirst.getText();
	}
	
	public synchronized String getSomethingWentWrongText() {
		  logger.info("Starting of getSomethingWentWrongText method");
		  logger.info("Ending of getSomethingWentWrongText method");
		  this.explicitWait(msgSomethingWentWrong);
		  return msgSomethingWentWrong.getText();
		  
		  }
	public synchronized String getOpinionMinimumScaleValueIsRequiredText() {
		  logger.info("Starting of getOpinionMinimumScaleValueIsRequiredText method");
		  logger.info("Ending of getOpinionMinimumScaleValueIsRequiredText method");
		  
		  this.explicitWait(msgOpinionMinimumScaleValueIsRequired);
		  return msgOpinionMinimumScaleValueIsRequired.getText();
		  
		  }
	
	public synchronized String getOpinionMaximumScaleValueIsRequiredText() {
		  logger.info("Starting of getOpinionMaximumScaleValueIsRequiredText method");
		  logger.info("Ending of getOpinionMaximumScaleValueIsRequiredText method");
		  
		  this.explicitWait(msgOpinionMaximumScaleValueIsRequired);
		  return msgOpinionMaximumScaleValueIsRequired.getText();
		  
		  }
	
	 public synchronized String getRatingImageCountIsRequiredText() {
		  logger.info("Starting of getRatingImageCountIsRequiredText method");
		  logger.info("Ending of getRatingImageCountIsRequiredText method");
		  
		  this.explicitWait(msgRatingImageCountIsRequired);
		  return msgRatingImageCountIsRequired.getText();
		  
		  }
	 public synchronized String getRatingImageIsRequiredText() {
		  logger.info("Starting of getRatingImageIsRequiredText method");
		  logger.info("Ending of getRatingImageIsRequiredText method");
		  
		  this.explicitWait(msgRatingImageIsRequired);
		  return msgRatingImageIsRequired.getText();
		  
		  }

	 public synchronized String getOpinionScaleValueBetweenFiveAndTenTextMessage() {
		  logger.info("Staring of getOpinionScaleValueBetweenFiveAndTenTextMessage method");
		  logger.info("Ending of getOpinionScaleValueBetweenFiveAndTenTextMessage method");
		  
		  this.explicitWait(msgOpinionScaleValueBetweenFiveAndTen);
		  return msgOpinionScaleValueBetweenFiveAndTen.getText();
	  }
	 
	 public synchronized String getRatingsMaximumValueLessThanOrEqualToTenMessageText() {
		  logger.info("Staring of getRatingsMaximumValueLessThanOrEqualToTenMessageText method");
		  logger.info("Ending of getRatingsMaximumValueLessThanOrEqualToTenMessageText method");
		  
		  this.explicitWait(msgRatingsMaximumValueLessThanOrEqualToTen);
		  return msgRatingsMaximumValueLessThanOrEqualToTen.getText();
		  			  
	  }
	 
	 public synchronized String getNetPromoterMiniumValueReqiredTextMessage() {
		  logger.info("Staring of getNetPromoterMiniumValueReqiredTextMessage method");
		  logger.info("Ending of getNetPromoterMiniumValueReqiredTextMessage method");
		  
		  this.explicitWait(msgNetPromoterMiniumkeValueReqired);
		  return msgNetPromoterMiniumkeValueReqired.getText();
	  }
	  
	 public synchronized String getNetPromoterMaximumValueReqiredTextMessage() {
		  logger.info("Staring of getNetPromoterMaximumValueReqiredTextMessage method");
		  logger.info("Ending of getNetPromoterMaximumValueReqiredTextMessage method");
		  
		  this.explicitWait(msgNetPromoterMaximumValueRequired);
		  return msgNetPromoterMaximumValueRequired.getText();
	  }

	 public synchronized String getNetPromoterMinimumValueReqiredTextMessage() {
		  logger.info("Staring of getNetPromoterMinimumValueReqiredTextMessage method");
		  logger.info("Ending of getNetPromoterMinimumValueReqiredTextMessage method");
		  
		  this.explicitWait(msgNetPromoterMinimumValueRequired);
		  return msgNetPromoterMinimumValueRequired.getText();
	  }
	 
	 public synchronized String getNetPromoterMinValueMoreThanMaxAndMaxLessThanMinTextMessage() {
		  logger.info("Starting of getNetPromoterMinValueMoreThanMaxAndMaxLessThanMinTextMessage method");
		  logger.info("Ending of getNetPromoterMinValueMoreThanMaxAndMaxLessThanMinTextMessage method");
		  
		  this.explicitWait(msgNetPromoterScaleValueBetweenFiveAndTen);
		  return msgNetPromoterScaleValueBetweenFiveAndTen.getText();
		  
	  }

	 public synchronized String getNetPromoterScaleValueBetweenFiveAndTenTextMessage() {
		  logger.info("Staring of getNetPromoterScaleValueBetweenFiveAndTenTextMessage method");
		  logger.info("Ending of getNetPromoterScaleValueBetweenFiveAndTenTextMessage method");
		  
		  this.explicitWait(msgNetPromoterScaleValueBetweenFiveAndTen);
		  return msgNetPromoterScaleValueBetweenFiveAndTen.getText();
	  }





	  


	 
	
	

}