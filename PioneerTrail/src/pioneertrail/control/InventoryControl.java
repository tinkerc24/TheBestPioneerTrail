/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pioneertrail.control;

import java.util.ArrayList;
import java.util.Collections;
import pioneertrail.PioneerTrail;
import pioneertrail.model.ActorObject;
import pioneertrail.model.InventoryItem;
import pioneertrail.model.Wagon;

/**
 *
 * @author tinkerc
 */
public class InventoryControl {
    
    public static double calcNewWeight(InventoryItem InventoryItem, Wagon Wagon) {
        
//        BEGIN
//            IF (inventoryItem.getWeight < 1) THEN
//                RETURN -1
// 
//            IF (inventoryItem.getCount < 1) THEN
//                RETURN -2
//
//            IF wagon.getWeight +  (inventoryItem.getWeight * inventoryItem.getCount) > maxWeight THEN
//                RETURN -3
//            RETURN wagon.getWeight + (inventoryItem.getWeight * inventoryItem.getCount)
//        END 	

        if (InventoryItem.getWeight() < 1) {
            return -1;
        }
        
        if (InventoryItem.getCount() < 1) {
            return -2;
        }
        
        if (Wagon.getWeight() + (InventoryItem.getWeight() * InventoryItem.getCount()) > Wagon.getMaxWeight()) {
            return -3;
        }
        
        return Wagon.getWeight() + (InventoryItem.getWeight() * InventoryItem.getCount());
    }

    public static void listItems() {
        
        ArrayList<InventoryItem> items = PioneerTrail.getCurrentGame().getWagon().getItems();
        for (int i = 0; i < items.size(); i++ ) {
            InventoryItem item = items.get(i);
            System.out.println("\nItem: " + item.getItemType() +
                               "\nPrice: $" + item.getPrice() +
                               "\nQuantity: " + item.getCount() +
                               "\nWeight: " + item.getWeight() + " lbs" +
                               "\nDescription: " + item.getDescription());
        }
        return;
    }
    
    public static void listItemsAlphabetically(ArrayList<InventoryItem> items) {
        
        //ArrayList<InventoryItem> items = PioneerTrail.getCurrentGame().getWagon().getItems();
        
        //Sorting based on Actor Name
	   Collections.sort(items, InventoryItem.itemTypeComparator);

	   for(InventoryItem item: items){
			System.out.println("\nItem: " + item.getItemType() +
                               "\nQuantity: " + item.getCount() +
                               "\nWeight: " + item.getWeight() + " lbs" +
                               "\nDescription: " + item.getDescription());
	   }
    }
    
//    public int getPriceItems(int[] prices) {
//        
//        int total = 0;
//        
//        for (int price : prices ) {
//            total += price;
//            System.out.println("\nPrice: $" + prices.getPrice());
//        }
//        return total;
//    }
}
