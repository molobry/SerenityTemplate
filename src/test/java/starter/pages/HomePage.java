package starter.pages;

import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class HomePage extends PageObject {

    @FindBy(how = How.ID_OR_NAME, using = "username")
    public WebElementFacade usernameInput;

    @FindBy(how = How.ID_OR_NAME, using = "password")
    public WebElementFacade passwordInput;

    @FindBy(how = How.XPATH, using = "//button[@type='submit']")
    public WebElementFacade loginButton;
}
