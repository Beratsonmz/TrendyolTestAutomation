package Pages;

import Util.PageUtil;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;
import java.util.Random;

public class BoutiquePage extends PageUtil {

    private final By activeTabLink = By.cssSelector(".active > .category-header");
    private final By categories = By.cssSelector(".slick-slide");

    public BoutiquePage(WebDriver driver) {
        super(driver);
    }

    public String getPageTitle() {
        return getPageTitle();
    }

    public String findActiveTabText() {
        waitUntilElementVisible(activeTabLink);
        return getElementsText(activeTabLink);
    }
    public List<WebElement> getCategoryLinks(){
        return findElements(categories);
    }
    public void clickRandomBoutique(){
        Random rand = new Random();
        getCategoryLinks().get(rand.nextInt(getCategoryLinks().size())).click();
    }
}
