package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class DeliveryAndReturnPage extends BasePage {

    @FindBy(xpath = "//button[@class='dr-country-selector_button js-open-modal']")
    private WebElement changeDeliveryCountryButton;

    @FindBy(xpath = "//input[@class='dr-country-picker_input icon-search']")
    private WebElement searchDeliveryCountryField;

    @FindBy(xpath = "//a[@class='dr-country-picker_country es']")
    private WebElement selectSpainAsDeliveryCountry;

    public DeliveryAndReturnPage(WebDriver driver) {
        super(driver);
    }

    public void clickChangeDeliveryCountryButton() {
        waitVisibility(changeDeliveryCountryButton);
        changeDeliveryCountryButton.click();
    }

    public void clickSearchDeliveryCountryField() {
        waitVisibility(searchDeliveryCountryField);
        searchDeliveryCountryField.click();
    }

    public void enterCountryToSearchField(final String deliveryCountry) {
        searchDeliveryCountryField.sendKeys(deliveryCountry);
    }

    public void selectSpainAsCountryOfDelivery() {
        waitVisibility(selectSpainAsDeliveryCountry);
        selectSpainAsDeliveryCountry.click();
    }
}
