package utils;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.io.File;

public class ScreenShotUtil {
    public static void takeScreenshot(WebDriver driver, String name) {
        File screenShot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        FileUtil.copyToFile(screenShot, new File(String.format("target/ScreenShot/%s.png", name)));
    }
}
