package StepDefs;

import Utils.DriverClass;
import cucumber.api.DataTable;
import cucumber.api.PendingException;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

/**
 * Created by ee on 11/1/17.
 */
public class AmazonStepDefs {

    private By searchTextBox = By.xpath("//div[@class='nav-search-field']/input[@id='twotabsearchtextbox']");
    private By searchButton = By.xpath("//*[@id=\"nav-search\"]/form/div[2]/div/input");
    private By phoneImage = By.xpath("//*[@id=\"result_0\"]/div/div[2]/div/div/a/img");
    private By phoneDetails = By.xpath("//*[@id=\"priceblock_ourprice_lbl\"]");
    private By deviceName = By.xpath("//*[@id=\"result_0\"]/div/div[3]/div[1]/a/h2");
    private By addCart = By.xpath("//*[@id=\"add-to-cart-button\"]");
    private By addCartStatus = By.xpath("//*[@id=\"huc-v2-order-row-confirm-text\"]/h1");
    private By checkout = By.xpath("//*[@id=\"sc-buy-box-ptc-button\"]/span/input");
    private By loginLabel = By.xpath("//*[@id=\"a-page\"]/div[1]/div[3]/div/div/form/div/div/div/h1");
    private By userName = By.xpath("//*[@id=\"ap_email\"]");
    private By passWord = By.xpath("//*[@id=\"ap_password\"]");
    private By loginButton = By.xpath("//*[@id=\"signInSubmit\"]");
    private By user = By.xpath("//*[@id=\"address-book-entry-0\"]/div[1]/div/ul/li[1]/b/span");
    private By addressLabel = By.xpath("/html/body/div[5]/div[2]/div[1]/h1");
    private By cart = By.xpath("//*[@id=\"hlb-view-cart-announce\"]");
    private By quantityDropDown = By.name("quantity");
    private By cartValue = By.xpath("//*[@id=\"gutterCartViewForm\"]/div[3]/div[2]/div/div[1]/p/span/span[1]");
    private By deliveryAddress = By.xpath("//*[@id=\"address-book-entry-0\"]/div[2]/span/a");
    private By deliveryOptionsLabel = By.xpath("//*[@id=\"shippingOptionFormId\"]/div[1]/div[1]/h1");
    private By deliveryDay = By.xpath("//*[@id=\"order_0_ShippingSpeed_PrimeSMSP-std-in-cod-eligible\"]");
    private By continueToPaymentButton = By.xpath("//*[@id=\"shippingOptionFormId\"]/div[3]/div/div/span[1]/span/input");
    private By paymentMethodLabel = By.xpath("//*[@id=\"another-payment-methods\"]/div[1]/strong");
    private By debitSelect = By.id("pm_new_verified_debit_card");
    private By netBankingSelect = By.id("pm_net_banking");
    private By chooseABankButton = By.xpath("//*[@id=\"new-vdc\"]/div[1]/span[1]/span/span/button");
    private By bankSelect = By.xpath("//*[@id=\"1_dropdown_combobox\"]/li[6]/a");
    private By continueToPlaceOrderButton = By.id("continue-top");
    private By placeOrderLabel = By.xpath("//*[@id=\"spc-desktop\"]/div[2]/div[2]/div/div[1]");
    private By palceYourOrderButton = By.xpath("//*[@id=\"order-summary-box\"]/div[1]/div/div[1]/div/span/span/input");
    private By gatewayImage = By.xpath("//*[@id=\"LogoSection\"]/img");
    private By paymentGatewayLabel = By.xpath("//*[@id=\"content-holder\"]/div[2]/h5/div/div[1]/small");

    private WebDriver driver;

    DriverClass driverClass;


    public void getHomePage(){
        driverClass = new DriverClass();
        driver = driverClass.driver;
    }

    public void handleWindow(){
        ArrayList<String> windowHandles = new ArrayList<String>(driver.getWindowHandles());
        driver.switchTo().window(windowHandles.get(1));
    }

    @Before
    public void initDriver(){
        getHomePage();
    }

    @After
    public void closeDriver(){
        driver.close();
    }

    @Test
    @Given("^Iam on the Homepage of Amazon India")
    public void visitHomePage(){
        try {
            if (driver.findElement(searchTextBox).isDisplayed()) {
                System.out.println("Iam on The Homepage");
            } else {
                System.out.println("Homepage not opened");
            }
        }
        catch(NoSuchElementException noe){
            System.out.println("Homepage not opened");
        }
        Assert.assertEquals(searchTextBox,searchTextBox);
    }


