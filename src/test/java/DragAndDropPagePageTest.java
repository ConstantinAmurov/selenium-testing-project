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

public class DragAndDropPagePageTest {
    public WebDriver driver;
    public DragAndDropPage dragAndDropPage;

    @Before
    public void setup() {
        WebDriverManager.chromedriver().setup();

        driver = new ChromeDriver();
        driver.manage().window().maximize();
        dragAndDropPage = new DragAndDropPage(this.driver);

    }

    @Test
    public void staticPageTest() {
        Assert.assertTrue(dragAndDropPage.getHeaderText().contains("Drag And Drop Examples"));
    }

    @Test
    public void dragAndDropTest() {
        Assert.assertEquals("Drop here", dragAndDropPage.droppableElem1.getText());

        dragAndDropPage.dragBothElementsIntoPlace();

        Assert.assertEquals("Dropped!", dragAndDropPage.droppableElem1.getText());

    }

    @After
    public void close() {
        if (driver != null) {
            driver.quit();
        }
    }
}
