package com.honohr.pulse.configuration.test;

import static com.honohr.pulse.util.Constants.*;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.springframework.context.annotation.Description;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.honohr.pulse.base.test.BaseHonoPulseAutomationTest;
import com.honohr.pulse.configuration.pages.HonohrPulseCreateSurveyDefineEngagementParameterPage;

import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Story;

@Epic("Hono Pulse Create Survey")
@Feature("Define Configuration Engagement Parameter")
public class HonohrPulseCreateSurveyDefineEngagementParameterTwoTest extends BaseHonoPulseAutomationTest {
	
	private WebDriver driver = null;

	private HonohrPulseCreateSurveyDefineEngagementParameterPage honoEngagementParameterPage = null;

	private static final Logger logger = Logger.getLogger(HonohrPulseCreateSurveyDefineEngagementParameterTwoTest.class.getName());

	@BeforeTest
	@Parameters({ "browser", "siteURL", "emailAddress", "password" })
	public void initMethodTest(String browser, String siteURL, String emailAddress, String password) throws Exception {
		logger.info("Starting of initMethodTest method");

		this.driver = this.getWebDriver(browser);
		this.loginToHono(browser, siteURL, emailAddress, password, this.driver);
		
		//honoLoginPage = new HonohrPulseLoginPage(driver);
		
		honoEngagementParameterPage = new HonohrPulseCreateSurveyDefineEngagementParameterPage(driver);

		logger.info("Ending of initMethodTest method");
	}
	
	@Test(priority = 1, description = "Verify Configuration")
	@Description("Test Case #1, Verify Configuration")
	@Severity(SeverityLevel.NORMAL)
	@Story("Test Case #1, Verify Configuration")
	public void verifyConfiguration() {
		logger.info("Starting of verifyConfiguration method");

		try {

			honoEngagementParameterPage.clickOnConfigurationButton();

			honoEngagementParameterPage.clickOnEngagementParameter();

			honoEngagementParameterPage.clickOnAddParameterButton();

		} catch (Exception e) {
			Assert.fail("Exception occured while testing verifyConfiguration : " + e.getMessage());
			logger.error("Error occured while verifyConfiguration " + e);
		}

		logger.info("Starting of verifyConfiguration method");
	}
	
	@Test(priority = 2, description = "Verify Add New Engagement Parameter functionality with empty fields")
	@Description("Test Case #2, Verify Add New Engagement Parameter functionality with empty fields")
	@Severity(SeverityLevel.NORMAL)
	@Story("Test Case #2, Verify Add New Engagement Parameter functionality with empty fields")
	public void verifyAddNewEngagementParameterWithEmptyFields() {
		logger.info("Starting of verifyAddNewEngagementParameterWithEmptyFields method");

		try {
	
			honoEngagementParameterPage.setParameterName("");
			
			honoEngagementParameterPage.setScaleStartValue("");
			
			honoEngagementParameterPage.setScaleEndValue("");

			honoEngagementParameterPage.clickOnSaveButton();
			
			honoEngagementParameterPage.clickOnCloseButton();

		} catch (Exception e) {
			Assert.fail("Exception occured while testing verifyAddNewEngagementParameterWithEmptyFields : " + e.getMessage());
			logger.error("Error occured while verifyAddNewEngagementParameterWithEmptyFields " + e);
		}

		logger.info("Starting of verifyAddNewEngagementParameterWithEmptyFields method");
	}

