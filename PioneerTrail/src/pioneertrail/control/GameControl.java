/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pioneertrail.control;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import pioneertrail.PioneerTrail;
import pioneertrail.exceptions.GameControlException;
import pioneertrail.exceptions.MapControlException;
import pioneertrail.model.ActorEnum;
import pioneertrail.model.ActorObject;
import pioneertrail.model.Game;
import pioneertrail.model.InventoryItem;
import pioneertrail.model.InventoryItemEnum;
import pioneertrail.model.Location;
import pioneertrail.model.Map;
import pioneertrail.model.Player;
import pioneertrail.model.Purchase;
import pioneertrail.model.RegularScene;
import pioneertrail.model.ResourceScene;
import pioneertrail.model.Scene;
import pioneertrail.model.SceneType;
import pioneertrail.model.SicknessScene;
import pioneertrail.model.Tool;
import pioneertrail.model.Wagon;

/**
 *
 * @author tinkerc
 */
public class GameControl {

    public static Player savePlayer(String playersName) {
        if (playersName.length() < 1) {

            return null;
        }
        Player player = new Player();
        player.setName(playersName);
        PioneerTrail.setPlayer(player);
        return new Player();
    }

    public static int createNewGame(Player player) {
        if (player == null) {
            return -1;
        }
        Game game = new Game();
        game.setPlayer(player);

        //Create wagon model layer object and save the data to the game
        Wagon wagon = createWagon();
        game.setWagon(wagon);

        Purchase purchase = new Purchase();
        purchase.setMoney(100);

        game.setPurchase(purchase);

        //Create Actor array and save the data to the game
        ActorObject[] actors = createActors();
        game.setActors(actors);

        //Create Array List of Inventory Items and save the data to the wagon object
        ArrayList<InventoryItem> items = createItems();
        wagon.setItems(items);

        //Saving array
        ArrayList<InventoryItem> purchaseItems = createPurchase();
        purchase.setItems(purchaseItems);

        //Create Array List of Tools and save the data to the wagon object
        ArrayList<Tool> tools = createTools();
        wagon.setTools(tools);

        //THESE ARE FOR TESTING!! REMOVE WHEN GAME IS COMPLETED!!
        items = createItems();
        wagon.setItems(items);
        PioneerTrail.setCurrentGame(game);
        //END TESTING
        
        try {
            Map map = MapControl.createMap(5, 5, items);
            game.setMap(map);
            MapControl.movePlayerToStartingLocation(map);
        } catch (MapControlException mce) {
            System.out.println(mce.getMessage());
        }

        //This exists to set the items back to what they should be. 
        //Our attempt to add items to scenes didn't work. We need to figure out
        //a way to create a new item for every scene and then add the count of that
        //item to our overall count, and not actually add the item to the arraylist. 


        PioneerTrail.setCurrentGame(game);
        return 1;
    }

    public static void saveGame(Game game, String filePath)
            throws GameControlException {
        if (game == null) {
            throw new GameControlException("game is invalid");

        }
        if (filePath == null) {
            throw new GameControlException("filepath is empty");
        }
        try (ObjectOutputStream out
                = new ObjectOutputStream(new FileOutputStream(filePath))) {
            out.writeObject(game);

        } catch (IOException ex) {
            System.out.println("I/O Error: " + ex.getMessage());
        }
    }

    public static ActorObject[] createActors() {

        ActorObject[] actors = new ActorObject[5];

        ActorObject Father = new ActorObject();
        Father.setName("Kevin");
        Father.setGender("M");
        Father.setType("Adult");
        Father.setHealth(50);
        Father.setSickness("Broken Bone");
        Father.setStrength(100);
        actors[ActorEnum.Father.ordinal()] = Father;

        ActorObject Mother = new ActorObject();
        Mother.setName("Kannette");
        Mother.setGender("F");
        Mother.setType("Adult");
        Mother.setHealth(75);
        Mother.setSickness("Fatigue");
        Mother.setStrength(75);
        actors[ActorEnum.Mother.ordinal()] = Mother;

        ActorObject Child1 = new ActorObject();
        Child1.setName("Chris");
        Child1.setGender("M");
        Child1.setType("Child");
        Child1.setHealth(100);
        Child1.setSickness("Healthy");
        Child1.setStrength(50);
        actors[ActorEnum.Child1.ordinal()] = Child1;

        ActorObject Child2 = new ActorObject();
        Child2.setName("Thomas");
        Child2.setGender("M");
        Child2.setType("Child");
        Child2.setHealth(100);
        Child2.setSickness("Healthy");
        Child1.setStrength(55);
        actors[ActorEnum.Child2.ordinal()] = Child2;

        ActorObject Child3 = new ActorObject();
        Child3.setName("Lili");
        Child3.setGender("F");
        Child3.setType("Child");
        Child3.setHealth(100);
        Child3.setSickness("Healthy");
        Child1.setStrength(35);
        actors[ActorEnum.Child3.ordinal()] = Child3;

        return actors;
    }

