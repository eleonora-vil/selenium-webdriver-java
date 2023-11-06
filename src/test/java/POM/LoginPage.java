package POM;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.time.Duration;

public class LoginPage {
    WebDriver driver;
    WebElement Elem = null;
    WebDriverWait wait = null;
    By AccountLink = By.linkText("ACCOUNT");
    By myAccountLink = By.linkText("MY ACCOUNT");
    By emailInputLocator = By.id("email");
    By passwordInputLocator = By.id("pass");
    By LoginButton = By.xpath("//button[@title='Login']");
    By myAccountLinkSelector = By.linkText("MY ACCOUNT");
    By MyOrder = By.linkText("MY ORDERS");
    By ViewOrder = By.xpath("//tr[@class='first odd']//a[contains(text(),'View Order')]");
    By PrintOrder = By.linkText("Print Order");
    By Reorder = By.linkText("REORDER");
    By Qty = By.cssSelector("input[title='Qty']");
    By Update = By.cssSelector("button[title='Update']");
    By OldGrandTotal = By.cssSelector("strong span[class='price']");
    By GrandTotal = By.cssSelector("strong span[class='price']");
    By OrderNumber = By.cssSelector("#order_number");

    public LoginPage(WebDriver driver) {

        this.driver = driver;

    }

    public void goToHomePage() {
        driver.get("http://live.techpanda.org/");
    }

    public void clicAccountLink() {
        driver.findElement(AccountLink).click();
    }

    public void clickMyAccountLink() {
        driver.findElement(myAccountLink).click();
    }

    public void enterEmail(String email) {
        WebElement emailElement = driver.findElement(emailInputLocator);
        emailElement.clear();
        emailElement.sendKeys(email);
    }

    public void enterPassword(String password) {
        WebElement passwordElement = driver.findElement(passwordInputLocator);
        passwordElement.clear();
        passwordElement.sendKeys(password);
    }

    public void clickLoginButton() {
        driver.findElement(LoginButton).click();
    }

    public void clickOnMyAccountLink() {
        driver.findElement(myAccountLinkSelector).click();
    }

    public void login(String emailAddress, String password) {
        Elem = driver.findElement(emailInputLocator);
        Elem.clear();
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.attributeToBe(emailInputLocator, "value", ""));
        Elem.sendKeys(emailAddress);

        Elem = driver.findElement(passwordInputLocator);
        Elem.clear();
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.attributeToBe(passwordInputLocator, "value", ""));
        Elem.sendKeys(password);

        driver.findElement(LoginButton).click();
    }

    public void clickMyOrders() {
        driver.findElement(MyOrder).click();
    }

    public void clickViewOrder() {
        driver.findElement(ViewOrder).click();

    }

    public void clickPrintOrder() {
        driver.findElement(PrintOrder).click();
        for (String x : driver.getWindowHandles()) {
            driver.switchTo().window(x);
        }
    }

    public void clickReorder() {
        driver.findElement(Reorder).click();
    }

    public String getOldGrandTotal() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        return wait.until(ExpectedConditions.visibilityOfElementLocated(OldGrandTotal)).getText();
    }

    public void changeQty(String qty) {

        WebElement qtyField = driver.findElement(Qty);
        qtyField.clear();
        qtyField.sendKeys(qty);
    }

    public void clickUpdate() {
        driver.findElement(Update).click();
    }

    public String getGrandTotal() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        return wait.until(ExpectedConditions.visibilityOfElementLocated(GrandTotal)).getText();
    }

}
