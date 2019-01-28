package UnitClassSet;

import SupportClasses.SetupClass.SetupClass;

public class PagesURL extends SetupClass {

    public void MainPage(){ driver.get("https://seriesone.dynamo-ny.com/"); }
    public void DealPage(){
        driver.get("https://secure-seriesone.dynamo-ny.com/deals");
    }
    public void FundsPage(){ driver.get("https://seriesone.dynamo-ny.com/start-raising-funds/"); }
    public void BrokeronePage(){
        driver.get("https://seriesone.dynamo-ny.com/brokerone/");
    }
    public void AboutInvestingPage(){
        driver.get("https://seriesone.dynamo-ny.com/learn/");
    }
    public void TokenOfferingsPage(){ driver.get("https://seriesone.dynamo-ny.com/token-offering/"); }
    public void RegisterPage(){ driver.get("https://secure-seriesone.dynamo-ny.com/register"); }
    public void LoginPage(){
        driver.get("https://secure-seriesone.dynamo-ny.com/login");
    }
}
