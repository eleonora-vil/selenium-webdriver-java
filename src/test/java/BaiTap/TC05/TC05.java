package BaiTap.TC05;

import POM.RegisterPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.AssertJUnit;
import org.testng.annotations.Test;

import java.util.UUID;

public class TC05 {
    @Test
    public void TC0505() {

        WebDriver driver = new ChromeDriver();

        // Step 1: Go to the website
        driver.get("http://live.techpanda.org/");

        // Step 3: Click on ACCOUNT
        WebElement accountMenu = driver.findElement(By.cssSelector(".account-cart-wrapper .label"));
        accountMenu.click();

        // Step 4: Click on Register
        WebElement registerMenu = driver.findElement(By.cssSelector("a[title='Register']"));
        registerMenu.click();

        // Step 5: Input fields
        RegisterPage registerPage = new RegisterPage(driver);

        // Step 5: Input fields using the Page Object Model
        registerPage.enterFirstName("Vi");
        registerPage.enterLastName("Elen");

        String randomEmail = generateRandomEmail();
        registerPage.enterEmail(randomEmail);
        registerPage.enterPassword("123456");
        registerPage.enterConfirmPassword("123456");

        // Step 6: Click on REGISTER
        registerPage.clickRegisterButton();

        // Step 7: Click on TV
        WebElement tvMenu = driver.findElement(By.linkText("TV"));
        tvMenu.click();

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // Step 8: Click on Add To Wishlist
        WebElement wishList = driver.findElement(By.cssSelector(
                "body > div:nth-child(1) > div:nth-child(2) > div:nth-child(3) > div:nth-child(1) > div:nth-child(2) > div:nth-child(1) > div:nth-child(2) > ul:nth-child(2) > li:nth-child(1) > div:nth-child(2) > div:nth-child(4) > ul:nth-child(2) > li:nth-child(1) > a:nth-child(1)"));
        wishList.click();

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // Step 9: Click on Share WishList
        WebElement shareWishList = driver.findElement(By.cssSelector("button[title='Share Wishlist']"));
        shareWishList.click();

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // Step 10: Input shared Email
        WebElement sharedEmail = driver.findElement(By.cssSelector("#email_address"));
        sharedEmail.click();
        sharedEmail.sendKeys("vinh@gmail.com ");

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // Step 11: Input message
        WebElement sharedMessage = driver.findElement(By.cssSelector("#message"));
        sharedMessage.click();
        sharedMessage.sendKeys("This is great but don't buy it ");

        try {
            Thread.sleep(1000); // Độ trễ 10 giây (10.000 milliseconds)
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // Step 12: Share WishList
        WebElement share = driver.findElement(By.cssSelector("button[title='Share Wishlist']"));
        share.click();

        // Step 13: Check
        WebElement successMessageElement = driver.findElement(By.cssSelector("li[class='success-msg'] ul li span"));
        String successMessage = successMessageElement.getText();
        String expectedMessage = "Your Wishlist has been shared.";

        AssertJUnit.assertEquals(successMessage, expectedMessage);
        try {
            Thread.sleep(1000); // Độ trễ 10 giây (10.000 milliseconds)
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        // Quit
        driver.quit();
    }

    private String generateRandomEmail() {
        // Generate a random email using UUID
        String emailPrefix = UUID.randomUUID().toString().substring(0, 10);
        return emailPrefix + "@gmail.com";

    }

}