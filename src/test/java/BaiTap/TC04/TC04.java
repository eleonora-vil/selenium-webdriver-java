package BaiTap.TC04;

import driver.driverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TC04 {
    @Test
    public void verifyCanCompareTwoProducts() {

        try {
            WebDriver driver = new ChromeDriver();

            // 1. Go to http://live.techpanda.org/
            driver.get("http://live.techpanda.org/");

            // 2. Click on "MOBILE" menu
            WebElement mobileMenu = driver.findElement(By.linkText("MOBILE"));
            mobileMenu.click();

            // 3. Click on "Add To Compare" for Sony Xperia
            WebElement sonyXperiaCompare = driver.findElement(By.cssSelector(
                    "body > div:nth-child(1) > div:nth-child(2) > div:nth-child(3) > div:nth-child(1) > div:nth-child(2) > div:nth-child(1) > div:nth-child(3) > ul:nth-child(2) > li:nth-child(2) > div:nth-child(2) > div:nth-child(4) > ul:nth-child(2) > li:nth-child(2) > a:nth-child(2)"));
            sonyXperiaCompare.click();

            // 3. Click on "Add To Compare" for iPhone
            WebElement iPhoneCompare = driver.findElement(By.cssSelector(
                    "body > div:nth-child(1) > div:nth-child(2) > div:nth-child(3) > div:nth-child(1) > div:nth-child(2) > div:nth-child(1) > div:nth-child(4) > ul:nth-child(2) > li:nth-child(3) > div:nth-child(2) > div:nth-child(4) > ul:nth-child(2) > li:nth-child(2) > a:nth-child(2)"));
            iPhoneCompare.click();

            // 4. Click on "COMPARE" button
            WebElement compareButton = driver.findElement(By.cssSelector("button[title='Compare']"));
            compareButton.click();

            // 5. Verify the pop-up window and check that the products are reflected in it
            String parentWindowHandle = driver.getWindowHandle();
            for (String windowHandle : driver.getWindowHandles()) {
                driver.switchTo().window(windowHandle);
                if (driver.getTitle().equals("Products Comparison List - Magento Commerce")) {
                    System.out.println("Pop-up window is opened.");
                    break;
                }
            }

            WebElement popUpContent = driver.findElement(By.id("product_comparison"));
            String popUpText = popUpContent.getText();
            Assert.assertTrue(popUpText.contains("IPhone"));
            Assert.assertTrue(popUpText.contains("SAMSUNG GALAXY"));

            // 6. Close the Popup Window
            // driver.close();
            driver.switchTo().window(parentWindowHandle);

            driver.quit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
