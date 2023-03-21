package TestAutomation.pageObjects;

import TestAutomation.helpers.BasePage;
import TestAutomation.helpers.Config;
import TestAutomation.helpers.WaitHelper;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;
import java.util.stream.Collectors;

public class SauceDemoCheckoutUserDetailsPage extends BasePage
{
	@FindBy(id = "first-name")
	private WebElement firstName;

	@FindBy(id = "last-name")
	private WebElement lastName;
	@FindBy(id = "postal-code")
	private WebElement postalCode;

	@FindBy(id = "continue")
	private WebElement continueButton;

	Config testConfig;

	public SauceDemoCheckoutUserDetailsPage(Config testConfig)
	{
		PageFactory.initElements(testConfig.driver, this);
		this.testConfig = testConfig;
	}

	public void enterFirstname(String text)
	{
		WaitHelper.waitForElementToBeDisplayed(testConfig, firstName, "waiting for firstname field");
		enterData(testConfig, firstName, text, "text is being entered to firstName here");
	}

	public void enterLastname(String text)
	{
		WaitHelper.waitForElementToBeDisplayed(testConfig, lastName, "waiting for lastName field");
		enterData(testConfig, lastName, text, "text is being entered to lastName here");
	}

	public void enterPostalCode(String text)
	{
		WaitHelper.waitForElementToBeDisplayed(testConfig, postalCode, "waiting for postalCode field");
		enterData(testConfig, postalCode, text, "text is being entered to postalCode here");
	}

	public void clickContinueButton()
	{
		WaitHelper.waitForElementToBeClickable(testConfig, continueButton, "waiting for continueButton field");
		click(testConfig, continueButton, "continue Button is clicked here");
	}
}
