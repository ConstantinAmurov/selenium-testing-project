package pages;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.By;

public class CssPseudoClassHoverPage extends PageBase {

    private By headerBy = By.xpath("//div[@class='page-body']/h1");
    private By hoverParaBy = By.id("hoverpara");
 
    public WebElement hoverParagraf;
    


    public CssPseudoClassHoverPage(WebDriver driver) {
        super(driver);
        this.driver.get("https://testpages.herokuapp.com/styled/csspseudo/css-hover.html");
        this.onInit();
    }

    private void onInit() {
        hoverParagraf = this.waitAndReturnElement(hoverParaBy);
    }

    public String getHeaderText() {
        return this.waitAndReturnElement(headerBy).getText();
    }

    public void performHoverAction() {
        this.actions.moveToElement(hoverParagraf);
        this.actions.click().build().perform();
    }

}
