package org.vaadin.delayedbutton.unit;

import org.junit.Test;
import static org.junit.Assert.*;
import org.vaadin.delayedbutton.DelayedButton;

public class MyComponentUnitTest {

    @Test
    public void testMaxClickCount() {
        DelayedButton myComponent = new DelayedButton("Click me", 5);
    }
    
}
