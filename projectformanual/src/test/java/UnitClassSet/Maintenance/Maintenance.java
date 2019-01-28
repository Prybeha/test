package UnitClassSet.Maintenance;

import SupportClasses.SetupClass.SetupClass;
import UnitClassSet.Field;
import org.openqa.selenium.By;

public class Maintenance extends SetupClass {
    private Field field = new Field();
    public boolean MaintenancePageCheck(){
        if(field.ExistElementOnThePage("//*[@class='maintenance-text']",2)){
            System.out.println("Maintenance mode is on!");
            return true;
        }
        return false;
    }
}
