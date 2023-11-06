package BaiTap.TC06_demo;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.AssertJUnit;
import org.testng.annotations.Test;

import POM.CheckOutPage_demo;
import POM.LoginPage;

public class TC06 {
    /**
     * @throws InterruptedException
     * 
     */
    @Test
    public void TC06() throws InterruptedException {
        WebDriver driver = new ChromeDriver();

        // Step 1: Go to the website
        driver.get("http://live.techpanda.org/");

        // Step 2: Click on ACCOUNT
        LoginPage Login = new LoginPage(driver);

        // Step 3: input account
        Login.clickMyAccountLink();
        // Login.clickMyAccountLink();
        Login.enterEmail("vil@gmail.com");
        Login.enterPassword("123456");

        // Step 4: Click on Login
        Login.clickLoginButton();

        // 5
        WebElement wishList = driver.findElement(By.linkText("MY WISHLIST"));
        wishList.click();
        WebElement addToCart = driver.findElement(By.xpath("//button[@title='Add to Cart']"));
        addToCart.click();
        WebElement CheckOut = driver.findElement(By.xpath("//button[@title='Proceed to Checkout']"));
        CheckOut.click();
        WebElement bilingContinute = driver.findElement(By.xpath("//button[@title='Continue']"));
        bilingContinute.click();
        try {

            driver.findElement(By.id("shipping-address-select")).click();
            WebElement selectShipping = driver.findElement(By.id("shipping-address-select"));
            Select selectCountryOptionShipping = new Select(selectShipping);
            int SselectShipping = selectCountryOptionShipping.getOptions().size();
            selectCountryOptionShipping.selectByIndex(SselectShipping - 1);
            // selectCountryOptionShipping.selectByVisibleText("New Address");
        } catch (Exception e) {
            System.out.println("No dropdown element present");
        }
        //
        CheckOutPage_demo shipping = new CheckOutPage_demo(driver);
        // shipping.enterselectShipping();

        shipping.enterFirstNameShipping("VIl");
        shipping.enterLastNameShipping("elen");
        shipping.enterAddressShipping("abcde");
        shipping.enterCityShipping("AZ");
        shipping.enterCountryShipping("US");
        shipping.enterRegionShipping("14");
        shipping.enterTelephoneShipping("123456789");
        shipping.clickContinueButton();

        // Quit
        // driver.quit();
    }
}
