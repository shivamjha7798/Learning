import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import performOperations.BrowserPopupOperations;
import utils.FileUtil;

import java.util.Properties;

public class WebDriverLaunch {

    public static WebDriver driverLaunch() {
        Properties configProperty = FileUtil.properties("config.properties");
        RemoteWebDriver webdriver;

        String chromeDriverProperty = "chrome.driver.version";
        String chromeDriverVersion = configProperty.getProperty(chromeDriverProperty);

        String geckoDriverProperty = "webdriver.gecko.driver";
        String geckoDriverPath = configProperty.getProperty(geckoDriverProperty);

        String edgeDriverProperty = "webdriver.edge.driver";
        String edgeDriverPath = configProperty.getProperty(edgeDriverProperty);

        switch(configProperty.getProperty("webdriver")){
            case "chromedriver":
                System.setProperty(chromeDriverProperty, chromeDriverVersion);
                webdriver = new ChromeDriver();
                break;
            case "geckodriver":
                System.setProperty(geckoDriverProperty, geckoDriverPath);
                webdriver = new FirefoxDriver();
                break;
            case "edgedriver":
                System.setProperty(edgeDriverProperty, edgeDriverPath);
                webdriver = new EdgeDriver();
                break;
            default:
                throw new RuntimeException("Illegal WebDriver call");
        }
        return webdriver;
    }

    public static void main(String[] args) {
        WebDriver driver = WebDriverLaunch.driverLaunch();
//        driver.navigate().to("https://demoqa.com/");
//        driver.get("https://demoqa.com/");
//
//        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(15));
//        new ScreenShotUtil<WebDriver>().takeScreenshot(driver, "demoqa");

        new BrowserPopupOperations(driver).performOperations();
        driver.quit();
    }
}
