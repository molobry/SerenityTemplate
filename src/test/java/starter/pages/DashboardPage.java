package starter.pages;

import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class DashboardPage extends PageObject {
    @FindBy(how = How.XPATH, using = "//h6[.='Dashboard']")
    public WebElementFacade dashboardTopLabel;
}
