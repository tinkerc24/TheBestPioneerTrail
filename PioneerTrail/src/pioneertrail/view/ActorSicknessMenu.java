/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pioneertrail.view;

import java.util.ArrayList;
import pioneertrail.PioneerTrail;
import pioneertrail.control.InventoryControl;
import pioneertrail.model.ActorObject;
import pioneertrail.model.Game;
import pioneertrail.model.InventoryItem;
import pioneertrail.model.Wagon;

/**
 *
 * @author tinkerc
 */
class ActorSicknessMenu extends View  {
    
    public ActorSicknessMenu(ActorObject actor) {
        displayMessage = buildMenu(actor);
    }
            
        private String buildMenu(ActorObject actor) {
        String input = "********************\n"
                + actor.getName() + " Sickness Menu"
                + "\n********************";

        Game game = PioneerTrail.getCurrentGame();
        Wagon wagon = game.getWagon();
        ArrayList<InventoryItem> items = new ArrayList<>();

        InventoryControl.listItemsAlphabetically(items);
        
        input += ("\n\nS - Make Splint"
                + "\tCost: 2 wood"
                + "\nR - Rest"
                + "\tCost: 2 units of food (potatoes or meat) and 1 water per person"
                + "\nM - Medical Supplies "
                + "\tCost: 1 unit of medical supplies"
                + "\nE - Exit");
        input += ("\nEnter the action you want to take");
        
        return input;
    }
        
    @Override
    public boolean doAction(String inputs) {

        String menuItem = inputs.toUpperCase();

        switch (menuItem) {
            case "S":
                createSplint();
                break;
            case "R":
                rest();
                break;
            case "M":
                medicalSupplies();
                break;
            case "E":
                //mainMenuView();
                return true;

            default:
                System.out.println("Invalid menu item");
        }
        return false;
    }

    private void createSplint() {
        CreateSplintView createSplintView = new CreateSplintView();
        createSplintView.displayResourceHelp();
    }

    private void rest() {
        System.out.println("Rest called");
    }

    private void medicalSupplies() {
        System.out.println("medicalSupplies called");
    }
}
