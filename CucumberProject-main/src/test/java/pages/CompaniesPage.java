package pages;

import com.github.javafaker.Faker;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class CompaniesPage {
    WebDriver driver;

    @FindBy(xpath = "//input[@placeholder=\"Enter login\"]")
    public WebElement loginBtn;


    @FindBy(xpath = "//input[@placeholder=\"Enter password\"]")
    public WebElement passwordBtn;

    @FindBy(xpath = "//button[@type=\"submit\"]")
    public WebElement singInBtn;
    @FindBy(xpath = "//button[text()='Create company']")
    public WebElement addCompanyButton;

    @FindBy (xpath = "//p[text()=\"Click on the icon to download or drag\"]")
    public WebElement addPictureButton;


    @FindBy(xpath = "//span[contains(text(),\"Company Name *\")]/../../..//input")
    public WebElement companyNameField;

    @FindBy(xpath = "//input[@name='address']")
    public WebElement addressField;

    @FindBy(xpath = "//input[@name='phoneNumber']")
    public WebElement phoneField;

    @FindBy(xpath = "//span[contains(text(),\"Email *\")]/../../..//input")
    public WebElement emailField;

    @FindBy (xpath = "//span[@class=\"sc-ctqQKy jusjEk MuiButton-startIcon MuiButton-iconSizeMedium\"]")
    public WebElement createButton;

    @FindBy (xpath = "//button[text()=\"Cancel\"]")
    public WebElement cancelButton;
    @FindBy(xpath = " //button[@class=\"sc-jJoQJp ieRzNh MuiButton-root MuiButton-contained" +
            " MuiButton-containedPrimary MuiButton-sizeMedium MuiButton-containedSizeMedium " +
            "MuiButtonBase-root sc-eGRUor dTmEKg sc-gIDmLj fpaoOd\"]")
    public WebElement justCreate;


    @FindBy(id = "companyList")
    public WebElement companyList;

    @FindBy(xpath = "(//div[contains(text(),'BugBuster')])[9]")
    public WebElement checkCompanyName;


    public  CompaniesPage(){
        driver = Driver.getDriver();
        PageFactory.initElements(driver,this);
    }


    public void createCompany()  {
        Faker faker = new Faker();
        //addPictureButton.sendKeys();
        addCompanyButton.click();
        companyNameField.sendKeys("BugBuster");
        emailField.sendKeys(faker.internet().emailAddress());
        addressField.sendKeys(faker.address().fullAddress());
        phoneField.click();
        phoneField.sendKeys(faker.phoneNumber().phoneNumber());

        justCreate.click();

    }
    public boolean isCompanyListed(String companyName) {
        return companyList.getText().contains(companyName);
    }
}
