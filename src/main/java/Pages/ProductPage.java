package Pages;

import Util.PageUtil;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ProductPage extends PageUtil {

    private final By addToBasketBtn = By.cssSelector(".add-to-bs-tx");
    private final By basketBtn = By.xpath("//p[contains(text(),'Sepetim')]");
    public ProductPage(WebDriver driver) {
        super(driver);
    }

    public void addToBasket() {
        click(addToBasketBtn);
    }
    public void goToBucket(){
        click(basketBtn);
    }
}
