package SupportClasses.SetupClass;

import SupportClasses.AllureFunc.ScreenShot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.ScreenshotException;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class SetupClass {
    public static WebDriver driver;
    public static WebDriverWait wait;

    public WebDriver GetDriver(){
        return driver;
    }

    @BeforeMethod
    public void setup (){
        System.setProperty("webdriver.chrome.driver", "C:\\SeleniumDrivers\\chromedriver.exe");
        driver = new ChromeDriver();
        wait = new WebDriverWait(driver,15, 500);
        driver.manage().timeouts().pageLoadTimeout(60, TimeUnit.SECONDS);
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.manage().window().maximize();
    }

    @AfterMethod
    public void teardown(ITestResult result){
        if (!result.isSuccess()) {
            try {
                ScreenShot screenshot = new ScreenShot();
                screenshot.makeScreenshot(driver);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        driver.quit();
    }
}
