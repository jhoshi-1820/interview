package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import pageObjects.components.Popup;

import java.util.List;

public class AplicacionesPage extends Page {

    private String itemsListLocator = ".f-wrap-items [class*='-item'] h3";
    private String siguienteButtonSelector = "a[aria-label*='siguiente']";
    private String goToPageButtonSelector = "[aria-label*='página %s']";
    private String itemsPriceSelector = "[itemprop='price'][content*='$']";
    private Popup popup;

    public AplicacionesPage(WebDriver webDriver) {
        super(webDriver);
        popup = new Popup(webDriver);
    }

    public WebElement siguienteButton() {
        return this.findElementByCss(siguienteButtonSelector);
    }

    public List<WebElement> getItemsList() {
        return this.findElementsByCss(itemsListLocator);
    }

    public WebElement getFirstItemPrice() {
        return this.findElementByCss(itemsPriceSelector);
    }

    public WebElement goToPageButton(int pageNumber) {
        return this.findElementByCss(String.format(goToPageButtonSelector, pageNumber));
    }

    public void clickSiguienteButton() {
        this.clickOnElement(this.siguienteButton());
    }

    public void printItemsList() {
        for(WebElement element: getItemsList()) {
            this.logger.info(String.format("Artículo encontrado: %s", element.getText()));
        }
    }

    public void countItemsPerPage(int pagesNumber) {
        int totalItems = 0;

        for (int i = 0; i < pagesNumber; i++) {
			if (i != 0) {
                clickSiguienteButton();
                popup.close();
            }
			totalItems+=getItemsList().size();
			printItemsList();
		}

        this.logger.info(String.format("Cantidad Total de artículos: %d", totalItems));
    }

    public void goToPage(int pageNumber) {
        this.clickOnElement(goToPageButton(pageNumber));
        popup.close();
    }

    public void selectFirstItemWithPrice() {
        this.clickOnElement(getFirstItemPrice());
    }
}
