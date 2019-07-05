package gbsys.commons;

import gbsys.pageobjects.DashBoardPage;
import gbsys.pageobjects.UsuarioPage;
import org.testng.Assert;

public class UsuarioCommons {


    // Agregar usuario ....
    public static void addUser(UsuarioPage usuarioPage, String userName, String password1) {
        usuarioPage.fillPassword1(password1);
        usuarioPage.fillPassword2(password1);
        usuarioPage.fillUserName(userName);
        DashBoardPage dashBoardPage = usuarioPage.submitSaveUser();
        Assert.assertTrue(dashBoardPage.isSuccessAddUser(),
                "No navegó a la pagina de lista de usuarios");
    }

    // cambiar contraseña de Usuario ...
    public static void changePassword(UsuarioPage usuarioPage, String password1) {
        usuarioPage.fillPassword1(password1);
        usuarioPage.fillPassword2(password1);
        DashBoardPage dashBoardPage = usuarioPage.SummitChangePassword();
        Assert.assertTrue(dashBoardPage.isSuccessChangeUserPassword(),
                "No cambió la contraseña");
    }

    public static void activeUser(UsuarioPage usuarioPage){
        usuarioPage.activeUser();
    }



}
