package org.vaadin.delayedbutton.it;

import com.vaadin.testbench.elements.ButtonElement;
import com.vaadin.testbench.elements.NotificationElement;
import org.junit.Test;
import static org.junit.Assert.*;
import org.vaadin.delayedbutton.BasicDelayedButtonUsageUI;

/**
 * A simple example that uses TestBench to do a browser level test for a
 * BasicDelayedButtonUsageUI. For more complex tests, consider using page object
 * pattern.
 */
public class BasicDelayedButtonUsageIT extends AbstractTestBenchTestCase {


    /** Construct with the right testing URL. 
     */    
    public BasicDelayedButtonUsageIT() {
        URL = URL + BasicDelayedButtonUsageUI.class.getName();
    }
    
    @Test
    public void testJavaScriptComponentWithBrowser() throws InterruptedException {
        
        // Reload the the test page
        reload();
        
        // Click the only button on in UI
        $(ButtonElement.class).first().click();

        if ($(NotificationElement.class).exists()) {
            fail("Click should not be possible yet.");
        }

        // Wait until the delay expires
        Thread.sleep(6000);
        
        // Click again
        $(ButtonElement.class).first().click();
        if (!$(NotificationElement.class).exists()) {
            fail("Click didn't work correctly.");
        }
    }
}
