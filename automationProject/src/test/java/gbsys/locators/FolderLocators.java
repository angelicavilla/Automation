package gbsys.locators;

import gbsys.configurations.selenium.PageObjectBase;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class FolderLocators extends PageObjectBase {
    public FolderLocators (WebDriver driver) {
        super(driver);
    }


    @FindBy(xpath = "//a[contains(@title,'Adds a new Folder')]")
    protected WebElement linkNewFolder;

    @FindBy(name="name")
    protected WebElement nameFolderElement;

    @FindBy(name="_save")
    protected WebElement saveFolderElement;

    @FindBy(css="action-button")
    protected WebElement editBoton;

    @FindBy(xpath ="//input[contains(@type,'submit')]")
    protected WebElement inputConfirmationDelete;



    }

