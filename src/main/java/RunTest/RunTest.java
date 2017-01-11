package RunTest; /**
 * Created by ee on 11/1/17.
 */
import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;
@RunWith(Cucumber.class)
@CucumberOptions(glue = {"/home/ee/Desktop/Abhinav/Amazon/src/test/java/StepDefs" },features = {"/home/ee/Desktop/Abhinav/Amazon/src/Feature/AmazonHomePage.feature"},format = {"pretty", "html:target/cucumber-html-report"}
)

public class RunTest {



}
