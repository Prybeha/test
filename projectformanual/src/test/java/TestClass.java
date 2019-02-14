import SupportClasses.SetupClass.SetupClass;
import SupportClasses.TestLink.TestLinkResult;
import UnitClassSet.AccountType;
import UnitClassSet.Investment.Investment;
import UnitClassSet.Login.Login;
import UnitClassSet.Maintenance.Maintenance;
import UnitClassSet.PagesURL;
import org.testng.annotations.Test;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.util.Scanner;

public class TestClass extends SetupClass {
    TestLinkResult TestResult = new TestLinkResult();
    private String EntityUS = "prybehav+176@gmail.com";// +
    private String IndividualUS = "prybehav+153@gmail.com";// +
    private String EntityNoUS = "prybehav+297@gmail.com";// +
    private String IndividualNoUS = "prybehav+155@gmail.com";// +
    private String IndividualUSNoAccredited = "prybehav+303@gmail.com";// +

    @Test
    public void Secondtest() throws Exception{
        System.out.println("test");
        Scanner reader = new Scanner(new File("src/test/java//id.txt"));
        int id = reader.nextInt(); // id > unique number for email, that reads from the file and writes bigger on one.

        id++;
        String str = Integer.toString(id);
        BufferedWriter writer = new BufferedWriter(new FileWriter("src/test/java/id.txt"));
        writer.write(str);
        writer.close();
        //PagesURL URL = new PagesURL();
        //URL.LoginPage();
//
//        Maintenance maintenance = new Maintenance();
//        if (maintenance.MaintenancePageCheck()){
//            return;
//        }
    }
}
