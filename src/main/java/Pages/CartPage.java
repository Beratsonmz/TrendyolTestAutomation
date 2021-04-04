package Pages;

import Util.PageUtil;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;
import java.util.NoSuchElementException;

public class CartPage extends PageUtil {

    private final By cartItems = By.className("pb-basket-item");

    public CartPage(WebDriver driver) {
        super(driver);
    }

    public int countCart() {
        try {
            List<WebElement> cartItemList = findElements(cartItems);
            return cartItemList.size();
        } catch (NoSuchElementException e) {
            return 0;
        }
    }
}
