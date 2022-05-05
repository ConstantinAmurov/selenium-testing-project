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
