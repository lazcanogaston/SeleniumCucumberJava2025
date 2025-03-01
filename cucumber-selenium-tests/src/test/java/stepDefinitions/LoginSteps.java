package stepDefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.When;
import pageObjects.LoginPage;

public class LoginSteps extends LoginPage{

    @When("The user populates the username field with value: {}")
    public void insertEmail(String email){
        inputEmail(email);
    }
    @And("The user populates the password field with value: {}")
    public void insertPassword(String password){
        inputPassword(password);
    }
    @And("The user clicks Login Button")
    public void clickSignInButton(){
        click(loginBtn);
    }
}
