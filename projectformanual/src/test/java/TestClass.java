import SupportClasses.NewException;
import SupportClasses.SetupClass;
import SupportClasses.TestLinkResult;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.annotations.Test;
import org.testng.Assert;
import ru.yandex.qatools.allure.annotations.Severity;
import ru.yandex.qatools.allure.annotations.TestCaseId;
import ru.yandex.qatools.allure.annotations.Title;
import ru.yandex.qatools.allure.model.SeverityLevel;

public class TestClass extends SetupClass {
    TestLinkResult TestResult = new TestLinkResult();

    @Title("FirstTest")
    @Severity(SeverityLevel.NORMAL)
    @TestCaseId("1")
    @Test
    public void firsttest() throws Exception{
        try {
            driver.findElement(By.name("q")).sendKeys("CoinMarketCap");
            driver.findElement(By.name("btnK")).submit();
            wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"rso\"]/div[1]/div/div/div/div/div[1]/a[1]/h3")));
            driver.findElement(By.xpath("//*[@id=\"rso\"]/div[1]/div/div/div/div/div[1]/a[1]/h3")).click();
            Assert.assertEquals(1,2);
            TestResult.TestLinkPass("FirstTestCaseForManual"); // Must be on the last line of try block
        }
        catch (AssertionError e){
            TestResult.TestLinkFail("FirstTestCaseForManual",e.getMessage()); // Send TC name and error message
            throw new NewException("Assertion finished false"); // call error
        }
    }

    @Title("SecondTest")
    @Severity(SeverityLevel.CRITICAL)
    @TestCaseId("2")
    @Test
    public void secondtest() throws Exception{
        try {
            driver.findElement(By.name("q")).sendKeys("CoinMarketCap");
            Assert.assertEquals(driver.getCurrentUrl(), "https://www.google.com/");
            TestResult.TestLinkPass("SecondTestCaseForManual");
        }
        catch (AssertionError e){
            TestResult.TestLinkFail("SecondTestCaseForManual",e.getMessage());
            throw new NewException("Assertion finished false");
        }
    }
}
