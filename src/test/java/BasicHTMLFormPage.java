
import org.junit.*;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;

class BasicHTMLFormPage extends PageBase {

    private By headerBy = By.xpath("//div[@class='page-body']/h1");
    private By formBy = By.name("HTMLFormElements");
    private By userNameBy = By.name("username");
    private By passwordBy = By.name("password");
    private By commentsBy = By.name("comments");
    private By fileBy = By.name("filename");
    private By checkBox2By = By.xpath("//input[@type='checkbox'][2]");
    private By radio2By = By.xpath("//input[@name='radioval'][2]");
    private By multipleSelectorBy = By.name("multipleselect[]");
    private By simpleDropDownBy = By.name("dropdown");

    WebElement form;
    WebElement userNameInput;
    WebElement passwordInput;
    WebElement commentsInput;
    WebElement fileInput;
    WebElement checkbox2Input;
    WebElement radio2Input;

    Select multipleSelectorInput;
    Select simpleDropDownInput;

    public BasicHTMLFormPage(WebDriver driver) {
        super(driver);
        this.driver.get("https://testpages.herokuapp.com/styled/basic-html-form-test.html");
        this.onInit();
    }

    public void onInit() {
        form = this.waitAndReturnElement(formBy);
        userNameInput = this.waitAndReturnElement(userNameBy);
        passwordInput = this.waitAndReturnElement(passwordBy);
        commentsInput = this.waitAndReturnElement(commentsBy);
        fileInput = this.waitAndReturnElement(fileBy);
        checkbox2Input = this.waitAndReturnElement(checkBox2By);
        radio2Input = this.waitAndReturnElement(radio2By);
        multipleSelectorInput = new Select(this.waitAndReturnElement(multipleSelectorBy));
        simpleDropDownInput = new Select(this.waitAndReturnElement(simpleDropDownBy));
    }

    public String getHeaderText() {
        return this.waitAndReturnElement(headerBy).getText();
    }

    public void fillInFormAndSubmit() {
        userNameInput.sendKeys("Admin");
        passwordInput.sendKeys("AdminPass");

        commentsInput.clear();
        commentsInput.sendKeys("This is a comment");

        checkbox2Input.click();
        radio2Input.click();

        fileInput.sendKeys("/home/ubuntu/response.json");

        multipleSelectorInput.deselectAll();
        multipleSelectorInput.selectByValue("ms3");
        multipleSelectorInput.selectByValue("ms1");

        simpleDropDownInput.selectByValue("dd1");

        form.submit();
    }

}
