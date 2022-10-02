package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import pageObjects.components.Popup;

public class SearchResultsPage extends Page {
    private String comprarTabSelector = "//a[text() = 'Comprar']";
    private String aplicacionesTabSelector = "a[aria-label*='Aplicaciones']";
    public Popup popup;

    public SearchResultsPage(WebDriver webDriver) {
        super(webDriver);
        popup = new Popup(webDriver);
    }

    public WebElement getComprarTab() {
        return this.findElementByXpath(comprarTabSelector);
    }

    public WebElement getAplicacionesTab() {
        return this.findElementByCss(aplicacionesTabSelector);
    }

    public void clickComprarTab() {
        this.clickOnElement(getComprarTab());
        popup.close();
    }

    public void clickAplicacionesTab() {
        this.clickOnElement(getAplicacionesTab());
        popup.close();
    }
}
