package com.honohr.pulse.createsurvey.test;

import static com.honohr.pulse.util.Constants.*;

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
import com.honohr.pulse.createsurvey.pages.HonohrPulseCreateSurveyQuestionPage;
import com.honohr.pulse.login.pages.HonohrPulseLoginPage;

import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Story;

@Epic("Hono pulse Create Survey")
@Feature("Create survey Add Questions")
public class HonohrCreateSurveyAddQuestionsTest extends BaseHonoPulseAutomationTest {
	
	private WebDriver driver = null;
	private HonohrPulseLoginPage honoLoginPage = null;
	private HonohrPulseCreateSurveyPage honoCreateSurveyPage = null;
	private HonohrPulseCreateSurveyQuestionPage createSurveyQuestionPage = null;
	
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

			this.honoCreateSurveyPage.clickOnSurveyName(testDataProp.getProperty(SURVEY_NAME));
			this.honoCreateSurveyPage.clickOnSurveyDesc(testDataProp.getProperty(SURVEY_DESC));
			this.honoCreateSurveyPage.clickOnSurveyCategory();
			this.honoCreateSurveyPage.clickOnEngagement();
			this.honoCreateSurveyPage.setExpiryDate(testDataProp.getProperty(EXPIRY_DATE));

			this.honoCreateSurveyPage.clickOnAddLanguage();
			this.honoCreateSurveyPage.clickOnSelectLanguage();
			this.honoCreateSurveyPage.clickOnSaveButton();
			
