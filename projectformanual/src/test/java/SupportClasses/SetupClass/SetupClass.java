package SupportClasses.SetupClass;

import SupportClasses.AllureFunc.ScreenShot;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.remote.ScreenshotException;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import ru.yandex.qatools.allure.annotations.Attachment;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Method;
import java.nio.file.Files;
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

        File dir = new File("./target/screenshots/");
        dir.mkdir();
    }

    @AfterMethod
    public void teardown(ITestResult result, Method test_name) throws IOException{
        if (result.getStatus()==ITestResult.FAILURE) {
            File screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
            String path = "./target/screenshots/" + test_name.getName();
            FileHandler.copy(screenshot, new File(path));

            byte[] fileContent = Files.readAllBytes(screenshot.toPath());

            ScreenShot.saveAllureScreenshot(fileContent);
        }
        driver.quit();
    }
}
