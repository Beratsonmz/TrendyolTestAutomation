package Parallel.StepDefinitions;

import Factory.DriverFactory;
import Pages.BasketPage;
import Pages.BoutiquePage;
import io.cucumber.java.en.Then;
import org.testng.Assert;

public class BasketSteps {
    private BasketPage basketPage = new BasketPage(DriverFactory.getDriver());

    @Then("item count should be {int}")
    public void itemCountShouldBe(int count) {
        Assert.assertEquals(basketPage.countBasket(),count);
    }
}
