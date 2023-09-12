package mol;

import jxl.write.DateTime;
import net.serenitybdd.core.annotations.findby.By;
import net.serenitybdd.core.pages.PageObject;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Set;

import static starter.stepdefinitions.Hooks.scenarioName;


public class Helpers extends PageObject {
    static long start;
    static long end;
    static long duration;

    public static void StartTimer()
    {
        start = System.currentTimeMillis();
    }
    public static void StopTimer()
    {
        Logger logger = LoggerFactory.getLogger("timer");
        end = System.currentTimeMillis();
        duration = end - start;
        logger.info("Scenario name: " + scenarioName+ " Duration in ms " + duration);
    }
    public static void StopTimer(String message)
    {
        Logger logger = LoggerFactory.getLogger("timer");
        end = System.currentTimeMillis();
        duration = end - start;
        logger.info(message +" Duration in ms " + duration);
    }



    public static String addTimestamp()
    {
        String timeStamp = new SimpleDateFormat("_yyyy_MM_dd_HH_mm_ss").format(new java.util.Date());
        return timeStamp;
    }
    public WebDriver switchToNewWindow(boolean closePrevious) {
        WebDriver newWindowDriver = null;
        String parentHandler = getDriver().getWindowHandle();
        if(closePrevious)
        {
            getDriver().switchTo().window(parentHandler).close();
        }
        Set<String> allHendlers = getDriver().getWindowHandles();
        for (String currentHandler : allHendlers) {
            newWindowDriver = getDriver().switchTo().window(currentHandler);
            if (!currentHandler.equals(parentHandler)) {
                break;
            }
        }

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

    public void setAttribute(WebElement element, String attName, String attValue) {
        JavascriptExecutor js = (JavascriptExecutor) getDriver();
        js.executeScript("arguments[0].setAttribute(arguments[1], arguments[2]);",
                element, attName, attValue);
    }
    public void scrollToElement(WebElement elem)
    {
        Actions action = new Actions(getDriver());
        action.scrollToElement(elem);

    }
    public void scrollToElementWithJavascript(WebElement elem)
    {
        ((JavascriptExecutor) getDriver()).executeScript("arguments[0].scrollIntoView(true);", elem);
        waitABit(500);
    }
    public static String todaysDate()
    {
        Date date = Calendar.getInstance().getTime();
        String pattern = "dd/MM/yyyy";
        DateFormat formatter= new SimpleDateFormat(pattern);
        String today = formatter.format(date);
        return today;
    }

    public void refreshAndWaitUntilElementNotVisible(String xpathOrCssSelector,int timeoutInSeconds)
    {
        if($$(xpathOrCssSelector).size()>0)
        {
            for(int i=0; i<timeoutInSeconds/5;i++)
            {
                waitABit(5000);
                getDriver().navigate().refresh();
                if($$(xpathOrCssSelector).size()<1)
                {
                    break;
                }

            }

        }
    }

}
