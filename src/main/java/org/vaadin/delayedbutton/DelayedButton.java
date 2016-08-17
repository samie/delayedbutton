package org.vaadin.delayedbutton;

import org.vaadin.delayedbutton.client.ui.DelayedButtonState;

import com.vaadin.ui.Button;

/**
 * Button that is delayed for inactive for specified amount of seconds.
 *
 * This forces user to concentrate on the view content before clicking the
 * button.
 *
 * Server side component for the VDelayedButton widget.
 */
public class DelayedButton extends Button {

    private static final long serialVersionUID = 8658800951893182452L;

    /**
     * Creates new delayed button with caption. Default delay is 3 seconds.
     *
     * @param caption
     *            the Button caption
     */
    public DelayedButton(String caption) {
        super(caption);
        setDelay(3);
    }

    /**
     * Creates new delayed button with caption and delay delay
     *
     * @param caption
     *            the Button caption
     * @param delaySeconds
     *            Number of seconds as specified for {@link #setDelay(int)}
     */
    public DelayedButton(String caption, int delaySeconds) {
        super(caption);
        setDelay(delaySeconds);
    }

    /**
     * Creates a new delayed button with delay and click listener.
     *
     * @param caption
     *            the Button caption.
     * @param delaySeconds
     *            Number of seconds as specified for {@link #setDelay(int)}
     * @param listener
     *            the Button click listener.
     */
    public DelayedButton(String caption, int delaySeconds,
            ClickListener listener) {
        super(caption, listener);
        setDelay(delaySeconds);
    }

    /**
     * Set delay in seconds after which the button is enabled. Makes the button
     * inactive but does not affect the enabled-property.
     *
     * @param seconds
     *            Number of seconds. Zero or negative number disables the
     *            behaviour.
     * @see #setEnabled(boolean) 
     */
    public void setDelay(int seconds) {
        getState().setDelay(seconds > 0 ? seconds : 0);
        requestRepaint();
    }

    @Override
    public DelayedButtonState getState() {
        return (DelayedButtonState) super.getState();
    }
}
