package performOperations;

import locators.NestedFrames;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class FrameOperations {
    WebDriver driver;
    public FrameOperations(WebDriver driver){
        this.driver = driver;
    }

    public void performOperation(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        JavascriptExecutor executor = (JavascriptExecutor) driver;

        wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(NestedFrames.frame1));
        driver.switchTo().frame(driver.findElement(NestedFrames.frame1));
        driver.findElement(By.xpath("//body[text()='Parent frame']")).getText();
        driver.switchTo().defaultContent();
        driver.findElement(NestedFrames.paraText).getText();

        // TODO: Need to find a way to get the child text and while returning to default content print every text
    }
}
