package pageObjects;

import org.openqa.selenium.By;

public class LoginPage extends BasePage{
    
    protected By emailField = By.xpath("//input[@type='email']");
    protected By passwordField = By.xpath("//input[@formcontrolname='password']");
    protected By loginBtn = By.xpath("//span[contains(text(),'LOG IN')]");
    public By signInErrorMessage = By.xpath("//div[@class='error-text-input']");
    
    public void inputEmail(String email){
        if(email==null){
            sendText(emailField, "");
        }
        else{
            sendText(emailField, email);
        }
    }

    public void inputPassword(String password){
        if(password==null){
            sendText(passwordField, "");
        }
        else{
            sendText(passwordField, password);
        }
    }
}

