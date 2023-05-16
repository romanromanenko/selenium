package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class BasePage {

    public static WebDriver driver;
    public static void start(){
        System.setProperty("webdriver.http.factory", "jdk-http-client");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("url");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

    public void clickByJavaScript(WebElement element){
        JavascriptExecutor e = (JavascriptExecutor)driver;
        e.executeScript("arguments[0].click();", element);
    }

    public void waitUntilPageIsLoaded(){
        new WebDriverWait(driver, Duration.ofSeconds(10)).until(
                webDriver -> ((JavascriptExecutor) webDriver).executeScript("return document.readyState").equals("complete"));
    }
    public void waitForElementToBeClickable(WebElement element) {
        new WebDriverWait(driver, Duration.ofSeconds(20)).
                until(ExpectedConditions.elementToBeClickable(element));
    }

    public void waitForInvisibilityOf(WebElement element){
        new WebDriverWait(driver, Duration.ofSeconds(20)).
                until(ExpectedConditions.invisibilityOf(element));
    }

    public void waitForVisibilityOfAllElements(WebElement element){
        new WebDriverWait(driver, Duration.ofSeconds(20)).
                until(ExpectedConditions.visibilityOfAllElements(element));
    }

    public void waitForPresenceOfElementLocated(By by){
        new WebDriverWait(driver, Duration.ofSeconds(20)).
                until(ExpectedConditions.presenceOfElementLocated(by));
    }

}
