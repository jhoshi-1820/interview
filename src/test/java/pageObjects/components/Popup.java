package pageObjects.components;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import pageObjects.Page;

public class Popup extends Page {
    private String closePopupButtonSelector = "[aria-label='Cancelar']";

    public Popup(WebDriver webDriver) {
        super(webDriver);
    }

    public WebElement getClosePopupButton() {
        return this.findElementByCss(closePopupButtonSelector);
    }

    public void close() {
        this.clickOnElement(getClosePopupButton());
        this.waitUntilElementIsNotVisible(getClosePopupButton());
    }
}
