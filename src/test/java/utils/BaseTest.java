package utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

public class BaseTest {
    protected static WebDriver driver = new ChromeDriver();
    @BeforeClass
    public void setUp(){
        driver = new ChromeDriver();
    }

    @AfterClass
    public static void tearDown(){
        WebDriverManage.quitDriver();
    }
}
