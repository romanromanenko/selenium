package pages;

import org.openqa.selenium.By;

import java.util.ArrayList;
import java.util.List;

public class LoginForm extends BasePage{

    private final By loginButton = By.xpath("//p[text() = 'Login']/..");
    private final By registrationForm = By.xpath("//button[text() = 'Register here']");
    private final By firstName = By.name("firstName");
    private final By lastName = By.name("//input[@name='lastName']");
    private final By emailField = By.name("email");
    private final By passwordField = By.name("password");
    private final By confirmPasswordField = By.name("confirmPassword");
    private final By termsAndCondition = By.xpath("//input[@type='checkbox']");
    private final By registrationButton = By.xpath("//p[text() = 'register']/..");
    private final By loyaltyPoints = By.xpath("//p[text() = ' PTS']");
    private final By regValidationErrors = By.xpath("//p[contains(text(), 'Enter')] | //p[contains(text(), 'OOPS')]");


    public void switchToRegistrationForm() {
        driver.findElement(loginButton).click();
        driver.findElement(registrationForm).click();
    }

    public void fillRegistrationForm() {
        driver.findElement(firstName).sendKeys("test");
        driver.findElement(lastName).sendKeys("test");
        driver.findElement(emailField).sendKeys("roman.romanenko+8@grinteq.com");
        driver.findElement(passwordField).sendKeys("Qwerty12345!");
        driver.findElement(confirmPasswordField).sendKeys("Qwerty12345!");
        driver.findElement(termsAndCondition).click();
        driver.findElement(registrationButton).click();
    }

    public boolean displayingPTS(){
        waitUntilPageIsLoaded();
        return driver.findElement(loyaltyPoints).isDisplayed();
    }

    public void activeTermsAndCondition() {
       waitForPresenceOfElementLocated(termsAndCondition);
       driver.findElement(termsAndCondition).click();
    }

    public void clickOnRegisterButton() {
        driver.findElement(registrationButton).click();
    }

    public List<String> getRegistrationValidationErrors(){
        List<String> registrationValidationErrors = new ArrayList<>();
        driver.findElements(regValidationErrors)
                .forEach(header -> registrationValidationErrors.add(header.getText()));

        return registrationValidationErrors;
    }
}
