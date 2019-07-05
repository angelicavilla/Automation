package gbsys.pageobjects;

import gbsys.locators.FolderLocators;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

public class FolderPage extends FolderLocators {
    public FolderPage(WebDriver driver) {
        super(driver);
    }


    public DashBoardPage fillnameFolder(String nombreFolder) {
        this.nameFolderElement.clear();
        this.nameFolderElement.sendKeys(nombreFolder);
        this.saveFolderElement.submit();
        return PageFactory.initElements(this.getDriver(), DashBoardPage.class);
    }

    public DashBoardPage clickNewFolder() {
        this.linkNewFolder.click();
        return PageFactory.initElements(this.getDriver(), DashBoardPage.class);
    }

    public DashBoardPage openEditFolder(String folder) {
        String xpath = "//tr[contains(.,'"+folder+"')]//a[contains(@title,'Change folder details')]";
        WebElement row = this.getDriver().findElement(By.xpath(xpath));
        row.click();
        return PageFactory.initElements(this.getDriver(), DashBoardPage.class);
    }


    public DashBoardPage removeFolder(String folder) {
        String xpath = "//tr[contains(.,'"+folder+"')]//a[contains(@title,'Remove folder')]";
        WebElement row = this.getDriver().findElement(By.xpath(xpath));
        row.click();
        WebElement confirmation = this.inputConfirmationDelete;
        confirmation.submit();
        return PageFactory.initElements(this.getDriver(), DashBoardPage.class);
    }


}
