package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;


import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import Util.PageUtil;

public class HomePage extends PageUtil {


    private final By accountPanel = By.id("account-navigation-container");
    private final By getAccountPanelItem = By.className("loggedin-account-item");
    private final By accountBtn = By.xpath("//p[contains(text(),'Hesabım')]");
    private final By genderPopupContainer = By.id("popupContainer");
    private final By genderBtnWomen = By.xpath("//span[contains(text(),'KADIN')]");
    private final By genderBtnMan = By.xpath("//span[contains(text(),'ERKEK')]");
    private final By genderPopupCloseBtn = By.cssSelector(".fancybox-item.fancybox-close");
    private final By boutiqueLinks = By.className("tab-link");

    public HomePage(WebDriver driver) {
        super(driver);
    }

    public boolean validateLogin() {
        return isElementDisplayed(accountBtn);
    }

    public String getPageTitle() {
        return pageTitle();
    }

    public void moveCursorToAccountBtn() {
        waitUntilElementVisible(accountBtn);
        moveCursorToElement(accountBtn).perform();
    }

    public boolean validateAccountDropdown() {
        return isElementDisplayed(accountPanel);
    }
    public boolean validateGenderPopupClosed(){
        return isElementDissapeared(genderPopupContainer);
    }

    public int getAccountDropdownCount() {
        return findElements(getAccountPanelItem).size();
    }

    public List<String> getAccountDropdownList() {
        List<String> accountDropDown = new ArrayList<>();
        List<WebElement> accountDropDownItems = findElements(getAccountPanelItem);

        for (WebElement e : accountDropDownItems) {
            String text = e.getText();
            accountDropDown.add(text);
        }
        return accountDropDown;
    }
    public List<WebElement>getBoutiuqeLinks(){
        return findElements(boutiqueLinks);
    }
    public void clickRandomBoutique(){
        Random rand = new Random();
        getBoutiuqeLinks().get(rand.nextInt(getBoutiuqeLinks().size())).click();
    }

    public boolean validateGenderPopUp() {
        return isElementDisplayed(genderPopupContainer);
    }

    public boolean validateGenderButtonWomen() {
        return isElementDisplayed(genderBtnWomen);
    }

    public boolean validateGenderButtonMan() {
        return isElementDisplayed(genderBtnMan);
    }

    public boolean validateCloseBtn() {
        return isElementDisplayed(genderPopupCloseBtn);
    }

    public void clickGenderPopupCloseBtn() {
        click(genderPopupCloseBtn);
    }

    public void clickGenderGenderWomenBtn() {
        click(genderBtnWomen);
    }

    public void clickGenderGenderManBtn() {
        click(genderPopupCloseBtn);
    }
}

