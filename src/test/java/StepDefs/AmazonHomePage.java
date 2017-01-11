package StepDefs;

import Utils.DriverClass;
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

/**
 * Created by ee on 11/1/17.
 */
public class AmazonHomePage {

    private By searchTextBox = By.xpath("//div[@class='nav-search-field']/input[@id='twotabsearchtextbox']");
    private By searchButton = By.xpath("//div[@class='nav-search-submit nav-sprite']/span[@id='nav-search-submit-text']/input");
    private By phoneImage = By.xpath("//div[@class='a-row a-spacing-base']/div[2]/a/img");

    private WebDriver driver;
    DriverClass driverClass;
    public void getHomePage(){
        driverClass = new DriverClass();
        driver = driverClass.driver;
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

    @When("^I enter \"(.*)\" in the Search TextBox$")
    public void iEnterPhoneNameInTheSearchTextBox(String phoneName){
        driver.findElement(searchTextBox).sendKeys(phoneName);

    }



    @And("^I click on the Search Button")
    public void clickSearchButton(){
        driver.findElement(searchButton).click();
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
}
