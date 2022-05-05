import org.apache.commons.lang3.builder.ToStringExclude;
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

public class MainPageTest {
    public WebDriver driver;

    @Before
    public void setup() {
        WebDriverManager.chromedriver().setup();

        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    @Test
    public void staticPageTest() {
        MainPage mainPage = new MainPage(this.driver);
        Assert.assertTrue(mainPage.getHeaderText().contains("Test Pages For Automating"));
    }

    @Test
    public void backButtonPage() {
        MainPage mainPage = new MainPage(this.driver);
        String mainUrl = mainPage.driver.getCurrentUrl();
        String currentUrl;

        Assert.assertEquals("https://testpages.herokuapp.com/styled/index.html", mainUrl);

        mainPage.goToBasicWebPage();
        currentUrl = mainPage.driver.getCurrentUrl();
        Assert.assertEquals("https://testpages.herokuapp.com/styled/basic-web-page-test.html", currentUrl);

        mainPage.driver.navigate().back();
        currentUrl = mainPage.driver.getCurrentUrl();
        Assert.assertEquals(mainUrl, currentUrl);
    }

    @Test
    public void testJavaScriptExecutor() {
        MainPage mainPage = new MainPage(this.driver);
        JavascriptExecutor js = (JavascriptExecutor) driver;
        String currentUrl;

        js.executeScript("document.getElementById('basicpagetest').click();");

        // Check if redirected to correct url
        currentUrl = mainPage.driver.getCurrentUrl();
        Assert.assertEquals("https://testpages.herokuapp.com/styled/basic-web-page-test.html", currentUrl);

    }

    @After
    public void close() {
        if (driver != null) {
            driver.quit();
        }
    }
}
