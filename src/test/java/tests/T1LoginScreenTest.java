package tests;

import common.BaseTest;
import common.PropertiesLoader;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.P01LoginScreen;

public class T1LoginScreenTest extends BaseTest {
    P01LoginScreen login;
    @BeforeClass
    private void initiateObjects(){
        login = new P01LoginScreen(getDriver());
    }
    @Test
    public void TC_001validateWelcomeScreen(){
        login.checkHomeScreen();
        login.checkLoginSuccessfully(PropertiesLoader.readEnvFile("USERNAME"),PropertiesLoader.readEnvFile("PASSWORD"));
    }


}
