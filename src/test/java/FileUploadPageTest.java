import org.junit.*;
import io.github.bonigarcia.wdm.WebDriverManager;
import pages.FileUploadPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import org.openqa.selenium.By;


public class FileUploadPageTest {

    public WebDriver driver;
    public FileUploadPage fileUploadPage;

    @Before
    public void setup() {
        WebDriverManager.chromedriver().setup();

        driver = new ChromeDriver();
        driver.manage().window().maximize();
        fileUploadPage = new FileUploadPage(this.driver);

    }

    @Test
    public void staticPageTest() {
        Assert.assertTrue(fileUploadPage.getHeaderText().contains("Upload a File"));
    }

    @Test
    public void uploadFileTest() {
        String pathToFile = "/home/ubuntu/response.json";
        String fileName = "response.json";
        
        fileUploadPage.fileInput.sendKeys(pathToFile);
        fileUploadPage.itsAFileRadioButton.click();
        fileUploadPage.uploadButton.click();

        WebElement uploadedFileName = fileUploadPage.waitAndReturnElement(By.id("uploadedfilename"));

        Assert.assertEquals(fileName, uploadedFileName.getText());
    }

    @After
    public void close() {
        if (driver != null) {
            driver.quit();
        }
    }

}
