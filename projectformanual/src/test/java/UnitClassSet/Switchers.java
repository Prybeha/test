package UnitClassSet;
import SupportClasses.SetupClass.SetupClass;
import org.openqa.selenium.By;

public class Switchers extends SetupClass{
    public void SwitcherManage(String LocatorForCheck, String LocatorForClick, boolean expected_result){

        if (!driver.findElement(By.id(LocatorForCheck)).isSelected() && expected_result) {
            driver.findElement(By.xpath(LocatorForClick)).click();
        }
        else if (driver.findElement(By.id(LocatorForCheck)).isSelected() && !expected_result){
            driver.findElement(By.xpath(LocatorForClick)).click();
        }
    }
}