			Assert.assertEquals(createSurveyQuestionPage.getSurveyInitializeSuccessfullyText(),
					expectedAssertionsProp.getProperty(SURVEY_INITIALIZE_SUCCESSFULLY));

		} catch (Exception e) {
			Assert.fail("Exception occured while testing verifyDashboard : " + e.getMessage());
			logger.error("Error occured while verifyDashboard " + e);
		}

		logger.info("Starting of verifyCreatesurveyGeneralFunctionality method");
	}
	
	@Test(priority = 3, description = "Verify question tab functionality without creating any question")
	@Description("Test Case #3, Verify question tab functionality without creating any question")
	@Severity(SeverityLevel.NORMAL)
	@Story("Test Case #3, Verify question tab functionality without creating any question ")
	public void verifyCreateSurveyQuestionDetailsWithoutQuestionDetails() {
		logger.info("Starting of verifyCreateSurveyQuestionDetailsWithoutQuestionDetails method");

		try {

			this.createSurveyQuestionPage.clickOnQuestionSaveButton();
			
			Assert.assertEquals(createSurveyQuestionPage.getSelectquestioncategorytocreatequestionText(),
					expectedAssertionsProp.getProperty(SELECT_QUESTION_CATEGORY_TO_CREATE_QUESTION));

		} catch (Exception e) {
			Assert.fail("Exception occured while testing verifyCreateSurveyQuestionDetailsWithoutQuestionDetails : "
					+ e.getMessage());
			logger.error("Error occured while verifyCreateSurveyQuestionDetailsWithoutQuestionDetails " + e);
		}

		logger.info("Starting of verifyCreateSurveyQuestionDetailsWithoutQuestionDetails method");
	}

	@Test(priority = 4, description = "Verify question tab functionality by adding Question type and leaving all fields blank")
	@Description("Test Case #4, Verify question tab functionality by adding Question type and leaving all fields blank")
	@Severity(SeverityLevel.NORMAL)
	@Story("Test Case #4, Verify question tab functionality by adding Question type and leaving all fields blank")
	public void verifyCreateSurveyQuestionDetailsByAddingOnlyQuestionType() {
		logger.info("Starting of verifyCreateSurveyQuestionDetailsByAddingOnlyQuestionType method");

		try {

			this.createSurveyQuestionPage.refresh();

			this.createSurveyQuestionPage.clickOnQuestionType();

			this.createSurveyQuestionPage.clickOnQuestionSaveButton();
			
			Assert.assertEquals(createSurveyQuestionPage.getAddQuestionTextFirstText(),
					expectedAssertionsProp.getProperty(ADD_QUESTION_TEXT_FIRST));

		} catch (Exception e) {
			Assert.fail("Exception occured while testing verifyCreateSurveyQuestionDetailsByAddingOnlyQuestionType : "
					+ e.getMessage());
			logger.error("Error occured while verifyCreateSurveyQuestionDetailsByAddingOnlyQuestionType " + e);
		}

		logger.info("Starting of verifyCreateSurveyQuestionDetailsByAddingOnlyQuestionType method");
	}
	

 
 
	@Test(priority = 5, description = "Verify question tab functionality by adding question type & Text question and leaving Parameter, Sub parameter, Scale,  Add Description, Is optional, link to parent question, Add comment fields blank")
	@Description("Test Case #5, Verify question tab functionality by adding Question type and leaving all fields blank")
	@Severity(SeverityLevel.NORMAL)
	@Story("Test Case #5, Verify question tab functionality by adding Question type and leaving all fields blank")
	public void verifyCreateSurveyQuestionDetailsByAddingOnlyQuestionTypeAndTextQuesti() {
		logger.info("Starting of verifyCreateSurveyQuestionDetailsByAddingOnlyQuestionTypeAndTextQuesti method");

		try {

			this.createSurveyQuestionPage.refresh();

			this.createSurveyQuestionPage.clickOnQuestionType();

			this.createSurveyQuestionPage.clickOnAddQuestion(testDataProp.getProperty(ADD_TEXT_QUESTION));

			this.createSurveyQuestionPage.clickOnQuestionSaveButton();
			
			Assert.assertEquals(createSurveyQuestionPage.getSomethingWentWrongText(),
					expectedAssertionsProp.getProperty(SOMETHING_WENT_WRONG));


		} catch (Exception e) {
			Assert.fail(
					"Exception occured while testing verifyCreateSurveyQuestionDetailsByAddingOnlyQuestionTypeAndTextQuesti : "
							+ e.getMessage());
			logger.error(
					"Error occured while verifyCreateSurveyQuestionDetailsByAddingOnlyQuestionTypeAndTextQuesti " + e);
		}

		logger.info("Starting of verifyCreateSurveyQuestionDetailsByAddingOnlyQuestionTypeAndTextQuesti method");
	}


	@Test(priority = 6, description = "Verify question tab functionality by adding Question type, parameter, sub parameter t, Add question & leaving Scale field blank")
	@Description("Test Case #6, Verify question tab functionality by adding Question type and leaving all fields blank")
	@Severity(SeverityLevel.NORMAL)
	@Story("Test Case #6, Verify question tab functionality by adding Question type and leaving all fields blank")
	public void verifyCreateSurveyQuestionDetailsByLeavingOnlyScaleValueblank() {
		logger.info("Starting of verifyCreateSurveyQuestionDetailsByLeavingOnlyScaleValueblank method");

		try {

			this.createSurveyQuestionPage.refresh();

			this.createSurveyQuestionPage.clickOnQuestionType();

			this.createSurveyQuestionPage.clickOnEngagementParameter();

			this.createSurveyQuestionPage.clickOnSubParameter();

			this.createSurveyQuestionPage.clickOnAddQuestion(testDataProp.getProperty(ADD_TEXT_QUESTION));

			this.createSurveyQuestionPage.clickOnQuestionSaveButton();
			
			Assert.assertEquals(createSurveyQuestionPage.getQuestionAddedSuccessfullyText(),
					expectedAssertionsProp.getProperty(QUESTION_ADDED_SUCCESSFULLY));

			

		} catch (Exception e) {
			Assert.fail(
					"Exception occured while testing verifyCreateSurveyQuestionDetailsByLeavingOnlyScaleValueblank : "
							+ e.getMessage());
			logger.error("Error occured while verifyCreateSurveyQuestionDetailsByLeavingOnlyScaleValueblank " + e);
		}

		logger.info("Starting of verifyCreateSurveyQuestionDetailsByLeavingOnlyScaleValueblank method");
	}



	@Test(priority = 7, description = "Verify question tab functionality by Selecting Scale type as opinion and leaving Minimum & maximum value fields blank")
	@Description("Test Case #7, Verify question tab functionality by Selecting Scale type as opinion and leaving Minimum & maximum value fields blank")
	@Severity(SeverityLevel.NORMAL)
	@Story("Test Case #7, Verify question tab functionality by Selecting Scale type as opinion and leaving Minimum & maximum value fields blank")
	public void verifyCreateSurveyQuestionDetailsByLeavingOnlyScaleMinAndMaxValuesBlank() {
		logger.info("Starting of verifyCreateSurveyQuestionDetailsByLeavingOnlyScaleMinAndMaxValuesBlank method");

	try {

			this.createSurveyQuestionPage.refresh();

			this.createSurveyQuestionPage.clickOnQuestionType();

			this.createSurveyQuestionPage.clickOnEngagementParameter();

			this.createSurveyQuestionPage.clickOnSubParameter();

			this.createSurveyQuestionPage.clickOnScale();

			this.createSurveyQuestionPage.clickOnOpinionScale();

			this.createSurveyQuestionPage.clickOnAddQuestion(testDataProp.getProperty(ADD_TEXT_QUESTION));

			this.createSurveyQuestionPage.clickOnQuestionSaveButton();
			
			Assert.assertEquals(createSurveyQuestionPage.getOpinionMinimumScaleValueIsRequiredText(),
					expectedAssertionsProp.getProperty(OPINION_MINIMUM_SCALE_VALUE_IS_REQUIRED));
			

		} catch (Exception e) {
			Assert.fail(
					"Exception occured while testing verifyCreateSurveyQuestionDetailsByLeavingOnlyScaleMinAndMaxValuesBlank : "
							+ e.getMessage());
			logger.error(
					"Error occured while verifyCreateSurveyQuestionDetailsByLeavingOnlyScaleMinAndMaxValuesBlank " + e);
		}

		logger.info("Starting of verifyCreateSurveyQuestionDetailsByLeavingOnlyScaleMinAndMaxValuesBlank method");
	}

	@Test(priority = 8, description = "Verify question tab functionality by selecting Scale type as opinion & Entering minimum value and leaving the maximum value field blank")
	@Description("Test Case #8, Verify question tab functionality by selecting Scale type as opinion & Entering minimum value and leaving the maximum value field blank")
	@Severity(SeverityLevel.NORMAL)
	@Story("Test Case #8, Verify question tab functionality by selecting Scale type as opinion & Entering minimum value and leaving the maximum value field blank")
	public void verifyCreateSurveyQuestionDetailsByLeavingOnlyScaleMinAndScaleTypeAndScaleMinValuesBlank() {
		logger.info(
				"Starting of verifyCreateSurveyQuestionDetailsByLeavingTheMAximumFieldBlank");

		try {

			this.createSurveyQuestionPage.refresh();

			this.createSurveyQuestionPage.clickOnQuestionType();

			this.createSurveyQuestionPage.clickOnEngagementParameter();

			this.createSurveyQuestionPage.clickOnSubParameter();

			this.createSurveyQuestionPage.clickOnScale();

			this.createSurveyQuestionPage.clickOnOpinionScale();

			this.createSurveyQuestionPage.clickOnOpinionScaleMinValue(testDataProp.getProperty(SCALE_MIN_VALUE));

			this.createSurveyQuestionPage.clickOnAddQuestion(testDataProp.getProperty(ADD_TEXT_QUESTION));

			this.createSurveyQuestionPage.clickOnQuestionSaveButton();
			
			Assert.assertEquals(createSurveyQuestionPage.getOpinionMaximumScaleValueIsRequiredText(),
					expectedAssertionsProp.getProperty(OPINION_MAXIMUM_SCALE_VALUE_IS_REQUIRED));

		} catch (Exception e) {
			Assert.fail(
					"Exception occured while testing verifyCreateSurveyQuestionDetailsByLeavingTheMAximumFieldBlank : "
							+ e.getMessage());
			logger.error(
					"Error occured while verifyCreateSurveyQuestionDetailsByLeavingTheMAximumFieldBlank "
							+ e);
		}

		logger.info(
				"Starting of verifyCreateSurveyQuestionDetailsByLeavingTheMAximumFieldBlank method");
	}


	@Test(priority = 9, description = "Verify question tab functionality by leaving select Engagement parameter field blank")
	@Description("Test Case #9, Verify question tab functionality by leaving select Engagement parameter field blank")
	@Severity(SeverityLevel.NORMAL)
	@Story("Test Case #9. Verify question tab functionality by leaving select Engagement parameter field blank")
	public void verifyCreateSurveyQuestionDetailsByLeavingOnlyEngagementParameterBlank() {
		logger.info("Starting of verifyCreateSurveyQuestionDetailsByLeavingOnlyEngagementParameterBlank method");

		try {

			this.createSurveyQuestionPage.refresh();

			this.createSurveyQuestionPage.clickOnQuestionType();

			this.createSurveyQuestionPage.clickOnAddQuestion(testDataProp.getProperty(ADD_TEXT_QUESTION));

			this.createSurveyQuestionPage.clickOnQuestionSaveButton();
			
			Assert.assertEquals(createSurveyQuestionPage.getSomethingWentWrongText(),
					expectedAssertionsProp.getProperty(SOMETHING_WENT_WRONG));

			

		} catch (Exception e) {
			Assert.fail(
					"Exception occured while testing verifyCreateSurveyQuestionDetailsByLeavingOnlyEngagementParameterBlank : "
							+ e.getMessage());
			logger.error(
					"Error occured while verifyCreateSurveyQuestionDetailsByLeavingOnlyEngagementParameterBlank " + e);
		}

		logger.info("Starting of verifyCreateSurveyQuestionDetailsByLeavingOnlyEngagementParameterBlank method");
	}

	
	@Test(priority = 10, description = "Verify question tab functionality by selecting Scale type as Rating & leaving the Left label, Right label, Maximum Value fields blank")
	@Description("Test Case #10, Verify question tab functionality by selecting Scale type as Rating & leaving the Left label, Right label, Maximum Value fields blank")
	@Severity(SeverityLevel.NORMAL)
	@Story("Test Case #10. Verify question tab functionality by selecting Scale type as Rating & leaving the Left label, Right label, Maximum Value fields blank")
	public void verifyCreateSurveyQuestionDetailsBySelectingOnlyScaleTypeAsBlank() {
		logger.info("Starting of verifyCreateSurveyQuestionDetailsByLeavingOnlyEngagementParameterBlank method");

		try {

			this.createSurveyQuestionPage.refresh();

			this.createSurveyQuestionPage.clickOnQuestionType();

			this.createSurveyQuestionPage.clickOnScale();

			this.createSurveyQuestionPage.clickOnRatingScale();

			this.createSurveyQuestionPage.clickOnAddQuestion(testDataProp.getProperty(ADD_TEXT_QUESTION));

			this.createSurveyQuestionPage.clickOnQuestionSaveButton();
			
			Assert.assertEquals(createSurveyQuestionPage.getRatingImageCountIsRequiredText(),
					expectedAssertionsProp.getProperty(RATING_IMAGE_COUNT_IS_REQUIRED));

		} catch (Exception e) {
			Assert.fail(
					"Exception occured while testing verifyCreateSurveyQuestionDetailsByLeavingOnlyEngagementParameterBlank : "
							+ e.getMessage());
			logger.error(
					"Error occured while verifyCreateSurveyQuestionDetailsByLeavingOnlyEngagementParameterBlank " + e);
		}

		logger.info("Starting of verifyCreateSurveyQuestionDetailsByLeavingOnlyEngagementParameterBlank method");
	}


 
	@Test(priority = 11, description = "Verify Rating Sacle functionality by Entering Left label and leaving Right label , Maximum value fields blank in question tab")
	@Description("Test Case #11, Verify Rating Sacle functionality by Entering Left label and leaving Right label , Maximum value fields blank in question tab")
	@Severity(SeverityLevel.NORMAL)
	@Story("Test Case #11. Verify Rating Sacle functionality by Entering Left label and leaving Right label , Maximum value fields blank in question tab")
	public void verifyCreateSurveyQuestionDetailsByLeavingTheMaximumFielAndRightLabeldBlank() {
		logger.info("Starting of verifyCreateSurveyQuestionDetailsByLeavingTheMaximumFielAndRightLabeldBlank method");

		try {

			this.createSurveyQuestionPage.refresh();

			this.createSurveyQuestionPage.clickOnQuestionType();

			this.createSurveyQuestionPage.clickOnEngagementParameter();

			this.createSurveyQuestionPage.clickOnSubParameter();

			this.createSurveyQuestionPage.clickOnScale();

			this.createSurveyQuestionPage.clickOnRatingScale();

			this.createSurveyQuestionPage.clickOnAddQuestion(testDataProp.getProperty(ADD_TEXT_QUESTION));

			this.createSurveyQuestionPage.clickOnQuestionSaveButton();
			
			Assert.assertEquals(createSurveyQuestionPage.getRatingImageCountIsRequiredText(),
					expectedAssertionsProp.getProperty(RATING_IMAGE_COUNT_IS_REQUIRED));


		} catch (Exception e) {
			Assert.fail(
					"Exception occured while testing verifyCreateSurveyQuestionDetailsByLeavingTheMaximumFielAndRightLabeldBlank : "
							+ e.getMessage());
			logger.error("Error occured while verifyCreateSurveyQuestionDetailsByLeavingTheMaximumFielAndRightLabeldBlank " + e);
		}

		logger.info("Starting of verifyCreateSurveyQuestionDetailsByLeavingTheMaximumFielAndRightLabeldBlank method");
	}

	
	
	@Test(priority = 12, description = "Verify Rating Sacle functionality by Entering the Left label ,Right label &Leaving Maximum value fields blank in the question tab")
	@Description("Test Case #12, Verify Rating Sacle functionality by Entering the Left label ,Right label &Leaving Maximum value fields blank in the question tab")
	@Severity(SeverityLevel.NORMAL)
	@Story("Test Case #12. Verify Rating Sacle functionality by Entering the Left label ,Right label &Leaving Maximum value fields blank in the question tab")
	public void verifyCreateSurveyQuestionDetailsByGivingLeftAndRightLabelValues() {
		logger.info("Starting of verifyCreateSurveyQuestionDetailsByGivingLeftAndRightLabelValues method");

		try {

			this.createSurveyQuestionPage.refresh();

			this.createSurveyQuestionPage.clickOnQuestionType();

			this.createSurveyQuestionPage.clickOnEngagementParameter();

			this.createSurveyQuestionPage.clickOnSubParameter();

			this.createSurveyQuestionPage.clickOnScale();

			this.createSurveyQuestionPage.clickOnRatingScale();

			this.createSurveyQuestionPage.clickOnRatingScaleLeftLabel(testDataProp.getProperty(LEFT_LABEL_TEXT));

			this.createSurveyQuestionPage.clickOnRatingScaleRightLabel(testDataProp.getProperty(RIGHT_LABEL_TEXT));

			this.createSurveyQuestionPage.clickOnAddQuestion(testDataProp.getProperty(ADD_TEXT_QUESTION));

			this.createSurveyQuestionPage.clickOnQuestionSaveButton();
			
			Assert.assertEquals(createSurveyQuestionPage.getRatingImageCountIsRequiredText(),
					expectedAssertionsProp.getProperty(RATING_IMAGE_COUNT_IS_REQUIRED));


		} catch (Exception e) {
			Assert.fail(
					"Exception occured while testing verifyCreateSurveyQuestionDetailsByGivingLeftAndRightLabelValues : "
							+ e.getMessage());
			logger.error("Error occured while verifyCreateSurveyQuestionDetailsByGivingLeftAndRightLabelValues " + e);
		}

		logger.info("Starting of verifyCreateSurveyQuestionDetailsByGivingLeftAndRightLabelOnlyLeftLabelValues method");
	}

	
	@Test(priority = 13, description = "Verify Rating Sacle functionality by Entering the Left label , Right label, Maximum value& without selecting Rating Image in the question tab")
	@Description("Test Case #13, Verify Rating Sacle functionality by Entering the Left label , Right label, Maximum value& without selecting Rating Image in the question tab")
	@Severity(SeverityLevel.NORMAL)
	@Story("Test Case #13. Verify Rating Sacle functionality by Entering the Left label , Right label, Maximum value& without selecting Rating Image in the question tab")
	public void verifyCreateSurveyQuestionDetailsByLeavingRatingImage() {
		logger.info("Starting of verifyCreateSurveyQuestionDetailsByLeavingRatingImage method");

		try {

			this.createSurveyQuestionPage.refresh();

			this.createSurveyQuestionPage.clickOnQuestionType();

			this.createSurveyQuestionPage.clickOnEngagementParameter();

			this.createSurveyQuestionPage.clickOnSubParameter();

			this.createSurveyQuestionPage.clickOnScale();

			this.createSurveyQuestionPage.clickOnRatingScale();

			this.createSurveyQuestionPage.clickOnRatingScaleLeftLabel(testDataProp.getProperty(LEFT_LABEL_TEXT));

			this.createSurveyQuestionPage.clickOnRatingScaleRightLabel(testDataProp.getProperty(RIGHT_LABEL_TEXT));

			this.createSurveyQuestionPage.clickOnRatingScaleMaximumValue(testDataProp.getProperty(RATING_MAX_VALUE));

			this.createSurveyQuestionPage.clickOnAddQuestion(testDataProp.getProperty(ADD_TEXT_QUESTION));

			this.createSurveyQuestionPage.clickOnQuestionSaveButton();
			
			Assert.assertEquals(createSurveyQuestionPage.getRatingImageIsRequiredText(),
					expectedAssertionsProp.getProperty(RATING_IMAGE_IS_REQUIRED));


		} catch (Exception e) {
			Assert.fail("Exception occured while testing verifyCreateSurveyQuestionDetailsByLeavingRatingImage : "
					+ e.getMessage());
			logger.error("Error occured while verifyCreateSurveyQuestionDetailsByLeavingRatingImage " + e);
		}

		logger.info("Starting of verifyCreateSurveyQuestionDetailsByLeavingRatingImage method");
	}

	@Test(priority = 14, description = "Verify Rating Scale functionality with more then Maximum value in question tab")
	@Description("Test Case #14, Verify Rating Scale functionality with more then Maximum value in question tab")
	@Severity(SeverityLevel.NORMAL)
	@Story("Test Case #14. Verify Rating Scale functionality with more then Maximum value in question tab")
	public void verifyCreateSurveyQuestionDetailsByGivingRatingScaleMorethanMaximum() {
		logger.info("Starting of verifyCreateSurveyQuestionDetailsByGivingRatingScaleMorethanMaximum method");

		try {

			this.createSurveyQuestionPage.refresh();

			this.createSurveyQuestionPage.clickOnQuestionType();

			this.createSurveyQuestionPage.clickOnEngagementParameter();

			this.createSurveyQuestionPage.clickOnSubParameter();

			this.createSurveyQuestionPage.clickOnAddQuestion(testDataProp.getProperty(ADD_TEXT_QUESTION));

			this.createSurveyQuestionPage.clickOnScale();

			this.createSurveyQuestionPage.clickOnRatingScale();

			this.createSurveyQuestionPage.clickOnRatingScaleLeftLabel(testDataProp.getProperty(LEFT_LABEL_TEXT));

			this.createSurveyQuestionPage.clickOnRatingScaleRightLabel(testDataProp.getProperty(RIGHT_LABEL_TEXT));

			this.createSurveyQuestionPage
					.clickOnRatingScaleMaximumValue(testDataProp.getProperty(RATING_MORE_THAN_MAX_VALUE));

			this.createSurveyQuestionPage.clickOnRatingImage();

			this.createSurveyQuestionPage.clickOnQuestionSaveButton();
			
			Assert.assertEquals(createSurveyQuestionPage.getRatingsMaximumValueLessThanOrEqualToTenMessageText(),
					expectedAssertionsProp.getProperty(RATINGS_MAXIMUM_VALUE_LESS_THAN_OR_EQUAL_TO_Ten_MESSAGE));


		} catch (Exception e) {
			Assert.fail(
					"Exception occured while testing verifyCreateSurveyQuestionDetailsByGivingRatingScaleMorethanMaximum : "
							+ e.getMessage());
			logger.error(
					"Error occured while verifyCreateSurveyQuestionDetailsByGivingRatingScaleMorethanMaximum " + e);
		}

		logger.info("Starting of verifyCreateSurveyQuestionDetailsByGivingRatingScaleMorethanMaximum method");
	}

	@Test(priority = 15, description = "Verify Opinion Scale Type functionality with more than minimum & maximum values")
	@Description("Test Case #15, Verify Opinion Scale Type functionality with more than minimum & maximum values")
	@Severity(SeverityLevel.NORMAL)
	@Story("Test Case #15. Verify Opinion Scale Type functionality with more than minimum & maximum values")
	public void verifyCreateSurveyQuestionDetailsByGivingOpenionScaleValuesMorethanMaximum() {
		logger.info("Starting of verifyCreateSurveyQuestionDetailsByGivingratingScaleMorethanMaximum method");

		try {

			this.createSurveyQuestionPage.refresh();

			this.createSurveyQuestionPage.clickOnQuestionType();

			this.createSurveyQuestionPage.clickOnEngagementParameter();

			this.createSurveyQuestionPage.clickOnSubParameter();

			this.createSurveyQuestionPage.clickOnScale();

			this.createSurveyQuestionPage.clickOnOpinionScale();

			this.createSurveyQuestionPage
					.clickOnOpinionScaleMinValue(testDataProp.getProperty(OPINION_SCALE_MIN_VALUE_TWO));

			this.createSurveyQuestionPage
					.clickOnOpinionScaleMaxValue(testDataProp.getProperty(OPINIONSCALE_MAX_VALUE_TWO));

			this.createSurveyQuestionPage.clickOnAddQuestion(testDataProp.getProperty(ADD_TEXT_QUESTION));

			this.createSurveyQuestionPage.clickOnQuestionSaveButton();
			
			Assert.assertEquals(createSurveyQuestionPage.getOpinionScaleValueBetweenFiveAndTenTextMessage(),
					expectedAssertionsProp.getProperty(OPINION_SCALE_VALUE_BETWEEN_FIVE_AND_TEN_MESSAGE));


		} catch (Exception e) {
			Assert.fail(
					"Exception occured while testing verifyCreateSurveyQuestionDetailsByGivingOpenionScaleValuesMorethanMaximum : "
							+ e.getMessage());
			logger.error(
					"Error occured while verifyCreateSurveyQuestionDetailsByGivingOpenionScaleValuesMorethanMaximum "
							+ e);
		}

		logger.info("Starting of verifyCreateSurveyQuestionDetailsByGivingOpenionScaleValuesMorethanMaximum method");
	}

	@Test(priority = 16, description = "Verify Opinion Scale Type functionality with more than minimum & Less maximum values")
	@Description("Test Case #16, Verify Opinion Scale Type functionality with more than minimum & Less maximum values")
	@Severity(SeverityLevel.NORMAL)
	@Story("Test Case #16. Verify Opinion Scale Type functionality with more than minimum & Less maximum values")
	public void verifyCreateSurveyQuestionDetailsByGivingOpenionScaleValuesMorethanMinimumAndLessThanMaximum() {
		logger.info(
				"Starting of verifyCreateSurveyQuestionDetailsByGivingOpenionScaleValuesMorethanMinimumAndLessThanMaximum method");

		try {

			this.createSurveyQuestionPage.refresh();

			this.createSurveyQuestionPage.clickOnQuestionType();

			this.createSurveyQuestionPage.clickOnEmployOnBoard();

			this.createSurveyQuestionPage.clickOnSubParameter();

			this.createSurveyQuestionPage.clickOnScale();

			this.createSurveyQuestionPage.clickOnOpinionScale();

			this.createSurveyQuestionPage.clickOnOpinionScaleMinValue(testDataProp.getProperty(OPINION_SCALE_MIN_VALUE_TWO));

			this.createSurveyQuestionPage.clickOnOpinionScaleMaxValue(testDataProp.getProperty(SCALE_MIN_VALUE));

			this.createSurveyQuestionPage.clickOnAddQuestion(testDataProp.getProperty(ADD_TEXT_QUESTION));

			this.createSurveyQuestionPage.clickOnQuestionSaveButton();
			
			Assert.assertEquals(createSurveyQuestionPage.getOpinionScaleValueBetweenFiveAndTenTextMessage(),
					expectedAssertionsProp.getProperty(OPINION_SCALE_VALUE_BETWEEN_FIVE_AND_TEN_MESSAGE));


		} catch (Exception e) {
			Assert.fail(
					"Exception occured while testing verifyCreateSurveyQuestionDetailsByGivingOpenionScaleValuesMorethanMinimumAndLessThanMaximum : "
							+ e.getMessage());
			logger.error(
					"Error occured while verifyCreateSurveyQuestionDetailsByGivingOpenionScaleValuesMorethanMinimumAndLessThanMaximum "
							+ e);
		}

		logger.info(
				"Starting of verifyCreateSurveyQuestionDetailsByGivingOpenionScaleValuesMorethanMinimumAndLessThanMaximum method");
	}
	
	//@Test(priority = 17, description = "Verify Opinion Scale Type functionality by Entering the minimum value and leaving the maximum value field blank")
	@Description("Test Case #17, Verify Opinion Scale Type functionality by Entering the minimum value and leaving the maximum value  field blank")
	@Severity(SeverityLevel.NORMAL)
	@Story("Test Case #17. Verify Opinion Scale Type functionality by Entering the minimum value and leaving the maximum value  field blank")
	public void verifyCreateSurveyQuestionDetailsByGivingOpenionScaleMinimumValuesAndLeavingMaxValue() {
		logger.info(
				"Starting of verifyCreateSurveyQuestionDetailsByGivingOpenionScaleMinimumValuesAndLeavingMaxValue method");

		try {

			this.createSurveyQuestionPage.refresh();

			this.createSurveyQuestionPage.clickOnQuestionType();

			this.createSurveyQuestionPage.clickOnEmployOnBoard();

			this.createSurveyQuestionPage.clickOnSubParameter();

			this.createSurveyQuestionPage.clickOnScale();

			this.createSurveyQuestionPage.clickOnOpinionScale();

			this.createSurveyQuestionPage.clickOnOpinionScaleMinValue(testDataProp.getProperty(SCALE_MIN_VALUE));

			this.createSurveyQuestionPage.clickOnAddQuestion(testDataProp.getProperty(ADD_TEXT_QUESTION));

			this.createSurveyQuestionPage.clickOnQuestionSaveButton();
			
//       	Assert.assertEquals(createSurveyQuestionPage.getError(),
//					expectedAssertionsProp.getProperty(ERROR));

		} catch (Exception e) {
			Assert.fail(
					"Exception occured while testing verifyCreateSurveyQuestionDetailsByGivingOpenionScaleMinimumValuesAndLeavingMaxValue : "
							+ e.getMessage());
			logger.error(
					"Error occured while verifyCreateSurveyQuestionDetailsByGivingOpenionScaleMinimumValuesAndLeavingMaxValue "
							+ e);
		}

		logger.info(
				"Starting of verifyCreateSurveyQuestionDetailsByGivingOpenionScaleMinimumValuesAndLeavingMaxValue method");
	}

	//@Test(priority = 18, description = "Verify Opinion Scale Type functionality by  leaving the minimum & maximum value  field blanks in the question tab")
	@Description("Test Case #18, Verify Opinion Scale Type functionality by  leaving the minimum & maximum value  field blanks in the question tab")
	@Severity(SeverityLevel.NORMAL)
	@Story("Test Case #18. Verify Opinion Scale Type functionality by  leaving the minimum & maximum value  field blanks in the question tab")
	public void verifyCreateSurveyQuestionDetailsByLeavingOpenionScaleMinimumAndMaximumValuesBlank() {
		logger.info(
				"Starting of verifyCreateSurveyQuestionDetailsByLeavingOpenionScaleMinimumAndMaximumValuesBlank method");

		try {

			this.createSurveyQuestionPage.refresh();

			this.createSurveyQuestionPage.clickOnQuestionType();

			this.createSurveyQuestionPage.clickOnEngagementParameterDropDown();

			this.createSurveyQuestionPage.clickOnSubParameter();

			this.createSurveyQuestionPage.clickOnScale();

			this.createSurveyQuestionPage.clickOnOpinionScale();

			// this.createSurveyQuestionPage.clickOnIsOptional();
			// this.createSurveyQuestionPage.clickOnAllowComments();
			// this.createSurveyQuestionPage.clickOnCommentOptions();

			this.createSurveyQuestionPage.clickOnQuestionSaveButton();
			
//			Assert.assertEquals(createSurveyQuestionPage.getError(),
//					expectedAssertionsProp.getProperty(ERROR));


		} catch (Exception e) {
			Assert.fail(
					"Exception occured while testing verifyCreateSurveyQuestionDetailsByLeavingOpenionScaleMinimumAndMaximumValuesBlank : "
							+ e.getMessage());
			logger.error(
					"Error occured while verifyCreateSurveyQuestionDetailsByLeavingOpenionScaleMinimumAndMaximumValuesBlank "
							+ e);
		}

		logger.info(
				"Starting of verifyCreateSurveyQuestionDetailsByLeavingOpenionScaleMinimumAndMaximumValuesBlank method");
	}

	@Test(priority = 19, description = "Verify Opinion scale type functionality by Entering Text in minimum & maximum fields")
	@Description(" Test Case #19, Verify Opinion scale type functionality by Entering Text in minimum & maximum fields")
	@Severity(SeverityLevel.NORMAL)
	@Story("Test Case #19. VeVerify Opinion scale type functionality by Entering Text in minimum & maximum fields")
	public void verifyCreateSurveyQuestionDetailsByGivingOpenionScaleMinimumAndMaximumValues() {
		logger.info("Starting of verifyCreateSurveyQuestionDetailsByGivingOpenionScaleMinimumAndMaximumValues method");

		try {

			this.createSurveyQuestionPage.refresh();

			this.createSurveyQuestionPage.clickOnQuestionType();

			this.createSurveyQuestionPage.clickOnEmployOnBoard();

			this.createSurveyQuestionPage.clickOnSubParameter();

			this.createSurveyQuestionPage.clickOnScale();

			this.createSurveyQuestionPage.clickOnOpinionScale();

			this.createSurveyQuestionPage.clickOnOpinionScaleMinValue(testDataProp.getProperty(SCALE_MIN_VALUE_TEXT));

			this.createSurveyQuestionPage.clickOnOpinionScaleMaxValue(testDataProp.getProperty(SCALE_MAX_VALUE_TEXT));

			this.createSurveyQuestionPage.clickOnAddQuestion(testDataProp.getProperty(ADD_TEXT_QUESTION));

			this.createSurveyQuestionPage.clickOnQuestionSaveButton();
			
			Assert.assertEquals(createSurveyQuestionPage.getOpinionScaleValueBetweenFiveAndTenTextMessage(),
					expectedAssertionsProp.getProperty(OPINION_SCALE_VALUE_BETWEEN_FIVE_AND_TEN_MESSAGE));


		} catch (Exception e) {
			Assert.fail(
					"Exception occured while testing verifyCreateSurveyQuestionDetailsByGivingOpenionScaleMinimumAndMaximumValues : "
							+ e.getMessage());
			logger.error(
					"Error occured while verifyCreateSurveyQuestionDetailsByGivingOpenionScaleMinimumAndMaximumValues "
							+ e);
		}

		logger.info("Starting of verifyCreateSurveyQuestionDetailsByGivingOpenionScaleMinimumAndMaximumValues method");
	}

	@Test(priority = 20, description = "Verify net promoter scale type functionality by leaving minimum & maximum value fields blank in question tab")
	@Description("Test Case #20, Verify net promoter scale type functionality by leaving minimum & maximum value fields blank in question tab")
	@Severity(SeverityLevel.NORMAL)
	@Story("Test Case #20. Verify net promoter scale type functionality by leaving minimum & maximum value fields blank in question tab")
	public void verifyCreateSurveyQuestionDetailsByLeavingPromoterScaleMinimumAndMaximumValuesBlank() {
		logger.info(
				"Starting of verifyCreateSurveyQuestionDetailsByLeavingPromoterScaleMinimumAndMaximumValuesBlank method");

		try {

			this.createSurveyQuestionPage.refresh();

			this.createSurveyQuestionPage.clickOnQuestionType();

			this.createSurveyQuestionPage.clickOnEngagementParameterDropDown();

			this.createSurveyQuestionPage.clickOnSubParameter();

			this.createSurveyQuestionPage.clickOnScale();

			this.createSurveyQuestionPage.clickOnNetPromotorScore();

			this.createSurveyQuestionPage.clickOnAddQuestion(testDataProp.getProperty(ADD_TEXT_QUESTION));

			this.createSurveyQuestionPage.clickOnQuestionSaveButton();
			
			Assert.assertEquals(createSurveyQuestionPage.getNetPromoterMiniumValueReqiredTextMessage(),
					expectedAssertionsProp.getProperty(NET_PROMOTER_MINIMUM_VALUE_REQUIRED_MESSAGE));


		} catch (Exception e) {
			Assert.fail(
					"Exception occured while testing verifyCreateSurveyQuestionDetailsByLeavingPromoterScaleMinimumAndMaximumValuesBlank : "
							+ e.getMessage());
			logger.error(
					"Error occured while verifyCreateSurveyQuestionDetailsByLeavingPromoterScaleMinimumAndMaximumValuesBlank "
							+ e);
		}

		logger.info(
				"Starting of verifyCreateSurveyQuestionDetailsByLeavingPromoterScaleMinimumAndMaximumValuesBlank method");
	}


	@Test(priority = 21, description = "Verify net promote scale type functionality by entering minimum value and leaving maximum value field blank")
	@Description("Test Case #21, Verify net promote scale type functionality by entering minimum value and leaving maximum value field blank")
	@Severity(SeverityLevel.NORMAL)
	@Story("Test Case #21. Verify net promote scale type functionality by entering minimum value and leaving maximum value field blank")
	public void verifyCreateSurveyQuestionDetailsByGivingOnlyPromoterScaleMinimumValue() {
		logger.info("Starting of verifyCreateSurveyQuestionDetailsByGivingOnlyPromoterScaleMinimumValue method");

		try {

			this.createSurveyQuestionPage.refresh();

			this.createSurveyQuestionPage.clickOnQuestionType();

			this.createSurveyQuestionPage.clickOnEngagementParameterDropDown();

			this.createSurveyQuestionPage.clickOnSubParameter();

			this.createSurveyQuestionPage.clickOnScale();

			this.createSurveyQuestionPage.clickOnNetPromotorScore();

			this.createSurveyQuestionPage.clickOnOpinionScaleMinValue(testDataProp.getProperty(SCALE_MIN_VALUE));

			this.createSurveyQuestionPage.clickOnAddQuestion(testDataProp.getProperty(ADD_TEXT_QUESTION));

			this.createSurveyQuestionPage.clickOnQuestionSaveButton();
			
			Assert.assertEquals(createSurveyQuestionPage.getNetPromoterMaximumValueReqiredTextMessage(),
					expectedAssertionsProp.getProperty(NET_PROMOTER_MAXIMUM_VALUE_REQUIRED_MESSAGE));

		} catch (Exception e) {
			Assert.fail(
					"Exception occured while testing verifyCreateSurveyQuestionDetailsByGivingOnlyPromoterScaleMinimumValue : "
							+ e.getMessage());
			logger.error(
					"Error occured while verifyCreateSurveyQuestionDetailsByGivingOnlyPromoterScaleMinimumValue " + e);
		}

		logger.info("Starting of verifyCreateSurveyQuestionDetailsByGivingOnlyPromoterScaleMinimumValue method");
	}

	@Test(priority = 22, description = "Verify net promote score type functionality by entering maximum value and leaving minimum value field blank in question tab")
	@Description("Test Case #22, Verify net promote scale type functionality by entering maximum value and leaving minimum value field blank in question tab")
	@Severity(SeverityLevel.NORMAL)
	@Story("Test Case #22. Verify net promote scale type functionality by entering maximum value and leaving minimum value field blank in question tab")
	public void verifyCreateSurveyQuestionDetailsByGivingOnlyPromoterScaleMaximumValue() {
		logger.info("Starting of verifyCreateSurveyQuestionDetailsByGivingOnlyPromoterScaleMaximumValue method");

		try {

			this.createSurveyQuestionPage.refresh();

			this.createSurveyQuestionPage.clickOnQuestionType();

			this.createSurveyQuestionPage.clickOnEngagementParameterDropDown();

			this.createSurveyQuestionPage.clickOnSubParameter();

			this.createSurveyQuestionPage.clickOnScale();

			this.createSurveyQuestionPage.clickOnNetPromotorScore();

			this.createSurveyQuestionPage.clickOnOpinionScaleMaxValue(testDataProp.getProperty(SCALE_MAX_VALUE));

			this.createSurveyQuestionPage.clickOnAddQuestion(testDataProp.getProperty(ADD_TEXT_QUESTION));
			
			this.createSurveyQuestionPage.clickOnQuestionSaveButton();
			
			Assert.assertEquals(createSurveyQuestionPage.getNetPromoterMinimumValueReqiredTextMessage(),
					expectedAssertionsProp.getProperty(NET_PROMOTER_MINIMUM_VALUE_REQUIRED_MESSAGE));

		} catch (Exception e) {
			Assert.fail(
					"Exception occured while testing verifyCreateSurveyQuestionDetailsByGivingOnlyPromoterScaleMaximumValue : "
							+ e.getMessage());
			logger.error(
					"Error occured while verifyCreateSurveyQuestionDetailsByGivingOnlyPromoterScaleMaximumValue " + e);
		}

		logger.info("Starting of verifyCreateSurveyQuestionDetailsByGivingOnlyPromoterScaleMaximumValue method");
	}

	@Test(priority = 23, description = "Verify net promote scale type functionality with more than the range value of minimum & maximum fields in question tab")
	@Description("Test Case #23, Verify net promote scale type functionality with more than the range value of minimum & maximum fields in question tab")
	@Severity(SeverityLevel.NORMAL)
	@Story("Test Case #23. Verify net promote scale type functionality with more than the range value of minimum & maximum fields in question tab")
	public void verifyCreateSurveyQuestionDetailsByGivingMoreThanPromoterScaleMinimumAndMaximumValues() {
		logger.info(
				"Starting of verifyCreateSurveyQuestionDetailsByGivingMoreThanPromoterScaleMinimumAndMaximumValues method");

		try {

			this.createSurveyQuestionPage.refresh();

			this.createSurveyQuestionPage.clickOnQuestionType();

			this.createSurveyQuestionPage.clickOnEmployOnBoard();

			this.createSurveyQuestionPage.clickOnSubParameter();

			this.createSurveyQuestionPage.clickOnScale();

			this.createSurveyQuestionPage.clickOnNetPromotorScore();

			this.createSurveyQuestionPage.clickOnOpinionScaleMinValue(testDataProp.getProperty(OPINION_SCALE_MIN_VALUE_TWO));

			this.createSurveyQuestionPage.clickOnOpinionScaleMaxValue(testDataProp.getProperty(OPINIONSCALE_MAX_VALUE_TWO));

			this.createSurveyQuestionPage.clickOnAddQuestion(testDataProp.getProperty(ADD_TEXT_QUESTION));

			this.createSurveyQuestionPage.clickOnQuestionSaveButton();
			
			Assert.assertEquals(createSurveyQuestionPage.getNetPromoterScaleValueBetweenFiveAndTenTextMessage(),
					expectedAssertionsProp.getProperty(NET_PROMOTER_SCALE_VALUE_BETWEEN_FIVE_AND_TEN_MESSAGE));

		} catch (Exception e) {
			Assert.fail(
					"Exception occured while testing verifyCreateSurveyQuestionDetailsByGivingMoreThanPromoterScaleMinimumAndMaximumValues : "
							+ e.getMessage());
			logger.error(
					"Error occured while verifyCreateSurveyQuestionDetailsByGivingMoreThanPromoterScaleMinimumAndMaximumValues "
							+ e);
		}

		logger.info(
				"Starting of verifyCreateSurveyQuestionDetailsByGivingMoreThanPromoterScaleMinimumAndMaximumValues method");
	}

	@Test(priority = 24, description = "Verify net promote scale type functionality by Entering the minimum value more than the maximum value range & maximum value less than the minimum range")
	@Description("Test Case #24, Verify net promote scale type functionality by Entering the minimum value more than the maximum value range & maximum value less than the minimum range")
	@Severity(SeverityLevel.NORMAL)
	@Story("Test Case #24. Verify net promote scale type functionality by Entering the minimum value more than the maximum value range & maximum value less than the minimum range")
	public void verifyCreateSurveyQuestionDetailsByGivingMoreThanPromoterScaleMinimumAndMinimumvalusForMaximumRangeValues() {
		logger.info(
				"Starting of verifyCreateSurveyQuestionDetailsByGivingMoreThanPromoterScaleMinimumAndMinimumvalusForMaximumRangeValues method");

		try {

			this.createSurveyQuestionPage.refresh();

			this.createSurveyQuestionPage.clickOnQuestionType();

			this.createSurveyQuestionPage.clickOnEmployOnBoard();

			this.createSurveyQuestionPage.clickOnSubParameter();

			this.createSurveyQuestionPage.clickOnScale();

			this.createSurveyQuestionPage.clickOnNetPromotorScore();

			this.createSurveyQuestionPage
					.clickOnOpinionScaleMinValue(testDataProp.getProperty(OPINION_SCALE_MIN_VALUE_TWO));

			this.createSurveyQuestionPage.clickOnOpinionScaleMaxValue(testDataProp.getProperty(SCALE_MIN_VALUE));

			this.createSurveyQuestionPage.clickOnAddQuestion(testDataProp.getProperty(ADD_TEXT_QUESTION));

			this.createSurveyQuestionPage.clickOnQuestionSaveButton();
			
			Assert.assertEquals(createSurveyQuestionPage.getNetPromoterMinValueMoreThanMaxAndMaxLessThanMinTextMessage(),
					expectedAssertionsProp.getProperty(NET_PROMOTER_MIN_VALUE_MORE_THAN_MAX_AND_MAX_LESS_THAN_MIN_MESSAGE));

		} catch (Exception e) {
			Assert.fail(
					"Exception occured while testing verifyCreateSurveyQuestionDetailsByGivingMoreThanPromoterScaleMinimumAndMinimumvalusForMaximumRangeValues : "
							+ e.getMessage());
			logger.error(
					"Error occured while verifyCreateSurveyQuestionDetailsByGivingMoreThanPromoterScaleMinimumAndMinimumvalusForMaximumRangeValues "
							+ e);
		}

		logger.info(
				"Starting of verifyCreateSurveyQuestionDetailsByGivingMoreThanPromoterScaleMinimumAndMinimumvalusForMaximumRangeValues method");
	}

	@Test(priority = 25, description = "Verify net promote scale type functionality by Entering Text  in minimum & maximum fields ")
	@Description("Test Case #25, Verify net promote scale type functionality by Entering Text  in minimum & maximum fields ")
	@Severity(SeverityLevel.NORMAL)
	@Story("Test Case #25. Verify net promote scale type functionality by Entering Text  in minimum & maximum fields ")
	public void verifyCreateSurveyQuestionDetailsByGivingTextWithPromoteScaleMinimumAndMaximumvalus() {
		logger.info(
				"Starting of verifyCreateSurveyQuestionDetailsByGivingTextWithPromoteScaleMinimumAndMaximumvalus method");

		try {

			this.createSurveyQuestionPage.refresh();

			this.createSurveyQuestionPage.clickOnQuestionType();

			this.createSurveyQuestionPage.clickOnEmployOnBoard();

			this.createSurveyQuestionPage.clickOnSubParameter();

			this.createSurveyQuestionPage.clickOnScale();

			this.createSurveyQuestionPage.clickOnNetPromotorScore();

			this.createSurveyQuestionPage.clickOnOpinionScaleMinValue(testDataProp.getProperty(SCALE_MIN_VALUE_TEXT));

			this.createSurveyQuestionPage.clickOnOpinionScaleMaxValue(testDataProp.getProperty(SCALE_MAX_VALUE_TEXT));

			this.createSurveyQuestionPage.clickOnAddQuestion(testDataProp.getProperty(ADD_TEXT_QUESTION));

			this.createSurveyQuestionPage.clickOnQuestionSaveButton();
			
			Assert.assertEquals(createSurveyQuestionPage.getNetPromoterScaleValueBetweenFiveAndTenTextMessage(),
					expectedAssertionsProp.getProperty(NET_PROMOTER_MIN_VALUE_MORE_THAN_MAX_AND_MAX_LESS_THAN_MIN_MESSAGE));

		} catch (Exception e) {
			Assert.fail(
					"Exception occured while testing verifyCreateSurveyQuestionDetailsByGivingTextWithPromoteScaleMinimumAndMaximumvalus : "
							+ e.getMessage());
			logger.error(
					"Error occured while verifyCreateSurveyQuestionDetailsByGivingTextWithPromoteScaleMinimumAndMaximumvalus "
							+ e);
		}

		logger.info(
				"Starting of verifyCreateSurveyQuestionDetailsByGivingTextWithPromoteScaleMinimumAndMaximumvalus method");
	}

	
	@Test(priority = 26, description = "Verify net promoter scale type functionality by entering a large number in the minimum & maximum fields")
	@Description("Test Case #26, Verify net promoter scale type functionality by entering a large number in the minimum & maximum fields")
	@Severity(SeverityLevel.NORMAL)
	@Story("Test Case #26. Verify net promoter scale type functionality by entering a large number in the minimum & maximum fields")
	public void verifyCreateSurveyQuestionDetailsByGivingPromoteScaleMinimumAndMaximumvalus() {
		logger.info("Starting of verifyCreateSurveyQuestionDetailsByGivingTextWithPromoteScaleMinimumAndMaximumvalus method");

		try {

			this.createSurveyQuestionPage.refresh();
			
			this.createSurveyQuestionPage.clickOnQuestionType();
			
			this.createSurveyQuestionPage.clickOnEmployOnBoard();
			
			this.createSurveyQuestionPage.clickOnSubParameter();
			
			this.createSurveyQuestionPage.clickOnNetPromotorScore();
			
			this.createSurveyQuestionPage.clickOnOpinionScaleMinValue(testDataProp.getProperty(PROMOTER_SCALE_MIN_VALUE));
			
			this.createSurveyQuestionPage.clickOnOpinionScaleMaxValue(testDataProp.getProperty(PROMOTER_SCALE_MAX_VALUE));
			
			this.createSurveyQuestionPage.clickOnAddQuestion(testDataProp.getProperty(ADD_TEXT_QUESTION));;
			
			this.createSurveyQuestionPage.clickOnQuestionSaveButton();
			
			
			Assert.assertEquals(createSurveyQuestionPage.getOpinionScaleValueBetweenZeroAndTenMessage(),
					expectedAssertionsProp.getProperty(OPINION_SCALE_VALUE_BETWEEN_FIVE_AND_TEN));

		} catch (Exception e) {
			Assert.fail("Exception occured while testing verifyCreateSurveyQuestionDetailsByGivingTextWithPromoteScaleMinimumAndMaximumvalus : " + e.getMessage());
			logger.error("Error occured while verifyCreateSurveyQuestionDetailsByGivingTextWithPromoteScaleMinimumAndMaximumvalus " + e);
		}

		logger.info("Starting of verifyCreateSurveyQuestionDetailsByGivingTextWithPromoteScaleMinimumAndMaximumvalus method");
	}
	
	@Test(priority = 27, description = "Verify Add Question functionality without selecting options for the created question")
	@Description("Test Case #27,  Verify Add Question functionality without selecting options for the created question")
	@Severity(SeverityLevel.NORMAL)
	@Story("Test Case #27.Verify Add Question functionality without selecting options for the created question")
	public void verifyCreateSurveyQuestionDetailsByWithoutselectingOptions() {
		logger.info("Starting of verifyCreateSurveyQuestionDetailsByWithoutselectingOptions method");

		try {

			this.createSurveyQuestionPage.refresh();
			
			this.createSurveyQuestionPage.clickOnQuestionType();
			
			this.createSurveyQuestionPage.clickOnEngagementParameterDropDown();
			
			this.createSurveyQuestionPage.clickOnSubParameter();
			
			this.createSurveyQuestionPage.clickOnAddQuestion(testDataProp.getProperty(ADD_TEXT_QUESTION));
			
			this.createSurveyQuestionPage.clickOnQuestionSaveButton();
			
			Assert.assertEquals(createSurveyQuestionPage.getQuestionAddedSuccessfullyText(),
					expectedAssertionsProp.getProperty(QUESTION_ADDED_SUCCESSFULLY_TEXT));

		} catch (Exception e) {
			Assert.fail("Exception occured while testing verifyCreateSurveyQuestionDetailsByWithoutselectingOptions : " + e.getMessage());
			logger.error("Error occured while verifyCreateSurveyQuestionDetailsByWithoutselectingOptions " + e);
		}

		logger.info("Starting of verifyCreateSurveyQuestionDetailsByWithoutselectingOptions method");
	}
	
	@Test(priority = 28, description = "Verify question tab functionality by adding text questions by selecting the image option & without uploading an image")
	@Description("Test Case #28,  Verify question tab functionality by adding text questions by selecting the image option & without uploading an image")
	@Severity(SeverityLevel.NORMAL)
	@Story("Test Case #28, Verify question tab functionality by adding text questions by selecting the image option & without uploading an image")
	public void verifyCreateSurveyQuestionDetailsByWithoutselectingImageAsOption() {
		logger.info("Starting of verifyCreateSurveyQuestionDetailsByWithoutselectingImageAsOption method");

		try {

			this.createSurveyQuestionPage.refresh();
			
			this.createSurveyQuestionPage.clickOnQuestionType();
			
			this.createSurveyQuestionPage.clickOnEngagementParameterDropDown();
			
			this.createSurveyQuestionPage.clickOnSubParameter();
			
			this.createSurveyQuestionPage.clickOnScale();
			
			this.createSurveyQuestionPage.clickOnLikertScaleAgrementOption();
			
			this.createSurveyQuestionPage.clickOnAddQuestion(testDataProp.getProperty(ADD_TEXT_QUESTION));
			
			this.createSurveyQuestionPage.clickOnImageChoiceQuestionButton();

			this.createSurveyQuestionPage.clickOnQuestionSaveButton();
			
			Assert.assertEquals(createSurveyQuestionPage.getQuestionAddedSuccessfullyText(),
					expectedAssertionsProp.getProperty(QUESTION_ADDED_SUCCESSFULLY_TEXT));

		} catch (Exception e) {
			Assert.fail("Exception occured while testing verifyCreateSurveyQuestionDetailsByWithoutselectingImageAsOption : " + e.getMessage());
			logger.error("Error occured while verifyCreateSurveyQuestionDetailsByWithoutselectingImageAsOption " + e);
		}

		logger.info("Starting of verifyCreateSurveyQuestionDetailsByWithoutselectingImageAsOption method");
	}
	
	@Test(priority = 29, description = "Verify question tab functionality by adding text questions & selecting and uploading image options")
	@Description("Test Case #29,  Verify question tab functionality by adding text questions & selecting and uploading image options")
	@Severity(SeverityLevel.NORMAL)
	@Story("Test Case #29, Verify question tab functionality by adding text questions & selecting and uploading image options")
	public void verifyCreateSurveyQuestionDetailsBySelectingImageAsOption() {
		logger.info("Starting of verifyCreateSurveyQuestionDetailsByWithoutselectingImageAsOption method");

		try {

			this.createSurveyQuestionPage.refresh();
			
			this.createSurveyQuestionPage.clickOnQuestionType();
			
			this.createSurveyQuestionPage.clickOnEngagementParameterDropDown();
			
			this.createSurveyQuestionPage.clickOnSubParameter();
			
			this.createSurveyQuestionPage.clickOnScale();
			
			this.createSurveyQuestionPage.clickOnNewLikertScale();
			
			this.createSurveyQuestionPage.clickOnAddQuestion(testDataProp.getProperty(ADD_TEXT_QUESTION));

			this.createSurveyQuestionPage.clickOnImageChoiceQuestionButton();

			this.createSurveyQuestionPage.setImageChoiceOptions(testDataProp.getProperty(ADD_IMAGE_CHOICE_FILE));
			
			this.createSurveyQuestionPage.clickOnQuestionSaveButton();
			
			Assert.assertEquals(createSurveyQuestionPage.getQuestionAddedSuccessfullyText(),
					expectedAssertionsProp.getProperty(QUESTION_ADDED_SUCCESSFULLY_TEXT));

		} catch (Exception e) {
			Assert.fail("Exception occured while testing verifyCreateSurveyQuestionDetailsByWithoutselectingImageAsOption : " + e.getMessage());
			logger.error("Error occured while verifyCreateSurveyQuestionDetailsByWithoutselectingImageAsOption " + e);
		}

		logger.info("Starting of verifyCreateSurveyQuestionDetailsByWithoutselectingImageAsOption method");
	}
	
	@Test(priority = 30, description = "Verify question tab functionality by adding text questions by selecting the Audio option & without uploading an Audio file")
	@Description("Test Case #30,  Verify question tab functionality by adding text questions by selecting the Audio option & without uploading an Audio file")
	@Severity(SeverityLevel.NORMAL)
	@Story("Test Case #30, Verify question tab functionality by adding text questions by selecting the Audio option & without uploading an Audio file")
	public void verifyCreateSurveyQuestionDetailsBySelectingAudioAsOption() {
		logger.info("Starting of verifyCreateSurveyQuestionDetailsBySelectingAudioAsOption method");

		try {

			this.createSurveyQuestionPage.refresh();
			
			this.createSurveyQuestionPage.clickOnQuestionType();
			
			this.createSurveyQuestionPage.clickOnEngagementParameterDropDown();
			
			this.createSurveyQuestionPage.clickOnSubParameter();
			
			this.createSurveyQuestionPage.clickOnScale();
			
			this.createSurveyQuestionPage.clickOnNewLikertScale();
			
			this.createSurveyQuestionPage.clickOnAddQuestion(testDataProp.getProperty(ADD_TEXT_QUESTION));
			
			this.createSurveyQuestionPage.clickOnAddAudioChoiceQuestionsButton();
			
			this.createSurveyQuestionPage.clickOnQuestionSaveButton();
			
			Assert.assertEquals(createSurveyQuestionPage.getQuestionAddedSuccessfullyText(),
					expectedAssertionsProp.getProperty(QUESTION_ADDED_SUCCESSFULLY_TEXT));

		} catch (Exception e) {
			Assert.fail("Exception occured while testing verifyCreateSurveyQuestionDetailsBySelectingAudioAsOption : " + e.getMessage());
			logger.error("Error occured while verifyCreateSurveyQuestionDetailsBySelectingAudioAsOption " + e);
		}

		logger.info("Starting of verifyCreateSurveyQuestionDetailsBySelectingAudioAsOption method");
	}
	
	@Test(priority = 31, description = "verify question tab functionality by adding Text questions & selecting and uploading Audio file options")
	@Description("Test Case #31,  verify question tab functionality by adding questions & selecting and uploading Audio file options")
	@Severity(SeverityLevel.NORMAL)
	@Story("Test Case #31, verify question tab functionality by adding questions & selecting and uploading Audio file options")
	public void verifyCreateSurveyQuestionDetailsByUploadAudioAsOption() {
		logger.info("Starting of verifyCreateSurveyQuestionDetailsByUploadAudioAsOption method");

		try {

			this.createSurveyQuestionPage.refresh();

			this.createSurveyQuestionPage.clickOnQuestionType();

			this.createSurveyQuestionPage.clickOnEngagementParameterDropDown();

			this.createSurveyQuestionPage.clickOnSubParameter();

			this.createSurveyQuestionPage.clickOnScale();

			this.createSurveyQuestionPage.clickOnLikertScaleEngagement();

			this.createSurveyQuestionPage.clickOnAddQuestion(testDataProp.getProperty(ADD_TEXT_QUESTION));

			this.createSurveyQuestionPage.clickOnAddAudioChoiceQuestionsButton();
			
			this.createSurveyQuestionPage.setAudioChoiceOptions(testDataProp.getProperty(ADD_AUDIO_CHOICE_FILE));
			
			this.createSurveyQuestionPage.clickOnQuestionSaveButton();
			
			Assert.assertEquals(createSurveyQuestionPage.getQuestionAddedSuccessfullyText(),
					expectedAssertionsProp.getProperty(QUESTION_ADDED_SUCCESSFULLY_TEXT));

		} catch (Exception e) {
			Assert.fail("Exception occured while testing verifyCreateSurveyQuestionDetailsByUploadAudioAsOption : " + e.getMessage());
			logger.error("Error occured while verifyCreateSurveyQuestionDetailsByUploadAudioAsOption " + e);
		}

		logger.info("Starting of verifyCreateSurveyQuestionDetailsByUploadAudioAsOption method");
	}
	
	@Test(priority = 32, description = "Verify question tab functionality by adding text questions by selecting the Video option & without uploading a Video file")
	@Description("Test Case #32,  Verify question tab functionality by adding text questions by selecting the Video option & without uploading a Video file")
	@Severity(SeverityLevel.NORMAL)
	@Story("Test Case #32, Verify question tab functionality by adding text questions by selecting the Video option & without uploading a Video file")
	public void verifyCreateSurveyQuestionDetailsBySelectingVideoAsOptionWithoutUploadVideoFile() {
		logger.info("Starting of verifyCreateSurveyQuestionDetailsBySelectingVideoAsOptionWithoutUploadVideoFile method");

		try {

			this.createSurveyQuestionPage.refresh();
			
			this.createSurveyQuestionPage.clickOnQuestionType();
			
			this.createSurveyQuestionPage.clickOnEngagementParameterDropDown();
			
			this.createSurveyQuestionPage.clickOnSubParameter();
			
			this.createSurveyQuestionPage.clickOnScale();
			
			this.createSurveyQuestionPage.clickOnLikertScaleEngagement();
			
			this.createSurveyQuestionPage.clickOnAddQuestion(testDataProp.getProperty(ADD_TEXT_QUESTION));
			
			this.createSurveyQuestionPage.clickOnAddVideoChoiceQuestionsButton();
			
			this.createSurveyQuestionPage.clickOnQuestionSaveButton();
			
			Assert.assertEquals(createSurveyQuestionPage.getQuestionAddedSuccessfullyText(),
					expectedAssertionsProp.getProperty(QUESTION_ADDED_SUCCESSFULLY_TEXT));

		} catch (Exception e) {
			Assert.fail("Exception occured while testing verifyCreateSurveyQuestionDetailsBySelectingVideoAsOptionWithoutUploadVideoFile : " + e.getMessage());
			logger.error("Error occured while verifyCreateSurveyQuestionDetailsBySelectingVideoAsOptionWithoutUploadVideoFile " + e);
		}

		logger.info("Starting of verifyCreateSurveyQuestionDetailsBySelectingVideoAsOptionWithoutUploadVideoFile method");
	}
	
	@Test(priority = 33, description = "Verify question tab functionality by adding text questions by selecting the Video option & uploading a Video file")
	@Description("Test Case #33,  Verify question tab functionality by adding text questions by selecting the Video option & uploading a Video file")
	@Severity(SeverityLevel.NORMAL)
	@Story("Test Case #33, Verify question tab functionality by adding text questions by selecting the Video option & uploading a Video file")
	public void verifyCreateSurveyQuestionDetailsBySelectingTextQuestionAndUploadVideoAsOption() {
		logger.info("Starting of verifyCreateSurveyQuestionDetailsBySelectingTextQuestionAndUploadVideoAsOption method");

		try {

			this.createSurveyQuestionPage.refresh();
			
			this.createSurveyQuestionPage.clickOnQuestionType();
			
			this.createSurveyQuestionPage.clickOnEngagementParameterDropDown();
			
			this.createSurveyQuestionPage.clickOnSubParameter();
			
			this.createSurveyQuestionPage.clickOnScale();
			
			this.createSurveyQuestionPage.clickOnLikertScaleEngagement();
			
			this.createSurveyQuestionPage.clickOnAddQuestion(testDataProp.getProperty(ADD_TEXT_QUESTION));
			
			this.createSurveyQuestionPage.clickOnAddVideoChoiceQuestionsButton();
			
			this.createSurveyQuestionPage.setVideoChoiceOptions(testDataProp.getProperty(ADD_VIDEO_CHOICE_FILE));

			this.createSurveyQuestionPage.clickOnQuestionSaveButton();
			
			Assert.assertEquals(createSurveyQuestionPage.getQuestionAddedSuccessfullyText(),
					expectedAssertionsProp.getProperty(QUESTION_ADDED_SUCCESSFULLY_TEXT));

		} catch (Exception e) {
			Assert.fail("Exception occured while testing verifyCreateSurveyQuestionDetailsBySelectingTextQuestionAndUploadVideoAsOption : " + e.getMessage());
			logger.error("Error occured while verifyCreateSurveyQuestionDetailsBySelectingTextQuestionAndUploadVideoAsOption " + e);
		}

		logger.info("Starting of verifyCreateSurveyQuestionDetailsBySelectingTextQuestionAndUploadVideoAsOption method");
	}
	
	@Test(priority = 34, description = "Verify question tab functionality by adding questions & selecting and uploading the Video  file option")
	@Description("Test Case #34, Verify question tab functionality by adding questions & selecting and uploading the Video  file option")
	@Severity(SeverityLevel.NORMAL)
	@Story("Test Case #34, Verify question tab functionality by adding questions & selecting and uploading the Video  file option")
	public void verifyCreateSurveyQuestionDetailsByUploadingVideoAsOption() {
		logger.info("Starting of verifyCreateSurveyQuestionDetailsByUploadingVideoAsOption method");

		try {

			this.createSurveyQuestionPage.refresh();
			
			this.createSurveyQuestionPage.clickOnQuestionType();
			
			this.createSurveyQuestionPage.clickOnEngagementParameterDropDown();
			
			this.createSurveyQuestionPage.clickOnSubParameter();
			
			this.createSurveyQuestionPage.clickOnScale();
			
			this.createSurveyQuestionPage.clickOnLikertScaleEngagement();
			
			this.createSurveyQuestionPage.clickOnAddQuestion(testDataProp.getProperty(ADD_TEXT_QUESTION));
			
			this.createSurveyQuestionPage.clickOnAddVideoChoiceQuestionsButton();
			
			this.createSurveyQuestionPage.setVideoChoiceOptions(testDataProp.getProperty(ADD_VIDEO_CHOICE_FILE));

			this.createSurveyQuestionPage.clickOnQuestionSaveButton();
			
			Assert.assertEquals(createSurveyQuestionPage.getQuestionAddedSuccessfullyText(),
					expectedAssertionsProp.getProperty(QUESTION_ADDED_SUCCESSFULLY_TEXT));

		} catch (Exception e) {
			Assert.fail("Exception occured while testing verifyCreateSurveyQuestionDetailsBySekectingVideoAsOption : " + e.getMessage());
			logger.error("Error occured while verifyCreateSurveyQuestionDetailsBySekectingVideoAsOption " + e);
		}

		logger.info("Starting of verifyCreateSurveyQuestionDetailsBySekectingVideoAsOption method");
	}
	
	@Test(priority = 35, description = "Verify question tab functionality by uploading image question ")
	@Description("Test Case #35,  verify question tab functionality by adding questions & selecting and uploading Audio file options")
	@Severity(SeverityLevel.NORMAL)
	@Story("Test Case #35, Verify question tab functionality by adding questions & selecting and uploading the Video  file option")
	public void verifyCreateSurveyQuestionDetailsByUploadingImageoAsOption() {
		logger.info("Starting of verifyCreateSurveyQuestionDetailsByUploadingImageoAsOption method");

		try {

			this.createSurveyQuestionPage.refresh();
			
			this.createSurveyQuestionPage.clickOnQuestionType();
			
			this.createSurveyQuestionPage.clickOnEngagementParameterDropDown();
			
			this.createSurveyQuestionPage.clickOnSubParameter();
			
			this.createSurveyQuestionPage.clickOnScale();
			
			this.createSurveyQuestionPage.clickOnLikertScaleEngagement();
			
			this.createSurveyQuestionPage.clickOnAddImageQuestion(testDataProp.getProperty(ADD_IMAGE_CHOICE_FILE));
			
			this.createSurveyQuestionPage.clickOnAddImageQuestionButton();

			this.createSurveyQuestionPage.setImageChoiceOptions(testDataProp.getProperty(ADD_IMAGE_CHOICE_FILE));

			this.createSurveyQuestionPage.clickOnQuestionSaveButton();
			
			Assert.assertEquals(createSurveyQuestionPage.getQuestionAddedSuccessfullyText(),
					expectedAssertionsProp.getProperty(QUESTION_ADDED_SUCCESSFULLY_TEXT));

		} catch (Exception e) {
			Assert.fail("Exception occured while testing verifyCreateSurveyQuestionDetailsByUploadingImageoAsOption : " + e.getMessage());
			logger.error("Error occured while verifyCreateSurveyQuestionDetailsByUploadingImageoAsOption " + e);
		}

		logger.info("Starting of verifyCreateSurveyQuestionDetailsBySekectingVideoAsOption method");
	}
	
	@Test(priority = 36, description = "Verify question tab functionality by uploading the Audio question for add question field")
	@Description("Test Case #36,  verify question tab functionality by adding questions & selecting and uploading Audio file options")
	@Severity(SeverityLevel.NORMAL)
	@Story("Test Case #36, Verify question tab functionality by uploading the Audio question for add question field")
	public void verifyCreateSurveyQuestionDetailsByUploadingAudioQuestion() {
		logger.info("Starting of verifyCreateSurveyQuestionDetailsByUploadingAudioQuestion method");

		try {

			this.createSurveyQuestionPage.refresh();
			
			this.createSurveyQuestionPage.clickOnQuestionType();
			
			this.createSurveyQuestionPage.clickOnEngagementParameterDropDown();
			
			this.createSurveyQuestionPage.clickOnSubParameter();
			
			this.createSurveyQuestionPage.clickOnScale();
			
			this.createSurveyQuestionPage.clickOnLikertScaleEngagement();
						
			this.createSurveyQuestionPage.clickOnAddAudioQuestion(testDataProp.getProperty(ADD_AUDIO_CHOICE_FILE));

			this.createSurveyQuestionPage.clickOnQuestionSaveButton();

			Assert.assertEquals(createSurveyQuestionPage.getQuestionAddedSuccessfullyText(),
					expectedAssertionsProp.getProperty(QUESTION_ADDED_SUCCESSFULLY_TEXT));

		} catch (Exception e) {
			Assert.fail("Exception occured while testing verifyCreateSurveyQuestionDetailsByUploadingAudioQuestion : " + e.getMessage());
			logger.error("Error occured while verifyCreateSurveyQuestionDetailsByUploadingAudioQuestion " + e);
		}

		logger.info("Starting of verifyCreateSurveyQuestionDetailsByUploadingAudioQuestion method");
	}
	
	@Test(priority = 37, description = "Verify question tab functionality by selecting Add Question as Audio & upload the Image file in the add question field")
	@Description("Test Case #37,  Verify question tab functionality by selecting Add Question as Audio & upload the Image file in the add question field")
	@Severity(SeverityLevel.NORMAL)
	@Story("Test Case #37, Verify question tab functionality by selecting Add Question as Audio & upload the Image file in the add question field")
	public void verifyCreateSurveyQuestionDetailsBySelectingAudioQuestionAndUploadImage() {
		logger.info("Starting of verifyCreateSurveyQuestionDetailsBySelectingAudioQuestionAndUploadImage method");

		try {

			this.createSurveyQuestionPage.refresh();
			
			this.createSurveyQuestionPage.clickOnQuestionType();
			
			this.createSurveyQuestionPage.clickOnEngagementParameterDropDown();
			
			this.createSurveyQuestionPage.clickOnSubParameter();
			
			this.createSurveyQuestionPage.clickOnScale();
			
			this.createSurveyQuestionPage.clickOnLikertScaleEngagement();
			this.createSurveyQuestionPage.clickOnAddImageQuestion(testDataProp.getProperty(ADD_IMAGE_CHOICE_FILE));
			
			this.createSurveyQuestionPage.clickOnQuestionSaveButton();
			
			Assert.assertEquals(createSurveyQuestionPage.getQuestionAddedSuccessfullyText(),
					expectedAssertionsProp.getProperty(QUESTION_ADDED_SUCCESSFULLY_TEXT));


		} catch (Exception e) {
			Assert.fail("Exception occured while testing verifyCreateSurveyQuestionDetailsBySelectingAudioQuestionAndUploadImage : " + e.getMessage());
			logger.error("Error occured while verifyCreateSurveyQuestionDetailsBySelectingAudioQuestionAndUploadImage " + e);
		}

		logger.info("Starting of verifyCreateSurveyQuestionDetailsBySelectingAudioQuestionAndUploadImage method");
	}

	@Test(priority = 38, description = "Verify question tab functionality by selecting Add Question as Image  & Without uploading an image file in the question field and saving the question")
	@Description("Test Case #38, Verify question tab functionality by selecting Add Question as Image  & Without uploading an image file in the question field and saving the question")
	@Severity(SeverityLevel.NORMAL)
	@Story("Test Case #38, Verify question tab functionality by selecting Add Question as Image  & Without uploading an image file in the question field and saving the question")
	public void verifyCreateSurveyQuestionDetailsBySelectingImageQuestionAndWithoutUploadingImage() {
		logger.info("Starting of verifyCreateSurveyQuestionDetailsBySelectingImageQuestionAndWithoutUploadingImage method");

		try {

			this.createSurveyQuestionPage.refresh();
			
			this.createSurveyQuestionPage.clickOnQuestionType();
			
			this.createSurveyQuestionPage.clickOnEngagementParameterDropDown();
			
			this.createSurveyQuestionPage.clickOnSubParameter();
			
			this.createSurveyQuestionPage.clickOnScale();
			
			this.createSurveyQuestionPage.clickOnLikertScaleEngagement();
			
			this.createSurveyQuestionPage.clickOnAddImageQuestionButton();
			
			this.createSurveyQuestionPage.clickOnQuestionSaveButton();
			
			Assert.assertEquals(createSurveyQuestionPage.getQuestionAddedSuccessfullyText(),
					expectedAssertionsProp.getProperty(QUESTION_ADDED_SUCCESSFULLY_TEXT));

		} catch (Exception e) {
			Assert.fail("Exception occured while testing verifyCreateSurveyQuestionDetailsBySelectingImageQuestionAndWithoutUploadingImage : " + e.getMessage());
			logger.error("Error occured while verifyCreateSurveyQuestionDetailsBySelectingImageQuestionAndWithoutUploadingImage " + e);
		}

		logger.info("Starting of verifyCreateSurveyQuestionDetailsBySelectingImageQuestionAndWithoutUploadingImage method");
	}
	
	@Test(priority = 39, description = "Verify question tab functionality by selecting Add Question as Image & upload the Audio file in the add question field")
	@Description("Test Case #39,Verify question tab functionality by selecting Add Question as Image & upload the Audio file in the add question field")
	@Severity(SeverityLevel.NORMAL)
	@Story("Test Case #39, Verify question tab functionality by selecting Add Question as Image & upload the Audio file in the add question field")
	public void verifyCreateSurveyQuestionDetailsBySelectingImageQuestionAndUploadAudioFile() {
		logger.info("Starting of verifyCreateSurveyQuestionDetailsBySelectingImageQuestionAndUploadAudioFile method");

		try {

			this.createSurveyQuestionPage.refresh();
			
			this.createSurveyQuestionPage.clickOnQuestionType();
			
			this.createSurveyQuestionPage.clickOnEngagementParameterDropDown();
			
			this.createSurveyQuestionPage.clickOnSubParameter();
			
			this.createSurveyQuestionPage.clickOnScale();
			
			this.createSurveyQuestionPage.clickOnLikertScaleEngagement();

			this.createSurveyQuestionPage.clickOnAddImageQuestion(testDataProp.getProperty(ADD_AUDIO_CHOICE_FILE));
			
			Assert.assertEquals(createSurveyQuestionPage.getAudioQuestionIsInvalidText(),
					expectedAssertionsProp.getProperty(AUDIO_QUESTION_IS_INVALID_TEXT));
			
			//this.createSurveyQuestionPage.clickOnQuestionSaveButton();

		} catch (Exception e) {
			Assert.fail("Exception occured while testing verifyCreateSurveyQuestionDetailsBySelectingImageQuestionAndUploadAudioFile : " + e.getMessage());
			logger.error("Error occured while verifyCreateSurveyQuestionDetailsBySelectingImageQuestionAndUploadAudioFile " + e);
		}

		logger.info("Starting of verifyCreateSurveyQuestionDetailsBySelectingImageQuestionAndUploadAudioFile method");
	}
	
	@Test(priority = 40, description = "Verify question tab functionality by selecting Add Question as Video & upload the Audio file in the add question field")
	@Description("Test Case #40,Verify question tab functionality by selecting Add Question as Video & upload the Audio file in the add question field")
	@Severity(SeverityLevel.NORMAL)
	@Story("Test Case #40, Verify question tab functionality by selecting Add Question as Video & upload the Audio file in the add question field")
	public void verifyCreateSurveyQuestionDetailsBySelectingVideoQuestionAndUploadAudioFile() {
		logger.info("Starting of verifyCreateSurveyQuestionDetailsBySelectingVideoQuestionAndUploadAudioFile method");

		try {

			this.createSurveyQuestionPage.refresh();
			
			this.createSurveyQuestionPage.clickOnQuestionType();
			
			this.createSurveyQuestionPage.clickOnEngagementParameterDropDown();
			
			this.createSurveyQuestionPage.clickOnSubParameter();
			
			this.createSurveyQuestionPage.clickOnScale();
			
			this.createSurveyQuestionPage.clickOnLikertScaleEngagement();
			
			this.createSurveyQuestionPage.clickOnAddVideoQuestion(testDataProp.getProperty(ADD_AUDIO_CHOICE_FILE));
	
			Assert.assertEquals(createSurveyQuestionPage.getAudioQuestionIsInvalidText(),
					expectedAssertionsProp.getProperty(AUDIO_QUESTION_IS_INVALID_TEXT));
			
			//this.createSurveyQuestionPage.clickOnQuestionSaveButton();

		} catch (Exception e) {
			Assert.fail("Exception occured while testing verifyCreateSurveyQuestionDetailsBySelectingVideoQuestionAndUploadAudioFile : " + e.getMessage());
			logger.error("Error occured while verifyCreateSurveyQuestionDetailsBySelectingVideoQuestionAndUploadAudioFile " + e);
		}

		logger.info("Starting of verifyCreateSurveyQuestionDetailsBySelectingVideoQuestionAndUploadAudioFile method");
	}
	
	@Test(priority = 41, description = "Verify question tab functionality by Adding a Text question & Selecting option as image & uploading Audio file")
	@Description("Test Case #41, Verify question tab functionality by Adding a Text question & Selecting option as image & uploading Audio file")
	@Severity(SeverityLevel.NORMAL)
	@Story("Test Case #41, Verify question tab functionality by Adding a Text question & Selecting option as image & uploading Audio file ")
	public void verifyCreateSurveyQuestionDetailsBySelectingOptionAsImageAndUploadAudioFile() {
		logger.info("Starting of verifyCreateSurveyQuestionDetailsBySelectingOptionAsImageAndUploadAudioFile method");

		try {

			this.createSurveyQuestionPage.refresh();
			
			this.createSurveyQuestionPage.clickOnQuestionType();
			
			this.createSurveyQuestionPage.clickOnEngagementParameterDropDown();
			
			this.createSurveyQuestionPage.clickOnSubParameter();
			
			this.createSurveyQuestionPage.clickOnScale();
			
			this.createSurveyQuestionPage.clickOnLikertScaleEngagement();
			
			this.createSurveyQuestionPage.clickOnAddQuestion(testDataProp.getProperty(ADD_TEXT_QUESTION));
			
			this.createSurveyQuestionPage.clickOnImageChoiceQuestionButton();

			this.createSurveyQuestionPage.setImageChoiceOptions(testDataProp.getProperty(ADD_AUDIO_CHOICE_FILE));
			
			Assert.assertEquals(createSurveyQuestionPage.getAudioQuestionIsInvalidText(),
					expectedAssertionsProp.getProperty(AUDIO_QUESTION_IS_INVALID_TEXT));
			
			//this.createSurveyQuestionPage.clickOnQuestionSaveButton();

		} catch (Exception e) {
			Assert.fail("Exception occured while testing verifyCreateSurveyQuestionDetailsBySelectingOptionAsImageAndUploadAudioFile : " + e.getMessage());
			logger.error("Error occured while verifyCreateSurveyQuestionDetailsBySelectingOptionAsImageAndUploadAudioFile " + e);
		}

		logger.info("Starting of verifyCreateSurveyQuestionDetailsBySelectingVideoQuestionAndUploadAudioFile method");
	}
	
	@Test(priority = 42, description = "Verify question tab functionality by Adding a Text question & Selecting option as Audio & uploading image file")
	@Description("Test Case #42, Verify question tab functionality by Adding a Text question & Selecting option as image & uploading Audio file")
	@Severity(SeverityLevel.NORMAL)
	@Story("Test Case #42, Verify question tab functionality by Adding a Text question & Selecting option as Audio & uploading image file")
	public void verifyCreateSurveyQuestionDetailsBySelectingOptionAsAudioAndUploadImageFile() {
		logger.info("Starting of   method");

		try {

			this.createSurveyQuestionPage.refresh();
			
			this.createSurveyQuestionPage.clickOnQuestionType();
			
			this.createSurveyQuestionPage.clickOnEngagementParameterDropDown();
			
			this.createSurveyQuestionPage.clickOnSubParameter();
			
			this.createSurveyQuestionPage.clickOnScale();
			
			this.createSurveyQuestionPage.clickOnLikertScaleEngagement();
			
			this.createSurveyQuestionPage.clickOnAddQuestion(testDataProp.getProperty(ADD_TEXT_QUESTION));
			
			this.createSurveyQuestionPage.clickOnAddAudioChoiceQuestionsButton();
			
			this.createSurveyQuestionPage.setAudioChoiceOptions(testDataProp.getProperty(ADD_IMAGE_CHOICE_FILE));
			
			Assert.assertEquals(createSurveyQuestionPage.getImageQuestionIsInvalidText(),
					expectedAssertionsProp.getProperty(IMAGE_QUESTION_IS_INVALID_TEXT));

		} catch (Exception e) {
			Assert.fail("Exception occured while testing verifyCreateSurveyQuestionDetailsBySelectingOptionAsAudioAndUploadImageFile : " + e.getMessage());
			logger.error("Error occured while verifyCreateSurveyQuestionDetailsBySelectingOptionAsAudioAndUploadImageFile " + e);
		}

		logger.info("Starting of verifyCreateSurveyQuestionDetailsBySelectingVideoQuestionAndUploadAudioFile method");
	}
	
	@Test(priority = 43, description = "Verify question tab functionality by Adding a Text question & Selecting the option as Audio & uploading Video file")
	@Description("Test Case #43,Verify question tab functionality by Adding a Text question & Selecting the option as Audio & uploading Video file")
	@Severity(SeverityLevel.NORMAL)
	@Story("Test Case #43, Verify question tab functionality by Adding a Text question & Selecting option as Audio & uploading image file")
	public void verifyCreateSurveyQuestionDetailsBySelectingOptionAsAudioAndUploadVideoFile() {
		logger.info("Starting of   method");

		try {

			this.createSurveyQuestionPage.refresh();

			this.createSurveyQuestionPage.clickOnQuestionType();

			this.createSurveyQuestionPage.clickOnEngagementParameterDropDown();

			this.createSurveyQuestionPage.clickOnSubParameter();

			this.createSurveyQuestionPage.clickOnScale();

			this.createSurveyQuestionPage.clickOnLikertScaleEngagement();

			this.createSurveyQuestionPage.clickOnAddQuestion(testDataProp.getProperty(ADD_TEXT_QUESTION));
			
			this.createSurveyQuestionPage.clickOnAddAudioChoiceQuestionsButton();
			
			this.createSurveyQuestionPage.setAudioChoiceOptions(testDataProp.getProperty(ADD_VIDEO_CHOICE_FILE));
			
			Assert.assertEquals(createSurveyQuestionPage.getVideoQuestionIsInvalidText(),
					expectedAssertionsProp.getProperty(VIDEO_QUESTION_IS_INVALID_TEXT));
			

		} catch (Exception e) {
			Assert.fail("Exception occured while testing verifyCreateSurveyQuestionDetailsBySelectingOptionAsAudioAndUploadVideoFile : " + e.getMessage());
			logger.error("Error occured while verifyCreateSurveyQuestionDetailsBySelectingOptionAsAudioAndUploadVideoFile " + e);
		}

		logger.info("Starting of verifyCreateSurveyQuestionDetailsBySelectingOptionAsAudioAndUploadVideoFile method");
	}
	
	@Test(priority = 44, description = "Verify question tab functionality by Adding a Text question & Selecting the option as an image & uploading video file")
	@Description("Test Case #44, Verify question tab functionality by Adding a Text question & Selecting the option as an image & uploading video file")
	@Severity(SeverityLevel.NORMAL)
	@Story("Test Case #44, Verify question tab functionality by Adding a Text question & Selecting the option as an image & uploading video file")
	public void verifyCreateSurveyQuestionDetailsBySelectingOptionAsImageAndUploadVideoFile() {
		logger.info("Starting ofverifyCreateSurveyQuestionDetailsBySelectingOptionAsImageAndUploadVideoFile method");

		try {

			this.createSurveyQuestionPage.refresh();
			
			this.createSurveyQuestionPage.clickOnQuestionType();
			
			this.createSurveyQuestionPage.clickOnEngagementParameterDropDown();
			
			this.createSurveyQuestionPage.clickOnSubParameter();
			
			this.createSurveyQuestionPage.clickOnScale();
			
			this.createSurveyQuestionPage.clickOnLikertScaleEngagement();
			
			this.createSurveyQuestionPage.clickOnAddQuestion(testDataProp.getProperty(ADD_TEXT_QUESTION));
			
			this.createSurveyQuestionPage.clickOnImageChoiceQuestionButton();
			
			this.createSurveyQuestionPage.setImageChoiceOptions(testDataProp.getProperty(ADD_VIDEO_CHOICE_FILE));
			
			Assert.assertEquals(createSurveyQuestionPage.getVideoQuestionIsInvalidText(),
					expectedAssertionsProp.getProperty(VIDEO_QUESTION_IS_INVALID_TEXT));
			
		} catch (Exception e) {
			Assert.fail("Exception occured while testing verifyCreateSurveyQuestionDetailsBySelectingOptionAsImageAndUploadVideoFile : " + e.getMessage());
			logger.error("Error occured while verifyCreateSurveyQuestionDetailsBySelectingOptionAsImageAndUploadVideoFile " + e);
		}

		logger.info("Starting of verifyCreateSurveyQuestionDetailsBySelectingOptionAsImageAndUploadVideoFile method");
	}
	
	@Test(priority = 45, description = "Verify question tab functionality by Adding a Text question & Selecting the option as an video & uploading image file")
	@Description("Test Case #45, Verify question tab functionality by Adding a Text question & Selecting the option as an video & uploading image file")
	@Severity(SeverityLevel.NORMAL)
	@Story("Test Case #45, Verify question tab functionality by Adding a Text question & Selecting the option as an video & uploading image file")
	public void verifyCreateSurveyQuestionDetailsBySelectingOptionAsVideoAndUploadImageFile() {
		logger.info("Starting verifyCreateSurveyQuestionDetailsBySelectingOptionAsVideoAndUploadImageFile method");

		try {

			this.createSurveyQuestionPage.refresh();
			
			this.createSurveyQuestionPage.clickOnQuestionType();
			
			this.createSurveyQuestionPage.clickOnEngagementParameterDropDown();
			
			this.createSurveyQuestionPage.clickOnSubParameter();
			
			this.createSurveyQuestionPage.clickOnScale();
			
			this.createSurveyQuestionPage.clickOnLikertScaleEngagement();
			
			this.createSurveyQuestionPage.clickOnAddQuestion(testDataProp.getProperty(ADD_TEXT_QUESTION));
			
			this.createSurveyQuestionPage.clickOnAddVideoChoiceQuestionsButton();
			
			this.createSurveyQuestionPage.setVideoChoiceOptions(testDataProp.getProperty(ADD_IMAGE_CHOICE_FILE));
			
			Assert.assertEquals(createSurveyQuestionPage.getImageQuestionIsInvalidText(),
					expectedAssertionsProp.getProperty(IMAGE_QUESTION_IS_INVALID_TEXT));

		} catch (Exception e) {
			Assert.fail("Exception occured while testing verifyCreateSurveyQuestionDetailsBySelectingOptionAsVideoAndUploadImageFile : " + e.getMessage());
			logger.error("Error occured while verifyCreateSurveyQuestionDetailsBySelectingOptionAsVideoAndUploadImageFile " + e);
		}

		logger.info("Starting of verifyCreateSurveyQuestionDetailsBySelectingOptionAsVideoAndUploadImageFile method");
	}
	
	@Test(priority = 46, description = "Verify question tab functionality by Adding a Text question & Selecting the option as an Video & uploading Audio file")
	@Description("Test Case #46, Verify question tab functionality by Adding a Text question & Selecting the option as an Video & uploading Audio file")
	@Severity(SeverityLevel.NORMAL)
	@Story("Test Case #46, Verify question tab functionality by Adding a Text question & Selecting the option as an Video & uploading Audio file")
	public void verifyCreateSurveyQuestionDetailsBySelectingOptionAsVideoAndUploadAudioFile() {
		logger.info("Starting verifyCreateSurveyQuestionDetailsBySelectingOptionAsVideoAndUploadAudioFile method");

		try {

			this.createSurveyQuestionPage.refresh();
			
			this.createSurveyQuestionPage.clickOnQuestionType();
			
			this.createSurveyQuestionPage.clickOnEngagementParameterDropDown();
			
			this.createSurveyQuestionPage.clickOnSubParameter();
			
			this.createSurveyQuestionPage.clickOnScale();
			
			this.createSurveyQuestionPage.clickOnLikertScaleEngagement();
			
			this.createSurveyQuestionPage.clickOnAddQuestion(testDataProp.getProperty(ADD_TEXT_QUESTION));
			
			this.createSurveyQuestionPage.clickOnAddVideoChoiceQuestionsButton();
			
			this.createSurveyQuestionPage.setVideoChoiceOptions(testDataProp.getProperty(ADD_AUDIO_CHOICE_FILE));
			
			Assert.assertEquals(createSurveyQuestionPage.getAudioQuestionIsInvalidText(),
					expectedAssertionsProp.getProperty(AUDIO_QUESTION_IS_INVALID_TEXT));

		} catch (Exception e) {
			Assert.fail("Exception occured while testing verifyCreateSurveyQuestionDetailsBySelectingOptionAsVideoAndUploadAudioFile : " + e.getMessage());
			logger.error("Error occured while verifyCreateSurveyQuestionDetailsBySelectingOptionAsVideoAndUploadAudioFile " + e);
		}

		logger.info("Starting of verifyCreateSurveyQuestionDetailsBySelectingOptionAsVideoAndUploadAudioFile method");
	}
	
	@Test(priority = 47, description = "Verify question tab functionality by Selecting the image question & selecting the option choice as audio")
	@Description("Test Case #47, Verify question tab functionality by Selecting the image question & selecting the option choice as audio")
	@Severity(SeverityLevel.NORMAL)
	@Story("Test Case #47, Verify question tab functionality by Selecting the image question & selecting the option choice as audio")
	public void verifyCreateSurveyQuestionDetailsBySelectingImageQuestionAndSelectingOptionAsAudio() {
		logger.info("Starting verifyCreateSurveyQuestionDetailsBySelectingImageQuestionAndSelectingOptionAsAudio method");

		try {

			this.createSurveyQuestionPage.refresh();
			
			this.createSurveyQuestionPage.clickOnQuestionType();
			
			this.createSurveyQuestionPage.clickOnEngagementParameterDropDown();
			
			this.createSurveyQuestionPage.clickOnSubParameter();
			
			this.createSurveyQuestionPage.clickOnScale();
			
			this.createSurveyQuestionPage.clickOnLikertScaleEngagement();
			
			this.createSurveyQuestionPage.clickOnAddImageQuestion(testDataProp.getProperty(ADD_IMAGE_QUESTION));
			
			this.createSurveyQuestionPage.clickOnAddAudioChoiceQuestionsButton();
			
			this.createSurveyQuestionPage.setAudioChoiceOptions(testDataProp.getProperty(ADD_AUDIO_CHOICE_FILE));
			
			this.createSurveyQuestionPage.clickOnQuestionSaveButton();
			
			Assert.assertEquals(createSurveyQuestionPage.getQuestionAddedSuccessfullyText(),
					expectedAssertionsProp.getProperty(QUESTION_ADDED_SUCCESSFULLY_TEXT));

		} catch (Exception e) {
			Assert.fail("Exception occured while testing verifyCreateSurveyQuestionDetailsBySelectingImageQuestionAndSelectingOptionAsAudio : " + e.getMessage());
			logger.error("Error occured while verifyCreateSurveyQuestionDetailsBySelectingImageQuestionAndSelectingOptionAsAudio " + e);
		}

		logger.info("Starting of verifyCreateSurveyQuestionDetailsBySelectingImageQuestionAndSelectingOptionAsAudio method");
	}
	
	@Test(priority = 48, description = "Verify the Question tab functionality by selecting Text question & Add Your Choices as Text")
	@Description("Test Case #48, Verify the Question tab functionality by selecting Text question & Add Your Choices as Text")
	@Severity(SeverityLevel.NORMAL)
	@Story("Test Case #48, Verify the Question tab functionality by selecting Text question & Add Your Choices as Text")
	public void verifyCreateSurveyQuestionDetailsBySelectingTextQuestionAndSelectingOptionsAsText() {
		logger.info("Starting verifyCreateSurveyQuestionDetailsBySelectingTextQuestionAndSelectingOptionsAsText method");

		try {

			this.createSurveyQuestionPage.refresh();
			
			this.createSurveyQuestionPage.clickOnQuestionType();
			
			this.createSurveyQuestionPage.clickOnEngagementParameterDropDown();
			
			this.createSurveyQuestionPage.clickOnSubParameter();
			
			this.createSurveyQuestionPage.clickOnScale();
			
			this.createSurveyQuestionPage.clickOnLikertScaleEngagement();
			
			this.createSurveyQuestionPage.clickOnAddQuestion(testDataProp.getProperty(ADD_TEXT_QUESTION));

			this.createSurveyQuestionPage.clickOnQuestionSaveButton();
			
			Assert.assertEquals(createSurveyQuestionPage.getQuestionAddedSuccessfullyText(),
					expectedAssertionsProp.getProperty(QUESTION_ADDED_SUCCESSFULLY_TEXT));


		} catch (Exception e) {
			Assert.fail("Exception occured while testing verifyCreateSurveyQuestionDetailsBySelectingTextQuestionAndSelectingOptionsAsText : " + e.getMessage());
			logger.error("Error occured while verifyCreateSurveyQuestionDetailsBySelectingTextQuestionAndSelectingOptionsAsText " + e);
		}

		logger.info("Starting of verifyCreateSurveyQuestionDetailsBySelectingTextQuestionAndSelectingOptionsAsText method");
	}
	
	@Test(priority = 49, description = "Verify the Question tab functionality by selecting Text question & Add Your Choices as Audio")
	@Description("Test Case #49, Verify the Question tab functionality by selecting Text question & Add Your Choices as Text")
	@Severity(SeverityLevel.NORMAL)
	@Story("Test Case #49, Verify the Question tab functionality by selecting Text question & Add Your Choices as Text")
	public void verifyCreateSurveyQuestionDetailsBySelectingTextQuestionAndSelectingOptionsAsAudio() {
		logger.info("Starting verifyCreateSurveyQuestionDetailsBySelectingTextQuestionAndSelectingOptionsAsAudio method");

		try {

			this.createSurveyQuestionPage.refresh();
			
			this.createSurveyQuestionPage.clickOnQuestionType();
			
			this.createSurveyQuestionPage.clickOnEngagementParameterDropDown();
			
			this.createSurveyQuestionPage.clickOnSubParameter();
			
			this.createSurveyQuestionPage.clickOnScale();
			
			this.createSurveyQuestionPage.clickOnLikertScaleEngagement();
			
			this.createSurveyQuestionPage.clickOnAddQuestion(testDataProp.getProperty(ADD_TEXT_QUESTION));
			
			this.createSurveyQuestionPage.clickOnAddAudioChoiceQuestionsButton();
			
			this.createSurveyQuestionPage.setAudioChoiceOptions(testDataProp.getProperty(ADD_AUDIO_CHOICE_FILE));
			
			this.createSurveyQuestionPage.clickOnQuestionSaveButton();
			
			Assert.assertEquals(createSurveyQuestionPage.getQuestionAddedSuccessfullyText(),
					expectedAssertionsProp.getProperty(QUESTION_ADDED_SUCCESSFULLY_TEXT));


		} catch (Exception e) {
			Assert.fail("Exception occured while testing verifyCreateSurveyQuestionDetailsBySelectingTextQuestionAndSelectingOptionsAsAudio : " + e.getMessage());
			logger.error("Error occured while verifyCreateSurveyQuestionDetailsBySelectingTextQuestionAndSelectingOptionsAsAudio " + e);
		}

		logger.info("Starting of verifyCreateSurveyQuestionDetailsBySelectingTextQuestionAndSelectingOptionsAsAudio method");
	}
	
	@Test(priority = 50, description = "Verify the Question tab functionality by selecting Text question & Add Your Choices as Video")
	@Description("Test Case #50, Verify the Question tab functionality by selecting Text question & Add Your Choices as Video")
	@Severity(SeverityLevel.NORMAL)
	@Story("Test Case #50, Verify the Question tab functionality by selecting Text question & Add Your Choices as Video")
	public void verifyCreateSurveyQuestionDetailsBySelectingTextQuestionAndSelectingOptionsAsVideo() {
		logger.info("Starting verifyCreateSurveyQuestionDetailsBySelectingTextQuestionAndSelectingOptionsAsVideo method");

		try {

			this.createSurveyQuestionPage.refresh();
			
			this.createSurveyQuestionPage.clickOnQuestionType();
			
			this.createSurveyQuestionPage.clickOnEngagementParameterDropDown();
			
			this.createSurveyQuestionPage.clickOnSubParameter();
			
			this.createSurveyQuestionPage.clickOnScale();
			
			this.createSurveyQuestionPage.clickOnLikertScaleEngagement();
			
			this.createSurveyQuestionPage.clickOnAddQuestion(testDataProp.getProperty(ADD_TEXT_QUESTION));
			
			this.createSurveyQuestionPage.clickOnAddVideoChoiceQuestionsButton();
			
			this.createSurveyQuestionPage.setVideoChoiceOptions(testDataProp.getProperty(ADD_VIDEO_CHOICE_FILE));
			
			this.createSurveyQuestionPage.clickOnQuestionSaveButton();
			
			Assert.assertEquals(createSurveyQuestionPage.getQuestionAddedSuccessfullyText(),
					expectedAssertionsProp.getProperty(QUESTION_ADDED_SUCCESSFULLY_TEXT));

		} catch (Exception e) {
			Assert.fail("Exception occured while testing verifyCreateSurveyQuestionDetailsBySelectingTextQuestionAndSelectingOptionsAsVideo : " + e.getMessage());
			logger.error("Error occured while verifyCreateSurveyQuestionDetailsBySelectingTextQuestionAndSelectingOptionsAsVideo " + e);
		}

		logger.info("Starting of verifyCreateSurveyQuestionDetailsBySelectingTextQuestionAndSelectingOptionsAsVideo method");
	}
	
	@Test(priority = 51, description = "Verify the Question tab functionality by selecting Image question & Add Your Choices as Text")
	@Description("Test Case #51, Verify the Question tab functionality by selecting Image question & Add Your Choices as Text")
	@Severity(SeverityLevel.NORMAL)
	@Story("Test Case #51, Verify the Question tab functionality by selecting Image question & Add Your Choices as Text")
	public void verifyCreateSurveyQuestionDetailsBySelectingImageQuestionAndSelectingOptionsAsText() {
		logger.info("Starting verifyCreateSurveyQuestionDetailsBySelectingImageQuestionAndSelectingOptionsAsText method");

		try {

			this.createSurveyQuestionPage.refresh();
			
			this.createSurveyQuestionPage.clickOnQuestionType();
			
			this.createSurveyQuestionPage.clickOnEngagementParameterDropDown();
			
			this.createSurveyQuestionPage.clickOnSubParameter();
			
			this.createSurveyQuestionPage.clickOnScale();
			
			this.createSurveyQuestionPage.clickOnLikertScaleEngagement();
			
			this.createSurveyQuestionPage.clickOnAddImageQuestion(testDataProp.getProperty(ADD_IMAGE_CHOICE_FILE));
			
			this.createSurveyQuestionPage.clickOnQuestionSaveButton();
			
			Assert.assertEquals(createSurveyQuestionPage.getQuestionAddedSuccessfullyText(),
					expectedAssertionsProp.getProperty(QUESTION_ADDED_SUCCESSFULLY_TEXT));

		} catch (Exception e) {
			Assert.fail("Exception occured while testing verifyCreateSurveyQuestionDetailsBySelectingImageQuestionAndSelectingOptionsAsText : " + e.getMessage());
			logger.error("Error occured while verifyCreateSurveyQuestionDetailsBySelectingImageQuestionAndSelectingOptionsAsText " + e);
		}

		logger.info("Starting of verifyCreateSurveyQuestionDetailsBySelectingImageQuestionAndSelectingOptionsAsText method");
	}
	
	@Test(priority = 52, description = "Verify the Question tab functionality by selecting Image question & Add Your Choices as upload Image file")
	@Description("Test Case #52, Verify the Question tab functionality by selecting Image question & Add Your Choices as upload Image file")
	@Severity(SeverityLevel.NORMAL)
	@Story("Test Case #52, Verify the Question tab functionality by selecting Image question & Add Your Choices as upload Image file")
	public void verifyCreateSurveyQuestionDetailsBySelectingImageQuestionAndSelectingOptionsAsImage() {
		logger.info("Starting verifyCreateSurveyQuestionDetailsBySelectingImageQuestionAndSelectingOptionsAsImage method");

		try {

			this.createSurveyQuestionPage.refresh();
			
			this.createSurveyQuestionPage.clickOnQuestionType();
			
			this.createSurveyQuestionPage.clickOnEngagementParameterDropDown();
			
			this.createSurveyQuestionPage.clickOnSubParameter();
			
			this.createSurveyQuestionPage.clickOnScale();
			
			this.createSurveyQuestionPage.clickOnLikertScaleEngagement();
			
			this.createSurveyQuestionPage.clickOnAddImageQuestion(testDataProp.getProperty(ADD_IMAGE_CHOICE_FILE));
			
			this.createSurveyQuestionPage.clickOnImageChoiceQuestionButton();
			
			this.createSurveyQuestionPage.setImageChoiceOptions(testDataProp.getProperty(ADD_IMAGE_CHOICE_FILE));
			
			this.createSurveyQuestionPage.clickOnQuestionSaveButton();
			
			Assert.assertEquals(createSurveyQuestionPage.getQuestionAddedSuccessfullyText(),
					expectedAssertionsProp.getProperty(QUESTION_ADDED_SUCCESSFULLY_TEXT));

		} catch (Exception e) {
			Assert.fail("Exception occured while testing verifyCreateSurveyQuestionDetailsBySelectingImageQuestionAndSelectingOptionsAsImage : " + e.getMessage());
			logger.error("Error occured while verifyCreateSurveyQuestionDetailsBySelectingImageQuestionAndSelectingOptionsAsImage " + e);
		}

		logger.info("Starting of verifyCreateSurveyQuestionDetailsBySelectingImageQuestionAndSelectingOptionsAsImage method");
	}
	
	@Test(priority = 53, description = "Verify the Question tab functionality by selecting Image question & Add Your Choices as upload Audio file")
	@Description("Test Case #53, Verify the Question tab functionality by selecting Image question & Add Your Choices as upload Audio file")
	@Severity(SeverityLevel.NORMAL)
	@Story("Test Case #53, Verify the Question tab functionality by selecting Image question & Add Your Choices as upload Audio file")
	public void verifyCreateSurveyQuestionDetailsBySelectingImageQuestionAndSelectingOptionsAsAudio() {
		logger.info("Starting verifyCreateSurveyQuestionDetailsBySelectingImageQuestionAndSelectingOptionsAsAudio method");

		try {

			this.createSurveyQuestionPage.refresh();
			
			this.createSurveyQuestionPage.clickOnQuestionType();
			
			this.createSurveyQuestionPage.clickOnEngagementParameterDropDown();
			
			this.createSurveyQuestionPage.clickOnSubParameter();
			
			this.createSurveyQuestionPage.clickOnScale();
			
			this.createSurveyQuestionPage.clickOnLikertScaleEngagement();
			
			this.createSurveyQuestionPage.clickOnAddImageQuestion(testDataProp.getProperty(ADD_IMAGE_CHOICE_FILE));
			
			this.createSurveyQuestionPage.clickOnAddAudioChoiceQuestionsButton();
			
			this.createSurveyQuestionPage.setAudioChoiceOptions(testDataProp.getProperty(ADD_AUDIO_CHOICE_FILE));
			
			this.createSurveyQuestionPage.clickOnQuestionSaveButton();
			
			Assert.assertEquals(createSurveyQuestionPage.getQuestionAddedSuccessfullyText(),
					expectedAssertionsProp.getProperty(QUESTION_ADDED_SUCCESSFULLY_TEXT));

		} catch (Exception e) {
			Assert.fail("Exception occured while testing verifyCreateSurveyQuestionDetailsBySelectingImageQuestionAndSelectingOptionsAsAudio : " + e.getMessage());
			logger.error("Error occured while verifyCreateSurveyQuestionDetailsBySelectingImageQuestionAndSelectingOptionsAsAudio " + e);
		}

		logger.info("Starting of verifyCreateSurveyQuestionDetailsBySelectingImageQuestionAndSelectingOptionsAsAudio method");
	}
}