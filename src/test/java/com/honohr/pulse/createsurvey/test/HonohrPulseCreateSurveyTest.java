package com.honohr.pulse.createsurvey.test;
import static com.honohr.pulse.util.Constants.*;
import static org.junit.Assert.assertTrue;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.springframework.context.annotation.Description;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.honohr.pulse.base.test.BaseHonoPulseAutomationTest;
import com.honohr.pulse.createsurvey.pages.HonoPulseCreateServeyDesignPage;
import com.honohr.pulse.createsurvey.pages.HonohrPulseCreateSurveyCampaignPage;
import com.honohr.pulse.createsurvey.pages.HonohrPulseCreateSurveyPage;
import com.honohr.pulse.createsurvey.pages.HonohrPulseCreateSurveyPreviewPage;
import com.honohr.pulse.createsurvey.pages.HonohrPulseCreateSurveyQuestionPage;
import com.honohr.pulse.createsurvey.pages.HonohrPulseCreateSurveyThankYouPage;
import com.honohr.pulse.createsurvey.pages.HonohrPulseCreateSurveyWelcomePage;
import com.honohr.pulse.login.pages.HonohrPulseLoginPage;

import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Story;

@Epic("Hono pulse Create Survey")
@Feature("Create survey for Onboard Employees")
public class HonohrPulseCreateSurveyTest extends BaseHonoPulseAutomationTest {

	private WebDriver driver = null;
	private HonohrPulseLoginPage honoLoginPage = null;
	private HonohrPulseCreateSurveyPage honoCreateSurveyPage = null;
	private HonohrPulseCreateSurveyQuestionPage createSurveyQuestionPage = null;
	private HonoPulseCreateServeyDesignPage createServeyDesignPage = null;
	private HonohrPulseCreateSurveyWelcomePage createServeyWelcomePage = null;
	private HonohrPulseCreateSurveyThankYouPage createServeyThankyouPage = null;
	private HonohrPulseCreateSurveyPreviewPage createServeyPreviewPage = null;
	private HonohrPulseCreateSurveyCampaignPage createServeyCompaignPage = null;
	
	

	private static final Logger logger = Logger.getLogger(HonohrPulseCreateSurveyTest.class.getName());

	@BeforeTest
	@Parameters({ "browser", "siteURL", "emailAddress", "password" })
	public void initMethodTest(String browser, String siteURL, String emailAddress, String password) throws Exception {
		logger.info("Starting of initMethodTest method");

		this.driver = this.getWebDriver(browser);
		this.loginToHono(browser, siteURL, emailAddress, password, this.driver);
		honoLoginPage = new HonohrPulseLoginPage(driver);
		honoCreateSurveyPage = new HonohrPulseCreateSurveyPage(driver);
		createSurveyQuestionPage = new HonohrPulseCreateSurveyQuestionPage(driver);
		createServeyDesignPage = new HonoPulseCreateServeyDesignPage(driver);
		createServeyWelcomePage = new HonohrPulseCreateSurveyWelcomePage(driver);
		createServeyThankyouPage = new HonohrPulseCreateSurveyThankYouPage(driver);
		createServeyPreviewPage = new HonohrPulseCreateSurveyPreviewPage(driver);
		createServeyCompaignPage = new HonohrPulseCreateSurveyCampaignPage(driver);

		logger.info("Ending of initMethodTest method");
	}

	@Test(priority = 1, description = "Verify Dashboard")
	@Description("Test Case #1, Verify Dashboard")
	@Severity(SeverityLevel.CRITICAL)
	@Story("Test Case #1, Verify Dashboard")
	public void verifyDashboard() {
		logger.info("Starting of verifyDashboard method");

		try {

			Assert.assertEquals(honoLoginPage.getTextDashboard(), expectedAssertionsProp.getProperty(DASHBOARD_TEXT));
			honoCreateSurveyPage.clickOnCreateNewButton();

		} catch (Exception e) {
			Assert.fail("Exception occured while testing verifyDashboard : " + e.getMessage());
			logger.error("Error occured while verifyDashboard " + e);
		}

		logger.info("Starting of verifyDashboard method");
	}

