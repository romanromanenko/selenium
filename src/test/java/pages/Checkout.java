package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

public class Checkout extends BasePage{

    private final By viewDetailsButton = By.xpath("//div[text() = 'view details']");
    private final By addToCardButton = By.xpath("//p[text() = 'add to cart']");
    private final By viewCard = By.id("viewCart");
    private final By checkoutButton = By.id("checkout");
    private final By addPaymentDetailsButton = By.id("addPaymentDetails");
    private final By placeOrderButton = By.id("placeOrder");
    private final By checkoutAsGuest = By.xpath("//p[text() = 'checkout as a guest']/..");
    private final By firstName = By.name("firstName");
    private final By lastName = By.name("lastName");
    private final By addressLine = By.id("address1");
    private final By countryName = By.id("countryCode");
    private final By stateDropDown = By.xpath("//input[@name = 'stateCode']/..");
    private final By cityName = By.name("city");
    private final By zipCode = By.name("postalCode");
    private final By phoneNumber = By.name("phone");
    private final By loginField = By.name("email");
    private final By cardNumber = By.name("cardnumber");
    private final By durationOfCard = By.name("exp-date");
    private final By cvcField = By.name("cvc");
    private final By countryNamePD = By.xpath("//input[@id = 'country']");
    private final By zipCodePD = By.name("zipCode");
    private final By saveToWishList = By.xpath("//p[text() = 'save to wishlist']/..");
    private final By messageAfterOrderPlacement = By.xpath("//p[text() = 'order summary']/..");
    private final By continueShoppingButton = By.xpath("//p[text() = 'continue shopping']/..");
    private final By quickViewButton = By.xpath("//p[text() = 'Quick View']");
    private final By addToCartButtonQW = By.xpath("//p[text() = 'add to cart']/..");
    private final By afterpayMethod = By.id("paymentByAfterpay");
    private final By authorizeTestPayment = By.name("success");

    public void openDetails() { clickByJavaScript(driver.findElement(viewDetailsButton)); }

    public void addItemToCart() {
        waitForPresenceOfElementLocated(addToCardButton);
        driver.findElement(addToCardButton).click();
    }

    public void moveToCheckout() {
        waitForPresenceOfElementLocated(viewCard);
        driver.findElement(viewCard).click();
        clickByJavaScript( driver.findElement(checkoutButton));
    }

    public void clickOnAddPaymentDetailsButton() {
        driver.findElement(addPaymentDetailsButton).click();
    }

    public void clickOnPlaceOrderButton() {
        driver.findElement(placeOrderButton).click();
    }

    public void continueAsGuest() {
        driver.findElement(checkoutAsGuest).click();
    }

    public void fillShippingAddress() {
        driver.findElement(firstName).sendKeys("Roman");
        driver.findElement(lastName).sendKeys("Romanenko");
        driver.findElement(addressLine).click();
        driver.findElement(addressLine).sendKeys("4869 Parkview Dr apt H");
        driver.findElement(countryName).click();
        driver.findElement(countryName).sendKeys("US");
        driver.findElement(stateDropDown).click();
        clickByJavaScript(driver.findElement(By.xpath("//p[text() = 'Oregon']")));
        driver.findElement(cityName).sendKeys("Lake Oswego");
        driver.findElement(zipCode).sendKeys("97035");
        driver.findElement(phoneNumber).sendKeys("5415984181");
        driver.findElement(loginField).sendKeys("roman.romanenko@grinteq.com");
        driver.findElement(addPaymentDetailsButton).click();
    }

    public void fillPaymentDetails() {
        List<WebElement> listOfFrames = driver.findElements(By.xpath("//iframe[contains(@name,'__privateStripeFrame')]"));
        driver.switchTo().frame(listOfFrames.get(0).getAttribute("name"));
        driver.findElement(cardNumber).click();
        driver.findElement(cardNumber).sendKeys("4242424242424242");
        driver.switchTo().defaultContent();
        driver.switchTo().frame(listOfFrames.get(1).getAttribute("name"));
        driver.findElement(durationOfCard).click();
        driver.findElement(durationOfCard).sendKeys("1223");
        driver.switchTo().defaultContent();
        driver.switchTo().frame(listOfFrames.get(2).getAttribute("name"));
        driver.findElement(cvcField).click();
        driver.findElement(cvcField).sendKeys("123");
        driver.switchTo().defaultContent();
        driver.findElement(countryNamePD).click();
        driver.findElement(countryNamePD).sendKeys("US");
        driver.findElement(zipCodePD).click();
        driver.findElement(zipCodePD).sendKeys("97035");
        driver.findElement(placeOrderButton).click();
    }

    public void addItemToWishList() {
        waitForPresenceOfElementLocated(saveToWishList);
        driver.findElement(saveToWishList).click();
    }

    public boolean getActualMessageAfterOrderPlacement() {
        waitForElementToBeClickable(driver.findElement(continueShoppingButton));
        return driver.findElement(messageAfterOrderPlacement).isDisplayed();
    }

    public void openQuickViewForm() { clickByJavaScript(driver.findElement(quickViewButton)); }

    public void addItemToCartFromQuickViewForm() {
        driver.findElement(addToCartButtonQW).click();
    }

    public void selectAfterpay() {
        driver.findElement(afterpayMethod).click();
    }

    public void confirmTestTransaction() {
        waitForPresenceOfElementLocated(authorizeTestPayment);
        driver.findElement(authorizeTestPayment).click();
    }
}
