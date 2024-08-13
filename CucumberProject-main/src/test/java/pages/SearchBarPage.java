package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class SearchBarPage {
    WebDriver driver;

    public SearchBarPage () {
        this.driver = Driver.getDriver();
        PageFactory.initElements(driver, this);
    }

    @FindBy (id = "APjFqb")
    public WebElement searchBar;

    @FindBy (xpath = "//h3[@class=\"LC20lb MBeuO DKV0Md\"]")
    public WebElement result;

    @FindBy (xpath = "//p[@style=\"padding-top:.33em\"]")
    public WebElement resultMessage;

}
