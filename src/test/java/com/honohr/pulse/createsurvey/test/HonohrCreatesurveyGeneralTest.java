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
import com.honohr.pulse.createsurvey.pages.HonohrPulseCreateSurveyPage;
import com.honohr.pulse.login.pages.HonohrPulseLoginPage;

import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Story;

@Epic("Hono Pulse Create Survey")
@Feature("Create survey General functionality ")
public class HonohrCreatesurveyGeneralTest extends BaseHonoPulseAutomationTest {
	
	private WebDriver driver = null;
	private HonohrPulseLoginPage honoLoginPage = null;
	private HonohrPulseCreateSurveyPage honoCreateSurveyPage = null;

	private static final Logger logger = Logger.getLogger(HonohrCreatesurveyGeneralTest.class.getName());


	@BeforeTest
	@Parameters({ "browser", "siteURL", "emailAddress", "password" })
	public void initMethodTest(String browser, String siteURL, String emailAddress, String password) throws Exception {
		logger.info("Starting of initMethodTest method");

		this.driver = this.getWebDriver(browser);
		
		this.loginToHono(browser, siteURL, emailAddress, password, this.driver);
		
		honoLoginPage = new HonohrPulseLoginPage(driver);
		honoCreateSurveyPage = new HonohrPulseCreateSurveyPage(driver);

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

		} catch (Exception e) {
			Assert.fail("Exception occured while testing verifyDashboard : " + e.getMessage());
			logger.error("Error occured while verifyDashboard " + e);
		}

