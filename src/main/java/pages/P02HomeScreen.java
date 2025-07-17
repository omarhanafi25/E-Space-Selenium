package pages;

import base.WebPageHelper;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class P02HomeScreen extends WebPageHelper {
    public P02HomeScreen(WebDriver driver) {
        super(driver);
    }
    private final By side_icon_arrow = By.xpath("//*[@class='oxd-icon-button oxd-main-menu-button' and @type='button']");
    private final By orange_logo = By.xpath("//*[@alt='client brand banner']");
    private final By admin_text= By.xpath("//*[normalize-space()='Admin']");
    private final By admin_icon = By.xpath("(//*[@role='presentation'])[2]");

    public void checkSideBar (){
        elementsValidator(orange_logo,admin_text,admin_icon);
    }
    public void navigateToAdmin(){
        clickOnElement(admin_text);
        waitForVisibilityOfElement(users_system_text);
    }



}
