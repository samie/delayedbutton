package org.vaadin.delayedbutton;

import com.vaadin.ui.Component;
import com.vaadin.ui.Notification;
import org.vaadin.addonhelpers.AbstractTest;

/**
 * Add many of these with different configurations,
 * combine with different components, for regressions
 * and also make them dynamic if needed.
 */
public class BasicDelayedButtonUsageUI extends AbstractTest {

    @Override
    public Component getTestComponent() {
        DelayedButton btn = new DelayedButton("Click me", 5);
        btn.addClickListener(e -> {
            Notification.show("Click ok");
        });
        return btn;
    }

}
