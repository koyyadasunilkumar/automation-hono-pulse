package com.honohr.pulse.createsurvey.pages;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.honohr.pulse.base.pages.BaseHonoPulseAutomationPage;

public class HonoPulseCreateServeyDesignPage extends BaseHonoPulseAutomationPage {

	@FindBy(xpath = "//div[@class='col-lg-3 right_tabstypeform right-canvas']//a[text()='Design']")
	private WebElement btnDesignTab;

	@FindBy(xpath = "//div[@id='design-welcome-and-thankyou']//select[@formcontrolname=\"st_layout\"]")
	private WebElement btnLayOutDropDown;

	@FindBy(xpath = "//label[text()='Button']")
	private WebElement lblButton;

	@FindBy(xpath = "//div[@class='col-lg-12 questions_ntn']//button[text()=' Save ']")
	private WebElement btnSave;

	private static final Logger logger = Logger.getLogger(HonoPulseCreateServeyDesignPage.class.getName());

	public HonoPulseCreateServeyDesignPage(WebDriver driver) {
		super(driver);
		logger.info("Starting of DesignTabPage method");

		PageFactory.initElements(driver, this);

		logger.info("Ending of DesignTabPage method");
	}

	public synchronized void clickOnDesignTabButton() {
		logger.info("Starting of clickOnDesignTabButton Method");

		explicitWait(btnDesignTab);
		try {
			clickOnWebElement(btnDesignTab);

		} catch (Exception e) {
			this.btnDesignTab.click();
		}
		logger.info("Ending of clickOnDesignTabButton Method");
	}

	public synchronized String getDesignTabButtonText() {

		logger.info("Starting of getDesignTabButtonText Method");
		logger.info("Ending of clickOnDesignTabButton Method");

		return btnDesignTab.getText();

	}

	public synchronized void clickOnSaveButton() {
		logger.info("Starting of clickOnSaveButton Method");

		try {
			this.waitForElementToBeClikable(btnSave);
			clickOnWebElement(btnSave);
		} catch (Exception e) {
			this.btnSave.click();
		}

		logger.info("Ending of clickOnSaveButton Method");
	}
}
