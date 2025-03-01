package pageObjects;

import java.time.Duration;
import java.util.List;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import utils.DriverManager;

public class BasePage  {
    protected WebDriver driver;
    protected WebDriverWait wait;
    protected By acceptTermsBtn = By.xpath("//span[contains(text(), 'ACCEPT')]");

    public BasePage() {
        this.driver = DriverManager.getDriver(); // Obtains the instance of WebDriver;
        this.wait= new WebDriverWait(this.driver, Duration.ofSeconds(10));
    }

    public void navigateToPage(String url){
        driver.get(url);
        waitUntilPageIsLoaded(url);
    }

    private WebElement findElement(By locator){
        return driver.findElement(locator);
    }

    protected List<WebElement> findElements(By locator){
        return driver.findElements(locator);
    }

    public boolean isElementVisible(By locator){
        try{
            wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
            return true;
        }
        catch (TimeoutException e){
            return false;
        }
    }

    public boolean isElementClickeable(By locator){
        try{
            wait.until(ExpectedConditions.elementToBeClickable(locator));
            return true;
        }
        catch (TimeoutException e){
            return false;
        }
    }

    protected void waitUntilPageIsLoaded(String url){
        this.wait.until(ExpectedConditions.urlToBe(url));
    }

    public void sendText(By locator, String text){
        if(isElementVisible(locator)){
            findElement(locator).sendKeys(text);
        }
        else{
            Assert.fail("The locator: "+locator+"is not visible to send '"+text+"' text in it.");
        }
    }

    public void click(By locator){
        if (isElementClickeable(locator)){
            findElement(locator).click();
        }
        else{
            Assert.fail("Element: "+locator+" is not clickeable at this point.");
        }
    }

    public String getText(By locator){
        wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
        return findElement(locator).getText();
    }

    public String getText(WebElement element){
        wait.until(ExpectedConditions.visibilityOf(element));
        return element.getText();
    }


    
}