package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;

public class HomePage extends BasePage {

    private final By loginField = By.name("email");
    private final By passwordField = By.name("password");
    private final By loginButtonLoginForm = By.xpath("//p[text() = 'login']");
    private final By loginButtonHomePage = By.xpath("//p[text() = 'Login']/..");
    private final By searchIcon = By.xpath("//div[text() = 'search']");
    private final By searchField = By.xpath("//input[@placeholder='WHAT ARE YOU LOOKING FOR?']");
    private final By profileIcon = By.id("profile");
    private final By logOutButton = By.xpath("//p[text() = 'Log Out']");
    private final By catalog = By.id("shop");
    private final By artTab = By.id("art");
    private final By wishListPage = By.id("favorites");

    public void login(String email, String password){
        driver.findElement(loginButtonHomePage).click();
        driver.findElement(loginField).sendKeys(email);
        driver.findElement(passwordField).sendKeys(password);
        driver.findElement(loginButtonLoginForm).click();
    }

    public void clickOnSearchIcon() {

        try{
            waitForInvisibilityOf(driver.findElement(loginButtonLoginForm));
            driver.findElement(searchIcon).click();
        }catch (NoSuchElementException e){
            driver.findElement(searchIcon).click();
        }
    }

    public void itemSearch(String itemName) {
        driver.findElement(searchField).sendKeys(itemName + "\n");
        waitUntilPageIsLoaded();
    }

    public void logOut() {
        driver.findElement(profileIcon).click();
        driver.findElement(logOutButton).click();
    }

    public void openCatalog() {

        try {
            waitForInvisibilityOf(driver.findElement(passwordField));
            driver.findElement(catalog).click();
        } catch (NoSuchElementException e){
            driver.findElement(catalog).click();
        }
    }

    public void switchToArtTab() {
        waitForVisibilityOfAllElements(driver.findElement(artTab));
        driver.findElement(artTab).click();
    }

    public void openWishList() {
        driver.findElement(wishListPage).click();
    }
}
