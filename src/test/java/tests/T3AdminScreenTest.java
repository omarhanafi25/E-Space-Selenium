package tests;

import common.BaseTest;
import common.PropertiesLoader;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.P01LoginScreen;
import pages.P02HomeScreen;
import pages.P03AdminScreen;

public class T3AdminScreenTest extends BaseTest {
    P02HomeScreen home;
    P01LoginScreen login;
    P03AdminScreen admin;

    @BeforeClass
    private void initiateObjects(){
        login = new P01LoginScreen(getDriver());
        home = new P02HomeScreen(getDriver());
        admin= new P03AdminScreen(getDriver());
    }
    @Test
    public void TC_01validateUSerSearch(){
        login.checkLoginSuccessfully(PropertiesLoader.readEnvFile("USERNAME"),PropertiesLoader.readEnvFile("PASSWORD"));
        home.checkSideBar();
        home.navigateToAdmin();
        admin.SearchAdmin(PropertiesLoader.readEnvFile("USERNAME"));
    }
    @Test
    public void TC_02validateAdminCantBEDeleted(){
        admin.checkAdminDelete();
    }
}
