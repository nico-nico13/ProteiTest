package protei.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import protei.BaseClass;
import protei.data.DataProviderProtei;
import protei.pages.FormPage;
import protei.pages.LoginPage;

public class NegativeTests extends BaseClass {

    @Test(  dataProviderClass = DataProviderProtei.class,
            dataProvider = "invalid login testing data")
    public void performInvalidLoginTesting(String email, String password) {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login(email, password);
        Assert.assertTrue(loginPage.errorMessageDisplay());
    }

    @Test(  dataProviderClass = DataProviderProtei.class,
            dataProvider = "invalid email submit testing data")
    public void performInvalidEmailSubmitTesting(String email) {
        LoginPage loginPage = new LoginPage(driver);
        FormPage formPage = new FormPage(driver);
        loginPage.login(properties.getProperty("email"), properties.getProperty("password"));
        formPage.typeEmail(email);
        formPage.send();
        Assert.assertTrue(formPage.emailErrorDisplay());
    }

    @Test(  dataProviderClass = DataProviderProtei.class,
            dataProvider = "blank name submit testing data")
    public void performBlankNameSubmitTesting(String email, String name) {
        LoginPage loginPage = new LoginPage(driver);
        FormPage formPage = new FormPage(driver);
        loginPage.login(properties.getProperty("email"), properties.getProperty("password"));
        formPage.typeEmail(email);
        formPage.typeName(name);
        formPage.send();
        Assert.assertTrue(formPage.nameErrorDisplay());
    }
}
