package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;

public class HomePageValidate {
    private WebDriver driver;
    private WebDriverWait wait;
    @FindBy(id = "_valueusername")
    WebElement textUsername;

    @FindBy(id = "_valuepassword")
    WebElement textPassword;

    @FindBy(id = "_valuecomments")
    WebElement textComments;

    public HomePageValidate(WebDriver driver){
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        PageFactory.initElements(driver,this);
    }

    public void validateUsername(String username){
        Assert.assertEquals(textUsername.getText(),username);
    }
    public void validatePassword(String password){
        Assert.assertEquals(textPassword.getText(),password);
    }
    public void validateComments(String comments){
        Assert.assertEquals(textComments.getText(),comments);
    }
    public void closeBrowser(){
        this.driver.quit();
    }
}
