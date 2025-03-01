package pageObjects;

import org.openqa.selenium.By;

public class PreSignInPage extends BasePage{
    protected By acceptCookiesBtn = By.xpath("//button[text()='I ACCEPT']");
    protected By loginNowLink = By.xpath("//span[contains(text(),'Login now')]");
    protected By continueEmailBtn = By.xpath("//span[contains(@class,'email-btn')]");

    public void acceptCookiesAndTerms(){
        if(isElementVisible(acceptCookiesBtn)){
            click(acceptCookiesBtn);
        }
        if(isElementVisible(acceptTermsBtn)){
            click(acceptTermsBtn);
        }
    }

    public void clickSignInLink(){
        if(isElementVisible(loginNowLink)){
            click(loginNowLink);
        }
    }

    public void signInByEmail(){
        if(isElementVisible(continueEmailBtn)){
            click(continueEmailBtn);
        }
    }
}
