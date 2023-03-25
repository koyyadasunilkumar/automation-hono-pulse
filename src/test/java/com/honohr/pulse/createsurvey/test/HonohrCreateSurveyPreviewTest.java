package com.honohr.pulse.createsurvey.test;

import static com.honohr.pulse.util.Constants.*;
import static org.junit.Assert.assertTrue;
import static org.testng.Assert.assertTrue;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.springframework.context.annotation.Description;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.honohr.pulse.base.test.BaseHonoPulseAutomationTest;
import com.honohr.pulse.createsurvey.pages.HonoPulseCreateServeyDesignPage;
import com.honohr.pulse.createsurvey.pages.HonohrPulseCreateSurveyPage;
import com.honohr.pulse.createsurvey.pages.HonohrPulseCreateSurveyPreviewPage;
import com.honohr.pulse.createsurvey.pages.HonohrPulseCreateSurveyQuestionPage;
import com.honohr.pulse.createsurvey.pages.HonohrPulseCreateSurveyThankYouPage;
import com.honohr.pulse.login.pages.HonohrPulseLoginPage;

import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Story;

@Epic("Hono pulse Create Survey")
@Feature("Create survey preview test")
public class HonohrCreateSurveyPreviewTest extends BaseHonoPulseAutomationTest {
	
	private WebDriver driver = null;
	private HonohrPulseLoginPage honoLoginPage = null;
	private HonohrPulseCreateSurveyPage honoCreateSurveyPage = null;
	private HonohrPulseCreateSurveyQuestionPage createSurveyQuestionPage = null;
	private HonohrPulseCreateSurveyPreviewPage createServeyPreviewPage = null;
	private HonohrPulseCreateSurveyThankYouPage createServeyThankyouPage = null;
	private HonoPulseCreateServeyDesignPage createServeyDesignPage = null;


	
	private static final Logger logger = Logger.getLogger(HonohrCreatesurveyGeneralTest.class.getName());
	
	@BeforeTest
	@Parameters({ "browser", "siteURL", "emailAddress", "password" })
	public void initMethodTest(String browser, String siteURL, String emailAddress, String password) throws Exception {
		logger.info("Starting of initMethodTest method");

		this.driver = this.getWebDriver(browser);
		this.loginToHono(browser, siteURL, emailAddress, password, this.driver);
		
		honoLoginPage = new HonohrPulseLoginPage(this.driver);
		honoCreateSurveyPage = new HonohrPulseCreateSurveyPage(this.driver);
		createSurveyQuestionPage = new HonohrPulseCreateSurveyQuestionPage(driver);
		createServeyPreviewPage = new HonohrPulseCreateSurveyPreviewPage(driver);
		createServeyThankyouPage = new HonohrPulseCreateSurveyThankYouPage(driver);
		createServeyDesignPage = new HonoPulseCreateServeyDesignPage(driver);



		logger.info("Ending of initMethodTest method");
	}
	
	@Test(priority = 1, description = "Verify Dashboard")
	@Description("Test Case #1, Verify Dashboard")
	@Severity(SeverityLevel.NORMAL)
	@Story("Test Case #1, Verify Dashboard")
	public void verifyDashboard() {
		logger.info("Starting of verifyDashboard method");

		try {

			Assert.assertEquals(honoLoginPage.getTextDashboard(), expectedAssertionsProp.getProperty(DASHBOARD_TEXT));

		} catch (Exception e) {
			Assert.fail("Exception occured while testing verifyDashboard : " + e.getMessage());
			logger.error("Error occured while verifyDashboard " + e);
		}

		logger.info("Starting of verifyDashboard method");
	}

	@Test(priority = 2, description = "Verify General Tab Details")
	@Description("Test Case #2, Verify General Tab Details")
	@Severity(SeverityLevel.NORMAL)
	@Story("Test Case #2, Verify General Tab Details")
	public void verifyCreatesurveyGeneralFunctionality() {
		logger.info("Starting of verifyCreatesurveyGeneralFunctionality method");

		try {

			honoCreateSurveyPage.clickOnCreateNewButton();

			Assert.assertEquals(honoCreateSurveyPage.getCreateSurveyText(),
					expectedAssertionsProp.getProperty(CREATE_SURVEY_TEXT));

			Assert.assertEquals(honoCreateSurveyPage.getTextGeneral(),
					expectedAssertionsProp.getProperty(GENERAL_TEXT));

		} catch (Exception e) {
			Assert.fail("Exception occured while testing verifyDashboard : " + e.getMessage());
			logger.error("Error occured while verifyDashboard " + e);
		}

		logger.info("Starting of verifyCreatesurveyGeneralFunctionality method");
	}