	@Test(priority = 3, description = "Verify Add New Engagement Parameter functionality by leaving scale start & end values blank")
	@Description("Test Case #3, Verify Add New Engagement Parameter functionality by leaving scale start & end values blank")
	@Severity(SeverityLevel.NORMAL)
	@Story("Test Case #3, Verify Add New Engagement Parameter functionality by leaving scale start & end values blank")
	public void verifyAddNewEngagementParameterWithOnlyEngagementParameterName() {
		logger.info("Starting of verifyAddNewEngagementParameterWithOnlyEngagementParameterName method");

		try {
			
			honoEngagementParameterPage.clickOnAddParameterButton();
			
			honoEngagementParameterPage.setEngParamValue(testDataProp.getProperty(ADD_NEW_ENGAGEMENT_PARAMETER_TEXT));
			
			honoEngagementParameterPage.clickOnSaveButton();
			
		} catch (Exception e) {
			Assert.fail("Exception occured while testing verifyAddNewEngagementParameterWithOnlyEngagementParameterName : " + e.getMessage());
			logger.error("Error occured while verifyAddNewEngagementParameterWithOnlyEngagementParameterName " + e);
		}

		logger.info("Starting of verifyAddNewEngagementParameterWithOnlyEngagementParameterName method");
	}
	
	@Test(priority = 4, description = "verifyAddNewEngagementParameterWithoutEngagementParameterName")
	@Description("Test Case #4, verifyAddNewEngagementParameterWithoutEngagementParameterName")
	@Severity(SeverityLevel.NORMAL)
	@Story("Test Case #4, verifyAddNewEngagementParameterWithoutEngagementParameterName")
	public void verifyAddNewEngagementParameterWithoutEngagementParameterName() {
		logger.info("Starting of verifyAddNewEngagementParameterWithoutEngagementParameterName method");

		try {
			honoEngagementParameterPage.clickOnCloseButton();
			
			//honoEngagementParameterPage.refresh();
			
			honoEngagementParameterPage.clickOnAddParameterButton();
			
			honoEngagementParameterPage.setScaleStartValueTwo(testDataProp.getProperty(SCALE_START_VALUE));
			
			honoEngagementParameterPage.setScaleEndValueTwo(testDataProp.getProperty(SCALE_END_VALUE));

			honoEngagementParameterPage.clickOnSaveButton();
			

		} catch (Exception e) {
			Assert.fail("Exception occured while testing verifyAddNewEngagementParameterWithoutEngagementParameterName : " + e.getMessage());
			logger.error("Error occured while verifyAddNewEngagementParameterWithoutEngagementParameterName " + e);
		}

		logger.info("Starting of verifyAddNewEngagementParameterWithoutEngagementParameterName method");
	}
	
	@Test(priority = 5, description = "Verify Add New Engagement Parameter functionality by leaving the Scale End Value field blank")
	@Description("Test Case #5, Verify Add New Engagement Parameter functionality by leaving the Scale End Value field blank")
	@Severity(SeverityLevel.NORMAL)
	@Story("Test Case #5, Verify Add New Engagement Parameter functionality by leaving the Scale End Value field blank")
	public void verifyAddNewEngagementParameterWithoutScaleEndValue() {
		logger.info("Starting of verifyAddNewEngagementParameterWithoutEngagementParameterName method");

		try {
			honoEngagementParameterPage.clickOnCloseButton();
			
			honoEngagementParameterPage.refresh();
			
			honoEngagementParameterPage.clickOnAddParameterButton();
			
			honoEngagementParameterPage.setParamValue(testDataProp.getProperty(ADD_NEW_ENGAGEMENT_PARAMETER_TEXT));
			
			honoEngagementParameterPage.setScaleStartValueText(testDataProp.getProperty(SCALE_START_VALUE));

			honoEngagementParameterPage.clickOnSaveButton();
		

		} catch (Exception e) {
			Assert.fail("Exception occured while testing verifyAddNewEngagementParameterWithoutScaleEndValue : " + e.getMessage());
			logger.error("Error occured while verifyAddNewEngagementParameterWithoutScaleEndValue " + e);
		}

		logger.info("Starting of verifyAddNewEngagementParameterWithoutScaleEndValue method");
	}
	
