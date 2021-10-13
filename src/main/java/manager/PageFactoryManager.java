package manager;

import org.openqa.selenium.WebDriver;
import pages.*;

public class PageFactoryManager {

    WebDriver driver;

    public PageFactoryManager(WebDriver driver) {
        this.driver = driver;
    }

    public HomePage getHomePage() {
        return new HomePage(driver);
    }

    public SearchResultsPage getSearchResultPage() {return new SearchResultsPage(driver);}

    public DeliveryAndReturnPage getDeliveryAndReturnPage() {return new DeliveryAndReturnPage(driver);}

    public SavedListsPage getSavedListsPage() {return new SavedListsPage(driver);}

    public SignInPage getSignInPage() {return new SignInPage(driver);}

    public ViewAllAccessoriesPage getViewAllAccessoriesPage() {return new ViewAllAccessoriesPage(driver);}
}
