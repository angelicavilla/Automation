package gbsys.testcases;


import gbsys.commons.FolderCommons;
import gbsys.commons.LoginCommons;
import gbsys.configurations.selenium.TestCaseBase;
import gbsys.pageobjects.FolderPage;
import gbsys.pageobjects.LoginPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.*;

public class FolderSuite extends TestCaseBase {

    private String password;
    private String userlogin;
    private String url_list_folder;


    @BeforeMethod(alwaysRun = true)
    @Parameters({"username", "password", "url_list_folder"})
    private void getParameterLogin(String username, String pass, String urlfolder) {
        this.password = pass;
        this.userlogin = username;
        this.url_list_folder = urlfolder;

    }

    ////----------------------------------------------------------

    @DataProvider(name = "dataprovideFolder")
    public static Object[][] credentials() {
        return new Object[][]{
                {"foldercreadoprueba", "folderNuevo"}};

    }


    @Test(description = "Este test case crea 1 folder",
            groups = {"Folders","full_regression"},
            dataProvider = "dataprovideFolder")
    public void createFolder(String folderCreado, String folderNuevo) {

        //login
        LoginPage loginPage = PageFactory.initElements(this.getDriver(), LoginPage.class);
        LoginCommons.login(loginPage, userlogin, password);
        // NAVEGAR AL AGREGAR AL USUARIO
        this.getDriver().navigate().to(url_list_folder);

        FolderPage folderPage = PageFactory.initElements(this.getDriver(), FolderPage.class);
        FolderCommons.clickNewFolder(folderPage);
        String windowHandleBase = this.getDriver().getWindowHandle();

        for (String currentWindow : this.getDriver().getWindowHandles()) {
            if (this.getDriver().switchTo().window(currentWindow).getTitle().equals("Add new folder | Django site admin")) {
                break;
            }
        }
        FolderCommons.addNewFolder(folderPage, folderCreado);
        this.getDriver().switchTo().window(windowHandleBase);
        FolderCommons.isNewFolderCreate(folderPage);

    }


    @Test(description = "Este test case edita 1 folder",
            groups = {"Folders","full_regression"},
            dataProvider = "dataprovideFolder", dependsOnMethods = "createFolder")
    public void editFolder(String folderCreado, String folderNuevo) {

        //login
        LoginPage loginPage = PageFactory.initElements(this.getDriver(), LoginPage.class);
        LoginCommons.login(loginPage, userlogin, password);
        // NAVEGAR AL AGREGAR AL USUARIO
        this.getDriver().navigate().to(url_list_folder);

        FolderPage folderPage = PageFactory.initElements(this.getDriver(), FolderPage.class);
        FolderCommons.selectRowFolder(folderPage,folderCreado);
        FolderCommons.addNewFolder(folderPage,folderNuevo);
        FolderCommons.isNewFolderCreate(folderPage);

    }


    @Test(description = "Este test case elimina 1 folder",
            groups = {"Folders","full_regression"},
            dataProvider = "dataprovideFolder", dependsOnMethods = "editFolder")
    public void removeFolder(String folderCreado, String folderNuevo) {

        //login
        LoginPage loginPage = PageFactory.initElements(this.getDriver(), LoginPage.class);
        LoginCommons.login(loginPage, userlogin, password);
        // NAVEGAR AL AGREGAR AL USUARIO
        this.getDriver().navigate().to(url_list_folder);

        FolderPage folderPage = PageFactory.initElements(this.getDriver(), FolderPage.class);
        FolderCommons.removeFolder(folderPage,folderNuevo);
    }
}
