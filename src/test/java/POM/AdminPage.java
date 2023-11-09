package POM;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AdminPage {
    private WebDriver driver;
    private WebDriverWait wait;

    public AdminPage(WebDriver driver) {
        this.driver = driver;
    }

    private final By CloseBtn = By.cssSelector("a[title='close'] span");
    private final By NavBar = By.id("nav");
    private final By DBSales = By.linkText("Sales");
    private final By Orders = By.linkText("Orders");
    private final By OrderId = By.id("sales_order_grid_filter_real_order_id");
    private final By dateFrom = By.name("created_at[from]");
    private final By dateTo = By.name("created_at[to]");
    private final By Search = By.xpath("//button[@title='Search']");

    public void closeMsgBox() {
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(CloseBtn)).click();
    }

    public void goToOrders() {
        driver.findElement(NavBar).findElement(DBSales).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(Orders)).click();
    }

    public void search(String id, String from, String to) {
        driver.findElement(OrderId).sendKeys(id);
        driver.findElement(dateFrom).sendKeys(from);
        driver.findElement(dateTo).sendKeys(to);
        driver.findElement(Search).click();

    }

}
