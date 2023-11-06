package BaiTap.TC08;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import POM.CheckOutPage;
import POM.LoginPage;
import driver.driverFactory;

public class TC08 {
    @Test
    public void Main() {

        // Create a WebDriver instance
        WebDriver driver = driverFactory.getChromeDriver();

        LoginPage page = new LoginPage(driver);
        CheckOutPage checkoutPage = new CheckOutPage(driver);

        // Step 1: Go to http://live.techpanda.org/
        page.goToHomePage();

        // Step 2: Click on My Account link
        page.clickMyAccountLink();

        // Step 3: Login in application using previously created credential
        page.login("vil@gmail.com", "123456");

        // Step 4: Click on 'REORDER' link , change QTY & click Update
        page.clickReorder();
        String OldgrandTotal = page.getOldGrandTotal();
        page.changeQty("10");
        page.clickUpdate();

        // Step 5: Verify Grand Total is changed
        String grandTotal = page.getGrandTotal();
        assert !grandTotal.equals(OldgrandTotal) : "Failed update Grand Total!";
        System.out.println("Grand Total Updated");

        // Step 6: Complete Billing & Shipping Information
        checkoutPage.clickProceedToCheckout();

        checkoutPage.enterBillingInformation("New Address", "VIl",
                "Elen", "Alshavin", "FPT", "24",
                "SCK", "AlieZ", "New York", "123456",
                "United States", "1234567890", "654321");

        checkoutPage.enterShippingInformation("New Address", "VIl",
                "Elen", "Alshavin", "FPT", "24",
                "SCK", "AlieZ", "New York", "123456",
                "United States", "1234567890", "654321");

        checkoutPage.selectShippingMethod();
        checkoutPage.selectPaymentMethod();
        checkoutPage.clickPaymentInfo();
        checkoutPage.clickPlaceOrder();

        // Step 7: Verify order is generated and note the order number
        String expectedMessage = "THANK YOU FOR YOUR PURCHASE!";
        String actualMessage = checkoutPage.getOrderRecievedMessage();
        assert actualMessage.equals(expectedMessage) : "Order failed!";
        System.out.println("Order sent succeed");

        String orderNumber = checkoutPage.getOrderNumber();
        System.out.println(orderNumber);

        // Close the browser
        driver.quit();
    }
}
