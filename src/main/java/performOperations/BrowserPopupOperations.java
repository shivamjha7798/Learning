package performOperations;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.time.Duration;
import java.util.Iterator;
import java.util.Set;

public class BrowserPopupOperations {
    WebDriver driver;
    public BrowserPopupOperations(WebDriver driver){
        this.driver = driver;
    }

    public void performOperations(){
        driver.navigate().to("https://www.rrc.texas.gov/resource-center/research/gis-viewer/gis-popup-blocker-test/");
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(15));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        driver.findElement(By.xpath("//a[@class='btn goBtn']")).click();

        Set<String> windowsId = driver.getWindowHandles();
        Iterator<String> itr = windowsId.iterator();
        String parentWindow = itr.next();
        String childWindow = itr.next();

        driver.switchTo().window(childWindow);
        assert driver.findElement(By.tagName("h1")).getText().equals("Test Page");
        driver.close();

        driver.switchTo().window(parentWindow);
    }
}