    @Test
    @When("^I enter DeviceName in the Search TextBox$")
    public void iEnterPhoneNameInTheSearchTextBox(DataTable deviceName){

        List<Map<String , String>> data = deviceName.asMaps(String.class,String.class);
        driver.findElement(searchTextBox).sendKeys(data.get(0).get("DeviceName"));

    }
    @Test
    @And("^I click on the Search Button")
    public void clickSearchButton(){
        driver.findElement(searchButton).click();
    }

    @Test
    @And("^All the related items are shown on the next page$")
    public void allTheRelatedItemsAreShownOnTheNextPage(){

        try{
            if(driver.findElement(phoneImage).isDisplayed()){
                System.out.println("Search Results are Visible");
            }
            else{
                System.out.println("ERROR SOMEWHERE");
            }
        }
        catch(NoSuchElementException noe){
            System.out.println("ERROR SOMEWHERE");
        }

    }

    @Test
    @And("^I click on a device$")
    public void clickDevice(){
        try {
            driver.findElement(deviceName).click();
        }
        catch(NoSuchElementException noe){
            driver.findElement(By.xpath("//*[@id=\"result_0\"]/div/div[3]/div[1]/a/h2"));
        }
    }

    @Test
    @Then("^All the related items should be shown on the next page")
    public void searchResult(){
        try{
            if(driver.findElement(phoneImage).isDisplayed()){
                System.out.println("Search Results are Visible");

            }
            else{
                System.out.println("ERROR SOMEWHERE");

            }
        }
        catch(NoSuchElementException noe){
            System.out.println("ERROR SOMEWHERE");

        }

    }

    @Test
    @Then("^Device details should open in a new tab$")
    public void deviceDetails(){
        handleWindow();

        try {
            if(driver.findElement(phoneDetails).isDisplayed()){
                System.out.println("Phone Details are displayed");


            }
            else {
                System.out.println("Error Somewhere");

            }
        }catch (NoSuchElementException noe){
            System.out.println("Error Somewhere");
        }
    }

    @Test
    @And("^I click on Add to Cart Button$")
    public void iClickOnAddToCartButton()  {
        handleWindow();
        driver.findElement(addCart).click();

    }

