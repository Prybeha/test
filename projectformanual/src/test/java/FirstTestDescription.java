import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;

public class FirstTestDescription extends TestClass {
    public void FirstTestMainPart() {
        driver.findElement(By.name("q")).sendKeys("CoinMarketCap");
        driver.findElement(By.name("btnK")).submit();
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"rso\"]/div[1]/div/div/div/div/div[1]/a[1]/h3")));
        driver.findElement(By.xpath("//*[@id=\"rso\"]/div[1]/div/div/div/div/div[1]/a[1]/h3")).click();
        Assert.assertEquals(1, 2);
    }
}
