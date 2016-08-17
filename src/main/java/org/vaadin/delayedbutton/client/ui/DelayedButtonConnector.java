package org.vaadin.delayedbutton.client.ui;

import org.vaadin.delayedbutton.DelayedButton;

import com.google.gwt.core.client.GWT;
import com.google.gwt.user.client.ui.Widget;
import com.vaadin.client.communication.StateChangeEvent;
import com.vaadin.client.ui.button.ButtonConnector;
import com.vaadin.shared.ui.Connect;

@Connect(DelayedButton.class)
public class DelayedButtonConnector extends ButtonConnector {

    private static final long serialVersionUID = 3008795499402562824L;

    @Override
    public void onStateChanged(StateChangeEvent stateChangeEvent) {

        super.onStateChanged(stateChangeEvent);
        getWidget().setDelay(getState().getDelay());
    }

    @Override
    protected Widget createWidget() {
        return GWT.create(VDelayedButton.class);
    }

    @Override
    public VDelayedButton getWidget() {
        return (VDelayedButton)super.getWidget();
    }

    @Override
    public DelayedButtonState getState() {
        return (DelayedButtonState) super.getState();
    }
}
