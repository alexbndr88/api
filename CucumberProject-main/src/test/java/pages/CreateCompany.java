//package pages;
//
//import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.WebElement;
//import org.openqa.selenium.support.FindBy;
//import org.openqa.selenium.support.PageFactory;
//import org.openqa.selenium.support.ui.ExpectedConditions;
//import org.openqa.selenium.support.ui.WebDriverWait;
//import utilities.Driver;
//import java.time.Duration;
//
//public class CreateCompany {
//
//    WebDriver driver;
//    WebDriverWait wait;
//
//    public CreateCompany() {
//        this.driver = Driver.getDriver();
//        PageFactory.initElements(driver, this);
//        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
//    }
//
//    @FindBy(xpath = "//button[contains(text(),'Create company')]")
//    public WebElement createCompanyButton;
//
//    @FindBy(name = "companyName")
//    public WebElement companyNameField;
//
//    @FindBy(name = "companyEmail")
//    public WebElement companyEmailField;
//
//    @FindBy(name = "companyAddress")
//    public WebElement companyAddressField;
//
//    @FindBy(name = "companyPhoneNumber")
//    public WebElement companyPhoneNumberField;
//
//    @FindBy(xpath = "//button[@type='submit']")
//    public WebElement submitButton;
//
//    @FindBy(xpath = "//td[text()='TestCompany']") // Adjust this locator as needed
//    public WebElement companyNameVerification;
//
//    public void clickCreateCompanyButton() {
//        wait.until(ExpectedConditions.elementToBeClickable(createCompanyButton)).click();
//    }
//
//    public void enterCompanyName(String companyName) {
//        wait.until(ExpectedConditions.visibilityOf(companyNameField)).sendKeys(companyName);
//    }
//
//    public void enterCompanyEmail(String companyEmail) {
//        companyEmailField.sendKeys(companyEmail);
//    }
//
//    public void enterCompanyAddress(String companyAddress) {
//        companyAddressField.sendKeys(companyAddress);
//    }
//
//    public void enterCompanyPhoneNumber(String companyPhoneNumber) {
//        companyPhoneNumberField.sendKeys(companyPhoneNumber);
//    }
//
//    public void clickSubmitButton() {
//        submitButton.click();
//    }
//
//    public boolean verifyCompanyNameCreated(String companyName) {
//        return wait.until(ExpectedConditions.visibilityOf(companyNameVerification)).isDisplayed();
//    }
//}
package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utilities.Driver;

import java.time.Duration;

public class CreateCompany {

    WebDriver driver;
    WebDriverWait wait;

    public CreateCompany() {
        this.driver = Driver.getDriver();
        PageFactory.initElements(driver, this);
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    @FindBy(xpath = "//button[contains(text(),'Create company')]")
    public WebElement createCompanyButton;

    @FindBy(name = "companyName")
    public WebElement companyNameField;

    @FindBy(name = "companyEmail")
    public WebElement companyEmailField;

    @FindBy(name = "companyAddress")
    public WebElement companyAddressField;

    @FindBy(name = "companyPhoneNumber")
    public WebElement companyPhoneNumberField;

    @FindBy(xpath = "//button[@type='submit']")
    public WebElement submitButton;

    @FindBy(xpath = "//td[text()='TestCompany']") // Adjust this locator as needed
    public WebElement companyNameVerification;

    public void clickCreateCompanyButton() {
       createCompanyButton.click();
    }

    public void enterCompanyName(String companyName) {
        wait.until(ExpectedConditions.visibilityOf(companyNameField)).sendKeys(companyName);
    }

    public void enterCompanyEmail(String companyEmail) {
        companyEmailField.sendKeys(companyEmail);
    }

    public void enterCompanyAddress(String companyAddress) {
        companyAddressField.sendKeys(companyAddress);
    }

    public void enterCompanyPhoneNumber(String companyPhoneNumber) {
        companyPhoneNumberField.sendKeys(companyPhoneNumber);
    }

    public void clickSubmitButton() {
        submitButton.click();
    }

    public boolean verifyCompanyNameCreated(String companyName) {
        return wait.until(ExpectedConditions.visibilityOf(companyNameVerification)).isDisplayed();
    }
}
