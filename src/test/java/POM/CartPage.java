package POM;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class CartPage {
    private WebDriver driver;

    private By myWishlistLinkSelector = By.partialLinkText("MY WISHLIST");
    private By myAddToCartSelector = By.cssSelector("button[title='Add to Cart']");
    private By countryBox = By.id("country");
    private By stateBox = By.id("region_id");
    private By zipBox = By.id("postcode");
    private By estimateSelector = By.xpath("//span[contains(text(),'Estimate')]");
    private By shippingCostSelector = By.cssSelector("label[for='s_method_flatrate_flatrate'] span[class='price']");
    private By totalCostSelector = By.xpath("//span[contains(text(),'Update Total')]");
    private By totalCost = By.cssSelector("strong span[class='price']");
    private By msg = By.xpath("//li[@class='success-msg']/ul/li/span");
    private final By couponCodeInput = By.cssSelector("input[name='coupon_code']");
    private final By applyCouponButton = By.cssSelector("button[value='Apply']");
    private final By totalPrice = By.cssSelector("strong span[class='price']");

    public CartPage(WebDriver driver) {
        this.driver = driver;
    }

    public void clickOnMyWishlistLink() {
        driver.findElement(myWishlistLinkSelector).click();
    }

    public void clickOnMyAddToCartLink() {
        driver.findElement(myAddToCartSelector).click();
    }

    public void enterShippingInformation(String country, String state, String zip) {
        Select countryDropdown = new Select(driver.findElement(countryBox));
        countryDropdown.selectByVisibleText(country);

        Select stateDropdown = new Select(driver.findElement(stateBox));
        stateDropdown.selectByVisibleText(state);

        WebElement zipElement = driver.findElement(zipBox);
        zipElement.clear();
        zipElement.sendKeys(zip);
    }

    public void clickOnEstimateLink() {
        driver.findElement(estimateSelector).click();
    }

    public void selectShippingCost() {
        driver.findElement(shippingCostSelector).click();
    }

    public String getShippingCost() {
        return driver.findElement(shippingCostSelector).getText();
    }

    public void updateTotalCost() {
        driver.findElement(totalCostSelector).click();
    }

    public String getTotalCost() {
        return driver.findElement(totalCost).getText();
    }

    public void enterCouponCode(String code) {
        driver.findElement(couponCodeInput).sendKeys(code);
    }

    public void clickApplyCouponButton() {
        driver.findElement(applyCouponButton).click();
    }

    public String getNofication() {
        return driver.findElement(msg).getText();
    }

    public double Price() {
        return Double.parseDouble(driver.findElement(totalPrice).getText().replace("$", ""));
    }

    public double DiscountedPrice() {
        return Price() * 0.95;
    }
}
