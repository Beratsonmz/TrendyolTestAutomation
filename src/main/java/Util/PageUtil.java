package Util;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class PageUtil {
    WebDriver driver;
    WebDriverWait wait;
    Actions action;

    public PageUtil(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        this.action = new Actions(driver);
    }

    public WebDriver getWebdriver() {
        return driver;
    }

    public void waitUntilElementVisible(By by) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(by));
    }

    public void waitUntilElementInvisible(By by) {
        wait.until(ExpectedConditions.invisibilityOfElementLocated(by));
    }

    public List<WebElement> findElements(By by) {
        return driver.findElements(by);
    }

    public WebElement findElement(By by) {
        return driver.findElement(by);
    }

    public String pageTitle() {
        return driver.getTitle();
    }

    public Actions moveCursorToElement(By by) {
        return action.moveToElement(findElement(by));
    }

    public void click(By by) {
        findElement(by).click();
    }

    public boolean isElementDisplayed(By by) {
        try {
            waitUntilElementVisible(by);
        } catch (NoSuchElementException e) {
            return false;
        }
        return findElement(by).isDisplayed();
    }

    public boolean isElementDisappeared(By by) {
        try {
            waitUntilElementInvisible(by);
        } catch (NoSuchElementException e) {
            return true;
        }
        return findElement(by).isDisplayed();
    }

    public String getElementsText(By by) {
        return findElement(by).getText();
    }

    public void sendKeys(By by, String key) {
        findElement(by).sendKeys(key);
    }
}
