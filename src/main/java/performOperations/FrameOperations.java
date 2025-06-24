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
        NestedFrames.landOnPage(driver);

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        JavascriptExecutor executor = (JavascriptExecutor) driver;
        executor.executeScript("arguments[0].scrollIntoView(true);", driver.findElement(NestedFrames.h1Text));

//        wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(3));
        driver.switchTo().frame(3);
        assert driver.findElement(By.tagName("body")).getText().equals("Parent frame");
        driver.switchTo().defaultContent();
        assert driver.findElement(NestedFrames.paraText).getText().startsWith("Sample Nested Iframe page.");

        // TODO: Need to find a way to get the child text and while returning to default content print every text
    }
}
