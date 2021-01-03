package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class BoutiquePage {
    private WebDriver driver;
    private WebDriverWait wait;

    private final By activeTabLink = By.cssSelector(".active > .category-header");

    public BoutiquePage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    public String getPageTitle() {
        return driver.getTitle();
    }

    public String findActiveTabText() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(activeTabLink));
        String activeTabText = driver.findElement(activeTabLink).getText();
        return activeTabText;
    }
}
