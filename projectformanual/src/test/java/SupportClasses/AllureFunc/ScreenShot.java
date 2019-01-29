package SupportClasses.AllureFunc;

import SupportClasses.SetupClass.SetupClass;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.IHookCallBack;
import org.testng.IHookable;
import org.testng.ITestResult;
import ru.yandex.qatools.allure.annotations.Attachment;
import java.io.IOException;

public class ScreenShot{

    @Attachment
    public String makeAttach() {
        return "yeah, 2 is 2";
    }
}
