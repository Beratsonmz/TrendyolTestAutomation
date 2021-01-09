package StepDefinitions;

import Factory.DriverFactory;
import Pages.BasketPage;
import io.cucumber.java.en.Then;
import org.junit.Assert;


public class BasketSteps {
    private BasketPage basketPage = new BasketPage(DriverFactory.getDriver());

    @Then("item count should be {int}")
    public void itemCountShouldBe(int count) {
        Assert.assertEquals(basketPage.countBasket(),count);
    }
}
