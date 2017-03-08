/*
 * Copyright 2017 Vaadin Community.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.vaadin.delayedbutton.it;

import com.machinepublishers.jbrowserdriver.JBrowserDriver;
import com.machinepublishers.jbrowserdriver.RequestHeaders;
import com.machinepublishers.jbrowserdriver.Settings;
import com.machinepublishers.jbrowserdriver.UserAgent;
import com.vaadin.testbench.ScreenshotOnFailureRule;
import com.vaadin.testbench.TestBench;
import com.vaadin.testbench.TestBenchTestCase;
import org.eclipse.jetty.server.Server;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Rule;
import org.openqa.selenium.WebDriver;
import org.vaadin.addonhelpers.TServer;

/** Abstract helper class for testing with embedded server.
 * 
 * 
 * 
 * @author Sami Ekblad
 */
public abstract class AbstractTestBenchTestCase extends TestBenchTestCase {
    
    // host and port configuration for the URL
    protected static int PORT = 5678;
    protected static String URL = "http://localhost:" + PORT + "/";

    private static Server server;

    @BeforeClass
    public static void beforeAllTests() throws Exception {
        // Start the server
        server = new TServer().startServer(PORT);
    }

    @AfterClass
    public static void afterAllTests() throws Exception {
        // Stop the server
        server.stop();
    }

    @Rule
    public final ScreenshotOnFailureRule screenshotOnFailureRule = new ScreenshotOnFailureRule(this);

    @Before
    public void beforeTest() {
        setDriver(new JBrowserDriver(Settings.builder()
                .requestHeaders(RequestHeaders.CHROME)
                .userAgent(new UserAgent(
                        UserAgent.Family.WEBKIT,
                        "Google Inc.",
                        "Win32",
                        "Windows NT 6.1",
                        "5.0 (Windows NT 6.1; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/55.0.2869.0 Safari/537.36",
                        "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/55.0.2869.0 Safari/537.36"))
                .build()));
    }

    /**
     * Reloads the page. Depending on UI configuration this might re-init the UI
     * or keep the state.
     *
     */
    protected void reload() {
        getDriver().get(URL);
    }

}
