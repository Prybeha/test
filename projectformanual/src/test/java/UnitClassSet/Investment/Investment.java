package UnitClassSet.Investment;

import SupportClasses.AllureFunc.LogUtil;
import SupportClasses.SetupClass.SetupClass;
import UnitClassSet.Field;
import UnitClassSet.PagesURL;
import UnitClassSet.Switchers;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class Investment extends SetupClass {
    private Field field = new Field();
    private Switchers switcher = new Switchers();
    private PagesURL URL = new PagesURL();
    private LogUtil logger = new LogUtil();
    public void Investment(int user_type, String payment_method, String value_invest) throws Exception{
        URL.DealPage();

        WebElement LearnMoreButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[@href='https://secure-seriesone.dynamo-ny.com/deal/pdp-qa']"))); // using xpath locator that find element by link
        Thread.sleep(500);
        LearnMoreButton.click();

        if (field.ExistElementOnThePage("//div[@class='detail-page-protected denied']",3)){
            System.out.println("This user type does not have access for invest in this deal!");
            logger.log("This user type does not have access for invest in this deal!");
            return;
        }

        WebElement InvestButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[text()='Invest']"))); // using xpath locator that find element by text
        InvestButton.click();

        int current_step = 0;
        logger.log("Investment starts");
        while (current_step != 4) {
            wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//img[@class='footer-logo']")));
            Thread.sleep(1000);

            if(CheckInvestmentStep(current_step) == 1) {
                current_step = 1;

                System.out.println("First step");
                logger.log("First step");
                FirstStep(user_type);
            }
            else if(CheckInvestmentStep(current_step) == 2){
                current_step = 2;

                System.out.println("Second step");
                logger.log("Second step");
                SecondStep(payment_method,value_invest);
            }
            else if(CheckInvestmentStep(current_step) == 3){
                current_step = 3;

                System.out.println("Third step");
                logger.log("Third step");
                ThirdStep();
            }
            else if(CheckInvestmentStep(current_step) == 4){
                current_step = 4;

                System.out.println("Fourth step");
                logger.log("Fourth step");
                if (field.ExistElementOnThePage("//h3[text()='Congratulations, your investment is in!']",10)){
                    logger.log("Investment was successfully done.");
                    System.out.println("Investment was successfully done.");
                }

                wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[@class='fw-link pull-right']")));
                Thread.sleep(200);
                driver.findElement(By.xpath("//a[@class='fw-link pull-right']")).click();

                driver.get("https://secure-seriesone.dynamo-ny.com/investments");
            }
            else{
                System.out.println("Something goes wrong. You are go away from investment steps");
            }
            //wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[@href='https://seriesone.dynamo-ny.com']")));
        }
    }

    private int CheckInvestmentStep(int prev_step) throws Exception{
        int wait_time = 5;

        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//img[@class='footer-logo']")));
        Thread.sleep(500);
        if(prev_step == 0) {
            if (field.ExistElementOnThePage("//input[@id='investment_contact_agree']", wait_time)) { return 1; }
            else { return 0; }
        }
        else if(prev_step == 1) {
            if (field.ExistElementOnThePage("//input[@id='investment_fwAmount']", wait_time)) { return 2; }
            else if (field.ExistElementOnThePage("//input[@id='investment_contact_agree']", wait_time)) { return 1; }
            else { return 0; }
        }
        else if (prev_step == 2) {
            if (field.ExistElementOnThePage("//h5[text()='Sign Subscription Agreement']", wait_time)) { return 3; }
            else if (field.ExistElementOnThePage("//input[@id='investment_fwAmount']", wait_time)) { return 2; }
            else if (field.ExistElementOnThePage("//input[@id='investment_contact_agree']", wait_time)) { return 1; }
            else { return 0; }
        }
        else if(prev_step == 3) {
            if (field.ExistElementOnThePage("//h3[text()='Congratulations, your investment is in!']",wait_time)){ return 4; }
            else if (field.ExistElementOnThePage("//h5[text()='Sign Subscription Agreement']", wait_time)) { return 3; }
            else if (field.ExistElementOnThePage("//input[@id='investment_fwAmount']", wait_time)) { return 2; }
            else { return 0; }
        }
        // Loop doesn't start if step become fourth, because there is no choice where go.
        return 0;
    }

    private void FirstStep(int user_type){
        // add some changes to your data

        field.EnterValueIfAvailable("//input[@id='investment_contact_fwSSN']","123123123");
        field.EnterValueIfAvailable("//input[@id='investment_contact_birthdate']","01011997");

        if (user_type == 3 || user_type == 4) {
            switcher.SwitcherManage("investment_contact_agree",
                    "//*[@id=\"firstPlace\"]/form/div[17]/div/div/div/label/div[1]/div/label[2]",true);
        }
        else if (user_type == 1 || user_type == 2){
            switcher.SwitcherManage("investment_contact_agree",
                    "//*[@id=\"firstPlace\"]/form/div[8]/div/div/div/label/div[1]/div/label[2]",true);
        }
        WebElement next_button = driver.findElement(By.xpath("//button[@id='next']"));
        next_button.click();
    }

    private void SecondStep(String payment_method, String ValueForInvest) throws Exception{
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@data-option='ach']")));
        Thread.sleep(500);

        if (payment_method.equals("ACH")){

            driver.findElement(By.xpath("//div[@data-option='ach']")).click();

            // data that required for ACH payment
            field.EnterValueIfAvailable("//input[@id='ach_nameOnAccount']","021000021");
            field.EnterValueIfAvailable("//input[@id='ach_routingNumber']","021000021");
            field.EnterValueIfAvailable("//input[@id='ach_accountNumber_first']","021000021");
            field.EnterValueIfAvailable("//input[@id='ach_accountNumber_second']","021000021");

            driver.findElement(By.xpath("//label[@for='ach_checkType_0']")).click();// 'ach_checkType_1' if you want 'Business' type
            driver.findElement(By.xpath("//label[@for='ach_accountType_0']")).click();// 'ach_accountType_1' if you want 'Savings' type
            driver.findElement(By.xpath("//label[@for='ach_agree']")).click();
        }
        else if (payment_method.equals("Wire")){
            driver.findElement(By.xpath("//div[@data-option='wire']")).click();
        }
        else if (payment_method.equals("Bitcoin")){
            driver.findElement(By.xpath("//div[@data-option='bitcoin']")).click();
            field.EnterValueIfAvailable("//input[@id='investment_fwWalletAddress']","2N21od10j2n18391n123");
        }
        else if (payment_method.equals("Ethereum")){
            driver.findElement(By.xpath("//div[@data-option='ethereum']")).click();
            field.EnterValueIfAvailable("//input[@id='investment_fwWalletAddress']","0x12ni1890123oj123m1n1238819031ewd1");
        }
        field.EnterValueIfAvailable("//input[@id='investment_fwAmount']",ValueForInvest);
        driver.findElement(By.xpath("//button[@id='next']")).click();
    }

    private void ThirdStep() throws Exception{
        wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(0));

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[text()='Got it!']")));
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@class='onboarding-step-shade']")));
        driver.findElement(By.xpath("//div[@class='onboarding-step-shade']")).click();
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@class='onboarding-step-shade']")));
        driver.findElement(By.xpath("//div[@class='onboarding-step-shade']")).click();

        driver.findElement(By.xpath("//div[@class='next-required-field down ember-view']")).click();
        driver.findElement(By.xpath("//div[@class='signature-field ember-view']")).click();
        driver.findElement(By.xpath("//button[@class='minimal green theme_link']")).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='signature-pad-wrapper text']")));
        driver.findElement(By.xpath("//input[@class='type-pad ember-text-field ember-view']")).click();
        driver.findElement(By.xpath("//input[@class='type-pad ember-text-field ember-view']")).sendKeys("TestUser");

        driver.findElement(By.xpath("//button[@class='rs-button is-primary ember-view']")).click();

        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[text()='Submit Signature']")));
        driver.findElement(By.xpath("//div[text()='Submit Signature']")).click();
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[text()='Submit']")));
        driver.findElement(By.xpath("//div[text()='Submit']")).click();

        Thread.sleep(1000);

        driver.switchTo().defaultContent();
        wait.until(ExpectedConditions.elementToBeClickable(By.id("next")));
        driver.findElement(By.id("next")).click();

        if (field.ExistElementOnThePage("//*[@class='margin-bottom-25 investing-form-error alert alert-danger']",5)){
            driver.findElement(By.id("next")).click(); // if section work that means incorrect behavior
            System.out.println("Appears error on the third step!");
        }
    }
}
