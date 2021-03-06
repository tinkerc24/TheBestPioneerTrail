/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pioneertrail.control;

import java.util.ArrayList;
import pioneertrail.exceptions.ToolControlException;
import pioneertrail.model.InventoryItem;
import pioneertrail.model.InventoryItemEnum;
import pioneertrail.model.Tool;
import pioneertrail.model.Wagon;

/**
 *
 * @author Tinkerc
 */
public class ToolControl {

    //Camren
    public static int repairWagon(InventoryItem item, Tool tool, Wagon wagon)
            throws ToolControlException {
        System.out.println(item.getItemType());
        if (item.getItemType() != "Wood") {
            throw new ToolControlException("Item type is not wood");
        }

        if (tool.getDurability() < 1) {
            throw new ToolControlException("Tool durability cannot be less than 1");
        }

        if (item.getCount() < 1) {
            throw new ToolControlException("Item count cannot be less than 1");
        }

        if (tool.getToolType() != "Hammer") {
            throw new ToolControlException("Tool type is not hammer");
        }

        if ((item.getCount() * tool.getMultiplier()) + wagon.getHealth() > wagon.getMaxHealth()) {
            wagon.setHealth(wagon.getMaxHealth());
            tool.setDurability(tool.getDurability() - item.getCount());
            return wagon.getHealth();
        }

        wagon.setHealth((item.getCount() * tool.getMultiplier()) + wagon.getHealth());
        tool.setDurability(tool.getDurability() - item.getCount());
        return wagon.getHealth();
    }

    //Danica
    public static double chopWood(InventoryItem item, Tool tool, Wagon wagon, double scrap)
            throws ToolControlException {

//pseudocode:
        // BEGIN
        //   IF (item.getCount < 1) THEN
        //        RETURN -1
        //
        //   IF (item.getWeight < 1) THEN
        //	      RETURN - 2 
        //
        //   IF (item.getCount > 15) THEN
        //        RETURN -3
        //
        //   IF (item.getWeight > 12) THEN
        //        RETURN -4   	
        //
        //   RETURN item.getCount * (item.getWeight – item.getWeight * scrap)
        // END 
        if (item.getCount() < 1) { //is item count 0 or negative?
            throw new ToolControlException("Item count cannot be less than 1");
        }

        if (item.getWeight() < 1) { //is item weight 0 or negative?
            throw new ToolControlException("Item weight cannot be less than 1");
        }

        if (item.getCount() > 15) { //is item count greater than 15?
            throw new ToolControlException("Item count cannot be greater than 15");
        }

        if (item.getWeight() > 12) { //is item weight greater than 12?
            throw new ToolControlException("Item weight cannot be greater than 12");
        }

        if (tool.getDurability() < 1) {
            throw new ToolControlException("Tool durability cannot be less than 1");
        }

        if (tool.getToolType() != "Axe") {
            throw new ToolControlException("Tool type must be Axe");
        }

        int weight = (int) item.getWeight();
        
        if (tool.getDurability() - (item.getCount() + weight) < 0) {
            throw new ToolControlException("Your axe durability is unable to chop that much. Enter lower numbers.");
        }
        
        tool.setDurability(tool.getDurability() - (item.getCount() + weight));
        //item.setCount(item.getCount() + item.getCount());
        ArrayList<InventoryItem> items = wagon.getItems();
        InventoryItem wood = items.get(InventoryItemEnum.Wood.ordinal());
        //int weight = (int) item.getWeight();
        //wood.setCount(wood.getCount() + item.getCount());
        
        double result = item.getCount() * (item.getWeight() - item.getWeight() * scrap);
        int roundedResult = (int) Math.round(result);
        wood.setCount(wood.getCount() + roundedResult);
        item.setWeight(result * 2);

        return roundedResult;
    }

    //Kathy
    public static double calcFoodHunt(InventoryItem food)
            throws ToolControlException {
        //Pseudocode:
        //BEGIN
        //IF (InventoryItem.getType == "Food") THEN
        //RETURN -1
        //IF (InventoryItem.getCount <1) THEN
        //RETURN -2
        //IF totalInventoryItem.getWeight + (inventoryItem.getWeight *   inventoryItem.getCount) > 200 THEN
        //RETURN -3
        //RETURN totalInventoryItem.getWeight + (inventoryItem.getWeight * inventoryItem.getCount)
        //END
        if (food.getItemType() != "Meat") {
            throw new ToolControlException("Item is not meat"); //if the item is something else than food
        }

        if (food.getCount() < 1) {
            throw new ToolControlException("Meat is less than 1"); // if food is less than 1
        }
        if ((food.getWeight() + (food.getWeight() * food.getCount())) > 200) {
            throw new ToolControlException("Meat is more than 200 lbs"); // food more than 200lbs
        }
        return (food.getWeight() + (food.getWeight() * food.getCount()));
    }

}
