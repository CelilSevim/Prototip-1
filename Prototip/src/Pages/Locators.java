package Pages;

import org.openqa.selenium.By;

public interface Locators {


By singUpButtonLocator = By.cssSelector("ul#loginSignup li.jfHeader-menuListItem.hasSubMenu.signup-btn-wrapper > a");
By formFirstName = By.cssSelector("input#inputFirstName");
By formLastName = By.cssSelector("input#inputLastName");
By formEmail = By.cssSelector("input#inputEmail");
By formCountryLocator= By.cssSelector("div#containerNewUserSignup div.selected-dial-code");
By formCountryTRLocator= By.cssSelector("div#containerNewUserSignup li.country.active.highlight > span.country-name");

By formPhoneNumber = By.cssSelector("input#inputPhone");
By cityLocater = By.cssSelector("input#inputCity");
By ımnotrobotLocator = By.cssSelector("span#recaptcha-anchor > div.recaptcha-checkbox-border");
By registerButtonLocator = By.cssSelector("form#frmCheckout p > input");

}
