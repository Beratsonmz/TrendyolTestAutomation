package StepDefinitions;

import Factory.DriverFactory;
import Pages.ProductPage;
import io.cucumber.java.en.Then;

public class ProductPageSteps {
    private ProductPage productPage = new ProductPage(DriverFactory.getDriver());

    @Then("user add that item to the cart")
    public void userAddThatItemToTheCart() {
        productPage.addToCart();
    }

    @Then("user displays cart")
    public void userDisplaysCart() {
        productPage.goToCart();
    }
}
