package gbsys.testcases;


import gbsys.commons.LoginCommons;
import gbsys.commons.UsuarioCommons;
import gbsys.configurations.selenium.TestCaseBase;

import gbsys.pageobjects.LoginPage;
import gbsys.pageobjects.UsuarioPage;
import gbsys.utils.ExcelUtility;
import jxl.read.biff.BiffException;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.*;


import java.io.IOException;
import java.util.ArrayList;

public class UserSuite extends TestCaseBase {


    private String passwordLogin;
    private String userlogin;
    private String url_add_user;

    // arraylist
    private ArrayList<String[]> usuarios = new ArrayList<>();


    @BeforeMethod(alwaysRun = true)
    @Parameters({"username", "password", "url_add_user"})
    private void getParameterLogin(String username, String pass, String url_add_user) {
        this.passwordLogin = pass;
        this.userlogin = username;
        this.url_add_user = url_add_user;


    }

     // dataprovided

     @DataProvider(name = "dataProviderUsuarios")
     public static Object[][] credentials() {
         return new Object[][]{
                 {"usuarioprueba1", "pecado34434!","65432usuarueba1"},
                 {"perro", "cebro3343434","8765usuarieba2"},
                 {"gato", "cabra9545454","usuario36538"},
                 {"pollo","bicicleta44343","8833prueba"}
         };
     }


    @DataProvider(name = "dataProviderUsuarioXLS")
    public static Object[][] dataProviderUsuarioXLS() throws IOException, BiffException {
        return new ExcelUtility("src/test/resources/excel/pruebaText.xls").getData();
    }


    ///////////////-RPIMER EJERCICIO

    @Test(groups = {"full_regression","login"})
    public void addUser(){
        //login
        LoginPage loginPage = PageFactory.initElements(this.getDriver(), LoginPage.class);
        LoginCommons.login(loginPage,userlogin,passwordLogin);


        // NAVEGAR AL AGREGAR AL USUARIO
        this.getDriver().navigate().to(url_add_user);


        UsuarioPage usuarioPage = PageFactory.initElements(this.getDriver(), UsuarioPage.class);
        usuarioPage.SummitAddUser();

        // getWindowHandle()
        String windowHandleBase = this.getDriver().getWindowHandle();

        for (String currentWindow : getDriver().getWindowHandles()) {
            if (this.getDriver().switchTo().window(currentWindow).getTitle().equals("Add user | Django site admin")) {
                break;
            }
        }

        ///
        //----
        usuarios.clear();
        String[] fila=  new String[2];
        String[] fila2=  new String[2];
        fila[0] = "Prueba1";  fila[1] = "Passwoord123456789";
        fila2[0] = "Prueba1";  fila2[1] = "nuevopasword1";
        usuarios.add(fila);
        usuarios.add(fila2);

        UsuarioCommons.addUser(usuarioPage,fila[0],fila[1]);

        // cambia el passwod
        usuarioPage.linkThisFormChangePassword();
        UsuarioCommons.changePassword(usuarioPage,fila2[1]);
        //activa el usuario
        UsuarioCommons.activeUser(usuarioPage);
        // desloguea
        loginPage.logOut();
        System.out.println("Método 'getWindowHandle()': ".concat(this.getDriver().getWindowHandle()));
        loginPage = PageFactory.initElements(this.getDriver(), LoginPage.class);

        // usuario creado.
        LoginCommons.login(loginPage, fila[0],fila2[1]);

    }




///////////////-SEGUNDO EJERCICIO

    @Test(description = "Este test case crea 4 usuarios",
            groups = {"full_regression","login"},
            dataProvider = "dataProviderUsuarios")
    public void addUserDataProvide(String userName, String password,String password2r) {

        //login
        LoginPage loginPage = PageFactory.initElements(this.getDriver(), LoginPage.class);
        LoginCommons.login(loginPage,userlogin, passwordLogin);


        // NAVEGAR AL AGREGAR AL USUARIO
        this.getDriver().navigate().to(url_add_user);


        UsuarioPage usuarioPage = PageFactory.initElements(this.getDriver(), UsuarioPage.class);
        usuarioPage.SummitAddUser();


        for (String currentWindow : getDriver().getWindowHandles()) {
            if (this.getDriver().switchTo().window(currentWindow).getTitle().equals("Add user | Django site admin")) {
                break;
            }
        }

        UsuarioCommons.addUser(usuarioPage,userName,password);

        // getWindowHandle()
        System.out.println("Método 'getTitle()': ".concat(this.getDriver().getTitle()));
        System.out.println("Método 'getWindowHandle()': ".concat(this.getDriver().getWindowHandle()));


        for (String currentWindow : getDriver().getWindowHandles()) {
            if (this.getDriver().switchTo().window(currentWindow).getTitle().equals("Change user | Django site admin")) {
                break;
            }
        }
        // cambia el passwod
        usuarioPage.linkThisFormChangePassword();
        UsuarioCommons.changePassword(usuarioPage,password2r);
        //activa el usuario
        UsuarioCommons.activeUser(usuarioPage);
        // desloguea

        loginPage.logOut();
        System.out.println("Método 'getWindowHandle()': ".concat(this.getDriver().getWindowHandle()));
        loginPage = PageFactory.initElements(this.getDriver(), LoginPage.class);

        // usuario creado.
        LoginCommons.login(loginPage,userName,password2r);
    }


    @Test(description = "Este test case crea 4 usuarios leyendo de un archivo de excel",
            groups = {"full_regression", "usuarios"},
            dataProvider = "dataProviderUsuarioXLS")
    public void addUserDataProvideExcel(String userName, String password,String password2r) {

        //login
        LoginPage loginPage = PageFactory.initElements(this.getDriver(), LoginPage.class);
        LoginCommons.login(loginPage,userlogin, passwordLogin);
        // NAVEGAR AL AGREGAR AL USUARIO
        this.getDriver().navigate().to(url_add_user);
        UsuarioPage usuarioPage = PageFactory.initElements(this.getDriver(), UsuarioPage.class);
        usuarioPage.SummitAddUser();

        UsuarioCommons.addUser(usuarioPage,userName,password);

        for (String currentWindow : getDriver().getWindowHandles()) {
            if (this.getDriver().switchTo().window(currentWindow).getTitle().equals("Change user | Django site admin")) {
                break;
            }
        }
        // cambia el passwod
        usuarioPage.linkThisFormChangePassword();
        UsuarioCommons.changePassword(usuarioPage,password2r);
        //activa el usuario
        UsuarioCommons.activeUser(usuarioPage);
        // desloguea

        loginPage.logOut();
        System.out.println("Método 'getWindowHandle()': ".concat(this.getDriver().getWindowHandle()));
        loginPage = PageFactory.initElements(this.getDriver(), LoginPage.class);

        // usuario creado.
        LoginCommons.login(loginPage,userName,password2r);
    }

    ///--------------------------------------------------------------------





}
