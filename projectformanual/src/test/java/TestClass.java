import DB.db_registration_first_step;
import SupportClasses.SetupClass.SetupClass;
import SupportClasses.TestLink.TestLinkResult;
import org.testng.annotations.Test;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.util.Scanner;

public class TestClass extends SetupClass {
    TestLinkResult TestResult = new TestLinkResult();

    @Test
    public void SupportTest() throws Exception{
        Scanner reader = new Scanner(new File("src/test/java/id.txt"));
        int id = reader.nextInt(); // id > unique number for email, that reads from the file and writes bigger on one.
        id++;
        String str = Integer.toString(id);

        System.out.println("new feature that was realized.");

        BufferedWriter writer = new BufferedWriter(new FileWriter("src/test/java/id.txt"));
        writer.write(str);
        writer.close();
    }
}
