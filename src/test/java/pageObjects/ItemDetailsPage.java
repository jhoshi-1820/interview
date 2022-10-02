package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ItemDetailsPage extends Page {

    private String itemPriceLabelSelector = "[style*='line-through']:first-of-type + span";

    public ItemDetailsPage(WebDriver webDriver) {
        super(webDriver);
    }

    public WebElement getItemPriceLabel() {
        return this.findElementByCss(itemPriceLabelSelector);
    }
}
