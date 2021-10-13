package stepdefinitions;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import manager.PageFactoryManager;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.*;


import static io.github.bonigarcia.wdm.WebDriverManager.chromedriver;

public class DefinitionSteps {

    private static final long DEFAULT_TIMEOUT = 60;
    WebDriver driver;
    HomePage homePage;
    SearchResultsPage searchResultsPage;
    SavedListsPage savedListsPage;
    ViewAllAccessoriesPage viewAllAccessoriesPage;
    PageFactoryManager pageFactoryManager;
    DeliveryAndReturnPage deliveryAndReturnPage;
    SignInPage signInPage;

    @Before
    public void testsSetUp() {
        chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        pageFactoryManager = new PageFactoryManager(driver);

    }

    @And("User opens {string} page")
    public void openPage(final String url) {
        homePage = pageFactoryManager.getHomePage();
        homePage.openHomePage(url);
    }


    @When("User clicks Sale button")
    public void userClicksSaleButton() {
        homePage.clickSaleButton();
    }


    @After
    public void tearDown() {
        driver.close();
    }


    @Then("User checks that appears necessary point {string}")
    public void userChecksThatAppearsNecessaryPointBestOfSale(final String pointName) {
        Assert.assertTrue(homePage.getFrameForAccessoriesButtonText().contains(pointName));
    }

    @Then("User checks that appears necessary point with {string}")
    public void userChecksThatAppearsNecessaryPointWithPointNnames(final String pointName) {
        Assert.assertTrue(homePage.getFrameForSaleButtonText().contains(pointName));
    }


    @When("User clicks Accessories button")
    public void userClicksAccessoriesButton() {
        homePage.clickAccessoriesButton();
    }


    @And("User chooses adidas Originals jacquard backpack in black product")
    public void userChoosesAdidasOriginalsJacquardBackpackInBlackProduct() {
        searchResultsPage = pageFactoryManager.getSearchResultPage();
        searchResultsPage.clickChooseJacquardBackPackProductButton();
    }

    @When("User clicks 'Save' button")
    public void userClicksSaveButton() {
        viewAllAccessoriesPage = pageFactoryManager.getViewAllAccessoriesPage();
        viewAllAccessoriesPage.clickJacquardBackPackProductSaveButton();
    }

    @And("User opens Saved lists page")
    public void userOpensSavedListsPage() {
        savedListsPage = pageFactoryManager.getSavedListsPage();
        homePage.clickSavedListsButton();
    }


    @Then("User checks that {string} is added to saved items")
    public void userChecksThatOriginalsJacquardBackpackInBlackProductIsAddedToSavedItems(final String savedProduct) {
        Assert.assertTrue(savedListsPage.getFLoadedItemsText().contains(savedProduct));
    }


    @When("User opens Delivery and return page")
    public void userOpensDeliveryAndReturnPage() {
        homePage.clickDeliveryAndReturnButton();
    }

    @And("User clicks 'Change' button")
    public void userClicksChangeButton() {
        deliveryAndReturnPage = pageFactoryManager.getDeliveryAndReturnPage();
        deliveryAndReturnPage.clickChangeDeliveryCountryButton();
    }

    @And("User clicks 'SearchCountry' field")
    public void userClicksSearchField() {
        deliveryAndReturnPage.clickSearchDeliveryCountryField();
    }

    @And("User makes search by keyword {string}")
    public void userMakesSearchByKeywordSpain(final String keywordDeliveryCountry) {
        deliveryAndReturnPage.enterCountryToSearchField(keywordDeliveryCountry);
    }

    @And("User selects Spain country for delivery")
    public void userSelectsSpainCountryForDelivery() {
        deliveryAndReturnPage.selectSpainAsCountryOfDelivery();
    }

    @Then("User checks that current url contains {string} country")
    public void userChecksThatCurrentUrlContainsEsCountry(final String deliveryCountry) {
        homePage.waitForPageLoadComplete(DEFAULT_TIMEOUT);
        Assert.assertTrue(driver.getCurrentUrl().contains(deliveryCountry));
    }

    @When("User clicks 'AccountButton'")
    public void userOpensAccountButton() {
        homePage.waitForPageLoadComplete(DEFAULT_TIMEOUT);
        homePage.clickAccountButton();
    }

