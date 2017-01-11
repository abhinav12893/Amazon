package Utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

/**
 * Created by ee on 11/1/17.
 */
public class DriverClass {

    public WebDriver driver = new ChromeDriver();
    public String baseUrl = "https://amazon.co.in";
    public DriverClass(){
        driver.get(baseUrl);
        driver.manage().window().maximize();
    }
}
