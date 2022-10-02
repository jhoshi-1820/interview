package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;
import java.util.logging.Logger;

public class Page {
    private WebDriver webDriver;
    private Duration duration;
    private WebDriverWait wait;
    public Logger logger = Logger.getLogger("WindowsPageLog");

    public Page(WebDriver webDriver) {
        this.webDriver = webDriver;
        this.duration = Duration.ofSeconds(20);
        this.wait = new WebDriverWait(webDriver, duration);
    }

    public void clickOnElement(WebElement element) {
        wait.until(ExpectedConditions.visibilityOf(element));
        element.click();
    }

    public void waitUntilElementIsNotVisible(WebElement element) {
        this.wait.until(ExpectedConditions.invisibilityOf(element));
    }

    public WebElement findElementByID(String locator) {
        return this.webDriver.findElement(By.id(locator));
    }

    public WebElement findElementByXpath(String locator) {
        return this.webDriver.findElement(By.xpath(locator));
    }

    public WebElement findElementByCss(String locator) {
        return this.webDriver.findElement(By.cssSelector(locator));
    }

    public List<WebElement> findElementsByCss(String locator) {
        return this.webDriver.findElements(By.cssSelector(locator));
    }

    public void setText(WebElement element, String text) {
        wait.until(ExpectedConditions.visibilityOf(element));
        element.sendKeys(text);
    }
}
