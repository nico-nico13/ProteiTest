package protei.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

    @FindBy(xpath = "//input[@id='loginEmail']")
    private WebElement emailInput;
    @FindBy(xpath = "//input[@id='loginPassword']")
    private WebElement passwordInput;
    @FindBy(xpath = "//button[@id='authButton']")
    private WebElement authButton;
    @FindBy(xpath = "//div[@id='invalidEmailPassword']")
    private WebElement errorMessage;

    public LoginPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    public void login(String email, String password) {
        emailInput.sendKeys(email);
        passwordInput.sendKeys(password);
        authButton.click();
    }

    public boolean errorMessageDisplay(){
        return errorMessage.isDisplayed();
    }
}
