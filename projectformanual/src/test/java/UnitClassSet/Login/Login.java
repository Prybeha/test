package UnitClassSet.Login;

import SupportClasses.SetupClass.SetupClass;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class Login extends SetupClass {

    public void LoginTest(String Username){
        wait.until(ExpectedConditions.elementToBeClickable(By.id("_username")));
        driver.findElement(By.id("_username")).clear();
        driver.findElement(By.id("_username")).sendKeys(Username);
        driver.findElement(By.id("_password")).clear();
        driver.findElement(By.id("_password")).sendKeys("Aq1sw2de3");
        driver.findElement(By.id("submit")).click();
    }
}
