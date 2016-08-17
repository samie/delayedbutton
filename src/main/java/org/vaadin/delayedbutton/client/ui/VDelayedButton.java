package org.vaadin.delayedbutton.client.ui;

import com.google.gwt.user.client.Timer;
import com.vaadin.client.ui.VButton;

public class VDelayedButton extends VButton {

    private Timer timer;
    private int currentTime;
    private String originalCaption;
    private boolean wasEnabled;

    /**
     * The constructor should first call super() to initialize the component and
     * then handle any initialization relevant to Vaadin.
     */
    public VDelayedButton() {
        super();
    }

    private void startDelay() {
        wasEnabled = super.isEnabled();
        super.setEnabled(false);
        originalCaption = captionElement.getInnerText();
    }

    protected void endDelay() {
        super.setEnabled(true);
        if (originalCaption != null) {
            captionElement.setInnerText(originalCaption);
            setEnabled(wasEnabled);
        }
    }

    private void updateCaption() {
        int c = currentTime / 1000;
        if (originalCaption != null) {
            captionElement.setInnerText(originalCaption + " (" + c + ")");
        }
    }

    public void setDelay(int delay) {

        if (delay > 0) {
            currentTime = delay * 1000;
            startDelay();
            updateCaption();
        } else {
            delay = 0;
        }

        // Cancel previous timer
        if (timer != null) {
            timer.cancel();
        }

        // If no delay is given stop here
        if (delay <= 0) {
            return;
        }

        // Create new timer
        timer = new Timer() {
            @Override
            public void run() {
                currentTime -= 1000;
                if (currentTime > 0) {
                    updateCaption();
                } else {
                    cancel();
                    endDelay();
                }
            }
        };
        timer.scheduleRepeating(1000);

    }

}
