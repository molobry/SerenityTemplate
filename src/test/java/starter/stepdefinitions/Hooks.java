package starter.stepdefinitions;

import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import net.serenitybdd.model.environment.EnvironmentSpecificConfiguration;
import net.thucydides.model.util.EnvironmentVariables;
import org.apache.commons.io.FilenameUtils;

public class Hooks {

    public static String scenarioName;
    public static String featureFullPath;
    public static String baseUrl;

    public static String username;

    public static String password;
    private EnvironmentVariables environmentVariables;

    @Before
    public void BeforeScenario(Scenario scenario) {
        System.out.println("--------------------BEFORE SCENARIO----------------------");
        scenarioName = scenario.getName();
        System.out.println("Scenario name is " + scenarioName);
        featureFullPath = FilenameUtils.getFullPath(scenario.getUri().toString());
        
        baseUrl = EnvironmentSpecificConfiguration.from(environmentVariables)
                .getProperty("webdriver.base.url");

        username = EnvironmentSpecificConfiguration.from(environmentVariables)
                .getProperty("username");

        password = EnvironmentSpecificConfiguration.from(environmentVariables)
                .getProperty("password");

        System.out.println("Username is " + username);
        System.out.println("Password is " + password);

    }
}