		logger.info("Starting of verifyCreatesurveyGeneralFunctionality method");
	}
	
	@Test(priority = 3, description = "Verify General Tab functionality by selecting Category and leaving Survey Name & Description & Expired Date fields blank")
	@Description("Test Case #3, Verify General Tab functionality by selecting Category and leaving Survey Name & Description & Expired Date fields blank")
	@Severity(SeverityLevel.NORMAL)
	@Story("Test Case #3, Verify General Tab functionality by selecting Category and leaving Survey Name & Description & Expired Date fields blank")
	public void verifyCreateSurveyGeneralTabDetailsBySelectingOnlyCategory() {
		logger.info("Starting of verifyCreateSurveyGeneralTabDetailsBySelectingOnlyCategory method");

		try {

			Assert.assertEquals(honoCreateSurveyPage.getTextGeneral(),
					expectedAssertionsProp.getProperty(GENERAL_TEXT));

			this.honoCreateSurveyPage.clickOnSurveyCategory();
			this.honoCreateSurveyPage.clickOnEngagement();

			this.honoCreateSurveyPage.clickOnSaveButton();

			Assert.assertEquals(honoCreateSurveyPage.getGeneralToastText(),
					expectedAssertionsProp.getProperty(CHECK_YOUR_FIELD_TEXT));

		} catch (Exception e) {
			Assert.fail("Exception occured while testing verifyCreateSurveyGeneralTabDetailsBySelectingOnlyCategory : " + e.getMessage());
			logger.error("Error occured while verifyCreateSurveyGeneralTabDetailsBySelectingOnlyCategory " + e);
		}

		logger.info("Starting of verifyCreateSurveyGeneralTabDetailsBySelectingOnlyCategory method");
	}
	
	@Test(priority = 4, description = "Verify General Tab functionality by Entering Text in the Survey name field and leaving the Select category & Description & Expired Date fields blank")
	@Description("Test Case #4, Verify General Tab functionality by Entering Text in the Survey name field and leaving the Select category & Description & Expired Date fields blank")
	@Severity(SeverityLevel.NORMAL)
	@Story("Test Case #4, Verify General Tab functionality by Entering Text in the Survey name field and leaving the Select category & Description & Expired Date fields blank")
	public void verifyCreateSurveyGeneralTabDetailsByOnlyGivingSurveyName() {
		logger.info("Starting of verifyCreateSurveyGeneralTabDetailsBySelectingOnlyCategory method");

		try {
			
			this.honoCreateSurveyPage.refresh();
			
			this.honoCreateSurveyPage.clickOnSurveyName(testDataProp.getProperty(SURVEY_NAME));
			
			this.honoCreateSurveyPage.clickOnSurveyCategory();
			
			this.honoCreateSurveyPage.clickOnEngagement();


			this.honoCreateSurveyPage.clickOnSaveButton();

			Assert.assertEquals(honoCreateSurveyPage.getGeneralToastText(),
					expectedAssertionsProp.getProperty(CHECK_YOUR_FIELD_TEXT));

		} catch (Exception e) {
			Assert.fail("Exception occured while testing verifyCreateSurveyGeneralTabDetailsBySelectingOnlyCategory : " + e.getMessage());
			logger.error("Error occured while verifyCreateSurveyGeneralTabDetailsBySelectingOnlyCategory " + e);
		}

		logger.info("Starting of verifyCreateSurveyGeneralTabDetailsBySelectingOnlyCategory method");
	}
	
	@Test(priority = 5, description = "Verify General Tab functionality by Entering Text in the Description field and leaving the Select category & Survey name & Expired Date fields blank")
	@Description("Test Case #5, Verify General Tab functionality by Entering Text in the Description field and leaving the Select category & Survey name & Expired Date fields blank")
	@Severity(SeverityLevel.NORMAL)
	@Story("Test Case #5, Verify General Tab functionality by Entering Text in the Description field and leaving the Select category & Survey name & Expired Date fields blank")
	public void verifyCreateSurveyGeneralTabDetailsByOnlyGivingDescription() {
		logger.info("Starting of verifyCreateSurveyGeneralTabDetailsByOnlyGivingDescription method");

		try {
			this.honoCreateSurveyPage.refresh();
			
			this.honoCreateSurveyPage.clickOnSurveyDesc(testDataProp.getProperty(SURVEY_DESC));

			this.honoCreateSurveyPage.clickOnSaveButton();

			Assert.assertEquals(honoCreateSurveyPage.getGeneralToastText(),
					expectedAssertionsProp.getProperty(CHECK_YOUR_FIELD_TEXT));

		} catch (Exception e) {
			Assert.fail("Exception occured while testing verifyCreateSurveyGeneralTabDetailsByOnlyGivingDescription : " + e.getMessage());
			logger.error("Error occured while verifyCreateSurveyGeneralTabDetailsByOnlyGivingDescription " + e);
		}

		logger.info("Starting of verifyCreateSurveyGeneralTabDetailsByOnlyGivingDescription method");
	}
	
	@Test(priority = 6, description = "Verify General Tab functionality by Selecting Date from the date picker and leaving the Select category & Survey name & Description fields blank")
	@Description("Verify General Tab functionality by Selecting Date from the date picker and leaving the Select category & Survey name & Description fields blank")
	@Severity(SeverityLevel.NORMAL)
	@Story("Test Case #6, Verify General Tab functionality by Selecting Date from the date picker and leaving the Select category & Survey name & Description fields blank")
	public void verifyCreateSurveyGeneralTabDetailsByOnlyGivingDate() {
		logger.info("Starting of verifyCreateSurveyGeneralTabDetailsByOnlyGivingDate method");

		try {
			this.honoCreateSurveyPage.refresh();
			
			this.honoCreateSurveyPage.setExpiryDate(testDataProp.getProperty(EXPIRY_DATE));

			this.honoCreateSurveyPage.clickOnSaveButton();

			Assert.assertEquals(honoCreateSurveyPage.getGeneralToastText(),
					expectedAssertionsProp.getProperty(CHECK_YOUR_FIELD_TEXT));

		} catch (Exception e) {
			Assert.fail("Exception occured while testing verifyCreateSurveyGeneralTabDetailsByOnlyGivingDate : " + e.getMessage());
			logger.error("Error occured while verifyCreateSurveyGeneralTabDetailsByOnlyGivingDate " + e);
		}

		logger.info("Starting of verifyCreateSurveyGeneralTabDetailsByOnlyGivingDate method");
	}

	@Test(priority = 7, description = "Verify General Tab functionality by Entering Text in the Survey name & Description fields and leaving Select Category Expired date fields blank")
	@Description("Verify General Tab functionality by Entering Text in the Survey name & Description fields and leaving Select Category Expired date fields blank")
	@Severity(SeverityLevel.NORMAL)
	@Story("Test Case #7, Verify General Tab functionality by Entering Text in the Survey name & Description fields and leaving Select Category Expired date fields blank")
	public void verifyCreateSurveyGeneralTabDetailsByOnlyGivingSurveyNameAndDesc() {
		logger.info("Starting of verifyCreateSurveyGeneralTabDetailsByOnlyGivingSurveyNameAndDesc method");

		try {
			
			this.honoCreateSurveyPage.refresh();
			
			this.honoCreateSurveyPage.clickOnSurveyName(testDataProp.getProperty(SURVEY_NAME));

			this.honoCreateSurveyPage.clickOnSurveyDesc(testDataProp.getProperty(SURVEY_DESC));

			this.honoCreateSurveyPage.clickOnSaveButton();

			Assert.assertEquals(honoCreateSurveyPage.getGeneralCategoryText(),
					expectedAssertionsProp.getProperty(SELECT_CATEGORY_TEXT));

		} catch (Exception e) {
			Assert.fail("Exception occured while testing verifyCreateSurveyGeneralTabDetailsByOnlyGivingSurveyNameAndDesc : " + e.getMessage());
			logger.error("Error occured while verifyCreateSurveyGeneralTabDetailsByOnlyGivingSurveyNameAndDesc " + e);
		}

		logger.info("Starting of verifyCreateSurveyGeneralTabDetailsByOnlyGivingSurveyNameAndDesc method");
	}
	
	@Test(priority = 8, description = "Verify General Tab functionality by Entering the Survey name & selecting the category and leaving the Description , Expired Date fields blank ")
	@Description("Verify General Tab functionality by Entering the Survey name & selecting the category and leaving the Description , Expired Date fields blank ")
	@Severity(SeverityLevel.NORMAL)
	@Story("Test Case #8, Verify General Tab functionality by Entering the Survey name & selecting the category and leaving the Description , Expired Date fields blank ")
	public void verifyCreateSurveyGeneralTabDetailsByOnlyGivingSurveyNameAndCategory() {
		logger.info("Starting of verifyCreateSurveyGeneralTabDetailsByOnlyGivingSurveyNameAndCategory method");

		try {
			
			this.honoCreateSurveyPage.refresh();
			
			this.honoCreateSurveyPage.clickOnSurveyName(testDataProp.getProperty(SURVEY_NAME));

			this.honoCreateSurveyPage.clickOnSurveyCategory();
			
			this.honoCreateSurveyPage.clickOnEngagement();

			this.honoCreateSurveyPage.clickOnSaveButton();

			Assert.assertEquals(honoCreateSurveyPage.getGeneralToastText(),
					expectedAssertionsProp.getProperty(CHECK_YOUR_FIELD_TEXT));

		} catch (Exception e) {
			Assert.fail("Exception occured while testing verifyCreateSurveyGeneralTabDetailsByOnlyGivingSurveyNameAndCategory : " + e.getMessage());
			logger.error("Error occured while verifyCreateSurveyGeneralTabDetailsByOnlyGivingSurveyNameAndCategory " + e);
		}

		logger.info("Starting of verifyCreateSurveyGeneralTabDetailsByOnlyGivingSurveyNameAndCategory method");
	}
	
	@Test(priority = 9, description = "Verify General Tab functionality by selecting Category & Expiry date and leaving Survey Name & Description fields blank")
	@Description("Verify General Tab functionality by selecting Category & Expiry date and leaving Survey Name & Description fields blank")
	@Severity(SeverityLevel.NORMAL)
	@Story("Test Case #9, Verify General Tab functionality by selecting Category & Expiry date and leaving Survey Name & Description fields blank")
	public void verifyCreateSurveyGeneralTabDetailsByOnlyGivingExpDateAndCategory() {
		logger.info("Starting of verifyCreateSurveyGeneralTabDetailsByOnlyGivingSurveyNameAndCategory method");

		try {
			
			this.honoCreateSurveyPage.refresh();

			this.honoCreateSurveyPage.clickOnSurveyCategory();
			
			this.honoCreateSurveyPage.clickOnEngagement();
			
			this.honoCreateSurveyPage.setExpiryDate(testDataProp.getProperty(EXPIRY_DATE));
			
			//this.honoCreateSurveyPage.clickOnAddLanguage();
			
			//this.honoCreateSurveyPage.clickOnSelectLanguage();

			this.honoCreateSurveyPage.clickOnSaveButton();

			Assert.assertEquals(honoCreateSurveyPage.getGeneralToastText(),
					expectedAssertionsProp.getProperty(CHECK_YOUR_FIELD_TEXT));

		} catch (Exception e) {
			Assert.fail("Exception occured while testing verifyCreateSurveyGeneralTabDetailsByOnlyGivingSurveyNameAndCategory : " + e.getMessage());
			logger.error("Error occured while verifyCreateSurveyGeneralTabDetailsByOnlyGivingSurveyNameAndCategory " + e);
		}

		logger.info("Starting of verifyCreateSurveyGeneralTabDetailsByOnlyGivingSurveyNameAndCategory method");
	}
	
	@Test(priority = 10, description = "Verify General Tab functionality by Entering the Survey name & selecting category and leaving Description field blank")
	@Description("Verify General Tab functionality by Entering the Survey name & selecting category and leaving Description field blank")
	@Severity(SeverityLevel.NORMAL)
	@Story("Test Case #10, Verify General Tab functionality by Entering the Survey name & selecting category and leaving Description field blank")
	public void verifyCreateSurveyGeneralTabDetailsByOnlyLeavingDescriptionBlank() {
		logger.info("Starting of verifyCreateSurveyGeneralTabDetailsByOnlyLeavingDescriptionBlank method");

		try {

			this.honoCreateSurveyPage.refresh();
			
			this.honoCreateSurveyPage.clickOnSurveyName(testDataProp.getProperty(SURVEY_NAME));

			this.honoCreateSurveyPage.clickOnSurveyCategory();

			this.honoCreateSurveyPage.clickOnEngagement();

			this.honoCreateSurveyPage.clickOnSaveButton();

			Assert.assertEquals(honoCreateSurveyPage.getGeneralToastText(),
					expectedAssertionsProp.getProperty(CHECK_YOUR_FIELD_TEXT));

		} catch (Exception e) {
			Assert.fail("Exception occured while testing verifyCreateSurveyGeneralTabDetailsByOnlyLeavingDescriptionBlank : " + e.getMessage());
			logger.error("Error occured while verifyCreateSurveyGeneralTabDetailsByOnlyLeavingDescriptionBlank " + e);
		}

		logger.info("Starting of verifyCreateSurveyGeneralTabDetailsByOnlyLeavingDescriptionBlank method");
	}
	
	@Test(priority = 11, description = "Verify General Tab functionality by Entering the Description & Selecting Category and leaving Survey Name field blank")
	@Description("Verify General Tab functionality by Entering the Description & Selecting Category and leaving Survey Name field blank")
	@Severity(SeverityLevel.NORMAL)
	@Story("Test Case #11, Verify General Tab functionality by Entering the Description & Selecting Category and leaving Survey Name field blank")
	public void verifyCreateSurveyGeneralTabDetailsByOnlyLeavingSurveyNameBlank() {
		logger.info("Starting of verifyCreateSurveyGeneralTabDetailsByOnlyLeavingSurveyNameBlank method");

		try {
			
			this.honoCreateSurveyPage.refresh();
			
			this.honoCreateSurveyPage.clickOnSurveyCategory();

			this.honoCreateSurveyPage.clickOnEngagement();

			this.honoCreateSurveyPage.clickOnSaveButton();

			Assert.assertEquals(honoCreateSurveyPage.getGeneralToastText(),
					expectedAssertionsProp.getProperty(CHECK_YOUR_FIELD_TEXT));

		} catch (Exception e) {
			Assert.fail("Exception occured while testing verifyCreateSurveyGeneralTabDetailsByOnlyLeavingSurveyNameBlank : " + e.getMessage());
			logger.error("Error occured while verifyCreateSurveyGeneralTabDetailsByOnlyLeavingSurveyNameBlank " + e);
		}

		logger.info("Starting of verifyCreateSurveyGeneralTabDetailsByOnlyLeavingSurveyNameBlank method");
	}
	
	@Test(priority = 12, description = "Verify General Tab functionality by leaving all fields blank")
	@Description("Verify General Tab functionality by leaving all fields blank")
	@Severity(SeverityLevel.NORMAL)
	@Story("Test Case #12, Verify General Tab functionality by leaving all fields blank")
	public void verifyCreateSurveyGeneralTabDetailsByLeavingAllFieldsBlank() {
		logger.info("Starting of verifyCreateSurveyGeneralTabDetailsByLeavingAllFieldsBlank method");

		try {
			
			this.honoCreateSurveyPage.refresh();
			
			this.honoCreateSurveyPage.clickOnSaveButton();

			Assert.assertEquals(honoCreateSurveyPage.getGeneralToastText(),
					expectedAssertionsProp.getProperty(CHECK_YOUR_FIELD_TEXT));

		} catch (Exception e) {
			Assert.fail("Exception occured while testing verifyCreateSurveyGeneralTabDetailsByLeavingAllFieldsBlank : " + e.getMessage());
			logger.error("Error occured while verifyCreateSurveyGeneralTabDetailsByLeavingAllFieldsBlank " + e);
		}

		logger.info("Starting of verifyCreateSurveyGeneralTabDetailsByLeavingAllFieldsBlank method");
	}
	
	@Test(priority = 13, description = "Verify General Tab functionality by Entering the Survey name & selecting  Expiry Date and leaving Description , select category fields blank")
	@Description("Verify General Tab functionality by Entering the Survey name & selecting  Expiry Date and leaving Description , select category fields blank")
	@Severity(SeverityLevel.NORMAL)
	@Story("Test Case #13, Verify General Tab functionality by Entering the Survey name & selecting  Expiry Date and leaving Description , select category fields blank")
	public void verifyCreateSurveyGeneralTabDetailsByLeavingCategoryAndDescriptionBlank() {
		logger.info("Starting of verifyCreateSurveyGeneralTabDetailsByLeavingCategoryAndDescriptionBlank method");

		try {
			
			this.honoCreateSurveyPage.refresh();
			
			this.honoCreateSurveyPage.clickOnSurveyName(testDataProp.getProperty(SURVEY_NAME));
			
			this.honoCreateSurveyPage.setExpiryDate(testDataProp.getProperty(EXPIRY_DATE));
			
			this.honoCreateSurveyPage.clickOnSaveButton();

			Assert.assertEquals(honoCreateSurveyPage.getGeneralToastText(),
					expectedAssertionsProp.getProperty(CHECK_YOUR_FIELD_TEXT));

		} catch (Exception e) {
			Assert.fail("Exception occured while testing verifyCreateSurveyGeneralTabDetailsByLeavingCategoryAndDescriptionBlank : " + e.getMessage());
			logger.error("Error occured while verifyCreateSurveyGeneralTabDetailsByLeavingCategoryAndDescriptionBlank " + e);
		}

		logger.info("Starting of verifyCreateSurveyGeneralTabDetailsByLeavingCategoryAndDescriptionBlank method");
	}

	@Test(priority = 14, description = "Verify General Tab functionality by Entering the description & selecting Expiry Date and leaving Survey name, Select category fields blank")
	@Description("Verify General Tab functionality by Entering the description & selecting Expiry Date and leaving Survey name, Select category fields blank")
	@Severity(SeverityLevel.NORMAL)
	@Story("Test Case #14, Verify General Tab functionality by Entering the description & selecting Expiry Date and leaving Survey name, Select category fields blank")
	public void verifyCreateSurveyGeneralTabDetailsByLeavingsurveyNameAndCategoryBlank() {
		logger.info("Starting of verifyCreateSurveyGeneralTabDetailsByLeavingsurveyNameAndCategoryBlank method");

		try {
			
			this.honoCreateSurveyPage.refresh();

			this.honoCreateSurveyPage.setExpiryDate(testDataProp.getProperty(EXPIRY_DATE));

			this.honoCreateSurveyPage.clickOnSaveButton();

			Assert.assertEquals(honoCreateSurveyPage.getGeneralToastText(),
					expectedAssertionsProp.getProperty(CHECK_YOUR_FIELD_TEXT));

		} catch (Exception e) {
			Assert.fail("Exception occured while testing verifyCreateSurveyGeneralTabDetailsByLeavingsurveyNameAndCategoryBlank : " + e.getMessage());
			logger.error("Error occured while verifyCreateSurveyGeneralTabDetailsByLeavingsurveyNameAndCategoryBlank " + e);
		}

		logger.info("Starting of verifyCreateSurveyGeneralTabDetailsByLeavingsurveyNameAndCategoryBlank method");
	}
	
	@Test(priority = 15, description = "Verify the General tab with valid details")
	@Description("Verify the General tab with valid details")
	@Severity(SeverityLevel.NORMAL)
	@Story("Test Case #15, Verify the General tab with valid details")
	public void verifyCreateSurveyGeneralTabDetailsByEnteringValidDetails() {
		logger.info("Starting of verifyCreateSurveyGeneralTabDetailsByEnteringValidDetails method");

		try {
			
			this.honoCreateSurveyPage.refresh();
			
			this.honoCreateSurveyPage.clickOnSurveyName(testDataProp.getProperty(SURVEY_NAME));
			
			this.honoCreateSurveyPage.clickOnSurveyCategory();

			this.honoCreateSurveyPage.clickOnEngagement();
			
			this.honoCreateSurveyPage.setExpiryDate(testDataProp.getProperty(EXPIRY_DATE));

			this.honoCreateSurveyPage.clickOnSaveButton();

			Assert.assertEquals(honoCreateSurveyPage.getGeneralToastText(),
					expectedAssertionsProp.getProperty(CHECK_YOUR_FIELD_TEXT));

		} catch (Exception e) {
			Assert.fail("Exception occured while testing verifyCreateSurveyGeneralTabDetailsByEnteringValidDetails : " + e.getMessage());
			logger.error("Error occured while verifyCreateSurveyGeneralTabDetailsByEnteringValidDetails " + e);
		}

		logger.info("Starting of verifyCreateSurveyGeneralTabDetailsByEnteringValidDetails method");
	}

	@Test(priority = 16, description = "Verify the Add  Language functionality by selecting all languages in the General tab")
	@Description("Verify the Add  Language functionality by selecting all languages in the General tab ")
	@Severity(SeverityLevel.NORMAL)
	@Story("Test Case #16, Verify the Add  Language functionality by selecting all languages in the General tab ")
	public void verifyCreateSurveyGeneralTabDetailsByAddAllLanguage() {
		logger.info("Starting of verifyCreateSurveyGeneralTabDetailsByAddAllLanguage method");

		try {
			
			this.honoCreateSurveyPage.refresh();
			
			this.honoCreateSurveyPage.clickOnSurveyName(testDataProp.getProperty(SURVEY_NAME));

			this.honoCreateSurveyPage.clickOnSurveyCategory();

			this.honoCreateSurveyPage.clickOnEngagement();
			
			this.honoCreateSurveyPage.clickOnSurveyDesc(testDataProp.getProperty(SURVEY_DESC));
			
			this.honoCreateSurveyPage.setExpiryDate(testDataProp.getProperty(EXPIRY_DATE));
			
			this.honoCreateSurveyPage.clickOnAddLanguage();
			
			this.honoCreateSurveyPage.clickOnSelectLanguage();

			this.honoCreateSurveyPage.clickOnSaveButton();

			//Assert.assertEquals(honoCreateSurveyPage.getGeneralToastText(),
					//expectedAssertionsProp.getProperty(CHECK_YOUR_FIELD_TEXT));

		} catch (Exception e) {
			Assert.fail("Exception occured while testing verifyCreateSurveyGeneralTabDetailsByAddAllLanguage : " + e.getMessage());
			logger.error("Error occured while verifyCreateSurveyGeneralTabDetailsByAddAllLanguage " + e);
		}

		logger.info("Starting of verifyCreateSurveyGeneralTabDetailsByAddAllLanguage method");
	}
}
