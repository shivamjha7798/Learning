package locators;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class PracticeForm {

    public static By h1text = By.xpath("//div[@class= 'practice-form-wrapper']/h1");
    public static By h5text = By.xpath("//div[@class= 'practice-form-wrapper']/h1");
    public static By nameLabel = By.id("userName-label");
    public static By firstNameField = By.id("firstName");
    public static By lastNameField = By.id("lastName");
    public static By emailLabel = By.id("userEmail-label");
    public static By email = By.id("userEmail");
    public static By genderLabel = By.id("genterWrapper");
    public static By male = By.xpath("//label[contains(text(),'Male')]");
    public static By female = By.xpath("//label[contains(text(),'Female')]");
    public static By other = By.xpath("//label[contains(text(),'Other')]");
    public static By mobileNo_Label = By.id("userNumber-label");
    public static By mobileNo_Field = By.id("userNumber");
    public static By dobLabel = By.id("dateOfBirth-label");
    public static By dobInputField = By.id("dateOfBirthInput");
    public static By subjectLabels = By.id("subjects-label");
    public static By subjectField = By.xpath("//input[@id='subjectsInput']");
    public static By subjectAutoComplete = By.xpath("//div[starts-with(@class, 'subjects-auto-complete__menu-list')]");
    public static By hobbiesLabel = By.xpath("//div[@id='hobbiesWrapper']/div/label");
    public static By hobbiesSports = By.xpath("//div[@id='hobbiesWrapper']//label[contains(text(), 'Sports')]");
    public static By hobbiesReading = By.xpath("//div[@id='hobbiesWrapper']//label[contains(text(), 'Reading')]");
    public static By hobbiesMusic = By.xpath("//div[@id='hobbiesWrapper']//label[contains(text(), 'Music')]");
    public static By pictureLabel = By.xpath("//label[contains(text(), 'Picture')]");
    public static By chooseFile = By.id("uploadPicture");
    public static By addressLabel = By.id("currentAddress-label");
    public static By addressField = By.id("currentAddress");
    public static By state_cityLabel = By.id("stateCity-label");
    public static By stateField = By.id("state");
    public static By stateOptions = By.xpath("//div[@id='state']/div[2]/div");
    public static By cityField = By.id("city");
    public static By cityOptions = By.xpath("//div[@id='city']/div[2]/div");

    public static By selectSubject(String subject){
        return By.xpath(String.format("//div[text()='%s']", subject));
    }
    public static By selectState(String state){
        return By.xpath(String.format("//div[text(),'%s']", state));
    }
    public static By selectCity(String city){
        return By.xpath(String.format("//div[text(),'%s']", city));
    }

    public static void landOnPage(WebDriver driver){
        driver.get(driver.getCurrentUrl()+"automation-practice-form/");
        driver.findElement(h1text).isDisplayed();
        driver.findElement(h5text).isDisplayed();
    }
    public static void verifyAllLabel(WebDriver driver){
        assert driver.findElement(h1text).getText().equals("Practice Form");
        assert driver.findElement(h5text).getText().equals("Student Registration Form");
        assert driver.findElement(nameLabel).getText().equals("Name");
        assert driver.findElement(emailLabel).getText().equals("Email");
        assert driver.findElement(genderLabel).getText().equals("Gender");
        assert driver.findElement(mobileNo_Label).getText().equals("Mobile(10 Digits)");
        assert driver.findElement(dobLabel).getText().equals("Date of Birth");
        assert driver.findElement(subjectLabels).getText().equals("Subjects");
        assert driver.findElement(hobbiesLabel).getText().equals("Hobbies");
        assert driver.findElement(pictureLabel).getText().equals("Picture");
        assert driver.findElement(addressLabel).getText().equals("Current Address");
        assert driver.findElement(state_cityLabel).getText().equals("State and City");
    }
}