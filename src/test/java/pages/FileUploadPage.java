package pages;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.By;

public class FileUploadPage extends PageBase {

    private By headerBy = By.xpath("//div[@class='page-body']/h1");
    private By fileInputBy = By.id("fileinput");
    private By itsAFileBy = By.id("itsafile");
    private By uploadButtonBy = By.name("upload");
    public WebElement fileInput;
    public WebElement itsAFileRadioButton;
    public WebElement uploadButton;

    public FileUploadPage(WebDriver driver) {
        super(driver);
        this.driver.get("https://testpages.herokuapp.com/styled/file-upload-test.html");
        this.onInit();
    }

    public void onInit() {
        fileInput = this.waitAndReturnElement(fileInputBy);
        itsAFileRadioButton = this.waitAndReturnElement(itsAFileBy);
        uploadButton = this.waitAndReturnElement(uploadButtonBy);
    }

    public String getHeaderText() {
        return this.waitAndReturnElement(headerBy).getText();
    }


}
