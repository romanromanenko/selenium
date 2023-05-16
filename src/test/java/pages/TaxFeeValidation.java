package pages;

import org.openqa.selenium.By;

public class TaxFeeValidation extends BasePage{

    private final By loginField = By.name("email");
    private final By firstName = By.name("firstName");
    private final By lastName = By.name("lastName");
    private final By addressLine = By.id("address1");
    private final By countryName = By.id("countryCode");
    private final By phoneNumber = By.name("phone");
    private final By stateDropDown = By.xpath("//input[@name = 'stateCode']/..");
    private final By cityName = By.name("city");
    private final By zipCode = By.name("postalCode");
    private final By addPaymentDetailsButton = By.id("addPaymentDetails");

    public void fillAddressData(String address, String state, String city, String zip) {
        driver.findElement(firstName).sendKeys("Roman");
        driver.findElement(lastName).sendKeys("Romanenko");
        driver.findElement(addressLine).click();
        driver.findElement(addressLine).sendKeys(address);
        driver.findElement(countryName).click();
        driver.findElement(countryName).sendKeys("US");
        driver.findElement(stateDropDown).click();
        clickByJavaScript(driver.findElement(By.xpath("//p[text() = '" + state + "']")));
        driver.findElement(cityName).sendKeys(city);
        driver.findElement(zipCode).sendKeys(zip);
        driver.findElement(phoneNumber).sendKeys("5415984181");
        driver.findElement(loginField).sendKeys("roman.romanenko@grinteq.com");
    }

    public void moveToAddPaymentMethod() {
        driver.findElement(addPaymentDetailsButton).click();
    }

    public Double taxPercentValue() {

        waitForVisibilityOfAllElements(driver.findElement(By.id("taxAmount")));

        String productTotal = ((driver.findElement(By.id("productTotal")).getText())).replaceAll("[$ ]","").replace(',' , '.');
        Double productTotalInDouble = Double.parseDouble(productTotal);

        String taxAmount = ((driver.findElement(By.id("taxAmount")).getText())).replaceAll("[$ ]","").replace(',' , '.');
        Double taxAmountInDouble = Double.parseDouble(taxAmount);

        Double percent = Math.round((taxAmountInDouble / productTotalInDouble * 100) * 100.0) / 100.0;
        return percent;
    }
}
