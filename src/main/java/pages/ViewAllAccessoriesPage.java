package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.concurrent.TimeUnit;

public class ViewAllAccessoriesPage extends BasePage {


    @FindBy(xpath = "//button[@class='save-button']")
    private WebElement jacquardBackPackProductSaveButton;


    public ViewAllAccessoriesPage(WebDriver driver) {
        super(driver);
    }


    public void clickJacquardBackPackProductSaveButton() {
        waitVisibility(jacquardBackPackProductSaveButton);
        jacquardBackPackProductSaveButton.click();
    }
}