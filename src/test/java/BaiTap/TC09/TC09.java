package BaiTap.TC09;

import POM.CartPage;
import POM.HomePage;

import driver.driverFactory;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TC09 {
    @Test
    public void TC09() {
        WebDriver driver = driverFactory.getChromeDriver();
        driver.get("http://live.techpanda.org/");

        HomePage page = new HomePage(driver);

        page.clickOnMobileMenu();
        page.addToCartIphone();

        CartPage cartPage = new CartPage(driver);

        cartPage.enterCouponCode("GURU50");
        cartPage.clickApplyCouponButton();
        Double price = cartPage.Price();
        System.out.println(price);
        if (cartPage.getNofication() != null) {
            System.out.println(cartPage.getNofication());
            Double discount = cartPage.Price();

            try {
                Assert.assertNotEquals(price, discount);

            } catch (Exception e) {
                System.out.println();
                driver.quit();
            }
        } else {

            System.out.println("Price is discounted by 5%");
        }

        // driver.quit();
    }
}
