package BaiTap.TC07;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import POM.LoginPage;
import driver.driverFactory;

public class TC07 {
    @Test
    public void Main() {

        // Create a WebDriver instance
        WebDriver driver = driverFactory.getChromeDriver();

        LoginPage LoginPage = new LoginPage(driver);

        // Step 1: Go to http://live.techpanda.org/
        LoginPage.goToHomePage();

        // Step 2: Click on My Account link
        LoginPage.clickMyAccountLink();

        // Step 3: Login in application using previously created credential
        LoginPage.login("vil@gmail.com", "123456");

        // Step 4: Click on 'My Orders'
        LoginPage.clickMyOrders();

        // Step 5: Click on 'View Order'
        LoginPage.clickViewOrder();

        // Step 6: Click on 'Print Order' link
        LoginPage.clickPrintOrder();

        // Step 8: A popup will be opened as 'Select a destination' , select 'Save as
        // PDF' link.
        // LoginPage.clickSavePDF();

        // Close the browser
        // driver.quit();
    }
}
