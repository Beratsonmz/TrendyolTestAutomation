package Factory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.safari.SafariDriver;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

public class DriverFactory {

    public WebDriver driver;
    public static Actions action;
    public static ThreadLocal<WebDriver> threadLocal = new ThreadLocal<>();

    /**
     * This method is used for initialize the specific browser driver with threadLocal.
     *
     * @param browserName
     * @return driver with threadLocal
     */
    public WebDriver initDriver(String browserName) {

        switch (browserName) {
            case "chrome":
                System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver");
                threadLocal.set(new ChromeDriver());
                break;
            case "firefox":
                System.setProperty("webdriver.gecko.driver", "src/main/resources/geckodriver");
                threadLocal.set(new FirefoxDriver());
                break;
            case "safari":
                System.setProperty("webdriver.safari.driver", "src/main/resources/safaridriver");
                threadLocal.set(new SafariDriver());
                break;
        }
        getDriver().manage().window().maximize();
        getDriver().manage().deleteAllCookies();
        return getDriver();


    }

    /**
     * This Method used for call the WebDriver with threadLocal.
     *
     * @return
     */
    public static synchronized WebDriver getDriver() {
        return threadLocal.get();

    }

}
