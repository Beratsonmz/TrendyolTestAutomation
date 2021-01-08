package Parallel.StepDefinitions;

import Factory.DriverFactory;
import Pages.ProductPage;
import io.cucumber.java.en.Then;

public class ProductPageSteps {
    private ProductPage productPage = new ProductPage(DriverFactory.getDriver());

    @Then("user add that item to the basket")
    public void userAddThatItemToTheBasket() {
        productPage.addToBasket();
    }

    @Then("user displays basket")
    public void userDisplaysBasket() {
        productPage.goToBucket();
    }
}
