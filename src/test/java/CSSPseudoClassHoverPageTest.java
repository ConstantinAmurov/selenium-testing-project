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

public class CSSPseudoClassHoverPageTest {
    public WebDriver driver;
    public CssPseudoClassHoverPage cssHoverPage;

    @Before
    public void setup() {
        WebDriverManager.chromedriver().setup();

        driver = new ChromeDriver();
        driver.manage().window().maximize();
        cssHoverPage = new CssPseudoClassHoverPage(this.driver);

    }

    @Test
    public void staticPageTest() {
        Assert.assertTrue(cssHoverPage.getHeaderText().contains("CSS Pseudo Class - hover"));
    }

    @Test
    public void hoverTest() {
        cssHoverPage.performHoverAction();
        
        By hoveParaEffectBy = By.id("hoverparaeffect");
        WebElement hoverParagrafEffect = cssHoverPage.waitAndReturnElement(hoveParaEffectBy);

        Assert.assertTrue(cssHoverPage.isElementVisible(hoverParagrafEffect));
    }

    @After
    public void close() {
        if (driver != null) {
            driver.quit();
        }
    }
}
