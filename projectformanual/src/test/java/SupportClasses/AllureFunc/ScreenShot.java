package SupportClasses.AllureFunc;

import SupportClasses.SetupClass.SetupClass;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import ru.yandex.qatools.allure.annotations.Attachment;

public class ScreenShot extends SetupClass {
    @Attachment(value = "Page screenshot", type = "image/png")
    public byte[] saveAllureScreenshot()
    { return ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES); }
}
