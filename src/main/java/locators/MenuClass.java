package locators;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import utils.Helper;

public class MenuClass {
    public static By menuContainer = By.id("nav-menu-container");
    public static By h1Text = By.xpath("//div[@class='nav-menu-container']//h1");
    public static By mainItem1 = By.xpath("//a[text()='Main Item 1']");
    public static By mainItem2 = By.xpath("//a[text()='Main Item 2']");
    public static By mainItem3 = By.xpath("//a[text()='Main Item 3']");
    public static By subSubList = By.xpath("//a[text()='SUB SUB LIST »']");
    public static By subSubItem1 = By.xpath("//a[text()='Sub Sub Item 1']");
    public static By subSubItem2 = By.xpath("//a[text()='Sub Sub Item 2']");

    public static void landOnPage(WebDriver driver){
        driver.get(driver.getCurrentUrl()+"menu/");
        Helper.wait(driver).until(ExpectedConditions.visibilityOfElementLocated(h1Text));

        driver.findElement(h1Text).isDisplayed();
    }
}