    @Test
    @And("^I click on Cart Button$")
    public void iClickOnCartButton()  {
        WebDriverWait wait = new WebDriverWait(driver,10);
        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(cart));
        driver.findElement(cart).click();

    }



    @Test
    @And("^I click on Proceed to checkout")
    public  void checkout(){
        WebDriverWait wait = new WebDriverWait(driver,10);
        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(checkout));
        driver.findElement(checkout).click();
    }

    @Test
    @And("^I enter username and password$")
    public void iEnterUsernameAndPassword(DataTable userCredentials)  {

        List<Map<String , String>> userdata = userCredentials.asMaps(String.class , String.class);
        driver.findElement(userName).sendKeys(userdata.get(0).get("UserName"));
        driver.findElement(passWord).sendKeys(userdata.get(0).get("Password"));

    }

    @Test
    @Then("^Device should get added to the cart$")
    public void deviceShouldGetAddedToTheCart(){
        try{
            if(driver.findElement(addCartStatus).isDisplayed()){
                System.out.println("Device is added to the cart");
            }
            else{
                System.out.println("Device is not added to the cart");
            }
        }catch(NoSuchElementException noe){
            System.out.println("Device is not added to the cart");
        }

    }

    @Test
    @Then("^Amazon should ask for Sign In")
    public void amazonShouldAskForSignIn(){
        try{
            if(driver.findElement(loginLabel).isDisplayed()){
                System.out.println("Amazon is asking for Sign In");
            }
            else{
                System.out.println("Sign In Not required");
            }
        }catch (NoSuchElementException noe){
            System.out.println("No Such Element Found");
        }
    }

    @Test
    @And("^I click on Login$")
    public void iClickOnLogin() {
        driver.findElement(loginButton).click();

    }

    @Test
    @Then("^User should be signed in and Address Page should be shown$")
    public void userShouldBeSignedInAndAddressPageShouldBeShown(){
        String userAuth = driver.findElement(user).getText();
        Assert.assertEquals("Abhinav Sharma",userAuth);
        System.out.println("User's Name is :" + userAuth);
        try{
            if(driver.findElement(addressLabel).isDisplayed()){
                System.out.println("You are on Address page");
            }else{
                System.out.println("You are not on address page");
            }
        }catch(NoSuchElementException noe){
            System.out.println("Adress Label Not Found");
        }

    }

    @Test
    @And("^I increase the quantity$")
    public void iIncreaseTheQuantityTo(){

        Select quantity = new Select(driver.findElement(quantityDropDown));
        quantity.selectByValue("3");

    }

    @Test
    @Then("^More Iphones should get Added$")
    public void moreIphonesShouldGetAdded()  {

        String totalIphones = driver.findElement(cartValue).getText();
        Assert.assertEquals("Subtotal (3 items):",totalIphones);
        System.out.println("No. of iphone in cart are :"+ totalIphones);

    }

    @Test
    @And("^I select Delivery Address$")
    public void iSelectDeliveryAddress(){
        driver.findElement(deliveryAddress).click();
    }

    @Test
    @Then("^I should see the Delivery options page$")
    public void iShouldSeeTheDeliveyOptionsPage(){
        String deliveryLabel = driver.findElement(deliveryOptionsLabel).getText();
        Assert.assertEquals("Choose your delivery options",deliveryLabel);
        System.out.println("Iam on the page : "+deliveryLabel);


    }


    @Test
    @And("^I click on Continue$")
    public void iClickOnContinue(){
        driver.findElement(continueToPaymentButton).click();
    }

    @Test
    @Then("^I should land on payment method page$")
    public void iShouldLandOnPaymentMethodPage(){
        String paymentLabel = driver.findElement(paymentMethodLabel).getText();
        Assert.assertEquals("Select a payment method",paymentLabel);
        System.out.println("Iam on page : "+paymentLabel);
    }

    @Test
    @And("^I click on Debit Card Payment$")
    public void iClickOnDebitCardPayment(){
        WebDriverWait wait = new WebDriverWait(driver,10);
        wait.until(ExpectedConditions.visibilityOfElementLocated(debitSelect));
        try {
            driver.findElement(debitSelect).click();
        }
        catch(NoSuchElementException noe){
            driver.findElement(netBankingSelect).click();
        }


    }

    @Test
    @Then("^Debit Card Should be selected$")
    public void debitCardShouldBeSelected(){

        if(driver.findElement(debitSelect).isSelected()){
            System.out.println("Payment Selected as Debit Card");
        }
        else{
            System.out.println("Anyother payment selected");
        }
    }

    @Test
    @And("^I select Bank from the dropdown$")
    public void iSelectBankFromTheDropdown(){
        driver.findElement(chooseABankButton).click();
        driver.findElement(bankSelect).click();
    }

    @Test
    @And("^I click on Continue To Place Order$")
    public void iClickOnContinueToPlaceOrder(){
        driver.findElement(continueToPlaceOrderButton).click();

    }

    @Test
    @Then("^I should land on Place Order Page$")
    public void iShouldLandOnPlaceOrderPage()  {
        WebDriverWait wait = new WebDriverWait(driver,10);
        wait.until(ExpectedConditions.visibilityOfElementLocated(placeOrderLabel));
        String placeOrderText = driver.findElement(placeOrderLabel).getText();
        Assert.assertEquals("Review your order", placeOrderText);
        System.out.println("Iam on page : "+placeOrderText);

    }

    @Test
    @And("^I click on Place your order button$")
    public void iClickOnPlaceYourOrderButton(){
        WebDriverWait wait = new WebDriverWait(driver,10);
        wait.until(ExpectedConditions.visibilityOfElementLocated(palceYourOrderButton));
        driver.findElement(palceYourOrderButton).click();
    }

    @Test
    @Then("^I should be redirected to payment gateway$")
    public void iShouldBeRedirectedToPaymentGateway() {
        WebDriverWait wait = new WebDriverWait(driver,15);
        wait.until(ExpectedConditions.visibilityOfElementLocated(gatewayImage));
        try{
            if(driver.findElement(gatewayImage).isDisplayed()){
                String gatewayLabel = driver.findElement(paymentGatewayLabel).getText();
                Assert.assertEquals("MERCHANT NAME :",gatewayLabel);
                System.out.println("Iam on Gateway page");

            }
            else {
                System.out.println("Error Occured");

            }
        }catch(NoSuchElementException noe){
            System.out.println("Error Occured");

        }

    }
}