	@Test(priority = 2, description = "Verify Create Survey General Tab Details")
	@Description("Test Case #2, Verify Create Survey General Tab Details")
	@Severity(SeverityLevel.NORMAL)
	@Story("Test Case #2, Verify Create Survey General Tab Details")
	public void verifyCreateSurveyGeneralTabDetails() {
		logger.info("Starting of verifyCreateSurveyGeneralTabDetails method");

		try {

			Assert.assertEquals(honoCreateSurveyPage.getCreateSurveyText(),
					expectedAssertionsProp.getProperty(CREATE_SURVEY_TEXT));

			Assert.assertEquals(honoCreateSurveyPage.getTextGeneral(),
					expectedAssertionsProp.getProperty(GENERAL_TEXT));

			this.honoCreateSurveyPage.clickOnSurveyName(testDataProp.getProperty(SURVEY_NAME));
			this.honoCreateSurveyPage.clickOnSurveyDesc(testDataProp.getProperty(SURVEY_DESC));
			this.honoCreateSurveyPage.clickOnSurveyCategory();
			this.honoCreateSurveyPage.clickOnEngagement();
			this.honoCreateSurveyPage.setExpiryDate(testDataProp.getProperty(EXPIRY_DATE));

			this.honoCreateSurveyPage.clickOnAddLanguage();
			this.honoCreateSurveyPage.clickOnSelectLanguage();
			this.honoCreateSurveyPage.clickOnSaveButton();

			// assertTrue(this.honoCreateSurveyPage.isSurveyInitializeMessageDisplayed());

		} catch (Exception e) {
			Assert.fail("Exception occured while testing verifyCreateSurveyGeneralTabDetails : " + e.getMessage());
			logger.error("Error occured while verifyCreateSurveyGeneralTabDetails " + e);
		}

		logger.info("Starting of verifyCreateSurveyGeneralTabDetails method");
	}

	@Test(priority = 3, description = "Verify Create Survey Question Tab Details ")
	@Description("Test Case #3, Verify Create Survey Question Tab Details ")
	@Severity(SeverityLevel.CRITICAL)
	@Story("Test Case #3, Verify Create Survey Question Tab Details ")
	public void verifyCreateSurveyTextQuestionDetails() {
		logger.info("Starting of verifyCreateSurveyTextQuestionDetails method");

		try {

			this.createSurveyQuestionPage.AddQuestion();

			this.createSurveyQuestionPage.clickOnAddQuestion(testDataProp.getProperty(ADD_TEXT_QUESTION));

			this.createSurveyQuestionPage.AddQuestionDesc();
			
			Assert.assertEquals(createSurveyQuestionPage.getQuestionAddedSuccessfullyText(),
					expectedAssertionsProp.getProperty(QUESTION_ADDED_SUCCESSFULLY_TEXT));

		} catch (Exception e) {
			Assert.fail("Exception occured while testing verifyCreateSurveyTextQuestionDetails : " + e.getMessage());
			logger.error("Error occured while verifyCreateSurveyTextQuestionDetails " + e);
		}

		logger.info("Starting of verifyCreateSurveyTextQuestionDetails method");
	}

	@Test(priority = 4, description = "Verify Create Survey Image Type Question Details ")
	@Description("Test Case #4, Verify Create Survey Image Type Question Details ")
	@Severity(SeverityLevel.CRITICAL)
	@Story("Test Case #4, Verify Create Survey Image Type Question Details ")
	public void verifyCreateSurveyImageTypeQuestionDetails() {
		logger.info("Starting of verifyCreateSurveyImageTypeQuestionDetails method");

		try {

			this.createSurveyQuestionPage.AddQuestion();

			this.createSurveyQuestionPage.clickOnAddImageQuestion(testDataProp.getProperty(ADD_IMAGE_QUESTION));

			this.createSurveyQuestionPage.AddQuestionDesc();
			
			Assert.assertEquals(createSurveyQuestionPage.getQuestionAddedSuccessfullyText(),
					expectedAssertionsProp.getProperty(QUESTION_ADDED_SUCCESSFULLY_TEXT));

		} catch (Exception e) {
			Assert.fail(
					"Exception occured while testing verifyCreateSurveyImageTypeQuestionDetails : " + e.getMessage());
			logger.error("Error occured while verifyCreateSurveyImageTypeQuestionDetails " + e);
		}

		logger.info("Starting of verifyCreateSurveyImageTypeQuestionDetails method");
	}

