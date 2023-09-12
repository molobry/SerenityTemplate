package starter.stepdefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import mol.Helpers;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.model.environment.EnvironmentSpecificConfiguration;
import net.thucydides.model.util.EnvironmentVariables;
import starter.pages.DashboardPage;
import starter.pages.HomePage;

import static starter.stepdefinitions.Hooks.*;

public class HomeSteps extends PageObject {
a
    HomePage homePage = new HomePage();
    DashboardPage dashboardPage = new DashboardPage();

    
    @Given("User navigate to OrangeHRM page")
    public void userNavigateToOrangeHRMPage() {
        getDriver().navigate().to(baseUrl);
        homePage.usernameInput.waitUntilVisible();
    }

    @And("User login with Admin credentials")
    public void userLoginWithAdminCredentials() {
        homePage.usernameInput.sendKeys(username);
        homePage.passwordInput.sendKeys(password);
        homePage.loginButton.click();
    }

    @Then("User is logged in and see Dashboard page")
    public void userIsLoggedInAndSeeDashboardPage() {
        dashboardPage.dashboardTopLabel.shouldBeVisible();
    }
}
