package POM;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage {
    private WebDriver driver;

    public HomePage(WebDriver driver) {
        this.driver = driver;
    }

    private final By mobileMenu = By.linkText("MOBILE");
    private final By addToCartIphone = By.cssSelector(
            "body > div:nth-child(1) > div:nth-child(2) > div:nth-child(3) > div:nth-child(1) > div:nth-child(2) > div:nth-child(1) > div:nth-child(3) > ul:nth-child(2) > li:nth-child(1) > div:nth-child(2) > div:nth-child(4) > button:nth-child(1)");

    public void clickOnMobileMenu() {
        driver.findElement(mobileMenu).click();
    }

    public void addToCartIphone() {
        driver.findElement(addToCartIphone).click();
    }

}