	@Test(priority = 6, description = "Verify Add New Engagement Parameter functionality by leaving the Scale Start Value field blank")
	@Description("Test Case #6, Verify Add New Engagement Parameter functionality by leaving the Scale Start Value field blank")
	@Severity(SeverityLevel.NORMAL)
	@Story("Test Case #6, Verify Add New Engagement Parameter functionality by leaving the Scale Start Value field blank")
	public void verifyAddNewEngagementParameterWithoutScaleStartValue() {
		logger.info("Starting of verifyAddNewEngagementParameterWithoutScaleStartValue method");

		try {
			honoEngagementParameterPage.clickOnCloseButton();
			
			honoEngagementParameterPage.refresh();
			
			honoEngagementParameterPage.clickOnAddParameterButton();
			
			honoEngagementParameterPage.setParamValue(testDataProp.getProperty(ADD_NEW_ENGAGEMENT_PARAMETER_TEXT));
			
			honoEngagementParameterPage.setScaleEndValueText(testDataProp.getProperty(SCALE_END_VALUE));
			
			honoEngagementParameterPage.clickOnSaveButton();
			
			honoEngagementParameterPage.clickOnCloseButton();
		} catch (Exception e) {
			Assert.fail("Exception occured while testing verifyAddNewEngagementParameterWithoutScaleStartValue : " + e.getMessage());
			logger.error("Error occured while verifyAddNewEngagementParameterWithoutScaleStartValue " + e);
		}

		logger.info("Starting of verifyAddNewEngagementParameterWithoutScaleStartValue method");
	}

	@Test(priority = 7, description = "Verify Add New Engagement Parameter functionality by giving Engagement Parameter Name ,the Scale Start and the scale End Values")
	@Description("Test Case #7, Verify Add New Engagement Parameter functionality by giving Engagement Parameter Name ,the Scale Start and the scale End Values")
	@Severity(SeverityLevel.NORMAL)
	@Story("Test Case #7, Verify Add New Engagement Parameter functionality by giving Engagement Parameter Name ,the Scale Start and the scale End Values")
	public void verifyAddNewEngagementParameterWithAllValues() {
		logger.info("Starting of verifyAddNewEngagementParameterWithAllValues method");

		try {
			honoEngagementParameterPage.refresh();
			
			honoEngagementParameterPage.clickOnAddParameterButton();
			
			honoEngagementParameterPage.setParamValue(testDataProp.getProperty(ADD_NEW_ENGAGEMENT_PARAMETER_TEXT));
			
			honoEngagementParameterPage.setScaleStartValueText(testDataProp.getProperty(SCALE_START_VALUE));
			
			honoEngagementParameterPage.setScaleEndValueText(testDataProp.getProperty(SCALE_END_VALUE));

			honoEngagementParameterPage.clickOnSaveButton();
			

		} catch (Exception e) {
			Assert.fail("Exception occured while testing verifyAddNewEngagementParameterWithAllValues : " + e.getMessage());
			logger.error("Error occured while verifyAddNewEngagementParameterWithAllValues " + e);
		}

		logger.info("Starting of verifyAddNewEngagementParameterWithAllValues method");
	}
	
	@Test(priority = 8, description = "Verify add new sub parameter")
	@Description("Test Case #8, Verify add new sub parameter")
	@Severity(SeverityLevel.NORMAL)
	@Story("Test Case #8,Verify add new sub parameter")
	public void verifyAddNewSubParameter() {
		logger.info("Starting of verifyAddNewSubParameter method");

		try {
			honoEngagementParameterPage.refresh();
			
			honoEngagementParameterPage.clickOnAddSubParameterButton();

		} catch (Exception e) {
			Assert.fail("Exception occured while testing verifyAddNewSubParameter : " + e.getMessage());
			logger.error("Error occured while verifyAddNewSubParameter " + e);
		}

		logger.info("Starting of verifyAddNewSubParameter method");
	}
	