    @And("User selects 'HomePage Sign In' button")
    public void userSelectsHomePageSignInButton() {
        homePage.clickHomePageSignInButton();
    }

    @And("User enters wrong {string} or wrong {string}")
    public void userEntersWrongLoginOrWrongPassword(final String login, final String password) {
        signInPage = pageFactoryManager.getSignInPage();
        signInPage.enterLogin(login);
        signInPage.enterPassword(password);
    }

    @And("User clicks 'Sign In' button")
    public void userClicksSignInButton() {
        signInPage.clickSignInButton();
    }

    @Then("User checks that 'Failure Massage' appears")
    public void userChecksThatFailureMassageAppears() {
        Assert.assertTrue(signInPage.isErrorBlockAppears());

    }

    @And("User checks search field visibility")
    public void userChecksSearchFieldVisibility() {
        homePage.waitForPageLoadComplete(DEFAULT_TIMEOUT);
        homePage.isSearchFieldAtHomePageVisible();
    }

    @And("User makes search at 'Home page' by keyword {string}")
    public void userMakesSearchAtHomePageByKeywordAdidas(final String keywordAdidas) {
        homePage.enterKeywordToSearchFieldAtHomePage(keywordAdidas);
    }

    @And("User puts first selected product to the shoping cart")
    public void userPutsFirstSelectedProductToTheShopingCart() {

        searchResultsPage.clickAddToShopingCartButton();
    }

    @And("User goes back to the search results page")
    public void userGoesBackToTheSearchResultsPage() {
        searchResultsPage.clickPreviousPage();
    }

    @And("User chouses adidas Originals jacquard mini backpack in black product")
    public void userChousesAdidasOriginalsJacquardMiniBackpackInBlackProduct() {
        searchResultsPage.clickChooseJacquardMiniBackPackProductButton();
    }

    @And("User puts second selected product to the shoping cart")
    public void userPutsSecondSelectedProductToTheShopingCart() {
        searchResultsPage.clickAddToShopingCartButton();
    }

    @Then("User checks that search result includes products containing {string}")
    public void userChecksThatSearchResultIncludesProductsContainingAdidas(final String checkAdidas) {
        searchResultsPage = pageFactoryManager.getSearchResultPage();
        Assert.assertTrue(searchResultsPage.getTextFirstProductAdidasSearch().contains(checkAdidas));
    }


    @Then("User checks that search result doesnt includes products containing {string}")
    public void userChecksThatSearchResultDoesntIncludesProductsContainingNike(final String checkNike) {
        searchResultsPage = pageFactoryManager.getSearchResultPage();
        Assert.assertFalse(searchResultsPage.getTextAdidasSearchResul().contains(checkNike));
    }

    @When("User clicks 'Shoping Cart' Button")
    public void userClicksShopingCartButton() {
        homePage.clickShopingCartButton();
    }

    @When("User clicks 'MEN' button")
    public void userClicksMENButton() {
        homePage.clickMenButton();
    }

    @Then("User checks that current url contains {string} version")
    public void userChecksThatCurrentUrlContainsMenVersion(final String menVersion) {
        homePage.waitForPageLoadComplete(DEFAULT_TIMEOUT);
        Assert.assertTrue(driver.getCurrentUrl().contains(menVersion));
    }

    @And("User enters correct {string} and correct {string}")
    public void userEntersCorrectLoginAndCorrectPassword(final String login, final String password) {
        signInPage = pageFactoryManager.getSignInPage();
        signInPage.enterLogin(login);
        signInPage.enterPassword(password);
    }

    @And("If needed User clicks 'I am not a robot' button")
    public void userClicksIAmNotARobotButton() {
        signInPage.clickIAmNotARobotButton();
        homePage.waitForPageLoadComplete(DEFAULT_TIMEOUT);
    }

    @Then("User checks that 'Account' field contains {string} User name")
    public void userChecksThatAccountFieldContainsVladyslavUserName(final String userName) {
        homePage.waitForPageLoadComplete(DEFAULT_TIMEOUT);
        Assert.assertTrue(homePage.getTextFromFrameForAccountButton().contains(userName));
    }

    @Then("User checks that 'Sign Out' button is displayed")
    public void userChecksThatSignOutButtonIsDisplayed() {
        Assert.assertTrue(homePage.signOutButtonIsDisplayed());
    }
}


