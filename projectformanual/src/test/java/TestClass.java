import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class TestClass {
    WebDriver driver; // driver that make possible access to page element

    @Test
    public void firsttest(){
        // make system know that you will use chromedriver and write PATH to it
        System.setProperty("webdriver.chrome.driver", "C:\\SeleniumDrivers\\chromedriver.exe");
        // assign our driver to chromedriver
        driver = new ChromeDriver();

        driver.get("https://www.google.com/"); // go to google.com page

        driver.close(); // close your browser
    }
}
