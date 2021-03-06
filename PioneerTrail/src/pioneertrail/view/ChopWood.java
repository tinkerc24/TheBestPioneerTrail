/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pioneertrail.view;

//import java.util.Scanner;
import java.util.ArrayList;
import java.util.Scanner;
import pioneertrail.PioneerTrail;
import pioneertrail.control.ToolControl;
import pioneertrail.exceptions.ToolControlException;
import pioneertrail.model.Game;
import pioneertrail.model.InventoryItem;
import pioneertrail.model.Tool;
import pioneertrail.model.Wagon;

//import pioneertrail.PioneerTrail;
//import pioneertrail.control.ToolControl;
//import pioneertrail.model.Game;
//import pioneertrail.model.InventoryItem;
//import pioneertrail.model.Tool;
//import pioneertrail.model.Wagon;
//import pioneertrail.control.ToolControl;
/**
 *
 * @author Danica
 */
class ChopWood extends View {

    public ChopWood() {
        displayMessage = buildMenu();
    }

    private String buildMenu() {
        //ArrayList<InventoryItem> items = new ArrayList<InventoryItem>();
        //InventoryItem item = items.get(0);
        Game game = PioneerTrail.getCurrentGame();
        Wagon wagon = game.getWagon();
        Tool tool = wagon.getTools().get(2);
        InventoryItem item = wagon.getItems().get(0);
        double scrap = .5;

        String input = "\n***************"
                + "\nChop Wood MENU"
                + "\n***************"
                + "\nEnter Q to return to the previous menu."
                + "\n\nAxe durability is: " + tool.getDurability()
                + "\n\nEnter the number of trees you would like to chop (cannot be more than 15), "
                + "\nand enter the weight of wood you would like to chop (cannot be more than 12), "
                + "\nseperated by a comma. (Example: 5,4): ";
        return input;
    }

    @Override
    public boolean doAction(String inputs) {

        int amount;
        int weight;

        try {
            //amount = Integer.parseInt(inputs);
            String[] parts = inputs.split(",");
            amount = Integer.parseInt(parts[0].trim());
            weight = Integer.parseInt(parts[1].trim());
        } catch (Exception ex) {
            ErrorView.display(this.getClass().getName(), "\nInvalid input, please enter two numbers seperated by a comma.");
            return false;
        }

        Game game = PioneerTrail.getCurrentGame();
        Wagon wagon = game.getWagon();
        Tool tool = wagon.getTools().get(2);
        InventoryItem item = new InventoryItem();
        item.setCount(amount);
        item.setWeight(weight);
        double scrap = .5;
        double result;

        try {
            result = ToolControl.chopWood(item, tool, wagon, scrap);
        } catch (ToolControlException te) {
            ErrorView.display(this.getClass().getName(), te.getMessage());
            return false;
        }

        this.console.println("\nYou have chopped " + result + " logs of wood."); 
        
        ////displays weight:
        //       + " (" + item.getWeight() + " lbs of wood).");
        ////Other:
        // this.console.println("You now have " + item.getCount() + " wood.");
        

        if (tool.getDurability() < 1) {
            this.console.println("Axe has broken");
        } else {
            this.console.println("Axe durability is now " + tool.getDurability());
        }
        
        //wagon.setItems();

        return false;
    }
}
