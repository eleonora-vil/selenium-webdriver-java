package BaiTap.TC03;

import java.io.File;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.By.ByXPath;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import dev.failsafe.internal.util.Assert;
import driver.driverFactory;

public class TC03 {

    @Test
    public void TC02() {
        // 1. Init web-driver session
        WebDriver driver = driverFactory.getChromeDriver();
        try {
            // 2. Open target page - Login Form
            driver.get("http://live.techpanda.org/index.php/");
            // 3: Click on MOBILE menu
            WebElement mobileMenu = driver.findElement(By.linkText("MOBILE"));
            mobileMenu.click();
            // 3. In the list of all mobile , ADD TO CART for Sony Xperia mobile
            WebElement addToCart = driver.findElement(
                    By.xpath("//h2[a='Sony Xperia']/following-sibling::div//button[@title='Add to Cart']"));
            addToCart.click();
            // 4. Change quantity value to 1000 and UPDATE
            WebElement selectqQuantity = driver.findElement(By.cssSelector("input[title ='Qty']"));
            selectqQuantity.clear();
            selectqQuantity.sendKeys("1000");
            TakesScreenshot beforeSC = ((TakesScreenshot) driver);
            File srcFile1 = beforeSC.getScreenshotAs(OutputType.FILE);
            FileHandler.copy(srcFile1, new File(
                    "D:\\Study\\Fall 2023\\SWT301\\Ex\\Test By sele\\selenium-webdriver-java\\src\\test\\java\\BaiTap\\TC03\\BeforeUpdate.png"));
            WebElement updateButton = driver.findElement(By.xpath("//button[@title='Update']"));
            updateButton.click();
            TakesScreenshot afterSC = ((TakesScreenshot) driver);
            File srcFile2 = afterSC.getScreenshotAs(OutputType.FILE);
            FileHandler.copy(srcFile2, new File(
                    "D:\\Study\\Fall 2023\\SWT301\\Ex\\Test By sele\\selenium-webdriver-java\\src\\test\\java\\BaiTap\\TC03\\AfteeUpdate.png"));
            //// 5. Verify the error message
            WebElement errormsg = driver.findElement(By.xpath("li[@class=='error-msg']"));
            String expectedMsg = "The requested quantity for 'Sony Xperia' is not available.";
            if (errormsg.getText().equals(expectedMsg)) {
                System.out.println("error message is match");
            } else {
                System.out.println("error message doesn't match");
            }
            // 6.Click empty cart
            WebElement emptyCart = driver.findElement(By.xpath("button[@title='Empty Cart']"));
            emptyCart.click();
            // 7. Verify that the cart is empty
            WebElement emptyCartMessage = driver.findElement(By.xpath("//h1[text()='SHOPPING CART IS EMPTY']"));
            if (emptyCartMessage.isDisplayed()) {
                System.out.println("Shopping cart is empty.");
            } else {
                System.out.println("Shopping cart is not empty.");
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        // 8. Quit browser session
        driver.quit();
        // }
    }
}