	@Test(priority = 9, description = "Verify Add New Sub Parameter Functionality by leaving the Engagement Parameter field blank")
	@Description("Test Case #9, Verify Add New Sub Parameter Functionality by leaving the Engagement Parameter field blank")
	@Severity(SeverityLevel.NORMAL)
	@Story("Test Case #9, Verify Add New Sub Parameter Functionality by leaving the Engagement Parameter field blank")
	public void verifyAddNewSubParameterByLeavingEngagementparameter() {
		logger.info("Starting of verifyAddNewSubParameterByLeavingEngagementparameter method");

		try {
			Thread.sleep(1000);
			honoEngagementParameterPage.clickOnSubParameterSaveButton();
			
			honoEngagementParameterPage.clickOnSubParameterCloseButton();

		} catch (Exception e) {
			Assert.fail("Exception occured while testing verifyAddNewSubParameterByLeavingEngagementparameter : " + e.getMessage());
			logger.error("Error occured while verifyAddNewSubParameterByLeavingEngagementparameter " + e);
		}

		logger.info("Starting of verifyAddNewSubParameterByLeavingEngagementparameter method");
	}
	
	@Test(priority = 10, description = "Verify Add New Sub Parameter Functionality by giving the Engagement Parameter name")
	@Description("Test Case #10, Verify Add New Sub Parameter Functionality by giving the Engagement Parameter name")
	@Severity(SeverityLevel.NORMAL)
	@Story("Test Case #10, Verify Add New Sub Parameter Functionality by giving the Engagement Parameter name")
	public void verifyAddNewSubParameterByGivingEngagementParameterName() {
		logger.info("Starting of verifyAddNewSubParameterByLeavingEngagementparameter method");

		try {
			honoEngagementParameterPage.refresh();
			
			honoEngagementParameterPage.clickOnAddSubParameterButton();


			honoEngagementParameterPage.setSubEngagementParameterText(testDataProp.getProperty(ADD_NEW_ENGAGEMENT_PARAMETER_TEXT));

			honoEngagementParameterPage.clickOnSubParameterSaveButton();

		} catch (Exception e) {
			Assert.fail("Exception occured while testing verifyAddNewSubParameterByLeavingEngagementparameter : " + e.getMessage());
			logger.error("Error occured while verifyAddNewSubParameterByLeavingEngagementparameter " + e);
		}

		logger.info("Starting of verifyAddNewSubParameterByLeavingEngagementparameter method");
	}
	
	@Test(priority = 11, description = "Verify Update Engagement Parameter functionality by leaving the Engagement Parameter field blank")
	@Description("Test Case #11, Verify Update Engagement Parameter functionality by leaving the Engagement Parameter field blank")
	@Severity(SeverityLevel.NORMAL)
	@Story("Test Case #11, Verify Update Engagement Parameter functionality by leaving the Engagement Parameter field blank")
	public void verifyUpdateEngagementParameterNameWithEmptyValue() {
		logger.info("Starting of verifyUpdateEngagementParameterNameWithEmptyValue method");

		try {

			honoEngagementParameterPage.clickOnUpdateEngagementParameterButton();

			honoEngagementParameterPage.clickOnEngParameterName();

			honoEngagementParameterPage.clickOnUpdateButton();

			//honoEngagementParameterPage.clickOnUpdateCloseButton();

		} catch (Exception e) {
			Assert.fail("Exception occured while testing verifyUpdateEngagementParameterNameWithEmptyValue : " + e.getMessage());
			logger.error("Error occured while verifyUpdateEngagementParameterNameWithEmptyValue " + e);
		}

		logger.info("Starting of verifyUpdateEngagementParameterNameWithEmptyValue method");
	}

