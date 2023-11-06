package POM;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class CheckOutPage_demo {
    WebDriver driver;

    By selectShippingLocator = By.id("shipping-address-select");
    By firstNameShippingLocator = By.id("shipping:firstname");
    By lastNameShippingLocator = By.id("shipping:lastname");
    By addressShippingLocator = By.id("shipping:street1");
    By cityShippingLocator = By.id("shipping:city");
    By zipShippingLocator = By.id("shipping:postcode");
    By regionShippingLocator = By.id("shipping:region_id");
    By countryShippingLocator = By.id("shipping:country_id");
    By telephoneShippingLocator = By.id("shipping:telephone");
    By ContinueButtonLocator = By.xpath("//button[@title='Continue']");

    public CheckOutPage_demo(WebDriver driver) {

        this.driver = driver;

    }

    public void enterFirstNameShipping(String name) {
        WebElement firstNameShipping = driver.findElement(firstNameShippingLocator);
        firstNameShipping.clear();
        firstNameShipping.sendKeys(name);
    }

    public void enterLastNameShipping(String lastName) {
        WebElement lastNameShipping = driver.findElement(lastNameShippingLocator);
        lastNameShipping.clear();
        lastNameShipping.sendKeys(lastName);
    }

    public void enterAddressShipping(String address) {
        WebElement addressShipping = driver.findElement(addressShippingLocator);
        addressShipping.clear();
        addressShipping.sendKeys(address);
    }

    public void enterCityShipping(String city) {
        WebElement cityShipping = driver.findElement(cityShippingLocator);
        cityShipping.clear();
        cityShipping.sendKeys(city);
    }

    public void enterZipShipping(String zip) {
        WebElement zipShipping = driver.findElement(zipShippingLocator);
        zipShipping.clear();
        zipShipping.sendKeys(zip);
    }

    public void enterTelephoneShipping(String telephone) {
        WebElement telephoneShipping = driver.findElement(telephoneShippingLocator);
        telephoneShipping.clear();
        telephoneShipping.sendKeys(telephone);
    }

    public void enterRegionShipping(String region) {
        WebElement regionShipping = driver.findElement(regionShippingLocator);
        Select selectRegionOptionShipping = new Select(regionShipping);
        selectRegionOptionShipping.selectByValue(region);
    }

    public void enterCountryShipping(String country) {
        WebElement countryShipping = driver.findElement(countryShippingLocator);
        Select selectCountryOptionShipping = new Select(countryShipping);
        selectCountryOptionShipping.selectByValue(country);
    }

    public void enterselectShipping() {
        try {

            driver.findElement(selectShippingLocator).click();
            WebElement selectShipping = driver.findElement(selectShippingLocator);
            Select selectCountryOptionShipping = new Select(selectShipping);
            int SselectShipping = selectCountryOptionShipping.getOptions().size();
            selectCountryOptionShipping.selectByIndex(SselectShipping - 1);
            selectCountryOptionShipping.selectByVisibleText("New Address");
        } catch (Exception e) {
            System.out.println("No dropdown element present");
        }
    }

    public void clickContinueButton() {
        driver.findElement(ContinueButtonLocator).click();
    }

}
