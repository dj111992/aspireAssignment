package TestAutomation.pageObjects;

import TestAutomation.helpers.Browser;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import TestAutomation.helpers.BasePage;
import TestAutomation.helpers.Config;
import TestAutomation.helpers.WaitHelper;

import static TestAutomation.helpers.Config.url;

public class SauceDemoLoginPage extends BasePage
{
	@FindBy(id = "user-name")
	private WebElement userName;

	@FindBy(id = "password")
	private WebElement password;
	@FindBy(id = "login-button")
	private WebElement loginButton;
	
	Config testConfig;
	
	public SauceDemoLoginPage(Config testConfig)
	{
		PageFactory.initElements(testConfig.driver, this);
		this.testConfig = testConfig;
	}

	public void enterUsername(String text)
	{
		WaitHelper.waitForElementToBeDisplayed(testConfig, userName, "waiting for username field");
		enterData(testConfig, userName, text, "text is being entered to username here");
	}

	public void enterPassword(String text)
	{
		WaitHelper.waitForElementToBeDisplayed(testConfig, password, "waiting for password field");
		enterData(testConfig, password, text, "text is being entered to password here");
	}

	public void clickLoginButton()
	{
		WaitHelper.waitForElementToBeClickable(testConfig, loginButton, "waiting for Login button");
		click(testConfig, loginButton, "loginButton is being clicked here");
	}
}