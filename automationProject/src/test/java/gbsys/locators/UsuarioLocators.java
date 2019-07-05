package gbsys.locators;

import gbsys.configurations.selenium.PageObjectBase;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class UsuarioLocators extends PageObjectBase {
    public UsuarioLocators (WebDriver driver) {
        super(driver);
    }

    @FindBy(id="id_username")
    protected WebElement userNameElement;

    @FindBy(id="id_password1")
    protected WebElement password1Element;

    @FindBy(id="id_password2")
    protected WebElement password2Element;

    @FindBy(name="_save")
    protected WebElement submitSaveElement;

    @FindBy(xpath = "//input[contains(@value,'Change password')]")
    protected WebElement submitChangePassword;

    @FindBy(xpath = "//a[contains(text(),'Add user')]")
    protected WebElement submitAddUser;

    @FindBy(id = "id_is_staff")
    protected WebElement checkistaff;

    @FindBy(xpath = "//a[contains(text(),'this form')]")
    protected WebElement linkThisFormChangePass;

    @FindBy(name="result_list")
    protected WebElement resultListUser;



}
