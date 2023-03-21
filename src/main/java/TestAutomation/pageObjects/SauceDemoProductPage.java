package TestAutomation.pageObjects;

import TestAutomation.helpers.BasePage;
import TestAutomation.helpers.Config;
import TestAutomation.helpers.WaitHelper;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class SauceDemoProductPage extends BasePage
{
	@FindBy(css = ".inventory_list .inventory_item")
	private List<WebElement> inventoryItems;
	@FindBy(className = "shopping_cart_link")
	private WebElement shoppingCartLink;
	private String itemDescription = ".inventory_item_description";
	private String addToCartButton = "#add-to-cart-";

	Config testConfig;

	public SauceDemoProductPage(Config testConfig)
	{
		PageFactory.initElements(testConfig.driver, this);
		this.testConfig = testConfig;
	}

	public void clickElementWithText(Config testConfig, String text)
	{
		String buttonText = text.toLowerCase().replace(" ", "-");
		WaitHelper.waitForElementToBeDisplayed(testConfig, inventoryItems.get(0), "waiting for inventory items");
		WebElement reqElement = inventoryItems.stream().
				filter(e -> e.findElement(By.cssSelector(itemDescription)).getText().contains(text)).findFirst().get();
		click(testConfig, reqElement.findElement(By.cssSelector(addToCartButton + buttonText)), "Clicking the add cart button for specific item");
	}

	public void clickShoppingCartLinkButton()
	{
		WaitHelper.waitForElementToBeClickable(testConfig, shoppingCartLink, "waiting for shopping Cart Link button");
		click(testConfig, shoppingCartLink, "shopping Cart Link is being clicked here");
	}
}