	@Test(priority = 5, description = "Verify Create Survey Audio Type Question Details ")
	@Description("Test Case #5, Verify Create Survey Audio Type Question Details ")
	@Severity(SeverityLevel.CRITICAL)
	@Story("Test Case #5, Verify Create Survey Image Audio Question Details ")
	public void verifyCreateSurveyAudioTypeQuestionDetails() {
		logger.info("Starting of verifyCreateSurveyAudioTypeQuestionDetails method");

		try {

			this.createSurveyQuestionPage.AddQuestion();

			this.createSurveyQuestionPage.clickOnAddAudioQuestion(testDataProp.getProperty(ADD_AUDIO_QUESTION));

			this.createSurveyQuestionPage.AddQuestionDesc();
			
			Assert.assertEquals(createSurveyQuestionPage.getQuestionAddedSuccessfullyText(),
					expectedAssertionsProp.getProperty(QUESTION_ADDED_SUCCESSFULLY_TEXT));

		} catch (Exception e) {
			Assert.fail(
					"Exception occured while testing verifyCreateSurveyAudioTypeQuestionDetails : " + e.getMessage());
			logger.error("Error occured while verifyCreateSurveyAudioTypeQuestionDetails " + e);
		}

		logger.info("Starting of verifyCreateSurveyAudioTypeQuestionDetails method");
	}

	@Test(priority = 6, description = "Verify Create Survey Video Type Question Details ")
	@Description("Test Case #6, Verify Create Survey Video Type Question Details ")
	@Severity(SeverityLevel.CRITICAL)
	@Story("Test Case #6, Verify Create Survey Image Video Question Details ")
	public void verifyCreateSurveyVideoTypeQuestionDetails() {
		logger.info("Starting of verifyCreateSurveyVideoTypeQuestionDetails method");

		try {

			this.createSurveyQuestionPage.AddQuestion();

			this.createSurveyQuestionPage.clickOnAddVideoQuestion(testDataProp.getProperty(ADD_VIDEO_QUESTION));

			this.createSurveyQuestionPage.AddQuestionDesc();
			
			Assert.assertEquals(createSurveyQuestionPage.getQuestionAddedSuccessfullyText(),
					expectedAssertionsProp.getProperty(QUESTION_ADDED_SUCCESSFULLY_TEXT));

		} catch (Exception e) {
			Assert.fail(
					"Exception occured while testing verifyCreateSurveyVideoTypeQuestionDetails : " + e.getMessage());
			logger.error("Error occured while verifyCreateSurveyVideoTypeQuestionDetails " + e);
		}

		logger.info("Starting of verifyCreateSurveyVideoTypeQuestionDetails method");
	}

	@Test(priority = 7, description = "Verify Create Survey Design Tab Details")
	@Description("Test Case #7, Verify Create Survey Design Tab Details")
	@Severity(SeverityLevel.NORMAL)
	@Story("Test Case #7, Verify Create Survey Design Tab Details")
	public void verifyCreateSurveyDesignTabDetails() {
		logger.info("Starting of verifyCreateSurveyDesignTabDetails method");

		try {

			createServeyDesignPage.clickOnDesignTabButton();

			Assert.assertEquals(createServeyDesignPage.getDesignTabButtonText(),
					expectedAssertionsProp.getProperty(DESIGN_TEXT));

			createServeyDesignPage.clickOnSaveButton();

		} catch (Exception e) {
			Assert.fail("Exception occured while testing verifyCreateSurveyDesignTabDetails : " + e.getMessage());
			logger.error("Error occured while verifyCreateSurveyDesignTabDetails " + e);
		}

		logger.info("Ending of verifyCreateSurveyDesignTabDetails method");
	}
	
	@Test(priority = 8, description = "Verify Create Survey Welcome Page Details")
	@Description("Test Case #8, Verify Create Survey Welcome Page Details")
	@Severity(SeverityLevel.NORMAL)
	@Story("Test Case #8, Verify Create Survey Welcome Page Details")
	public void verifyCreateSurveyWelcomeTabDetails() {
		logger.info("Starting of verifyCreateSurveyWelcomeTabDetails method");

		try {
			assertTrue(this.createServeyWelcomePage.isWelcomeTitlTextDisplayed());
			this.createServeyWelcomePage.setWelComeTitleText(testDataProp.getProperty(WELCOME_TITLE));
			
			assertTrue(this.createServeyWelcomePage.isWelcomeDescriptionDisplayed());
			this.createServeyWelcomePage.setWelComeDescription(testDataProp.getProperty(WELCOME_DESCRIPTION));
			
			this.createServeyWelcomePage.clickOnSaveButton();
			
		} catch (Exception e) {
			Assert.fail("Exception occured while testing verifyCreateSurveyWelcomeTabDetails : " + e.getMessage());
			logger.error("Error occured while verifyCreateSurveyWelcomeTabDetails " + e);
		}

		logger.info("Ending of verifyCreateSurveyWelcomeTabDetails method");
	}

