package com.projLDTS.blackjack.states;

import com.projLDTS.blackjack.controller.menu.ApplicationStateController;
import com.projLDTS.blackjack.gui.LanternaGUI;
import com.projLDTS.blackjack.gui.UserInput;

import java.awt.*;
import java.io.IOException;
import java.net.URISyntaxException;

public class HowToPlayMenuController implements StateController {
    private final ApplicationStateController applicationStateController;

    public HowToPlayMenuController(ApplicationStateController applicationStateController_) throws IOException, FontFormatException, URISyntaxException {
        applicationStateController = applicationStateController_;
    }

    @Override
    public void run() throws IOException, FontFormatException, URISyntaxException {
        while (true) {
            int aux = userInput();
            if (aux == 1 && getPage() == 3) {
                nextState();
                break;
            }
            else if (aux == 0 && getPage() == 0) {
                nextState();
                break;
            }
            else if (aux != -1) {
                setButtonSelected(aux);
                if (getPage() > 0 && getButtonSelected() == 0)
                    setPage(getPage() - 1);
                else if (getPage() < 3 && getButtonSelected() == 1)
                    setPage(getPage() + 1);
            }
            applicationStateController.redraw();
        }
    }

    public int getPage() {
        return applicationStateController.getStateViewer().getPage();
    }

    public void setPage(int i) {
        applicationStateController.getStateViewer().setPage(i);
    }

    @Override
    public void nextState() throws IOException, FontFormatException, URISyntaxException {
        applicationStateController.changeState(ApplicationState.MainMenu);
    }

    @Override
    public int getButtonSelected() {
        return applicationStateController.getButtonSelected();
    }

    @Override
    public void setButtonSelected(int i) {
        applicationStateController.setButtonSelected(i);
    }

    @Override
    public int userInput() throws IOException {
        return applicationStateController.userInput();
    }
}
