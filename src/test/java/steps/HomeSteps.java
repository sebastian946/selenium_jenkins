package steps;

import org.testng.annotations.BeforeClass;
import pages.HomePage;
import pages.HomePageValidate;
import utils.BaseTest;

public class HomeSteps extends BaseTest {
    public static String username = "jio987";
    public static String password = "123456admin";
    public static String comments = "This my new comments";
    public static String pathfile = "D:\\Portfolio\\Selenium projects\\Selenium_Jenkins\\src\\test\\java\\file\\kurama}.jpg";
    public static String value = "ms1";
    public static String textVisible = "dd5";
    static HomePage home = new HomePage(driver);
    static HomePageValidate homeValidate = new HomePageValidate(driver);
    @BeforeClass
    public void con(){
        super.setUp();
    }
    public static void openUrl(){
        driver.get("https://testpages.eviltester.com/styled/basic-html-form-test.html");
    }
    public static void completeForms(){
        home.completeForm(username,password,comments,pathfile,value,textVisible);
    }
    public static void validateResults(){
        homeValidate.validateUsername(username);
        homeValidate.validatePassword(password);
        homeValidate.validateComments(comments);
        homeValidate.closeBrowser();
    }
}
