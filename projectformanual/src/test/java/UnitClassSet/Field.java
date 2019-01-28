package UnitClassSet;

import SupportClasses.SetupClass.SetupClass;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import org.openqa.selenium.NoSuchElementException;
import java.util.concurrent.TimeUnit;

public class Field extends SetupClass {

    public void EnterValue(String locator, String value){
        driver.findElement(By.xpath(locator)).clear();
        driver.findElement(By.xpath(locator)).click();
        driver.findElement(By.xpath(locator)).sendKeys(value);
    }

    public void EnterValueIfAvailable(String locator, String value){
        if (ExistElementOnThePage(locator, 2)){
            EnterValue(locator, value);
            //System.out.println("Enter " + value + " in the field.");
        }
//        else{
//            System.out.println("Field is disable.");
//        }
    }

    public boolean ExistElementOnThePage(String locator, int WaitTime){
        driver.manage().timeouts().implicitlyWait(WaitTime, TimeUnit.SECONDS);
        try {
            WebElement element = driver.findElement(By.xpath(locator));
            driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
            return true;
        }
        catch(NoSuchElementException ex) {
            driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
            return false;
        }
    }
}
