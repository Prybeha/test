package SupportClasses.SetupClass;

import SupportClasses.AllureFunc.ScreenShotUtil;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Listeners;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Method;
import java.util.concurrent.TimeUnit;

@Listeners({ScreenShotUtil.class})
public class SetupClass {
    protected static WebDriver driver;
    protected static WebDriverWait wait;

    public static WebDriver GetDriver(){
        return driver;
    }

    @BeforeSuite
    private void CreateFolderForScreenshots(){
        File dir = new File("./target/allure-results/screenshots/");
        dir.mkdir();
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
    public void teardown(ITestResult result, Method test_name) throws IOException{
        if (result.getStatus()==ITestResult.FAILURE ) {
            File screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
            String path = "./target/allure-results/screenshots/" + test_name.getName();
            FileHandler.copy(screenshot, new File(path));
        }
        driver.quit();
    }
}
