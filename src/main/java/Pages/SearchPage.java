package Pages;

import Util.PageUtil;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;
import java.util.Random;

public class SearchPage extends PageUtil {

    private final By searchProduct = By.className("p-card-wrppr");

    public SearchPage(WebDriver driver) {
        super(driver);
    }

    public void clickRandomSearchProduct() {
        Random rand = new Random();
        getSearchProductList().get(rand.nextInt(getSearchProductList().size())).click();
    }

    public List<WebElement> getSearchProductList() {
        return findElements(searchProduct);
    }
}
