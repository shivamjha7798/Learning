package locators;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Alerts {
    public static By alertsWrapper = By.id("javascriptAlertsWrapper");
    public static By heading = By.xpath("//div[@id= 'javascriptAlertsWrapper'] //h1[text()='Alerts']");
    public static By alertButton = By.xpath("//button[@id='alertButton']");
    public static By timerAlertButton = By.xpath("//button[@id='timerAlertButton']");
    public static By confirmButton = By.xpath("//button[@id='confirmButton']");
    public static By promtButton = By.xpath("//button[@id='promtButton']");

    public static void landOnPage(WebDriver driver){
        driver.get(driver.getCurrentUrl()+"alerts/");
        driver.findElement(alertsWrapper).isEnabled();
        driver.findElement(heading).isDisplayed();
    }

}
