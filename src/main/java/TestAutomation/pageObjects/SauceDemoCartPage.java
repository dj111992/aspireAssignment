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

public class SauceDemoCartPage extends BasePage
{
	@FindBy(css = ".cart_item")
	private List<WebElement> cartItems;
	@FindBy(id = "checkout")
	private WebElement checkoutButton;
	private String itemDescription = ".cart_item_label";

	Config testConfig;

	public SauceDemoCartPage(Config testConfig)
	{
		PageFactory.initElements(testConfig.driver, this);
		this.testConfig = testConfig;
	}

	public int getCartItems(String text)
	{
		WaitHelper.waitForElementToBeDisplayed(testConfig, cartItems.get(0), "waiting for cart items");
		List<WebElement> reqElement = cartItems.stream().
				filter(e -> e.findElement(By.cssSelector(itemDescription)).getText().contains(text)).collect(Collectors.toList());

		return reqElement.size();
	}

	public void clickCheckoutButton()
	{
		WaitHelper.waitForElementToBeClickable(testConfig, checkoutButton, "waiting for checkout button");
		click(testConfig, checkoutButton, "checkout button is being clicked here");
	}
}