    public static ArrayList<InventoryItem> createItems() {

//        InventoryItem[] itemsArray = new InventoryItem[5];
//        InventoryItem wood = new InventoryItem();
//        wood.setPrice(5);
//        wood.setDescription("Used to repair wagons");
//        wood.setCount(10);
//        wood.setWeight(10);
//        wood.setItemType("Wood");
//        itemsArray[InventoryItemEnum.Wood.ordinal()] = wood;
        InventoryItem item = new InventoryItem();
//
//        //item = new InventoryItem();
//        item.setPrice(5);
//        item.setDescription("food");
//        item.setCount(10);
//        item.setWeight(5);
//        item.setItemType("potatoes");
//        itemsArray[InventoryItemEnum.Potatoes.ordinal()] = item;
//
//        item = new InventoryItem();
//        item.setPrice(2);
//        item.setDescription("drink");
//        item.setCount(10);
//        item.setWeight(4);
//        item.setItemType("water");
//        itemsArray[InventoryItemEnum.Water.ordinal()] = item;
//
//        item = new InventoryItem();
//        item.setPrice(8);
//        item.setDescription("food");
//        item.setCount(10);
//        item.setWeight(6);
//        item.setItemType("Meat");
//        itemsArray[InventoryItemEnum.Meat.ordinal()] = item;
//
//        item = new InventoryItem();
//        item.setPrice(15);
//        item.setDescription("Medical Supplies");
//        item.setCount(10);
//        item.setWeight(6);
//        item.setItemType("Medical Supplies");
//        itemsArray[InventoryItemEnum.MedicalSupplies.ordinal()] = item;

        ArrayList<InventoryItem> items = new ArrayList<InventoryItem>();

        item.setPrice(5);
        item.setDescription("Used to repair wagons");
        item.setCount(25);
        item.setWeight(item.getCount() * 4);
        item.setItemType("Wood");
        items.add(InventoryItemEnum.Wood.ordinal(), item);

        item = new InventoryItem();
        item.setPrice(5);
        item.setDescription("food");
        item.setCount(10);
        item.setWeight(5);
        item.setItemType("Potatoes");
        items.add(InventoryItemEnum.Potatoes.ordinal(), item);

        item = new InventoryItem();
        item.setPrice(2);
        item.setDescription("drink");
        item.setCount(10);
        item.setWeight(4);
        item.setItemType("Water");
        items.add(InventoryItemEnum.Water.ordinal(), item);

        item = new InventoryItem();
        item.setPrice(8);
        item.setDescription("food");
        item.setCount(10);
        item.setWeight(6);
        item.setItemType("Meat");
        items.add(InventoryItemEnum.Meat.ordinal(), item);

        item = new InventoryItem();
        item.setPrice(15);
        item.setDescription("Medical Supplies");
        item.setCount(10);
        item.setWeight(6);
        item.setItemType("Medical Supplies");
        items.add(InventoryItemEnum.MedicalSupplies.ordinal(), item);
//        wagon.setItems(items);

        return items;
    }

