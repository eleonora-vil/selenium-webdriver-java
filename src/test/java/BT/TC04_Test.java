package BT;

import driver.driverFactory;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import java.time.Duration;
@Test
public class TC04_Test {
    public static void testCart() {
        WebDriver driver = driverFactory.getChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        driver.get("http://live.techpanda.org/");

        TC04_Page page = new TC04_Page(driver);

        page.clickOnMobileMenu();
        page.addToCompareSonyXperia();
        page.addToCompareIphone();
        page.clickOnCompareButton();


        String expectedHeading = "COMPARE PRODUCTS";
        String actualHeading = page.getPopupHeading();
        assert actualHeading.equals(expectedHeading) : "Popup heading does not match!";
        String x = page.getProductNames1();
        System.out.println(x);
        String y = page.getProductNames2();
        System.out.println(y);
        String z = page.getProductPrice1();
        System.out.println(z);
        String w = page.getProductPrice2();
        System.out.println(w);


        driver.quit();
    }
}