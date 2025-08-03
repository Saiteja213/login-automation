package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.*;

public class LoginPage {
    WebDriver driver;

    @FindBy(id = "formEmail")
    private WebElement userIdField;


    @FindBy(id = "formPassword")
    private WebElement passwordField;


    @FindBy(tagName = "button")
    private WebElement loginButton;

    @FindBy(css = "img.passowrd-visible")
    private WebElement passwordToggle;

    @FindBy(css = "div.invalid-credential-div p.normal-text")
    private WebElement errorMsg;


    public LoginPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void enterUserId(String userId) {
        userIdField.clear();
        userIdField.sendKeys(userId);
    }

    public void enterPassword(String password) {
        passwordField.clear();
        passwordField.sendKeys(password);
    }

    public void clickLogin() {
        loginButton.click();
    }

    public boolean isLoginButtonEnabled() {
        return loginButton.isEnabled();
    }

    public boolean isPasswordMasked() {
        return passwordField.getAttribute("type").equals("password");
    }

    public void togglePasswordVisibility() {
        passwordToggle.click();
    }

    public String getErrorMessage() {
        try {
            return errorMsg.getText();
        } catch (org.openqa.selenium.NoSuchElementException e) {
            return "Error message not found";
        }
    }

    public boolean isLoginButtonDisplayed() {
        return loginButton.isDisplayed();
    }
    public boolean isUserIdFieldDisplayed() {
        return userIdField.isDisplayed();
    }

    public boolean isPasswordFieldDisplayed() {
        return passwordField.isDisplayed();
    }

    public boolean isPasswordToggleDisplayed() {
        return passwordToggle.isDisplayed();
    }

}

