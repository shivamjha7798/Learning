package locators;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import utils.Helper;

import java.util.Objects;

public class Droppable {
    public static By simpleLinkText = By.xpath("//a[text()='Simple']");
    public static By dragMe = By.xpath("//div[@id='draggable']");
    public static By dropHere = By.xpath("//div[@id='simpleDropContainer']//div[@class='drop-box ui-droppable']");
    public static By droppedText = By.xpath("//div[@id='simpleDropContainer']//div[@id='droppable']");

    public static void landOnPage(WebDriver driver){
        if (driver.getCurrentUrl().split(".com/").length==1) { driver.get(driver.getCurrentUrl() + "droppable/"); }
        else { driver.get(driver.getCurrentUrl().split(".com/")[0] + ".com/droppable/"); }

        Helper.wait(driver).until(ExpectedConditions.visibilityOfElementLocated(simpleLinkText));
        driver.findElement(simpleLinkText).isDisplayed();
    }
}
