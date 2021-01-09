package StepDefinitions;

import Factory.DriverFactory;
import Pages.SearchPage;
import io.cucumber.java.en.Then;

public class SearchPageSteps {
    private SearchPage searchPage = new SearchPage(DriverFactory.getDriver());

    @Then("user selects random item from results")
    public void userSelectsRandomItemFromResults() {
        searchPage.clickRandomSearchProduct();
    }
}
