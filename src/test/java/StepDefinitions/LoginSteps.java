package StepDefinitions;

import Factory.DriverFactory;
import Pages.HomePage;
import Pages.LoginPage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import org.junit.Assert;



public class LoginSteps {

    private LoginPage loginPage = new LoginPage(DriverFactory.getDriver());
    private HomePage homePage = new HomePage(DriverFactory.getDriver());
    private static String title;

    @Given("User is on login page")
    public void userIsOnLoginPage() {
        DriverFactory.getDriver().get("https://www.trendyol.com/giris");
    }

    @When("User gets the title of the page")
    public void userGetsTheTitleOfThePage() {
        title = loginPage.getPageTitle();
        System.out.println("Login Page Title is :" + title);
    }

    @Then("Page title should be {string}")
    public void pageTitleShouldBe(String expectedTitle) {
        Assert.assertTrue(loginPage.getPageTitle().contains(expectedTitle));
    }

    @Then("Forgot password link should be displayed")
    public void forgotPasswordLinkShouldBeDisplayed() {
        Assert.assertTrue(loginPage.isForgotPwdLinkExist());
    }

    @When("User enters email {string}")
    public void userEntersEmail(String email) {
        loginPage.setEmail(email);
    }

    @When("User enters password {string}")
    public void userEntersPassword(String password) {
        loginPage.setPassword(password);
    }

    @When("User clicks on login button")
    public void userClicksOnLoginButton() {
        loginPage.clickLoginBtn();
    }

    @When("User sees the account container")
    public void userSeesTheAccountContainer() {
        homePage.validateAccountDropdown();
    }

    @Then("User moves cursor to the My Account button")
    public void userMovesCursorToTheAccountBtn() {
        homePage.moveCursorToAccountBtn();
    }

    @Then("My account dropdown should be displayed")
    public void myAccountDropdownShouldBeDisplayed() {
        homePage.validateAccountDropdown();
    }
}