	@Test(priority = 12, description = "Verify Update Engagement Parameter functionality by leaving the Scale Start Value field blank")
	@Description("Test Case #12, Verify Update Engagement Parameter functionality by leaving the Scale Start Value field blank")
	@Severity(SeverityLevel.NORMAL)
	@Story("Test Case #12, Verify Update Engagement Parameter functionality by leaving the Scale Start Value field blank")
	public void verifyUpdateEngagementParameterWithEmptyScaleStartValue() {
		logger.info("Starting of verifyUpdateEngagementParameterWithEmptyScaleStartValue method");

		try {
			honoEngagementParameterPage.refresh();
			
			honoEngagementParameterPage.clickOnUpdateEngagementParameterButton();
			
			honoEngagementParameterPage.clickOnScaleStartValue();
			
			honoEngagementParameterPage.clickOnUpdateButton();
			
			//honoEngagementParameterPage.clickOnUpdateCloseButton();

		} catch (Exception e) {
			Assert.fail("Exception occured while testing verifyUpdateEngagementParameterWithEmptyScaleStartValue : " + e.getMessage());
			logger.error("Error occured while verifyUpdateEngagementParameterWithEmptyScaleStartValue " + e);
		}

		logger.info("Starting of verifyUpdateEngagementParameterWithEmptyScaleStartValue method");
	}
	
	@Test(priority = 13, description = "Verify Update Engagement Parameter functionality by leaving the Scale End Value field blank")
	@Description("Test Case #13, Verify Update Engagement Parameter functionality by leaving the Scale End Value field blank")
	@Severity(SeverityLevel.NORMAL)
	@Story("Test Case #13, Verify Update Engagement Parameter functionality by leaving the Scale End Value field blank")
	public void verifyUpdateEngagementParameterWithEmptyScaleEndValue() {
		logger.info("Starting of verifyUpdateEngagementParameterWithEmptyScaleEndValue method");

		try {
			honoEngagementParameterPage.refresh();
			
			honoEngagementParameterPage.clickOnUpdateEngagementParameterButton();
			
			honoEngagementParameterPage.clickOnScaleEndValue();
			
			honoEngagementParameterPage.clickOnUpdateButton();
			
			//honoEngagementParameterPage.clickOnUpdateCloseButton();

		} catch (Exception e) {
			Assert.fail("Exception occured while testing verifyUpdateEngagementParameterWithEmptyScaleEndValue : " + e.getMessage());
			logger.error("Error occured while verifyUpdateEngagementParameterWithEmptyScaleEndValue " + e);
		}

		logger.info("Starting of verifyUpdateEngagementParameterWithEmptyScaleEndValue method");
	}
	
	@Test(priority = 14, description = "Verify Update Engagement Parameter functionality by leaving the Scale Start and End Value fields blank")
	@Description("Test Case #14, Verify Update Engagement Parameter functionality by leaving the Scale Start and End Value fields blank")
	@Severity(SeverityLevel.NORMAL)
	@Story("Test Case #14, Verify Update Engagement Parameter functionality by leaving the Scale Start and End Value fields blank")
	public void verifyUpdateEngagementParameterWithEmptyScaleStartAndEndValues() {
		logger.info("Starting of verifyUpdateEngagementParameterWithEmptyScaleStartAndEndValues method");

		try {
			honoEngagementParameterPage.refresh();
			
			honoEngagementParameterPage.clickOnUpdateEngagementParameterButton();
			
			honoEngagementParameterPage.clickOnScaleStartValue();
			
			honoEngagementParameterPage.clickOnScaleEndValue();
			
			honoEngagementParameterPage.clickOnUpdateButton();
			
			//honoEngagementParameterPage.clickOnUpdateCloseButton();

		} catch (Exception e) {
			Assert.fail("Exception occured while testing verifyUpdateEngagementParameterWithEmptyScaleStartAndEndValues : " + e.getMessage());
			logger.error("Error occured while verifyUpdateEngagementParameterWithEmptyScaleStartAndEndValues " + e);
		}

		logger.info("Starting of verifyUpdateEngagementParameterWithEmptyScaleStartAndEndValues method");
	}
}