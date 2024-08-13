package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class CashwisePages {
    WebDriver driver;

    public CashwisePages() {
        this.driver = Driver.getDriver();
        PageFactory.initElements(driver, this);
    }


    @FindBy(xpath = "//button[@class=\"MuiButton-root MuiButton-outlined MuiButton-outlinedPrimary MuiButton-sizeMedium MuiButton-outlinedSizeMedium MuiButtonBase-root css-k6k41x\"]")
    public WebElement signUpButton;

    @FindBy (xpath = "//input[@id=\"email_input_text\"]")
    public WebElement emailField;

    @FindBy (xpath = "//input[@id=\"password_input_text\"]")
    public WebElement passwordField;

    @FindBy (xpath = "//input[@id=\"repeat_password_input_text\"]")
    public WebElement confirmPassword;

    @FindBy (xpath = "//button[@form=\"register-form-1\"]")
    public WebElement continueButton;

    @FindBy (xpath = "//input[@id=\"first_name_input_text\"]")
    public WebElement nameField;

    @FindBy (xpath = "//input[@id=\"last_name_input_text\"]")
    public WebElement lastNameField;

    @FindBy (xpath = "//input[@id=\"company_name_input_text\"]")
    public WebElement businessField;

    @FindBy (xpath = "//div[@id=\"mui-component-select-business_area_id\"]")
    public WebElement areaBusiness;

    @FindBy (xpath = "//li[@data-value=\"1\"]")
    public WebElement businessOption;

    @FindBy (xpath = "//input[@id=\"address_input_text\"]")
    public WebElement addressField;

    @FindBy (xpath = "//div[@id=\"mui-component-select-currency\"]")
    public WebElement currency;

    @FindBy (xpath = "//div[@style=\"display: flex; align-items: center; gap: 5px;\"]")
    public  WebElement currencyOption;

    @FindBy (xpath = "//button[@form=\"register-form-2\"]")
    public WebElement signUp;

}
