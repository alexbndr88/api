

import org.junit.Assert;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utilities.Driver;

import java.time.Duration;

public class CreateTariff {


    public CreateTariff() {
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(xpath = "//button[contains(text(),'Create')]")
    public WebElement createButton;

    @FindBy(xpath = "(//div[@role='button'])[1]")
    public WebElement branchButton;

    @FindBy(xpath = "//li[text()='Nurgazy ']")
    public WebElement branchDropdown;

    @FindBy(xpath = "(//input[@class='sc-efQSVx sc-jgrJph gZyZEO jRPFTh MuiOutlinedInput-input MuiInputBase-input'])[1]")
    public WebElement nameOfTariff;

    @FindBy(xpath = "(//input[@class='sc-efQSVx sc-jgrJph gZyZEO jRPFTh MuiOutlinedInput-input MuiInputBase-input'])[2]")
    public WebElement deliveryTime;

    @FindBy(xpath = "(//div[@role='button'])[2]")
    public WebElement typeOfDeliverybutton;

    @FindBy(xpath = "//li[text()='City express']")
    public WebElement typeOfDelivery;

    @FindBy(xpath = "(//input[@class='sc-efQSVx sc-jgrJph gZyZEO jRPFTh MuiOutlinedInput-input MuiInputBase-input'])[3]")
    public WebElement deliveryCost;

    @FindBy(xpath = "(//div[@role='button'])[3]")
    public WebElement selectRegionbutton;

    @FindBy(xpath = "//li[text()='Hawaii']")
    public WebElement SelectRegion;

    @FindBy(xpath = "//input[@value='true']")
    public WebElement available;

    @FindBy(xpath = "//input[@value='false']")
    public WebElement notAvailable;

    @FindBy(name = "coordinates")
    public WebElement coordinates;

    @FindBy(name = "additionalInformation")
    public WebElement additionalInformation;

    @FindBy(xpath = "//button[@type='submit']")
    public WebElement submit;


}
