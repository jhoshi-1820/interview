package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class WindowsPage extends Page {

    private String searchInputSelector = "cli_shellHeaderSearchInput";
    private String searchIconSelector = "search";

    public WindowsPage (WebDriver webDriver) {
        super(webDriver);
    }

    public WebElement getSearchInput() {
        return this.findElementByID(searchInputSelector);
    }

    public WebElement getSearchIcon() {
        return this.findElementByID(searchIconSelector);
    }

    public void clickSearchIcon() {
        this.clickOnElement(getSearchIcon());
    }

    public void search(String keyword) {
        this.setText(getSearchInput(), keyword);
        this.clickSearchIcon();
    }
}
