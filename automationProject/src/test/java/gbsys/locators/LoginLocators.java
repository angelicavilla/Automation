package gbsys.locators;


import gbsys.configurations.selenium.PageObjectBase;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginLocators extends PageObjectBase {
    public LoginLocators(WebDriver driver) {
        super(driver);
    }

    @FindBy(id="id_username")
    protected WebElement userNameElement;

    @FindBy(id="id_password")
    protected WebElement passwordElement;

    @FindBy(css="[type='submit']")
    protected WebElement submitElement;

    @FindBy(css="[href='/admin/logout/']")
    protected WebElement logOutElementElement;

    @FindBy(xpath = "//a[contains(text(),'Log in again')]")
    protected WebElement loginAgain;


}
