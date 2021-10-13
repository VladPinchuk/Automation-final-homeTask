package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SearchResultsPage extends BasePage {

    @FindBy(xpath = "//a[contains(@aria-label,'adidas Originals jacquard backpack in black')]")
    private WebElement chooseJacquardBackPackProductButton;

    @FindBy(xpath = "//button[@id='product-add-button']")
    private WebElement addToShopingCartButton;

    @FindBy(xpath = "//a[contains(@aria-label,'adidas Originals jacquard mini backpack in black')]")
    private WebElement chooseJacquardMiniBackPackProductButton;

    @FindBy(xpath = "(//section[@data-auto-id=\"1\"])[1]")
    private WebElement firstProductAdidasSearchResult;

    @FindBy(xpath = "//section[@data-auto-id=\"1\"]")
    private WebElement adidasSearchResult;


    public SearchResultsPage(WebDriver driver) {
        super(driver);
    }

    public void clickChooseJacquardBackPackProductButton() {
        waitVisibility(chooseJacquardBackPackProductButton);
        chooseJacquardBackPackProductButton.click();
    }

    public void clickAddToShopingCartButton() {
        waitVisibility(addToShopingCartButton);
        addToShopingCartButton.click();
    }

    public void clickPreviousPage() {
        driver.navigate().back();
    }

    public void clickChooseJacquardMiniBackPackProductButton() {
        waitVisibility(chooseJacquardMiniBackPackProductButton);
        chooseJacquardBackPackProductButton.click();
    }

    public String getTextFirstProductAdidasSearch() {
        return firstProductAdidasSearchResult.getText();
    }

    public String getTextAdidasSearchResul() {
        return adidasSearchResult.getText();
    }
}