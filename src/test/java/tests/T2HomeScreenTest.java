package tests;

import common.BaseTest;
import common.PropertiesLoader;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.P01LoginScreen;
import pages.P02HomeScreen;

public class T2HomeScreenTest extends BaseTest {
    P02HomeScreen home;
    P01LoginScreen login;

    @BeforeClass
    private void initiateObjects(){
        login = new P01LoginScreen(getDriver());
        home = new P02HomeScreen(getDriver());
    }
    @Test
    public void validateSideBar(){
        login.checkLoginSuccessfully(PropertiesLoader.readEnvFile("USERNAME"),PropertiesLoader.readEnvFile("PASSWORD"));
        home.checkSideBar();
        home.navigateToAdmin();
    }
}
