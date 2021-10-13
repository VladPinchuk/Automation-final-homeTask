package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

public class SignInPage extends BasePage {

    @FindBy(xpath = "//input[@name='Username']")
    private WebElement emailField;

    @FindBy(xpath = "//input[@data-st-field='id-signIn-password']")
    private WebElement passwordField;

    @FindBy(xpath = "//input[@id='signin']")
    private WebElement signInButton;

    @FindBy(xpath = "//div[@class='error-block']")
    private WebElement errorBlock;

    @FindBy(xpath = "//input[@id='signin']")
    private WebElement iAmNotARobotButton;

    public SignInPage(WebDriver driver) {
        super(driver);
    }

    public void enterLogin(final String enterLogin) {
        waitVisibility(emailField);
        emailField.click();
        emailField.sendKeys(enterLogin);
    }

    public void enterPassword(final String enterPassword) {
        waitVisibility(passwordField);
        passwordField.sendKeys(enterPassword);
    }

    public void clickSignInButton() {
        waitVisibility(signInButton);
        signInButton.click();
    }

    public boolean isErrorBlockAppears() {
        return errorBlock.isDisplayed();
    }

    public void clickIAmNotARobotButton() {
        waitVisibility(iAmNotARobotButton);
        iAmNotARobotButton.click();
    }
}
