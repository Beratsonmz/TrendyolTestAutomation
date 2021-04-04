package StepDefinitions;

import Factory.DriverFactory;
import Pages.CartPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;


public class CartSteps {
    private CartPage cartPage = new CartPage(DriverFactory.getDriver());

    @Then("item count should be {int}")
    public void itemCountShouldBe(int count) {
        Assert.assertEquals(cartPage.countCart(),count);
    }

    @Given("shopping cart contains {int} item")
    public void shoppingCartContainsItem(int arg0) {
    }

    @Given("user on Cart Page")
    public void userOnCartPage() {
    }

    @When("user clicks + button {int} times")
    public void userClicksButtonTimes(int arg0) {
    }

    @And("+ button should become inactive.")
    public void buttonShouldBecomeInactive() {
    }
}
