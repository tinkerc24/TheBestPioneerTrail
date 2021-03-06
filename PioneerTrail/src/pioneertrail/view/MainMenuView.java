/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pioneertrail.view;

import java.util.Scanner;
import pioneertrail.PioneerTrail;
import pioneertrail.control.GameControl;
import pioneertrail.model.Game;
import pioneertrail.model.Player;

/**
 *
 * @author CamrenTinker
 */
class MainMenuView extends View {

    public MainMenuView() {
        super("**********"
                + "\nMain MENU"
                + "\n**********\n"
                + "N - Start new game\n"
                + "R - Restart existing game\n"
                + "H - Get help on how to play the game\n"
                + "E - Exit");
    }


    @Override
    public boolean doAction(String inputs) {

        String menuItem = inputs.toUpperCase();

        switch (menuItem) {
            case "N":
                startNewGame();
                break;
            case "R":
                restartGame();
                break;
            case "H":
                getHelp();
                break;
            case "E":
                return true;

            default:
                ErrorView.display(this.getClass().getName(), "Invalid menu item");

        }

        return false;
    }

    private void startNewGame() {
        Player player = PioneerTrail.getPlayer();
        GameControl.createNewGame(player);
        GameMenuView gameMenuView = new GameMenuView();
        gameMenuView.display();
    }

    private void restartGame() {
        StartExistingGameView startExistingGameView = new StartExistingGameView();
        startExistingGameView.display();
    }

    private void getHelp() {
        HelpMenuView helpMenuView = new HelpMenuView();
        helpMenuView.display();
    }

}
