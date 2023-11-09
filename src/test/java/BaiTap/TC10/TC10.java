package BaiTap.TC10;

import java.io.File;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;
import org.testng.annotations.Test;

import POM.AdminPage;
import POM.LoginAdminPage;
import driver.driverFactory;

public class TC10 {

    @Test
    public void TC10() {
        String username = "user01";
        String password = "guru99com";
        String id = "100019886";
        String from = "07/11/2023";
        String to = "08/11/2023";

        WebDriver driver = driverFactory.getChromeDriver();
        LoginAdminPage loginAdminPage = new LoginAdminPage(driver);
        AdminPage adminPage = new AdminPage(driver);
        try {

            // TODO: handle exception
            // Step 1: Go to backend login page
            driver.get("http://live.techpanda.org/index.php/backendlogin");

            // Step 2: Login with provided credentials
            loginAdminPage.login(username, password);

            // Step 3: Navigate to Sales -> Orders menu
            adminPage.closeMsgBox();
            adminPage.goToOrders();

            // Step 4: Input OrderId and FromDate -> ToDate
            adminPage.search(id, from, to);
            Thread.sleep(4000);
            TakesScreenshot TC10 = ((TakesScreenshot) driver);
            File srcFile1 = TC10.getScreenshotAs(OutputType.FILE);
            FileHandler.copy(srcFile1, new File(
                    "D:\\Study\\Fall 2023\\SWT301\\Ex\\Test By sele\\selenium-webdriver-java\\src\\test\\java\\BaiTap\\TC10\\TC10.png"));

            driver.quit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
