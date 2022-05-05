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

class CssPseudoClassHover extends PageBase {

    private By headerBy = By.xpath("//div[@class='page-body']/h1");

    public CssPseudoClassHover(WebDriver driver) {
        super(driver);
        this.driver.get("https://testpages.herokuapp.com/styled/csspseudo/css-hover.html");
    }

    public String getHeaderText() {
        return this.waitAndReturnElement(headerBy).getText();
    }

}
