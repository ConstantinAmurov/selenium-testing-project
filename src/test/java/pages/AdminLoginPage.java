package pages;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.By;
import org.openqa.selenium.Cookie;

public class AdminLoginPage extends PageBase {

    private By headerBy = By.xpath("//div[@class='page-body']/h1");
    private By formBy = By.xpath("//form");
    private By userNameInputBy = By.name("username");
    private By passwordInputBy = By.name("password");
    private By rememberMeBy = By.xpath("//input[@type='checkbox']");
    private By logOutBy = By.id("navadminlogout");

    public AdminLoginPage(WebDriver driver) {
        super(driver);
        this.driver.get("https://testpages.herokuapp.com/styled/cookies/adminlogin.html");
    }

    public String getHeaderText() {
        return this.waitAndReturnElement(headerBy).getText();
    }

    public void fillFormAndSendRequest() {
        WebElement userNameInput = this.waitAndReturnElement(userNameInputBy);
        WebElement passwordInput = this.waitAndReturnElement(passwordInputBy);
        WebElement rememberMeCheckBox = this.waitAndReturnElement(rememberMeBy);
        WebElement formElement = this.waitAndReturnElement(formBy);

        userNameInput.sendKeys("Admin");
        passwordInput.sendKeys("AdminPass");
        rememberMeCheckBox.click();
        formElement.submit();
    }

    public void signOut() {
        WebElement logOutButton = this.waitAndReturnElement(logOutBy);
        logOutButton.click();
    }

    public void setCookiesToLoggedIn() {
        Cookie loggedInCookie = new Cookie("loggedin", "Admin");
        this.driver.manage().addCookie(loggedInCookie);
    }

}
