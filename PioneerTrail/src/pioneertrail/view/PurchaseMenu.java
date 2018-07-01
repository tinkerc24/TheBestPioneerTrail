/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pioneertrail.view;

import pioneertrail.model.InventoryItem;
import pioneertrail.model.Purchase;

/**
 *
 * @author Danica
 */
class PurchaseMenu extends View {

    public PurchaseMenu(InventoryItem item) {
        displayMessage = buildMenu(item);
    }

    private String buildMenu(InventoryItem item) {
        String input = "**************************\n"
                + item.getItemType() + " purchase menu"
                + "\n**************************\n\n"
                + item.getItemType()
                + " will be purchased here."
                + "\n\nQ - Return to Previous MENU";

        return input;
    }

    @Override
    public boolean doAction(String inputs) {

        String menuItem = inputs.toUpperCase();

        switch (menuItem) {
            case "E":
                //mainMenuView();
                return true;

            default:
                System.out.println("Invalid menu item");
        }
        return false;
    }
}
