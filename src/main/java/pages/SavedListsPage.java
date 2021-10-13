package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SavedListsPage extends BasePage {


    @FindBy(xpath = "//div[@class='loadedItemsWrapper_s-Qdb']")
    private WebElement loadedItems;

    public SavedListsPage(WebDriver driver) {
        super(driver);
    }

    public String getFLoadedItemsText() {
        waitVisibility(loadedItems);
        return loadedItems.getText();
    }
}
