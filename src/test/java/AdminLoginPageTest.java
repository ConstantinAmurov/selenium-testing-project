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
import java.util.*;

public class AdminLoginPageTest {
    public WebDriver driver;
    public AdminLoginPage adminLoginPage;

    @Before
    public void setup() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        adminLoginPage = new AdminLoginPage(this.driver);
    }

    @Test
    public void staticPageTest() {
        Assert.assertTrue(adminLoginPage.getHeaderText().contains("Cookie Controlled Admin"));
    }

    @Test
    public void fillFormAndSignInTest() {
        adminLoginPage.fillFormAndSendRequest();

        String currentUrl = driver.getCurrentUrl();

        Assert.assertEquals(currentUrl, "https://testpages.herokuapp.com/styled/cookies/adminview.html");
    }

    @Test
    public void signOutTest() {

        adminLoginPage.fillFormAndSendRequest();

        adminLoginPage.signOut();

        String currentUrl = driver.getCurrentUrl();
        Assert.assertEquals(currentUrl, "https://testpages.herokuapp.com/styled/cookies/adminlogin.html");
    }

    @Test
    public void cookiesManipulationTest() {
        String currentUrl = driver.getCurrentUrl();
        Assert.assertEquals(currentUrl, "https://testpages.herokuapp.com/styled/cookies/adminlogin.html");

        adminLoginPage.setCookiesToLoggedIn();

        adminLoginPage.driver.navigate().refresh();

        currentUrl = driver.getCurrentUrl();
        // it should redirect to already logged in page
        Assert.assertEquals(currentUrl, "https://testpages.herokuapp.com/styled/cookies/adminview.html");
    }

    @After
    public void close() {
        if (driver != null) {
            driver.quit();
        }
    }
}
