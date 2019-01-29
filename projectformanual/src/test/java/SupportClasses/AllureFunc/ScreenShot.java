package SupportClasses.AllureFunc;

import SupportClasses.SetupClass.SetupClass;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.IHookCallBack;
import org.testng.IHookable;
import org.testng.ITestResult;
import org.testng.TestListenerAdapter;
import ru.yandex.qatools.allure.annotations.Attachment;
import java.io.IOException;

public class ScreenShot extends TestListenerAdapter {

//        private Logger log = LoggerFactory.getLogger(CustomTestListener.class);
//
//        @Override
//        public void onTestStart(ITestResult result) {
//            log.info("Test class started: " + result.getTestClass().getName());
//            log.info("Test started: " + result.getName());
//        }
//
//        @Override
//        public void onTestSuccess(ITestResult result) {
//            log.info("Test SUCCESS: " + result.getName());
//        }

    @Override
    public void onTestFailure(ITestResult result) {
        makeScreenshot();
    }

    @Attachment
    byte[] makeScreenshot() {
        return ((TakesScreenshot) SetupClass.GetDriver()).getScreenshotAs(OutputType.BYTES);
    }
}
