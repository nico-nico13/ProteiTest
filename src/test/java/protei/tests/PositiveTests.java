package protei.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import protei.BaseClass;
import protei.data.DataProviderProtei;
import protei.pages.FormPage;
import protei.pages.LoginPage;

public class PositiveTests extends BaseClass {

    @Test(  dataProviderClass = DataProviderProtei.class,
            dataProvider = "positive testing data")
    public void performTesting(String email, String name, String gender, String checkbox, String radio) {

        LoginPage loginPage = new LoginPage(driver);
        FormPage formPage = new FormPage(driver);

        loginPage.login(properties.getProperty("email"), properties.getProperty("password"));

        formPage.typeEmail(email);
        formPage.typeName(name);
        formPage.selectGender(gender);
        formPage.selectCheckbox(checkbox);
        formPage.selectRadio(radio);
        formPage.send();

        Assert.assertEquals(formPage.getEmailLogText(), email);
        Assert.assertEquals(formPage.getNameLogText(), name);
        Assert.assertEquals(formPage.getGenderLogText(), gender);
        Assert.assertEquals(formPage.getCheckboxLogText(), checkbox);
        Assert.assertEquals(formPage.getRadioLogText(), radio);
        Assert.assertTrue(formPage.alertDisplay());
    }
}
