package Pages;

import Util.PageUtil;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;
import java.util.NoSuchElementException;

public class BasketPage extends PageUtil {

    private final By basketItems = By.className("pb-basket-item");

    public BasketPage(WebDriver driver) {
        super(driver);
    }

    public int countBasket() {
        try {
            List<WebElement> basketItemList = findElements(basketItems);
            return basketItemList.size();
        } catch (NoSuchElementException e) {
            return 0;
        }
    }
}
