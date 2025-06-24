package performOperations;

import locators.Droppable;
import locators.MenuClass;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import utils.Helper;

public class ActionsOperations {
    WebDriver driver;

    public ActionsOperations(WebDriver driver){
        this.driver = driver;
    }

    public void performOperation() {
        Actions actions = new Actions(driver);

        MenuClass.landOnPage(driver);

        Helper.wait(driver).until(ExpectedConditions.visibilityOfElementLocated(MenuClass.mainItem2));
        Helper.scroll(driver, driver.findElement(MenuClass.mainItem2));

        actions.moveToElement(driver.findElement(MenuClass.mainItem2)).build().perform();
        actions.moveToElement(driver.findElement(MenuClass.subSubList)).build().perform();
        assert(driver.findElement(MenuClass.subSubItem1).isDisplayed());

        Droppable.landOnPage(driver);
        Helper.scroll(driver, driver.findElement(Droppable.dragMe));
        actions.moveToElement(driver.findElement(Droppable.dragMe)).clickAndHold().moveToElement(driver.findElement(Droppable.dropHere)).build().perform();
        assert driver.findElement(Droppable.droppedText).getText().equals("Dropped");
        assert true;

    }
}
