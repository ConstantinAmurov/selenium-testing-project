import org.junit.*;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;

class DragAndDropPage extends PageBase {

    private By headerBy = By.xpath("//div[@class='page-body']/h1");
    private By dragabble1By = By.id("draggable1");
    private By dragabble2By = By.id("draggable2");
    private By droppable1By = By.id("droppable1");
    private By droppable2By = By.id("droppable2");

    public WebElement draggableElem1;
    public WebElement draggableElem2;
    public WebElement droppableElem1;
    public WebElement droppableElem2;

    public DragAndDropPage(WebDriver driver) {
        super(driver);
        this.driver.get("https://testpages.herokuapp.com/styled/drag-drop-javascript.html");
        this.onInit();
    }

    public void onInit() {
        draggableElem1 = this.waitAndReturnElement(dragabble1By);
        draggableElem2 = this.waitAndReturnElement(dragabble2By);
        droppableElem1 = this.waitAndReturnElement(droppable1By);
        droppableElem2 = this.waitAndReturnElement(droppable2By);
    }

    public String getHeaderText() {
        return this.waitAndReturnElement(headerBy).getText();
    }

    public void dragBothElementsIntoPlace() {
        this.actions.dragAndDrop(draggableElem1, droppableElem1).perform();
        this.actions.dragAndDrop(draggableElem2, droppableElem1).perform();
    }

}
