package stepDefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import steps.HomeSteps.*;

import static steps.HomeSteps.*;


public class HomeStepDefinitions {
    @Given("the user join the web page")
    public void the_user_join_the_web_page() {
        openUrl();
    }
    @When("the user complete the form")
    public void the_user_complete_the_form() {
        completeForms();
    }
    @Then("the data save correctly")
    public void the_data_save_correctly() {
        validateResults();
    }

}
