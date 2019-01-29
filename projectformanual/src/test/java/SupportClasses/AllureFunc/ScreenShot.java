package SupportClasses.AllureFunc;

import SupportClasses.SetupClass.SetupClass;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import ru.yandex.qatools.allure.annotations.Attachment;

public final class ScreenShot extends SetupClass {
    @Attachment(value = "Page screenshot {0}", type = "image/png")
    public static String saveAllureScreenshot(String screenshot)
    { return screenshot; }
}
