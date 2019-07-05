package gbsys.configurations.selenium;


import org.testng.annotations.*;

public class TestCaseBase extends SeleniumBase {

    @BeforeSuite(alwaysRun = true)
    public void beforeSuite(){
        System.out.println("Estamos en la ejecucion del before suite");
    }

    @BeforeTest(alwaysRun = true)
    public void beforeTest(){
        System.out.println("Estamos en la ejecucion del before Test");
    }

    @BeforeMethod(alwaysRun = true)
    @Parameters({"browser", "app_admin_url"})
    public void beforeMethod(String browser, String url){
        System.out.println("Estamos en la ejecucion del before Method");
        setup(browser, url);
    }

    @BeforeClass(alwaysRun = true)
    public void beforeClass() {
        System.out.println("Estamos en la ejecucion del before class");
    }

    @AfterClass(alwaysRun = true)
    public void afterClass() {
        System.out.println("Estamos en la ejecucion del after class");
    }

    @AfterSuite(alwaysRun = true)
    public void afterSuite(){
        System.out.println("Estamos en la ejecucion del after suite");
    }

    @AfterTest(alwaysRun = true)
    public void afterTest(){
        System.out.println("Estamos en la ejecucion del after Test");
    }

    @AfterMethod(alwaysRun = true)
    public void afterMethod(){
        System.out.println("Estamos en la ejecucion del after Method");
        tearDown();
    }
}
