import org.junit.*;
import io.github.bonigarcia.wdm.WebDriverManager;
import pages.MainPage;
import config.UsersDesiredCapability;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class MainPageTest {
    public WebDriver driver;

    @Before
    public void setup() {
        WebDriverManager.chromedriver().setup();
        UsersDesiredCapability capabilities = new UsersDesiredCapability();

        try {
            driver = new ChromeDriver(capabilities.getCapabilities());
        } catch (Exception e) {
            System.err.println("Adding Capabilities Error");
            driver = new ChromeDriver();
        } finally {
            driver.manage().window().maximize();
        }
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
