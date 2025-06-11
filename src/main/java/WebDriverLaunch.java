import Locators.PracticeForm;
import Locators.Alerts;
import performOperations.AlertOperations;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.RemoteWebDriver;

public class WebDriverLaunch {
    String driver;
    public WebDriverLaunch(String driver){
        this.driver = driver;
    }

    public WebDriver driverLaunch() {
        RemoteWebDriver webdriver;

        String chromeDriverProperty = "chrome.driver.version";
        String chromeDriverVersion = "137.0.7151.55";

        String geckoDriverProperty = "webdriver.gecko.driver";
        String geckoDriverPath = "src/main/resources/WebDrivers/geckodriver-v0.35.0-win64/geckodriver.exe";

        String edgeDriverProperty = "webdriver.edge.driver";
        String edgeDriverPath = "src/main/resources/WebDrivers/edgedriver_win64/msedgedriver.exe";

        switch(this.driver){
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
        WebDriver driver = new WebDriverLaunch("chromedriver").driverLaunch();
        driver.get("https://demoqa.com/");
        Alerts.landOnPage(driver);
        new AlertOperations(driver).performOperation();
        driver.quit();
    }
}
