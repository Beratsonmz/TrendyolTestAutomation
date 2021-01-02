package Parallel.StepDefinitions;

import Factory.DriverFactory;
import Pages.HomePage;
import Pages.LoginPage;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.testng.Assert;

import java.util.List;
import java.util.Map;

public class HomePageSteps {
    private LoginPage loginPage = new LoginPage(DriverFactory.getDriver());
    private HomePage homePage;


    @Given("User has already logged in")
    public void userHasAlreadyLoggedIn(DataTable dataTable) {
       List<Map<String, String>> loginInfo = dataTable.asMaps();
       DriverFactory.getDriver().get("https://www.trendyol.com/giris");
       homePage = loginPage.login(loginInfo.get(0).get("email"), loginInfo.get(0).get("password"));

    }

    @Given("User is on Home Page")
    public void userIsOnHomePage() {

        System.out.println("Home Page Title : "+homePage.getPageTitle());
    }

    @Then("My account dropdown should be visible")
    public void myAccountDropdownShouldBeVisible(DataTable dropDownTable) {
       List<String> expectedDropDownList = dropDownTable.asList();
       System.out.println("Expected List:" + expectedDropDownList);
       List<String> actualDropDownList = homePage.getAccountDropdownList();
       System.out.println("Actual List:" + actualDropDownList);
       homePage.validateAccountDropdown();
    }

    @Then("My account dropdown should contain {int} different links")
    public void myAccountDropdownShouldContainDifferent(Integer expectedCount) {
        Assert.assertEquals(homePage.getAccountDropdownCount(),(int) expectedCount);
    }


}
