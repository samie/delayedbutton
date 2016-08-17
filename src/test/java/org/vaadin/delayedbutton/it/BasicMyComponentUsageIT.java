package org.vaadin.delayedbutton.it;

import java.util.concurrent.TimeUnit;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.vaadin.addonhelpers.automated.AbstractWebDriverCase;
import org.vaadin.addonhelpers.automated.VaadinConditions;
import static org.junit.Assert.*;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.vaadin.delayedbutton.BasicDelayedButtonUsageUI;

/**
 * A simple example that uses Selenium to do a browser level test for a
 * BasicMyComponentUsageUI. For more complex tests, consider using page object
 * pattern.
 */
public class BasicMyComponentUsageIT extends AbstractWebDriverCase {

    @Test
    public void testJavaScriptComponentWithBrowser() throws InterruptedException {

        startBrowser(new ChromeDriver());

        driver.navigate().to(BASEURL + BasicDelayedButtonUsageUI.class.getName());

        // Consider using Vaadin TestBench to make stuff easier
        new WebDriverWait(driver, 30).until(VaadinConditions.ajaxCallsCompleted());

        final WebElement el = driver.findElement(By.cssSelector(".v-button"));

        el.click();
        new WebDriverWait(driver, 30).until(VaadinConditions.ajaxCallsCompleted());

        try {
            final WebElement notif = driver.findElement(By.cssSelector(".v-Notification"));
            fail("Click should not be possible");
        } catch (NoSuchElementException e) {
        }

        // Just for demo purposes, keep the UI open for a while
        Thread.sleep(6000);

        el.click();

        new WebDriverWait(driver, 30).until(VaadinConditions.ajaxCallsCompleted());

        final WebElement notif = driver.findElement(By.cssSelector(".v-Notification"));

    }
}
