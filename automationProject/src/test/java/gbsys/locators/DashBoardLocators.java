package gbsys.locators;


import gbsys.configurations.selenium.PageObjectBase;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class DashBoardLocators extends PageObjectBase {
    public DashBoardLocators(WebDriver driver) {
        super(driver);
    }

    @FindBy(css="[href='/admin/logout/']")
    protected WebElement logOutElementElement;

    @FindBy(css="[href='/admin/password_change/']")
    protected WebElement changePasswordElement;

    @FindBy(xpath = "//a[contains(@class,'historylink')]")
    protected WebElement successAddUserElement;

    @FindBy(xpath = "//li[contains(text(),'Password changed successfully')]")
    protected WebElement passwordSuccessMessage;

    @FindBy(css="[href='/admin/filer/folder/']")
    protected WebElement foldersList;

    @FindBy(xpath = "//li[contains(text(),'Successfully deleted 1 files and/or folders.')]")
    protected WebElement removeFolderSuccessMessage;


}
