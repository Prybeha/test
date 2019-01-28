package UnitClassSet.Investment;

import SupportClasses.AllureFunc.LogUtil;
import SupportClasses.SetupClass.SetupClass;
import UnitClassSet.AccountType;
import UnitClassSet.Login.Login;
import UnitClassSet.Maintenance.Maintenance;
import UnitClassSet.PagesURL;
import org.testng.annotations.Test;
import ru.yandex.qatools.allure.annotations.Description;
import ru.yandex.qatools.allure.annotations.Features;
import ru.yandex.qatools.allure.annotations.Severity;
import ru.yandex.qatools.allure.annotations.Title;
import ru.yandex.qatools.allure.model.SeverityLevel;

public class test_IndividualUSnoAccredited extends SetupClass {
    private String IndividualUSNoAccredited = "prybehav+303@gmail.com";
    private LogUtil logger = new LogUtil();

    @Title("Test Individual US no Accredited investment process for ACH method")
    @Severity(SeverityLevel.CRITICAL)
    @Features({"Investment","Individual US no Accredited","ACH"})
    @Description("Login > check account type > make ACH investment")
    @Test
    public void Investment_ACH() throws Exception{
        PagesURL URL = new PagesURL();
        URL.LoginPage();

        Maintenance maintenance = new Maintenance();
        if (maintenance.MaintenancePageCheck()){
            logger.log("Maintenance mode is on!");
            return;
        }

        Login L = new Login();
        L.LoginTest(IndividualUSNoAccredited);
        logger.log("Login");

        AccountType acc_type_obj = new AccountType();
        int acc_type = acc_type_obj.AccountTypeCheck();
        logger.log("Type is: " + acc_type);

        Investment TestInvestment = new Investment();
        TestInvestment.Investment(acc_type,"ACH","100");
    }

    @Title("Test Individual US no Accredited investment process for Wire method")
    @Severity(SeverityLevel.CRITICAL)
    @Features({"Investment","Individual US no Accredited","Wire"})
    @Description("Login > check account type > make Wire investment")
    @Test
    public void Investment_Wire() throws Exception{
        PagesURL URL = new PagesURL();
        URL.LoginPage();

        Maintenance maintenance = new Maintenance();
        if (maintenance.MaintenancePageCheck()){
            logger.log("Maintenance mode is on!");
            return;
        }

        Login L = new Login();
        L.LoginTest(IndividualUSNoAccredited);
        logger.log("Login");

        AccountType acc_type_obj = new AccountType();
        int acc_type = acc_type_obj.AccountTypeCheck();
        logger.log("Type is: " + acc_type);

        Investment TestInvestment = new Investment();
        TestInvestment.Investment(acc_type,"Wire","100");
    }

    @Title("Test Individual US no Accredited investment process for Bitcoin method")
    @Severity(SeverityLevel.CRITICAL)
    @Features({"Investment","Individual US no Accredited","Bitcoin"})
    @Description("Login > check account type > make Bitcoin investment")
    @Test
    public void Investment_Bitcoin() throws Exception{
        PagesURL URL = new PagesURL();
        URL.LoginPage();

        Maintenance maintenance = new Maintenance();
        if (maintenance.MaintenancePageCheck()){
            logger.log("Maintenance mode is on!");
            return;
        }

        Login L = new Login();
        L.LoginTest(IndividualUSNoAccredited);
        logger.log("Login");

        AccountType acc_type_obj = new AccountType();
        int acc_type = acc_type_obj.AccountTypeCheck();
        logger.log("Type is: " + acc_type);

        Investment TestInvestment = new Investment();
        TestInvestment.Investment(acc_type,"Bitcoin","0.5");
    }

    @Title("Test Individual US no Accredited investment process for Ethereum method")
    @Severity(SeverityLevel.CRITICAL)
    @Features({"Investment","Individual US no Accredited","Ethereum"})
    @Description("Login > check account type > make Ethereum investment")
    @Test
    public void Investment_Ethereum() throws Exception{
        PagesURL URL = new PagesURL();
        URL.LoginPage();

        Maintenance maintenance = new Maintenance();
        if (maintenance.MaintenancePageCheck()){
            logger.log("Maintenance mode is on!");
            return;
        }

        Login L = new Login();
        L.LoginTest(IndividualUSNoAccredited);
        logger.log("Login");

        AccountType acc_type_obj = new AccountType();
        int acc_type = acc_type_obj.AccountTypeCheck();
        logger.log("Type is: " + acc_type);

        Investment TestInvestment = new Investment();
        TestInvestment.Investment(acc_type,"Ethereum","0.5");
    }
}
