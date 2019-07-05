package gbsys.commons;

import gbsys.pageobjects.DashBoardPage;
import gbsys.pageobjects.FolderPage;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class FolderCommons {

    public static void clickNewFolder(FolderPage folderPage){
        folderPage.clickNewFolder();
    }


    // Agregar nuevo folder ....
    public static void addNewFolder(FolderPage folderPage, String nombre) {
      folderPage.fillnameFolder(nombre);

    }

    public static void isNewFolderCreate(FolderPage folderPage){
        DashBoardPage dashBoardPage =  PageFactory.initElements(folderPage.getDriver(), DashBoardPage.class);
        Assert.assertTrue(dashBoardPage.isFolderListPage(),
                "No encontró la lista de folders");
    }

    public static void selectRowFolder(FolderPage folderPage, String nombre){
        folderPage.openEditFolder(nombre);
    }

    public static void removeFolder(FolderPage folderPage,String foldernuevo){
        folderPage.removeFolder(foldernuevo);
        DashBoardPage dashBoardPage =  PageFactory.initElements(folderPage.getDriver(), DashBoardPage.class);
        Assert.assertTrue(dashBoardPage.isRemoveFolder(),
                "No se eliminó el folder");
    }
}
