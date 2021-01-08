package Parallel.StepDefinitions;

import Factory.DriverFactory;
import Pages.BoutiquePage;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class BoutiquePageSteps {
    private BoutiquePage boutiquePage = new BoutiquePage(DriverFactory.getDriver());

    @Then("user randomly clicks one of the search category link from slider")
    public void userRandomlyClicksOneOfTheSearchCategoryLinkFromSlider() {
        boutiquePage.clickRandomBoutique();
    }
}
