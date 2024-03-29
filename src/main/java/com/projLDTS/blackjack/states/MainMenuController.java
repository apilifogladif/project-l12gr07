package com.projLDTS.blackjack.states;

import com.projLDTS.blackjack.controller.menu.ApplicationStateController;
import com.projLDTS.blackjack.controller.music.MusicManager;
import com.projLDTS.blackjack.controller.music.MusicOptions;

import java.awt.*;
import java.io.IOException;
import java.net.URISyntaxException;

public class MainMenuController implements StateController {
    private ApplicationStateController applicationStateController = null;

    public MainMenuController(ApplicationStateController applicationStateController_) {
        applicationStateController = applicationStateController_;
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
    public void run() throws IOException, FontFormatException, URISyntaxException {
        while (true) {
            int aux = userInput();
            if (aux == 3) {
                nextState();
                break;
            }
            else setButtonSelected(aux);
            applicationStateController.redraw();
        }
    }

    @Override
    public void nextState() throws IOException, FontFormatException, URISyntaxException {
        if (getButtonSelected() == 0) {
            MusicManager.getInstance().playMusicChoice(MusicOptions.OPTION_CLICK);
            applicationStateController.changeState(ApplicationState.StartMenu);
        }
        else if (getButtonSelected() == 1) {
            MusicManager.getInstance().playMusicChoice(MusicOptions.OPTION_CLICK);
            applicationStateController.changeState(ApplicationState.HowToPlay);
        }
        else if (getButtonSelected() == 2) {
            MusicManager.getInstance().playMusicChoice(MusicOptions.OPTION_CLICK);
            applicationStateController.changeState(ApplicationState.Exit);
        }
    }

    @Override
    public int userInput() throws IOException {
        return applicationStateController.userInput();
    }
}
