package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

import java.util.List;

public class SauceDemoPages {
    WebDriver driver;

    public SauceDemoPages() {
        this.driver = Driver.getDriver();
        PageFactory.initElements(driver, this);
    }

    @FindBy (xpath = "//input[@id=\"user-name\"]")
    public WebElement username;

    @FindBy (xpath = "//input[@id=\"password\"]")
    public WebElement password;

    @FindBy (xpath = "//input[@id=\"login-button\"]")
    public WebElement loginButton;

    @FindBy (xpath = "//button[@class=\"btn btn_primary btn_small btn_inventory \"]")
    public List<WebElement> items;

    @FindBy (xpath = "//a[@class=\"shopping_cart_link\"]")
    public WebElement goToCart;

    @FindBy (xpath = "//div[@class=\"cart_item\"]")
    public List<WebElement> itemsInCart;

    @FindBy (xpath = "//button[@id=\"checkout\"]")
    public WebElement checkout;

    @FindBy (xpath = "//input[@id=\"first-name\"]")
    public WebElement firstName;

    @FindBy (xpath = "//input[@id=\"last-name\"]")
    public WebElement lastName;

    @FindBy (xpath = "//input[@id=\"postal-code\"]")
    public WebElement postalCode;

    @FindBy (xpath = "//input[@id=\"continue\"]")
    public WebElement continueButton;

    @FindBy (xpath = "//button[@id=\"finish\"]")
    public  WebElement finish;

    @FindBy (xpath = "//h2[@data-test=\"complete-header\"]")
    public WebElement lastMessage;

    @FindBy (xpath = "//div[@id=\"login_credentials\"]")
    public WebElement wrongPassword;

    @FindBy (xpath = "//div[@class=\"error-message-container error\"]")
    public WebElement errorMessage;

    public void addAll() {
        for(WebElement item : items) {
            item.click();
        }
    }

    public void fill() {
        firstName.sendKeys("Abduvohid");
        lastName.sendKeys("Abdujamolov");
        postalCode.sendKeys("60504");
    }
}
