import org.junit.*;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;

class AdminLoginPage extends PageBase {

    private By headerBy = By.xpath("//div[@class='page-body']/h1");
    private By formBy = By.xpath("//form");
    private By userNameInputBy = By.name("username");
    private By passwordInputBy = By.name("password");
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
        WebElement formElement = this.waitAndReturnElement(formBy);

        userNameInput.sendKeys("Admin");
        passwordInput.sendKeys("AdminPass");
        formElement.submit();
    }

    public void signOut() {
        WebElement logOutButton = this.waitAndReturnElement(logOutBy);
        logOutButton.click();
    }

}
