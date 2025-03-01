package stepDefinitions;

import io.cucumber.java.en.Given;
import pageObjects.PreSignInPage;

public class PreSignInSteps extends PreSignInPage{
    private String loginUrl = "https://www.slot.com/en/landing";
    
    @Given("The user navigates to the login page")
    public void navigateToLogin(){
        navigateToPage(this.loginUrl);
        acceptCookiesAndTerms();
        signInByEmail();
        clickSignInLink();
    }
}
