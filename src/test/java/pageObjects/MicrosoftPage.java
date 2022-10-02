package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class MicrosoftPage extends Page {

    private String windowsButtonSelector = "search";

    public MicrosoftPage(WebDriver webDriver) {
        super(webDriver);
    }

    public WebElement getWindowsButton() {
        return this.findElementByID(this.windowsButtonSelector);
    }

    public void clickWindowsButton() {
        this.clickOnElement(getWindowsButton());
    }
}
