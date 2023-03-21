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

@FindBy(id= "checkout_complete_container")
public class SauceDemoFinalThankYouPage extends BasePage
{
	@FindBy(className = "complete-header")
	private WebElement completeHeader;

	@FindBy(className = "complete-text")
	private WebElement completeDescription;

	@FindBy(css = "[alt='Pony Express']")
	private WebElement completeImage;

	Config testConfig;

	public SauceDemoFinalThankYouPage(Config testConfig)
	{
		PageFactory.initElements(testConfig.driver, this);
		this.testConfig = testConfig;
	}

	public String getCheckoutTitle()
	{
		WaitHelper.waitForElementToBeDisplayed(testConfig, completeHeader, "waiting for checkout header");

		return completeHeader.getText();
	}

	public String getCompleteDescription()
	{
		WaitHelper.waitForElementToBeDisplayed(testConfig, completeDescription, "waiting for checkout description");

		return completeDescription.getText();
	}

	public String getImageSrc()
	{
		WaitHelper.waitForElementToBeDisplayed(testConfig, completeImage, "waiting for checkout Image");

		return completeImage.getAttribute("src");
	}
}