	@Test(priority = 3, description = "Verify Create Survey Preview details Without giving General and Question and Design Tab deails")
	@Description("Test Case #3, Verify Create Survey Preview details Without giving General and Question and Design Tab deails")
	@Severity(SeverityLevel.NORMAL)
	@Story("Test Case #3, Verify Create Survey Preview details Without giving General and Question and Design Tab deails")
	public void verifyCreateSurveyPreviewDetailsWithoutDetalis() {
		logger.info("Starting of verifyCreateSurveyPreviewDetails method");

		try {
			Assert.assertEquals(createServeyPreviewPage.getPreviewButtonText(),
					expectedAssertionsProp.getProperty(PREVIEW_BUTTON_TEXT));
			
			this.createServeyThankyouPage.clickOnPreviewButton();
			
			
			Assert.assertEquals(createServeyPreviewPage.getAddQuestionsToSeePreviewText(),
					expectedAssertionsProp.getProperty(ADD_QUESTIONS_TO_SEE_PREVIEW_TEXT));

		} catch (Exception e) {
			Assert.fail("Exception occured while testing verifyCreateSurveyPreviewDetails : " + e.getMessage());
			logger.error("Error occured while verifyCreateSurveyPreviewDetails " + e);
		}

		logger.info("Ending of verifyCreateSurveyPreviewDetails method");
	}
	
	@Test(priority = 4, description = "Verify Create Survey Preview details Without giving General and Design Tab deails")
	@Description("Test Case #4, Verify Create Survey Preview details Without giving General and Design Tab deails")
	@Severity(SeverityLevel.NORMAL)
	@Story("Test Case #4, Verify Create Survey Preview details Without giving General and Design Tab deails")
	public void verifyCreateSurveyPreviewDetailsWithoutGeneralAndDesignDetails() {
		logger.info("Starting of verifyCreateSurveyPreviewDetailsWithoutGeneralAndDesignDetails method");

		try {
			
			//this.createSurveyQuestionPage.refresh();
			
			this.createServeyPreviewPage.clickOnQuestionButton();
			
			this.createSurveyQuestionPage.clickOnQuestionType();
			
			this.createSurveyQuestionPage.clickOnEngagementParameterDropDown();
			
			this.createSurveyQuestionPage.clickOnSubParameter();
			
			this.createSurveyQuestionPage.clickOnScale();
			
			this.createSurveyQuestionPage.clickOnLikertScaleEngagement();
			
			this.createSurveyQuestionPage.clickOnAddImageQuestion(testDataProp.getProperty(ADD_IMAGE_CHOICE_FILE));
			
			this.createSurveyQuestionPage.clickOnQuestionSaveButton();
			
			Assert.assertEquals(createServeyPreviewPage.getFillBasicDetailsFirstText(),
					expectedAssertionsProp.getProperty(FILL_BASIC_DETAILS_FIRST_TEXT));
			

		} catch (Exception e) {
			Assert.fail("Exception occured while testing verifyCreateSurveyPreviewDetailsWithoutGeneralAndDesignDetails : " + e.getMessage());
			logger.error("Error occured while verifyCreateSurveyPreviewDetailsWithoutGeneralAndDesignDetails " + e);
		}

		logger.info("Ending of verifyCreateSurveyPreviewDetailsWithoutGeneralAndDesignDetails method");
	}
	
