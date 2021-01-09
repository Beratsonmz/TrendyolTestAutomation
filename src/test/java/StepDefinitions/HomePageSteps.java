package StepDefinitions;

import Factory.DriverFactory;
import Pages.BoutiquePage;
import Pages.HomePage;
import Pages.LoginPage;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;


import java.util.List;
import java.util.Map;

public class HomePageSteps {
    private LoginPage loginPage = new LoginPage(DriverFactory.getDriver());
    private HomePage homePage = new HomePage(DriverFactory.getDriver());
    private BoutiquePage boutiquePage = new BoutiquePage(DriverFactory.getDriver());

    @Given("User has already logged in")
    public void userHasAlreadyLoggedIn(DataTable dataTable) {
        List<Map<String, String>> loginInfo = dataTable.asMaps();
        DriverFactory.getDriver().get("https://www.trendyol.com/giris");
        homePage = loginPage.login(loginInfo.get(0).get("email"), loginInfo.get(0).get("password"));

    }

    @Given("User is on Home Page")
    public void userIsOnHomePage() {
        DriverFactory.getDriver().get("https://www.trendyol.com/");
        System.out.println("Home Page Title : " + homePage.getPageTitle());
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
        Assert.assertEquals(homePage.getAccountDropdownCount(), (int) expectedCount);
    }

    @When("Gender popup appears")
    public void genderPopupAppears() {
        Assert.assertTrue(homePage.validateGenderPopUp());
    }

    @Then("Both gender buttons should be visible")
    public void bothGenderButtonsShouldBeVisible() {
        Assert.assertTrue(homePage.validateGenderButtonWomen());
        Assert.assertTrue(homePage.validateGenderButtonMan());
    }

    @Then("Close button should be visible")
    public void closeButtonShouldBeVisible() {
        Assert.assertTrue(homePage.validateCloseBtn());
    }

    @When("User clicks on close button")
    public void userClicksOnCloseButton() {
        homePage.clickGenderPopupCloseBtn();
    }

    @Then("Gender pop up should be disappear")
    public void genderPopUpShouldBeDisappear() {
        Assert.assertFalse(homePage.validateGenderPopupClosed());
    }

    @When("User clicks on kadın button")
    public void userClicksOnKadınButton() {
        homePage.clickGenderGenderWomenBtn();
    }

    @Then("User should be navigated to the Kadın Page")
    public void userShouldBeNavigatedToTheKadınPage() {
        Assert.assertEquals(boutiquePage.findActiveTabText(), "KADIN");
    }

    @When("user randomly clicks one of the boutique link")
    public void userRandomlyClicksOneOfTheBoutiqueLink() {
        homePage.clickRandomBoutique();
    }

}