	@Test(priority = 9, description = "Verify Create Survey Thank you page details")
	@Description("Test Case #9, Verify Create Survey Thank you page details")
	@Severity(SeverityLevel.NORMAL)
	@Story("Test Case #9, Verify Create Survey Thank you page details")
	public void verifyCreateSurveyThankYouTabDetails() {
		logger.info("Starting of verifyCreateSurveyThankYouTabDetails method");

		try {
			assertTrue(this.createServeyThankyouPage.isThankYouTitleDisplayed());
			this.createServeyThankyouPage.setThankYouTitle(testDataProp.getProperty(THANK_YOU_TITLE));
			
			assertTrue(this.createServeyThankyouPage.isThankYouMessageDisplayed());
			this.createServeyThankyouPage.setThankYouMessage(testDataProp.getProperty(THANK_YOU_MESSAGE));
			
			this.createServeyThankyouPage.clickOnUpDateButton();

		} catch (Exception e) {
			Assert.fail("Exception occured while testing verifyCreateSurveyThankYouTabDetails : " + e.getMessage());
			logger.error("Error occured while verifyCreateSurveyThankYouTabDetails " + e);
		}

		logger.info("Ending of verifyCreateSurveyThankYouTabDetails method");
	}
	
	@Test(priority = 10, description = "Verify Create Survey Preview details")
	@Description("Test Case #10, Verify Create Survey Preview details")
	@Severity(SeverityLevel.NORMAL)
	@Story("Test Case #10, Verify Create Survey Preview details")
	public void verifyCreateSurveyPreviewDetails() {
		logger.info("Starting of verifyCreateSurveyPreviewDetails method");

		try {
			Assert.assertEquals(createServeyPreviewPage.getPreviewButtonText(),
					expectedAssertionsProp.getProperty(PREVIEW_BUTTON_TEXT));
			
			this.createServeyThankyouPage.clickOnPreviewButton();

		} catch (Exception e) {
			Assert.fail("Exception occured while testing verifyCreateSurveyPreviewDetails : " + e.getMessage());
			logger.error("Error occured while verifyCreateSurveyPreviewDetails " + e);
		}

		logger.info("Ending of verifyCreateSurveyPreviewDetails method");
	}
	
	@Test(priority = 11, description = "Verify Create Survey Preview details")
	@Description("Test Case #11, Verify Create Survey Preview details")
	@Severity(SeverityLevel.NORMAL)
	@Story("Test Case #11, Verify Create Survey Preview details")
	public void verifyCreateSurveyPreviewStartDetails() {
		logger.info("Starting of verifyCreateSurveyPreviewStartDetails method");

		try {
			
			Assert.assertEquals(createServeyPreviewPage.getPreferedLangText(),
					expectedAssertionsProp.getProperty(PREFERRED_LANGUAGE_TEXT));
			
			this.createServeyPreviewPage.clickOnStartButton();
			
			this.createServeyPreviewPage.clickOnAnswerOptionButton();
			
			this.createServeyPreviewPage.clickOnAddComments(testDataProp.getProperty(ADD_COMMENTS_TEXT));
			
			Thread.sleep(2000);
			this.createServeyPreviewPage.clickOnTextQuestionNextButton();

			
			this.createServeyPreviewPage.clickOnImageAnswerOptionButton();
			
			this.createServeyPreviewPage.clickOnAddComments(testDataProp.getProperty(ADD_COMMENTS_TEXT));
			
			this.createServeyPreviewPage.clickOnImageQuestionNextButton();
			Thread.sleep(2000);
			
			this.createServeyPreviewPage.clickOnAudioQuestionOption();
			
			this.createServeyPreviewPage.clickOnAudioQuestionNext();
			
			Thread.sleep(2000);
			this.createServeyPreviewPage.clickOnVideoQuestionOption();
			
			this.createServeyPreviewPage.clickOnAddComments(testDataProp.getProperty(ADD_COMMENTS_TEXT));
			
			this.createServeyPreviewPage.clickOnSubmitButton();
			
			assertTrue(this.createServeyPreviewPage.isThankyouMessageDisplayed());
			
			
			this.createServeyPreviewPage.clickOnCloseButton();
			
		} catch (Exception e) {
			Assert.fail("Exception occured while testing verifyCreateSurveyPreviewStartDetails : " + e.getMessage());
			logger.error("Error occured while verifyCreateSurveyPreviewStartDetails " + e);
		}

		logger.info("Ending of verifyCreateSurveyPreviewStartDetails method");
	}
	
