import org.junit.*;
import io.github.bonigarcia.wdm.WebDriverManager;
import pages.BasicHTMLFormPage;
import org.openqa.selenium.WebDriver;

import org.openqa.selenium.chrome.ChromeDriver;


public class BasicHTMLFormPageTest {
    public WebDriver driver;

    @Before
    public void setup() {
        WebDriverManager.chromedriver().setup();

        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    @Test
    public void staticPageTest() {
        BasicHTMLFormPage basicHTMLFormPage = new BasicHTMLFormPage(this.driver);
        Assert.assertTrue(basicHTMLFormPage.getHeaderText().contains("Basic HTML Form Example"));
    }

    @Test
    public void formSubmitTest() {
        BasicHTMLFormPage basicHTMLFormPage = new BasicHTMLFormPage(this.driver);

        basicHTMLFormPage.fillInFormAndSubmit();

        // Check if redirect was done successfuly
        String currentUrl = driver.getCurrentUrl();
        Assert.assertEquals(currentUrl, "https://testpages.herokuapp.com/styled/the_form_processor.php");
        // Check if output data corresponds to our inputs;
    }
    

    @After
    public void close() {
        if (driver != null) {
            driver.quit();
        }
    }
}
