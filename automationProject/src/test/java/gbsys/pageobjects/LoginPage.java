package gbsys.pageobjects;


import gbsys.locators.DashBoardLocators;
import gbsys.locators.LoginLocators;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class LoginPage extends LoginLocators {

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    public void fillUserName(String userName) {
        this.userNameElement.sendKeys(userName);
    }

    public void fillPassword(String password) {
        this.passwordElement.sendKeys(password);
    }

    public DashBoardPage submit(){
        this.submitElement.submit();
        return PageFactory.initElements(this.getDriver(), DashBoardPage.class);
    }

    public DashBoardPage logOut(){
        this.logOutElementElement.click();
        this.loginAgain.click();
        return PageFactory.initElements(this.getDriver(), DashBoardPage.class);
    }
}
