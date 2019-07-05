package gbsys.pageobjects;


import gbsys.locators.DashBoardLocators;
import org.openqa.selenium.WebDriver;

public class DashBoardPage extends DashBoardLocators {

    public DashBoardPage(WebDriver driver) {
        super(driver);
    }

    public boolean isChangePasswordDisplayed(){
        return this.getBot().isElementDisplayed(this.changePasswordElement);
    }

    public boolean isLogOutDisplayed(){
        return this.getBot().isElementDisplayed(this.logOutElementElement);
    }

    public boolean isSuccessAddUser(){
        return this.getBot().isElementDisplayed(this.successAddUserElement);
    }

    public boolean isSuccessChangeUserPassword(){
        return this.getBot().isElementDisplayed(this.passwordSuccessMessage);
    }

    public boolean isFolderListPage(){
        return this.getBot().isElementDisplayed(this.foldersList);
    }

    public boolean isRemoveFolder(){
        return this.getBot().isElementDisplayed(this.removeFolderSuccessMessage);
    }

}
