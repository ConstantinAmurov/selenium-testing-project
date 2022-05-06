package pages;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.By;

public class MainPage extends PageBase {

    private By headerBy = By.xpath("//div[@class='page-body']/h1");
    private By basicPageBy = By.id("basicpagetest");
    public MainPage(WebDriver driver) {
        super(driver);
        this.driver.get("https://testpages.herokuapp.com/styled/index.html");
    }

    public String getHeaderText() {
        return this.waitAndReturnElement(headerBy).getText();
    }

    public void goToBasicWebPage() {
        WebElement basicPageLink = this.waitAndReturnElement(basicPageBy);
        basicPageLink.click();
    }

}
