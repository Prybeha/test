package SupportClasses.AllureFunc;

import SupportClasses.SetupClass.SetupClass;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import ru.yandex.qatools.allure.annotations.Attachment;

public class ScreenShot extends SetupClass {
    @Attachment(value = "Screenshot of {0}", type = "image/png")
    public byte[] makeScreenshot(WebDriver driver) {
        return (byte[]) ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
    }
}
