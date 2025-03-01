package utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DriverManager {
    //private static WebDriver driver;
    private static ThreadLocal<WebDriver> driver = new ThreadLocal<>(); //to allow parallel executions It allows one driver per thread
    private DriverManager() {} //private to avoid creating multiple instances of this class 
                                //(we just want one driver instance during all the test suite execution)

    public static WebDriver getDriver() {
        if (driver.get() == null) {
            WebDriverManager.chromedriver().setup(); // WebDriverManager setup
            driver.set(new ChromeDriver()); //creates driver instance in the ThreadLocal
            driver.get().manage().window().maximize();
        }
        return driver.get();
    }

    public static void quitDriver() {
        if (driver.get() != null) {
            driver.get().quit();
            driver.remove(); //deletes driver instance from the ThreadLocal
        }
    }
}