    //Testing for purchase functions
    public static ArrayList<InventoryItem> createPurchase() {

        InventoryItem item = new InventoryItem();

        ArrayList<InventoryItem> purchaseItems = new ArrayList<InventoryItem>();

        item.setPrice(5);
        item.setDescription("Used to repair wagons");
        item.setCount(100);
        item.setWeight(item.getCount() * 4);
        item.setItemType("Wood");
        purchaseItems.add(InventoryItemEnum.Wood.ordinal(), item);

        item = new InventoryItem();
        item.setPrice(5);
        item.setDescription("food");
        item.setCount(100);
        item.setWeight(5);
        item.setItemType("potatoes");
        purchaseItems.add(InventoryItemEnum.Potatoes.ordinal(), item);

        item = new InventoryItem();
        item.setPrice(2);
        item.setDescription("drink");
        item.setCount(100);
        item.setWeight(4);
        item.setItemType("water");
        purchaseItems.add(InventoryItemEnum.Water.ordinal(), item);

        item = new InventoryItem();
        item.setPrice(8);
        item.setDescription("food");
        item.setCount(100);
        item.setWeight(6);
        item.setItemType("Meat");
        purchaseItems.add(InventoryItemEnum.Meat.ordinal(), item);

        item = new InventoryItem();
        item.setPrice(15);
        item.setDescription("Medical Supplies");
        item.setCount(100);
        item.setWeight(6);
        item.setItemType("Medical Supplies");
        purchaseItems.add(InventoryItemEnum.MedicalSupplies.ordinal(), item);
//      wagon.setItems(items);

        return purchaseItems;
    }

    public static ArrayList<Tool> createTools() {

        ArrayList<Tool> tools = new ArrayList<Tool>();
//        Game game = PioneerTrail.getCurrentGame();

        Tool tool = new Tool();
        tool.setDurability(80);
        tool.setMultiplier(2);
        tool.setToolType("Hammer");
        tools.add(0, tool);

        tool = new Tool();
        tool.setDurability(60);
        tool.setMultiplier(2);
        tool.setToolType("Gun");
        tools.add(1, tool);

        tool = new Tool();
        tool.setDurability(70);
        tool.setMultiplier(2);
        tool.setToolType("Axe");
        tools.add(2, tool);
//        wagon.setTools(tools);

        return tools;
    }

    public static Wagon createWagon() {

//        Game game = PioneerTrail.getCurrentGame();
        Wagon wagon = new Wagon();
        wagon.setHealth(80);
        wagon.setMaxHealth(100);
        wagon.setWeight(250);
//        game.setWagon(wagon);

        return wagon;
    }

    //purchase array
//    public static Purchase[] createPurchase() {
//
//        Purchase[] purchase = new Purchase[5];
//
//        Purchase Food = new Purchase();
//        Food.setPrice(.5);
//        Food.setType("food");
//        Food.setWeight(5);
//        Food.setCount(100);
//        Food.setDescription("Food for eating");
//        purchase[0] = Food;
//
//        Purchase Water = new Purchase();
//        Water.setPrice(.2);
//        Water.setType("water");
//        Water.setWeight(10);
//        Water.setCount(100);
//        Water.setDescription("Water for drinking");
//        purchase[1] = Water;
//
//        Purchase Wood = new Purchase();
//        Wood.setPrice(.5);
//        Wood.setType("wood");
//        Wood.setWeight(10);
//        Wood.setCount(100);
//        Wood.setDescription("Wood to repair the wagon and start fires");
//        purchase[2] = Wood;
//
//        Purchase Hammer = new Purchase();
//        Hammer.setPrice(1);
//        Hammer.setType("tool");
//        Hammer.setWeight(5);
//        Hammer.setCount(2);
//        Hammer.setDescription("Hammers are used to repair the wagon");
//        purchase[3] = Hammer;
//
//        Purchase Axe = new Purchase();
//        Axe.setPrice(1);
//        Axe.setType("tool");
//        Axe.setWeight(5);
//        Axe.setCount(2);
//        Axe.setDescription("Axes are used to chop and gather wood along the way");
//        purchase[4] = Axe;
//
//        return purchase;
//    }
    public static Game getGame(String filePath)
            throws GameControlException {
        if (filePath == null) {
            throw new GameControlException("file name is invalid");
        }

        try (FileInputStream in = new FileInputStream(filePath)) {
            ObjectInputStream input = new ObjectInputStream(in);
            try {
                Game game = (Game) input.readObject();
                PioneerTrail.setCurrentGame(game);
                Player player = game.getPlayer();
                PioneerTrail.setPlayer(player);
                return game;
            } catch (ClassNotFoundException ex) {
                System.out.println("Game class not found");
            }
        } catch (IOException ex) {
            System.out.println("I/O Error: " + ex.getMessage());

        }
        Game game = pioneertrail.PioneerTrail.getCurrentGame();
        return game;
    }
}
