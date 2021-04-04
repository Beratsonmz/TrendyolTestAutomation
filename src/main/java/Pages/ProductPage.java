package Pages;

import Util.PageUtil;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ProductPage extends PageUtil {

    private final By addToCartBtn = By.cssSelector(".add-to-bs-tx");
    private final By cartBtn = By.xpath("//p[contains(text(),'Sepetim')]");
    public ProductPage(WebDriver driver) {
        super(driver);
    }

    public void addToCart() {
        click(addToCartBtn);
    }
    public void goToCart(){
        click(cartBtn);
    }
}
