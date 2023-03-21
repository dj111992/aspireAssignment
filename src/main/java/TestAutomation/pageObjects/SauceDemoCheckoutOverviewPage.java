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

public class SauceDemoCheckoutOverviewPage extends BasePage
{
	@FindBy(css = ".cart_item")
	private List<WebElement> cartItems;

	@FindBy(css = ".summary_subtotal_label")
	private WebElement itemTotal;

	@FindBy(css = ".summary_tax_label")
	private WebElement itemTax;

	@FindBy(css = ".summary_total_label")
	private WebElement itemFinalTotal;

	@FindBy(id = "finish")
	private WebElement finishButton;

	private String item_name = ".inventory_item_name";

	Config testConfig;

	public SauceDemoCheckoutOverviewPage(Config testConfig)
	{
		PageFactory.initElements(testConfig.driver, this);
		this.testConfig = testConfig;
	}

	public int getCheckoutDescriptionItems(String text)
	{
		WaitHelper.waitForElementToBeDisplayed(testConfig, cartItems.get(0), "waiting for cart items");
		List<WebElement> reqElement = cartItems.stream().
				filter(e -> e.findElement(By.cssSelector(item_name)).getText().contains(text)).collect(Collectors.toList());

		return reqElement.size();
	}

	public String getItemPrice()
	{
		WaitHelper.waitForElementToBeDisplayed(testConfig, itemTotal, "waiting for item price");

		return itemTotal.getText();
	}

	public String getItemTax()
	{
		WaitHelper.waitForElementToBeDisplayed(testConfig, itemTax, "waiting for item tax");

		return itemTax.getText();
	}

	public String getItemFinalTotal()
	{
		WaitHelper.waitForElementToBeDisplayed(testConfig, itemFinalTotal, "waiting for item final total");

		return itemFinalTotal.getText();
	}

	public void clickFinishButton()
	{
		WaitHelper.waitForElementToBeClickable(testConfig, finishButton, "waiting for finish button field");
		click(testConfig, finishButton, "finish button is clicked here");
	}
}
