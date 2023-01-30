package StepDefs;

import Pages.Locators;
import Utils.ParentClass;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.Set;

public class LoginStepDefs extends ParentClass {

    String firstWin;

    @Given("Go to website")
    public void goToWebsite() {

        gotoSite("https://phptravels.com/demo/");

    }

    @And("Click sing up button")
    public void clickSingUpButton() {
        firstWin = driver.getWindowHandle();
        clickTo(Locators.singUpButtonLocator);
        Set<String> allwindow = driver.getWindowHandles();

        for (String window : allwindow) {
            driver.switchTo().window(window);
        }



    }

    @When("account from")
    public void accountFrom() {
        sendKeysTo(Locators.formFirstName,"celil");
        sendKeysTo(Locators.formLastName,"sevim");
        sendKeysTo(Locators.formEmail,"celilsvmm@gmail.com");
        clickTo(Locators.formCountryLocator);
        clickTo(Locators.formCountryTRLocator);
        sendKeysTo(Locators.formPhoneNumber,"5411472356");
        sendKeysTo(Locators.cityLocater,"istanbul");
        sleepTo(2000);

        scrollIntoView(driver.findElement(Locators.registerButtonLocator));
        WebElement frame = driver.findElement(By.xpath("//*[@id=\"#divDynamicRecaptcha1\"]/div/div/iframe"));
        driver.switchTo().frame(frame);
        clickTo(Locators.ımnotrobotLocator);
        //clickTo(driver.findElement(By.xpath("//*[@id=\"recaptcha-verify-button\"]")));
        //clickTo(Locators.ımnotrobotLocator);
        driver.switchTo().parentFrame();




    }

    @And("Click Register button")
    public void clickRegisterButton() {
        clickTo(Locators.registerButtonLocator);
    }

    @Then("verify account created")
    public void verifyAccountCreated() {

    }
}
