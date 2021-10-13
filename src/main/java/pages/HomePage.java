package pages;

import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class HomePage extends BasePage {

    @FindBy(xpath = "//a[@id='men-floor']")
    private WebElement menButton;

    @FindBy(xpath = "//button[@data-id='57242f2c-d207-471c-95b1-31d6839df360']")
    private WebElement saleButton;

    @FindBy(xpath = "//div[@id='57242f2c-d207-471c-95b1-31d6839df360']")
    private WebElement frameForSaleButton;

    @FindBy(xpath = "//div[@id='415ffca1-8c1a-48a7-8997-9cc4929a7134']")
    private WebElement frameForAccessoriesButton;

    @FindBy(xpath = "//span[@class='_26lJ0fq -rhP1cz gBrrjX4 _2nHArcS']")
    private WebElement savedListsButton;

    @FindBy(xpath = "//button[@data-id='415ffca1-8c1a-48a7-8997-9cc4929a7134']")
    private WebElement accessoriesButtion;


    @FindBy(xpath = "//a[@class='_1OV98kg _3b2aD_j _3b2aD_j _20yDehE' and contains(@href,'delivery')]")
    private WebElement deliveryAndReturnButton;

    @FindBy(xpath = "//button[@class='_6iPIuvw _2SSHFPv']")
    private WebElement accountButton;

    @FindBy(xpath = "//button[@data-testid='signout-link']")
    private WebElement signOutButton;

    @FindBy(xpath = "//a[@data-testid='signin-link']")
    private WebElement homePageSignInButton;

    @FindBy(xpath = "//input[@id='chrome-search']")
    private WebElement searchFieldAtHomePage;

    @FindBy(xpath = "//span[@class='_1z5n7CN']")
    private WebElement shoppingCartButton;

    @FindBy(xpath = "//span[@class='_1M-cSy1' and contains(text(),'View Bag')]")
    private WebElement viewBagButton;

    @FindBy(xpath = "//div[@class='_3hSCfS2']")
    private WebElement frameForAccountButton;


    public HomePage(WebDriver driver) {
        super(driver);
    }

    public void openHomePage(String url) {
        driver.get(url);
    }


    public void clickMenButton(){
        waitVisibility(menButton);
        menButton.click();
    }

    public void clickSaleButton() {
        waitVisibility(saleButton);
        saleButton.click();
    }

    public String getFrameForSaleButtonText() {
        return frameForSaleButton.getText();
    }

    public String getFrameForAccessoriesButtonText() {
        return frameForAccessoriesButton.getText();
    }


    public void clickAccessoriesButton() {
        waitVisibility(accessoriesButtion);
        accessoriesButtion.click();
    }


    public void clickSavedListsButton() {
        waitVisibility(savedListsButton);
        savedListsButton.click();
    }

    public void clickDeliveryAndReturnButton() {
        waitVisibility(deliveryAndReturnButton);
        deliveryAndReturnButton.click();
    }

    public void clickAccountButton() {
        wait.until(ExpectedConditions.elementToBeClickable(accountButton));
        accountButton.click();
    }

    public void clickHomePageSignInButton() {
        waitVisibility(homePageSignInButton);
        homePageSignInButton.click();
    }

    public void isSearchFieldAtHomePageVisible() {
        searchFieldAtHomePage.isDisplayed();
    }

    public void enterKeywordToSearchFieldAtHomePage(final String adidasKeyword) {
        searchFieldAtHomePage.sendKeys(adidasKeyword);
        searchFieldAtHomePage.sendKeys(Keys.ENTER);
    }

    public void clickShopingCartButton() {
        waitVisibility(shoppingCartButton);
        shoppingCartButton.click();
    }

    public void clickViewBagButton(){
        waitVisibility(viewBagButton);
        viewBagButton.click();
    }


    public boolean signOutButtonIsDisplayed(){
        waitVisibility(signOutButton);
        return signOutButton.isDisplayed();
    }
    public String getTextFromFrameForAccountButton(){
        return frameForAccountButton.getText();
    }
}