	@Test(priority = 5, description = "Verify Create Survey Preview details Without giving Design Tab deails")
	@Description("Test Case #5, Verify Create Survey Preview details Without giving Design Tab deails")
	@Severity(SeverityLevel.NORMAL)
	@Story("Test Case #5, Verify Create Survey Preview details Without giving Design Tab deails")
	public void verifyCreateSurveyPreviewDetailsByWithoutGivingDesign() {
		logger.info("Starting of verifyCreateSurveyGeneralTabDetails method");

		try {
			
			this.createServeyPreviewPage.clickOnGeneralButton();
			
			this.honoCreateSurveyPage.clickOnSurveyName(testDataProp.getProperty(SURVEY_NAME));
			
			this.honoCreateSurveyPage.clickOnSurveyDesc(testDataProp.getProperty(SURVEY_DESC));
			
			this.honoCreateSurveyPage.clickOnSurveyCategory();
			
			this.honoCreateSurveyPage.clickOnEngagement();
			
			this.honoCreateSurveyPage.setExpiryDate(testDataProp.getProperty(EXPIRY_DATE));
			
			this.honoCreateSurveyPage.clickOnAddLanguage();
			
			this.honoCreateSurveyPage.clickOnSelectLanguage();
			
			this.honoCreateSurveyPage.clickOnSaveButton();
			
			this.createSurveyQuestionPage.clickOnQuestionSaveButton();
			
			this.createServeyPreviewPage.clickOnQuestionButton();
			
			this.createSurveyQuestionPage.clickOnQuestionType();
			
			this.createSurveyQuestionPage.clickOnEngagementParameterDropDown();
			
			this.createSurveyQuestionPage.clickOnSubParameter();
			
			this.createSurveyQuestionPage.clickOnScale();
			
			this.createSurveyQuestionPage.clickOnLikertScaleEngagement();
			
			this.createSurveyQuestionPage.clickOnAddImageQuestion(testDataProp.getProperty(ADD_IMAGE_CHOICE_FILE));
			
			this.createSurveyQuestionPage.clickOnQuestionSaveButton();

			this.createServeyThankyouPage.clickOnPreviewButton();
			
			Assert.assertEquals(createServeyPreviewPage.getAddSurveyDesignFirstText(),
					expectedAssertionsProp.getProperty(ADD_SURVEY_DESIGN_FIRST_TEXT));
			
		} catch (Exception e) {
			Assert.fail("Exception occred while testing verifyCreateSurveyGeneralTabDetails : " + e.getMessage());
			logger.error("Error occured while verifyCreateSurveyGeneralTabDetails " + e);
		}

		logger.info("Starting of verifyCreateSurveyGeneralTabDetails method");
	}
	
	@Test(priority = 6, description = "Verify Create Survey Preview details With giving all deails")
	@Description("Test Case #6, Verify Create Survey Preview details With giving all deails")
	@Severity(SeverityLevel.NORMAL)
	@Story("Test Case #6, Verify Create Survey Preview details With giving deails")
	public void verifyCreateSurveyPreviewDetailsByGivingAllDetails() {
		logger.info("Starting of verifyCreateSurveyPreviewDetailsByGivingAllDetails method");

		try {
			
			this.createServeyPreviewPage.clickOnDesignButton();
			
			this.createServeyDesignPage.clickOnSaveButton();
			
			this.createServeyThankyouPage.clickOnPreviewButton();
			
		} catch (Exception e) {
			Assert.fail("Exception occred while testing verifyCreateSurveyPreviewDetailsByGivingAllDetails : " + e.getMessage());
			logger.error("Error occured while verifyCreateSurveyPreviewDetailsByGivingAllDetails " + e);
		}

		logger.info("Starting of verifyCreateSurveyPreviewDetailsByGivingAllDetails method");
	}
	
	@Test(priority = 7, description = "Verify Create Survey Preview details")
	@Description("Test Case #7, Verify Create Survey Preview details")
	@Severity(SeverityLevel.NORMAL)
	@Story("Test Case #7, Verify Create Survey Preview details")
	public void verifyCreateSurveyPreviewStartDetails() {
		logger.info("Starting of verifyCreateSurveyPreviewStartDetails method");

		try {
			
			Assert.assertEquals(createServeyPreviewPage.getPreferedLangText(),
					expectedAssertionsProp.getProperty(PREFERRED_LANGUAGE_TEXT));
			
			this.createServeyPreviewPage.clickOnStartButton();
			
			//this.createServeyPreviewPage.clickOnAnswerOptionButton();
			
			//this.createServeyPreviewPage.clickOnAddComments(testDataProp.getProperty(ADD_COMMENTS_TEXT));
			
			//this.createServeyPreviewPage.clickOnSubmitButton();
			//Thread.sleep(2000);
			this.createServeyPreviewPage.clickOnTextQuestionNextButton();
			
			Assert.assertEquals(createServeyPreviewPage.getSelectOptionFirstFirstText(),
					expectedAssertionsProp.getProperty(SELECT_OPTION_FIRST_TEXT));
			
			//this.createServeyPreviewPage.clickOnImageAnswerOptionButton();
			
			//this.createServeyPreviewPage.clickOnAddComments(testDataProp.getProperty(ADD_COMMENTS_TEXT));
			
			//this.createServeyPreviewPage.clickOnImageQuestionNextButton();
			Thread.sleep(2000);
			
			
			//this.createServeyPreviewPage.clickOnSubmitButton();
			
			//assertTrue(this.createServeyPreviewPage.isThankyouMessageDisplayed());
			
			
			//this.createServeyPreviewPage.clickOnCloseButton();
			
		} catch (Exception e) {
			Assert.fail("Exception occured while testing verifyCreateSurveyPreviewStartDetails : " + e.getMessage());
			logger.error("Error occured while verifyCreateSurveyPreviewStartDetails " + e);
		}

		logger.info("Ending of verifyCreateSurveyPreviewStartDetails method");
	}
}