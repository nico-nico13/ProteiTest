package protei.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class FormPage {

    @FindBy(xpath = "//input[@id='dataEmail']")
    private WebElement emailInput;
    @FindBy(xpath = "//input[@id='dataName']")
    private WebElement nameInput;
    @FindBy(xpath = "//select[@id='dataGender']")
    private WebElement genderSelect;
    @FindBy(xpath = "//input[@id='dataCheck11']")
    private WebElement checkbox1;
    @FindBy(xpath = "//input[@id='dataCheck12']")
    private WebElement checkbox2;
    @FindBy(xpath = "//input[@id='dataSelect21']")
    private WebElement radio1;
    @FindBy(xpath = "//input[@id='dataSelect22']")
    private WebElement radio2;
    @FindBy(xpath = "//input[@id='dataSelect23']")
    private WebElement radio3;
    @FindBy(xpath = "//button[@id='dataSend']")
    private WebElement sendButton;

    @FindBy(xpath = "//td[1]")
    private WebElement emailLog;
    @FindBy(xpath = "//td[2]")
    private WebElement nameLog;
    @FindBy(xpath = "//td[3]")
    private WebElement genderLog;
    @FindBy(xpath = "//td[4]")
    private WebElement checkboxLog;
    @FindBy(xpath = "//td[5]")
    private WebElement radioLog;

    @FindBy(xpath = "//div[@class='uk-modal-dialog']")
    private WebElement alert;
    @FindBy(xpath = "//div[@id='emailFormatError']")
    private WebElement emailError;
    @FindBy(xpath = "//div[@id='blankNameError']")
    private WebElement nameError;

    public FormPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    public void typeEmail(String email) { emailInput.sendKeys(email); }

    public void typeName(String name) {
        nameInput.sendKeys(name);
    }

    public void selectGender(String gender) {
        Select select = new Select(genderSelect);
        select.selectByVisibleText(gender);
    }

    public void selectCheckbox(String checkbox) {
        if (checkbox.equals("1.1")){
            checkbox1.click();
        } else if (checkbox.equals("1.2")){
            checkbox2.click();
        } else if (checkbox.equals("1.1, 1.2")){
            checkbox1.click();
            checkbox2.click();
        }
    }

    public void selectRadio(String radio) {
        if (radio.equals("2.1")) {
            radio1.click();
        } else if (radio.equals("2.2")) {
            radio2.click();
        } else if (radio.equals("2.3")) {
            radio3.click();
        }
    }

    public void send() {
        sendButton.click();
    }

    public String getEmailLogText() {
        return emailLog.getText();
    }

    public String getNameLogText() {
        return nameLog.getText();
    }

    public String getGenderLogText() {
        return genderLog.getText();
    }

    public String getCheckboxLogText() {
        return checkboxLog.getText();
    }

    public String getRadioLogText() {
        return radioLog.getText();
    }

    public boolean alertDisplay() {
        return alert.isDisplayed();
    }

    public boolean emailErrorDisplay() {
        return emailError.isDisplayed();
    }

    public boolean nameErrorDisplay() {
        return nameError.isDisplayed();
    }
}
