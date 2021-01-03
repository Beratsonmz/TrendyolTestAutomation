package Pages;

import Util.PageUtil;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends PageUtil {


    private final By emailField = By.id("login-email");
    private final By passwordField = By.id("login-password-input");
    private final By loginBtn = By.xpath("//button[@type='submit']");
    private final By errorMsg = By.id("error-box-wrapper");
    private final By forgotPasswordLink = By.xpath("//span[contains(.,'Şifremi Unuttum')]");


    public LoginPage(WebDriver driver) {
        super(driver);
    }

    public String getPageTitle() {
        return pageTitle();
    }

    public boolean isForgotPwdLinkExist() {
        return isElementDisplayed(forgotPasswordLink);
    }

    public void setEmail(String email) {
        sendKeys(emailField, email);
    }

    public void setPassword(String password) {
        sendKeys(passwordField, password);
    }

    public void clickLoginBtn() {
        click(loginBtn);
    }

    public String getErrorMessage() {
        return getElementsText(errorMsg);

    }

    public HomePage login(String mail, String password) {
        setEmail(mail);
        setPassword(password);
        clickLoginBtn();
        return new HomePage(getwebdriver());
    }


}
