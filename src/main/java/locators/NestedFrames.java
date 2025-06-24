package locators;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import utils.ScreenShotUtil;

public class NestedFrames {
    public static By frameWrapper = By.id("framesWrapper");
    public static By h1Text = By.xpath("//div[@id='framesWrapper']/h1");
    public static By paraText = By.xpath("//div[@id='framesWrapper']/div[1]");
    public static By frame1 = By.xpath("//iframe[@id='frame1']");

    public static <driver> void landOnPage(WebDriver driver) {
        driver.get(driver.getCurrentUrl()+"nestedframes/");
        driver.findElement(frameWrapper).isDisplayed();
        driver.findElement(h1Text).isDisplayed();
        ScreenShotUtil.takeScreenshot(driver, "nestedframes");
    }
}