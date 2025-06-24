package performOperations;

import locators.Alerts;
import org.openqa.selenium.Alert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class AlertOperations {
    static WebDriver driver;

    public AlertOperations(WebDriver driver){
        AlertOperations.driver = driver;
    }


    public static void performOperation(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10000));
        JavascriptExecutor exec = (JavascriptExecutor) driver;

        exec.executeScript("arguments[0].scrollIntoView(true);", driver.findElement(Alerts.alertButton));
        driver.findElement(Alerts.alertButton).click();
        driver.switchTo().alert().accept();


        exec.executeScript("arguments[0].scrollIntoView(true);", driver.findElement(Alerts.timerAlertButton));
        driver.findElement(Alerts.timerAlertButton).click();
        wait.until(ExpectedConditions.alertIsPresent());
        driver.switchTo().alert().accept();

        exec.executeScript("arguments[0].scrollIntoView(true);", driver.findElement(Alerts.confirmButton));
        driver.findElement(Alerts.confirmButton).click();
        Alert alert = driver.switchTo().alert();
        System.out.println(alert.getText());
        alert.dismiss();

        exec.executeScript("arguments[0].scrollIntoView(true);", driver.findElement(Alerts.promtButton));
        driver.findElement(Alerts.promtButton).click();
        alert = driver.switchTo().alert();
        alert.sendKeys("Shivam Jha");
        alert.accept();
    }
}
