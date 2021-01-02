package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage {
    private WebDriver driver;

    private final By emailField = By.id("login-email");
    private final By passwordField = By.id("login-password-input");
    private final By loginBtn = By.xpath("//button[@type='submit']");
    private final By errorMsg = By.id("error-box-wrapper");
    private final By forgotPasswordLink = By.xpath("//span[contains(.,'Şifremi Unuttum')]");


    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    public String getPageTitle() {
        return driver.getTitle();
    }

    public boolean isForgotPwdLinkExist() {
        return driver.findElement(forgotPasswordLink).isDisplayed();
    }

    public void setEmail(String email) {
        driver.findElement(emailField).sendKeys(email);
    }

    public void setPassword(String password) {
        driver.findElement(passwordField).sendKeys(password);
    }

    public void clickLoginBtn() {
        driver.findElement(loginBtn).click();
    }

    public String getErrorMessage() {
        return driver.findElement(errorMsg).getText();

    }

    public HomePage login(String mail, String password) {
        setEmail(mail);
        setPassword(password);
        clickLoginBtn();
        return new HomePage(driver);
    }


}
