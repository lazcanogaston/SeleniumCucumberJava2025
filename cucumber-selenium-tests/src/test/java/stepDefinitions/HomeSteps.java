package stepDefinitions;

import java.util.List;

import org.junit.Assert;
import org.openqa.selenium.WebElement;

import io.cucumber.java.en.Then;
import pageObjects.HomePage;

public class HomeSteps extends HomePage {

    LoginSteps loginSteps = new LoginSteps();
    
    @Then("Validate signs in with result: {string} and error message {string}") 
    public void validateSignIn(String expectedResult, String ExpectedErrorMessage){
        if(expectedResult.equalsIgnoreCase("Correct")){
            waitUntilPageIsLoaded(homePageUrl);
            Assert.assertTrue("Sign in failed.", true);
        }
        else{
            if(expectedResult.equalsIgnoreCase("emptyFields")){
                try{
                    String[] mensajes = ExpectedErrorMessage.split("/");
                    String expectedEmailEmptyError =  mensajes[0].trim();
                    String expectedPasswordEmptyError =  mensajes[1].trim();
                    List<WebElement> currentErrorMessages = findElements(loginSteps.signInErrorMessage);
                    if (!currentErrorMessages.isEmpty()){
                        String currentEmailError = loginSteps.getText(currentErrorMessages.get(0)).trim();
                        Assert.assertEquals("Error message is not the expected. Expected: "+expectedEmailEmptyError+ " and Current message: "+currentEmailError+"." , expectedEmailEmptyError, currentEmailError);
                        String currentPasswordError = loginSteps.getText(currentErrorMessages.get(1)).trim();
                        Assert.assertEquals("Error message is not the expected. Expected: "+expectedPasswordEmptyError+ " and Current message: "+currentPasswordError+"." , expectedPasswordEmptyError, currentPasswordError);
                    }
                    
                }
                catch(Exception e){
                    Assert.fail("Sign in error messages couldn't be retrieved.");
                }
            }
            else{
                try{
                    String currentError = loginSteps.getText(loginSteps.signInErrorMessage).trim();
                    Assert.assertEquals("Error message is not the expected. Expected: "+ExpectedErrorMessage+ " and Current message: "+currentError+"." , ExpectedErrorMessage, currentError);
                     
                }catch(Exception e){
                    Assert.fail("Sign in error message couldn't be retrieved.");
                }
            }
            
        }
              
        
    }
}