	@Test(priority = 12, description = "Verify Create Survey Publish details")
	@Description("Test Case #12, Verify Create Survey Publish details")
	@Severity(SeverityLevel.NORMAL)
	@Story("Test Case #12, Verify Create Survey Publish details")
	public void verifyCreateSurveyPublishDetails() {
		logger.info("Starting of verifyCreateSurveyPublishDetails method");

		try {
			
			this.createServeyPreviewPage.clickOnPublishButton();
			
		} catch (Exception e) {
			Assert.fail("Exception occured while testing verifyCreateSurveyPublishDetails : " + e.getMessage());
			logger.error("Error occured while verifyCreateSurveyPublishDetails " + e);
		}

		logger.info("Ending of verifyCreateSurveyPublishDetails method");
	}
	
	@Test(priority = 13, description = "Verify create survey campaign details")
	@Description("Test Case #13, Verify create survey campaign details")
	@Severity(SeverityLevel.CRITICAL)
	@Story("Test Case #13, Verify create survey campaign details")
	public void verifyCreateSurveyCampaignDetails() {
		logger.info("Starting of verifyCreateSurveyCampaignDetails method");

		try {
			Assert.assertEquals(createServeyCompaignPage.getCampaignPageText(),
					expectedAssertionsProp.getProperty(COMPAIGN_TEXT));
			
			this.createServeyCompaignPage.setCampaignTitleText(testDataProp.getProperty(ADD_CAMPAIGN_TITLE));
			
			this.createServeyCompaignPage.clickOnCampaignType();
			this.createServeyCompaignPage.clickOnScheduleModeDropDownButton();
			this.createServeyCompaignPage.clickOnSelectModesDropDown();
			this.createServeyCompaignPage.clickOnEmailCheckBox();
			
			this.createServeyCompaignPage.clickOnTimeZoneDropDownButton();
			this.createServeyCompaignPage.clickOnTimeZoneOptionButton();
			this.createServeyCompaignPage.setSubjectText(testDataProp.getProperty(ADD_SUBJECT_TEXT));
			this.createServeyCompaignPage.setTextEmail(testDataProp.getProperty(CAMPAIGN_EMAIL_MESSAGE));
			
			this.createServeyCompaignPage.clickOnRegionDropDownButton();
			this.createServeyCompaignPage.clickOnSelectAllCHeckBox();
			this.createServeyCompaignPage.clickOnDepartmentDropDown();
			
			this.createServeyCompaignPage.clickOnSelectAllDepartmentCheckBox();
			this.createServeyCompaignPage.clickOnGenderDropDownButton();
			this.createServeyCompaignPage.clickOnFemaleOptionCheckBox();
			this.createServeyCompaignPage.clickOnShowListButton();
			
			this.createServeyCompaignPage.setNameTextField(testDataProp.getProperty(EMPLOYEE_NAME));
			this.createServeyCompaignPage.clickOnCloseButton();
			
			
			this.createServeyCompaignPage.clickOnSendButton();
			
			Assert.assertEquals(createServeyCompaignPage.getCampaignSuccessMsg(),
			  expectedAssertionsProp.getProperty(COMPAIGN_CREATED_SUCCESS_TEXT));
			 
			
		} catch (Exception e) {
			Assert.fail("Exception occured while testing verifyCreateSurveyCampaignDetails : " + e.getMessage());
			logger.error("Error occured while verifyCreateSurveyCampaignDetails " + e);
		}

		logger.info("Ending of verifyCreateSurveyCampaignDetails method");
	}
}