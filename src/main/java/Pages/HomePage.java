package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

public class HomePage {
    private WebDriver driver;
    private WebDriverWait wait;
    private Actions action;


    private final By accountPanel = By.id("account-navigation-container");
    private final By getAccountPanelItem = By.className("loggedin-account-item");
    private final By accountBtn = By.xpath("//p[contains(text(),'Hesabım')]");
    private final By genderPopupContainer = By.id("popupContainer");
    private final By genderBtnWomen = By.xpath("//span[contains(text(),'KADIN')]");
    private final By genderBtnMan = By.xpath("//span[contains(text(),'ERKEK')]");
    private final By genderPopupCloseBtn = By.cssSelector(".fancybox-item.fancybox-close");


    public HomePage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        this.action = new Actions(driver);

    }


    public boolean validateLogin() {
        return driver.findElement(accountBtn).isDisplayed();

    }

    public String getPageTitle() {
        return driver.getTitle();
    }

    public void moveCursorToAccountBtn() {

        wait.until(ExpectedConditions.visibilityOfElementLocated(accountBtn));
        action.moveToElement(driver.findElement(accountBtn)).perform();
    }

    public boolean validateAccountDropdown() {

        return driver.findElement(accountPanel).isDisplayed();
    }

    public int getAccountDropdownCount() {
        return driver.findElements(getAccountPanelItem).size();
    }

    public List<String> getAccountDropdownList() {
        List<String> accountDropDown = new ArrayList<>();
        List<WebElement> accountDropDownItems = driver.findElements(getAccountPanelItem);

        for (WebElement e : accountDropDownItems) {
            String text = e.getText();
            accountDropDown.add(text);
        }
        return accountDropDown;
    }

    public boolean validateGenderPopUp() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(genderPopupContainer));
        return driver.findElement(genderPopupContainer).isDisplayed();
    }

    public boolean validateGenderButtonWomen() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(genderBtnWomen));
        return driver.findElement(genderBtnWomen).isDisplayed();
    }

    public boolean validateGenderButtonMan() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(genderBtnMan));
        return driver.findElement(genderBtnMan).isDisplayed();
    }

    public boolean validateCloseBtn() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(genderPopupCloseBtn));
        return driver.findElement(genderPopupCloseBtn).isDisplayed();
    }

    public boolean validateGenderPopupClosed() {
        wait.until(ExpectedConditions.invisibilityOfElementLocated(genderPopupContainer));
        return driver.findElement(genderPopupContainer).isDisplayed();
    }

    public void clickGenderPopupCloseBtn() {
        driver.findElement(genderPopupCloseBtn).click();
    }

    public void clickGenderGenderWomenBtn() {
        driver.findElement(genderBtnWomen).click();
    }

    public void clickGenderGenderManBtn() {
        driver.findElement(genderPopupCloseBtn).click();
    }
}

