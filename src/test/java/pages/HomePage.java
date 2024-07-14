package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class HomePage {
    private WebDriver driver;
    private WebDriverWait wait;

    @FindBy(name = "username")
    WebElement input_username;

    @FindBy(name = "password")
    WebElement input_password;

    @FindBy(name = "comments")
    WebElement textarea_comments;

    @FindBy(name = "filename")
    WebElement input_upload_file;

    @FindAll({@FindBy(xpath = "//input[@type='checkbox']")})
    List<WebElement> input_checkbox;

    @FindAll({@FindBy(xpath = "//input[@type='radio']")})
    List<WebElement> input_radio;

    @FindBy(name = "multipleselect[]")
    WebElement multiple_select;

    @FindBy(name = "dropdown")
    WebElement dropdown;

    @FindBy(xpath = "//input[@value=\"submit\"]")
    WebElement submit_button;

    public HomePage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        PageFactory.initElements(driver, this);
    }

    public void typeUsername(String username) {
        wait.until(ExpectedConditions.visibilityOf(input_username)).sendKeys(username);
    }

    public void typePassword(String password) {
        wait.until(ExpectedConditions.visibilityOf(input_password)).sendKeys(password);
    }

    public void typeComments(String comments) {
        wait.until(ExpectedConditions.visibilityOf(textarea_comments));
        textarea_comments.clear();
        textarea_comments.sendKeys(comments);
    }

    public void uploadFile(String pathFile) {
        wait.until(ExpectedConditions.visibilityOf(input_upload_file)).sendKeys(pathFile);
    }

    public void clickCheckbox() {
        for (WebElement check : input_checkbox) {
            wait.until(ExpectedConditions.elementToBeClickable(check)).click();
        }
    }

    public void clickRadio() {
        wait.until(ExpectedConditions.elementToBeClickable(input_radio.get(0))).click();
    }

    public void selectMultipleSelect(String value) {
        Select select = new Select(multiple_select);
        wait.until(ExpectedConditions.visibilityOf(multiple_select));
        select.selectByValue(value);
    }

    public void clickOptionDropdown(String textVisible) {
        Select select = new Select(dropdown);
        wait.until(ExpectedConditions.visibilityOf(dropdown));
        select.selectByValue(textVisible);
    }

    public void clickButtonSubmit() {
        wait.until(ExpectedConditions.elementToBeClickable(submit_button)).click();
    }

    public void completeForm(String username, String password, String comments, String pathFile, String value, String textVisible) {
        typeUsername(username);
        typePassword(password);
        typeComments(comments);
        uploadFile(pathFile);
        clickCheckbox();
        clickRadio();
        selectMultipleSelect(value);
        clickOptionDropdown(textVisible);
        clickButtonSubmit();
    }
}
