package mol;

import net.serenitybdd.core.webdriver.enhancers.BeforeAWebdriverScenario;
import net.thucydides.core.model.TestOutcome;
import net.thucydides.core.util.EnvironmentVariables;
import net.thucydides.core.webdriver.SupportedWebDriver;
import org.openqa.selenium.MutableCapabilities;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;

public class SeleniumBox implements BeforeAWebdriverScenario  {

    @Override
    public DesiredCapabilities apply(EnvironmentVariables environmentVariables, SupportedWebDriver driver, TestOutcome testOutcome, MutableCapabilities capabilities) {
        if(!environmentVariables.getProperty("environment").equalsIgnoreCase("default")) {
            capabilities.setCapability("browserName", "chrome");
            capabilities.setCapability("browserVersion", "107");
            capabilities.setCapability("e34:token", "tokenValue");
            capabilities.setCapability("e34:credential", "Master");
            ChromeOptions chromeOptions = new ChromeOptions();
            chromeOptions.addArguments("incognito");
            capabilities.setCapability(ChromeOptions.CAPABILITY,chromeOptions);
        }
        environmentVariables.setProperty("user","admin");

        // Once we have ReadOnly user we can start using this settings
        if(environmentVariables.getProperty("user").equalsIgnoreCase("read"))
        {
            System.out.println("***************************READ ONLY USER**********************************");
            capabilities.setCapability("e34:credential", "ReadOnly");
        }

        return (DesiredCapabilities) capabilities;
    }
}
