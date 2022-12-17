package starter.stepdefinitions;

import io.cucumber.java.en.Given;
import mol.Helpers;
import net.serenitybdd.core.environment.EnvironmentSpecificConfiguration;
import net.serenitybdd.core.pages.PageObject;
import net.thucydides.core.util.EnvironmentVariables;

public class HomeSteps extends PageObject {
    private EnvironmentVariables env;

    Helpers helpers = new Helpers();

    @Given("I open wiki page")
    public void iOpenWikiPage() {
        String baseUrl = EnvironmentSpecificConfiguration.from(env)
                .getProperty("webdriver.base.url");
        getDriver().navigate().to(baseUrl);
    }
}
