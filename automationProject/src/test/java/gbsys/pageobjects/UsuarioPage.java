package gbsys.pageobjects;

import gbsys.locators.UsuarioLocators;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

public class UsuarioPage extends UsuarioLocators {
    public UsuarioPage(WebDriver driver) {
        super(driver);
    }

    public void fillUserName(String userName) {
        this.userNameElement.sendKeys(userName);
    }

    // password1 del formulario de agregar
    public void fillPassword1(String password1) {
        this.password1Element.sendKeys(password1);
    }

    // password2 de formulario de agregar
    public void fillPassword2(String password2) {
        this.password2Element.sendKeys(password2);
    }

    // boton de salvar del formulario de agregar
    public DashBoardPage submitSaveUser(){
        this.submitSaveElement.submit();
        return PageFactory.initElements(this.getDriver(), DashBoardPage.class);
    }

    public DashBoardPage SummitAddUser(){
        this.submitAddUser.click();
        return PageFactory.initElements(this.getDriver(), DashBoardPage.class);
    }

    public DashBoardPage SummitChangePassword(){
        this.submitChangePassword.submit();
        return PageFactory.initElements(this.getDriver(), DashBoardPage.class);
    }

    public DashBoardPage linkThisFormChangePassword(){
        this.linkThisFormChangePass.click();
        return PageFactory.initElements(this.getDriver(), DashBoardPage.class);
    }

    public DashBoardPage activeUser(){
        this.checkistaff.click();
        this.submitSaveElement.submit();
        return PageFactory.initElements(this.getDriver(), DashBoardPage.class);
    }

    public DashBoardPage resultListUser(String user){
        String xpath = "//a[contains(text(),'"+user+"')]";
        WebElement usrlink = this.resultListUser.findElement(By.xpath(xpath));
        usrlink.click();
        return PageFactory.initElements(this.getDriver(), DashBoardPage.class);
    }

}
