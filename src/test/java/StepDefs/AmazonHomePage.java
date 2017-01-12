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

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

/**
 * Created by ee on 11/1/17.
 */
public class AmazonHomePage {

    private By searchTextBox = By.xpath("//div[@class='nav-search-field']/input[@id='twotabsearchtextbox']");
    private By searchButton = By.xpath("//*[@id=\"nav-search\"]/form/div[2]/div/input");
    private By phoneImage = By.xpath("//*[@id=\"result_0\"]/div/div[2]/div/div/a/img");
    private By phoneDetails = By.xpath("//*[@id=\"priceblock_ourprice_lbl\"]");
    private By deviceName = By.xpath("//div[@class='a-row a-spacing-mini']/div[@class='a-row a-spacing-none']/a[@class='a-link-normal s-access-detail-page  a-text-normal']");
    private By addCart = By.xpath("//*[@id=\"add-to-cart-button\"]");
    private By addCartStatus = By.xpath("//*[@id=\"huc-v2-order-row-confirm-text\"]/h1");
    private By checkout = By.xpath("//*[@id=\"hlb-ptc-btn-native\"]");
    private By loginLabel = By.xpath("//*[@id=\"a-page\"]/div[1]/div[3]/div/div/form/div/div/div/h1");
    private By userName = By.xpath("//*[@id=\"ap_email\"]");
    private By passWord = By.xpath("//*[@id=\"ap_password\"]");
    private By loginButton = By.xpath("//*[@id=\"signInSubmit\"]");
    private By user = By.xpath("//*[@id=\"address-book-entry-0\"]/div[1]/div/ul/li[1]/b/span");
    private By addressLabel = By.xpath("/html/body/div[5]/div[2]/div[1]/h1");
    private By cart = By.xpath("//*[@id=\"hlb-view-cart-announce\"]");

    private By quantityDropDown = By.name("quantity");
    private By cartValue = By.xpath("//*[@id=\"nav-cart-count\"]");
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

    @Given("^Iam on the Homepage of Amazon India")
    public void visitHomePage() {
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
    }



    @When("^I enter DeviceName in the Search TextBox$")
    public void iEnterPhoneNameInTheSearchTextBox(DataTable deviceName){

        List<Map<String , String>> data = deviceName.asMaps(String.class,String.class);
        driver.findElement(searchTextBox).sendKeys(data.get(0).get("DeviceName"));

    }

    @And("^I click on the Search Button")
    public void clickSearchButton(){
        driver.findElement(searchButton).click();
    }

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

    @And("^I click on a device$")
    public void clickDevice(){
        driver.findElement(deviceName).click();
    }

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

    @And("^I click on Add to Cart Button$")
    public void iClickOnAddToCartButton()  {
        driver.findElement(addCart).click();

    }

    @And("^I click on Cart Button$")
    public void iClickOnCartButton()  {
        driver.findElement(cart).click();

    }



    @And("^I click on Proceed to checkout")
    public  void checkout(){
        driver.findElement(checkout).click();
    }

    @And("^I enter username and password$")
    public void iEnterUsernameAndPassword(DataTable userCredentials)  {

        List<Map<String , String>> userdata = userCredentials.asMaps(String.class , String.class);
        driver.findElement(userName).sendKeys(userdata.get(0).get("UserName"));
        driver.findElement(passWord).sendKeys(userdata.get(0).get("Password"));

    }

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

    @And("^I click on Login$")
    public void iClickOnLogin() {
        driver.findElement(loginButton).click();

    }

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

    @And("^I increase the quantity$")
    public void iIncreaseTheQuantityTo(){

        Select quantity = new Select(driver.findElement(quantityDropDown));
        quantity.selectByValue("3");

    }

    @Then("^More Iphones should get Added$")
    public void moreIphonesShouldGetAdded()  {
        String totalIphones = driver.findElement(cartValue).getText();
        Assert.assertEquals("3",totalIphones);
        System.out.println("No. of iphone in cart are :"+ totalIphones);

    }
}
