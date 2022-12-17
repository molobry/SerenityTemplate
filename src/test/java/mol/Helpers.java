package mol;

import net.serenitybdd.core.annotations.findby.By;
import net.serenitybdd.core.pages.PageObject;
import org.apache.commons.compress.harmony.unpack200.bytecode.forms.ThisInitMethodRefForm;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.text.SimpleDateFormat;
import java.util.Set;


public class Helpers extends PageObject {

    public static String addTimestamp()
    {
        String timeStamp = new SimpleDateFormat("_yyyy_MM_dd_HH_mm_ss").format(new java.util.Date());

        return timeStamp;
    }
    public WebDriver switchToNewWindow() {
        WebDriver newWindowDriver = null;
        String parentHandler = getDriver().getWindowHandle();
        Set<String> allHendlers = getDriver().getWindowHandles();
        for (String currentHandler : allHendlers) {
            newWindowDriver = getDriver().switchTo().window(currentHandler);
            if (!currentHandler.equals(parentHandler)) {
                break;
            }
        }
        //getDriver().switchTo().window(parentHandler).close();
        return newWindowDriver;
    }
    public WebDriver switchToNewWindowWithElement(String selector) {
        WebDriver newWindowDriver = null;
        String parentHandler = getDriver().getWindowHandle();
        Set<String> allHendlers = getDriver().getWindowHandles();
        for (String currentHandler : allHendlers) {
            newWindowDriver = getDriver().switchTo().window(currentHandler);
            waitABit(500);
            if (getDriver().findElements(By.xpath(selector)).size()>0) {
                break;
            }
        }
        return newWindowDriver;

    }

    public static WebElement clearInput(WebElement elem)
    {
        elem.sendKeys(Keys.CONTROL,"a");
        elem.sendKeys(Keys.DELETE);
        return elem;
    }



}
